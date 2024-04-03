package com.google.android.gms.internal.icing;

import java.util.Arrays;

public final class zzfe {
    private static final zzfe zza = new zzfe(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;

    private zzfe() {
        this(0, new int[8], new Object[8], true);
    }

    private zzfe(int i11, int[] iArr, Object[] objArr, boolean z11) {
        this.zze = -1;
        this.zzb = 0;
        this.zzc = iArr;
        this.zzd = objArr;
    }

    public static zzfe zza() {
        return zza;
    }

    public static zzfe zzb(zzfe zzfe, zzfe zzfe2) {
        int i11 = zzfe.zzb;
        int i12 = zzfe2.zzb;
        int[] copyOf = Arrays.copyOf(zzfe.zzc, 0);
        System.arraycopy(zzfe2.zzc, 0, copyOf, 0, 0);
        Object[] copyOf2 = Arrays.copyOf(zzfe.zzd, 0);
        System.arraycopy(zzfe2.zzd, 0, copyOf2, 0, 0);
        return new zzfe(0, copyOf, copyOf2, true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzfe)) {
            return false;
        }
        zzfe zzfe = (zzfe) obj;
        return true;
    }

    public final int hashCode() {
        return 506991;
    }

    public final int zzc() {
        int i11 = this.zze;
        if (i11 != -1) {
            return i11;
        }
        this.zze = 0;
        return 0;
    }

    public final int zzd() {
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
