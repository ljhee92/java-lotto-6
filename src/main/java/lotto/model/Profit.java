package lotto.model;

import lotto.util.Limit;

public class Profit {
    private final int amount;
    private final WinningResult winningResult;

    public Profit(int quantity, WinningResult winningResult) {
        this.amount = quantity * Limit.AMOUNT_UNIT;
        this.winningResult = winningResult;
    } // Profit

    public double calculateProfit() {
        int totalWinningMoney = winningResult.getWinningMoney();
        return (double) totalWinningMoney / amount * 100;
    } // calculateProfit
} // class