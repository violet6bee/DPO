package labs.lab1;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Student {
    private String name;
    private int group;
    private int course;
    private HashMap<String, ArrayList<Integer>> grades;

    public Student(String name, int group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new HashMap<>();
    }

    public void addGrades(String subject, ArrayList<Integer> subjectGrades){
        grades.put(subject, subjectGrades);
    }

    public int avgGrades(){
        Collection<ArrayList<Integer>> allGrades = grades.values();
        int sumGrade = 0;
        int count = 0;
        for (ArrayList<Integer> subjectGrades: allGrades) {
            for (int grade: subjectGrades) {
                sumGrade += grade;
                count++;
            }
        }
        return sumGrade/count;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }
}
