package com.veeru.sample.playground.corejava;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FindRobotPath {
	
	
	public static ArrayList<Point> getPath (boolean[][] maze ){
		
		if(maze == null || maze.length == 0 ) {
			return null;
		}
		
		ArrayList<Point> paths = new ArrayList<Point>();
		Set<Point> failedPoints = new HashSet<Point>();
		
		if(getPath(maze,maze.length-1, maze[0].length-1, paths, failedPoints)) {
			return paths;
		}
		
		return null;
		
	}

	public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
		
		if ( row <0 || col <0 || !maze[row][col]) {
			return false;
		}
		
		boolean isOrgin = (row == 0) && (col ==0);
		
		if (isOrgin || getPath(maze, row-1,col, path) || getPath(maze, row,col-1, path) ) {
			path.add(new Point(row, col));
			return true;
		}
		
		
		return false;
		
	}
	
	// Memo
	public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, Set<Point> failedPoints) {
		
		if ( row <0 || col <0 || !maze[row][col]) {
			return false;
		}
		
		Point point = new Point(row, col);
		
		if(failedPoints.contains(point)) {
			return false;
		}
		
		boolean isOrgin = (row == 0) && (col ==0);
		
		if (isOrgin || getPath(maze, row-1,col, path) || getPath(maze, row,col-1, path) ) {
			path.add(point);
			return true;
		}
		
		failedPoints.add(point);
		
		return false;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Point{
	int row, col;
	public Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}