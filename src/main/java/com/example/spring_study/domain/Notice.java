package com.example.spring_study.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter

public class Notice {
    @Id
    Integer id;

    String title;
    String content;
    String writer;


}
