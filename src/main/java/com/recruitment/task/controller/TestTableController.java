package com.recruitment.task.controller;

import com.recruitment.task.model.TestTable;
import com.recruitment.task.service.TestTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test-table")
public class TestTableController {

    @Autowired
    private TestTableService testTableService;

    @GetMapping
    public List<TestTable> getTestTableList() {
        return testTableService.getTestTableList();
    }
}
