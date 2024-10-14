package lotto.model;

import lotto.util.ErrorMessage;
import lotto.util.Limit;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, WinningNumber winningNumber) {
        validate(bonusNumber, winningNumber);
        this.bonusNumber = bonusNumber;
    } // BonusNumber

    private void validate(int bonusNumber, WinningNumber winningNumber) {
        checkBetweenOneAndFourtyFive(bonusNumber);
        checkDupilicate(bonusNumber, winningNumber);
    } // validate

    private void checkBetweenOneAndFourtyFive(int bonusNumber) {
        if (!(bonusNumber >= Limit.MIN_NUMBER && bonusNumber <= Limit.MAX_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_MUST_BE_BETWEEN_ONE_AND_FOURTYFIVE);
        } // end if
    } // checkBetweenOneAndFourtyFive

    private void checkDupilicate(int bonusNumber, WinningNumber winningNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_MUST_NOT_BE_DUPLICATE_OF_LOTTO);
        } // end if
    } // checkDuplicate

    public boolean matchesBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    } // matchesBonusNumber

    public int getBonusNumber() {
        return bonusNumber;
    } // getBonusNumber
} // class