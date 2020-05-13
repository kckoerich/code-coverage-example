package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Product {

    private String name;
    private BigDecimal value;

    public Product() {
        this("", new BigDecimal(0.0));
    }

    public Product(String name, BigDecimal value) {
        setName(name);
        setValue(value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name) &&
                value.equals(product.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    protected BigDecimal calculateFinalValueWithTaxPercentage(float feeValue) {
        BigDecimal taxMultiplier = new BigDecimal(1 + (feeValue/100));
        BigDecimal finalValue = getValue().multiply(taxMultiplier).setScale(2, RoundingMode.HALF_UP);
        return finalValue;
    }
}
