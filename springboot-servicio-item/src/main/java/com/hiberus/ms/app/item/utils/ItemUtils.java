package com.hiberus.ms.app.item.utils;

import com.hiberus.ms.app.item.models.Item;

public class ItemUtils {

    public static Double getTotalAmount(Item item) {
        return item.getProduct().getPrice() * item.getQuantity().doubleValue();
    }

}
