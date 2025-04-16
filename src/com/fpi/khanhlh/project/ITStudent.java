
package com.fpi.khanhlh.project;

public class ITStudent extends Student {
    public ITStudent(String id, String name, double score1, double score2, double score3) {
        super(id, name, "Information Technology", score1, score2, score3);
    }

    // Có thể thêm phương thức đặc thù nếu cần
    public double calculateITScore() {
        // Ví dụ: tính điểm cho ngành CNTT có thể khác biệt
        return getAverageScore() * 1.1; // Ví dụ: nhân điểm trung bình với 1.1
    }
}


