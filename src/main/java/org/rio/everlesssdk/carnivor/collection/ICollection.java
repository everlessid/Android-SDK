package org.rio.everlesssdk.carnivor.collection;

import org.rio.everlesssdk.carnivor.collection.res.XRESCollection;
import org.rio.everlesssdk.fossile.EVPair;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Url;

/**
 * Created by rio.chandra.r on 12/16/17.
 */

public interface ICollection {

    @POST
    Call<XRESCollection> create(@Url String url, @Body EVPair body);

    @GET
    Call<XRESCollection> retrieve(@Url String url);

    @PUT
    Call<XRESCollection> update(@Url String url, @Body EVPair body);

    @DELETE
    Call<XRESCollection> delete(@Url String url);
}
