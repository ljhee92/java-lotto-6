package lotto.model;

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
        if (!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        } // end if
    } // checkBetweenOneAndFourtyFive

    private void checkDupilicate(int bonusNumber, WinningNumber winningNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복되지 않는 숫자여야 합니다.");
        } // end if
    } // checkDuplicate

    public boolean matchesBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    } // matchesBonusNumber

    public int getBonusNumber() {
        return bonusNumber;
    } // getBonusNumber
} // class