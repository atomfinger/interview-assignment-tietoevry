package io.github.atomfinger.interview.vat.system.util;

import io.github.atomfinger.interview.vat.system.model.Product;
import io.github.atomfinger.interview.vat.system.model.ProductCategory;
import io.github.atomfinger.interview.vat.system.model.VatResult;

import java.util.ArrayList;
import java.util.List;

public class TaxUtil {

    private TaxUtil() {
    }

    public static List<VatResult> getVatForItems(List<Product> products) {
        List<VatResult> results = new ArrayList<>();
        for (Product product : products) {
            if (product.getImportCountry().equals("Basan")) {
                double tradeWarTax = calculateVatAmount(product.getPrice(), 0.30);
                results.add(new VatResult(product.getId(), product.getPrice(), "Extra Import Tax", tradeWarTax));
            }
            if (product.getType() == ProductCategory.GROCERY) {
                double salesTax = calculateVatAmount(product.getPrice(), 0.25);
                results.add(new VatResult(product.getId(), product.getPrice(), "Sales Tax", salesTax));
                double subsidy = calculateVatAmount(product.getPrice(), -0.10);
                results.add(new VatResult(product.getId(), product.getPrice(), "Subsidy", subsidy));
            } else if (product.getType() == ProductCategory.CLOTHING) {
                double salesTax = calculateVatAmount(product.getPrice(), 0.25);
                results.add(new VatResult(product.getId(), product.getPrice(), "Sales Tax", salesTax));
            } else if (product.getType() == ProductCategory.VEGETABLES || product.getType() == ProductCategory.BOOKS) {
                results.add(new VatResult(product.getId(), product.getPrice(), "Sales Tax", 0));
            } else if (product.getType() == ProductCategory.LUXURY) {
                double salesTax = calculateVatAmount(product.getPrice(), 0.25);
                double luxuryTax = product.getPrice() >= 5000 ? calculateVatAmount(product.getPrice(), 0.05) : 0;
                results.add(new VatResult(product.getId(), product.getPrice(), "Sales Tax", salesTax));
                results.add(new VatResult(product.getId(), product.getPrice(), "Luxury Tax", luxuryTax));
            } else {
                double salesTax = calculateVatAmount(product.getPrice(), 0.25);
                results.add(new VatResult(product.getId(), product.getPrice(), "Sales Tax", salesTax));
            }
        }
        return results;
    }

    private static double calculateVatAmount(double price, double tax) {
        return Math.ceil(price * tax);
    }
}
