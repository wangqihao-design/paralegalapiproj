package com.paralegalapi.demo.domain;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter

public class Passage {
    private String title;
    private String content;
    private int arguedDate;
    private int determinedDate;
}
