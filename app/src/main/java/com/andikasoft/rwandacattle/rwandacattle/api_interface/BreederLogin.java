package com.andikasoft.rwandacattle.rwandacattle.api_interface;

import com.andikasoft.rwandacattle.rwandacattle.api_helper.Login;
import com.andikasoft.rwandacattle.rwandacattle.api_helper.Token;
import com.andikasoft.rwandacattle.rwandacattle.model.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface BreederLogin {
    @Headers("Accept:application/json")

    @POST("login")
    Call<Token> login(@Body Login login);

    @GET("profile")
    Call<ResponseBody> getSecret(@Header("Authorization") String authToken);
}
