package com.google.android.gms.internal.icing;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.BitSet;

@ShowFirstParty
@SafeParcelable.Class(creator = "DocumentContentsCreator")
@SafeParcelable.Reserved({1000})
public final class zzg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzg> CREATOR = new zzh();
    @SafeParcelable.Field(id = 1)
    @Nullable
    final zzk[] zza;
    @SafeParcelable.Field(id = 2)
    public final String zzb;
    @SafeParcelable.Field(id = 3)
    public final boolean zzc;
    @SafeParcelable.Field(id = 4)
    public final Account zzd;

    public zzg(String str, boolean z11, Account account, @Nullable zzk... zzkArr) {
        this(zzkArr, str, z11, account);
        String str2;
        if (zzkArr != null) {
            int length = zzq.zza.length;
            BitSet bitSet = new BitSet(10);
            for (zzk zzk : zzkArr) {
                int i11 = zzk.zzd;
                if (i11 != -1) {
                    if (bitSet.get(i11)) {
                        String valueOf = String.valueOf(zzq.zza(i11));
                        if (valueOf.length() != 0) {
                            str2 = "Duplicate global search section type ".concat(valueOf);
                        } else {
                            str2 = new String("Duplicate global search section type ");
                        }
                        throw new IllegalArgumentException(str2);
                    }
                    bitSet.set(i11);
                }
            }
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof zzg) {
            zzg zzg = (zzg) obj;
            if (!Objects.equal(this.zzb, zzg.zzb) || !Objects.equal(Boolean.valueOf(this.zzc), Boolean.valueOf(zzg.zzc)) || !Objects.equal(this.zzd, zzg.zzd) || !Arrays.equals(this.zza, zzg.zza)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb, Boolean.valueOf(this.zzc), this.zzd, Integer.valueOf(Arrays.hashCode(this.zza)));
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedArray(parcel, 1, this.zza, i11, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i11, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzg(@SafeParcelable.Param(id = 1) @Nullable zzk[] zzkArr, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) boolean z11, @SafeParcelable.Param(id = 4) Account account) {
        this.zza = zzkArr;
        this.zzb = str;
        this.zzc = z11;
        this.zzd = account;
    }
}
