package org.rio.everlesssdk.eater;

/**
 * Created by rio.chandra.r on 12/15/17.
 */

public interface GETCallback<T> {
    void loaded(T data);
    void dataNotAvailable();
    void loadFailed(String errorMessage);
}
