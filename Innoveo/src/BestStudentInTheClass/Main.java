package BestStudentInTheClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        try {
            File file = new File("student_data.csv");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String parts[] = line.split(",");
                String name = parts[0];
                Double avgTest = Double.parseDouble(parts[1].trim());
                Double avgYear = Double.parseDouble(parts[2].trim());

                students.add(new Student(name, avgTest, avgYear));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Student bestStudent = students.get(0);

        for (Student student : students) {
            if (student.avgTest > bestStudent.avgTest) {
                bestStudent = student;
            }
        }

        System.out.println("Best Student is : " + bestStudent.name);
        System.err.println("Avg Test score : " + bestStudent.avgTest);
        System.err.println("Avg Yearly score : " + bestStudent.avgYear);
    }
}
