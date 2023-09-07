package com.example.mentalpeaceapp.data.models;


import android.graphics.drawable.Drawable;

public final class Quote {
    private Drawable img;
    private String quoteText;

    public Quote(Drawable img,String quoteText){
        setImg(img);
        setQuoteText(quoteText);
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }
}
