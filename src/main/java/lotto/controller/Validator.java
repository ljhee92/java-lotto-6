package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.WinningNumber;

import java.util.ArrayList;
import java.util.List;

public class Validator {

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
        String[] inputWinnigNumbers = inputWinningNumber.trim().split(",");

        for (String number : inputWinnigNumbers) {
            winningNumber.add(Integer.parseInt(number));
        } // end for

        return new WinningNumber(winningNumber);
    } // getValidWinningNumber

    public BonusNumber getValidBonusNumber(String inputBonusNumber, WinningNumber winningNumber) {
        if (!inputBonusNumber.matches("[1-9]{1,2}$")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자 1개만 입력 가능합니다.");
        } // end if

        return new BonusNumber(Integer.parseInt(inputBonusNumber), winningNumber);
    } // getValidBonusNumber
} // class