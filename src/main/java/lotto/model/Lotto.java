package lotto.model;

import lotto.validator.LottoValidator;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final LottoValidator LOTTO_VALIDATOR = new LottoValidator();
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        sort();
    } // Lotto

    private void validate(List<Integer> numbers) {
        LOTTO_VALIDATOR.checkNumberSize(numbers);
        LOTTO_VALIDATOR.checkBetweenOneAndFourtyFive(numbers);
        LOTTO_VALIDATOR.checkDupilicate(numbers);
    } // validate

    private void sort() {
        numbers.sort(Integer::compareTo);
    } // sort

    public boolean contains(int number) {
        return numbers.contains(number);
    } // contains

    @Override
    public String toString() {
            return numbers.toString();
    } // toString

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    } // getNumbers
} // class