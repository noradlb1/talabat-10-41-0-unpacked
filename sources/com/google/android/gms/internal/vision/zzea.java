package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import kotlin.text.Typography;

public final class zzea {

    public static final class zza extends zzgs<zza, C0047zza> implements zzie {
        private static volatile zzil<zza> zzbd;
        /* access modifiers changed from: private */
        public static final zza zzml;
        private int zzbf;
        private String zzmj = "";
        private String zzmk = "";

        /* renamed from: com.google.android.gms.internal.vision.zzea$zza$zza  reason: collision with other inner class name */
        public static final class C0047zza extends zzgs.zza<zza, C0047zza> implements zzie {
            private C0047zza() {
                super(zza.zzml);
            }

            public final C0047zza zzl(String str) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zza) this.zzwb).zzn(str);
                return this;
            }

            public final C0047zza zzm(String str) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zza) this.zzwb).zzo(str);
                return this;
            }

            public /* synthetic */ C0047zza(zzdz zzdz) {
                this();
            }
        }

        static {
            zza zza = new zza();
            zzml = zza;
            zzgs.zza(zza.class, zza);
        }

        private zza() {
        }

        public static C0047zza zzcj() {
            return (C0047zza) zzml.zzge();
        }

        /* access modifiers changed from: private */
        public final void zzn(String str) {
            str.getClass();
            this.zzbf |= 1;
            this.zzmj = str;
        }

        /* access modifiers changed from: private */
        public final void zzo(String str) {
            str.getClass();
            this.zzbf |= 2;
            this.zzmk = str;
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zza>] */
        public final Object zza(int i11, Object obj, Object obj2) {
            zzil<zza> zzil;
            switch (zzdz.zzbe[i11 - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0047zza((zzdz) null);
                case 3:
                    return zzgs.zza((zzic) zzml, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", new Object[]{"zzbf", "zzmj", "zzmk"});
                case 4:
                    return zzml;
                case 5:
                    zzil<zza> zzil2 = zzbd;
                    zzil<zza> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zza.class) {
                            zzil<zza> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzml);
                                zzbd = zzc;
                                zzil = zzc;
                            }
                        }
                        zzil3 = zzil;
                    }
                    return zzil3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzb extends zzgs<zzb, zza> implements zzie {
        private static volatile zzil<zzb> zzbd;
        private static final zzha<Integer, zzeo> zzmn = new zzeb();
        /* access modifiers changed from: private */
        public static final zzb zzmo;
        private zzgx zzmm = zzgs.zzgg();

        public static final class zza extends zzgs.zza<zzb, zza> implements zzie {
            private zza() {
                super(zzb.zzmo);
            }

            public /* synthetic */ zza(zzdz zzdz) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.gms.internal.vision.zzeb, com.google.android.gms.internal.vision.zzha<java.lang.Integer, com.google.android.gms.internal.vision.zzeo>] */
        static {
            zzb zzb = new zzb();
            zzmo = zzb;
            zzgs.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzb>] */
        public final Object zza(int i11, Object obj, Object obj2) {
            zzil<zzb> zzil;
            switch (zzdz.zzbe[i11 - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzdz) null);
                case 3:
                    return zzgs.zza((zzic) zzmo, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", new Object[]{"zzmm", zzeo.zzah()});
                case 4:
                    return zzmo;
                case 5:
                    zzil<zzb> zzil2 = zzbd;
                    zzil<zzb> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzb.class) {
                            zzil<zzb> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzmo);
                                zzbd = zzc;
                                zzil = zzc;
                            }
                        }
                        zzil3 = zzil;
                    }
                    return zzil3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzc extends zzgs<zzc, zza> implements zzie {
        private static volatile zzil<zzc> zzbd;
        /* access modifiers changed from: private */
        public static final zzc zzms;
        private int zzbf;
        private int zzmp = 1;
        private int zzmq = 1;
        private String zzmr = "";

        public static final class zza extends zzgs.zza<zzc, zza> implements zzie {
            private zza() {
                super(zzc.zzms);
            }

            public /* synthetic */ zza(zzdz zzdz) {
                this();
            }
        }

        static {
            zzc zzc = new zzc();
            zzms = zzc;
            zzgs.zza(zzc.class, zzc);
        }

        private zzc() {
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzc>] */
        public final Object zza(int i11, Object obj, Object obj2) {
            zzil<zzc> zzil;
            switch (zzdz.zzbe[i11 - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzdz) null);
                case 3:
                    return zzgs.zza((zzic) zzms, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\b\u0002", new Object[]{"zzbf", "zzmp", zzeo.zzah(), "zzmq", zzes.zzah(), "zzmr"});
                case 4:
                    return zzms;
                case 5:
                    zzil<zzc> zzil2 = zzbd;
                    zzil<zzc> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzc.class) {
                            zzil<zzc> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzms);
                                zzbd = zzc;
                                zzil = zzc;
                            }
                        }
                        zzil3 = zzil;
                    }
                    return zzil3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zze extends zzgs<zze, zzb> implements zzie {
        private static volatile zzil<zze> zzbd;
        /* access modifiers changed from: private */
        public static final zze zznd;
        private int zzbf;
        private String zzmv = "";
        private boolean zzmw;
        private int zzmx;
        private long zzmy;
        private long zzmz;
        private long zzna;
        private String zznb = "";
        private boolean zznc;

        public enum zza implements zzgw {
            REASON_UNKNOWN(0),
            REASON_MISSING(1),
            REASON_UPGRADE(2),
            REASON_INVALID(3);
            
            private static final zzgv<zza> zzgy = null;
            private final int value;

            /* access modifiers changed from: public */
            static {
                zzgy = new zzed();
            }

            private zza(int i11) {
                this.value = i11;
            }

            public static zzgy zzah() {
                return zzec.zzhb;
            }

            public static zza zzs(int i11) {
                if (i11 == 0) {
                    return REASON_UNKNOWN;
                }
                if (i11 == 1) {
                    return REASON_MISSING;
                }
                if (i11 == 2) {
                    return REASON_UPGRADE;
                }
                if (i11 != 3) {
                    return null;
                }
                return REASON_INVALID;
            }

            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            public final int zzag() {
                return this.value;
            }
        }

        public static final class zzb extends zzgs.zza<zze, zzb> implements zzie {
            private zzb() {
                super(zze.zznd);
            }

            public /* synthetic */ zzb(zzdz zzdz) {
                this();
            }
        }

        static {
            zze zze = new zze();
            zznd = zze;
            zzgs.zza(zze.class, zze);
        }

        private zze() {
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zze>] */
        public final Object zza(int i11, Object obj, Object obj2) {
            zzil<zze> zzil;
            switch (zzdz.zzbe[i11 - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zzb((zzdz) null);
                case 3:
                    return zzgs.zza((zzic) zznd, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\b\u0000\u0002\u0007\u0001\u0003\f\u0002\u0004\u0002\u0003\u0005\u0002\u0004\u0006\u0002\u0005\u0007\b\u0006\b\u0007\u0007", new Object[]{"zzbf", "zzmv", "zzmw", "zzmx", zza.zzah(), "zzmy", "zzmz", "zzna", "zznb", "zznc"});
                case 4:
                    return zznd;
                case 5:
                    zzil<zze> zzil2 = zzbd;
                    zzil<zze> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zze.class) {
                            zzil<zze> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zznd);
                                zzbd = zzc;
                                zzil = zzc;
                            }
                        }
                        zzil3 = zzil;
                    }
                    return zzil3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzf extends zzgs<zzf, zza> implements zzie {
        private static volatile zzil<zzf> zzbd;
        /* access modifiers changed from: private */
        public static final zzf zznr;
        private int zzbf;
        private String zznj = "";
        private String zznk = "";
        private zzgz<String> zznl = zzgs.zzgh();
        private int zznm;
        private String zznn = "";
        private long zzno;
        private long zznp;
        private zzgz<zzn> zznq = zzgs.zzgh();

        public static final class zza extends zzgs.zza<zzf, zza> implements zzie {
            private zza() {
                super(zzf.zznr);
            }

            public final zza zzc(Iterable<? extends zzn> iterable) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzf) this.zzwb).zzd(iterable);
                return this;
            }

            public final zza zzd(long j11) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzf) this.zzwb).zzf(j11);
                return this;
            }

            public final zza zze(long j11) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzf) this.zzwb).zzg(j11);
                return this;
            }

            public final zza zzp(String str) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzf) this.zzwb).setName(str);
                return this;
            }

            public final zza zzq(String str) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzf) this.zzwb).zzr(str);
                return this;
            }

            public /* synthetic */ zza(zzdz zzdz) {
                this();
            }
        }

        public enum zzb implements zzgw {
            RESULT_UNKNOWN(0),
            RESULT_SUCCESS(1),
            RESULT_FAIL(2),
            RESULT_SKIPPED(3);
            
            private static final zzgv<zzb> zzgy = null;
            private final int value;

            /* access modifiers changed from: public */
            static {
                zzgy = new zzee();
            }

            private zzb(int i11) {
                this.value = i11;
            }

            public static zzgy zzah() {
                return zzef.zzhb;
            }

            public static zzb zzt(int i11) {
                if (i11 == 0) {
                    return RESULT_UNKNOWN;
                }
                if (i11 == 1) {
                    return RESULT_SUCCESS;
                }
                if (i11 == 2) {
                    return RESULT_FAIL;
                }
                if (i11 != 3) {
                    return null;
                }
                return RESULT_SKIPPED;
            }

            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            public final int zzag() {
                return this.value;
            }
        }

        static {
            zzf zzf = new zzf();
            zznr = zzf;
            zzgs.zza(zzf.class, zzf);
        }

        private zzf() {
        }

        /* access modifiers changed from: private */
        public final void setName(String str) {
            str.getClass();
            this.zzbf |= 1;
            this.zznj = str;
        }

        public static zza zzcq() {
            return (zza) zznr.zzge();
        }

        /* access modifiers changed from: private */
        public final void zzd(Iterable<? extends zzn> iterable) {
            if (!this.zznq.zzdo()) {
                this.zznq = zzgs.zza(this.zznq);
            }
            zzet.zza(iterable, this.zznq);
        }

        /* access modifiers changed from: private */
        public final void zzf(long j11) {
            this.zzbf |= 16;
            this.zzno = j11;
        }

        /* access modifiers changed from: private */
        public final void zzg(long j11) {
            this.zzbf |= 32;
            this.zznp = j11;
        }

        /* access modifiers changed from: private */
        public final void zzr(String str) {
            str.getClass();
            this.zzbf |= 8;
            this.zznn = str;
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzf>] */
        public final Object zza(int i11, Object obj, Object obj2) {
            zzil<zzf> zzil;
            switch (zzdz.zzbe[i11 - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza((zzdz) null);
                case 3:
                    return zzgs.zza((zzic) zznr, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0002\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u001a\u0004\f\u0002\u0005\b\u0003\u0006\u0002\u0004\u0007\u0002\u0005\b\u001b", new Object[]{"zzbf", "zznj", "zznk", "zznl", "zznm", zzb.zzah(), "zznn", "zzno", "zznp", "zznq", zzn.class});
                case 4:
                    return zznr;
                case 5:
                    zzil<zzf> zzil2 = zzbd;
                    zzil<zzf> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzf.class) {
                            zzil<zzf> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zznr);
                                zzbd = zzc;
                                zzil = zzc;
                            }
                        }
                        zzil3 = zzil;
                    }
                    return zzil3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzh extends zzgs<zzh, zza> implements zzie {
        private static volatile zzil<zzh> zzbd;
        /* access modifiers changed from: private */
        public static final zzh zzow;
        private int zzbf;
        private float zzoq;
        private float zzor;
        private float zzos;
        private float zzot;
        private float zzou;
        private float zzov;

        public static final class zza extends zzgs.zza<zzh, zza> implements zzie {
            private zza() {
                super(zzh.zzow);
            }

            public final zza zzg(float f11) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzh) this.zzwb).zzm(f11);
                return this;
            }

            public final zza zzh(float f11) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzh) this.zzwb).zzn(f11);
                return this;
            }

            public final zza zzi(float f11) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzh) this.zzwb).zzo(f11);
                return this;
            }

            public final zza zzj(float f11) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzh) this.zzwb).zzp(f11);
                return this;
            }

            public final zza zzk(float f11) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzh) this.zzwb).zzq(f11);
                return this;
            }

            public final zza zzl(float f11) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzh) this.zzwb).zzr(f11);
                return this;
            }

            public /* synthetic */ zza(zzdz zzdz) {
                this();
            }
        }

        static {
            zzh zzh = new zzh();
            zzow = zzh;
            zzgs.zza(zzh.class, zzh);
        }

        private zzh() {
        }

        public static zza zzcu() {
            return (zza) zzow.zzge();
        }

        /* access modifiers changed from: private */
        public final void zzm(float f11) {
            this.zzbf |= 1;
            this.zzoq = f11;
        }

        /* access modifiers changed from: private */
        public final void zzn(float f11) {
            this.zzbf |= 2;
            this.zzor = f11;
        }

        /* access modifiers changed from: private */
        public final void zzo(float f11) {
            this.zzbf |= 4;
            this.zzos = f11;
        }

        /* access modifiers changed from: private */
        public final void zzp(float f11) {
            this.zzbf |= 8;
            this.zzot = f11;
        }

        /* access modifiers changed from: private */
        public final void zzq(float f11) {
            this.zzbf |= 16;
            this.zzou = f11;
        }

        /* access modifiers changed from: private */
        public final void zzr(float f11) {
            this.zzbf |= 32;
            this.zzov = f11;
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzh>] */
        public final Object zza(int i11, Object obj, Object obj2) {
            zzil<zzh> zzil;
            switch (zzdz.zzbe[i11 - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza((zzdz) null);
                case 3:
                    return zzgs.zza((zzic) zzow, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0001\u0000\u0002\u0001\u0001\u0003\u0001\u0002\u0004\u0001\u0003\u0005\u0001\u0004\u0006\u0001\u0005", new Object[]{"zzbf", "zzoq", "zzor", "zzos", "zzot", "zzou", "zzov"});
                case 4:
                    return zzow;
                case 5:
                    zzil<zzh> zzil2 = zzbd;
                    zzil<zzh> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzh.class) {
                            zzil<zzh> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzow);
                                zzbd = zzc;
                                zzil = zzc;
                            }
                        }
                        zzil3 = zzil;
                    }
                    return zzil3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzj extends zzgs<zzj, zza> implements zzie {
        private static volatile zzil<zzj> zzbd;
        /* access modifiers changed from: private */
        public static final zzj zzpf;
        private int zzbf;
        private int zzmp;
        private long zzpb;
        private long zzpc;
        private long zzpd;
        private long zzpe;

        public static final class zza extends zzgs.zza<zzj, zza> implements zzie {
            private zza() {
                super(zzj.zzpf);
            }

            public final zza zzh(long j11) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzj) this.zzwb).zzl(j11);
                return this;
            }

            public final zza zzi(long j11) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzj) this.zzwb).zzm(j11);
                return this;
            }

            public final zza zzj(long j11) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzj) this.zzwb).zzn(j11);
                return this;
            }

            public final zza zzk(long j11) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzj) this.zzwb).zzo(j11);
                return this;
            }

            public /* synthetic */ zza(zzdz zzdz) {
                this();
            }
        }

        public enum zzb implements zzgw {
            FORMAT_UNKNOWN(0),
            FORMAT_LUMINANCE(1),
            FORMAT_RGB8(2),
            FORMAT_MONOCHROME(3);
            
            private static final zzgv<zzb> zzgy = null;
            private final int value;

            /* access modifiers changed from: public */
            static {
                zzgy = new zzem();
            }

            private zzb(int i11) {
                this.value = i11;
            }

            public static zzgy zzah() {
                return zzen.zzhb;
            }

            public static zzb zzx(int i11) {
                if (i11 == 0) {
                    return FORMAT_UNKNOWN;
                }
                if (i11 == 1) {
                    return FORMAT_LUMINANCE;
                }
                if (i11 == 2) {
                    return FORMAT_RGB8;
                }
                if (i11 != 3) {
                    return null;
                }
                return FORMAT_MONOCHROME;
            }

            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            public final int zzag() {
                return this.value;
            }
        }

        static {
            zzj zzj = new zzj();
            zzpf = zzj;
            zzgs.zza(zzj.class, zzj);
        }

        private zzj() {
        }

        public static zza zzcz() {
            return (zza) zzpf.zzge();
        }

        /* access modifiers changed from: private */
        public final void zzl(long j11) {
            this.zzbf |= 2;
            this.zzpb = j11;
        }

        /* access modifiers changed from: private */
        public final void zzm(long j11) {
            this.zzbf |= 4;
            this.zzpc = j11;
        }

        /* access modifiers changed from: private */
        public final void zzn(long j11) {
            this.zzbf |= 8;
            this.zzpd = j11;
        }

        /* access modifiers changed from: private */
        public final void zzo(long j11) {
            this.zzbf |= 16;
            this.zzpe = j11;
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzj>] */
        public final Object zza(int i11, Object obj, Object obj2) {
            zzil<zzj> zzil;
            switch (zzdz.zzbe[i11 - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza((zzdz) null);
                case 3:
                    return zzgs.zza((zzic) zzpf, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0000\u0002\u0002\u0001\u0003\u0002\u0002\u0004\u0002\u0004\u0005\u0002\u0003", new Object[]{"zzbf", "zzmp", zzb.zzah(), "zzpb", "zzpc", "zzpe", "zzpd"});
                case 4:
                    return zzpf;
                case 5:
                    zzil<zzj> zzil2 = zzbd;
                    zzil<zzj> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzj.class) {
                            zzil<zzj> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzpf);
                                zzbd = zzc;
                                zzil = zzc;
                            }
                        }
                        zzil3 = zzil;
                    }
                    return zzil3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzl extends zzgs<zzl, zza> implements zzie {
        private static volatile zzil<zzl> zzbd;
        /* access modifiers changed from: private */
        public static final zzl zzpq;
        private int zzbf;
        private long zzno;
        private long zznp;

        public static final class zza extends zzgs.zza<zzl, zza> implements zzie {
            private zza() {
                super(zzl.zzpq);
            }

            public /* synthetic */ zza(zzdz zzdz) {
                this();
            }
        }

        static {
            zzl zzl = new zzl();
            zzpq = zzl;
            zzgs.zza(zzl.class, zzl);
        }

        private zzl() {
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzl>, com.google.android.gms.internal.vision.zzgs$zzc] */
        public final Object zza(int i11, Object obj, Object obj2) {
            zzil<zzl> zzil;
            switch (zzdz.zzbe[i11 - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza((zzdz) null);
                case 3:
                    return zzgs.zza((zzic) zzpq, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0000\u0002\u0002\u0001", new Object[]{"zzbf", "zzno", "zznp"});
                case 4:
                    return zzpq;
                case 5:
                    zzil<zzl> zzil2 = zzbd;
                    zzil<zzl> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzl.class) {
                            zzil<zzl> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzpq);
                                zzbd = zzc;
                                zzil = zzc;
                            }
                        }
                        zzil3 = zzil;
                    }
                    return zzil3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzm extends zzgs<zzm, zza> implements zzie {
        private static volatile zzil<zzm> zzbd;
        /* access modifiers changed from: private */
        public static final zzm zzpt;
        private int zzbf;
        private int zzpr;
        private int zzps;

        public static final class zza extends zzgs.zza<zzm, zza> implements zzie {
            private zza() {
                super(zzm.zzpt);
            }

            public final zza zzy(int i11) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzm) this.zzwb).setX(i11);
                return this;
            }

            public final zza zzz(int i11) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzm) this.zzwb).setY(i11);
                return this;
            }

            public /* synthetic */ zza(zzdz zzdz) {
                this();
            }
        }

        static {
            zzm zzm = new zzm();
            zzpt = zzm;
            zzgs.zza(zzm.class, zzm);
        }

        private zzm() {
        }

        /* access modifiers changed from: private */
        public final void setX(int i11) {
            this.zzbf |= 1;
            this.zzpr = i11;
        }

        /* access modifiers changed from: private */
        public final void setY(int i11) {
            this.zzbf |= 2;
            this.zzps = i11;
        }

        public static zza zzde() {
            return (zza) zzpt.zzge();
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzm>] */
        public final Object zza(int i11, Object obj, Object obj2) {
            zzil<zzm> zzil;
            switch (zzdz.zzbe[i11 - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza((zzdz) null);
                case 3:
                    return zzgs.zza((zzic) zzpt, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzbf", "zzpr", "zzps"});
                case 4:
                    return zzpt;
                case 5:
                    zzil<zzm> zzil2 = zzbd;
                    zzil<zzm> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzm.class) {
                            zzil<zzm> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzpt);
                                zzbd = zzc;
                                zzil = zzc;
                            }
                        }
                        zzil3 = zzil;
                    }
                    return zzil3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzg extends zzgs<zzg, zzb> implements zzie {
        private static volatile zzil<zzg> zzbd;
        /* access modifiers changed from: private */
        public static final zzg zzob;
        private int zzbf;
        private float zzjw;
        private boolean zzka;
        private int zznx;
        private int zzny;
        private int zznz;
        private boolean zzoa;

        public enum zza implements zzgw {
            CLASSIFICATION_UNKNOWN(0),
            CLASSIFICATION_NONE(1),
            CLASSIFICATION_ALL(2);
            
            private static final zzgv<zza> zzgy = null;
            private final int value;

            /* access modifiers changed from: public */
            static {
                zzgy = new zzeh();
            }

            private zza(int i11) {
                this.value = i11;
            }

            public static zzgy zzah() {
                return zzeg.zzhb;
            }

            public static zza zzu(int i11) {
                if (i11 == 0) {
                    return CLASSIFICATION_UNKNOWN;
                }
                if (i11 == 1) {
                    return CLASSIFICATION_NONE;
                }
                if (i11 != 2) {
                    return null;
                }
                return CLASSIFICATION_ALL;
            }

            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            public final int zzag() {
                return this.value;
            }
        }

        public static final class zzb extends zzgs.zza<zzg, zzb> implements zzie {
            private zzb() {
                super(zzg.zzob);
            }

            public final zzb zzb(zzd zzd) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzg) this.zzwb).zza(zzd);
                return this;
            }

            public final zzb zzf(float f11) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzg) this.zzwb).zzd(f11);
                return this;
            }

            public final zzb zzh(boolean z11) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzg) this.zzwb).zza(z11);
                return this;
            }

            public final zzb zzi(boolean z11) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzg) this.zzwb).zzg(z11);
                return this;
            }

            public /* synthetic */ zzb(zzdz zzdz) {
                this();
            }

            public final zzb zzb(zzc zzc) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzg) this.zzwb).zza(zzc);
                return this;
            }

            public final zzb zzb(zza zza) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzg) this.zzwb).zza(zza);
                return this;
            }
        }

        public enum zzc implements zzgw {
            LANDMARK_UNKNOWN(0),
            LANDMARK_NONE(1),
            LANDMARK_ALL(2),
            LANDMARK_CONTOUR(3);
            
            private static final zzgv<zzc> zzgy = null;
            private final int value;

            /* access modifiers changed from: public */
            static {
                zzgy = new zzei();
            }

            private zzc(int i11) {
                this.value = i11;
            }

            public static zzgy zzah() {
                return zzej.zzhb;
            }

            public static zzc zzv(int i11) {
                if (i11 == 0) {
                    return LANDMARK_UNKNOWN;
                }
                if (i11 == 1) {
                    return LANDMARK_NONE;
                }
                if (i11 == 2) {
                    return LANDMARK_ALL;
                }
                if (i11 != 3) {
                    return null;
                }
                return LANDMARK_CONTOUR;
            }

            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            public final int zzag() {
                return this.value;
            }
        }

        public enum zzd implements zzgw {
            MODE_UNKNOWN(0),
            MODE_ACCURATE(1),
            MODE_FAST(2),
            MODE_SELFIE(3);
            
            private static final zzgv<zzd> zzgy = null;
            private final int value;

            /* access modifiers changed from: public */
            static {
                zzgy = new zzel();
            }

            private zzd(int i11) {
                this.value = i11;
            }

            public static zzgy zzah() {
                return zzek.zzhb;
            }

            public static zzd zzw(int i11) {
                if (i11 == 0) {
                    return MODE_UNKNOWN;
                }
                if (i11 == 1) {
                    return MODE_ACCURATE;
                }
                if (i11 == 2) {
                    return MODE_FAST;
                }
                if (i11 != 3) {
                    return null;
                }
                return MODE_SELFIE;
            }

            public final String toString() {
                return "<" + zzd.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            public final int zzag() {
                return this.value;
            }
        }

        static {
            zzg zzg = new zzg();
            zzob = zzg;
            zzgs.zza(zzg.class, zzg);
        }

        private zzg() {
        }

        /* access modifiers changed from: private */
        public final void zza(zzd zzd2) {
            this.zznx = zzd2.zzag();
            this.zzbf |= 1;
        }

        public static zzb zzcs() {
            return (zzb) zzob.zzge();
        }

        /* access modifiers changed from: private */
        public final void zzd(float f11) {
            this.zzbf |= 32;
            this.zzjw = f11;
        }

        /* access modifiers changed from: private */
        public final void zzg(boolean z11) {
            this.zzbf |= 16;
            this.zzoa = z11;
        }

        /* access modifiers changed from: private */
        public final void zza(zzc zzc2) {
            this.zzny = zzc2.zzag();
            this.zzbf |= 2;
        }

        /* access modifiers changed from: private */
        public final void zza(zza zza2) {
            this.zznz = zza2.zzag();
            this.zzbf |= 4;
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z11) {
            this.zzbf |= 8;
            this.zzka = z11;
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzg>] */
        public final Object zza(int i11, Object obj, Object obj2) {
            zzil<zzg> zzil;
            switch (zzdz.zzbe[i11 - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zzb((zzdz) null);
                case 3:
                    return zzgs.zza((zzic) zzob, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\f\u0002\u0004\u0007\u0003\u0005\u0007\u0004\u0006\u0001\u0005", new Object[]{"zzbf", "zznx", zzd.zzah(), "zzny", zzc.zzah(), "zznz", zza.zzah(), "zzka", "zzoa", "zzjw"});
                case 4:
                    return zzob;
                case 5:
                    zzil<zzg> zzil2 = zzbd;
                    zzil<zzg> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzg.class) {
                            zzil<zzg> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc2 = new zzgs.zzc(zzob);
                                zzbd = zzc2;
                                zzil = zzc2;
                            }
                        }
                        zzil3 = zzil;
                    }
                    return zzil3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzi extends zzgs<zzi, zza> implements zzie {
        private static volatile zzil<zzi> zzbd;
        /* access modifiers changed from: private */
        public static final zzi zzpa;
        private int zzbf;
        private zzj zzox;
        private zzl zzoy;
        private zzgz<zzf> zzoz = zzgs.zzgh();

        public static final class zza extends zzgs.zza<zzi, zza> implements zzie {
            private zza() {
                super(zzi.zzpa);
            }

            public final zza zza(zzj zzj) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzi) this.zzwb).zzb(zzj);
                return this;
            }

            public final zza zze(Iterable<? extends zzf> iterable) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzi) this.zzwb).zzf(iterable);
                return this;
            }

            public /* synthetic */ zza(zzdz zzdz) {
                this();
            }

            public final zza zza(zzf.zza zza) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzi) this.zzwb).zza((zzf) ((zzgs) zza.zzgc()));
                return this;
            }
        }

        static {
            zzi zzi = new zzi();
            zzpa = zzi;
            zzgs.zza(zzi.class, zzi);
        }

        private zzi() {
        }

        /* access modifiers changed from: private */
        public final void zza(zzf zzf) {
            zzf.getClass();
            zzcw();
            this.zzoz.add(zzf);
        }

        /* access modifiers changed from: private */
        public final void zzb(zzj zzj) {
            zzj.getClass();
            this.zzox = zzj;
            this.zzbf |= 1;
        }

        private final void zzcw() {
            if (!this.zzoz.zzdo()) {
                this.zzoz = zzgs.zza(this.zzoz);
            }
        }

        public static zza zzcx() {
            return (zza) zzpa.zzge();
        }

        /* access modifiers changed from: private */
        public final void zzf(Iterable<? extends zzf> iterable) {
            zzcw();
            zzet.zza(iterable, this.zzoz);
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzi>] */
        public final Object zza(int i11, Object obj, Object obj2) {
            zzil<zzi> zzil;
            switch (zzdz.zzbe[i11 - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza((zzdz) null);
                case 3:
                    return zzgs.zza((zzic) zzpa, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\t\u0000\u0002\t\u0001\u0003\u001b", new Object[]{"zzbf", "zzox", "zzoy", "zzoz", zzf.class});
                case 4:
                    return zzpa;
                case 5:
                    zzil<zzi> zzil2 = zzbd;
                    zzil<zzi> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzi.class) {
                            zzil<zzi> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzpa);
                                zzbd = zzc;
                                zzil = zzc;
                            }
                        }
                        zzil3 = zzil;
                    }
                    return zzil3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzk extends zzgs<zzk, zza> implements zzie {
        private static volatile zzil<zzk> zzbd;
        /* access modifiers changed from: private */
        public static final zzk zzpp;
        private int zzbf;
        private String zznb = "";
        private String zznj = "";
        private long zzpl;
        private zza zzpm;
        private zzg zzpn;
        private zzb zzpo;

        public static final class zza extends zzgs.zza<zzk, zza> implements zzie {
            private zza() {
                super(zzk.zzpp);
            }

            public final zza zza(zzg.zzb zzb) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzk) this.zzwb).zza((zzg) ((zzgs) zzb.zzgc()));
                return this;
            }

            public final zza zzb(zza zza) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzk) this.zzwb).zza(zza);
                return this;
            }

            public final zza zzq(long j11) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzk) this.zzwb).zzp(j11);
                return this;
            }

            public final zza zzt(String str) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzk) this.zzwb).setName(str);
                return this;
            }

            public final zza zzu(String str) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzk) this.zzwb).zzs(str);
                return this;
            }

            public /* synthetic */ zza(zzdz zzdz) {
                this();
            }
        }

        static {
            zzk zzk = new zzk();
            zzpp = zzk;
            zzgs.zza(zzk.class, zzk);
        }

        private zzk() {
        }

        /* access modifiers changed from: private */
        public final void setName(String str) {
            str.getClass();
            this.zzbf |= 1;
            this.zznj = str;
        }

        /* access modifiers changed from: private */
        public final void zza(zza zza2) {
            zza2.getClass();
            this.zzpm = zza2;
            this.zzbf |= 4;
        }

        public static zza zzdb() {
            return (zza) zzpp.zzge();
        }

        /* access modifiers changed from: private */
        public final void zzp(long j11) {
            this.zzbf |= 2;
            this.zzpl = j11;
        }

        /* access modifiers changed from: private */
        public final void zzs(String str) {
            str.getClass();
            this.zzbf |= 8;
            this.zznb = str;
        }

        /* access modifiers changed from: private */
        public final void zza(zzg zzg) {
            zzg.getClass();
            this.zzpn = zzg;
            this.zzbf |= 16;
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzk>, com.google.android.gms.internal.vision.zzgs$zzc] */
        public final Object zza(int i11, Object obj, Object obj2) {
            zzil<zzk> zzil;
            switch (zzdz.zzbe[i11 - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza((zzdz) null);
                case 3:
                    return zzgs.zza((zzic) zzpp, "\u0001\u0006\u0000\u0001\u0001\u0011\u0006\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\t\u0002\u0006\b\u0003\u0010\t\u0004\u0011\t\u0005", new Object[]{"zzbf", "zznj", "zzpl", "zzpm", "zznb", "zzpn", "zzpo"});
                case 4:
                    return zzpp;
                case 5:
                    zzil<zzk> zzil2 = zzbd;
                    zzil<zzk> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzk.class) {
                            zzil<zzk> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzpp);
                                zzbd = zzc;
                                zzil = zzc;
                            }
                        }
                        zzil3 = zzil;
                    }
                    return zzil3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzn extends zzgs<zzn, zza> implements zzie {
        private static volatile zzil<zzn> zzbd;
        /* access modifiers changed from: private */
        public static final zzn zzpy;
        private int zzbf;
        private zzd zzpu;
        private int zzpv;
        private zzh zzpw;
        private zzc zzpx;

        public static final class zza extends zzgs.zza<zzn, zza> implements zzie {
            private zza() {
                super(zzn.zzpy);
            }

            public final zza zza(zzd.zza zza) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzn) this.zzwb).zza((zzd) ((zzgs) zza.zzgc()));
                return this;
            }

            public final zza zzaa(int i11) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzn) this.zzwb).setId(i11);
                return this;
            }

            public final zza zzb(zzh zzh) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzn) this.zzwb).zza(zzh);
                return this;
            }

            public /* synthetic */ zza(zzdz zzdz) {
                this();
            }
        }

        static {
            zzn zzn = new zzn();
            zzpy = zzn;
            zzgs.zza(zzn.class, zzn);
        }

        private zzn() {
        }

        /* access modifiers changed from: private */
        public final void setId(int i11) {
            this.zzbf |= 2;
            this.zzpv = i11;
        }

        /* access modifiers changed from: private */
        public final void zza(zzd zzd) {
            zzd.getClass();
            this.zzpu = zzd;
            this.zzbf |= 1;
        }

        public static zza zzdg() {
            return (zza) zzpy.zzge();
        }

        /* access modifiers changed from: private */
        public final void zza(zzh zzh) {
            zzh.getClass();
            this.zzpw = zzh;
            this.zzbf |= 4;
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzn>] */
        public final Object zza(int i11, Object obj, Object obj2) {
            zzil<zzn> zzil;
            switch (zzdz.zzbe[i11 - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zza((zzdz) null);
                case 3:
                    return zzgs.zza((zzic) zzpy, "\u0001\u0004\u0000\u0001\u0001\u0011\u0004\u0000\u0000\u0000\u0001\t\u0000\u0002\u0004\u0001\u0010\t\u0002\u0011\t\u0003", new Object[]{"zzbf", "zzpu", "zzpv", "zzpw", "zzpx"});
                case 4:
                    return zzpy;
                case 5:
                    zzil<zzn> zzil2 = zzbd;
                    zzil<zzn> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzn.class) {
                            zzil<zzn> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzpy);
                                zzbd = zzc;
                                zzil = zzc;
                            }
                        }
                        zzil3 = zzil;
                    }
                    return zzil3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzo extends zzgs<zzo, zza> implements zzie {
        private static volatile zzil<zzo> zzbd;
        /* access modifiers changed from: private */
        public static final zzo zzqd;
        private int zzbf;
        private zze zzpz;
        private zzk zzqa;
        private zzi zzqb;
        private int zzqc;

        public static final class zza extends zzgs.zza<zzo, zza> implements zzie {
            private zza() {
                super(zzo.zzqd);
            }

            public final zza zza(zzk.zza zza) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzo) this.zzwb).zza((zzk) ((zzgs) zza.zzgc()));
                return this;
            }

            public final zza zzb(zzi zzi) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzo) this.zzwb).zza(zzi);
                return this;
            }

            public /* synthetic */ zza(zzdz zzdz) {
                this();
            }
        }

        static {
            zzo zzo = new zzo();
            zzqd = zzo;
            zzgs.zza(zzo.class, zzo);
        }

        private zzo() {
        }

        /* access modifiers changed from: private */
        public final void zza(zzk zzk) {
            zzk.getClass();
            this.zzqa = zzk;
            this.zzbf |= 2;
        }

        public static zza zzdi() {
            return (zza) zzqd.zzge();
        }

        /* access modifiers changed from: private */
        public final void zza(zzi zzi) {
            zzi.getClass();
            this.zzqb = zzi;
            this.zzbf |= 4;
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzo>] */
        public final Object zza(int i11, Object obj, Object obj2) {
            zzil<zzo> zzil;
            switch (zzdz.zzbe[i11 - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zza((zzdz) null);
                case 3:
                    return zzgs.zza((zzic) zzqd, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002\u0004\u0004\u0003", new Object[]{"zzbf", "zzpz", "zzqa", "zzqb", "zzqc"});
                case 4:
                    return zzqd;
                case 5:
                    zzil<zzo> zzil2 = zzbd;
                    zzil<zzo> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzo.class) {
                            zzil<zzo> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzqd);
                                zzbd = zzc;
                                zzil = zzc;
                            }
                        }
                        zzil3 = zzil;
                    }
                    return zzil3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzd extends zzgs<zzd, zza> implements zzie {
        private static volatile zzil<zzd> zzbd;
        /* access modifiers changed from: private */
        public static final zzd zzmu;
        private zzgz<zzm> zzmt = zzgs.zzgh();

        public static final class zza extends zzgs.zza<zzd, zza> implements zzie {
            private zza() {
                super(zzd.zzmu);
            }

            public final zza zzb(zzm zzm) {
                if (this.zzwc) {
                    zzfy();
                    this.zzwc = false;
                }
                ((zzd) this.zzwb).zza(zzm);
                return this;
            }

            public /* synthetic */ zza(zzdz zzdz) {
                this();
            }
        }

        static {
            zzd zzd = new zzd();
            zzmu = zzd;
            zzgs.zza(zzd.class, zzd);
        }

        private zzd() {
        }

        /* access modifiers changed from: private */
        public final void zza(zzm zzm) {
            zzm.getClass();
            if (!this.zzmt.zzdo()) {
                this.zzmt = zzgs.zza(this.zzmt);
            }
            this.zzmt.add(zzm);
        }

        public static zza zzcn() {
            return (zza) zzmu.zzge();
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzgs$zzc, com.google.android.gms.internal.vision.zzil<com.google.android.gms.internal.vision.zzea$zzd>] */
        public final Object zza(int i11, Object obj, Object obj2) {
            zzil<zzd> zzil;
            switch (zzdz.zzbe[i11 - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza((zzdz) null);
                case 3:
                    return zzgs.zza((zzic) zzmu, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzmt", zzm.class});
                case 4:
                    return zzmu;
                case 5:
                    zzil<zzd> zzil2 = zzbd;
                    zzil<zzd> zzil3 = zzil2;
                    if (zzil2 == null) {
                        synchronized (zzd.class) {
                            zzil<zzd> zzil4 = zzbd;
                            zzil = zzil4;
                            if (zzil4 == null) {
                                ? zzc = new zzgs.zzc(zzmu);
                                zzbd = zzc;
                                zzil = zzc;
                            }
                        }
                        zzil3 = zzil;
                    }
                    return zzil3;
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
