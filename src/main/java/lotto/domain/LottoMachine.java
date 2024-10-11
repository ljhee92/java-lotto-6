package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public List<Lotto> createLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(createLotto()));
        } // end for

        return lottos;
    } // createLotto

    public List<Integer> createLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    } // createLotto
} // class