package lotto;

import lotto.model.WinningNumber;
import lotto.validator.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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

    @ParameterizedTest(name = "{index} : {1}")
    @DisplayName("구입 금액 예외 테스트")
    @MethodSource("generateAmountData")
    void testPurchaseAmountException(String input, String message) {
        assertThatThrownBy(() -> inputValidator.getValidQuantity(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public Stream<Arguments> generateAmountData() {
        return Stream.of(
                Arguments.of("1000j", "숫자가 아닐 때"),
                Arguments.of("1001", "1000으로 나누어 떨어지지 않을 때")
        );
    }

    @ParameterizedTest(name = "{index} : {1}")
    @DisplayName("당첨 번호 예외 테스트")
    @MethodSource("generateWinningNumberData")
    void testWinningNumberException(String input, String Message) {
        assertThatThrownBy(() -> inputValidator.getValidWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public Stream<Arguments> generateWinningNumberData() {
        return Stream.of(
                Arguments.of("1, 2, 3, 4, 5, 46", "1~45 사이 숫자가 아닐 때"),
                Arguments.of("1, 2, 3, 4, 5, 6, 7", "숫자의 개수가 6개를 넘을 때"),
                Arguments.of("1, 2, 3, 4, 5", "숫자의 개수가 6개보다 적을 때"),
                Arguments.of("1, 2, 3, 4, 5, 5", "중복될 때")
        );
    }

    @ParameterizedTest(name = "{index} : {2}")
    @DisplayName("보너스 번호 예외 테스트")
    @MethodSource("generateBonusNumberData")
    void testBonusNumberException(String inputBonusNumber, WinningNumber inputWinningNumber, String Message) {
        assertThatThrownBy(() -> inputValidator.getValidBonusNumber(inputBonusNumber, inputWinningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public Stream<Arguments> generateBonusNumberData() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        return Stream.of(
                Arguments.of("46", winningNumber, "1~45 사이 숫자가 아닐 때"),
                Arguments.of("46, 47", winningNumber, "숫자의 개수가 1개를 넘을 때"),
                Arguments.of("", winningNumber, "숫자의 개수가 1개가 아닐 때"),
                Arguments.of("j", winningNumber, "숫자를 입력하지 않았을 때"),
                Arguments.of("4", winningNumber, "당첨 번호와 중복될 때")
        );
    }
} // class