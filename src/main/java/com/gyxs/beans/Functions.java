package com.gyxs.beans;

import com.gyxs.beans.FunctionInterface;

public enum Functions {
    function_01("过程",(a,b)->{  return a+b;}),
    function_02("决策",(a,b)->{return a-b;});
    public String type;
    public FunctionInterface function;
    private Functions(String type, FunctionInterface function){
        this.type=type;
        this.function=function;
    }
}
