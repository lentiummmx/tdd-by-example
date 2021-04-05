package guru.springframework;

import lombok.Data;

@Data
public class Franc {

    private int amount;

    public Franc(int amount) {
        this.amount = amount;
    }

    public Franc times(int multiplier) {
        // this.amount *= multiplier;
        return new Franc(amount * multiplier);
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Franc)) {
            return false;
        }
        Franc other = (Franc) o;
        return amount == other.amount;
    }
}
