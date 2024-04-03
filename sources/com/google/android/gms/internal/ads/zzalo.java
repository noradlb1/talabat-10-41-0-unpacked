package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;
import androidx.annotation.VisibleForTesting;
import j$.util.concurrent.ThreadLocalRandom;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;

public final class zzalo {
    @VisibleForTesting
    protected static volatile zzfoj zza = null;
    /* access modifiers changed from: private */
    public static final ConditionVariable zzc = new ConditionVariable();
    private static volatile Random zzd = null;
    @VisibleForTesting
    protected volatile Boolean zzb;
    /* access modifiers changed from: private */
    public final zzams zze;

    public zzalo(zzams zzams) {
        this.zze = zzams;
        zzams.zzk().execute(new zzaln(this));
    }

    public static final int zzd() {
        try {
            return ThreadLocalRandom.current().nextInt();
        } catch (RuntimeException unused) {
            return zze().nextInt();
        }
    }

    private static Random zze() {
        if (zzd == null) {
            synchronized (zzalo.class) {
                if (zzd == null) {
                    zzd = new Random();
                }
            }
        }
        return zzd;
    }

    public final void zzc(int i11, int i12, long j11, String str, Exception exc) {
        try {
            zzc.block();
            if (this.zzb.booleanValue() && zza != null) {
                zzail zza2 = zzaip.zza();
                zza2.zza(this.zze.zza.getPackageName());
                zza2.zze(j11);
                if (str != null) {
                    zza2.zzb(str);
                }
                if (exc != null) {
                    StringWriter stringWriter = new StringWriter();
                    exc.printStackTrace(new PrintWriter(stringWriter));
                    zza2.zzf(stringWriter.toString());
                    zza2.zzd(exc.getClass().getName());
                }
                zzfoi zza3 = zza.zza(((zzaip) zza2.zzah()).zzar());
                zza3.zza(i11);
                if (i12 != -1) {
                    zza3.zzb(i12);
                }
                zza3.zzc();
            }
        } catch (Exception unused) {
        }
    }
}
