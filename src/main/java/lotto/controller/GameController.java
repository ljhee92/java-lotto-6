package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.WinningNumber;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class GameController {
    private final OutputView outputView;
    private final InputView inputView;
    private final InputValidator inputValidator;
    private final LottoMachine lottoMachine;

    public GameController() {
        outputView = new OutputView();
        inputView = new InputView();
        inputValidator = new InputValidator();
        lottoMachine = new LottoMachine();
    } // GameController

    public void playGame() {
        purchaseLotto();
        WinningNumber winningNumber = getWinningNumber();
        BonusNumber bonusNumber = getBonusNumber(winningNumber);
    } // startGame

    public void purchaseLotto() {
        outputView.displayMessage("구입금액을 입력해 주세요.");
        String inputAmount = inputView.inputMessage();

        try {
            int quantity = inputValidator.getValidQuantity(inputAmount);
            outputView.displayNewLine();
            outputView.displayMessage(quantity + "개를 구매했습니다.");
            List<Lotto> createdLotto = lottoMachine.createLottos(quantity);

            for (Lotto lotto : createdLotto) {
                outputView.displayMessage(lotto.toString());
            } // end for
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            purchaseLotto();
        } // end catch
    } // purchaseLotto

    public WinningNumber getWinningNumber() {
        outputView.displayNewLine();
        outputView.displayMessage("당첨 번호를 입력해주세요.");
        String inputWinningNumber = inputView.inputMessage();
        WinningNumber winningNumber = null;

        try {
            winningNumber = inputValidator.getValidWinningNumber(inputWinningNumber);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            getWinningNumber();
        } // end catch
        return winningNumber;
    } // inputWinningNumber

    public BonusNumber getBonusNumber(WinningNumber winningNumber) {
        outputView.displayNewLine();
        outputView.displayMessage("보너스 번호를 입력해주세요.");
        String inputBonusNumber = inputView.inputMessage();
        BonusNumber bonusNumber = null;

        try {
            bonusNumber = inputValidator.getValidBonusNumber(inputBonusNumber, winningNumber);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            getBonusNumber(winningNumber);
        } // end catch
        return bonusNumber;
    } // inputBonusNumber
} // class