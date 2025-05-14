package com.example.liteflowdemo.context;

import java.util.ArrayList;
import java.util.List;

public class NumberCheckContext {
    private double inputNumber;
    private List<String> executionSteps = new ArrayList<>();
    private String finalResult;

    // Getters and Setters
    public double getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(double inputNumber) {
        this.inputNumber = inputNumber;
    }

    public List<String> getExecutionSteps() {
        return executionSteps;
    }

    public void addExecutionStep(String step) {
        this.executionSteps.add(step);
    }

    public String getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(String finalResult) {
        this.finalResult = finalResult;
    }
}