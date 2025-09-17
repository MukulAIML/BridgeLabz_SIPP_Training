
import java.util.*;
import java.util.stream.Collectors;

public class StudentResultGrouping {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", "Grade 10"),
            new Student("Bob", "Grade 10"),
            new Student("Charlie", "Grade 11"),
            new Student("David", "Grade 11"),
            new Student("Eve", "Grade 12")
        );

        Map<String, List<String>> groupedByGrade = students.stream()
            .collect(Collectors.groupingBy(Student::getGrade,
                    Collectors.mapping(Student::getName, Collectors.toList())));

        System.out.println(groupedByGrade);
    }
}

class Student {
    private String name;
    private String grade;

    public Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }
}
