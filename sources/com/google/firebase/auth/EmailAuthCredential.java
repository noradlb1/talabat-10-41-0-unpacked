package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "EmailAuthCredentialCreator")
public class EmailAuthCredential extends AuthCredential {
    @NonNull
    public static final Parcelable.Creator<EmailAuthCredential> CREATOR = new zzg();
    @SafeParcelable.Field(getter = "getEmail", id = 1)
    private final String zza;
    @SafeParcelable.Field(getter = "getPassword", id = 2)
    @Nullable
    private String zzb;
    @SafeParcelable.Field(getter = "getSignInLink", id = 3)
    @Nullable
    private final String zzc;
    @SafeParcelable.Field(getter = "getCachedState", id = 4)
    @Nullable
    private String zzd;
    @SafeParcelable.Field(getter = "isForLinking", id = 5)
    private boolean zze;

    @SafeParcelable.Constructor
    public EmailAuthCredential(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) @Nullable String str2, @SafeParcelable.Param(id = 3) @Nullable String str3, @SafeParcelable.Param(id = 4) @Nullable String str4, @SafeParcelable.Param(id = 5) boolean z11) {
        this.zza = Preconditions.checkNotEmpty(str);
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            this.zzb = str2;
            this.zzc = str3;
            this.zzd = str4;
            this.zze = z11;
            return;
        }
        throw new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
    }

    public static boolean zzi(@NonNull String str) {
        ActionCodeUrl parseLink;
        if (!TextUtils.isEmpty(str) && (parseLink = ActionCodeUrl.parseLink(str)) != null && parseLink.getOperation() == 4) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getProvider() {
        return "password";
    }

    @NonNull
    public String getSignInMethod() {
        return !TextUtils.isEmpty(this.zzb) ? "password" : EmailAuthProvider.EMAIL_LINK_SIGN_IN_METHOD;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public final AuthCredential zza() {
        return new EmailAuthCredential(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }

    @NonNull
    public final EmailAuthCredential zzb(@NonNull FirebaseUser firebaseUser) {
        this.zzd = firebaseUser.zzf();
        this.zze = true;
        return this;
    }

    @Nullable
    public final String zzc() {
        return this.zzd;
    }

    @NonNull
    public final String zzd() {
        return this.zza;
    }

    @Nullable
    public final String zze() {
        return this.zzb;
    }

    @Nullable
    public final String zzf() {
        return this.zzc;
    }

    public final boolean zzg() {
        return !TextUtils.isEmpty(this.zzc);
    }

    public final boolean zzh() {
        return this.zze;
    }
}
