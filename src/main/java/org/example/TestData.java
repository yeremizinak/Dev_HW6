package org.example;

public class TestData {
    private int id;
    private String name;

    public TestData(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
