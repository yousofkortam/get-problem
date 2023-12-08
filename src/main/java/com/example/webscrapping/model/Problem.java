package com.example.webscrapping.model;

import java.util.List;

public class Problem {
    String title;
    String timePerTest;
    String memoryPerTest;
    String inputType;
    String outputType;
    String problemDescription;
    String inputSpecification;
    String outputSpecification;
    String note;
    List<String> tags;
    List<Sample> samples;

    public Problem() {}

    public Problem(String title, String timePerTest, String memoryPerTest, String inputType, String outputType, String problemDescription, String inputSpecification, String outputSpecification, String note, List<String> tags, List<Sample> samples) {
        this.title = title;
        this.timePerTest = timePerTest;
        this.memoryPerTest = memoryPerTest;
        this.inputType = inputType;
        this.outputType = outputType;
        this.problemDescription = problemDescription;
        this.inputSpecification = inputSpecification;
        this.outputSpecification = outputSpecification;
        this.note = note;
        this.tags = tags;
        this.samples = samples;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimePerTest() {
        return timePerTest;
    }

    public void setTimePerTest(String timePerTest) {
        this.timePerTest = timePerTest;
    }

    public String getMemoryPerTest() {
        return memoryPerTest;
    }

    public void setMemoryPerTest(String memoryPerTest) {
        this.memoryPerTest = memoryPerTest;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getOutputType() {
        return outputType;
    }

    public void setOutputType(String outputType) {
        this.outputType = outputType;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getInputSpecification() {
        return inputSpecification;
    }

    public void setInputSpecification(String inputSpecification) {
        this.inputSpecification = inputSpecification;
    }

    public String getOutputSpecification() {
        return outputSpecification;
    }

    public void setOutputSpecification(String outputSpecification) {
        this.outputSpecification = outputSpecification;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Sample> getSamples() {
        return samples;
    }

    public void setSamples(List<Sample> samples) {
        this.samples = samples;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "title='" + title + '\'' +
                ", timePerTest='" + timePerTest + '\'' +
                ", memoryPerTest='" + memoryPerTest + '\'' +
                ", inputType='" + inputType + '\'' +
                ", outputType='" + outputType + '\'' +
                ", problemDescription='" + problemDescription + '\'' +
                ", inputSpecification='" + inputSpecification + '\'' +
                ", outputSpecification='" + outputSpecification + '\'' +
                ", note='" + note + '\'' +
                ", tags=" + tags +
                ", samples=" + samples +
                '}';
    }
}
