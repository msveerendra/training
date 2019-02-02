package com.veeru.sample.playground.sorting;

public class MatrixRotation {
	
	
	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][i];
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i] = temp;
			}
		}
	}
	
	public static void printMatrix(int[][] matrix) {

		for(int i=0; i< matrix.length; i++) {
			for(int j=0; j< matrix.length; j++) {
				System.out.print(matrix[i][j]+ "   " );
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = {
			    {1,  2,  3,  4},
			    {5,  6,  7,  8},
			    {9,  10, 11, 12},
			    {13, 14, 15, 16}
			   
			  };   
		
		printMatrix(matrix);
		System.out.println();
		System.out.println();
		rotate(matrix);
		printMatrix(matrix);

	}

}
