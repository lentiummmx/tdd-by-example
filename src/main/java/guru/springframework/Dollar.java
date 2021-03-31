package guru.springframework;

import lombok.Data;

@Data
public class Dollar {

    private int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Dollar times(int multiplier) {
        // this.amount *= multiplier;
        return new Dollar(amount * multiplier);
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Dollar)) {
            return false;
        }
        Dollar other = (Dollar) o;
        return amount == other.amount;
    }
}
