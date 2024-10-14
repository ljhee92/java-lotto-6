package lotto.model;

public class Money {
    private final int amount;
    private final int quantity;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
        this.quantity = setQuantity();
    } // Money

    private void validate(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다.");
        } // end if
    } // validate

    private int setQuantity() {
        return amount / 1000;
    } // setQuantity

    public int getQuantity() {
        return quantity;
    } // getQuantity
} // class