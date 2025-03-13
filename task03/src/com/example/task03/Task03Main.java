package com.example.task03;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

import java.util.*;
import java.util.stream.Collectors;

public class Task03Main {

    public static void main(String[] args) {

        findMinMax(
                Stream.of(2, 9, 5, 4, 8, 1, 3),
                Integer::compareTo,
                (min, max) -> System.out.println("min: " + min + " / max: " + max)
        );

        findMinMax(
                Stream.empty(),
                Integer::compareTo,
                (min, max) -> System.out.println("min: " + min + " / max: " + max)
        );
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        Objects.requireNonNull(stream, "Stream null");
        Objects.requireNonNull(order, "Comparator null");
        Objects.requireNonNull(minMaxConsumer, "BiConsumer null");

        Optional<T> min = Optional.empty();
        Optional<T> max = Optional.empty();

        Iterator<? extends T> iterator = stream.iterator();

        if (!iterator.hasNext()) {
            minMaxConsumer.accept(null, null);
            return;
        }

        T first = iterator.next();
        min = Optional.of(first);
        max = Optional.of(first);

        while (iterator.hasNext()) {
            T current = iterator.next();

            if (current == null || (min.isPresent() && order.compare(current, min.get()) < 0)) {
                min = Optional.of(current);
            }

            if (current == null || (max.isPresent() && order.compare(current, max.get()) > 0)) {
                max = Optional.of(current);
            }
        }

        minMaxConsumer.accept(min.orElse(null), max.orElse(null));
    }
}
