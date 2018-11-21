package com.example.a300985590.ttcpay.model;

import java.util.ArrayList;

public class ShoppingCart {

    public int cartId;

    public ArrayList<Items> items;

    public int cartOwner;


    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }

    public int getCartOwner() {
        return cartOwner;
    }

    public void setCartOwner(int cartOwner) {
        this.cartOwner = cartOwner;
    }
}
