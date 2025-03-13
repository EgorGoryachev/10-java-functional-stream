package com.example.task05;

public interface Sendable<T> {
    String getTo();
    T getContent();
}