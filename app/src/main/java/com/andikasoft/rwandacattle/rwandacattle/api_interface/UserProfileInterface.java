package com.andikasoft.rwandacattle.rwandacattle.api_interface;

import com.andikasoft.rwandacattle.rwandacattle.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface UserProfileInterface {
    @GET("profile")
    Call<User> getUserProfile(@Header("Authorization") String token);
}
