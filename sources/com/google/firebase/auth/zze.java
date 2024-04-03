package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzac;
import com.google.android.gms.internal.p002firebaseauthapi.zzaes;

@SafeParcelable.Class(creator = "DefaultOAuthCredentialCreator")
public final class zze extends OAuthCredential {
    public static final Parcelable.Creator<zze> CREATOR = new zzf();
    @SafeParcelable.Field(getter = "getProvider", id = 1)
    private final String zza;
    @SafeParcelable.Field(getter = "getIdToken", id = 2)
    @Nullable
    private final String zzb;
    @SafeParcelable.Field(getter = "getAccessToken", id = 3)
    @Nullable
    private final String zzc;
    @SafeParcelable.Field(getter = "getWebSignInCredential", id = 4)
    @Nullable
    private final zzaes zzd;
    @SafeParcelable.Field(getter = "getPendingToken", id = 5)
    @Nullable
    private final String zze;
    @SafeParcelable.Field(getter = "getSecret", id = 6)
    @Nullable
    private final String zzf;
    @SafeParcelable.Field(getter = "getRawNonce", id = 7)
    @Nullable
    private final String zzg;

    @SafeParcelable.Constructor
    public zze(@SafeParcelable.Param(id = 1) @Nullable String str, @SafeParcelable.Param(id = 2) @Nullable String str2, @SafeParcelable.Param(id = 3) @Nullable String str3, @SafeParcelable.Param(id = 4) @Nullable zzaes zzaes, @SafeParcelable.Param(id = 5) @Nullable String str4, @SafeParcelable.Param(id = 6) @Nullable String str5, @SafeParcelable.Param(id = 7) @Nullable String str6) {
        this.zza = zzac.zzc(str);
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzaes;
        this.zze = str4;
        this.zzf = str5;
        this.zzg = str6;
    }

    public static zze zzb(zzaes zzaes) {
        Preconditions.checkNotNull(zzaes, "Must specify a non-null webSignInCredential");
        return new zze((String) null, (String) null, (String) null, zzaes, (String) null, (String) null, (String) null);
    }

    public static zze zzc(String str, String str2, String str3, @Nullable String str4, @Nullable String str5) {
        Preconditions.checkNotEmpty(str, "Must specify a non-empty providerId");
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            return new zze(str, str2, str3, (zzaes) null, str4, str5, (String) null);
        }
        throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
    }

    public static zzaes zzd(zze zze2, @Nullable String str) {
        Preconditions.checkNotNull(zze2);
        zzaes zzaes = zze2.zzd;
        if (zzaes != null) {
            return zzaes;
        }
        return new zzaes(zze2.zzb, zze2.zzc, zze2.zza, (String) null, zze2.zzf, (String) null, str, zze2.zze, zze2.zzg);
    }

    @Nullable
    public final String getAccessToken() {
        return this.zzc;
    }

    @Nullable
    public final String getIdToken() {
        return this.zzb;
    }

    public final String getProvider() {
        return this.zza;
    }

    @Nullable
    public final String getSecret() {
        return this.zzf;
    }

    public final String getSignInMethod() {
        return this.zza;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i11, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final AuthCredential zza() {
        return new zze(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
    }
}
