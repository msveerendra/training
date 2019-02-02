package com.sreeni.samples.playground.workday;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

public class DateRangeNode<Type> {

	private SortedMap<DateRange<Type>, List<DateRange<Type>>> dateRange;
	private long center;
	private DateRangeNode<Type> leftNode;
	private DateRangeNode<Type> rightNode;

	public DateRangeNode() {
		dateRange = new TreeMap<DateRange<Type>, List<DateRange<Type>>>();
		center = 0;
		leftNode = null;
		rightNode = null;
	}

	public DateRangeNode(List<DateRange<Type>> dateRangeList) {

		dateRange = new TreeMap<DateRange<Type>, List<DateRange<Type>>>();

		SortedSet<Long> endpoints = new TreeSet<Long>();

		for (DateRange<Type> dateRange : dateRangeList) {
			endpoints.add(dateRange.getStart());
			endpoints.add(dateRange.getEnd());
		}

		long median = getMedian(endpoints);
		center = median;

		List<DateRange<Type>> left = new ArrayList<DateRange<Type>>();
		List<DateRange<Type>> right = new ArrayList<DateRange<Type>>();

		for (DateRange<Type> range : dateRangeList) {
			if (range.getEnd() < median) {
				left.add(range);
			} else if (range.getStart() > median) {
				right.add(range);
			} else {
				List<DateRange<Type>> posting = dateRange.get(range);
				if (posting == null) {
					posting = new ArrayList<DateRange<Type>>();
					dateRange.put(range, posting);
				}
				posting.add(range);
			}
		}

		if (left.size() > 0)
			leftNode = new DateRangeNode<Type>(left);
		if (right.size() > 0)
			rightNode = new DateRangeNode<Type>(right);
	}

	public List<DateRange<Type>> range(long time) {
		List<DateRange<Type>> result = new ArrayList<DateRange<Type>>();

		for (Entry<DateRange<Type>, List<DateRange<Type>>> entry : dateRange.entrySet()) {
			if (entry.getKey().contains(time))
				for (DateRange<Type> dateRange : entry.getValue())
					result.add(dateRange);
			else if (entry.getKey().getStart() > time)
				break;
		}

		if (time < center && leftNode != null)
			result.addAll(leftNode.range(time));
		else if (time > center && rightNode != null)
			result.addAll(rightNode.range(time));
		return result;
	}

	public List<DateRange<Type>> query(DateRange<?> target) {
		List<DateRange<Type>> result = new ArrayList<DateRange<Type>>();

		for (Entry<DateRange<Type>, List<DateRange<Type>>> entry : dateRange.entrySet()) {
			if (entry.getKey().intersects(target))
				for (DateRange<Type> dateRange : entry.getValue())
					result.add(dateRange);
			else if (entry.getKey().getStart() > target.getEnd())
				break;
		}

		if (target.getStart() < center && leftNode != null)
			result.addAll(leftNode.query(target));
		if (target.getEnd() > center && rightNode != null)
			result.addAll(rightNode.query(target));
		return result;
	}

	public long getCenter() {
		return center;
	}

	public void setCenter(long center) {
		this.center = center;
	}

	public DateRangeNode<Type> getLeft() {
		return leftNode;
	}

	public void setLeft(DateRangeNode<Type> left) {
		this.leftNode = left;
	}

	public DateRangeNode<Type> getRight() {
		return rightNode;
	}

	public void setRight(DateRangeNode<Type> right) {
		this.rightNode = right;
	}

	private Long getMedian(SortedSet<Long> set) {
		int i = 0;
		int middle = set.size() / 2;
		for (Long point : set) {
			if (i == middle)
				return point;
			i++;
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(center + ": ");
		for (Entry<DateRange<Type>, List<DateRange<Type>>> entry : dateRange.entrySet()) {
			sb.append("[" + entry.getKey().getStart() + "," + entry.getKey().getEnd() + "]:{");
			for (DateRange<Type> dateRange : entry.getValue()) {
				sb.append("(" + dateRange.getStart() + "," + dateRange.getEnd() + "," + dateRange.getData() + ")");
			}
			sb.append("} ");
		}
		return sb.toString();
	}

}