package org.rio.everlesssdk.carnivor.collection;

import org.rio.everlesssdk.carnivor.collection.cab.CollectionCallback;
import org.rio.everlesssdk.carnivor.collection.res.XRESCollection;
import org.rio.everlesssdk.fossile.EVPair;
import org.rio.everlesssdk.wings.EverlessGo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rio.chandra.r on 12/16/17.
 */

public class Collection {
    ICollection iCollection;
    Collection _child;
    String childUrl;

    public Collection(String url){
        childUrl = url;
    }

    public Collection child(String url){
        _child = new Collection(childUrl + "/" + url);

        return _child;
    }

    public void create(final EVPair body, final CollectionCallback callback){
        iCollection = EverlessGo.createService(ICollection.class);
        Call<XRESCollection> call = iCollection.create(childUrl, body);
        call.enqueue(new Callback<XRESCollection>() {
            @Override
            public void onResponse(Call<XRESCollection> call, Response<XRESCollection> response) {
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
            public void onFailure(Call<XRESCollection> call, Throwable t) {
                callback.loadFailed(t.getMessage());
            }
        });
    }

    public void create(final String id, final EVPair body, final CollectionCallback callback){
        iCollection = EverlessGo.createService(ICollection.class);
        body.put("_id", id);
        Call<XRESCollection> call = iCollection.create(childUrl, body);
        call.enqueue(new Callback<XRESCollection>() {
            @Override
            public void onResponse(Call<XRESCollection> call, Response<XRESCollection> response) {
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
            public void onFailure(Call<XRESCollection> call, Throwable t) {
                callback.loadFailed(t.getMessage());
            }
        });
    }

    public void retrieve(final CollectionCallback callback){
        iCollection = EverlessGo.createService(ICollection.class);
        Call<XRESCollection> call = iCollection.retrieve(childUrl);
        call.enqueue(new Callback<XRESCollection>() {
            @Override
            public void onResponse(Call<XRESCollection> call, Response<XRESCollection> response) {
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
            public void onFailure(Call<XRESCollection> call, Throwable t) {
                callback.loadFailed(t.getMessage());
            }
        });
    }

    public void update(final EVPair body, final CollectionCallback callback){
        iCollection = EverlessGo.createService(ICollection.class);
        Call<XRESCollection> call = iCollection.update(childUrl, body);
        call.enqueue(new Callback<XRESCollection>() {
            @Override
            public void onResponse(Call<XRESCollection> call, Response<XRESCollection> response) {
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
            public void onFailure(Call<XRESCollection> call, Throwable t) {
                callback.loadFailed(t.getMessage());
            }
        });
    }

    public void update(final String id, final EVPair body, final CollectionCallback callback){
        iCollection = EverlessGo.createService(ICollection.class);
        body.put("_id", id);
        Call<XRESCollection> call = iCollection.update(childUrl, body);
        call.enqueue(new Callback<XRESCollection>() {
            @Override
            public void onResponse(Call<XRESCollection> call, Response<XRESCollection> response) {
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
            public void onFailure(Call<XRESCollection> call, Throwable t) {
                callback.loadFailed(t.getMessage());
            }
        });
    }

    public void delete(final CollectionCallback callback){
        iCollection = EverlessGo.createService(ICollection.class);
        Call<XRESCollection> call = iCollection.delete(childUrl);
        call.enqueue(new Callback<XRESCollection>() {
            @Override
            public void onResponse(Call<XRESCollection> call, Response<XRESCollection> response) {
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
            public void onFailure(Call<XRESCollection> call, Throwable t) {
                callback.loadFailed(t.getMessage());
            }
        });
    }
}
