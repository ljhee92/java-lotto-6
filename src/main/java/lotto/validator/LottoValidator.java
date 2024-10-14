package lotto.validator;

import lotto.util.ErrorMessage;
import lotto.util.Limit;

import java.util.List;

public class LottoValidator {
    public void checkNumberSize(List<Integer> numbers) {
        if (numbers.size() != Limit.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_MUST_BE_SIX_NUMBERS);
        } // end if
    } // checkNumberSize

    public void checkBetweenOneAndFourtyFive(List<Integer> numbers) {
        if (!numbers.stream().allMatch(number -> number >= Limit.MIN_NUMBER && number <= Limit.MAX_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_MUST_BE_BETWEEN_ONE_AND_FOURTYFIVE);
        } // end if
    } // checkBetweenOneAndFourtyFive

    public void checkDupilicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_MUST_NOT_BE_DUPLICATE);
        } // end if
    } // checkDuplicate
} // class