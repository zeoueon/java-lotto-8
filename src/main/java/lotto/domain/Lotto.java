package lotto.domain;

import java.util.List;
import lotto.constant.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;
    // 추가 변수 사용 금지, private 변경 금지

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER);
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DUPLICATED_LOTTO_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}