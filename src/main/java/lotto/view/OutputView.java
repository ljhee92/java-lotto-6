package lotto.view;

import lotto.model.Lotto;
import lotto.model.WinningResult;

public class OutputView {

    public static void requestAmount() {
        OutputWriter.displayMessage("구입금액을 입력해 주세요.");
    } // requestAmount

    public static void displayAmount(int quantity) {
        OutputWriter.displayNewLine();
        OutputWriter.displayMessage(quantity + "개를 구매했습니다.");
    } // displayAmount

    public static void displayPurchasedLotto(Lotto lotto) {
        OutputWriter.displayMessage(lotto.toString());
    } // displayPurchasedLotto

    public static void displayErrorMessage(String errerMessage) {
        OutputWriter.displayMessage(errerMessage);
    } // displayErrorMessage

    public static void requestWinningNumber() {
        OutputWriter.displayNewLine();
        OutputWriter.displayMessage("당첨 번호를 입력해주세요.");
    } // requestWinningNumber

    public static void requestBonusNumber() {
        OutputWriter.displayNewLine();
        OutputWriter.displayMessage("보너스 번호를 입력해주세요.");
    } // requestBonusNumber

    public static void displayResult(WinningResult winningResult, double profit) {
        OutputWriter.displayNewLine();
        OutputWriter.displayMessage("당첨 통계");
        OutputWriter.displayMessage("---");
        OutputWriter.displayMessage(winningResult.toString());
        OutputWriter.displayMessage("총 수익률은 " + String.format("%,.1f", profit) + "%입니다.");
    } // displayResult
} // class