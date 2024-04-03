package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class zzarf implements Comparator<zzare>, Parcelable {
    public static final Parcelable.Creator<zzarf> CREATOR = new zzarc();
    public final int zza;
    private final zzare[] zzb;
    private int zzc;

    public zzarf(Parcel parcel) {
        zzare[] zzareArr = (zzare[]) parcel.createTypedArray(zzare.CREATOR);
        this.zzb = zzareArr;
        this.zza = zzareArr.length;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzare zzare = (zzare) obj;
        zzare zzare2 = (zzare) obj2;
        UUID uuid = zzaor.zzb;
        if (!uuid.equals(zzare.zze)) {
            return zzare.zze.compareTo(zzare2.zze);
        }
        if (!uuid.equals(zzare2.zze)) {
            return 1;
        }
        return 0;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzarf.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzb, ((zzarf) obj).zzb);
    }

    public final int hashCode() {
        int i11 = this.zzc;
        if (i11 != 0) {
            return i11;
        }
        int hashCode = Arrays.hashCode(this.zzb);
        this.zzc = hashCode;
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeTypedArray(this.zzb, 0);
    }

    public final zzare zza(int i11) {
        return this.zzb[i11];
    }

    public zzarf(List<zzare> list) {
        this(false, (zzare[]) list.toArray(new zzare[list.size()]));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.google.android.gms.internal.ads.zzare[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzarf(boolean r3, com.google.android.gms.internal.ads.zzare... r4) {
        /*
            r2 = this;
            r2.<init>()
            if (r3 == 0) goto L_0x000c
            java.lang.Object r3 = r4.clone()
            r4 = r3
            com.google.android.gms.internal.ads.zzare[] r4 = (com.google.android.gms.internal.ads.zzare[]) r4
        L_0x000c:
            java.util.Arrays.sort(r4, r2)
            r3 = 1
        L_0x0010:
            int r0 = r4.length
            if (r3 >= r0) goto L_0x0040
            int r0 = r3 + -1
            r0 = r4[r0]
            java.util.UUID r0 = r0.zze
            r1 = r4[r3]
            java.util.UUID r1 = r1.zze
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002a
            int r3 = r3 + 1
            goto L_0x0010
        L_0x002a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r3 = r4[r3]
            java.util.UUID r3 = r3.zze
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Duplicate data for uuid: "
            java.lang.String r3 = r4.concat(r3)
            r0.<init>(r3)
            throw r0
        L_0x0040:
            r2.zzb = r4
            r2.zza = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzarf.<init>(boolean, com.google.android.gms.internal.ads.zzare[]):void");
    }

    public zzarf(zzare... zzareArr) {
        this(true, zzareArr);
    }
}
