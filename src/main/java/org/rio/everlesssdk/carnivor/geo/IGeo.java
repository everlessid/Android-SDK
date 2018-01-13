package org.rio.everlesssdk.carnivor.geo;

import org.rio.everlesssdk.carnivor.collection.res.XRESCollection;
import org.rio.everlesssdk.carnivor.geo.res.XRESGeo;
import org.rio.everlesssdk.carnivor.geo.res.XRESListGeo;
import org.rio.everlesssdk.fossile.EVPair;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Url;

/**
 * Created by rio.chandra.r on 13/01/18.
 */

public interface IGeo {

    @POST
    Call<XRESGeo> saveLocation(@Url String url, @Body EVPair body);

    @GET
    Call<XRESGeo> getLocation(@Url String url, final String uuid);

    @GET
    Call<XRESListGeo> getLocationByRadius(@Url String url, final Double radius);
}
