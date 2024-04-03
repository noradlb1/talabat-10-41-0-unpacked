package com.google.android.gms.internal.vision;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

public abstract class zzbe<T> {
    @SuppressLint({"StaticFieldLeak"})
    private static Context zze = null;
    private static final Object zzfy = new Object();
    private static boolean zzfz = false;
    private static zzcu<zzcn<zzba>> zzga;
    private static final AtomicInteger zzgd = new AtomicInteger();

    /* renamed from: name  reason: collision with root package name */
    private final String f44502name;
    private final zzbk zzgb;
    private final T zzgc;
    private volatile int zzge;
    private volatile T zzgf;

    private zzbe(zzbk zzbk, String str, T t11) {
        this.zzge = -1;
        String str2 = zzbk.zzgk;
        if (str2 == null && zzbk.zzgl == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        } else if (str2 == null || zzbk.zzgl == null) {
            this.zzgb = zzbk;
            this.f44502name = str;
            this.zzgc = t11;
        } else {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
    }

    public static void init(Context context) {
        synchronized (zzfy) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zze != context) {
                zzaq.zzx();
                zzbj.zzx();
                zzav.zzaa();
                zzgd.incrementAndGet();
                zze = context;
                zzga = zzcx.zza(zzbd.zzfx);
            }
        }
    }

    public static void maybeInit(Context context) {
        synchronized (zzfy) {
            if (zze == null) {
                init(context);
            }
        }
    }

    /* access modifiers changed from: private */
    public static zzbe<Boolean> zza(zzbk zzbk, String str, boolean z11) {
        return new zzbf(zzbk, str, Boolean.valueOf(z11));
    }

    public static void zzab() {
        zzgd.incrementAndGet();
    }

    @Nullable
    private final T zzad() {
        zzau zzau;
        Object zzb;
        boolean z11;
        boolean z12 = false;
        if (!this.zzgb.zzgq) {
            String str = (String) zzav.zze(zze).zzb("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
            if (str == null || !zzal.zzeu.matcher(str).matches()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                z12 = true;
            }
        }
        if (!z12) {
            zzbk zzbk = this.zzgb;
            Uri uri = zzbk.zzgl;
            if (uri == null) {
                zzau = zzbj.zzb(zze, zzbk.zzgk);
            } else if (!zzbc.zza(zze, uri)) {
                zzau = null;
            } else if (this.zzgb.zzgr) {
                ContentResolver contentResolver = zze.getContentResolver();
                String lastPathSegment = this.zzgb.zzgl.getLastPathSegment();
                String packageName = zze.getPackageName();
                StringBuilder sb2 = new StringBuilder(String.valueOf(lastPathSegment).length() + 1 + String.valueOf(packageName).length());
                sb2.append(lastPathSegment);
                sb2.append("#");
                sb2.append(packageName);
                zzau = zzaq.zza(contentResolver, zzbb.getContentProviderUri(sb2.toString()));
            } else {
                zzau = zzaq.zza(zze.getContentResolver(), this.zzgb.zzgl);
            }
            if (!(zzau == null || (zzb = zzau.zzb(zzac())) == null)) {
                return zza(zzb);
            }
        } else if (Log.isLoggable("PhenotypeFlag", 3)) {
            String valueOf = String.valueOf(zzac());
            if (valueOf.length() != 0) {
                "Bypass reading Phenotype values for flag: ".concat(valueOf);
            }
        }
        return null;
    }

    @Nullable
    private final T zzae() {
        zzcl<Context, Boolean> zzcl;
        String str;
        zzbk zzbk = this.zzgb;
        if (!zzbk.zzgo && ((zzcl = zzbk.zzgs) == null || zzcl.apply(zze).booleanValue())) {
            zzav zze2 = zzav.zze(zze);
            zzbk zzbk2 = this.zzgb;
            if (zzbk2.zzgo) {
                str = null;
            } else {
                str = zze(zzbk2.zzgm);
            }
            Object zzb = zze2.zzb(str);
            if (zzb != null) {
                return zza(zzb);
            }
        }
        return null;
    }

    public static final /* synthetic */ zzcn zzaf() {
        new zzaz();
        return zzaz.zzf(zze);
    }

    private final String zze(String str) {
        if (str != null && str.isEmpty()) {
            return this.f44502name;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.f44502name);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final T get() {
        T t11;
        int i11 = zzgd.get();
        if (this.zzge < i11) {
            synchronized (this) {
                if (this.zzge < i11) {
                    if (zze != null) {
                        zzcn zzcn = zzga.get();
                        if (zzcn.isPresent()) {
                            zzbk zzbk = this.zzgb;
                            String zza = ((zzba) zzcn.get()).zza(zzbk.zzgl, zzbk.zzgk, zzbk.zzgn, this.f44502name);
                            if (zza != null) {
                                t11 = zza(zza);
                                this.zzgf = t11;
                                this.zzge = i11;
                            }
                        } else if (this.zzgb.zzgp) {
                            t11 = zzae();
                            if (t11 == null) {
                                t11 = zzad();
                                if (t11 != null) {
                                }
                            }
                            this.zzgf = t11;
                            this.zzge = i11;
                        } else {
                            t11 = zzad();
                            if (t11 == null) {
                                t11 = zzae();
                                if (t11 != null) {
                                }
                            }
                            this.zzgf = t11;
                            this.zzge = i11;
                        }
                        t11 = this.zzgc;
                        this.zzgf = t11;
                        this.zzge = i11;
                    } else {
                        throw new IllegalStateException("Must call PhenotypeFlag.init() first");
                    }
                }
            }
        }
        return this.zzgf;
    }

    public abstract T zza(Object obj);

    public final String zzac() {
        return zze(this.zzgb.zzgn);
    }

    /* access modifiers changed from: private */
    public static <T> zzbe<T> zza(zzbk zzbk, String str, T t11, zzbh<T> zzbh) {
        return new zzbi(zzbk, str, t11, zzbh);
    }

    public /* synthetic */ zzbe(zzbk zzbk, String str, Object obj, zzbg zzbg) {
        this(zzbk, str, obj);
    }
}
