package org.rio.everlesssdk.carnivor.storage;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.rio.everlesssdk.carnivor.storage.cab.StorageCallback;
import org.rio.everlesssdk.carnivor.storage.res.XRESStorage;
import org.rio.everlesssdk.carnivor.storage.util.FileUtils;
import org.rio.everlesssdk.wings.EverlessGo;

import java.io.File;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.rio.everlesssdk.carnivor.storage.util.FileUtils.writeResponseBodyToDisk;
import static org.rio.everlesssdk.fossile.Standarization.BASE_STORAGE_UPLOAD_PATH_URL;

/**
 * Created by rio.chandra.r on 12/18/17.
 */

public class Storage {
    IStorage iStorage;

    public Storage() {
    }

    public void getFileURL(final String uuid, final StorageCallback callback){
        iStorage = EverlessGo.createService(IStorage.class);
        Call<XRESStorage> call = iStorage.getFileURL(BASE_STORAGE_UPLOAD_PATH_URL, uuid); // TODO: ganti dengan path storage
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

    public void directDownloadFile(final Context context, final String fileUrl) throws Exception{
        Toast.makeText(context, "Download started", Toast.LENGTH_SHORT).show();
        FileUtils.startDownload(context, fileUrl);
    }

    private void getFileBinary(final Context context, final String fileUrl, final StorageCallback callback){
        iStorage = EverlessGo.createService(IStorage.class);
        Call<ResponseBody> call = iStorage.getFileBinary(fileUrl);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Log.d("EVERLESS_GF", "server contacted and has file");
                    String fileName = fileUrl.substring(fileUrl.lastIndexOf('/') + 1);
                    String fileDestDirName = context.getExternalFilesDir(null) + File.separator + fileName;
                    boolean writtenToDisk = writeResponseBodyToDisk(fileDestDirName, response.body());
                    Log.d("EVERLESS_GF", "file download was a success? " + String.valueOf(writtenToDisk));
                } else {
                    Log.d("EVERLESS_GF", "server contact failed");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("EVERLESS_GF", "error");
            }
        });
    }

    public void delete(final String fileName, final StorageCallback callback){
        iStorage = EverlessGo.createService(IStorage.class);
        Call<XRESStorage> call = iStorage.delete(BASE_STORAGE_UPLOAD_PATH_URL, fileName); // TODO: ganti dengan path storage
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
        Call<XRESStorage> call = iStorage.upload(BASE_STORAGE_UPLOAD_PATH_URL, filePart);
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

    // upload variation
    public void upload(final File file, final StorageCallback callback){
        upload(file.getName(), file, callback);
    }
}
