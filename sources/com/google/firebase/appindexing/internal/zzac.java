package com.google.firebase.appindexing.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.icing.zzbp;
import com.google.firebase.appindexing.Indexable;

@SafeParcelable.Class(creator = "MetadataCreator")
@SafeParcelable.Reserved({1000})
public final class zzac extends AbstractSafeParcelable implements Indexable.Metadata {
    public static final Parcelable.Creator<zzac> CREATOR = new zzx();
    @SafeParcelable.Field(getter = "getWorksOffline", id = 1)
    private final boolean zza;
    @SafeParcelable.Field(getter = "getScore", id = 2)
    private final int zzb;
    @SafeParcelable.Field(getter = "getAccountEmail", id = 3)
    private final String zzc;
    @SafeParcelable.Field(getter = "getPropertyBundle", id = 4)
    private final Bundle zzd;
    @SafeParcelable.Field(getter = "getEmbeddingProperties", id = 5)
    private final Bundle zze;

    @SafeParcelable.Constructor
    public zzac(@SafeParcelable.Param(id = 1) boolean z11, @SafeParcelable.Param(id = 2) int i11, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) Bundle bundle, @SafeParcelable.Param(id = 5) Bundle bundle2) {
        this.zza = z11;
        this.zzb = i11;
        this.zzc = str;
        this.zzd = bundle == null ? new Bundle() : bundle;
        bundle2 = bundle2 == null ? new Bundle() : bundle2;
        this.zze = bundle2;
        ClassLoader classLoader = zzac.class.getClassLoader();
        zzbp.zza(classLoader);
        bundle2.setClassLoader(classLoader);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzac)) {
            return false;
        }
        zzac zzac = (zzac) obj;
        if (!Objects.equal(Boolean.valueOf(this.zza), Boolean.valueOf(zzac.zza)) || !Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzac.zzb)) || !Objects.equal(this.zzc, zzac.zzc) || !Thing.zze(this.zzd, zzac.zzd) || !Thing.zze(this.zze, zzac.zze)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc, Integer.valueOf(Thing.zzf(this.zzd)), Integer.valueOf(Thing.zzf(this.zze)));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("worksOffline: ");
        sb2.append(this.zza);
        sb2.append(", score: ");
        sb2.append(this.zzb);
        if (!this.zzc.isEmpty()) {
            sb2.append(", accountEmail: ");
            sb2.append(this.zzc);
        }
        Bundle bundle = this.zzd;
        if (bundle != null && !bundle.isEmpty()) {
            sb2.append(", Properties { ");
            Thing.zzd(this.zzd, sb2);
            sb2.append("}");
        }
        if (!this.zze.isEmpty()) {
            sb2.append(", embeddingProperties { ");
            Thing.zzd(this.zze, sb2);
            sb2.append("}");
        }
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeBundle(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeBundle(parcel, 5, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
