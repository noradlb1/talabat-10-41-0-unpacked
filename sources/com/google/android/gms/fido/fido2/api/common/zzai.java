package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@SafeParcelable.Class(creator = "PrfExtensionCreator")
public final class zzai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzai> CREATOR = new zzaj();
    @SafeParcelable.Field(getter = "getEvaluationPoints", id = 1)
    @NonNull
    private final byte[][] zza;

    @SafeParcelable.Constructor
    public zzai(@SafeParcelable.Param(id = 1) @NonNull byte[][] bArr) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        if (bArr != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        if (1 != ((bArr.length & 1) ^ 1)) {
            z12 = false;
        } else {
            z12 = true;
        }
        Preconditions.checkArgument(z12);
        for (int i11 = 0; i11 < bArr.length; i11 += 2) {
            if (i11 == 0 || bArr[i11] != null) {
                z13 = true;
            } else {
                z13 = false;
            }
            Preconditions.checkArgument(z13);
            int i12 = i11 + 1;
            if (bArr[i12] != null) {
                z14 = true;
            } else {
                z14 = false;
            }
            Preconditions.checkArgument(z14);
            int length = bArr[i12].length;
            if (length == 32 || length == 64) {
                z15 = true;
            } else {
                z15 = false;
            }
            Preconditions.checkArgument(z15);
        }
        this.zza = bArr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof zzai)) {
            return false;
        }
        return Arrays.deepEquals(this.zza, ((zzai) obj).zza);
    }

    public final int hashCode() {
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            i11 ^= Objects.hashCode(objArr[i12]);
        }
        return i11;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArrayArray(parcel, 1, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
