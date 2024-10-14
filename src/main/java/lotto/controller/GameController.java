package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.model.*;
import lotto.validator.InputValidator;
import lotto.view.InputReader;
import lotto.view.OutputView;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class GameController {
    private final InputValidator inputValidator;
    private final LottoMachine lottoMachine;

    public GameController() {
        inputValidator = new InputValidator();
        lottoMachine = new LottoMachine();
    } // GameController

    public void playGame() {
        int quantity = repeatUntilValid(this::purchaseLotto);
        List<Lotto> issuedLotto = issueLotto(quantity);

        WinningNumber winningNumber = repeatUntilValid(this::getWinningNumber);
        BonusNumber bonusNumber = repeatUntilValidWithParameter(winningNumber, this::getBonusNumber);

        WinningResult winningResult = lottoMachine.compareResult(issuedLotto, winningNumber, bonusNumber);
        double profit = lottoMachine.calculateProfit(quantity, winningResult);
        OutputView.displayResult(winningResult, profit);
    } // startGame

    public int purchaseLotto() {
        OutputView.requestAmount();
        String inputAmount = InputReader.inputMessage();

        int quantity = inputValidator.getValidQuantity(inputAmount);
        OutputView.displayAmount(quantity);

        return quantity;
    } // purchaseLotto

    public List<Lotto> issueLotto(int quantity) {
        List<Lotto> createdLotto = lottoMachine.createLottos(quantity);
        createdLotto.forEach(OutputView::displayPurchasedLotto);
        return createdLotto;
    } // issueLotto

    public WinningNumber getWinningNumber() {
        OutputView.requestWinningNumber();
        String inputWinningNumber = InputReader.inputMessage();
        return inputValidator.getValidWinningNumber(inputWinningNumber);
    } // inputWinningNumber

    public BonusNumber getBonusNumber(WinningNumber winningNumber) {
        OutputView.requestBonusNumber();
        String inputBonusNumber = InputReader.inputMessage();
        return inputValidator.getValidBonusNumber(inputBonusNumber, winningNumber);
    } // inputBonusNumber

    private <T> T repeatUntilValid(Supplier<T> function) {
        try {
            return function.get();
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.displayErrorMessage(illegalArgumentException.getMessage());
            return repeatUntilValid(function);
        } // end catch
    } // repeatUntilValid

    private <T, R> R repeatUntilValidWithParameter(T input, Function<T, R> function) {
        try {
            return function.apply(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.displayErrorMessage(illegalArgumentException.getMessage());
            return repeatUntilValidWithParameter(input, function);
        } // end catch
    } // repeatUntilValidWithParameter
} // class