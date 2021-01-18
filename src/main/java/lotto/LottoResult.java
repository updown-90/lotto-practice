package lotto;

public class LottoResult {

    public static final int THREE_MATCH_AMOUNT = 5000;
    public static final int FOUR_MATCH_AMOUNT = 50000;
    public static final int FIVE_MATCH_AMOUNT = 1500000;
    public static final int SIX_MATCH_AMOUNT = 2000000000;

    private int matchCount;

    private int winningAmount;

    public LottoResult(int matchCount) {
        this.matchCount = matchCount;
        calculateWinningAmount();
    }

    public void calculateWinningAmount() {
        if (this.matchCount == 3) {
            this.winningAmount = THREE_MATCH_AMOUNT;
        }

        if (this.matchCount == 4) {
            this.winningAmount = FOUR_MATCH_AMOUNT;
        }

        if (this.matchCount == 5) {
            this.winningAmount = FIVE_MATCH_AMOUNT;
        }

        if (this.matchCount == 6) {
            this.winningAmount = SIX_MATCH_AMOUNT;
        }
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public boolean matchCountEqual(int matchCount) {
        return this.matchCount == matchCount;
    }
}