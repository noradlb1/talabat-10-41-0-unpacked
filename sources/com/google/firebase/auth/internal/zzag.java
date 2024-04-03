package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorSession;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SafeParcelable.Class(creator = "DefaultMultiFactorSessionCreator")
public final class zzag extends MultiFactorSession {
    public static final Parcelable.Creator<zzag> CREATOR = new zzah();
    @SafeParcelable.Field(getter = "getIdToken", id = 1)
    @Nullable
    private String zza;
    @SafeParcelable.Field(getter = "getPendingCredential", id = 2)
    @Nullable
    private String zzb;
    @SafeParcelable.Field(getter = "getPhoneMultiFactorInfoList", id = 3)
    @Nullable
    private List zzc;
    @SafeParcelable.Field(getter = "getTotpMultiFactorInfoList", id = 4)
    @Nullable
    private List zzd;
    @SafeParcelable.Field(getter = "getFirebaseUser", id = 5)
    @Nullable
    private zzx zze;

    private zzag() {
    }

    public static zzag zzb(String str, @Nullable zzx zzx) {
        Preconditions.checkNotEmpty(str);
        zzag zzag = new zzag();
        zzag.zza = str;
        zzag.zze = zzx;
        return zzag;
    }

    public static zzag zzc(List list, String str) {
        Preconditions.checkNotNull(list);
        Preconditions.checkNotEmpty(str);
        zzag zzag = new zzag();
        zzag.zzc = new ArrayList();
        zzag.zzd = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MultiFactorInfo multiFactorInfo = (MultiFactorInfo) it.next();
            if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                zzag.zzc.add((PhoneMultiFactorInfo) multiFactorInfo);
            } else if (multiFactorInfo instanceof TotpMultiFactorInfo) {
                zzag.zzd.add((TotpMultiFactorInfo) multiFactorInfo);
            } else {
                throw new IllegalArgumentException("MultiFactorInfo must be either PhoneMultiFactorInfo or TotpMultiFactorInfo. The factorId of this MultiFactorInfo: ".concat(String.valueOf(multiFactorInfo.getFactorId())));
            }
        }
        zzag.zzb = str;
        return zzag;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeTypedList(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i11, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzx zza() {
        return this.zze;
    }

    @Nullable
    public final String zzd() {
        return this.zza;
    }

    @Nullable
    public final String zze() {
        return this.zzb;
    }

    public final boolean zzf() {
        return this.zza != null;
    }

    @SafeParcelable.Constructor
    public zzag(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) List list, @SafeParcelable.Param(id = 4) List list2, @SafeParcelable.Param(id = 5) zzx zzx) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = list;
        this.zzd = list2;
        this.zze = zzx;
    }
}
