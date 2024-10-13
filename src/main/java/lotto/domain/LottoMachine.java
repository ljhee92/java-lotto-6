package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.WinningNumber;
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

    public Result compareResult(List<Lotto> issuedLotto, WinningNumber winningNumber, BonusNumber bonusNumber) {;
        Result result = new Result();
        issuedLotto.forEach(lotto -> {result.updateResult(Rank.of(lotto, winningNumber, bonusNumber));});
        return result;
    }
} // class