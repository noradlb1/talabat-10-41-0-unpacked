package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class zzs implements Comparator<zzr>, Parcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new zzp();
    @Nullable
    public final String zza;
    private final zzr[] zzb;
    private int zzc;

    public zzs(Parcel parcel) {
        this.zza = parcel.readString();
        zzr[] zzrArr = (zzr[]) zzfn.zzC((zzr[]) parcel.createTypedArray(zzr.CREATOR));
        this.zzb = zzrArr;
        int length = zzrArr.length;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzr zzr = (zzr) obj;
        zzr zzr2 = (zzr) obj2;
        UUID uuid = zzk.zza;
        if (!uuid.equals(zzr.zza)) {
            return zzr.zza.compareTo(zzr2.zza);
        }
        if (!uuid.equals(zzr2.zza)) {
            return 1;
        }
        return 0;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzs.class == obj.getClass()) {
            zzs zzs = (zzs) obj;
            if (!zzfn.zzP(this.zza, zzs.zza) || !Arrays.equals(this.zzb, zzs.zzb)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        int i12 = this.zzc;
        if (i12 != 0) {
            return i12;
        }
        String str = this.zza;
        if (str == null) {
            i11 = 0;
        } else {
            i11 = str.hashCode();
        }
        int hashCode = (i11 * 31) + Arrays.hashCode(this.zzb);
        this.zzc = hashCode;
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.zza);
        parcel.writeTypedArray(this.zzb, 0);
    }

    public final zzs zza(@Nullable String str) {
        if (zzfn.zzP(this.zza, str)) {
            return this;
        }
        return new zzs(str, false, this.zzb);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.google.android.gms.internal.ads.zzr[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzs(@androidx.annotation.Nullable java.lang.String r1, boolean r2, com.google.android.gms.internal.ads.zzr... r3) {
        /*
            r0 = this;
            r0.<init>()
            r0.zza = r1
            if (r2 == 0) goto L_0x000e
            java.lang.Object r1 = r3.clone()
            r3 = r1
            com.google.android.gms.internal.ads.zzr[] r3 = (com.google.android.gms.internal.ads.zzr[]) r3
        L_0x000e:
            r0.zzb = r3
            int r1 = r3.length
            java.util.Arrays.sort(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzs.<init>(java.lang.String, boolean, com.google.android.gms.internal.ads.zzr[]):void");
    }

    public zzs(@Nullable String str, zzr... zzrArr) {
        this((String) null, true, zzrArr);
    }

    public zzs(List<zzr> list) {
        this((String) null, false, (zzr[]) list.toArray(new zzr[0]));
    }
}
