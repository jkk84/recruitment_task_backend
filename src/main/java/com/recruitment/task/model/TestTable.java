package com.recruitment.task.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tabela_testowa")
public class TestTable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "kolumna1")
    private String column1;

    @Column(name = "kolumna2")
    private String column2;

    @Column(name = "kolumna3")
    private String column3;

    @Column(name = "kolumna4")
    private Long column4;
}
