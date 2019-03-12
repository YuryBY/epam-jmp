package com.epam.cdp.jmpd3.eventserviceapi;

import java.util.List;
import java.util.stream.Collectors;

public class MarkdownService {
    public void formatList(List<String> input){
        input.stream().collect(Collectors.joining("\n"));
    }
}
