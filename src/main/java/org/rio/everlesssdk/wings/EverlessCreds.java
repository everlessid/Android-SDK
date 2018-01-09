package org.rio.everlesssdk.wings;

/**
 * Created by rio.chandra.r on 12/15/17.
 */

public class EverlessCreds{
    private static CredentialModel creds;

    public static CredentialModel getCreds() throws Exception{
        if(creds == null)
            throw new Exception("credential belum diset, lakukan set terlebih dahulu dengan metode EverlessCreds.setCreds()");

        return creds;
    }

    public static void setCreds(String baseUrl, String cKey, String cSecret) throws Exception{
        if(baseUrl == null)
            throw new Exception("base url tidak boleh null");

        if(cKey == null)
            throw new Exception("client key tidak boleh null");

        if(cSecret == null)
            throw new Exception("client secret tidak boleh null");

        if(baseUrl.isEmpty())
            throw new Exception("base url tidak boleh kosong");

        if(cKey.isEmpty())
            throw new Exception("client key tidak boleh kosong");

        if(cSecret.isEmpty())
            throw new Exception("client secret tidak boleh kosong");

        creds = new CredentialModel(baseUrl, cKey, cSecret);
    }

    public static class CredentialModel{
        public String baseUrl;
        public String clientKey;
        public String clientSecret;

        public CredentialModel(String baseUrl, String cKey, String cSecret) {
            this.baseUrl = baseUrl;
            this.clientKey = cKey;
            this.clientSecret = cSecret;
        }
    }
}
