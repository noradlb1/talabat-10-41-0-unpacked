package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import java.util.Iterator;
import java.util.regex.Pattern;

public final class zzfje {
    private final Context zza;
    /* access modifiers changed from: private */
    public long zzb;
    /* access modifiers changed from: private */
    public boolean zzc = false;
    /* access modifiers changed from: private */
    public int zzd = 0;
    /* access modifiers changed from: private */
    public String zze = "";
    /* access modifiers changed from: private */
    public String zzf = "";
    /* access modifiers changed from: private */
    public String zzg = "";
    /* access modifiers changed from: private */
    public final String zzh = "";
    /* access modifiers changed from: private */
    public String zzi = "";
    private boolean zzj = false;
    private boolean zzk = false;
    /* access modifiers changed from: private */
    public int zzl = 2;
    /* access modifiers changed from: private */
    public int zzm = 2;

    private zzfje(Context context, int i11) {
        this.zza = context;
    }

    @Nullable
    public static zzfje zzp(Context context, int i11, int i12, zzbfd zzbfd) {
        zzfje zzfje;
        if (zzfjg.zzb()) {
            zzfje = new zzfje(context, 7);
        } else {
            zzfje = null;
        }
        if (zzfje == null) {
            return null;
        }
        zzfje.zzh();
        zzfje.zzq(i12);
        String str = zzbfd.zzp;
        if (!TextUtils.isEmpty(str)) {
            if (Pattern.matches((String) zzbgq.zzc().zzb(zzblj.zzgw), str)) {
                zzfje.zzf(zzbfd.zzp);
            }
        }
        return zzfje;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.internal.ads.zzfje zzc(com.google.android.gms.internal.ads.zzbew r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            android.os.IBinder r3 = r3.zze     // Catch:{ all -> 0x0023 }
            if (r3 != 0) goto L_0x0007
            monitor-exit(r2)
            return r2
        L_0x0007:
            com.google.android.gms.internal.ads.zzdek r3 = (com.google.android.gms.internal.ads.zzdek) r3     // Catch:{ all -> 0x0023 }
            java.lang.String r0 = r3.zzh()     // Catch:{ all -> 0x0023 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0023 }
            if (r1 != 0) goto L_0x0015
            r2.zze = r0     // Catch:{ all -> 0x0023 }
        L_0x0015:
            java.lang.String r3 = r3.zzf()     // Catch:{ all -> 0x0023 }
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0023 }
            if (r0 != 0) goto L_0x0021
            r2.zzf = r3     // Catch:{ all -> 0x0023 }
        L_0x0021:
            monitor-exit(r2)
            return r2
        L_0x0023:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfje.zzc(com.google.android.gms.internal.ads.zzbew):com.google.android.gms.internal.ads.zzfje");
    }

    public final synchronized zzfje zzd(zzfdy zzfdy) {
        if (!TextUtils.isEmpty(zzfdy.zzb.zzb)) {
            this.zze = zzfdy.zzb.zzb;
        }
        Iterator<zzfdn> it = zzfdy.zza.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            zzfdn next = it.next();
            if (!TextUtils.isEmpty(next.zzY)) {
                this.zzf = next.zzY;
                break;
            }
        }
        return this;
    }

    public final synchronized zzfje zze(String str) {
        this.zzg = str;
        return this;
    }

    public final synchronized zzfje zzf(String str) {
        this.zzi = str;
        return this;
    }

    public final synchronized zzfje zzg(boolean z11) {
        this.zzc = z11;
        return this;
    }

    public final synchronized zzfje zzh() {
        zzt.zzp();
        this.zzd = com.google.android.gms.ads.internal.util.zzt.zzC(this.zza);
        Resources resources = this.zza.getResources();
        int i11 = 2;
        if (resources != null) {
            Configuration configuration = resources.getConfiguration();
            if (configuration != null) {
                i11 = configuration.orientation == 2 ? 4 : 3;
            }
        }
        this.zzm = i11;
        this.zzb = zzt.zzA().currentTimeMillis();
        this.zzk = true;
        return this;
    }

    @Nullable
    public final synchronized zzfjf zzi() {
        if (this.zzj) {
            return null;
        }
        this.zzj = true;
        if (!this.zzk) {
            zzh();
        }
        return new zzfjf(this);
    }

    public final synchronized zzfje zzq(int i11) {
        this.zzl = i11;
        return this;
    }
}
