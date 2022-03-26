package com.recruitment.task.service;

import com.recruitment.task.model.TestTable;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TestTableService {

    @Autowired
    EntityManager entityManager;

    public TestTableLists getLists(String s) {

        boolean contains = Arrays.asList("kolumna1", "kolumna2", "kolumna3", "kolumna4").contains(s);

        String query = "SELECT * FROM tabela_testowa as t " +
                "JOIN (SELECT %s, COUNT(*) FROM tabela_testowa GROUP BY %s HAVING count(*) %s 1 ) as b " +
                "ON t.%s = b.%s ORDER BY t.id asc";

        return TestTableLists
                .builder()
                .duplicates(!contains ? new ArrayList<>() :
                        entityManager.createNativeQuery(String.format(query, s, s, ">", s, s), TestTable.class).getResultList())
                .uniques(!contains ? new ArrayList<>() :
                        entityManager.createNativeQuery(String.format(query, s, s, "=", s, s), TestTable.class).getResultList())
                .build();
    }

    @Data
    @Builder
    public static class TestTableLists {
        private List<TestTable> duplicates;
        private List<TestTable> uniques;
    }
}
