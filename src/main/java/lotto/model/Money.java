package lotto.model;

public class Money {
    private final int amount;
    private final int quantity;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
        this.quantity = setQuantity();
    }

    private void validate(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    private int setQuantity() {
        return amount / 1000;
    }

    public int getQuantity() {
        return quantity;
    }
} // class