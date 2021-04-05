package guru.springframework;

import lombok.Data;

public class Franc extends Money {

    public Franc(int amount) {
        this.amount = amount;
    }

    public Money times(int multiplier) {
        // this.amount *= multiplier;
        return new Franc(amount * multiplier);
    }
}
