package com.example.practical.entity;

public class Function {
    private int FunctionID;
    private String FunctionCode;
    private String FunctionName;

    public Function() {
    }

    public Function(int functionID, String functionCode, String functionName) {
        FunctionID = functionID;
        FunctionCode = functionCode;
        FunctionName = functionName;
    }

    @Override
    public String toString() {
        return "Function{" +
                "FunctionID=" + FunctionID +
                ", FunctionCode='" + FunctionCode + '\'' +
                ", FunctionName='" + FunctionName + '\'' +
                '}';
    }

    public int getFunctionID() {
        return FunctionID;
    }

    public void setFunctionID(int functionID) {
        FunctionID = functionID;
    }

    public String getFunctionCode() {
        return FunctionCode;
    }

    public void setFunctionCode(String functionCode) {
        FunctionCode = functionCode;
    }

    public String getFunctionName() {
        return FunctionName;
    }

    public void setFunctionName(String functionName) {
        FunctionName = functionName;
    }
}
