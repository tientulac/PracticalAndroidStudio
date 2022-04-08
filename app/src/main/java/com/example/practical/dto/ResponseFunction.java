package com.example.practical.dto;

import com.example.practical.entity.Function;

import java.util.List;

public class ResponseFunction {
    public List<Function> listFunctions;

    @Override
    public String toString() {
        return "ResponseFunction{" +
                "listFunctions=" + listFunctions +
                '}';
    }

    public List<Function> getListFunctions() {
        return listFunctions;
    }

    public void setListFunctions(List<Function> listFunctions) {
        this.listFunctions = listFunctions;
    }
}
