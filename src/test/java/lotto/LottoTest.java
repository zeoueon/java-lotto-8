package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

    @Test
    @DisplayName("로또를 생성하면 중복이 없는 6개의 숫자가 오름차순으로 생성된다.")
    void lottoGeneratorTest() {
        //given
        LottoGenerator generator = new LottoGenerator(RandomNumberGenerator::getUniqueSixNumbers);
        int lottoAmount = 3;

        //when
        List<Lotto> lottos = generator.createLottos(lottoAmount);

        //then
        assertThat(lottos).hasSize(lottoAmount);
        assertThat(lottos).allSatisfy(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            assertThat(numbers).hasSize(6);
            assertThat(numbers).isSorted();
            assertThat(numbers).doesNotHaveDuplicates();
        });
    }
}