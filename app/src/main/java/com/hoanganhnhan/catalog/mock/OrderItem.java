package com.hoanganhnhan.catalog.mock;

import com.hoanganhnhan.catalog.R;
import com.hoanganhnhan.catalog.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {

    private static List<Order> lOrder;
    public static List<Order> getOrders(){
        lOrder = new ArrayList<>();

        lOrder.add(new Order("maDon1", "23:45 21-04-2023", "97 Man Thiện, Hiệp Phú, Quận 9", 10000000, R.drawable.ic_home, 1));
        lOrder.add(new Order("maDon2", "23:45 21-04-2023", "97 Man Thiện, Hiệp Phú, Quận 9", 16030500, R.drawable.ic_home, 1));
        lOrder.add(new Order("maDon3", "23:45 21-04-2023", "97 Man Thiện, Hiệp Phú, Quận 9", 13434342, R.drawable.ic_home, 2));
        lOrder.add(new Order("maDon4", "23:45 21-04-2023", "97 Man Thiện, Hiệp Phú, Quận 9", 1123456, R.drawable.ic_home, 1));
        lOrder.add(new Order("maDon5", "23:45 21-04-2023", "97 Man Thiện, Hiệp Phú, Quận 9", 200000, R.drawable.ic_home, 1));
        lOrder.add(new Order("maDon6", "23:45 21-04-2023", "97 Man Thiện, Hiệp Phú, Quận 9", 9020000, R.drawable.ic_home, 2));
        lOrder.add(new Order("maDon7", "23:45 21-04-2023", "97 Man Thiện, Hiệp Phú, Quận 9", 1300000, R.drawable.ic_home, 1));
        lOrder.add(new Order("maDon8", "23:45 21-04-2023", "97 Man Thiện, Hiệp Phú, Quận 9", 20000000, R.drawable.ic_home, 1));
        return lOrder; 
    }

    public static Order getOrderFromOrderID(String orderID){
        Order orderItem = null;
        for(Order order: lOrder){
            if(order.getMaDonHang().equals(orderID)){
                orderItem = order;
                break;
            }
        }
        return orderItem;
    }
}
