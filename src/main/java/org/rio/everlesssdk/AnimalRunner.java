package org.rio.everlesssdk;

import android.content.Context;
import android.util.Log;

import org.rio.everlesssdk.carnivor.auth.Auth;
import org.rio.everlesssdk.carnivor.auth.cab.LoginCallback;
import org.rio.everlesssdk.carnivor.collection.Collection;
import org.rio.everlesssdk.carnivor.storage.Storage;
import org.rio.everlesssdk.wings.EverlessCreds;

import static org.rio.everlesssdk.fossile.Standarization.BASE_COLLECTION_PATH_URL;

/**
 * Created by rio.chandra.r on 12/15/17.
 */

public class AnimalRunner {

    private static Context sdkAppContext = null;

    public AnimalRunner() {
    }

    public static void setAppKey(){

    }

    // TODO: bagian ini masih bingung, kalo throw expeption gmn ngasih tau errornya ke developer
    public static void init(String baseUrl, String cKey, String cSecret){
        try {
            EverlessCreds.setCreds(baseUrl, cKey, cSecret);
            Log.e("EVERLESS-INIT", "Success");
        }catch (Exception e){
            Log.e("EVERLESS-INIT", e.getMessage());
        }
    }

    // ****
    // TODO: ALL: pada saat melakukan koneksi masih terdapat try/catch validasi base url, client key, dan secret key
    // ****       ini bisa dibilang semacam jaga-jaga, tapi masih bermasalah dengan metode throw errornyna

    public static class AuthUser{
        public static void login(final String username, final String password, final LoginCallback callback){
            Auth auth = new Auth();
            auth.login(username, password, callback);
        }
    }

    public static class Ref{
        public static Collection collection(final String collectionNames){
            Collection collection = null;
            collection = new Collection(BASE_COLLECTION_PATH_URL + "/" + collectionNames);

            return collection;
        }

        public static Storage storage(){
            Storage storage = null;
            storage = new Storage();

            return storage;
        }
    }

    public static Context getContext(){
        return sdkAppContext;
    }
}
