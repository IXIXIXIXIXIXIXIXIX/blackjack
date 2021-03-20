public enum RankType {
    ACE(1, " A", 14),
    TWO(2, " 2", 2),
    THREE(3, " 3", 3),
    FOUR(4, " 4", 4),
    FIVE(5, " 5", 5),
    SIX(6, " 6", 6),
    SEVEN(7, " 7", 7),
    EIGHT(8, " 8", 8),
    NINE(9, " 9", 9),
    TEN(10, "10", 10),
    JACK(10, " J", 11),
    QUEEN(10, " Q", 12),
    KING(10, " K", 13);

    private final int value;
    private final String view;
    private final int precedence;

    RankType(int value, String view, int precedence){
        this.value = value;
        this.view = view;
        this.precedence = precedence;
    }

    public int getValue() {
        return this.value;
    }
    public String getView() {
        return this.view;
    }
    public int getPrecedence() {
        return this.precedence;
    }
}
