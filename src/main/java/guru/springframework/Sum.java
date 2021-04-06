package guru.springframework;

import lombok.Data;

@Data
public class Sum implements Expression {
    private Expression augmend;
    private Expression addmend;

    public Sum(Expression augmend, Expression addmend) {
        this.augmend = augmend;
        this.addmend = addmend;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int amount = augmend.reduce(bank, to).getAmount() + addmend.reduce(bank, to).getAmount();
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression addend) {
        return null;
    }
}
