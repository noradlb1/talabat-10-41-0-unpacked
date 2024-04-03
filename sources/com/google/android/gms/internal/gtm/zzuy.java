package com.google.android.gms.internal.gtm;

import java.util.Arrays;

final class zzuy {
    final int tag;
    final byte[] zzawe;

    public zzuy(int i11, byte[] bArr) {
        this.tag = i11;
        this.zzawe = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzuy)) {
            return false;
        }
        zzuy zzuy = (zzuy) obj;
        if (this.tag != zzuy.tag || !Arrays.equals(this.zzawe, zzuy.zzawe)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.zzawe);
    }
}
