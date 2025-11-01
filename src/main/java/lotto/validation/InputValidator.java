package lotto.validation;

import java.util.Arrays;
import java.util.List;
import lotto.constant.ErrorMessage;

public class InputValidator {

    public void validatePurchaseAmount(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_PURCHASE_AMOUNT);
        }
    }

    public void validateWinningLotto(String winningLotto) {
        try {
            List<Integer> winningLottoList =
                    Arrays.stream(winningLotto.split(","))
                            .map(String::trim)
                            .map(Integer::parseInt)
                            .toList();
            checkCountWinningLotto(winningLottoList);
            checkRangeWinningLotto(winningLottoList);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT_WINNING_LOTTO);
        }
    }

    public void validateBonusNumber(List<Integer> winningLotto, String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_BONUS_NUMBER);
        }

        checkRangeBonusNumber(Integer.parseInt(bonusNumber));
        checkDuplicateBonusNumber(winningLotto, Integer.parseInt(bonusNumber));
    }

    private void checkDuplicateBonusNumber(List<Integer> winningLotto, int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DUPLICATED_BONUS_NUMBER);
        }
    }

    private void checkRangeBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_RANGE);
        }
    }

    private void checkRangeWinningLotto(List<Integer> winningLotto) {
        boolean hasInvalidElement = winningLotto.stream().anyMatch(winningLottoElement ->
                winningLottoElement > 45 || winningLottoElement < 1);

        if (hasInvalidElement) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_LOTTO_RANGE);
        }
    }

    private void checkCountWinningLotto(List<Integer> winningLotto) {
        if (winningLotto.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_LOTTO_COUNT);
        }
    }
}
