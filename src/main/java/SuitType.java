public enum SuitType {
    HEARTS("\u2665"),
    DIAMONDS("\u2666"),
    SPADES("\u2660"),
    CLUBS("\u2663");

    private final String symbol;

    SuitType(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
