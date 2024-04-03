package com.google.android.gms.fido.u2f.api.common;

import androidx.annotation.NonNull;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class Error {
    @NonNull
    @VisibleForTesting
    public static final String JSON_ERROR_CODE = "errorCode";
    @NonNull
    @VisibleForTesting
    public static final String JSON_ERROR_MESSAGE = "errorMessage";
    private final ErrorCode zza;
    private final String zzb;

    public Error(@NonNull ErrorCode errorCode) {
        this.zza = errorCode;
        this.zzb = null;
    }

    public Error(@NonNull ErrorCode errorCode, @NonNull String str) {
        this.zza = errorCode;
        this.zzb = str;
    }

    @NonNull
    public ErrorCode getErrorCode() {
        return this.zza;
    }

    @NonNull
    public String getErrorMessage() {
        return this.zzb;
    }

    @NonNull
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorCode", this.zza.getCode());
            String str = this.zzb;
            if (str != null) {
                jSONObject.put("errorMessage", (Object) str);
            }
            return jSONObject;
        } catch (JSONException e11) {
            throw new RuntimeException(e11);
        }
    }

    @NonNull
    public String toString() {
        if (this.zzb == null) {
            return String.format(Locale.ENGLISH, "{errorCode: %d}", new Object[]{Integer.valueOf(this.zza.getCode())});
        }
        return String.format(Locale.ENGLISH, "{errorCode: %d, errorMessage: %s}", new Object[]{Integer.valueOf(this.zza.getCode()), this.zzb});
    }
}
