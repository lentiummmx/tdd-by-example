package guru.springframework;

import lombok.Data;

@Data
public class Sum implements Expression {
    private Money augmend;
    private Money addmend;

    public Sum(Money augmend, Money addmend) {
        this.augmend = augmend;
        this.addmend = addmend;
    }

    @Override
    public Money reduce(String to) {
        int amount = augmend.getAmount() + addmend.getAmount();
        return new Money(amount, to);
    }
}
