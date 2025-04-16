
package com.fpi.khanhlh.project;

public class GDStudent extends Student {
    public GDStudent(String id, String name, double score1, double score2, double score3) {
        super(id, name, "Graphic Design", score1, score2, score3);
    }

    // Có thể thêm phương thức đặc thù nếu cần
    public double calculateDesignScore() {
        // Ví dụ: tính điểm cho ngành Thiết kế có thể khác biệt
        return getAverageScore() * 1.2; // Ví dụ: nhân điểm trung bình với 1.2
    }
}

