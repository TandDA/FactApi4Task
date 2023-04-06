package org.factapi.random.controller;

import org.factapi.random.utils.FileUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactController {

    FileUtil fileUtil = new FileUtil();

    @GetMapping("/api/v1/fact/random")
    public String getFact(){
        int count = fileUtil.getFactsCount();
        int factNum = (int)(Math.random() * ((count - 1) + 1)) + 1;


        return fileUtil.readFile(factNum);
    }
}
