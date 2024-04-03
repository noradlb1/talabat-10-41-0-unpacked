package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.apache.commons.lang3.StringUtils;

final class zzffo implements zzffn {
    @GuardedBy("this")
    private final ConcurrentHashMap<zzffx, zzffm> zza;
    private final zzffu zzb;
    private final zzffq zzc = new zzffq();

    public zzffo(zzffu zzffu) {
        this.zza = new ConcurrentHashMap<>(zzffu.zzd);
        this.zzb = zzffu;
    }

    private final void zzf() {
        Parcelable.Creator<zzffu> creator = zzffu.CREATOR;
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzeN)).booleanValue()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.zzb.zzb);
            sb2.append(" PoolCollection");
            sb2.append(this.zzc.zzb());
            int i11 = 0;
            for (Map.Entry next : this.zza.entrySet()) {
                i11++;
                sb2.append(i11);
                sb2.append(". ");
                sb2.append(next.getValue());
                sb2.append("#");
                sb2.append(((zzffx) next.getKey()).hashCode());
                sb2.append("    ");
                for (int i12 = 0; i12 < ((zzffm) next.getValue()).zzb(); i12++) {
                    sb2.append("[O]");
                }
                for (int zzb2 = ((zzffm) next.getValue()).zzb(); zzb2 < this.zzb.zzd; zzb2++) {
                    sb2.append("[ ]");
                }
                sb2.append(StringUtils.LF);
                sb2.append(((zzffm) next.getValue()).zzg());
                sb2.append(StringUtils.LF);
            }
            while (i11 < this.zzb.zzc) {
                i11++;
                sb2.append(i11);
                sb2.append(".\n");
            }
            zzciz.zze(sb2.toString());
        }
    }

    public final zzffu zza() {
        return this.zzb;
    }

    @Nullable
    public final synchronized zzffw<?, ?> zzb(zzffx zzffx) {
        zzffw<?, ?> zzffw;
        zzffm zzffm = this.zza.get(zzffx);
        if (zzffm != null) {
            zzffw = zzffm.zze();
            if (zzffw == null) {
                this.zzc.zze();
            }
            zzfgk zzf = zzffm.zzf();
            if (zzffw != null) {
                zzbbl zza2 = zzbbr.zza();
                zzbbj zza3 = zzbbk.zza();
                zza3.zzd(2);
                zzbbn zza4 = zzbbo.zza();
                zza4.zza(zzf.zza);
                zza4.zzb(zzf.zzb);
                zza3.zza(zza4);
                zza2.zza(zza3);
                zzffw.zza.zzb().zzc().zzc((zzbbr) zza2.zzah());
            }
            zzf();
        } else {
            this.zzc.zzf();
            zzf();
            zzffw = null;
        }
        return zzffw;
    }

    @Deprecated
    public final zzffx zzc(zzbfd zzbfd, String str, zzbfo zzbfo) {
        return new zzffy(zzbfd, str, new zzcdu(this.zzb.zza).zza().zzk, this.zzb.zzf, zzbfo);
    }

    public final synchronized boolean zzd(zzffx zzffx, zzffw<?, ?> zzffw) {
        boolean zzh;
        zzffm zzffm = this.zza.get(zzffx);
        zzffw.zzd = zzt.zzA().currentTimeMillis();
        if (zzffm == null) {
            zzffu zzffu = this.zzb;
            zzffm = new zzffm(zzffu.zzd, zzffu.zze * 1000);
            int size = this.zza.size();
            zzffu zzffu2 = this.zzb;
            if (size == zzffu2.zzc) {
                int i11 = zzffu2.zzg;
                int i12 = i11 - 1;
                zzffx zzffx2 = null;
                if (i11 != 0) {
                    long j11 = Long.MAX_VALUE;
                    if (i12 == 0) {
                        for (Map.Entry next : this.zza.entrySet()) {
                            if (((zzffm) next.getValue()).zzc() < j11) {
                                j11 = ((zzffm) next.getValue()).zzc();
                                zzffx2 = (zzffx) next.getKey();
                            }
                        }
                        if (zzffx2 != null) {
                            this.zza.remove(zzffx2);
                        }
                    } else if (i12 == 1) {
                        for (Map.Entry next2 : this.zza.entrySet()) {
                            if (((zzffm) next2.getValue()).zzd() < j11) {
                                j11 = ((zzffm) next2.getValue()).zzd();
                                zzffx2 = (zzffx) next2.getKey();
                            }
                        }
                        if (zzffx2 != null) {
                            this.zza.remove(zzffx2);
                        }
                    } else if (i12 == 2) {
                        int i13 = Integer.MAX_VALUE;
                        for (Map.Entry next3 : this.zza.entrySet()) {
                            if (((zzffm) next3.getValue()).zza() < i13) {
                                i13 = ((zzffm) next3.getValue()).zza();
                                zzffx2 = (zzffx) next3.getKey();
                            }
                        }
                        if (zzffx2 != null) {
                            this.zza.remove(zzffx2);
                        }
                    }
                    this.zzc.zzg();
                } else {
                    throw null;
                }
            }
            this.zza.put(zzffx, zzffm);
            this.zzc.zzd();
        }
        zzh = zzffm.zzh(zzffw);
        this.zzc.zzc();
        zzffp zza2 = this.zzc.zza();
        zzfgk zzf = zzffm.zzf();
        zzbbl zza3 = zzbbr.zza();
        zzbbj zza4 = zzbbk.zza();
        zza4.zzd(2);
        zzbbp zza5 = zzbbq.zza();
        zza5.zza(zza2.zza);
        zza5.zzb(zza2.zzb);
        zza5.zzc(zzf.zzb);
        zza4.zzc(zza5);
        zza3.zza(zza4);
        zzffw.zza.zzb().zzc().zzf((zzbbr) zza3.zzah());
        zzf();
        return zzh;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        if (r3.zzb() >= r2.zzb.zzd) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zze(com.google.android.gms.internal.ads.zzffx r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            j$.util.concurrent.ConcurrentHashMap<com.google.android.gms.internal.ads.zzffx, com.google.android.gms.internal.ads.zzffm> r0 = r2.zza     // Catch:{ all -> 0x001c }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x001c }
            com.google.android.gms.internal.ads.zzffm r3 = (com.google.android.gms.internal.ads.zzffm) r3     // Catch:{ all -> 0x001c }
            r0 = 1
            if (r3 == 0) goto L_0x001a
            int r3 = r3.zzb()     // Catch:{ all -> 0x001c }
            com.google.android.gms.internal.ads.zzffu r1 = r2.zzb     // Catch:{ all -> 0x001c }
            int r1 = r1.zzd     // Catch:{ all -> 0x001c }
            monitor-exit(r2)
            if (r3 >= r1) goto L_0x0018
            return r0
        L_0x0018:
            r3 = 0
            return r3
        L_0x001a:
            monitor-exit(r2)
            return r0
        L_0x001c:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzffo.zze(com.google.android.gms.internal.ads.zzffx):boolean");
    }
}
