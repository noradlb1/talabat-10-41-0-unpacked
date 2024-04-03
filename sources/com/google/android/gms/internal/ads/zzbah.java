package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.InputStream;
import javax.annotation.concurrent.GuardedBy;

@SafeParcelable.Class(creator = "CacheEntryParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzbah extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbah> CREATOR = new zzbai();
    @GuardedBy("this")
    @SafeParcelable.Field(getter = "getContentFileDescriptor", id = 2)
    @Nullable
    private ParcelFileDescriptor zza;
    @GuardedBy("this")
    @SafeParcelable.Field(getter = "hasAdditionalMetadataFromReadV2", id = 3)
    private final boolean zzb;
    @GuardedBy("this")
    @SafeParcelable.Field(getter = "isDownloaded", id = 4)
    private final boolean zzc;
    @GuardedBy("this")
    @SafeParcelable.Field(getter = "getCachedBytes", id = 5)
    private final long zzd;
    @GuardedBy("this")
    @SafeParcelable.Field(getter = "isGcacheHit", id = 6)
    private final boolean zze;

    public zzbah() {
        this((ParcelFileDescriptor) null, false, false, 0, false);
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, zzb(), i11, false);
        SafeParcelWriter.writeBoolean(parcel, 3, zzd());
        SafeParcelWriter.writeBoolean(parcel, 4, zzf());
        SafeParcelWriter.writeLong(parcel, 5, zza());
        SafeParcelWriter.writeBoolean(parcel, 6, zzg());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final synchronized long zza() {
        return this.zzd;
    }

    public final synchronized ParcelFileDescriptor zzb() {
        return this.zza;
    }

    @Nullable
    public final synchronized InputStream zzc() {
        ParcelFileDescriptor parcelFileDescriptor = this.zza;
        if (parcelFileDescriptor == null) {
            return null;
        }
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
        this.zza = null;
        return autoCloseInputStream;
    }

    public final synchronized boolean zzd() {
        return this.zzb;
    }

    public final synchronized boolean zze() {
        return this.zza != null;
    }

    public final synchronized boolean zzf() {
        return this.zzc;
    }

    public final synchronized boolean zzg() {
        return this.zze;
    }

    @SafeParcelable.Constructor
    public zzbah(@SafeParcelable.Param(id = 2) @Nullable ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.Param(id = 3) boolean z11, @SafeParcelable.Param(id = 4) boolean z12, @SafeParcelable.Param(id = 5) long j11, @SafeParcelable.Param(id = 6) boolean z13) {
        this.zza = parcelFileDescriptor;
        this.zzb = z11;
        this.zzc = z12;
        this.zzd = j11;
        this.zze = z13;
    }
}
