package lotto.controller;

import java.util.List;
import lotto.converter.InputParser;
import lotto.service.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private InputParser inputParser;
    private LottoGame lottoGame;

    public LottoController() {
        inputParser = new InputParser();
    }

    public void run() {
        lottoGame = new LottoGame(inputParser
                .parsePurchaseAmount(InputView.inputPurchaseAmount()));

        OutputView.printLottos(lottoGame.startLottoGame());

        setWinningLotto();
        printResults();
    }

    private void setWinningLotto() {
        List<Integer> winningLotto = inputParser
                .parseWinningLotto(InputView.inputWinningNumber());
        int bonusNumber = inputParser.parseBonusNumber(winningLotto, InputView.inputBonusNumber());
        lottoGame.setWinningLotto(winningLotto, bonusNumber);
    }

    private void printResults() {
        OutputView.printResults(lottoGame.getGameResults());
        OutputView.printProfitRate(lottoGame.calculateProfitRate());
    }
}
