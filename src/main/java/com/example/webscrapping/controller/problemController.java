package com.example.webscrapping.controller;

import com.example.webscrapping.model.Problem;
import com.example.webscrapping.model.Sample;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class problemController {

    final String problemSetUrl = "https://codeforces.com/problemset/problem";

    @GetMapping("/problem/{contestId}/{problemId}")
    public Problem getProblem(@PathVariable int contestId, @PathVariable char problemId) {
        try {
            final Document document = Jsoup.connect(problemSetUrl + "/" + contestId + "/" + problemId).get();
            var title = document.select(".header > .title").text().substring(3);
            var timeLimit = document.select(".header > .time-limit").text().substring(19, 20);
            var memoryLimit = document.select(".header > .memory-limit").text().substring(21, 24);
            var pageHtml = document.select(".problem-statement").outerHtml(); // all problem statement HTML that contains description, input, output, samples, and notes
            var inputFile = document.select(".header > .input-file").text().substring(5);
            var outputFile = document.select(".header > .output-file").text().substring(6);
            var inputSpecification = document.select(".input-specification > p").outerHtml();
            var outputSpecification = document.select(".output-specification > p").outerHtml();
            var problemStatement = document.select(".problem-statement > div").get(1).outerHtml();
            List<String> tags = document.select(".tag-box")
                    .stream()
                    .map(Element::text)
                    .collect(Collectors.toList());;
            // TODO
            List<Sample> allSamples = new ArrayList<>();
            var samples = document.select(".sample-test");
            for (var sample : samples) {
                var inputs = sample.select(".input > pre");
                var outputs = sample.select(".output > pre");
                for (int i = 0; i < inputs.size(); i++) {
                    Sample s = new Sample(inputs.get(i).text(), outputs.get(i).text());
                    allSamples.add(s);
                }
            }
            var note = document.select(".note").outerHtml();
            return new Problem(title, timeLimit, memoryLimit, inputFile, outputFile, problemStatement, inputSpecification, outputSpecification, note, tags, allSamples);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
