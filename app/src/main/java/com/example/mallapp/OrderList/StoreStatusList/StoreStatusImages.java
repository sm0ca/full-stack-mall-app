package com.example.mallapp.OrderList.StoreStatusList;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.mallapp.OrderList.DataHolder.ABOrderImage;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StoreStatusImages {

    private final ABOrderImage dataHolder;
    private final DatabaseReference queryImage;
    private final ValueEventListener listener;
    private final IFStoreStatusPresenter presenter;

    public StoreStatusImages(ABOrderImage dataHolder, String pathToImage, String databaseURL, IFStoreStatusPresenter presenter) {
        this.dataHolder = dataHolder;
        this.presenter = presenter;
        FirebaseDatabase db = FirebaseDatabase.getInstance(databaseURL);
        queryImage = db.getReference(pathToImage);
        listener = queryImage.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                updateImageURL(snapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("mine", "Err listening: " + error);
                removeListener();
            }
        });
    }

    public void updateImageURL(String imageURL) {
        dataHolder.setImageURL(imageURL);
        presenter.notifyAdapterDataChanged();
    }

    public void removeListener() {
        if (listener != null) {
            queryImage.removeEventListener(listener);
        }
    }

}
