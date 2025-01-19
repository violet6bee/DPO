package labs.lab1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Masha", 21101, 3));
        students.add(new Student("Dasha", 21201, 2));
        students.add(new Student("Sasha", 21201, 1));
        students.add(new Student("Pasha", 21101, 1)); //не должен перейти на второй курс

        students.get(0).addGrades("Chemistry", new ArrayList<>(Arrays.asList(4, 5, 3, 4)));
        students.get(0).addGrades("Math", new ArrayList<>(Arrays.asList(4, 5, 3, 5)));
        students.get(0).addGrades("Physics", new ArrayList<>(Arrays.asList(4, 5, 3, 3)));
        students.get(1).addGrades("Chemistry", new ArrayList<>(Arrays.asList(4, 4, 4, 5)));
        students.get(1).addGrades("Math", new ArrayList<>(Arrays.asList(4, 5, 4, 4)));
        students.get(1).addGrades("Physics", new ArrayList<>(Arrays.asList(4, 5, 4, 4)));
        students.get(2).addGrades("Chemistry", new ArrayList<>(Arrays.asList(5, 5, 5, 5)));
        students.get(2).addGrades("Math", new ArrayList<>(Arrays.asList(5, 5, 5, 5)));
        students.get(2).addGrades("Physics", new ArrayList<>(Arrays.asList(5, 5, 5, 5)));
        students.get(3).addGrades("Chemistry", new ArrayList<>(Arrays.asList(2, 2, 3, 3)));
        students.get(3).addGrades("Math", new ArrayList<>(Arrays.asList(3, 2, 2, 3)));
        students.get(3).addGrades("Physics", new ArrayList<>(Arrays.asList(2, 2, 2, 3)));

        System.out.println("Количество студентов в начале года: " + students.size());
        deleteStudent(students);
        System.out.println("Количество студентов, которые перейдут на следующий год: " + students.size());
        nextCourse(students);
        printStudents(students, 1);
    }

    private static void deleteStudent(ArrayList<Student> students){
        ArrayList<Student> deleteStudents = new ArrayList<>();
        for (Student student :students) {
            if (student.avgGrades() < 3) {
                deleteStudents.add(student);
            }
        }
        for (Student student: deleteStudents) {
            students.remove(student);
        }
    }

    private static void nextCourse(ArrayList<Student> students){
        for (Student student :students) {
            if (student.avgGrades() >= 3) {
                student.setCourse(student.getCourse() + 1);
            } else {
                System.out.println("Отчислен");
            }
        }
    }

    private static void printStudents(List<Student> students, int course) {
        for (Student student :students) {
            if (student.getCourse() == course){
                System.out.println( student.getName());
            }
        }
    }
}
