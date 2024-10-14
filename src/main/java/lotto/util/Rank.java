package lotto.util;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.WinningNumber;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원) - "),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원) - "),
    MISS(0, false, 0, "");

    private int matchedNumbersCount;
    private boolean matchesBonusNumber;
    private int winningMoney;
    private String message;

    private Rank(int matchedNumbersCount, boolean matchesBonusNumber, int winningMoney, String message) {
        this.matchedNumbersCount = matchedNumbersCount;
        this.matchesBonusNumber = matchesBonusNumber;
        this.winningMoney = winningMoney;
        this.message = message;
    } // Rank

    public static Rank of(Lotto lotto, WinningNumber winningNumber, BonusNumber bonusNumber) {
        return Rank.of(winningNumber.countMatchNumbers(lotto),
                bonusNumber.matchesBonusNumber(lotto));
    }

    public static Rank of(int matchedNumbersCount, boolean matchesBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchedNumbersCount == matchedNumbersCount
                                && rank.matchesBonusNumber == matchesBonusNumber)
                .findAny().orElse(MISS);
    }

    public String getMessage() {
        return message;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
} // enum