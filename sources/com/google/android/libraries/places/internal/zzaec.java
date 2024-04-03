package com.google.android.libraries.places.internal;

import java.util.Arrays;

public final class zzaec {
    private static final zzaec zza = new zzaec(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;

    private zzaec() {
        this(0, new int[8], new Object[8], true);
    }

    private zzaec(int i11, int[] iArr, Object[] objArr, boolean z11) {
        this.zze = -1;
        this.zzb = 0;
        this.zzc = iArr;
        this.zzd = objArr;
    }

    public static zzaec zzc() {
        return zza;
    }

    public static zzaec zzd(zzaec zzaec, zzaec zzaec2) {
        int i11 = zzaec.zzb;
        int i12 = zzaec2.zzb;
        int[] copyOf = Arrays.copyOf(zzaec.zzc, 0);
        System.arraycopy(zzaec2.zzc, 0, copyOf, 0, 0);
        Object[] copyOf2 = Arrays.copyOf(zzaec.zzd, 0);
        System.arraycopy(zzaec2.zzd, 0, copyOf2, 0, 0);
        return new zzaec(0, copyOf, copyOf2, true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzaec)) {
            return false;
        }
        zzaec zzaec = (zzaec) obj;
        return true;
    }

    public final int hashCode() {
        return 506991;
    }

    public final int zza() {
        int i11 = this.zze;
        if (i11 != -1) {
            return i11;
        }
        this.zze = 0;
        return 0;
    }

    public final int zzb() {
        int i11 = this.zze;
        if (i11 != -1) {
            return i11;
        }
        this.zze = 0;
        return 0;
    }

    public final void zze(StringBuilder sb2, int i11) {
    }
}
