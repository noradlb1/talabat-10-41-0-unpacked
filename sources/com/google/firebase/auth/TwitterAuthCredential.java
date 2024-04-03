package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzaes;

@SafeParcelable.Class(creator = "TwitterAuthCredentialCreator")
public class TwitterAuthCredential extends AuthCredential {
    @NonNull
    public static final Parcelable.Creator<TwitterAuthCredential> CREATOR = new zzav();
    @SafeParcelable.Field(getter = "getToken", id = 1)
    private final String zza;
    @SafeParcelable.Field(getter = "getSecret", id = 2)
    private final String zzb;

    @SafeParcelable.Constructor
    public TwitterAuthCredential(@SafeParcelable.Param(id = 1) @NonNull String str, @SafeParcelable.Param(id = 2) @NonNull String str2) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = Preconditions.checkNotEmpty(str2);
    }

    public static zzaes zzb(@NonNull TwitterAuthCredential twitterAuthCredential, @Nullable String str) {
        Preconditions.checkNotNull(twitterAuthCredential);
        return new zzaes((String) null, twitterAuthCredential.zza, twitterAuthCredential.getProvider(), (String) null, twitterAuthCredential.zzb, (String) null, str, (String) null, (String) null);
    }

    @NonNull
    public String getProvider() {
        return "twitter.com";
    }

    @NonNull
    public String getSignInMethod() {
        return "twitter.com";
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public final AuthCredential zza() {
        return new TwitterAuthCredential(this.zza, this.zzb);
    }
}
