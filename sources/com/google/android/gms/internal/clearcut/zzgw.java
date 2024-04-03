package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import java.util.List;

public final class zzgw {

    public static final class zza extends zzcg<zza, C0008zza> implements zzdq {
        private static volatile zzdz<zza> zzbg;
        /* access modifiers changed from: private */
        public static final zza zzbir;
        private zzcn<zzb> zzbiq = zzcg.zzbb();

        /* renamed from: com.google.android.gms.internal.clearcut.zzgw$zza$zza  reason: collision with other inner class name */
        public static final class C0008zza extends zzcg.zza<zza, C0008zza> implements zzdq {
            private C0008zza() {
                super(zza.zzbir);
            }

            public /* synthetic */ C0008zza(zzgx zzgx) {
                this();
            }
        }

        public static final class zzb extends zzcg<zzb, C0009zza> implements zzdq {
            private static volatile zzdz<zzb> zzbg;
            /* access modifiers changed from: private */
            public static final zzb zzbiv;
            private int zzbb;
            private String zzbis = "";
            private long zzbit;
            private long zzbiu;
            private int zzya;

            /* renamed from: com.google.android.gms.internal.clearcut.zzgw$zza$zzb$zza  reason: collision with other inner class name */
            public static final class C0009zza extends zzcg.zza<zzb, C0009zza> implements zzdq {
                private C0009zza() {
                    super(zzb.zzbiv);
                }

                public /* synthetic */ C0009zza(zzgx zzgx) {
                    this();
                }

                public final C0009zza zzn(String str) {
                    zzbf();
                    ((zzb) this.zzjt).zzm(str);
                    return this;
                }

                public final C0009zza zzr(long j11) {
                    zzbf();
                    ((zzb) this.zzjt).zzp(j11);
                    return this;
                }

                public final C0009zza zzs(long j11) {
                    zzbf();
                    ((zzb) this.zzjt).zzq(j11);
                    return this;
                }
            }

            static {
                zzb zzb = new zzb();
                zzbiv = zzb;
                zzcg.zza(zzb.class, zzb);
            }

            private zzb() {
            }

            public static C0009zza zzfz() {
                return (C0009zza) ((zzcg.zza) zzbiv.zza(zzcg.zzg.zzkh, (Object) null, (Object) null));
            }

            /* access modifiers changed from: private */
            public final void zzm(String str) {
                str.getClass();
                this.zzbb |= 2;
                this.zzbis = str;
            }

            /* access modifiers changed from: private */
            public final void zzp(long j11) {
                this.zzbb |= 4;
                this.zzbit = j11;
            }

            /* access modifiers changed from: private */
            public final void zzq(long j11) {
                this.zzbb |= 8;
                this.zzbiu = j11;
            }

            public final int getEventCode() {
                return this.zzya;
            }

            /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza$zzb>, com.google.android.gms.internal.clearcut.zzcg$zzb] */
            public final Object zza(int i11, Object obj, Object obj2) {
                zzdz<zzb> zzdz;
                switch (zzgx.zzba[i11 - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C0009zza((zzgx) null);
                    case 3:
                        return zzcg.zza((zzdo) zzbiv, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0005\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\u0002\u0003", new Object[]{"zzbb", "zzya", "zzbis", "zzbit", "zzbiu"});
                    case 4:
                        return zzbiv;
                    case 5:
                        zzdz<zzb> zzdz2 = zzbg;
                        zzdz<zzb> zzdz3 = zzdz2;
                        if (zzdz2 == null) {
                            synchronized (zzb.class) {
                                zzdz<zzb> zzdz4 = zzbg;
                                zzdz = zzdz4;
                                if (zzdz4 == null) {
                                    ? zzb = new zzcg.zzb(zzbiv);
                                    zzbg = zzb;
                                    zzdz = zzb;
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

            public final boolean zzfv() {
                return (this.zzbb & 1) == 1;
            }

            public final String zzfw() {
                return this.zzbis;
            }

            public final long zzfx() {
                return this.zzbit;
            }

            public final long zzfy() {
                return this.zzbiu;
            }
        }

        static {
            zza zza = new zza();
            zzbir = zza;
            zzcg.zza(zza.class, zza);
        }

        private zza() {
        }

        public static zza zzft() {
            return zzbir;
        }

        public static zza zzi(byte[] bArr) throws zzco {
            return (zza) zzcg.zzb(zzbir, bArr);
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.clearcut.zzcg$zzb, com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza>] */
        public final Object zza(int i11, Object obj, Object obj2) {
            zzdz<zza> zzdz;
            switch (zzgx.zzba[i11 - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0008zza((zzgx) null);
                case 3:
                    return zzcg.zza((zzdo) zzbir, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0002\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzbiq", zzb.class});
                case 4:
                    return zzbir;
                case 5:
                    zzdz<zza> zzdz2 = zzbg;
                    zzdz<zza> zzdz3 = zzdz2;
                    if (zzdz2 == null) {
                        synchronized (zza.class) {
                            zzdz<zza> zzdz4 = zzbg;
                            zzdz = zzdz4;
                            if (zzdz4 == null) {
                                ? zzb2 = new zzcg.zzb(zzbir);
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

        public final List<zzb> zzfs() {
            return this.zzbiq;
        }
    }
}
