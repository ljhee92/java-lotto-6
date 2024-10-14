package lotto;

import lotto.domain.LottoMachine;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.WinningNumber;
import lotto.util.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WinningResultTest {
    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;
    private LottoMachine lottoMachine;

    @BeforeEach
    void init() {
        winningNumber = new WinningNumber(List.of(1, 2, 3, 7, 8, 9));
        bonusNumber = new BonusNumber(10, winningNumber);
        lottoMachine = new LottoMachine();
    }

    @ParameterizedTest(name = "{index} : {2}")
    @DisplayName("3개, 4개, 5개, 5개+보너스볼, 6개 일치 개수 확인")
    @MethodSource("generateLottoData")
    void testCount(List<Lotto> lottos, Rank rank, String message, int output) {
        assertThat(lottoMachine.compareResult(lottos, winningNumber, bonusNumber).getRank(rank)).isEqualTo(output);
    }

    public Stream<Arguments> generateLottoData() {
        return Stream.of(
                Arguments.of(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), Rank.FIFTH, "3개 일치-1개", 1),
                Arguments.of(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7))), Rank.FOURTH, "4개 일치-1개", 1),
                Arguments.of(List.of(new Lotto(List.of(1, 2, 3, 4, 7, 8))), Rank.THIRD, "5개 일치-1개", 1),
                Arguments.of(List.of(new Lotto(List.of(1, 2, 3, 7, 8, 10))), Rank.SECOND, "5개+보너스 일치-1개", 1),
                Arguments.of(List.of(new Lotto(List.of(1, 2, 3, 7, 8, 9))), Rank.FIRST, "6개 일치-1개", 1),
                Arguments.of(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 6))), Rank.FIFTH, "3개 일치-2개", 2),
                Arguments.of(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new Lotto(List.of(1, 2, 3, 7, 8, 9))), Rank.FIRST, "6개 일치-1개", 1)
        );
    }
} // class