package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "GoogleNowAuthStateCreator")
@SafeParcelable.Reserved({1000})
public class GoogleNowAuthState extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<GoogleNowAuthState> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getAuthCode", id = 1)
    @Nullable
    String zza;
    @SafeParcelable.Field(getter = "getAccessToken", id = 2)
    @Nullable
    String zzb;
    @SafeParcelable.Field(getter = "getNextAllowedTimeMillis", id = 3)
    long zzc;

    @SafeParcelable.Constructor
    public GoogleNowAuthState(@SafeParcelable.Param(id = 1) @Nullable String str, @SafeParcelable.Param(id = 2) @Nullable String str2, @SafeParcelable.Param(id = 3) long j11) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j11;
    }

    @androidx.annotation.Nullable
    public String getAccessToken() {
        return this.zzb;
    }

    @androidx.annotation.Nullable
    public String getAuthCode() {
        return this.zza;
    }

    public long getNextAllowedTimeMillis() {
        return this.zzc;
    }

    @NonNull
    public String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        long j11 = this.zzc;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 74 + String.valueOf(str2).length());
        sb2.append("mAuthCode = ");
        sb2.append(str);
        sb2.append("\nmAccessToken = ");
        sb2.append(str2);
        sb2.append("\nmNextAllowedTimeMillis = ");
        sb2.append(j11);
        return sb2.toString();
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getAuthCode(), false);
        SafeParcelWriter.writeString(parcel, 2, getAccessToken(), false);
        SafeParcelWriter.writeLong(parcel, 3, getNextAllowedTimeMillis());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
