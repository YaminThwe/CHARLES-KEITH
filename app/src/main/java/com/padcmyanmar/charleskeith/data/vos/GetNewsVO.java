package com.padcmyanmar.charleskeith.data.vos;

import com.google.gson.annotations.SerializedName;

public class GetNewsVO
{
    @SerializedName("product-id")
    private int productId;
    @SerializedName("product-image")
    private String productImage;
    @SerializedName("product-title")
    private String productTitl;



    public int getProductId() {
        return productId;
    }

    public String getProductImage() {
        return productImage;
    }

    public String getProductTitl() {
        return productTitl;
    }
}
