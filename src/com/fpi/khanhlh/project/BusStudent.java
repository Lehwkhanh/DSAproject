package com.fpi.khanhlh.project;

public class BusStudent extends Student {
    public BusStudent(String id, String name, double score1, double score2, double score3) {
        super(id, name, "Business", score1, score2, score3);
    }

    // Có thể thêm phương thức đặc thù nếu cần
    public double calculateEconomicsScore() {
        // Ví dụ: tính điểm cho ngành Kinh tế có thể khác biệt
        return getAverageScore() * 1.05; // Ví dụ: nhân điểm trung bình với 1.05
    }
}