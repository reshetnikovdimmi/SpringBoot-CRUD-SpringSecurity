package com.spark.spark.responses;

import com.spark.spark.security.ShopDetailsImpl;

public class AuthResponse {

    private ShopDetailsImpl shopDetails;
    private String token;
    public AuthResponse(){

    }


    public AuthResponse(String token, ShopDetailsImpl shopDetails){
        this.token = token;
        this.shopDetails = shopDetails;
    }

    public Long getUserId(){
        return this.shopDetails.getUserId();
    }

    public String getUsername(){

        return this.shopDetails.getUsername();
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
