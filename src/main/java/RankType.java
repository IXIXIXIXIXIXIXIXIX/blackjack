public enum RankType {
    ACE(1, " A"),
    TWO(2, " 2"),
    THREE(3, " 3"),
    FOUR(4, " 4"),
    FIVE(5, " 5"),
    SIX(6, " 6"),
    SEVEN(7, " 7"),
    EIGHT(8, " 8"),
    NINE(9, " 9"),
    TEN(10, "10"),
    JACK(10, " J"),
    QUEEN(10, " Q"),
    KING(10, " K");

    private final int value;
    private final String view;

    RankType(int value, String view){
        this.value = value;
        this.view = view;
    }

    public int getValue() {
        return this.value;
    }
    public String getView() {
        return this.view;
    }
}
