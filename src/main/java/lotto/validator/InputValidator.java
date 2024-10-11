package lotto.validator;

import lotto.model.BonusNumber;
import lotto.model.WinningNumber;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {
    public int getValidQuantity(String inputAmount) {
        if (!inputAmount.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자만 입력해야 합니다.");
        } // end if

        int purchaseAmount = Integer.parseInt(inputAmount);
        int quantity = purchaseAmount / 1000;

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다.");
        } // end if

        return quantity;
    } // validAmount

    public WinningNumber getValidWinningNumber(String inputWinningNumber) {
        List<Integer> winningNumber = new ArrayList<>();
        String[] inputWinningNumbers = inputWinningNumber.trim().split(",");

        for (String number : inputWinningNumbers) {
            winningNumber.add(Integer.parseInt(number));
        } // end for

        return new WinningNumber(winningNumber);
    } // getValidWinningNumber

    public BonusNumber getValidBonusNumber(String inputBonusNumber, WinningNumber winningNumber) {
        return new BonusNumber(inputBonusNumber, winningNumber);
    } // getValidBonusNumber
} // class