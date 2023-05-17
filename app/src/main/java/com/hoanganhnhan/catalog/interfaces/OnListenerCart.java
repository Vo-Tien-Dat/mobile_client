package com.hoanganhnhan.catalog.interfaces;

import androidx.annotation.NonNull;

import com.google.firebase.database.DatabaseError;

import java.util.List;

public interface OnListenerCart {
    public void onSuccess(List<String> keys);

    public void onFailed(@NonNull DatabaseError errors);
}
