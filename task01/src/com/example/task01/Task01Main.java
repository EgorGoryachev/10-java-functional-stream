package com.example.task01;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Task01Main {
    public static void main(String[] args) {


        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);


        System.out.println(safeStringLength.apply(null)); // 0
        System.out.println(safeStringLength.apply("Hello")); // 5
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse)
    {

        Objects.requireNonNull(condition, "Condition null");
        Objects.requireNonNull(ifTrue, "IfTrue null");
        Objects.requireNonNull(ifFalse, "IfFalse null");

        return t -> {
            if (condition.test(t)) {
                return ifTrue.apply(t);
            } else {
                return ifFalse.apply(t);
            }
        };
    }
}
