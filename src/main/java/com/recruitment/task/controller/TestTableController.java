package com.recruitment.task.controller;

import com.recruitment.task.service.TestTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test-table")
public class TestTableController {

    @Autowired
    private TestTableService testTableService;

    @GetMapping("/get-lists")
    public TestTableService.TestTableLists getLists(@RequestParam String columnName) {
        return testTableService.getLists(columnName);
    }
}
