package com.example.task05;

public class Salary implements Sendable<Integer> {
    private final String from;
    private final String to;
    private final int amount;

    public Salary(String from, String to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public Integer getContent() {
        return amount;
    }
}