package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashSet;

public abstract class zzpc implements zzqb {
    private final ArrayList<zzqa> zza = new ArrayList<>(1);
    private final HashSet<zzqa> zzb = new HashSet<>(1);
    private final zzqi zzc = new zzqi();
    private final zzne zzd = new zzne();
    @Nullable
    private Looper zze;
    @Nullable
    private zzcd zzf;

    public final /* synthetic */ zzcd zzF() {
        return null;
    }

    public final zzne zzb(@Nullable zzpz zzpz) {
        return this.zzd.zza(0, zzpz);
    }

    public final zzne zzc(int i11, @Nullable zzpz zzpz) {
        return this.zzd.zza(i11, zzpz);
    }

    public final zzqi zzd(@Nullable zzpz zzpz) {
        return this.zzc.zza(0, zzpz, 0);
    }

    public final zzqi zze(int i11, @Nullable zzpz zzpz, long j11) {
        return this.zzc.zza(i11, zzpz, 0);
    }

    public final void zzf(Handler handler, zznf zznf) {
        zznf.getClass();
        this.zzd.zzb(handler, zznf);
    }

    public final void zzg(Handler handler, zzqj zzqj) {
        zzqj.getClass();
        this.zzc.zzb(handler, zzqj);
    }

    public final void zzh(zzqa zzqa) {
        boolean isEmpty = this.zzb.isEmpty();
        this.zzb.remove(zzqa);
        if ((!isEmpty) && this.zzb.isEmpty()) {
            zzi();
        }
    }

    public void zzi() {
    }

    public final void zzj(zzqa zzqa) {
        this.zze.getClass();
        boolean isEmpty = this.zzb.isEmpty();
        this.zzb.add(zzqa);
        if (isEmpty) {
            zzk();
        }
    }

    public void zzk() {
    }

    public final void zzl(zzqa zzqa, @Nullable zzdx zzdx) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.zze;
        boolean z11 = true;
        if (!(looper == null || looper == myLooper)) {
            z11 = false;
        }
        zzdy.zzd(z11);
        zzcd zzcd = this.zzf;
        this.zza.add(zzqa);
        if (this.zze == null) {
            this.zze = myLooper;
            this.zzb.add(zzqa);
            zzm(zzdx);
        } else if (zzcd != null) {
            zzj(zzqa);
            zzqa.zza(this, zzcd);
        }
    }

    public abstract void zzm(@Nullable zzdx zzdx);

    public final void zzn(zzcd zzcd) {
        this.zzf = zzcd;
        ArrayList<zzqa> arrayList = this.zza;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.get(i11).zza(this, zzcd);
        }
    }

    public final void zzo(zzqa zzqa) {
        this.zza.remove(zzqa);
        if (this.zza.isEmpty()) {
            this.zze = null;
            this.zzf = null;
            this.zzb.clear();
            zzp();
            return;
        }
        zzh(zzqa);
    }

    public abstract void zzp();

    public final void zzq(zznf zznf) {
        this.zzd.zzc(zznf);
    }

    public final void zzr(zzqj zzqj) {
        this.zzc.zzm(zzqj);
    }

    public final boolean zzs() {
        return !this.zzb.isEmpty();
    }

    public final /* synthetic */ boolean zzt() {
        return true;
    }
}
