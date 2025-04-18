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
        students = mergeSortByName(students);
        storage.save(students);
    }

    public void sortStudentsByScore() {
        students = mergeSortByScore(students);
        storage.save(students);
    }

    public void sortStudentsById() {
        students = mergeSortById(students);
        storage.save(students);
    }

    private void refreshSortedLists() {
        sortedById = mergeSortById(new ArrayList<>(students));
        sortedByName = mergeSortByName(new ArrayList<>(students));
    }

    public Student searchStudentById(String id) {
        return studentMap.get(id);
    }

    public Student searchStudentByName(String name) {
        refreshSortedLists();
        int left = 0;
        int right = sortedByName.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Student midStudent = sortedByName.get(mid);
            int cmp = midStudent.getName().compareTo(name);

            if (cmp == 0) {
                return midStudent;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
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

    // Merge sort helpers
    private List<Student> mergeSortByName(List<Student> list) {
        if (list.size() <= 1) return list;
        int mid = list.size() / 2;
        List<Student> left = mergeSortByName(list.subList(0, mid));
        List<Student> right = mergeSortByName(list.subList(mid, list.size()));
        return mergeByName(left, right);
    }

    private List<Student> mergeSortByScore(List<Student> list) {
        if (list.size() <= 1) return list;
        int mid = list.size() / 2;
        List<Student> left = mergeSortByScore(list.subList(0, mid));
        List<Student> right = mergeSortByScore(list.subList(mid, list.size()));
        return mergeByScore(left, right);
    }

    private List<Student> mergeSortById(List<Student> list) {
        if (list.size() <= 1) return list;
        int mid = list.size() / 2;
        List<Student> left = mergeSortById(list.subList(0, mid));
        List<Student> right = mergeSortById(list.subList(mid, list.size()));
        return mergeById(left, right);
    }

    private List<Student> mergeByName(List<Student> left, List<Student> right) {
        List<Student> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getName().compareTo(right.get(j).getName()) <= 0) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }
        result.addAll(left.subList(i, left.size()));
        result.addAll(right.subList(j, right.size()));
        return result;
    }

    private List<Student> mergeByScore(List<Student> left, List<Student> right) {
        List<Student> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getAverageScore() >= right.get(j).getAverageScore()) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }
        result.addAll(left.subList(i, left.size()));
        result.addAll(right.subList(j, right.size()));
        return result;
    }

    private List<Student> mergeById(List<Student> left, List<Student> right) {
        List<Student> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getId().compareTo(right.get(j).getId()) <= 0) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }
        result.addAll(left.subList(i, left.size()));
        result.addAll(right.subList(j, right.size()));
        return result;
    }
}