package lotto;

import lotto.model.WinningNumber;
import lotto.validator.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {
    private InputValidator inputValidator;

    @BeforeEach
    public void init() {
        inputValidator = new InputValidator();
    } // init

    @Test
    @DisplayName("구입금액이 1000원 단위로 나누어 떨어지는지")
    void canDivideByOneThousand() {
        assertThat(inputValidator.getValidQuantity("2000")).isEqualTo(2);
    }

    @Test
    @DisplayName("입력한 당첨번호가 1~45 사이의 숫자인지")
    void winningNumberIsBetweenOneAndFourtyFive() {
        assertThat(inputValidator.getValidWinningNumber("1, 2, 3, 4, 5, 6")
                .getNumbers()).allMatch(number -> number >= 1 && number <= 45);
    }

    @Test
    @DisplayName("입력한 당첨번호의 개수가 6개인지")
    void winningNumberIsSixCount() {
        assertThat(inputValidator.getValidWinningNumber("1, 2, 3, 4, 5, 6")
                .getNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("입력한 당첨번호의 숫자가 중복되지 않는지")
    void winningNumberDoesNotDuplicate() {
        assertThat(inputValidator.getValidWinningNumber("1, 2, 3, 4, 5, 6")
                .getNumbers()).doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("입력한 보너스 번호가 1~45 사이의 숫자인지")
    void bonusNumberIsBetweenOneAndFourtyFive() {
        assertThat(inputValidator.getValidBonusNumber("7",
                                                    new WinningNumber(List.of(1, 2, 3, 4, 5, 6)))
                .getBonusNumber()).isBetween(1, 45);
    }

    @Test
    @DisplayName("입력한 보너스 번호의 개수가 1개인지")
    void bonusNumberIsOneCount() {
        assertThat(inputValidator.getValidBonusNumber("7",
                                                    new WinningNumber(List.of(1, 2, 3, 4, 5, 6)))
                .getBonusNumber()).isNotNull();
    }

    @Test
    @DisplayName("입력한 보너스 번호와 당첨 번호가 중복되지 않는지")
    void bonusNumberDoesNotDuplicate() {
        assertThat(new WinningNumber(List.of(1, 2, 3, 4, 5, 6)).contains(7)).isFalse();
    }
} // class