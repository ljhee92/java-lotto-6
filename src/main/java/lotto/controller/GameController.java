package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final OutputView outputView;
    private final InputView inputView;
    private final Validator validator;

    public GameController() {
        outputView = new OutputView();
        inputView = new InputView();
        validator = new Validator();
    } // GameController

    public void startGame() {
        purchaseLotto();
        WinningNumber winningNumber = inputWinningNumber();
        BonusNumber bonusNumber = inputBonusNumber(winningNumber);
    } // startGame

    public void purchaseLotto() {
        outputView.displayMessage("구입금액을 입력해 주세요.");
        String inputAmount = inputView.inputMessage();

        try {
            int quantity = validator.getValidQuantity(inputAmount);
            outputView.displayNewLine();
            outputView.displayMessage(quantity + "개를 구매했습니다.");
            List<Lotto> createdLotto = createLotto(quantity);

            for (Lotto lotto : createdLotto) {
                outputView.displayMessage(lotto.toString());
            } // end for
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            purchaseLotto();
        } // end catch
    } // purchaseLotto

    public List<Lotto> createLotto(int quantity) {
        List<Lotto> lotto = new ArrayList<>();
        List<Integer> numbers;

        for (int i = 0; i < quantity; i++) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotto.add(new Lotto(numbers));
        } // end for

        return lotto;
    } // createLotto

    public WinningNumber inputWinningNumber() {
        outputView.displayNewLine();
        outputView.displayMessage("당첨 번호를 입력해주세요.");
        String inputWinningNumber = inputView.inputMessage();
        WinningNumber winningNumber = null;

        try {
            winningNumber = validator.getValidWinningNumber(inputWinningNumber);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            inputWinningNumber();
        } // end catch
        return winningNumber;
    } // inputWinningNumber

    public BonusNumber inputBonusNumber(WinningNumber winningNumber) {
        outputView.displayNewLine();
        outputView.displayMessage("보너스 번호를 입력해주세요.");
        String inputBonusNumber = inputView.inputMessage();
        BonusNumber bonusNumber = null;

        try {
            bonusNumber = validator.getValidBonusNumber(inputBonusNumber, winningNumber);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            inputBonusNumber(winningNumber);
        } // end catch
        return bonusNumber;
    } // inputBonusNumber
} // class