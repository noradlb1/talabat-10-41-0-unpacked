package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;

public final class zzap {

    public static final class zza extends zzcg<zza, C0005zza> implements zzdq {
        private static volatile zzdz<zza> zzbg;
        /* access modifiers changed from: private */
        public static final zza zzes;
        private int zzbb;
        private int zzel;
        private int zzem;
        private int zzen;
        private int zzeo;
        private int zzep;
        private int zzeq;
        private int zzer;

        /* renamed from: com.google.android.gms.internal.clearcut.zzap$zza$zza  reason: collision with other inner class name */
        public static final class C0005zza extends zzcg.zza<zza, C0005zza> implements zzdq {
            private C0005zza() {
                super(zza.zzes);
            }

            public /* synthetic */ C0005zza(zzaq zzaq) {
                this();
            }
        }

        public enum zzb implements zzcj {
            UNKNOWN(0),
            ON(1),
            OFF(2);
            
            private static final zzck<zzb> zzbq = null;
            private final int value;

            /* access modifiers changed from: public */
            static {
                zzbq = new zzar();
            }

            private zzb(int i11) {
                this.value = i11;
            }

            public static zzck<zzb> zzd() {
                return zzbq;
            }

            public static zzb zze(int i11) {
                if (i11 == 0) {
                    return UNKNOWN;
                }
                if (i11 == 1) {
                    return ON;
                }
                if (i11 != 2) {
                    return null;
                }
                return OFF;
            }

            public final int zzc() {
                return this.value;
            }
        }

        static {
            zza zza = new zza();
            zzes = zza;
            zzcg.zza(zza.class, zza);
        }

        private zza() {
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzap$zza>, com.google.android.gms.internal.clearcut.zzcg$zzb] */
        public final Object zza(int i11, Object obj, Object obj2) {
            zzdz<zza> zzdz;
            switch (zzaq.zzba[i11 - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0005zza((zzaq) null);
                case 3:
                    return zzcg.zza((zzdo) zzes, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\b\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\f\u0002\u0004\f\u0003\u0005\f\u0004\u0006\f\u0005\u0007\f\u0006", new Object[]{"zzbb", "zzel", zzb.zzd(), "zzem", zzb.zzd(), "zzen", zzb.zzd(), "zzeo", zzb.zzd(), "zzep", zzb.zzd(), "zzeq", zzb.zzd(), "zzer", zzb.zzd()});
                case 4:
                    return zzes;
                case 5:
                    zzdz<zza> zzdz2 = zzbg;
                    zzdz<zza> zzdz3 = zzdz2;
                    if (zzdz2 == null) {
                        synchronized (zza.class) {
                            zzdz<zza> zzdz4 = zzbg;
                            zzdz = zzdz4;
                            if (zzdz4 == null) {
                                ? zzb2 = new zzcg.zzb(zzes);
                                zzbg = zzb2;
                                zzdz = zzb2;
                            }
                        }
                        zzdz3 = zzdz;
                    }
                    return zzdz3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}
