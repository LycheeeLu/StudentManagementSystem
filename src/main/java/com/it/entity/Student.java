package com.it.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Scanner;


/**
 * Created with IntelliJ IDEA.
 *
 * @Package : com.cunyu.entity
 * @ClassName : Student.java
 * @Description :
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    private String id;
    private String name;

    /**
     * which grade the student is in
     * not the grade/scores the student get
     */
    private String grade;
    private Double math;
    private Double english;
    private Double sport;
    private Double java;
    private Double algorithm;
    private Double policy;
    private Double cPlusPlus;
    private Double score;
    private Double average;
}
