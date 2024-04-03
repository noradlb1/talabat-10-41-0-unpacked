package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;

final class zzsx implements zzsi {
    private final int flags;
    private final String info;
    private final Object[] zzbcz;
    private final zzsk zzbdc;

    public zzsx(zzsk zzsk, String str, Object[] objArr) {
        this.zzbdc = zzsk;
        this.info = str;
        this.zzbcz = objArr;
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

    public final int zzql() {
        return (this.flags & 1) == 1 ? zzrc.zze.zzbaz : zzrc.zze.zzbba;
    }

    public final boolean zzqm() {
        return (this.flags & 2) == 2;
    }

    public final zzsk zzqn() {
        return this.zzbdc;
    }

    public final String zzqt() {
        return this.info;
    }

    public final Object[] zzqu() {
        return this.zzbcz;
    }
}
