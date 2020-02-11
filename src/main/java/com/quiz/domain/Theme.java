package com.quiz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "theme")
public class Theme implements Serializable {
    @Id
    @Column(name = "id_theme")
    private Integer id_theme;

    @Column(name = "name_theme")
    private String name_theme;

    public Theme() {
    }

    public String getName_theme() {
        return name_theme;
    }

    public void setName_theme(String name_theme) {
        this.name_theme = name_theme;
    }

    public Integer getId_theme() {
        return id_theme;
    }

    public void setId_theme(Integer id_theme) {
        this.id_theme = id_theme;
    }

}
