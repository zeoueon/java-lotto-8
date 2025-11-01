package lotto.converter;

import java.util.Arrays;
import java.util.List;
import lotto.validation.InputValidator;

public class InputParser {

    public InputValidator validator = new InputValidator();

    public int parsePurchaseAmount(String purchaseAmount) {
        validator.validatePurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public List<Integer> parseWinningLotto(String winningLotto) {
        validator.validateWinningLotto(winningLotto);
        return Arrays.stream(winningLotto.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public int parseBonusNumber(List<Integer> winningLotto, String bonusNumber) {
        validator.validateBonusNumber(winningLotto, bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}
