package com.example;

import java.util.List;

public class Lion {
    private IFeline feline;
    private boolean hasMane;
    private String sex; // Добавлено поле sex

    public Lion(IFeline feline, String sex) throws Exception {
        this.feline = feline;
        this.sex = sex; // Инициализация поля sex
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используй допустимые значения пола животного - смец или самка");
        }
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }

    public String getSex() {
        return this.sex;
    }
}








