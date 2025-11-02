package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.converter.InputParser;
import lotto.service.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final int LOTTO_PRICE = 1000;

    private InputParser inputParser;
    private LottoGame lottoGame;

    public LottoController() {
        inputParser = new InputParser();
    }

    public void run() {
        startLottoGame();
        setWinningLotto();
        printResults();
    }

    private void startLottoGame() {
        int purchaseAmount = retryInput(() ->
                inputParser.parsePurchaseAmount(InputView.inputPurchaseAmount()));
        lottoGame = new LottoGame(purchaseAmount / LOTTO_PRICE);
        OutputView.printLottos(lottoGame.startLottoGame());
    }

    private void setWinningLotto() {
        List<Integer> winningLotto = retryInput(() ->
                inputParser.parseWinningLotto(InputView.inputWinningNumber()));
        int bonusNumber = retryInput(() ->
                inputParser.parseBonusNumber(winningLotto, InputView.inputBonusNumber()));

        lottoGame.setWinningLotto(winningLotto, bonusNumber);
    }

    private void printResults() {
        OutputView.printResults(lottoGame.getGameResults());
        OutputView.printProfitRate(lottoGame.calculateProfitRate());
    }

    private <T> T retryInput(Supplier<T> inputFunction) {
        while (true) {
            try {
                return inputFunction.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
