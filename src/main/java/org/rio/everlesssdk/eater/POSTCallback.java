package org.rio.everlesssdk.eater;

/**
 * Created by rio.chandra.r on 12/15/17.
 */

public interface POSTCallback<T> {
    void success(T data);
    void failure(String errorMessage);
}
