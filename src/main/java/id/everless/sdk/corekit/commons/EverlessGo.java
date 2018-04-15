package id.everless.sdk.corekit.commons;

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

import static id.everless.sdk.corekit.utils.Standarization.GSON_DATE_FORMAT;

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
                        .addHeader("everless.everless-k", cKey)
                        .addHeader("everless.everless-sk", cSecret).build();
                return chain.proceed(request);
            }
        };
    }

    public static <S> S createService(Class<S> serviceClass){
        try {
            EverlessCreds.CredentialModel emc = null;
            emc = EverlessCreds.getCreds();

            Retrofit.Builder builder = getBuilder(emc.baseUrl);
            builder.client(httpClient.build());

            if (!httpClient.interceptors().contains(logging)) {
                httpClient.addInterceptor(logging);
                httpClient.addInterceptor(getClientSecretAndKeyInterception(emc.clientKey, emc.clientSecret));
            }

            retrofit = builder.build();
            Log.d("GETCREDS", "baseurl: " + emc.baseUrl);
            Log.d("GETCREDS", "clientKey: " + emc.clientKey);
            Log.d("GETCREDS", "clientSecret: " + emc.clientSecret);
            Log.d("GETCREDS", "is Retrofit null? => " + String.valueOf(retrofit == null));
            Log.d("GETCREDS", "is Service Interface null? => " + String.valueOf(serviceClass == null));

            return retrofit.create(serviceClass);

        } catch (Exception e) {
            Log.e("CREDENTIAL-ISSUE", "Credential belum di set: " + e.getMessage());
            e.printStackTrace();

            return null;
        }
    }
}
