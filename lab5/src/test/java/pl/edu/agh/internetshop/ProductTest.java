package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pl.edu.agh.internetshop.util.CustomAssertions.assertBigDecimalCompareValue;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class ProductTest {

	
    private static final String NAME = "Mr. Sparkle";
    private static final BigDecimal PRICE = BigDecimal.valueOf(1);

	@Test
    public void testProductName() throws Exception{
        //given
    	
        // when
        Product product = new Product(NAME, PRICE);
        
        // then
        assertEquals(NAME, product.getName());
    }
    
    @Test
    public void testProductPriceWithoutDiscount() throws Exception{
        //given
    	
        // when
        Product product = new Product(NAME, PRICE);
        
        // then
        assertBigDecimalCompareValue(product.getPrice(), PRICE);
    }

    /** new test **/
    @Test
    public void testProductPriceWithDiscount() {
	    // given
        BigDecimal discount = BigDecimal.valueOf(0.68);

        // when
        Product product = new Product(NAME, PRICE, discount);

        // then
        assertBigDecimalCompareValue(product.getPrice(), PRICE.subtract(discount.multiply(PRICE)));
    }

    /** new test **/
    @Test
    public void testIllegalDiscount() {
        // when then
        assertThrows(IllegalArgumentException.class, () -> new Product(NAME, PRICE, BigDecimal.valueOf(-0.1)));
        assertThrows(IllegalArgumentException.class, () -> new Product(NAME, PRICE, BigDecimal.valueOf(1.2)));
    }
}