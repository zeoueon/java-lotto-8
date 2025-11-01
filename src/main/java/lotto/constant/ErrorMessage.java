package lotto.constant;

public class ErrorMessage {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public static final String NOT_INTEGER_PURCHASE_AMOUNT = ERROR_MESSAGE_PREFIX + "구입 금액을 올바른 형식으로 입력하세요.";
    public static final String INVALID_PURCHASE_AMOUNT_UNIT = ERROR_MESSAGE_PREFIX + "구입 금액은 천원 단위여야 합니다.";

    public static final String NOT_INTEGER_BONUS_NUMBER = ERROR_MESSAGE_PREFIX + "보너스 번호를 올바른 형식으로 입력하세요.";
    public static final String NOT_DUPLICATED_BONUS_NUMBER = ERROR_MESSAGE_PREFIX + "보너스 번호는 당첨 번호와 중복이 될 수 없습니다.";
    public static final String INVALID_BONUS_NUMBER_RANGE = ERROR_MESSAGE_PREFIX + "보너스 번호는 1이상 45이하의 값이어야 합니다.";

    public static final String INVALID_WINNING_LOTTO_RANGE = ERROR_MESSAGE_PREFIX + "당첨 번호는 1이상 45이하의 값이어야 합니다.";
    public static final String INVALID_FORMAT_WINNING_LOTTO = ERROR_MESSAGE_PREFIX + "당첨 번호를 올바른 형식으로 입력하세요.";
    public static final String INVALID_WINNING_LOTTO_COUNT = ERROR_MESSAGE_PREFIX + "당첨 번호는 6개를 입력해야 합니다.";
}
