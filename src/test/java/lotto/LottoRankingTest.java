package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.stream.Stream;
import lotto.domain.LottoRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoRankingTest {

    @ParameterizedTest
    @MethodSource("expectedRanking")
    @DisplayName("getRanking함수가 올바르게 작동하는지 테스트한다.")
    void getRanking_test(int matchcount, boolean expected, LottoRanking expectedRanking) {
        //given
        //when
        LottoRanking ranking = LottoRanking.getRankingByMatchCount(matchcount, expected);

        //then
        assertThat(ranking).isEqualTo(expectedRanking);
    }

    private static Stream<Arguments> expectedRanking() {
        return Stream.of(
                Arguments.of(6, false, LottoRanking.FIRST),
                Arguments.of(5, true, LottoRanking.SECOND),
                Arguments.of(5, false, LottoRanking.THIRD),
                Arguments.of(4, false, LottoRanking.FOURTH),
                Arguments.of(3, false, LottoRanking.FIFTH),
                Arguments.of(2, false, LottoRanking.NONE),
                Arguments.of(2, true, LottoRanking.NONE),
                Arguments.of(1, false, LottoRanking.NONE),
                Arguments.of(1, true, LottoRanking.NONE)
        );
    }
}
