package com.gyxs.beans;

import java.util.HashSet;
import java.util.Set;

public class Node {
    private int index;
    private String name;
    private int param=1;
    private Functions function;
    private boolean isFinish;
    private Set<Node> parents;
    private Set<Node> childs;

    public Node(){
    }

    public Node(int index, String name) {
        this.index = index;
        this.name = name;
        childs=new HashSet<>();
        parents=new HashSet<>();
    }

    public void addChild(Node child){
        this.childs.add(child);
    }

    public void addParent(Node parent){
        parents.add(parent);
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
    }

    public boolean isFinish() {
        return isFinish;
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

    public Set<Node> getChilds() {
        return childs;
    }

    public Functions getFunction() {
        return function;
    }

    public void setFunction(Functions function) {
        this.function = function;
    }

    public int getParam() {
        return param;
    }

    public void setParam(int param) {
        this.param = param;
    }

    public Set<Node> getParents() {
        return parents;
    }

    public void setParents(Set<Node> parents) {
        this.parents = parents;
    }
}
