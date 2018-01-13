package org.rio.everlesssdk.carnivor.geo;

import org.rio.everlesssdk.carnivor.geo.cab.GeoCallback;
import org.rio.everlesssdk.carnivor.geo.cab.ListGeoCallback;
import org.rio.everlesssdk.carnivor.geo.res.XRESGeo;
import org.rio.everlesssdk.carnivor.geo.res.XRESListGeo;
import org.rio.everlesssdk.fossile.EVPair;
import org.rio.everlesssdk.wings.EverlessGo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.rio.everlesssdk.fossile.Standarization.BASE_GEO_PATH_URL;
import static org.rio.everlesssdk.fossile.Standarization.BASE_GEO_RADIUS_PATH_URL;

/**
 * Created by rio.chandra.r on 13/01/18.
 */

public class Geo {
    IGeo iGeo;

    public Geo(){

    }

    public void saveLocation(final EVPair body, final GeoCallback callback){
        iGeo = EverlessGo.createService(IGeo.class);
        Call<XRESGeo> call = iGeo.saveLocation(BASE_GEO_PATH_URL, body);
        call.enqueue(new Callback<XRESGeo>() {
            @Override
            public void onResponse(Call<XRESGeo> call, Response<XRESGeo> response) {
                if(response.body() == null) {
                    callback.loadFailed("Error: unknown");
                }else if(response.body().getError()) {
                    callback.loadFailed(response.body().getMessage());
                }else {
                    if (response.body().getData() == null)
                        callback.loadFailed("Error: data undefined");
                    else
                        callback.loaded(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<XRESGeo> call, Throwable t) {
                callback.loadFailed(t.getMessage());
            }
        });
    }

    public void getLocation(final String uuid, final GeoCallback callback){
        iGeo = EverlessGo.createService(IGeo.class);
        Call<XRESGeo> call = iGeo.getLocation(BASE_GEO_PATH_URL, uuid);
        call.enqueue(new Callback<XRESGeo>() {
            @Override
            public void onResponse(Call<XRESGeo> call, Response<XRESGeo> response) {
                if(response.body() == null) {
                    callback.loadFailed("Error: unknown");
                }else if(response.body().getError()) {
                    callback.loadFailed(response.body().getMessage());
                }else {
                    if (response.body().getData() == null)
                        callback.loadFailed("Error: data undefined");
                    else
                        callback.loaded(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<XRESGeo> call, Throwable t) {
                callback.loadFailed(t.getMessage());
            }
        });
    }

    public void getLocationByRadius(final Double radius, final ListGeoCallback callback){
        iGeo = EverlessGo.createService(IGeo.class);
        Call<XRESListGeo> call = iGeo.getLocationByRadius(BASE_GEO_RADIUS_PATH_URL, radius);
        call.enqueue(new Callback<XRESListGeo>() {
            @Override
            public void onResponse(Call<XRESListGeo> call, Response<XRESListGeo> response) {
                if(response.body() == null) {
                    callback.loadFailed("Error: unknown");
                }else if(response.body().getError()) {
                    callback.loadFailed(response.body().getMessage());
                }else {
                    if (response.body().getData() == null)
                        callback.loadFailed("Error: data undefined");
                    else
                        callback.loaded(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<XRESListGeo> call, Throwable t) {
                callback.loadFailed(t.getMessage());
            }
        });
    }
}
