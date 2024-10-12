package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.WinningNumber;
import lotto.validator.InputValidator;
import lotto.view.InputReader;
import lotto.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

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
        int quantity = repeatUntilValid(this::purchaseLotto);
        issueLotto(quantity);
        WinningNumber winningNumber = repeatUntilValid(this::getWinningNumber);
        BonusNumber bonusNumber = getBonusNumber(winningNumber);
    } // startGame

    public int purchaseLotto() {
        outputView.requestAmount();
        String inputAmount = inputReader.inputMessage();

        int quantity = inputValidator.getValidQuantity(inputAmount);
        outputView.displayAmount(quantity);

        return quantity;
    } // purchaseLotto

    public void issueLotto(int quantity) {
        List<Lotto> createdLotto = lottoMachine.createLottos(quantity);
        createdLotto.forEach(outputView::displayPurchasedLotto);
    } // issueLotto

    public WinningNumber getWinningNumber() {
        outputView.requestWinningNumber();
        String inputWinningNumber = inputReader.inputMessage();
        return inputValidator.getValidWinningNumber(inputWinningNumber);
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

    private <T> T repeatUntilValid(Supplier<T> function) {
        try {
            return function.get();
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.displayErrorMessage(illegalArgumentException.getMessage());
            return repeatUntilValid(function);
        } // end catch
    } // repeatUntilValid
} // class