package com.google.firebase.appindexing.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.icing.zzbp;
import com.google.firebase.appindexing.Action;

@SafeParcelable.Class(creator = "ActionImplCreator")
@SafeParcelable.Reserved({1000})
public final class zzc extends AbstractSafeParcelable implements Action {
    public static final Parcelable.Creator<zzc> CREATOR = new zzd();
    @SafeParcelable.Field(getter = "getActionType", id = 1)
    private final String zza;
    @SafeParcelable.Field(getter = "getObjectName", id = 2)
    private final String zzb;
    @SafeParcelable.Field(getter = "getObjectUrl", id = 3)
    private final String zzc;
    @SafeParcelable.Field(getter = "getObjectSameAs", id = 4)
    private final String zzd;
    @SafeParcelable.Field(getter = "getMetadata", id = 5)
    private final zzb zze;
    @SafeParcelable.Field(getter = "getActionStatus", id = 6)
    private final String zzf;
    @SafeParcelable.Field(getter = "getPropertyBundle", id = 7)
    private final Bundle zzg;

    @SafeParcelable.Constructor
    public zzc(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) String str3, @SafeParcelable.Param(id = 4) String str4, @SafeParcelable.Param(id = 5) zzb zzb2, @SafeParcelable.Param(id = 6) String str5, @SafeParcelable.Param(id = 7) Bundle bundle) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = zzb2;
        this.zzf = str5;
        if (bundle != null) {
            this.zzg = bundle;
        } else {
            this.zzg = Bundle.EMPTY;
        }
        ClassLoader classLoader = zzc.class.getClassLoader();
        zzbp.zza(classLoader);
        this.zzg.setClassLoader(classLoader);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ActionImpl { { actionType: '");
        sb2.append(this.zza);
        sb2.append("' } { objectName: '");
        sb2.append(this.zzb);
        sb2.append("' } { objectUrl: '");
        sb2.append(this.zzc);
        sb2.append("' } ");
        if (this.zzd != null) {
            sb2.append("{ objectSameAs: '");
            sb2.append(this.zzd);
            sb2.append("' } ");
        }
        if (this.zze != null) {
            sb2.append("{ metadata: '");
            sb2.append(this.zze.toString());
            sb2.append("' } ");
        }
        if (this.zzf != null) {
            sb2.append("{ actionStatus: '");
            sb2.append(this.zzf);
            sb2.append("' } ");
        }
        if (!this.zzg.isEmpty()) {
            sb2.append("{ ");
            sb2.append(this.zzg);
            sb2.append(" } ");
        }
        sb2.append("}");
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i11, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzb zza() {
        return this.zze;
    }
}
