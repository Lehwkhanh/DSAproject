package com.fpi.khanhlh.project;

public class BusStudent extends Student {
    public BusStudent(String id, String name, double score1, double score2, double score3) {
        super(id, name, "Business", score1, score2, score3);
    }

    public double calculateEconomicsScore() {
        
        return getAverageScore() * 1.05;
    }
}