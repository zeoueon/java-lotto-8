package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LottoGenerator {

    private Supplier<List<Integer>> numberGenerator;

    public LottoGenerator(Supplier<List<Integer>> numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> createLottos(int lottoNumber) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoNumber; i++) {
            lottos.add(createLotto());
        }

        return lottos;
    }

    private Lotto createLotto() {
        return new Lotto(numberGenerator.get()
                .stream()
                .sorted()
                .collect(Collectors.toList()));
    }
}
