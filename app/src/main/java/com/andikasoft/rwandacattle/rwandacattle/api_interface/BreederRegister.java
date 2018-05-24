package com.andikasoft.rwandacattle.rwandacattle.api_interface;

import com.andikasoft.rwandacattle.rwandacattle.api_helper.Register;
import com.andikasoft.rwandacattle.rwandacattle.api_helper.Token;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface BreederRegister {
    @POST("registerbreeder")
    Call<Token> register(@Body Register register);
}
