package lotto.validator;

import lotto.model.BonusNumber;
import lotto.model.Money;
import lotto.model.WinningNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");

    public int getValidQuantity(String inputAmount) {
        Matcher matcher = NUMBER_PATTERN.matcher(inputAmount);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자만 입력해야 합니다.");
        } // end if

        int amount = Integer.parseInt(inputAmount);
        return new Money(amount).getQuantity();
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