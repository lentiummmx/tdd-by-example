package guru.springframework;

import lombok.Data;

@Data
public class Money implements Expression {

    protected int amount;

    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money other = (Money) o;
        return amount == other.amount
                && currency.equals(other.currency);
    }

    @Override
    public Money reduce(Bank bank, String to) {
        return new Money(amount / bank.rate(currency, to), to);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

}
