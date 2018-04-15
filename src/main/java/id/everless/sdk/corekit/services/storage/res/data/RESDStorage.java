package id.everless.sdk.corekit.services.storage.res.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class RESDStorage implements Serializable, Parcelable
{

    @SerializedName("location")
    @Expose
    private String location;
    public final static Creator<RESDStorage> CREATOR = new Creator<RESDStorage>() {


        @SuppressWarnings({
                "unchecked"
        })
        public RESDStorage createFromParcel(Parcel in) {
            return new RESDStorage(in);
        }

        public RESDStorage[] newArray(int size) {
            return (new RESDStorage[size]);
        }

    }
            ;
    private final static long serialVersionUID = -5381148794060048594L;

    protected RESDStorage(Parcel in) {
        this.location = ((String) in.readValue((String.class.getClassLoader())));
    }

    public RESDStorage() {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("location", location).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(location).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RESDStorage) == false) {
            return false;
        }
        RESDStorage rhs = ((RESDStorage) other);
        return new EqualsBuilder().append(location, rhs.location).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(location);
    }

    public int describeContents() {
        return 0;
    }

}