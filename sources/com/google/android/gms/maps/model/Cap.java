package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "CapCreator")
@SafeParcelable.Reserved({1})
public class Cap extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<Cap> CREATOR = new zzb();
    private static final String zza = "Cap";
    @SafeParcelable.Field(getter = "getType", id = 2)
    private final int zzb;
    @SafeParcelable.Field(getter = "getWrappedBitmapDescriptorImplBinder", id = 3, type = "android.os.IBinder")
    @Nullable
    private final BitmapDescriptor zzc;
    @SafeParcelable.Field(getter = "getBitmapRefWidth", id = 4)
    @Nullable
    private final Float zzd;

    public Cap(int i11) {
        this(i11, (BitmapDescriptor) null, (Float) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cap)) {
            return false;
        }
        Cap cap = (Cap) obj;
        if (this.zzb != cap.zzb || !Objects.equal(this.zzc, cap.zzc) || !Objects.equal(this.zzd, cap.zzd)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    @NonNull
    public String toString() {
        return "[Cap: type=" + this.zzb + "]";
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        IBinder iBinder;
        int i12 = this.zzb;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, i12);
        BitmapDescriptor bitmapDescriptor = this.zzc;
        if (bitmapDescriptor == null) {
            iBinder = null;
        } else {
            iBinder = bitmapDescriptor.zza().asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 3, iBinder, false);
        SafeParcelWriter.writeFloatObject(parcel, 4, this.zzd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final Cap zza() {
        boolean z11;
        int i11 = this.zzb;
        if (i11 == 0) {
            return new ButtCap();
        }
        boolean z12 = true;
        if (i11 == 1) {
            return new SquareCap();
        }
        if (i11 == 2) {
            return new RoundCap();
        }
        if (i11 != 3) {
            Log.w(zza, "Unknown Cap type: " + i11);
            return this;
        }
        if (this.zzc != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, "bitmapDescriptor must not be null");
        if (this.zzd == null) {
            z12 = false;
        }
        Preconditions.checkState(z12, "bitmapRefWidth must not be null");
        return new CustomCap(this.zzc, this.zzd.floatValue());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Cap(@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 2) int r2, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 3) @androidx.annotation.Nullable android.os.IBinder r3, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 4) @androidx.annotation.Nullable java.lang.Float r4) {
        /*
            r1 = this;
            if (r3 != 0) goto L_0x0004
            r3 = 0
            goto L_0x000e
        L_0x0004:
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            com.google.android.gms.maps.model.BitmapDescriptor r0 = new com.google.android.gms.maps.model.BitmapDescriptor
            r0.<init>(r3)
            r3 = r0
        L_0x000e:
            r1.<init>((int) r2, (com.google.android.gms.maps.model.BitmapDescriptor) r3, (java.lang.Float) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.model.Cap.<init>(int, android.os.IBinder, java.lang.Float):void");
    }

    private Cap(int i11, @Nullable BitmapDescriptor bitmapDescriptor, @Nullable Float f11) {
        boolean z11;
        boolean z12 = f11 != null && f11.floatValue() > 0.0f;
        if (i11 == 3) {
            z11 = bitmapDescriptor != null && z12;
            i11 = 3;
        } else {
            z11 = true;
        }
        Preconditions.checkArgument(z11, String.format("Invalid Cap: type=%s bitmapDescriptor=%s bitmapRefWidth=%s", new Object[]{Integer.valueOf(i11), bitmapDescriptor, f11}));
        this.zzb = i11;
        this.zzc = bitmapDescriptor;
        this.zzd = f11;
    }

    public Cap(@NonNull BitmapDescriptor bitmapDescriptor, float f11) {
        this(3, bitmapDescriptor, Float.valueOf(f11));
    }
}
