package com.hoanganhnhan.catalog.datas;

import android.util.Log;

import com.hoanganhnhan.catalog.models.Account;
import com.hoanganhnhan.catalog.models.DetailCart;
import com.hoanganhnhan.catalog.models.Laptop;

import java.util.ArrayList;
import java.util.List;

public class HardData {
//    USE FOR CART - DETAIL CART
    private List<Laptop> listLaptops;
    private List<Account> listAccounts;
    private List<DetailCart> listDetailCarts;

    public HardData() {
    }

    public List<Laptop> getListProduct() {
        String imageLaptop = "https://salt.tikicdn.com/cache/280x280/media/catalog/producttmp/5b/0d/cf/d3c1c4933bfa48ef31a3cab821167016.jpg";
        listLaptops = new ArrayList<>();
        listLaptops.add(new Laptop("Lap1","Laptop Macbook Air M1","Des1",18490000.0,28990000.0,"OS1","CPU","GPU","RAM","Screensolution","HardDisk","Lan1","Wifi1","Communication1","KB1","ScreeSize1","Battery1","Weith1",imageLaptop,"1","1",100));
        listLaptops.add(new Laptop("Lap2","Laptop Macbook Air M2 8GB","Des1",26390000.0,32990000.0,"OS1","CPU","GPU","RAM","Screensolution","HardDisk","Lan1","Wifi1","Communication1","KB1","ScreeSize1","Battery1","Weith1",imageLaptop,"1","1",100));
        listLaptops.add(new Laptop("Lap3","Laptop Macbook Air M2 16GB","Des1",33990000.0,39990000.0,"OS1","CPU","GPU","RAM","Screensolution","HardDisk","Lan1","Wifi1","Communication1","KB1","ScreeSize1","Battery1","Weith1",imageLaptop,"1","1",100));
        listLaptops.add(new Laptop("Lap4","Laptop Macbook Air M2 24GB","Des1",37990000.0,45990000.0,"OS1","CPU","GPU","RAM","Screensolution","HardDisk","Lan1","Wifi1","Communication1","KB1","ScreeSize1","Battery1","Weith1",imageLaptop,"1","1",100));
        listLaptops.add(new Laptop("Lap5","Laptop Macbook Air 13","Des1",23020000.0,28990000.0,"OS1","CPU","GPU","RAM","Screensolution","HardDisk","Lan1","Wifi1","Communication1","KB1","ScreeSize1","Battery1","Weith1",imageLaptop,"1","1",100));
        return listLaptops;
    }

    public List<Account> getListAccounts(){
        listAccounts = new ArrayList<>();
//        Role 0 = client, 1 = admin
        listAccounts.add(new Account("Account1", "hoangtran", "123456", 0, "Tran Viet Hoang", "", "n19dcat033@gmail.com", "0123456789", ""));
        listAccounts.add(new Account("Account2", "tiendoan", "123456", 0, "Doan Hong Tien", "", "n19dcat072@gmail.com", "0123456789", ""));
        listAccounts.add(new Account("Account3", "nhanadmin", "123456", 1, "Hoang Anh Nhan", "", "n19dcat056@gmail.com", "0123456789", ""));
        listAccounts.add(new Account("Account4", "datvo", "123456", 1, "Vo Tien Dat", "", "n19dcat016@gmail.com", "0123456789", ""));
        listAccounts.add(new Account("Account5", "phongnguyen", "123456", 1, "Nguyen Cao Phong", "", "n19dcat060@gmail.com", "0123456789", ""));
        return listAccounts;
    }

    public List<DetailCart> getListDetailCart(String accountId){
        listDetailCarts = new ArrayList<>();
        if (accountId.equals("Account1")) {
            listDetailCarts.add(new DetailCart("Account1", "Lap1", 1));
            listDetailCarts.add(new DetailCart("Account1", "Lap2", 2));
            listDetailCarts.add(new DetailCart("Account1", "Lap3", 1));
        }
        if (accountId.equals("Account2")) {
            Log.d("NoDetailCart","This account has no item on cart");
        }
        if (accountId.isEmpty()){
            Log.d("NoAccount","No account accessed");
        }
        return listDetailCarts;
    }
}
