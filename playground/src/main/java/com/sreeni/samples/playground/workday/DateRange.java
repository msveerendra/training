package com.sreeni.samples.playground.workday;

public class DateRange<Type> implements Comparable<DateRange<Type>> {

	private long start;
	private long end;
	private Type data;

	public DateRange(long start, long end, Type data) {
		this.start = start;
		this.end = end;
		this.data = data;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}

	public Type getData() {
		return data;
	}

	public void setData(Type data) {
		this.data = data;
	}

	public boolean contains(long time) {
		return time < end && time > start;
	}

	public boolean intersects(DateRange<?> other) {
		return other.getEnd() > start && other.getStart() < end;
	}

	public int compareTo(DateRange<Type> other) {
		if (start < other.getStart())
			return -1;
		else if (start > other.getStart())
			return 1;
		else if (end < other.getEnd())
			return -1;
		else if (end > other.getEnd())
			return 1;
		else
			return 0;
	}

}
