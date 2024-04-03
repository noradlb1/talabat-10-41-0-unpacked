package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AdditionalUserInfo;
import java.util.Map;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "DefaultAdditionalUserInfoCreator")
public final class zzp implements AdditionalUserInfo {
    public static final Parcelable.Creator<zzp> CREATOR = new zzq();
    @SafeParcelable.Field(getter = "getProviderId", id = 1)
    private final String zza;
    @SafeParcelable.Field(getter = "getRawUserInfo", id = 2)
    private final String zzb;
    private final Map zzc;
    @SafeParcelable.Field(getter = "isNewUser", id = 3)
    private final boolean zzd;

    @SafeParcelable.Constructor
    public zzp(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) boolean z11) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzbb.zzc(str2);
        this.zzd = z11;
    }

    public zzp(boolean z11) {
        this.zzd = z11;
        this.zzb = null;
        this.zza = null;
        this.zzc = null;
    }

    public final int describeContents() {
        return 0;
    }

    @Nullable
    public final Map<String, Object> getProfile() {
        return this.zzc;
    }

    @Nullable
    public final String getProviderId() {
        return this.zza;
    }

    @Nullable
    public final String getUsername() {
        if ("github.com".equals(this.zza)) {
            return (String) this.zzc.get(FirebaseAnalytics.Event.LOGIN);
        }
        if ("twitter.com".equals(this.zza)) {
            return (String) this.zzc.get("screen_name");
        }
        return null;
    }

    public final boolean isNewUser() {
        return this.zzd;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
