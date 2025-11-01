package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ViewMessage;

public class InputView {

    public static String inputPurchaseAmount() {
        System.out.println(ViewMessage.INPUT_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static String inputWinningNumber() {
        System.out.println(ViewMessage.INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(ViewMessage.INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}