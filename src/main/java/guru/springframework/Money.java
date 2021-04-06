package guru.springframework;

import lombok.Data;

import java.util.Currency;

@Data
public class Money implements Expression {

    protected int amount;

    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Expression times(int multiplier) {
        return new Money(amount * multiplier, this.currency);
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Money)) {
            return false;
        }
        Money other = (Money) o;
        return amount == other.amount
                && this.currency.equals(((Money) o).currency);
    }

    @Override
    public Money reduce(Bank bank, String to) {
//        return this;
        //int rate = (currency.equals("CHF") && to.equals("USD")) ? 2 : 1;
        return new Money(amount / bank.rate(currency, to), to);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

}
