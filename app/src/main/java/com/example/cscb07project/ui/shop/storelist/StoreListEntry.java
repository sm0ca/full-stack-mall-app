package com.example.cscb07project.ui.shop.storelist;

import androidx.annotation.NonNull;

import java.util.Objects;

public class StoreListEntry {

    private String storeName;
    private String logo;

    public StoreListEntry(String storeName) {
        this.storeName = storeName;
    }

    public StoreListEntry(String storeName, String imageURL) {
        this.storeName = storeName;
        this.logo = imageURL;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreListEntry that = (StoreListEntry) o;
        return storeName.equals(that.storeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeName);
    }

    @NonNull
    @Override
    public String toString() {
        return storeName;
    }


}
