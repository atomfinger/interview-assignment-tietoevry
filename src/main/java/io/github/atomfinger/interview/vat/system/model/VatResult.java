package io.github.atomfinger.interview.vat.system.model;

public record VatResult(Long itemId, double price, String taxDescription, double taxAmount) {

    @Override
    public String toString() {
        return "VatResult{" +
               "itemId=" + itemId +
               ", price=" + price +
               ", taxDescription='" + taxDescription + '\'' +
               ", taxAmount=" + taxAmount +
               '}';
    }
}
