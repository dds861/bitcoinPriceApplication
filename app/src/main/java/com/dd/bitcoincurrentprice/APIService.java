package com.dd.bitcoincurrentprice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIService {
    @GET("v1/bpi/currentprice.json")
    Call<User> getUserData();

    @GET("v1/bpi/supported-currencies.json")
    Call<List<UserCurrencies>> getUserData2();

    @GET("v1/bpi/currentprice/{currency}")
    Call<UserCurrencies> getUserData2(@Path("currency") String currency);
}