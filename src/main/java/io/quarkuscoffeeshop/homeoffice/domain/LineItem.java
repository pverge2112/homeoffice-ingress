package io.quarkuscoffeeshop.homeoffice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.StringJoiner;


public class LineItem {

    private Item item;

    private String name;

    @JsonIgnore
    Order order;

    public LineItem() {
    }

    public LineItem(Item item, String name) {
        this.item = item;
        this.name = name;
    }

    public LineItem(Item item, String name, Order order) {
        this.item = item;
        this.name = name;
        this.order = order;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LineItem.class.getSimpleName() + "[", "]")
                .add("item=" + item)
                .add("name='" + name + "'")
                .add("order=" + order.getOrderId())
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LineItem lineItem = (LineItem) o;

        if (item != lineItem.item) return false;
        if (name != null ? !name.equals(lineItem.name) : lineItem.name != null) return false;
        return order != null ? order.equals(lineItem.order) : lineItem.order == null;
    }

    @Override
    public int hashCode() {
        int result = item != null ? item.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        return result;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
