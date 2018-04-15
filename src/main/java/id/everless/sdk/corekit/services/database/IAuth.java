package id.everless.sdk.corekit.services.database;

import id.everless.sdk.corekit.services.database.req.REQBLogin;
import id.everless.sdk.corekit.services.database.res.XRESLogin;
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
