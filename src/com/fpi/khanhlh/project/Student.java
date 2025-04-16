package com.fpi.khanhlh.project;

import java.io.Serializable;

public class Student implements Comparable<Student>, Serializable {
    private static final long serialVersionUID = 1L;

    protected String id;
    protected String name;
    protected String major;
    protected double score1;
    protected double score2;
    protected double score3;

    // Constructor
    public Student(String id, String name, String major, double score1, double score2, double score3) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public double getScore1() {
        return score1;
    }

    public double getScore2() {
        return score2;
    }

    public double getScore3() {
        return score3;
    }

    // Tính điểm trung bình
    public double getAverageScore() {
        double avg = (score1 + score2 + score3) / 3.0;
        return Math.round(avg * 10.0) / 10.0;
    }
    
    // Tính hạng dựa trên điểm trung bình
    public String getRank() {
        double avg = getAverageScore();  // Sử dụng getAverageScore() để lấy điểm trung bình
        if (avg < 5.0) return "Fail";
        else if (avg < 6.5) return "Medium";
        else if (avg < 7.5) return "Good";
        else if (avg < 9.0) return "Very Good";
        else return "Excellent";
    }

    // So sánh theo ID
    @Override
    public int compareTo(Student other) {
        return this.id.compareTo(other.id);
    }

    // Xuất thông tin ra dạng chuỗi
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Major: " + major + ", Average Score: " + getAverageScore();
    }
}
