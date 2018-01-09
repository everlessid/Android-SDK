package org.rio.everlesssdk.wings;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.rio.everlesssdk.fossile.Standarization.GSON_DATE_FORMAT;

/**
 * Created by rio.chandra.r on 12/15/17.
 */

public class EverlessGo {

    private static Gson mGson = new GsonBuilder()
            .setDateFormat(GSON_DATE_FORMAT)
            .create();

    public static Retrofit.Builder getBuilder(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(mGson));
    }

    private static Retrofit retrofit;
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private static HttpLoggingInterceptor logging = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);

    public static Interceptor getClientSecretAndKeyInterception(final String cKey, final String cSecret){
        return new Interceptor(){
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("everless-k", cKey)
                        .addHeader("everless-sk", cSecret).build();
                return chain.proceed(request);
            }
        };
    }

    public static <S> S createService(Class<S> serviceClass){
        if (!httpClient.interceptors().contains(logging)) {
            EverlessCreds.CredentialModel emc = null;
            try {
                emc = EverlessCreds.getCreds();
                Log.d("GETCREDS", String.valueOf(emc == null));
                httpClient.addInterceptor(logging);
                Log.d("GETCREDS", String.valueOf(0));
                httpClient.addInterceptor(getClientSecretAndKeyInterception(emc.clientKey, emc.clientSecret));
                Log.d("GETCREDS", String.valueOf(1));
                Retrofit.Builder builder = getBuilder(emc.baseUrl);
                Log.d("GETCREDS", String.valueOf(2));
                builder.client(httpClient.build());
                Log.d("GETCREDS", String.valueOf(3));
                retrofit = builder.build();
                Log.d("GETCREDS", String.valueOf(4));
                Log.d("GETCREDS", "baseurl: " + emc.baseUrl);
                Log.d("GETCREDS", "clientKey: " + emc.clientKey);
                Log.d("GETCREDS", "clientSecret: " + emc.clientSecret);
                Log.d("GETCREDS", "is Retrofit null? => " + String.valueOf(retrofit == null));
                Log.d("GETCREDS", "is Service Interface null? => " + String.valueOf(serviceClass == null));

                return retrofit.create(serviceClass);
            } catch (Exception e) {
                Log.e("CREDENTIAL-ISSUE", "Credential belum di set: " + e.getMessage());
                e.printStackTrace();
            }
        }

        return null;
    }
}
