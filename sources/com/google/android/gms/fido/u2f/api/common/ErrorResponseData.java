package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.fido.zzaj;
import com.google.android.gms.internal.fido.zzak;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "ErrorResponseDataCreator")
@SafeParcelable.Reserved({1})
@Deprecated
public class ErrorResponseData extends ResponseData {
    @NonNull
    public static final Parcelable.Creator<ErrorResponseData> CREATOR = new zzd();
    @NonNull
    @VisibleForTesting
    public static final String JSON_ERROR_CODE = "errorCode";
    @NonNull
    @VisibleForTesting
    public static final String JSON_ERROR_MESSAGE = "errorMessage";
    @SafeParcelable.Field(getter = "getErrorCodeAsInt", id = 2, type = "int")
    private final ErrorCode zza;
    @SafeParcelable.Field(getter = "getErrorMessage", id = 3)
    private final String zzb;

    @SafeParcelable.Constructor
    public ErrorResponseData(@SafeParcelable.Param(id = 2) int i11, @SafeParcelable.Param(id = 3) String str) {
        this.zza = ErrorCode.toErrorCode(i11);
        this.zzb = str;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ErrorResponseData)) {
            return false;
        }
        ErrorResponseData errorResponseData = (ErrorResponseData) obj;
        if (!Objects.equal(this.zza, errorResponseData.zza) || !Objects.equal(this.zzb, errorResponseData.zzb)) {
            return false;
        }
        return true;
    }

    @NonNull
    public ErrorCode getErrorCode() {
        return this.zza;
    }

    public int getErrorCodeAsInt() {
        return this.zza.getCode();
    }

    @NonNull
    public String getErrorMessage() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    @NonNull
    public final JSONObject toJsonObject() {
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
        zzaj zza2 = zzak.zza(this);
        zza2.zza("errorCode", this.zza.getCode());
        String str = this.zzb;
        if (str != null) {
            zza2.zzb("errorMessage", str);
        }
        return zza2.toString();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, getErrorCodeAsInt());
        SafeParcelWriter.writeString(parcel, 3, getErrorMessage(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public ErrorResponseData(@NonNull ErrorCode errorCode) {
        this.zza = (ErrorCode) Preconditions.checkNotNull(errorCode);
        this.zzb = null;
    }

    public ErrorResponseData(@NonNull ErrorCode errorCode, @NonNull String str) {
        this.zza = (ErrorCode) Preconditions.checkNotNull(errorCode);
        this.zzb = str;
    }
}
