package com.example.task05;

import java.util.*;
import java.util.function.Consumer;
public class MailService<T> implements Consumer<Sendable<T>> {
    private final Map<String, List<T>> mailBox = new HashMap<>();

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(Sendable<T> sendable) {
        List<T> list = mailBox.getOrDefault(sendable.getTo(), new ArrayList<>());
        list.add(sendable.getContent());
        mailBox.put(sendable.getTo(), list);
    }
}