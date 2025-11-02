package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.validation.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidateTest {

    @Test
    @DisplayName("구입 금액이 정수가 아닐 경우 에러 테스트")
    void purchaseAmountTest() {
        //given
        InputValidator validator = new InputValidator();

        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () ->
                validator.validatePurchaseAmount("5000.3"));
        //then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.NOT_INTEGER_PURCHASE_AMOUNT);
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닐 경우 에러 테스트")
    void purchaseAmountTest2() {
        //given
        InputValidator validator = new InputValidator();

        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () ->
                validator.validatePurchaseAmount("5500"));
        //then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT);
    }

    @Test
    @DisplayName("당첨 번호 입력 잘못된 형식 에러 테스트")
    void winningLottoInputTest() {
        //given
        InputValidator validator = new InputValidator();

        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () ->
                validator.validateWinningLotto("1, 2, 3, 4, 5. 6"));

        //then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INVALID_FORMAT_WINNING_LOTTO);
    }

    @Test
    @DisplayName("당첨 번호의 개수가 6개가 아닐 경우 에러 테스트")
    void winningLottoInputTest2() {
        //given
        InputValidator validator = new InputValidator();

        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () ->
                validator.validateWinningLotto("1, 2, 3, 4, 5, 6, 7"));

        //then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INVALID_WINNING_LOTTO_COUNT);
    }

    @Test
    @DisplayName("당첨 번호 입력이 범위를 벗어날 경우 에러 테스트")
    void winningLottoInputTest3() {
        //given
        InputValidator validator = new InputValidator();

        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () ->
                validator.validateWinningLotto("1, 2, 3, 4, 5, 46"));

        //then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INVALID_WINNING_LOTTO_RANGE);
    }

    @Test
    @DisplayName("보너스 번호 입력이 정수가 아닐 경우 에러 테스트")
    void bonusNumberInputTest() {
        InputValidator validator = new InputValidator();

        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () ->
                validator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), "정수아님"));

        //then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.NOT_INTEGER_BONUS_NUMBER);
    }

    @Test
    @DisplayName("보너스 번호 입력이 범위를 벗어났을 경우 에러 테스트")
    void bonusNumberInputTest2() {
        InputValidator validator = new InputValidator();

        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () ->
                validator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), "46"));

        //then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INVALID_BONUS_NUMBER_RANGE);
    }

    @Test
    @DisplayName("보너스 번호 입력이 당첨 번호와 중복일 경우 에러 테스트")
    void bonusNumberInputTest3() {
        InputValidator validator = new InputValidator();

        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () ->
                validator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), "6"));

        //then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.NOT_DUPLICATED_BONUS_NUMBER);
    }
}
