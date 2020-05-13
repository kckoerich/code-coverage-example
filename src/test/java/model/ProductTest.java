package model;

import model.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class ProductTest {

    @Mock
    private Product product;

    @Before
    public void setUp(){
        product = new Product("Arroz Brejarú", new BigDecimal(100).setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    public void shouldReturnProductName() {
        String expected = "Arroz Brejarú";
        assertEquals(expected, product.getName());
    }

    @Test
    public void shouldReturnProductValue() {
        BigDecimal expected = new BigDecimal(100).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expected, product.getValue());
    }

    @Test
    public void shouldCreateNewEmptyProduct() {
        Product expected = new Product();
        assertEquals(expected, new Product());
    }

    @Test
    public void shouldVerifyProductHashcode() {
        Product product1 = new Product();
        Product product2 = new Product();
        assertTrue(product1.equals(product2) && product2.equals(product1));
        assertTrue(product1.hashCode() == product2.hashCode());
    }

    @Test
    public void shouldCalculateFinalValueWithTaxPercentage() {
        BigDecimal expected = new BigDecimal(110).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expected, product.calculateFinalValueWithTaxPercentage(10));
    }

}