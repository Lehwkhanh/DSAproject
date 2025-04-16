
package com.fpi.khanhlh.project;

public class GDStudent extends Student {
    public GDStudent(String id, String name, double score1, double score2, double score3) {
        super(id, name, "Graphic Design", score1, score2, score3);
    }

    public double calculateDesignScore() {
        return getAverageScore() * 1.2;
    }
}

