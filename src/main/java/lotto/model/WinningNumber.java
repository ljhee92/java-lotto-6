package lotto.model;

import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    } // WinningNumber

    private void validate(List<Integer> numbers) {
        checkNumberSize(numbers);
        checkBetweenOneAndFourtyFive(numbers);
        checkDupilicate(numbers);
    } // validate

    private void checkNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자 6개여야 합니다.");
        } // end if
    } // checkNumberSize

    private void checkBetweenOneAndFourtyFive(List<Integer> numbers) {
        if (!numbers.stream().allMatch(number -> number >= 1 && number <= 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        } // end if
    } // checkBetweenOneAndFourtyFive

    private void checkDupilicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다.");
        } // end if
    } // checkDuplicate

    public List<Integer> getNumbers() {
        return numbers;
    } // getNumbers
} // class