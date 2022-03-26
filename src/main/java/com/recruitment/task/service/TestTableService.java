package com.recruitment.task.service;

import com.recruitment.task.model.TestTable;
import com.recruitment.task.repository.TestTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestTableService {

    @Autowired
    private TestTableRepository testTableRepository;

    public List<TestTable> getTestTableList() {
        return testTableRepository.findAll();
    }
}
