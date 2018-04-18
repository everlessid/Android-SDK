package id.everless.sdk.corekit.services.storage;

import id.everless.sdk.corekit.services.storage.res.XRESStorage;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by rio.chandra.r on 12/18/17.
 */

public interface IStorage {

    @Multipart
    @POST
    Call<XRESStorage> upload(@Url String url, @Part MultipartBody.Part file);

    @GET
    Call<XRESStorage> getFileURL(@Url String url, @Query("uuid") String filename);

    @GET
    Call<ResponseBody> getFileBinary(@Url String fileUrl);

    @DELETE
    Call<XRESStorage> delete(@Url String url, @Query("uuid") String filename);
}
