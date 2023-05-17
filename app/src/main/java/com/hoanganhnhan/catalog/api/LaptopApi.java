package com.hoanganhnhan.catalog.api;

import android.net.Uri;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.hoanganhnhan.catalog.interfaces.OnListener;
import com.hoanganhnhan.catalog.models.Laptop;

import java.util.List;
import java.util.UUID;

public class LaptopApi {

    private final static String KEY_LAPTOP_DATABASE = "laptops";
    
    private final static String KEY_LAPTOP_STORAGE = "laptops"; 

    private final static StorageReference laptopStorage = FirebaseStorage.getInstance().getReference().getStorage().getReference("laptops");

    private final static DatabaseReference laptopDatabase = FirebaseDatabase.getInstance().getReference("laptops");

    private final  DatabaseReference laptopDatabaseMulti = FirebaseDatabase.getInstance().getReference("laptops");

    public static void readLaptop(String laptopID, ValueEventListener valueEventListener){
        laptopDatabase.child(laptopID).addValueEventListener(valueEventListener);
    }


    public static void writeNewImages(String folderName, List<Uri> images, OnListener onListener){
        int loadingImageSuccess = 0 ;
        for(int i = 0 ; i < images.size(); ++i){
            String imageID = UUID.randomUUID().toString();
            Uri imageUri = images.get(i);
            laptopStorage.child(folderName).child(imageID).putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    if(onListener != null){
                        onListener.OnFailedListener();
                    }
                }
            });
        }
    }

    public static void writeNewLaptop(Laptop laptop, OnListener onListener){
        String laptopID = laptop.getLaptopID();
        laptopDatabase.child(laptopID).setValue(laptop).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                if(onListener != null){
                    onListener.OnSuccessListener();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if(onListener != null){
                    onListener.OnFailedListener();
                }
            }
        });
    }

    private Boolean writeImages(List<Uri> images){
        return false;
    }

     public static void deleteLaptopByIDFromDatabase(String laptopID, OnListener onListener){
        laptopDatabase.child(laptopID).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                if(onListener != null){
                    onListener.OnSuccessListener();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if(onListener != null){
                    onListener.OnFailedListener();
                }
            }
        });
    }
    private void deleteLaptopIDStorage(String folderName, OnListener onListener){
        laptopStorage.child(folderName).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                if(onListener != null){
                    onListener.OnSuccessListener();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if(onListener != null){
                    onListener.OnFailedListener();
                }
            }
        });
    }
}
