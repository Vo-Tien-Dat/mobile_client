package com.hoanganhnhan.catalog.api;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.hoanganhnhan.catalog.interfaces.OnListenerCart;
import com.hoanganhnhan.catalog.models.Laptop;

import java.util.ArrayList;
import java.util.List;

public class CartApi {

    private final static String KEY_CART_ENTITY = "carts";

    private final static StorageReference cartStorage = FirebaseStorage.getInstance().getReference().getStorage().getReference(KEY_CART_ENTITY);

    private final  static DatabaseReference cartDatabase = FirebaseDatabase.getInstance().getReference(KEY_CART_ENTITY);

    public static void readCarts(String accountID, ValueEventListener valueEventListener){
        cartDatabase.child(accountID).addValueEventListener(valueEventListener);
    }


}
