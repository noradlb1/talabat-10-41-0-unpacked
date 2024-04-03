package com.google.android.gms.fido.u2f.api.messagebased;

import androidx.annotation.NonNull;
import com.google.android.gms.fido.u2f.api.messagebased.RequestType;

@Deprecated
public enum ResponseType {
    REGISTER("u2f_register_response"),
    SIGN("u2f_sign_response");
    
    private final String zzb;

    private ResponseType(String str) {
        this.zzb = str;
    }

    @NonNull
    public static ResponseType getResponseTypeForRequestType(@NonNull RequestType requestType) throws RequestType.UnsupportedRequestTypeException {
        if (requestType != null) {
            int ordinal = requestType.ordinal();
            if (ordinal == 0) {
                return REGISTER;
            }
            if (ordinal == 1) {
                return SIGN;
            }
            throw new RequestType.UnsupportedRequestTypeException(requestType.toString());
        }
        throw new RequestType.UnsupportedRequestTypeException((String) null);
    }

    @NonNull
    public String toString() {
        return this.zzb;
    }
}
