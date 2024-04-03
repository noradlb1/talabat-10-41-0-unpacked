package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzaes;

@SafeParcelable.Class(creator = "GithubAuthCredentialCreator")
public class GithubAuthCredential extends AuthCredential {
    @NonNull
    public static final Parcelable.Creator<GithubAuthCredential> CREATOR = new zzal();
    @SafeParcelable.Field(getter = "getToken", id = 1)
    private final String zza;

    @SafeParcelable.Constructor
    public GithubAuthCredential(@SafeParcelable.Param(id = 1) String str) {
        this.zza = Preconditions.checkNotEmpty(str);
    }

    public static zzaes zzb(@NonNull GithubAuthCredential githubAuthCredential, @Nullable String str) {
        Preconditions.checkNotNull(githubAuthCredential);
        return new zzaes((String) null, githubAuthCredential.zza, githubAuthCredential.getProvider(), (String) null, (String) null, (String) null, str, (String) null, (String) null);
    }

    @NonNull
    public String getProvider() {
        return "github.com";
    }

    @NonNull
    public String getSignInMethod() {
        return "github.com";
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public final AuthCredential zza() {
        return new GithubAuthCredential(this.zza);
    }
}
