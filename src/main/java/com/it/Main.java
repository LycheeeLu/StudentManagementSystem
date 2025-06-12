package com.it;
import com.it.entity.Student;

import javax.sound.midi.SysexMessage;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Package : PACKAGE_NAME
 * @ClassName : Main.java
 * @Description :
 */
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true){
            System.out.println("---welcome to the student management system---");
            System.out.println("1. insert grade");
            System.out.println("2. search grade");
            System.out.println("3. update grade");
            System.out.println("4. delete grade");
            System.out.println("5. show all grades");
            System.out.println("6. exit");

            Student student = new Student();
            System.out.println("Enter your choice");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    student.insertScore();
                    break;
                case "2":
                    student.queryScoreById();
                    break;
                case "3":
                    student.update();
                    break;
                case "4":
                    student.delete();
                    break;
                case "5":
                    student.queryScores();
                    break;
                case "6":
                    System.exit(0);
                    break;
                default:
                    break;
            }

        }

    }
}