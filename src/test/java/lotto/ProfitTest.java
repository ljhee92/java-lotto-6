package lotto;

import lotto.domain.LottoMachine;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.WinningNumber;
import lotto.model.WinningResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitTest {
    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;
    private LottoMachine lottoMachine;

    @BeforeEach
    void init() {
        winningNumber = new WinningNumber(List.of(1, 2, 3, 7, 8, 9));
        bonusNumber = new BonusNumber(10, winningNumber);
        lottoMachine = new LottoMachine();
    } // init

    @Test
    @DisplayName("수익률 계산")
    void testProfit() {
        int quantity = 5;
        WinningResult winningResult = lottoMachine.compareResult(
                List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), winningNumber, bonusNumber
        );
        assertThat(lottoMachine.calculateProfit(quantity, winningResult)).isEqualTo(100.0);
    } // testProfit
} // class