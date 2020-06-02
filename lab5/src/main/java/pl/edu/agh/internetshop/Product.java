package pl.edu.agh.internetshop;

import java.math.BigDecimal;

public class Product {
	
	public static final int PRICE_PRECISION = 2;
	public static final int ROUND_STRATEGY = BigDecimal.ROUND_HALF_UP;
	
    private final String name;
    private final BigDecimal price;
    /** changes here **/
    private BigDecimal discount = BigDecimal.valueOf(0);

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
        this.price.setScale(PRICE_PRECISION, ROUND_STRATEGY);
    }

    /** changes here **/
    public Product(String name, BigDecimal price, BigDecimal discount) {
        this.name = name;
        this.price = price;
        this.price.setScale(PRICE_PRECISION, ROUND_STRATEGY);
        if(discount.doubleValue() > 1.0 || discount.doubleValue() < 0.0)
            throw new IllegalArgumentException("Discount out od possible range: " + discount);
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    /** changes here **/
    public BigDecimal getPrice() {
        return price.subtract(discount.multiply(price));
    }
}
