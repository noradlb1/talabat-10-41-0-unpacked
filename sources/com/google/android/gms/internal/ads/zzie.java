package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzie {
    private final List<zzic> zza = new ArrayList();
    private final IdentityHashMap<zzpy, zzic> zzb = new IdentityHashMap<>();
    private final Map<Object, zzic> zzc = new HashMap();
    private final zzid zzd;
    /* access modifiers changed from: private */
    public final zzqi zze;
    /* access modifiers changed from: private */
    public final zzne zzf;
    private final HashMap<zzic, zzib> zzg;
    private final Set<zzic> zzh;
    private boolean zzi;
    @Nullable
    private zzdx zzj;
    private zzrq zzk = new zzrq(0);

    public zzie(zzid zzid, @Nullable zzlb zzlb, Handler handler) {
        this.zzd = zzid;
        zzqi zzqi = new zzqi();
        this.zze = zzqi;
        zzne zzne = new zzne();
        this.zzf = zzne;
        this.zzg = new HashMap<>();
        this.zzh = new HashSet();
        zzqi.zzb(handler, zzlb);
        zzne.zzb(handler, zzlb);
    }

    private final void zzp(int i11, int i12) {
        while (i11 < this.zza.size()) {
            this.zza.get(i11).zzd += i12;
            i11++;
        }
    }

    private final void zzq(zzic zzic) {
        zzib zzib = this.zzg.get(zzic);
        if (zzib != null) {
            zzib.zza.zzh(zzib.zzb);
        }
    }

    private final void zzr() {
        Iterator<zzic> it = this.zzh.iterator();
        while (it.hasNext()) {
            zzic next = it.next();
            if (next.zzc.isEmpty()) {
                zzq(next);
                it.remove();
            }
        }
    }

    private final void zzs(zzic zzic) {
        if (zzic.zze && zzic.zzc.isEmpty()) {
            zzib remove = this.zzg.remove(zzic);
            remove.getClass();
            remove.zza.zzo(remove.zzb);
            remove.zza.zzr(remove.zzc);
            remove.zza.zzq(remove.zzc);
            this.zzh.remove(zzic);
        }
    }

    private final void zzt(zzic zzic) {
        zzpv zzpv = zzic.zza;
        zzhz zzhz = new zzhz(this);
        zzia zzia = new zzia(this, zzic);
        this.zzg.put(zzic, new zzib(zzpv, zzhz, zzia));
        zzpv.zzg(new Handler(zzfn.zzA(), (Handler.Callback) null), zzia);
        zzpv.zzf(new Handler(zzfn.zzA(), (Handler.Callback) null), zzia);
        zzpv.zzl(zzhz, this.zzj);
    }

    private final void zzu(int i11, int i12) {
        while (true) {
            i12--;
            if (i12 >= i11) {
                zzic remove = this.zza.remove(i12);
                this.zzc.remove(remove.zzb);
                zzp(i12, -remove.zza.zzz().zzc());
                remove.zze = true;
                if (this.zzi) {
                    zzs(remove);
                }
            } else {
                return;
            }
        }
    }

    public final int zza() {
        return this.zza.size();
    }

    public final zzcd zzb() {
        if (this.zza.isEmpty()) {
            return zzcd.zza;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.zza.size(); i12++) {
            zzic zzic = this.zza.get(i12);
            zzic.zzd = i11;
            i11 += zzic.zza.zzz().zzc();
        }
        return new zzij(this.zza, this.zzk, (zzrq) null);
    }

    public final /* synthetic */ void zze(zzqb zzqb, zzcd zzcd) {
        this.zzd.zzh();
    }

    public final void zzf(@Nullable zzdx zzdx) {
        zzdy.zzf(!this.zzi);
        this.zzj = zzdx;
        for (int i11 = 0; i11 < this.zza.size(); i11++) {
            zzic zzic = this.zza.get(i11);
            zzt(zzic);
            this.zzh.add(zzic);
        }
        this.zzi = true;
    }

    public final void zzg() {
        for (zzib next : this.zzg.values()) {
            try {
                next.zza.zzo(next.zzb);
            } catch (RuntimeException e11) {
                zzep.zza("MediaSourceList", "Failed to release child source.", e11);
            }
            next.zza.zzr(next.zzc);
            next.zza.zzq(next.zzc);
        }
        this.zzg.clear();
        this.zzh.clear();
        this.zzi = false;
    }

    public final void zzh(zzpy zzpy) {
        zzic remove = this.zzb.remove(zzpy);
        remove.getClass();
        remove.zza.zzA(zzpy);
        remove.zzc.remove(((zzps) zzpy).zza);
        if (!this.zzb.isEmpty()) {
            zzr();
        }
        zzs(remove);
    }

    public final boolean zzi() {
        return this.zzi;
    }

    public final zzcd zzj(int i11, List<zzic> list, zzrq zzrq) {
        if (!list.isEmpty()) {
            this.zzk = zzrq;
            for (int i12 = i11; i12 < list.size() + i11; i12++) {
                zzic zzic = list.get(i12 - i11);
                if (i12 > 0) {
                    zzic zzic2 = this.zza.get(i12 - 1);
                    zzic.zzc(zzic2.zzd + zzic2.zza.zzz().zzc());
                } else {
                    zzic.zzc(0);
                }
                zzp(i12, zzic.zza.zzz().zzc());
                this.zza.add(i12, zzic);
                this.zzc.put(zzic.zzb, zzic);
                if (this.zzi) {
                    zzt(zzic);
                    if (this.zzb.isEmpty()) {
                        this.zzh.add(zzic);
                    } else {
                        zzq(zzic);
                    }
                }
            }
        }
        return zzb();
    }

    public final zzcd zzk(int i11, int i12, int i13, zzrq zzrq) {
        boolean z11;
        if (zza() >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzd(z11);
        this.zzk = null;
        return zzb();
    }

    public final zzcd zzl(int i11, int i12, zzrq zzrq) {
        boolean z11 = false;
        if (i11 >= 0 && i11 <= i12 && i12 <= zza()) {
            z11 = true;
        }
        zzdy.zzd(z11);
        this.zzk = zzrq;
        zzu(i11, i12);
        return zzb();
    }

    public final zzcd zzm(List<zzic> list, zzrq zzrq) {
        zzu(0, this.zza.size());
        return zzj(this.zza.size(), list, zzrq);
    }

    public final zzcd zzn(zzrq zzrq) {
        int zza2 = zza();
        if (zzrq.zzc() != zza2) {
            zzrq = zzrq.zzf().zzg(0, zza2);
        }
        this.zzk = zzrq;
        return zzb();
    }

    public final zzpy zzo(zzpz zzpz, zztk zztk, long j11) {
        Object obj = zzpz.zza;
        Object obj2 = ((Pair) obj).first;
        zzpz zzc2 = zzpz.zzc(((Pair) obj).second);
        zzic zzic = this.zzc.get(obj2);
        zzic.getClass();
        this.zzh.add(zzic);
        zzib zzib = this.zzg.get(zzic);
        if (zzib != null) {
            zzib.zza.zzj(zzib.zzb);
        }
        zzic.zzc.add(zzc2);
        zzps zzB = zzic.zza.zzC(zzc2, zztk, j11);
        this.zzb.put(zzB, zzic);
        zzr();
        return zzB;
    }
}
