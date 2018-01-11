package org.rio.everlesssdk.carnivor.storage;

import org.rio.everlesssdk.carnivor.storage.res.XRESStorage;

import okhttp3.MultipartBody;
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
    Call<XRESStorage> getFileURL(@Url String url, @Query("filename") String filename);

    @DELETE
    Call<XRESStorage> delete(@Url String url, @Query("filename") String filename);
}
