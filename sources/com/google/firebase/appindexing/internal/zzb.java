package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "MetadataImplCreator")
@SafeParcelable.Reserved({1000})
public final class zzb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzb> CREATOR = new zzy();
    @SafeParcelable.Field(getter = "getEventStatus", id = 1)
    private int zza;
    @SafeParcelable.Field(getter = "isUploadable", id = 2)
    private final boolean zzb;
    @SafeParcelable.Field(getter = "getCompletionToken", id = 3)
    private final String zzc;
    @SafeParcelable.Field(getter = "getAccountName", id = 4)
    private final String zzd;
    @SafeParcelable.Field(getter = "getSsbContext", id = 5)
    private final byte[] zze;
    @SafeParcelable.Field(getter = "isContextOnly", id = 6)
    private final boolean zzf;

    @SafeParcelable.Constructor
    public zzb(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) boolean z11, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) byte[] bArr, @SafeParcelable.Param(id = 6) boolean z12) {
        this.zza = i11;
        this.zzb = z11;
        this.zzc = str;
        this.zzd = str2;
        this.zze = bArr;
        this.zzf = z12;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("MetadataImpl { { eventStatus: '");
        sb2.append(this.zza);
        sb2.append("' } { uploadable: '");
        sb2.append(this.zzb);
        sb2.append("' } ");
        if (this.zzc != null) {
            sb2.append("{ completionToken: '");
            sb2.append(this.zzc);
            sb2.append("' } ");
        }
        if (this.zzd != null) {
            sb2.append("{ accountName: '");
            sb2.append(this.zzd);
            sb2.append("' } ");
        }
        if (this.zze != null) {
            sb2.append("{ ssbContext: [ ");
            for (byte hexString : this.zze) {
                sb2.append("0x");
                sb2.append(Integer.toHexString(hexString));
                sb2.append(" ");
            }
            sb2.append("] } ");
        }
        sb2.append("{ contextOnly: '");
        sb2.append(this.zzf);
        sb2.append("' } }");
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeByteArray(parcel, 5, this.zze, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzf);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final void zza(int i11) {
        this.zza = i11;
    }

    public zzb(boolean z11, String str, String str2, byte[] bArr, boolean z12) {
        this.zza = 0;
        this.zzb = z11;
        this.zzc = null;
        this.zzd = null;
        this.zze = null;
        this.zzf = false;
    }
}
