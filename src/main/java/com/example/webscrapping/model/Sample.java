package com.example.webscrapping.model;

public class Sample {
    String input;
    String output;

    public Sample() {}

    public Sample(String input, String output) {
        this.input = input;
        this.output = output;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "Sample{" +
                "input='" + input + '\'' +
                ", output='" + output + '\'' +
                '}';
    }
}
