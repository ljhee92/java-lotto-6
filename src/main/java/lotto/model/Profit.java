package lotto.model;

public class Profit {
    private final int amount;
    private final WinningResult winningResult;

    public Profit(int quantity, WinningResult winningResult) {
        this.amount = quantity * 1000;
        this.winningResult = winningResult;
    }

    public double calculateProfit() {
        int totalWinningMoney = winningResult.getWinningMoney();
        return (double) totalWinningMoney / amount * 100;
    } // calculateProfit
} // class