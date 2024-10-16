package lotto;

import lotto.domain.LottoMachine;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    } // createLottoByOverSize

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    } // createLottoByDuplicatedNumber

    // 아래에 추가 테스트 작성 가능
    @Test
    @DisplayName("로또 번호가 1~45 사이가 아니라면 예외가 발생한다.")
    void createExceptionLottoByOneToFourtyFive() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    } // createExceptionLottoByOneToFourtyFive

    @Test
    @DisplayName("로또 번호가 1~45 사이의 숫자로 생성되는지 확인한다.")
    void createLottoByOneToFourtyFive() {
        assertThat(new LottoMachine().createLotto().getNumbers()).allMatch(number -> number >= 1 && number <= 45);
    } // createLottoByOneToFourtyFive

    @Test
    @DisplayName("로또 번호의 개수가 6개인지 확인한다.")
    void createLottoBySixCount() {
        assertThat(new LottoMachine().createLotto().getNumbers()).hasSize(6);
    } // createLottoBySixCount

    @Test
    @DisplayName("로또 번호가 중복되지 않는지 확인한다.")
    void createLottoByNotDuplicate() {
        assertThat(new LottoMachine().createLotto().getNumbers()).doesNotHaveDuplicates();
    } // createLottoByNotDuplicate

    @Test
    @DisplayName("사용자가 입력한 구입 개수만큼 로또가 생성되는지 확인")
    void createLottoByUserInputQuantity() {
        assertThat(new LottoMachine().createLottos(3)).hasSize(3);
    } // createLottoByUserInputQuantity
} // class