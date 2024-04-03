package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.maps.zzao;
import com.google.android.gms.internal.maps.zzap;

@SafeParcelable.Class(creator = "TileOverlayOptionsCreator")
@SafeParcelable.Reserved({1})
public final class TileOverlayOptions extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<TileOverlayOptions> CREATOR = new zzah();
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getTileProviderDelegate", id = 2, type = "android.os.IBinder")
    @Nullable
    public zzap zza;
    @Nullable
    private TileProvider zzb;
    @SafeParcelable.Field(getter = "isVisible", id = 3)
    private boolean zzc = true;
    @SafeParcelable.Field(getter = "getZIndex", id = 4)
    private float zzd;
    @SafeParcelable.Field(defaultValue = "true", getter = "getFadeIn", id = 5)
    private boolean zze = true;
    @SafeParcelable.Field(getter = "getTransparency", id = 6)
    private float zzf = 0.0f;

    public TileOverlayOptions() {
    }

    @NonNull
    public TileOverlayOptions fadeIn(boolean z11) {
        this.zze = z11;
        return this;
    }

    public boolean getFadeIn() {
        return this.zze;
    }

    @Nullable
    public TileProvider getTileProvider() {
        return this.zzb;
    }

    public float getTransparency() {
        return this.zzf;
    }

    public float getZIndex() {
        return this.zzd;
    }

    public boolean isVisible() {
        return this.zzc;
    }

    @NonNull
    public TileOverlayOptions tileProvider(@NonNull TileProvider tileProvider) {
        this.zzb = (TileProvider) Preconditions.checkNotNull(tileProvider, "tileProvider must not be null.");
        this.zza = new zzag(this, tileProvider);
        return this;
    }

    @NonNull
    public TileOverlayOptions transparency(float f11) {
        boolean z11 = false;
        if (f11 >= 0.0f && f11 <= 1.0f) {
            z11 = true;
        }
        Preconditions.checkArgument(z11, "Transparency must be in the range [0..1]");
        this.zzf = f11;
        return this;
    }

    @NonNull
    public TileOverlayOptions visible(boolean z11) {
        this.zzc = z11;
        return this;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        IBinder iBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzap zzap = this.zza;
        if (zzap == null) {
            iBinder = null;
        } else {
            iBinder = zzap.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 2, iBinder, false);
        SafeParcelWriter.writeBoolean(parcel, 3, isVisible());
        SafeParcelWriter.writeFloat(parcel, 4, getZIndex());
        SafeParcelWriter.writeBoolean(parcel, 5, getFadeIn());
        SafeParcelWriter.writeFloat(parcel, 6, getTransparency());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public TileOverlayOptions zIndex(float f11) {
        this.zzd = f11;
        return this;
    }

    @SafeParcelable.Constructor
    public TileOverlayOptions(@SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) boolean z11, @SafeParcelable.Param(id = 4) float f11, @SafeParcelable.Param(id = 5) boolean z12, @SafeParcelable.Param(id = 6) float f12) {
        zzaf zzaf;
        zzap zzc2 = zzao.zzc(iBinder);
        this.zza = zzc2;
        if (zzc2 == null) {
            zzaf = null;
        } else {
            zzaf = new zzaf(this);
        }
        this.zzb = zzaf;
        this.zzc = z11;
        this.zzd = f11;
        this.zze = z12;
        this.zzf = f12;
    }
}
