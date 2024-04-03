package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzaes;

@SafeParcelable.Class(creator = "PlayGamesAuthCredentialCreator")
public class PlayGamesAuthCredential extends AuthCredential {
    @NonNull
    public static final Parcelable.Creator<PlayGamesAuthCredential> CREATOR = new zzat();
    @SafeParcelable.Field(getter = "getServerAuthCode", id = 1)
    private final String zza;

    @SafeParcelable.Constructor
    public PlayGamesAuthCredential(@SafeParcelable.Param(id = 1) @NonNull String str) {
        this.zza = Preconditions.checkNotEmpty(str);
    }

    public static zzaes zzb(@NonNull PlayGamesAuthCredential playGamesAuthCredential, @Nullable String str) {
        Preconditions.checkNotNull(playGamesAuthCredential);
        return new zzaes((String) null, (String) null, playGamesAuthCredential.getProvider(), (String) null, (String) null, playGamesAuthCredential.zza, str, (String) null, (String) null);
    }

    @NonNull
    public String getProvider() {
        return "playgames.google.com";
    }

    @NonNull
    public String getSignInMethod() {
        return "playgames.google.com";
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public final AuthCredential zza() {
        return new PlayGamesAuthCredential(this.zza);
    }
}
