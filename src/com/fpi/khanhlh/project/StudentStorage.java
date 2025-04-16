package com.fpi.khanhlh.project;

import java.util.List;

public interface StudentStorage {
    List<Student> load();
    void save(List<Student> students);
}


