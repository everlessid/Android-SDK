package org.rio.everlesssdk.carnivor.storage;

import android.util.Log;

import org.rio.everlesssdk.carnivor.storage.cab.StorageCallback;
import org.rio.everlesssdk.carnivor.storage.res.XRESStorage;
import org.rio.everlesssdk.wings.EverlessGo;

import java.io.File;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rio.chandra.r on 12/18/17.
 */

public class Storage {
    IStorage iStorage;

    public Storage() {
    }

    public void getFileURL(final String fileName, final StorageCallback callback){
        Call<XRESStorage> call = iStorage.getFileURL("", fileName); // TODO: ganti dengan path storage
        call.enqueue(new Callback<XRESStorage>() {
            @Override
            public void onResponse(Call<XRESStorage> call, Response<XRESStorage> response) {
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
            public void onFailure(Call<XRESStorage> call, Throwable t) {
                callback.failure(t.getMessage());
            }
        });
    }


    public void delete(final String fileName, final StorageCallback callback){
        Call<XRESStorage> call = iStorage.delete("", fileName); // TODO: ganti dengan path storage
        call.enqueue(new Callback<XRESStorage>() {
            @Override
            public void onResponse(Call<XRESStorage> call, Response<XRESStorage> response) {
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
            public void onFailure(Call<XRESStorage> call, Throwable t) {
                callback.failure(t.getMessage());
            }
        });
    }

    public void upload(final String fileName, final File file, final StorageCallback callback){
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", fileName, RequestBody.create(null, file));
        iStorage = EverlessGo.createService(IStorage.class);
        if(iStorage == null) {
            Log.d("NULLX", "null---");
            return;
        }
        Call<XRESStorage> call = iStorage.upload("upload", filePart);
        call.enqueue(new Callback<XRESStorage>() {
            @Override
            public void onResponse(Call<XRESStorage> call, Response<XRESStorage> response) {
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
            public void onFailure(Call<XRESStorage> call, Throwable t) {
                callback.failure(t.getMessage());
            }
        });
    }
}
