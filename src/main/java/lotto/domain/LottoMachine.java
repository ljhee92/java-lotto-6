package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.List;
import java.util.stream.Stream;

public class LottoMachine {
    public List<Lotto> createLottos(int quantity) {
        return Stream.generate(this::createLotto).limit(quantity).toList();
    } // createLotto

    public Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    } // createLotto
} // class