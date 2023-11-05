package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int NUMBER_COUNTER = 6;
    static final int START_NUMBER = 1;
    static final int END_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNTER) {
            throw new IllegalArgumentException();
        }

        if (!(isDuplicate(numbers))) {
            throw new IllegalArgumentException();
        }

        if (!(isBetweenTwoNumbers(numbers, START_NUMBER, END_NUMBER))) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private boolean isDuplicate(List<Integer> numbers) {
        List<Integer> distinctNumbers = new ArrayList<>();

        for (Integer number : numbers) {
            if (!(distinctNumbers.contains(number))) {
                distinctNumbers.add(number);
            }
        }

        return distinctNumbers.size() == numbers.size();
    }

    static boolean isBetweenTwoNumbers(List<Integer> numbers, int start, int end) {
        for (Integer number : numbers) {
            if (!((start <= number) && (number <= end))) {
                return false;
            }
        }

        return true;
    }

    List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.stream().map(String::valueOf).collect(Collectors.joining(",","[","]"));
    }
}
