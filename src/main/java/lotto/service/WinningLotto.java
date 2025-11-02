package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRanking;

public class WinningLotto {

    private Lotto winningLotto;
    private int bonusNumber;

    public WinningLotto(List<Integer> winningLotto, int bonusNumber) {
        this.winningLotto = new Lotto(winningLotto);
        this.bonusNumber = bonusNumber;
    }

    public LottoRanking match(Lotto lotto) {
        List<Integer> diff = matchWinningLotto(lotto);

        return calculateLottoRanking(winningLotto.getNumbers().size() - diff.size()
                , matchBonusNumber(diff));
    }

    private List<Integer> matchWinningLotto(Lotto lotto) {
        return lotto.getNumbers()
                .stream()
                .filter(number -> !(winningLotto.getNumbers().contains(number)))
                .toList();
    }

    private boolean matchBonusNumber(List<Integer> diff) {
        return diff.stream()
                .anyMatch(number -> number == bonusNumber);
    }

    private LottoRanking calculateLottoRanking(int matchCount, boolean bonusMatch) {
        return LottoRanking.getRankingByMatchCount(matchCount, bonusMatch);
    }
}
