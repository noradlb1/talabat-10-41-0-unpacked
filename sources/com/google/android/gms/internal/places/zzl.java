package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzbc;
import java.util.List;

public final class zzl extends zzbc<zzl, zzb> implements zzcm {
    /* access modifiers changed from: private */
    public static final zzl zzdr;
    private static volatile zzct<zzl> zzds;
    private zzbh<String> zzdo = zzbc.zzbj();
    private zzbi zzdp = zzbc.zzbi();
    private zzbh<zzw> zzdq = zzbc.zzbj();

    public static final class zzb extends zzbc.zzb<zzl, zzb> implements zzcm {
        private zzb() {
            super(zzl.zzdr);
        }

        public /* synthetic */ zzb(zzk zzk) {
            this();
        }
    }

    static {
        zzl zzl = new zzl();
        zzdr = zzl;
        zzbc.zzb(zzl.class, zzl);
    }

    private zzl() {
    }

    public static zzl zzb(byte[] bArr) throws zzbk {
        return (zzl) zzbc.zzb(zzdr, bArr);
    }

    public final List<String> zzo() {
        return this.zzdo;
    }

    public final int zzp() {
        return this.zzdo.size();
    }

    public final List<Integer> zzq() {
        return this.zzdp;
    }

    public final int zzr() {
        return this.zzdp.size();
    }

    public final List<zzw> zzs() {
        return this.zzdq;
    }

    public final int zzt() {
        return this.zzdq.size();
    }

    public final Object zzb(int i11, Object obj, Object obj2) {
        switch (zzk.zzdn[i11 - 1]) {
            case 1:
                return new zzl();
            case 2:
                return new zzb((zzk) null);
            case 3:
                return zzbc.zzb((zzck) zzdr, "\u0001\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0003\u0000\u0001\u001a\u0002\u0016\u0003\u001c", new Object[]{"zzdo", "zzdp", "zzdq"});
            case 4:
                return zzdr;
            case 5:
                zzct<zzl> zzct = zzds;
                if (zzct == null) {
                    synchronized (zzl.class) {
                        zzct = zzds;
                        if (zzct == null) {
                            zzct = new zzbc.zzd<>(zzdr);
                            zzds = zzct;
                        }
                    }
                }
                return zzct;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
