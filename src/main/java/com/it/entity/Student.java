package com.it.entity;
import com.google.protobuf.ListValue;
import com.it.mapper.StudentMapper;
import com.it.util.MyBatisUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.session.SqlSession;


import java.util.List;
import java.util.Scanner;

import static com.sun.org.apache.xml.internal.utils.XMLChar.isValid;


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



    public void insertScore(){
        SqlSession sqlSession = MyBatisUtil.getSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Scanner scanner = new Scanner(System.in);
        System.out.println("--insert student data--");
        System.out.println("insert the following info: ");
        String id;
        while(true){
            System.out.print("id: ");
            id = scanner.nextLine();
            if(isValid(Integer.valueOf(id))){
                System.out.print("this id already exists! give a new one");
            } else {
                break;
            }
        }

        System.out.print("name: ");
        name = scanner.nextLine();

        System.out.print("grade: ");
         grade = scanner.nextLine();

        System.out.print("math: ");
        math = Double.valueOf(scanner.nextLine());

        System.out.print("english: ");
        english = Double.valueOf(scanner.nextLine());

        System.out.print("sport: ");
        sport = Double.valueOf(scanner.nextLine());

        System.out.print("java: ");
        java = Double.valueOf(scanner.nextLine());

        System.out.print("algorithm: ");
        algorithm = Double.valueOf(scanner.nextLine());

        System.out.print("policy: ");
        policy = Double.valueOf(scanner.nextLine());

        System.out.print("cPlusPlus: ");
        cPlusPlus = Double.valueOf(scanner.nextLine());

        System.out.print("score: ");
        score = Double.valueOf(scanner.nextLine());
        System.out.print("average: ");
        average = Double.valueOf(scanner.nextLine());


        //creating the student object and insert its info into sql database
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setGrade(grade);
        student.setMath(math);
        student.setEnglish(english);
        student.setSport(sport);
        student.setJava(java);
        student.setAlgorithm(algorithm);
        student.setPolicy(policy);
        student.setCPlusPlus(cPlusPlus);
        student.setScore(math + policy + english + algorithm + cPlusPlus + java + sport);
        student.setAverage(student.getScore() * 1.0 / 7);

        int i = studentMapper.insertScore(student);
        if (i > 0) {
            sqlSession.commit();
            System.out.println("student insert success!");
        } else {
            sqlSession.rollback();
            System.out.println("student insert fail!");
        }

        sqlSession.close();

    }

    public void queryScoreById() {
        try (SqlSession sqlSession = MyBatisUtil.getSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            Scanner scanner = new Scanner(System.in);
            System.out.print("--- search grade by student id ---\nStudent id: ");
            String id = scanner.nextLine();

            Student student = studentMapper.queryById(id);

            if (student != null) {
                System.out.println("Student found!");
                System.out.println("Student scores:");
                System.out.format("%s\t%s\t\t%s\t\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\n",
                        student.getId(), student.getGrade(), student.getName(),
                        student.getMath(), student.getEnglish(), student.getSport(),
                        student.getJava(), student.getCPlusPlus(), student.getPolicy(),
                        student.getAlgorithm(), student.getAverage(), student.getScore());
            } else {
                System.out.println("No such student.");
            }
        }
    }


    public void update() {
    System.out.println("--- update student ---");
    SqlSession sqlSession = MyBatisUtil.getSession();
    StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

    Scanner scanner = new Scanner(System.in);
    System.out.print("id: ");
    String id = scanner.nextLine();
    Student student = studentMapper.queryById(id);

    //what kind of simplified methods can i extract from here hmmms
    System.out.print("math: ");
    math = Double.valueOf(scanner.nextLine());
    System.out.print("english: ");
    english = Double.valueOf(scanner.nextLine());
    System.out.print("sport: ");
    sport = Double.valueOf(scanner.nextLine());
    System.out.print("java: ");
    java = Double.valueOf(scanner.nextLine());
    System.out.print("algorithm: ");
    algorithm = Double.valueOf(scanner.nextLine());
    System.out.print("policy: ");
    policy = Double.valueOf(scanner.nextLine());
    System.out.print("cPlusPlus: ");
    cPlusPlus = Double.valueOf(scanner.nextLine());

    student.setMath(math);
    student.setEnglish(english);
    student.setSport(sport);
    student.setJava(java);
    student.setAlgorithm(algorithm);
    student.setPolicy(policy);
    student.setCPlusPlus(cPlusPlus);
    student.setScore(sport + math + english + policy + java + cPlusPlus + algorithm);
    student.setAverage(student.getScore() / 7);

    if(studentMapper.updateById(student) > 0){
        sqlSession.commit();
        System.out.println("student update success!");
    } else {
        sqlSession.rollback();
        System.out.println("student update fail!");
    }
    }

    public void delete() {
        SqlSession sqlSession = MyBatisUtil.getSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Scanner scanner = new Scanner(System.in);
        System.out.print("id: ");
        String id = scanner.nextLine();
        int rowsAffected = studentMapper.deleteById(id);
        if(rowsAffected > 0){
            sqlSession.commit();
            System.out.println("student delete success!");
        } else {
            System.out.println("student delete fail!");
        }
            sqlSession.close();
    }

    public void queryScores(){
        SqlSession sqlSession = MyBatisUtil.getSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = studentMapper.showStudentList();
        if(students.isEmpty()){
            System.out.println("No scores found! please input scores first");
        } else {
            System.out.print("all student grade displayed: ");
            for(Student student : students){
                System.out.format("%s\t%s\t%s\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\n", student.getId(), student.getGrade(), student.getName(), student.getMath(), student.getEnglish(), student.getSport(), student.getJava(), student.getCPlusPlus(), student.getPolicy(), student.getAlgorithm(), student.getAverage(), student.getScore());
            }
        }
    sqlSession.close();
    }
}


