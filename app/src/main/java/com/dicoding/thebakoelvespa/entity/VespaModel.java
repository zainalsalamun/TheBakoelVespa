package com.dicoding.thebakoelvespa.entity;

import java.io.Serializable;

public class VespaModel implements Serializable {
    String title, image, harga, lokasi, share;

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShare () {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }




}
