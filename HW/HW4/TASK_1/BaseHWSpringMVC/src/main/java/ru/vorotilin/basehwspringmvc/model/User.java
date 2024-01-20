package ru.vorotilin.basehwspringmvc.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String fname;
    private String sname;
}
