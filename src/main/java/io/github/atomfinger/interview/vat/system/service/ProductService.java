package io.github.atomfinger.interview.vat.system.service;

import io.github.atomfinger.interview.vat.system.util.TaxUtil;
import io.github.atomfinger.interview.vat.system.model.VatResult;
import io.github.atomfinger.interview.vat.system.repository.ProductRepository;

import java.util.List;

public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<VatResult> getVatForProduct(Long itemId) {
        var item = repository.getItemById(itemId);
        return TaxUtil.getVatForItems(List.of(item));
    }
}
