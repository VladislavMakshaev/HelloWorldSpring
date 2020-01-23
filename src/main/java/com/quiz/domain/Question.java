package com.quiz.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @Column(name = "id_question")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "name_question")
    private String name;

    @Column(name = "id_theme")
    private Integer id_theme;

    @Column(name = "id_difficult")
    private Integer id_difficult;

    public Integer getId_theme() {
        return id_theme;
    }

    public void setId_theme(Integer id_theme) {
        this.id_theme = id_theme;
    }

    public Integer getId_difficult() {
        return id_difficult;
    }

    public void setId_difficult(Integer id_difficult) {
        this.id_difficult = id_difficult;
    }

    public Question () {
    }

    public Question(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}