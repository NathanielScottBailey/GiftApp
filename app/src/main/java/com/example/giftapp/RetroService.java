package com.example.giftapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetroService {
    @GET("motd")
    Call<List<ServerMessage>> getMOTD();
}
