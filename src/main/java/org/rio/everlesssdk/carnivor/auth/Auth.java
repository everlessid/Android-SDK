package org.rio.everlesssdk.carnivor.auth;

import org.rio.everlesssdk.carnivor.auth.cab.LoginCallback;
import org.rio.everlesssdk.carnivor.auth.req.REQBLogin;
import org.rio.everlesssdk.carnivor.auth.res.XRESLogin;
import org.rio.everlesssdk.wings.EverlessGo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rio.chandra.r on 12/15/17.
 */

public class Auth {
    IAuth iAuth;

    public Auth(){
        iAuth = EverlessGo.createService(IAuth.class);
    }

    public void login(final String username, final String password, final LoginCallback callback){
        Call<XRESLogin> call = iAuth.login(new REQBLogin(username, password));
        call.enqueue(new Callback<XRESLogin>() {
            @Override
            public void onResponse(Call<XRESLogin> call, Response<XRESLogin> response) {
                if(response.body() == null) {
                    callback.failure("Error: unknown");
                }else if(response.body().getError()) {
                    callback.failure(response.body().getMessage());
                }else {
                    if (response.body().getData() == null)
                        callback.failure("Error: data undefined");
                    else
                        callback.success(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<XRESLogin> call, Throwable t) {

            }
        });
    }
}
