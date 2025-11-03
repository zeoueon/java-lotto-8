package lotto.domain;

import java.util.Arrays;

public enum LottoRanking {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

    private int matchCount;
    private boolean bonusMatch;
    private int prizeMoney;

    private LottoRanking(int matchCount, boolean bonusMatch, int prizeMoney) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRanking getRankingByMatchCount(int matchCount, boolean bonusMatch) {
        if (matchCount == 5) {
            return Arrays.stream(values())
                    .filter(ranking -> ranking.matchCount == matchCount && ranking.bonusMatch == bonusMatch)
                    .findFirst()
                    .orElse(NONE);
        }
        
        return Arrays.stream(values())
                .filter(ranking -> ranking.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getStringFormat() {
        if (this == SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - "
                    , matchCount, String.format("%,d", prizeMoney));
        }
        return String.format("%d개 일치 (%s원) - "
                , matchCount, String.format("%,d", prizeMoney));
    }
}
