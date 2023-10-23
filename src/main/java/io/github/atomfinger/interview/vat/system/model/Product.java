package io.github.atomfinger.interview.vat.system.model;

public class Product {

    private Long id;
    private final String description;
    private final double price;
    private final ProductCategory type;
    private final String importCountry;

    public Product(Long id, String description, double price, ProductCategory type, String importCountry) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.type = type;
        this.importCountry = importCountry;
    }

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public ProductCategory getType() {
        return type;
    }

    public void setId(Long itemId) {
        this.id = itemId;
    }

    public String getDescription() {
        return description;
    }

    public String getImportCountry() {
        return importCountry;
    }
}
