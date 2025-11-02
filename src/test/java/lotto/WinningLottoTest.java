package lotto;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.service.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningLottoTest {

    @ParameterizedTest
    @MethodSource("expectedRanking")
    @DisplayName("WinningLotto의 match 함수가 올바르게 동작하는 지 확인한다.")
    void winningLottoTest(Lotto lotto, LottoRanking expectedRanking) {
        //given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        //when
        LottoRanking ranking = winningLotto.match(lotto);

        //then
        assertThat(ranking).isEqualTo(expectedRanking);
    }

    private static Stream<Arguments> expectedRanking() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoRanking.FIRST),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), LottoRanking.SECOND),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 9)), LottoRanking.THIRD),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 8, 9)), LottoRanking.FOURTH),
                Arguments.of(new Lotto(List.of(1, 2, 3, 8, 9, 10)), LottoRanking.FIFTH),
                Arguments.of(new Lotto(List.of(8, 9, 10, 11, 12, 13)), LottoRanking.NONE)
        );
    }
}
