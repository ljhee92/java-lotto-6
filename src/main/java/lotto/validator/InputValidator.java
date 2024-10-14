package lotto.validator;

import lotto.model.BonusNumber;
import lotto.model.Money;
import lotto.model.WinningNumber;
import lotto.util.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValidator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    private static final Pattern BONUS_NUMBER_PATTERN = Pattern.compile("^[0-9]{1,2}$");

    public int getValidQuantity(String inputAmount) {
        Matcher matcher = NUMBER_PATTERN.matcher(inputAmount);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_MUST_BE_NUMBER);
        } // end if

        int amount = Integer.parseInt(inputAmount);
        return new Money(amount).getQuantity();
    } // validAmount

    public WinningNumber getValidWinningNumber(String inputWinningNumber) {
        List<Integer> winningNumber = Arrays.stream(inputWinningNumber.replaceAll(" ", "").split(","))
                                            .map(Integer::parseInt)
                                            .collect(Collectors.toList());

        return new WinningNumber(winningNumber);
    } // getValidWinningNumber

    public BonusNumber getValidBonusNumber(String inputBonusNumber, WinningNumber winningNumber) {
        Matcher matcher = BONUS_NUMBER_PATTERN.matcher(inputBonusNumber);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_MUST_BE_ONLY_ONE_NUMBER);
        } // end if

        return new BonusNumber(Integer.parseInt(inputBonusNumber), winningNumber);
    } // getValidBonusNumber
} // class