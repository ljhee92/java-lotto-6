package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.*;
import lotto.util.Rank;

import java.util.List;
import java.util.stream.Stream;

public class LottoMachine {
    public List<Lotto> createLottos(int quantity) {
        return Stream.generate(this::createLotto).limit(quantity).toList();
    } // createLotto

    public Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    } // createLotto

    public WinningResult compareResult(List<Lotto> issuedLotto, WinningNumber winningNumber, BonusNumber bonusNumber) {
        WinningResult winningResult = new WinningResult();
        issuedLotto.forEach(lotto -> {
            winningResult.updateResult(Rank.of(lotto, winningNumber, bonusNumber));});
        return winningResult;
    } // compareResult

    public double calculateProfit(int quantity, WinningResult winningResult) {
        Profit profit = new Profit(quantity, winningResult);
        return profit.calculateProfit();
    } // calculateProfit
} // class