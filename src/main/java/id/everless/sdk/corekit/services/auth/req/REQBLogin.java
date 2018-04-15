package id.everless.sdk.corekit.services.auth.req;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class REQBLogin implements Serializable, Parcelable
{

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    public final static Creator<REQBLogin> CREATOR = new Creator<REQBLogin>() {


        @SuppressWarnings({
                "unchecked"
        })
        public REQBLogin createFromParcel(Parcel in) {
            return new REQBLogin(in);
        }

        public REQBLogin[] newArray(int size) {
            return (new REQBLogin[size]);
        }

    }
            ;
    private final static long serialVersionUID = -8743541005962974675L;

    protected REQBLogin(Parcel in) {
        this.username = ((String) in.readValue((String.class.getClassLoader())));
        this.password = ((String) in.readValue((String.class.getClassLoader())));
    }

    public REQBLogin() {
    }

    public REQBLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("username", username).append("password", password).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(username).append(password).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof REQBLogin) == false) {
            return false;
        }
        REQBLogin rhs = ((REQBLogin) other);
        return new EqualsBuilder().append(username, rhs.username).append(password, rhs.password).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(username);
        dest.writeValue(password);
    }

    public int describeContents() {
        return 0;
    }

}