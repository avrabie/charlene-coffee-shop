package org.charnele.shop.model.beaverages;

import org.charnele.shop.model.beaverages.size.Size;
import org.charnele.shop.model.food.items.Spices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TeaTest {

    Tea magicTea = new Tea("magic herbal tea", Size.SMALL, price -> price * 2); // we want the magic tea to be +100% of normal price, because it's magical

    @Test
    public void magicTeaTest() {
        magicTea.withExtras(new Spices());
        Assertions.assertEquals(6.0, magicTea.getPrice()); // small is 2.5 and spices is an extra 1
        Assertions.assertEquals("small magic herbal tea with extras: spices", magicTea.getDescription());  // amazing :))

    }

}