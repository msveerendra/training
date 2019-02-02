package com.sreeni.samples.playground.workday;

import java.util.ArrayList;
import java.util.List;

public class DateRangeTree<Type>
{
 
    private DateRangeNode<Type>   head;
    private List<DateRange<Type>> dateRangeList;
    private boolean              inSync;
    private int                  size;
 
    public DateRangeTree()
    {
        this.head = new DateRangeNode<Type>();
        this.dateRangeList = new ArrayList<DateRange<Type>>();
        this.inSync = true;
        this.size = 0;
    }
 
    public DateRangeTree(List<DateRange<Type>> dateRangeList)
    {
        this.head = new DateRangeNode<Type>(dateRangeList);
        this.dateRangeList = new ArrayList<DateRange<Type>>();
        this.dateRangeList.addAll(dateRangeList);
        this.inSync = true;
        this.size = dateRangeList.size();
    }
 
    public List<Type> get(long time)
    {
        List<DateRange<Type>> dateRange = getDateRange(time);
        List<Type> result = new ArrayList<Type>();
        for (DateRange<Type> range : dateRange)
            result.add(range.getData());
        return result;
    }
 
    public List<DateRange<Type>> getDateRange(long time)
    {
        build();
        return head.range(time);
    }
 
    public List<Type> get(long start, long end)
    {
        List<DateRange<Type>> dateRange = getDateRange(start, end);
        List<Type> result = new ArrayList<Type>();
        for (DateRange<Type> range : dateRange)
            result.add(range.getData());
        return result;
    }
 
    public List<DateRange<Type>> getDateRange(long start, long end)
    {
        build();
        return head.query(new DateRange<Type>(start, end, null));
    }
 
    public void addDateRange(DateRange<Type> dateRange)
    {
        dateRangeList.add(dateRange);
        inSync = false;
    }
 
    public void addDateRange(long begin, long end, Type data)
    {
        dateRangeList.add(new DateRange<Type>(begin, end, data));
        inSync = false;
    }
 
    public boolean inSync()
    {
        return inSync;
    }
 
    public void build()
    {
        if (!inSync)
        {
            head = new DateRangeNode<Type>(dateRangeList);
            inSync = true;
            size = dateRangeList.size();
        }
    }
 
    public int currentSize()
    {
        return size;
    }
 
    public int listSize()
    {
        return dateRangeList.size();
    }
 
    @Override
    public String toString()
    {
        return nodeString(head, 0);
    }
 
    private String nodeString(DateRangeNode<Type> node, int level)
    {
        if (node == null)
            return "";
 
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < level; i++) {
            sb.append("\t");
        }
        sb.append(node + "\n");
        sb.append(nodeString(node.getLeft(), level + 1));
        sb.append(nodeString(node.getRight(), level + 1));
        return sb.toString();
    }
}