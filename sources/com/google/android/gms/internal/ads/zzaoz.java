package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.exoplayer2.C;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class zzaoz implements zzaow {
    private final zzapl[] zza;
    private final zzavr zzb;
    private final zzavp zzc;
    private final Handler zzd;
    private final zzape zze;
    private final CopyOnWriteArraySet<zzaot> zzf = new CopyOnWriteArraySet<>();
    private final zzapq zzg;
    private final zzapp zzh;
    private boolean zzi;
    private boolean zzj = false;
    private int zzk = 1;
    private int zzl;
    private int zzm;
    private boolean zzn;
    private zzapr zzo;
    private Object zzp;
    private zzavd zzq;
    private zzavp zzr;
    private zzapk zzs;
    private zzapb zzt;
    private long zzu;

    @SuppressLint({"HandlerLeak"})
    public zzaoz(zzapl[] zzaplArr, zzavr zzavr, zzcmd zzcmd, byte[] bArr) {
        Looper looper;
        String str = zzaxb.zze;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 26);
        sb2.append("Init ExoPlayerLib/2.4.2 [");
        sb2.append(str);
        sb2.append("]");
        Log.i("ExoPlayerImpl", sb2.toString());
        this.zza = zzaplArr;
        zzavr.getClass();
        this.zzb = zzavr;
        zzavp zzavp = new zzavp(new zzavh[2], (byte[]) null);
        this.zzc = zzavp;
        this.zzo = zzapr.zza;
        this.zzg = new zzapq();
        this.zzh = new zzapp();
        this.zzq = zzavd.zza;
        this.zzr = zzavp;
        this.zzs = zzapk.zza;
        if (Looper.myLooper() != null) {
            looper = Looper.myLooper();
        } else {
            looper = Looper.getMainLooper();
        }
        zzaoy zzaoy = new zzaoy(this, looper);
        this.zzd = zzaoy;
        zzapb zzapb = new zzapb(0, 0);
        this.zzt = zzapb;
        this.zze = new zzape(zzaplArr, zzavr, zzcmd, this.zzj, 0, zzaoy, zzapb, this, (byte[]) null);
    }

    public final int zza() {
        return this.zzk;
    }

    public final long zzb() {
        if (this.zzo.zzh() || this.zzl > 0) {
            return this.zzu;
        }
        this.zzo.zzd(this.zzt.zza, this.zzh, false);
        return zzaor.zzb(0) + zzaor.zzb(this.zzt.zzd);
    }

    public final long zzc() {
        if (this.zzo.zzh() || this.zzl > 0) {
            return this.zzu;
        }
        this.zzo.zzd(this.zzt.zza, this.zzh, false);
        return zzaor.zzb(0) + zzaor.zzb(this.zzt.zzc);
    }

    public final long zzd() {
        if (this.zzo.zzh()) {
            return C.TIME_UNSET;
        }
        zzapr zzapr = this.zzo;
        zzr();
        return zzaor.zzb(zzapr.zzg(0, this.zzg, false).zza);
    }

    public final void zze(zzaot zzaot) {
        this.zzf.add(zzaot);
    }

    public final void zzf(zzaov... zzaovArr) {
        this.zze.zza(zzaovArr);
    }

    public final void zzg() {
        this.zze.zzb();
    }

    public final void zzh(zzauo zzauo) {
        if (!this.zzo.zzh() || this.zzp != null) {
            this.zzo = zzapr.zza;
            this.zzp = null;
            Iterator<zzaot> it = this.zzf.iterator();
            while (it.hasNext()) {
                it.next().zzf(this.zzo, this.zzp);
            }
        }
        if (this.zzi) {
            this.zzi = false;
            this.zzq = zzavd.zza;
            this.zzr = this.zzc;
            this.zzb.zzd((Object) null);
            Iterator<zzaot> it2 = this.zzf.iterator();
            while (it2.hasNext()) {
                it2.next().zzg(this.zzq, this.zzr);
            }
        }
        this.zzm++;
        this.zze.zzg(zzauo, true);
    }

    public final void zzi() {
        this.zze.zzh();
        this.zzd.removeCallbacksAndMessages((Object) null);
    }

    public final void zzj(zzaot zzaot) {
        this.zzf.remove(zzaot);
    }

    public final void zzk(long j11) {
        zzr();
        if (this.zzo.zzh() || this.zzo.zzc() > 0) {
            this.zzl++;
            if (!this.zzo.zzh()) {
                this.zzo.zzg(0, this.zzg, false);
                long zza2 = zzaor.zza(j11);
                long j12 = this.zzo.zzd(0, this.zzh, false).zzc;
                if (j12 != C.TIME_UNSET) {
                    int i11 = (zza2 > j12 ? 1 : (zza2 == j12 ? 0 : -1));
                }
            }
            this.zzu = j11;
            this.zze.zzi(this.zzo, 0, zzaor.zza(j11));
            Iterator<zzaot> it = this.zzf.iterator();
            while (it.hasNext()) {
                it.next().zze();
            }
            return;
        }
        throw new zzapi(this.zzo, 0, j11);
    }

    public final void zzl(zzaov... zzaovArr) {
        this.zze.zzj(zzaovArr);
    }

    public final void zzm(int i11) {
        this.zze.zzk(i11);
    }

    public final void zzn(int i11) {
        this.zze.zzl(i11);
    }

    public final void zzo(boolean z11) {
        if (this.zzj != z11) {
            this.zzj = z11;
            this.zze.zzm(z11);
            Iterator<zzaot> it = this.zzf.iterator();
            while (it.hasNext()) {
                it.next().zzd(z11, this.zzk);
            }
        }
    }

    public final void zzp() {
        this.zze.zzn();
    }

    public final boolean zzq() {
        return this.zzj;
    }

    public final int zzr() {
        if (!this.zzo.zzh() && this.zzl <= 0) {
            this.zzo.zzd(this.zzt.zza, this.zzh, false);
        }
        return 0;
    }

    public final void zzs(Message message) {
        boolean z11 = true;
        switch (message.what) {
            case 0:
                this.zzm--;
                return;
            case 1:
                this.zzk = message.arg1;
                Iterator<zzaot> it = this.zzf.iterator();
                while (it.hasNext()) {
                    it.next().zzd(this.zzj, this.zzk);
                }
                return;
            case 2:
                if (message.arg1 == 0) {
                    z11 = false;
                }
                this.zzn = z11;
                Iterator<zzaot> it2 = this.zzf.iterator();
                while (it2.hasNext()) {
                    it2.next().zza(this.zzn);
                }
                return;
            case 3:
                if (this.zzm == 0) {
                    zzavs zzavs = (zzavs) message.obj;
                    this.zzi = true;
                    this.zzq = zzavs.zza;
                    this.zzr = zzavs.zzb;
                    this.zzb.zzd(zzavs.zzc);
                    Iterator<zzaot> it3 = this.zzf.iterator();
                    while (it3.hasNext()) {
                        it3.next().zzg(this.zzq, this.zzr);
                    }
                    return;
                }
                return;
            case 4:
                int i11 = this.zzl - 1;
                this.zzl = i11;
                if (i11 == 0) {
                    this.zzt = (zzapb) message.obj;
                    if (message.arg1 != 0) {
                        Iterator<zzaot> it4 = this.zzf.iterator();
                        while (it4.hasNext()) {
                            it4.next().zze();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.zzl == 0) {
                    this.zzt = (zzapb) message.obj;
                    Iterator<zzaot> it5 = this.zzf.iterator();
                    while (it5.hasNext()) {
                        it5.next().zze();
                    }
                    return;
                }
                return;
            case 6:
                zzapd zzapd = (zzapd) message.obj;
                this.zzl -= zzapd.zzd;
                if (this.zzm == 0) {
                    this.zzo = zzapd.zza;
                    this.zzp = zzapd.zzb;
                    this.zzt = zzapd.zzc;
                    Iterator<zzaot> it6 = this.zzf.iterator();
                    while (it6.hasNext()) {
                        it6.next().zzf(this.zzo, this.zzp);
                    }
                    return;
                }
                return;
            case 7:
                zzapk zzapk = (zzapk) message.obj;
                if (!this.zzs.equals(zzapk)) {
                    this.zzs = zzapk;
                    Iterator<zzaot> it7 = this.zzf.iterator();
                    while (it7.hasNext()) {
                        it7.next().zzb(zzapk);
                    }
                    return;
                }
                return;
            case 8:
                zzaos zzaos = (zzaos) message.obj;
                Iterator<zzaot> it8 = this.zzf.iterator();
                while (it8.hasNext()) {
                    it8.next().zzc(zzaos);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }
}
