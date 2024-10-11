package lotto.model;

public class BonusNumber {
    private final String bonusNumber;

    public BonusNumber(String bonusNumber, WinningNumber winningNumber) {
        validate(bonusNumber, winningNumber);
        this.bonusNumber = bonusNumber;
    } // BonusNumber

    private void validate(String bonusNumber, WinningNumber winningNumber) {
        checkOnlyOneNumber(bonusNumber);

        int number = Integer.parseInt(bonusNumber);
        checkBetweenOneAndFourtyFive(number);
        checkDupilicate(number, winningNumber);
    } // validate

    private void checkOnlyOneNumber(String bonusNumber) {
        if (!bonusNumber.matches("[1-9]{1,2}$")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자 1개만 입력 가능합니다.");
        } // end if
    } // checkOnlyOneNumber

    private void checkBetweenOneAndFourtyFive(int bonusNumber) {
        if (!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        } // end if
    } // checkBetweenOneAndFourtyFive

    private void checkDupilicate(int bonusNumber, WinningNumber winningNumber) {
        if (winningNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복되지 않는 숫자여야 합니다.");
        } // end if
    } // checkDuplicate
} // class