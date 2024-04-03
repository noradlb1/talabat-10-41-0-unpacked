package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.util.Arrays;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "RtbVersionInfoParcelCreator")
@ParametersAreNonnullByDefault
public final class zzcab extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcab> CREATOR = new zzcac();
    @SafeParcelable.Field(id = 1)
    public final int zza;
    @SafeParcelable.Field(id = 2)
    public final int zzb;
    @SafeParcelable.Field(id = 3)
    public final int zzc;

    @SafeParcelable.Constructor
    public zzcab(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) int i12, @SafeParcelable.Param(id = 3) int i13) {
        this.zza = i11;
        this.zzb = i12;
        this.zzc = i13;
    }

    public static zzcab zza(VersionInfo versionInfo) {
        return new zzcab(versionInfo.getMajorVersion(), versionInfo.getMinorVersion(), versionInfo.getMicroVersion());
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzcab)) {
            zzcab zzcab = (zzcab) obj;
            if (zzcab.zzc == this.zzc && zzcab.zzb == this.zzb && zzcab.zza == this.zza) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new int[]{this.zza, this.zzb, this.zzc});
    }

    public final String toString() {
        int i11 = this.zza;
        int i12 = this.zzb;
        int i13 = this.zzc;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append(i11);
        sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
        sb2.append(i12);
        sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
        sb2.append(i13);
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
