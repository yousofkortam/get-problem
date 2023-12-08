package com.example.webscrapping.controller;

import com.example.webscrapping.model.Problem;
import com.example.webscrapping.model.Sample;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class problemController {

    final String problemSetUrl = "https://codeforces.com/problemset/problem";

    public Problem getProblem(int contestId, char problemId) {
        try {
            final Document document = Jsoup.connect(problemSetUrl + "/" + contestId + "/" + problemId).get();
            var title = document.select(".header > .title").text().substring(3);
            var timeLimit = document.select(".header > .time-limit").text().substring(19);
            var memoryLimit = document.select(".header > .memory-limit").text().substring(21);
            // var pageHtml = document.select(".problem-statement").outerHtml(); // all problem statement HTML that contains description, input, output, samples, and notes
            var inputFile = document.select(".header > .input-file").text().substring(5);
            var outputFile = document.select(".header > .output-file").text().substring(6);
            var inputSpecification = document.select(".input-specification > p").outerHtml();
            var outputSpecification = document.select(".output-specification > p").outerHtml();
            var problemStatement = document.select(".problem-statement > div").get(1).outerHtml();
            List<String> tags = document.select(".tag-box")
                    .stream()
                    .map(Element::text)
                    .collect(Collectors.toList());
            // TODO
            List<Sample> allSamples = new ArrayList<>();
            var samples = document.select(".sample-tests > .sample-test");
            for (var sample : samples) {
                var inputs = sample.select(".input > pre");
                var outputs = sample.select(".output > pre");
                for (int i = 0; i < inputs.size(); i++) {
                    Sample s = new Sample(inputs.get(i).outerHtml(), outputs.get(i).outerHtml());
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

    @GetMapping("/problem/{contestId}/{problemId}")
    public String getProblemMvc(@PathVariable int contestId, @PathVariable char problemId, Model model) {
        Problem problem = getProblem(contestId, problemId);
        model.addAttribute("problem", problem);
        return "problem-details";
    }

}
