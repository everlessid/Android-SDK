package id.everless.sdk.corekit.commons;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import id.everless.sdk.corekit.EverlessSDK;

import static id.everless.sdk.corekit.utils.Standarization.PREFERENCES_CODE_APP;
import static id.everless.sdk.corekit.utils.Standarization.PREFERENCES_CONSTANT_KEY;
import static id.everless.sdk.corekit.utils.Standarization.PREFERENCES_CONSTANT_SECRET_KEY;

/**
 * Created by rio.chandra.r on 12/15/17.
 */

public class EverlessPreferences {
    public static void setPreferences(Context context, String key, String value){
        if(context == null)
            return;

        SharedPreferences sharedpreferences = context.getSharedPreferences(
                PREFERENCES_CODE_APP, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void setPreferences(Activity act, String key, String value){
        if(act == null)
            return;

        SharedPreferences sharedpreferences = act.getSharedPreferences(
                PREFERENCES_CODE_APP, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String readPreferences(Context context, String key){
        if(context == null)
            return null;

        SharedPreferences sharedpreferences = context.getSharedPreferences(
                PREFERENCES_CODE_APP, Context.MODE_PRIVATE);
        return sharedpreferences.getString(key, null);
    }

    public static String readPreferences(Activity act, String key){
        if(act == null)
            return null;

        SharedPreferences sharedpreferences = act.getSharedPreferences(
                PREFERENCES_CODE_APP, Activity.MODE_PRIVATE);
        return sharedpreferences.getString(key, null);
    }

    public static String getAppKey(){
        return readPreferences(EverlessSDK.getContext(), PREFERENCES_CONSTANT_KEY);
    }

    public static String getAppSecretKey(){
        return readPreferences(EverlessSDK.getContext(), PREFERENCES_CONSTANT_SECRET_KEY);
    }
}
