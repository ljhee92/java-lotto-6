package lotto.model;

import lotto.validator.LottoValidator;

import java.util.List;

public class WinningNumber {
    private static final LottoValidator LOTTO_VALIDATOR = new LottoValidator();
    private final List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    } // WinningNumber

    private void validate(List<Integer> numbers) {
        LOTTO_VALIDATOR.checkNumberSize(numbers);
        LOTTO_VALIDATOR.checkBetweenOneAndFourtyFive(numbers);
        LOTTO_VALIDATOR.checkDupilicate(numbers);
    } // validate

    public List<Integer> getNumbers() {
        return numbers;
    } // getNumbers
} // class