package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;

final class zzip implements zzia {
    private final int flags;
    private final String info;
    private final Object[] zzyv;
    private final zzic zzyy;

    public zzip(zzic zzic, String str, Object[] objArr) {
        this.zzyy = zzic;
        this.info = str;
        this.zzyv = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        char c11 = charAt & 8191;
        int i11 = 13;
        int i12 = 1;
        while (true) {
            int i13 = i12 + 1;
            char charAt2 = str.charAt(i12);
            if (charAt2 >= 55296) {
                c11 |= (charAt2 & 8191) << i11;
                i11 += 13;
                i12 = i13;
            } else {
                this.flags = c11 | (charAt2 << i11);
                return;
            }
        }
    }

    public final int zzhi() {
        return (this.flags & 1) == 1 ? zzgs.zzf.zzwt : zzgs.zzf.zzwu;
    }

    public final boolean zzhj() {
        return (this.flags & 2) == 2;
    }

    public final zzic zzhk() {
        return this.zzyy;
    }

    public final String zzhp() {
        return this.info;
    }

    public final Object[] zzhq() {
        return this.zzyv;
    }
}
