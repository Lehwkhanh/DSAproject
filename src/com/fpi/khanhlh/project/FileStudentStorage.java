package com.fpi.khanhlh.project;
import java.io.*;
import java.util.*;

public class FileStudentStorage implements StudentStorage {
    private final String filename;

    public FileStudentStorage(String filename) {
        this.filename = filename;
    }

    @Override
    public List<Student> load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void save(List<Student> students) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


