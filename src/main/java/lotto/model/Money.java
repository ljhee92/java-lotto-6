package lotto.model;

import lotto.util.ErrorMessage;
import lotto.util.Limit;

public class Money {
    private final int amount;
    private final int quantity;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
        this.quantity = setQuantity();
    } // Money

    private void validate(int amount) {
        if (amount % Limit.AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_MUST_BE_DIVIDE_INTO_1000);
        } // end if
    } // validate

    private int setQuantity() {
        return amount / Limit.AMOUNT_UNIT;
    } // setQuantity

    public int getQuantity() {
        return quantity;
    } // getQuantity
} // class