package guru.springframework;

import lombok.Data;

public class Dollar extends Money {

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Dollar times(int multiplier) {
        // this.amount *= multiplier;
        return new Dollar(amount * multiplier);
    }
}
