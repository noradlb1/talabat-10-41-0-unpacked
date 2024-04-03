package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzaes;

@SafeParcelable.Class(creator = "FacebookAuthCredentialCreator")
public class FacebookAuthCredential extends AuthCredential {
    @NonNull
    public static final Parcelable.Creator<FacebookAuthCredential> CREATOR = new zzh();
    @SafeParcelable.Field(getter = "getAccessToken", id = 1)
    private final String zza;

    @SafeParcelable.Constructor
    public FacebookAuthCredential(@SafeParcelable.Param(id = 1) String str) {
        this.zza = Preconditions.checkNotEmpty(str);
    }

    @NonNull
    public static zzaes zzb(@NonNull FacebookAuthCredential facebookAuthCredential, @Nullable String str) {
        Preconditions.checkNotNull(facebookAuthCredential);
        return new zzaes((String) null, facebookAuthCredential.zza, facebookAuthCredential.getProvider(), (String) null, (String) null, (String) null, str, (String) null, (String) null);
    }

    @NonNull
    public String getProvider() {
        return "facebook.com";
    }

    @NonNull
    public String getSignInMethod() {
        return "facebook.com";
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public final AuthCredential zza() {
        return new FacebookAuthCredential(this.zza);
    }
}
