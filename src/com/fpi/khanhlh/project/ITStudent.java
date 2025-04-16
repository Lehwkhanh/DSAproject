
package com.fpi.khanhlh.project;

public class ITStudent extends Student {
    public ITStudent(String id, String name, double score1, double score2, double score3) {
        super(id, name, "Information Technology", score1, score2, score3);
    }

    public double calculateITScore() {
        return getAverageScore() * 1.1;
    }
}


