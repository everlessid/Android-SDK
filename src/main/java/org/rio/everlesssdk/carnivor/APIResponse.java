package org.rio.everlesssdk.carnivor;

import com.google.gson.annotationsg.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by lifeuniverse on 15/05/17.
 */

public class APIResponse<T> {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("data")
    @Expose
    private T data = null;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("message")
    @Expose
    private String message;

    private final static long serialVersionUID = -9039540148675826580L;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public APIResponse withError(Boolean error) {
        this.error = error;
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public APIResponse withData(T data) {
        this.data = data;
        return this;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public APIResponse withCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public APIResponse withMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(error).append(data).append(code).append(message).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof APIResponse) == false) {
            return false;
        }
        APIResponse rhs = ((APIResponse) other);
        return new EqualsBuilder().append(error, rhs.error).append(data, rhs.data).append(code, rhs.code).append(message, rhs.message).isEquals();
    }

    public int describeContents() {
        return 0;
    }
}

