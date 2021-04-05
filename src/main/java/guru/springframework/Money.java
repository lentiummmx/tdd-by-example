package guru.springframework;

import lombok.Data;

@Data
public class Money {

    protected int amount;

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Money)) {
            return false;
        }
        Money other = (Money) o;
        return amount == other.amount
                && this.getClass().equals(o.getClass());
    }

}
