package com.test.algorithm.dynaprogram;

public class MObject {
    String name;
    int weight;
    int price;

    public MObject(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public MObject() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
