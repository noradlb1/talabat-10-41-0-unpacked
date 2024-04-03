package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.zze;
import java.util.List;

@SafeParcelable.Class(creator = "DefaultAuthResultCreator")
public final class zzr implements AuthResult {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    @SafeParcelable.Field(getter = "getUser", id = 1)
    @NonNull
    private zzx zza;
    @SafeParcelable.Field(getter = "getAdditionalUserInfo", id = 2)
    @Nullable
    private zzp zzb;
    @SafeParcelable.Field(getter = "getOAuthCredential", id = 3)
    @Nullable
    private zze zzc;

    public zzr(zzx zzx) {
        zzx zzx2 = (zzx) Preconditions.checkNotNull(zzx);
        this.zza = zzx2;
        List zzo = zzx2.zzo();
        this.zzb = null;
        for (int i11 = 0; i11 < zzo.size(); i11++) {
            if (!TextUtils.isEmpty(((zzt) zzo.get(i11)).zza())) {
                this.zzb = new zzp(((zzt) zzo.get(i11)).getProviderId(), ((zzt) zzo.get(i11)).zza(), zzx.zzs());
            }
        }
        if (this.zzb == null) {
            this.zzb = new zzp(zzx.zzs());
        }
        this.zzc = zzx.zzj();
    }

    @SafeParcelable.Constructor
    public zzr(@SafeParcelable.Param(id = 1) @NonNull zzx zzx, @SafeParcelable.Param(id = 2) @Nullable zzp zzp, @SafeParcelable.Param(id = 3) @Nullable zze zze) {
        this.zza = zzx;
        this.zzb = zzp;
        this.zzc = zze;
    }

    public final int describeContents() {
        return 0;
    }

    @Nullable
    public final AdditionalUserInfo getAdditionalUserInfo() {
        return this.zzb;
    }

    @Nullable
    public final AuthCredential getCredential() {
        return this.zzc;
    }

    @Nullable
    public final FirebaseUser getUser() {
        return this.zza;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i11, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i11, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i11, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
