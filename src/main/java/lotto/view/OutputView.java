package lotto.view;

import lotto.model.Lotto;

public class OutputView {
    private static final OutputWriter OUTPUT_WRITER = new OutputWriter();

    public void requestAmount() {
        OUTPUT_WRITER.displayMessage("구입금액을 입력해 주세요.");
    }

    public void displayAmount(int quantity) {
        OUTPUT_WRITER.displayNewLine();
        OUTPUT_WRITER.displayMessage(quantity + "개를 구매했습니다.");
    }

    public void displayPurchasedLotto(Lotto lotto) {
        OUTPUT_WRITER.displayMessage(lotto.toString());
    }

    public void displayErrorMessage(String errerMessage) {
        OUTPUT_WRITER.displayMessage(errerMessage);
    }

    public void requestWinningNumber() {
        OUTPUT_WRITER.displayNewLine();
        OUTPUT_WRITER.displayMessage("당첨 번호를 입력해주세요.");
    }

    public void requestBonusNumber() {
        OUTPUT_WRITER.displayNewLine();
        OUTPUT_WRITER.displayMessage("보너스 번호를 입력해주세요.");
    }
} // class