package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoRanking;
import lotto.domain.RandomNumberGenerator;
import lotto.domain.WinningLotto;
import lotto.dto.LottoDto;

public class LottoGame {

    private int lottoAmount;
    private LottoGenerator lottoGenerator;
    private WinningLotto winningLotto;
    private List<Lotto> lottos = new ArrayList<Lotto>();
    private List<LottoRanking> results = new ArrayList<>();

    public LottoGame(int lottoAmount) {
        lottoGenerator = new LottoGenerator(RandomNumberGenerator::getUniqueSixNumbers);
        this.lottoAmount = lottoAmount;
    }

    public List<LottoDto> startLottoGame() {
        setLottos(lottoAmount);
        return convertToLottoDto(lottos);
    }

    private void setLottos(int lottoAmount) {
        lottos = lottoGenerator.createLottos(lottoAmount);
    }

    private List<LottoDto> convertToLottoDto(List<Lotto> lottos) {
        List<LottoDto> lottoDtos = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoDtos.add(new LottoDto(lotto.getNumbers()));
        }
        return lottoDtos;
    }

    public void setWinningLotto(List<Integer> winningLotto, int bonusNumber) {
        this.winningLotto = new WinningLotto(winningLotto, bonusNumber);
    }

    public List<LottoRanking> getGameResults() {
        for (Lotto lotto : lottos) {
            results.add(winningLotto.match(lotto));
        }

        return results;
    }

    public double calculateProfitRate() {
        long totalWinnings = 0;

        for (LottoRanking lottoRanking : results) {
            totalWinnings += lottoRanking.getPrizeMoney();
        }

        return ((double) totalWinnings / (lottoAmount * 1000)) * 100;
    }
}
