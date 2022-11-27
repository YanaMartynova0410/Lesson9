package Lessons9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Василий", Arrays.asList(new Course("Юридический"),
                new Course("Психология"),new Course("Социология"))));
        students.add(new Student("Анатолий", Arrays.asList(new Course("Юридический"),
                new Course("Журналистика"),new Course("Социология"))));
        students.add(new Student("Евгений", Arrays.asList(new Course("Юридический"),
                new Course("Журналистика"),new Course("Психология"))));
        students.add(new Student("Роман", Arrays.asList(new Course("Юридический"),
                new Course("Психология"))));
        System.out.println(students.stream()
                .map(s -> s.getCourses())
                .flatMap(c -> c.stream())
                .collect(Collectors.toSet()));

        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(3)
                .collect(Collectors.toList()));

        Course course = new Course("Testing");
        System.out.println(students.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList()));
    }
}
