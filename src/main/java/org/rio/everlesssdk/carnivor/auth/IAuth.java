package org.rio.everlesssdk.carnivor.auth;

import org.rio.everlesssdk.carnivor.auth.req.REQBLogin;
import org.rio.everlesssdk.carnivor.auth.res.XRESLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by rio.chandra.r on 12/15/17.
 */

public interface IAuth {
    @POST("auth/login")
    Call<XRESLogin> login(@Body REQBLogin body);
}
