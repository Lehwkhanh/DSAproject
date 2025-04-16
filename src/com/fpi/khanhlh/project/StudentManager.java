package com.fpi.khanhlh.project;

import java.util.*;
import java.util.stream.Collectors;

public class StudentManager {
    private List<Student> students;
    private List<Student> sortedById;
    private List<Student> sortedByName;
    private Map<String, Student> studentMap;
    private StudentStorage storage;

    public StudentManager(StudentStorage storage) {
        if (storage == null) {
            throw new IllegalArgumentException("Storage cannot be null");
        }
        this.storage = storage;
        this.students = storage.load();
        initializeSortedAndMap();
    }

    public StudentManager(String filename) {
        this.storage = new FileStudentStorage(filename);
        this.students = storage.load();
        initializeSortedAndMap();
    }

    private void initializeSortedAndMap() {
        this.sortedById = new ArrayList<>(students);
        this.sortedByName = new ArrayList<>(students);
        this.studentMap = new HashMap<>();
        for (Student s : students) {
            studentMap.put(s.getId(), s);
        }
    }

    public void addStudent(Student student) {
        students.add(student);
        sortedById.add(student);
        sortedByName.add(student);
        studentMap.put(student.getId(), student);
        storage.save(students);
    }

    public void removeStudent(String studentId) {
        students.removeIf(s -> s.getId().equals(studentId));
        sortedById.removeIf(s -> s.getId().equals(studentId));
        sortedByName.removeIf(s -> s.getId().equals(studentId));
        studentMap.remove(studentId);
        storage.save(students);
    }

    public void sortStudentsByName() {
        students.sort(Comparator.comparing(Student::getName));
        storage.save(students);
    }

    public void sortStudentsByScore() {
        students.sort(Comparator.comparingDouble(Student::getAverageScore).reversed());
        storage.save(students);
    }

    public void sortStudentsById() {
        students.sort(Comparator.comparing(Student::getId));
        storage.save(students);
    }

    private void refreshSortedLists() {
        sortedById = new ArrayList<>(students);
        sortedByName = new ArrayList<>(students);
        sortedById.sort(Comparator.comparing(Student::getId));
        sortedByName.sort(Comparator.comparing(Student::getName));
    }

    public Student searchStudentById(String id) {
        return studentMap.get(id);
    }

    public Student searchStudentByName(String name) {
        refreshSortedLists();
        int index = Collections.binarySearch(
            sortedByName,
            new Student("", name, "", 0, 0, 0),
            Comparator.comparing(Student::getName)
        );
        return index >= 0 ? sortedByName.get(index) : null;
    }

    public List<Student> searchStudentsByName(String name) {
        refreshSortedLists();
        return sortedByName.stream()
                .filter(s -> s.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Student> searchStudentsById(String id) {
        return sortedById.stream()
                .filter(s -> s.getId().toLowerCase().contains(id.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Student> getStudents() {
        return students;
    }
}
