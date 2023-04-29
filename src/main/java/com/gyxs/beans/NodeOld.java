package com.gyxs.beans;

@Deprecated
public class NodeOld implements Comparable<NodeOld> {
    private int index;
    private String name;
    private Functions function;

    public NodeOld(int index, String name, Functions function) {
        this.index = index;
        this.name = name;
        this.function = function;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Functions getFunction() {
        return function;
    }

    public void setFunction(Functions function) {
        this.function = function;
    }

    @Override
    public int compareTo(NodeOld other) {
        return Integer.compare(this.index,other.index);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
