package lotto.model;

import lotto.validator.LottoValidator;

import java.util.List;

public class Lotto {
    private static final LottoValidator LOTTO_VALIDATOR = new LottoValidator();
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sort(numbers);
        this.numbers = numbers;
    } // Lotto

    private void validate(List<Integer> numbers) {
        LOTTO_VALIDATOR.checkNumberSize(numbers);
        LOTTO_VALIDATOR.checkBetweenOneAndFourtyFive(numbers);
        LOTTO_VALIDATOR.checkDupilicate(numbers);
    } // validate

    private void sort(List<Integer> numbers) {
        numbers.sort(Integer::compareTo);
    } // sort

    @Override
    public String toString() {
        return numbers.toString();
    } // toString
} // class