package com.hoanganhnhan.catalog.utilize;

import java.text.NumberFormat;
import java.util.Locale;

public class MoneyFormat {
    public double money;

    public MoneyFormat(double money) {
        this.money = money;
    }

    public String toVND() {
        Locale locale = new Locale("vi", "VN");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        return format.format(money);
    }
}
