package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.WinningNumber;
import lotto.validator.InputValidator;
import lotto.view.InputReader;
import lotto.view.OutputView;

import java.util.List;

public class GameController {
    private final OutputView outputView;
    private final InputReader inputReader;
    private final InputValidator inputValidator;
    private final LottoMachine lottoMachine;

    public GameController() {
        outputView = new OutputView();
        inputReader = new InputReader();
        inputValidator = new InputValidator();
        lottoMachine = new LottoMachine();
    } // GameController

    public void playGame() {
        purchaseLotto();
        WinningNumber winningNumber = getWinningNumber();
        BonusNumber bonusNumber = getBonusNumber(winningNumber);
    } // startGame

    public void purchaseLotto() {
        outputView.requestAmount();
        String inputAmount = inputReader.inputMessage();

        try {
            int quantity = inputValidator.getValidQuantity(inputAmount);
            outputView.displayAmount(quantity);

            List<Lotto> createdLotto = lottoMachine.createLottos(quantity);

            for (Lotto lotto : createdLotto) {
                outputView.displayPurchasedLotto(lotto);
            } // end for
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.displayErrorMessage(illegalArgumentException.getMessage());
            purchaseLotto();
        } // end catch
    } // purchaseLotto

    public WinningNumber getWinningNumber() {
        outputView.requestWinningNumber();
        String inputWinningNumber = inputReader.inputMessage();

        WinningNumber winningNumber = null;
        try {
            winningNumber = inputValidator.getValidWinningNumber(inputWinningNumber);
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.displayErrorMessage(illegalArgumentException.getMessage());
            getWinningNumber();
        } // end catch
        return winningNumber;
    } // inputWinningNumber

    public BonusNumber getBonusNumber(WinningNumber winningNumber) {
        outputView.requestBonusNumber();
        String inputBonusNumber = inputReader.inputMessage();
        BonusNumber bonusNumber = null;

        try {
            bonusNumber = inputValidator.getValidBonusNumber(inputBonusNumber, winningNumber);
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.displayErrorMessage(illegalArgumentException.getMessage());
            getBonusNumber(winningNumber);
        } // end catch
        return bonusNumber;
    } // inputBonusNumber
} // class