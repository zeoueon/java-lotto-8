package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    public static List<Integer> getUniqueSixNumbers() {
        List<Integer> numbers = new ArrayList<Integer>();
        long size = 0L;

        while (size != 6) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            size = numbers.stream().distinct().count();
        }

        return numbers;
    }
}