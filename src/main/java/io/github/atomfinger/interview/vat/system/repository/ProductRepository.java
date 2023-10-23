package io.github.atomfinger.interview.vat.system.repository;

import io.github.atomfinger.interview.vat.system.model.Product;
import org.jeasy.random.EasyRandom;

/**
 * This is a dummy repository that returns a random item
 * <p>
 * This is out of scope for this exercise.
 */
public class ProductRepository {

    public Product getItemById(Long itemId) {
        var item = new EasyRandom().nextObject(Product.class);
        item.setId(itemId);
        return item;
    }
}
