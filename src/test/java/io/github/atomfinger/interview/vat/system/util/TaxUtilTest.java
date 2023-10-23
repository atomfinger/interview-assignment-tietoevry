package io.github.atomfinger.interview.vat.system.util;

import io.github.atomfinger.interview.vat.system.model.Product;
import io.github.atomfinger.interview.vat.system.model.ProductCategory;
import io.github.atomfinger.interview.vat.system.model.VatResult;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaxUtilTest {

    @Test
    void testGetVatForItems_Grocery() {
        Product product = new Product(1L, "Apple", 10.50, ProductCategory.GROCERY, "Norway");
        List<Product> products = new ArrayList<>();
        products.add(product);

        List<VatResult> results = TaxUtil.getVatForItems(products);

        assertEquals(2, results.size());
        VatResult result = results.get(0);
        assertEquals(1, result.itemId());
        assertEquals(10.50, result.price());
        assertEquals("Sales Tax", result.taxDescription());
        assertEquals(3.0, result.taxAmount());
        assertEquals(-1.0, results.get(1).taxAmount());
    }

    @Test
    void testGetVatForItems_Clothing() {
        Product product = new Product(2L, "Shirt", 25.0, ProductCategory.CLOTHING, "Norway");
        List<Product> products = new ArrayList<>();
        products.add(product);

        List<VatResult> results = TaxUtil.getVatForItems(products);

        VatResult result = results.get(0);
        assertEquals(2, result.itemId());
        assertEquals(25.0, result.price());
        assertEquals("Sales Tax", result.taxDescription());
        assertEquals(7.0, result.taxAmount());
    }

    @Test
    void testGetVatForItems_Book() {
        Product product = new Product(3L, "Book", 10.0, ProductCategory.BOOKS, "Norway");
        List<Product> products = new ArrayList<>();
        products.add(product);

        List<VatResult> results = TaxUtil.getVatForItems(products);

        VatResult result = results.get(0);
        assertEquals(3, result.itemId());
        assertEquals(10.0, result.price());
        assertEquals("Sales Tax", result.taxDescription());
        assertEquals(0, result.taxAmount());
    }

    @Test
    void testGetVatForItems_Luxury() {
        Product product = new Product(4L, "Car", 10000.0, ProductCategory.LUXURY, "Norway");
        List<Product> products = new ArrayList<>();
        products.add(product);

        List<VatResult> results = TaxUtil.getVatForItems(products);

        assertEquals(2, results.size());
        VatResult result1 = results.get(0);
        assertEquals(4, result1.itemId());
        assertEquals(10000.0, result1.price());
        assertEquals("Sales Tax", result1.taxDescription());
        assertEquals(2500.0, result1.taxAmount());

        VatResult result2 = results.get(1);
        assertEquals(4, result2.itemId());
        assertEquals(10000.0, result2.price());
        assertEquals("Luxury Tax", result2.taxDescription());
        assertEquals(500.0, result2.taxAmount());
    }

    @Test
    void testGetVatForItems_Others() {
        Product product = new Product(5L, "Phone", 500.0, ProductCategory.ELECTRONICS, "Norway");
        List<Product> products = new ArrayList<>();
        products.add(product);

        List<VatResult> results = TaxUtil.getVatForItems(products);

        VatResult result = results.get(0);
        assertEquals(5, result.itemId());
        assertEquals(500.0, result.price());
        assertEquals("Sales Tax", result.taxDescription());
        assertEquals(125.0, result.taxAmount());
    }

    @Test
    void testGetVatForItems_Basan() {
        Product product = new Product(5L, "Phone", 500.0, ProductCategory.ELECTRONICS, "Basan");
        List<Product> products = new ArrayList<>();
        products.add(product);

        List<VatResult> results = TaxUtil.getVatForItems(products);

        VatResult result = results.get(0);
        assertEquals(5, result.itemId());
        assertEquals(500.0, result.price());
        assertEquals("Extra Import Tax", result.taxDescription());
        assertEquals(150.0, result.taxAmount());
    }

}