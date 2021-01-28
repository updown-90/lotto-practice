package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    public static final int LOTTO_PRICE = 1000;

    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    // 테스트 코드 작성하기 위해서 생성
    protected LottoNumbers() {
    }

    // 테스트 코드 작성하기 위해서 생성
    protected LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers(int inputAmount) {
        validationInputAmount(inputAmount);
        createLottoNumbers(inputAmount);
    }

    private void validationInputAmount(int inputAmount) {
        if (inputAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public void createLottoNumbers(int inputCash) {
        int lottoCount = inputCash / LOTTO_PRICE;

        for (int i = 0; i < lottoCount; i++) {
            this.lottoNumbers.add(LottoNumberGenerator.createLottoNumber());
        }
    }

    public LottoTotalResult calculateMatchCountAndRate(LottoWinnerNumber lottoWinnerNumber) {

        List<LottoResult> lottoResults = this.lottoNumbers.stream()
                .map(lottoWinnerNumber::matchCount)
                .collect(Collectors.toList());

        return new LottoTotalResult(lottoResults);
    }

}