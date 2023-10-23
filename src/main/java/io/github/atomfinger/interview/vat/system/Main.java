package io.github.atomfinger.interview.vat.system;

import io.github.atomfinger.interview.vat.system.repository.ProductRepository;
import io.github.atomfinger.interview.vat.system.service.ProductService;

public class Main {

    public static void main(String[] args) {
        var repository = new ProductRepository();
        var service = new ProductService(repository);
        System.out.println(service.getVatForProduct(1L).toString());
    }
}
