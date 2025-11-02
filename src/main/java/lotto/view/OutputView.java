package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.domain.LottoRanking;
import lotto.dto.LottoDto;

public class OutputView {

    public static void printLottos(List<LottoDto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for (LottoDto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResults(List<LottoRanking> results) {
        Map<LottoRanking, Integer> rankingCount = initializeResultsMap();
        putResults(results, rankingCount);

        for (Map.Entry<LottoRanking, Integer> entry : rankingCount.entrySet()) {
            System.out.println(entry.getKey().getStringFormat() + entry.getValue() + "개");
        }
    }

    public static void printProfitRate(double profitRate) {
        double roundProfitRate = Math.round(profitRate * 100) / 100.0;
        System.out.println("총 수익률은 " + roundProfitRate + "%입니다.");
    }

    private static Map<LottoRanking, Integer> initializeResultsMap() {
        return Arrays.stream(LottoRanking.values())
                .filter(lottoRanking
                        -> !lottoRanking.equals(LottoRanking.NONE))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toMap(
                        Function.identity()
                        , count -> 0
                        , (count1, count2) -> count1
                        , LinkedHashMap::new));
    }

    private static void putResults(
            List<LottoRanking> results,
            Map<LottoRanking, Integer> rankingCount
    ) {
        results.stream().filter(lottoRanking
                        -> !lottoRanking.equals(LottoRanking.NONE))
                .forEach(lottoRanking -> {
                    rankingCount.put(lottoRanking, rankingCount.get(lottoRanking) + 1);
                });
    }
}
