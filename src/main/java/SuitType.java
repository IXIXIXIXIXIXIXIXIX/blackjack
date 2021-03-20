public enum SuitType {
    HEARTS("\u2665", 3),
    DIAMONDS("\u2666", 2),
    SPADES("\u2660", 4),
    CLUBS("\u2663", 1);

    private final String symbol;
    private final int precedence;
    // Precedence introduced in the unlikely event of a draw with exactly same rank of high card

    SuitType(String symbol, int precedence){
        this.symbol = symbol;
        this.precedence = precedence;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getPrecedence() {
        return this.precedence;
    }
}
