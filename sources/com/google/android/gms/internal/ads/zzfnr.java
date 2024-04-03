package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GassResponseParcelCreator")
public final class zzfnr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfnr> CREATOR = new zzfns();
    @SafeParcelable.VersionField(id = 1)
    public final int zza;
    @SafeParcelable.Field(getter = "getAfmaSignalsAsBytes", id = 2, type = "byte[]")
    private zzajp zzb = null;
    private byte[] zzc;

    @SafeParcelable.Constructor
    public zzfnr(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) byte[] bArr) {
        this.zza = i11;
        this.zzc = bArr;
        zzb();
    }

    private final void zzb() {
        zzajp zzajp = this.zzb;
        if (zzajp == null && this.zzc != null) {
            return;
        }
        if (zzajp != null && this.zzc == null) {
            return;
        }
        if (zzajp != null && this.zzc != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (zzajp == null && this.zzc == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        byte[] bArr = this.zzc;
        if (bArr == null) {
            bArr = this.zzb.zzar();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzajp zza() {
        if (this.zzb == null) {
            try {
                this.zzb = zzajp.zze(this.zzc, zzgjx.zza());
                this.zzc = null;
            } catch (zzgkx | NullPointerException e11) {
                throw new IllegalStateException(e11);
            }
        }
        zzb();
        return this.zzb;
    }
}
