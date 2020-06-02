package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import java.math.BigDecimal;
import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static pl.edu.agh.internetshop.util.CustomAssertions.assertBigDecimalCompareValue;

public class OrderTest {

	private Order getOrderWithMockedProduct() {
		Product product = mock(Product.class);
		return new Order(Collections.singletonList(product));
	}

	@Test
	public void testGetProductThroughOrder() {
		// given
		Product expectedProduct = mock(Product.class);
		Order order = new Order(Collections.singletonList(expectedProduct));

		// when
		List<Product> actualProducts = order.getProducts();

		// then
		assertSame(expectedProduct, actualProducts.get(0));
	}

	/**new test**/
	@Test
	public void testGetMultipleProductsFromOrder() {
		// given
		Product expectedProduct1 = mock(Product.class);
		Product expectedProduct2 = mock(Product.class);
		Order order = new Order(Arrays.asList(expectedProduct1, expectedProduct2));

		// when
		List<Product> actualProducts = order.getProducts();

		// then
		assertEquals(2, actualProducts.size());
		assertSame(expectedProduct1, actualProducts.get(0));
		assertSame(expectedProduct2, actualProducts.get(1));
	}

	/**new test**/
	@Test
	public void testProductListIsNull() {
		// when then
		assertThrows(NullPointerException.class, () -> new Order(null));
	}

	@Test
	public void testSetShipment() throws Exception {
		// given
		Order order = getOrderWithMockedProduct();
		Shipment expectedShipment = mock(Shipment.class);

		// when
		order.setShipment(expectedShipment);

		// then
		assertSame(expectedShipment, order.getShipment());
	}

	@Test
	public void testShipmentWithoutSetting() throws Exception {
		// given
		Order order = getOrderWithMockedProduct();

		// when

		// then
		assertNull(order.getShipment());
	}

	@Test
	public void testGetPriceWithoutDiscount() throws Exception {
		// given
		BigDecimal expectedOrderPrice = BigDecimal.valueOf(1000);
		Product product = mock(Product.class);
		given(product.getPrice()).willReturn(expectedOrderPrice);
		Order order = new Order(Collections.singletonList(product));

		// when
		BigDecimal actualOrderPrice = order.getPrice();

		// then
		assertBigDecimalCompareValue(expectedOrderPrice, actualOrderPrice);
	}

	/** new test **/
	@Test
	public void testGetPriceWithDiscount() {
		// given
		BigDecimal expectedOrderPrice = BigDecimal.valueOf(1000);
		Product product = mock(Product.class);
		given(product.getPrice()).willReturn(expectedOrderPrice);
		BigDecimal discount = BigDecimal.valueOf(0.4);
		Order order = new Order(Collections.singletonList(product), discount);

		// when
		BigDecimal actualOrderPrice = order.getPrice();

		// then
		assertBigDecimalCompareValue(expectedOrderPrice.subtract(discount.multiply(expectedOrderPrice)), actualOrderPrice);
	}

	/** new test **/
	@Test
	public void testIllegalOrderDiscount() {
		// given
		Product product1 = mock(Product.class);
		Product product2 = mock(Product.class);

		// when then
		Product expectedProduct1 = mock(Product.class);
		assertThrows(IllegalArgumentException.class, () -> new Order(Arrays.asList(product1, product2), BigDecimal.valueOf(1.1)));
		assertThrows(IllegalArgumentException.class, () -> new Order(Arrays.asList(product1, product2), BigDecimal.valueOf(-0.4)));
	}

	private Order getOrderWithCertainProductPrice(double productPriceValue) {
		BigDecimal productPrice = BigDecimal.valueOf(productPriceValue);
		Product product = mock(Product.class);
		given(product.getPrice()).willReturn(productPrice);
		return new Order(Collections.singletonList(product));
	}


	/** changes here **/
	private Order getOrderWithCertainProductPrice(double productPriceValue, double discount) {
		BigDecimal productPrice = BigDecimal.valueOf(productPriceValue);
		Product product = mock(Product.class);
		given(product.getPrice()).willReturn(productPrice);
		return new Order(Collections.singletonList(product), BigDecimal.valueOf(discount));
	}

	@Test
	public void testPriceWithTaxesWithoutRoundUp() {
		// given

		// when
		Order order = getOrderWithCertainProductPrice(2); // 2 PLN

		// then
		/** changes here **/
		assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(2.46)); // 2.44 PLN
	}

	/** new test **/
	@Test
	public void testPriceWithTaxesWithoutRoundUpWithDiscount() {
		// given

		// when
		Order order = getOrderWithCertainProductPrice(2, 0.15); // 2 PLN

		// then
		/** changes here **/
		assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(2.09)); // 2.44 PLN
	}

	@Test
	public void testPriceWithTaxesWithRoundDown() {
		// given

		// when
		Order order = getOrderWithCertainProductPrice(0.01); // 0.01 PLN

		// then
		assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(0.01)); // 0.01 PLN
																							
	}

	/** new test **/
	@Test
	public void testPriceWithTaxesWithRoundDownWithDiscount() {
		// given

		// when
		Order order = getOrderWithCertainProductPrice(6, 0.5); // 0.01 PLN

		// then
		assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(3.69)); // 0.01 PLN

	}

	@Test
	public void testPriceWithTaxesWithRoundUp() {
		// given

		// when
		Order order = getOrderWithCertainProductPrice(0.03); // 0.03 PLN

		// then
		assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(0.04)); // 0.04 PLN
																							
	}

	/** new test **/
	@Test
	public void testPriceWithTaxesWithRoundUpWithDiscount() {
		// given

		// when
		Order order = getOrderWithCertainProductPrice(12, 0.3); // 0.03 PLN

		// then
		System.out.println(order.getPriceWithTaxes());
		assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(10.33)); // 0.04 PLN
	}

	@Test
	public void testSetShipmentMethod() {
		// given
		Order order = getOrderWithMockedProduct();
		ShipmentMethod surface = mock(SurfaceMailBus.class);

		// when
		order.setShipmentMethod(surface);

		// then
		assertSame(surface, order.getShipmentMethod());
	}

	@Test
	public void testSending() {
		// given
		Order order = getOrderWithMockedProduct();
		SurfaceMailBus surface = mock(SurfaceMailBus.class);
		Shipment shipment = mock(Shipment.class);
		given(shipment.isShipped()).willReturn(true);

		// when
		order.setShipmentMethod(surface);
		order.setShipment(shipment);
		order.send();

		// then
		assertTrue(order.isSent());
	}

	@Test
	public void testIsSentWithoutSending() {
		// given
		Order order = getOrderWithMockedProduct();
		Shipment shipment = mock(Shipment.class);
		given(shipment.isShipped()).willReturn(true);

		// when

		// then
		assertFalse(order.isSent());
	}

	@Test
	public void testWhetherIdExists() throws Exception {
		// given
		Order order = getOrderWithMockedProduct();

		// when

		// then
		assertNotNull(order.getId());
	}

	@Test
	public void testSetPaymentMethod() throws Exception {
		// given
		Order order = getOrderWithMockedProduct();
		PaymentMethod paymentMethod = mock(MoneyTransferPaymentTransaction.class);

		// when
		order.setPaymentMethod(paymentMethod);

		// then
		assertSame(paymentMethod, order.getPaymentMethod());
	}

	@Test
	public void testPaying() throws Exception {
		// given
		Order order = getOrderWithMockedProduct();
		PaymentMethod paymentMethod = mock(MoneyTransferPaymentTransaction.class);
		given(paymentMethod.commit(any(MoneyTransfer.class))).willReturn(true);
		MoneyTransfer moneyTransfer = mock(MoneyTransfer.class);
		given(moneyTransfer.isCommitted()).willReturn(true);

		// when
		order.setPaymentMethod(paymentMethod);
		order.pay(moneyTransfer);

		// then
		assertTrue(order.isPaid());
	}

	@Test
	public void testIsPaidWithoutPaying() throws Exception {
		// given
		Order order = getOrderWithMockedProduct();

		// when

		// then
		assertFalse(order.isPaid());
	}
}
