package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

final class zzh {
    private long zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    @Nullable
    private String zzE;
    private boolean zzF;
    private long zzG;
    private long zzH;
    private final zzgd zza;
    private final String zzb;
    @Nullable
    private String zzc;
    @Nullable
    private String zzd;
    @Nullable
    private String zze;
    @Nullable
    private String zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    @Nullable
    private String zzj;
    private long zzk;
    @Nullable
    private String zzl;
    private long zzm;
    private long zzn;
    private boolean zzo;
    private boolean zzp;
    @Nullable
    private String zzq;
    @Nullable
    private Boolean zzr;
    private long zzs;
    @Nullable
    private List zzt;
    @Nullable
    private String zzu;
    private boolean zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    @WorkerThread
    public zzh(zzgd zzgd, String str) {
        Preconditions.checkNotNull(zzgd);
        Preconditions.checkNotEmpty(str);
        this.zza = zzgd;
        this.zzb = str;
        zzgd.zzaB().zzg();
    }

    @WorkerThread
    @Nullable
    public final String zzA() {
        this.zza.zzaB().zzg();
        return this.zzd;
    }

    @WorkerThread
    @Nullable
    public final String zzB() {
        this.zza.zzaB().zzg();
        return this.zzE;
    }

    @WorkerThread
    @Nullable
    public final String zzC() {
        this.zza.zzaB().zzg();
        return this.zze;
    }

    @WorkerThread
    @Nullable
    public final String zzD() {
        this.zza.zzaB().zzg();
        return this.zzu;
    }

    @WorkerThread
    @Nullable
    public final List zzE() {
        this.zza.zzaB().zzg();
        return this.zzt;
    }

    @WorkerThread
    public final void zzF() {
        this.zza.zzaB().zzg();
        this.zzF = false;
    }

    @WorkerThread
    public final void zzG() {
        this.zza.zzaB().zzg();
        long j11 = this.zzg + 1;
        if (j11 > 2147483647L) {
            this.zza.zzaA().zzk().zzb("Bundle index overflow. appId", zzet.zzn(this.zzb));
            j11 = 0;
        }
        this.zzF = true;
        this.zzg = j11;
    }

    @WorkerThread
    public final void zzH(@Nullable String str) {
        this.zza.zzaB().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzF |= true ^ zzg.zza(this.zzq, str);
        this.zzq = str;
    }

    @WorkerThread
    public final void zzI(boolean z11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzp != z11;
        this.zzp = z11;
    }

    @WorkerThread
    public final void zzJ(@Nullable String str) {
        this.zza.zzaB().zzg();
        this.zzF |= !zzg.zza(this.zzc, str);
        this.zzc = str;
    }

    @WorkerThread
    public final void zzK(@Nullable String str) {
        this.zza.zzaB().zzg();
        this.zzF |= !zzg.zza(this.zzl, str);
        this.zzl = str;
    }

    @WorkerThread
    public final void zzL(@Nullable String str) {
        this.zza.zzaB().zzg();
        this.zzF |= !zzg.zza(this.zzj, str);
        this.zzj = str;
    }

    @WorkerThread
    public final void zzM(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzk != j11;
        this.zzk = j11;
    }

    @WorkerThread
    public final void zzN(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzG != j11;
        this.zzG = j11;
    }

    @WorkerThread
    public final void zzO(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzB != j11;
        this.zzB = j11;
    }

    @WorkerThread
    public final void zzP(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzC != j11;
        this.zzC = j11;
    }

    @WorkerThread
    public final void zzQ(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzA != j11;
        this.zzA = j11;
    }

    @WorkerThread
    public final void zzR(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzz != j11;
        this.zzz = j11;
    }

    @WorkerThread
    public final void zzS(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzD != j11;
        this.zzD = j11;
    }

    @WorkerThread
    public final void zzT(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzy != j11;
        this.zzy = j11;
    }

    @WorkerThread
    public final void zzU(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzn != j11;
        this.zzn = j11;
    }

    @WorkerThread
    public final void zzV(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzs != j11;
        this.zzs = j11;
    }

    @WorkerThread
    public final void zzW(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzH != j11;
        this.zzH = j11;
    }

    @WorkerThread
    public final void zzX(@Nullable String str) {
        this.zza.zzaB().zzg();
        this.zzF |= !zzg.zza(this.zzf, str);
        this.zzf = str;
    }

    @WorkerThread
    public final void zzY(@Nullable String str) {
        this.zza.zzaB().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzF |= true ^ zzg.zza(this.zzd, str);
        this.zzd = str;
    }

    @WorkerThread
    public final void zzZ(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzm != j11;
        this.zzm = j11;
    }

    @WorkerThread
    public final long zza() {
        this.zza.zzaB().zzg();
        return 0;
    }

    @WorkerThread
    public final void zzaa(@Nullable String str) {
        this.zza.zzaB().zzg();
        this.zzF |= !zzg.zza(this.zzE, str);
        this.zzE = str;
    }

    @WorkerThread
    public final void zzab(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzi != j11;
        this.zzi = j11;
    }

    @WorkerThread
    public final void zzac(long j11) {
        boolean z11;
        boolean z12 = true;
        if (j11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        this.zza.zzaB().zzg();
        boolean z13 = this.zzF;
        if (this.zzg == j11) {
            z12 = false;
        }
        this.zzF = z13 | z12;
        this.zzg = j11;
    }

    @WorkerThread
    public final void zzad(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzh != j11;
        this.zzh = j11;
    }

    @WorkerThread
    public final void zzae(boolean z11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzo != z11;
        this.zzo = z11;
    }

    @WorkerThread
    public final void zzaf(@Nullable Boolean bool) {
        this.zza.zzaB().zzg();
        this.zzF |= !zzg.zza(this.zzr, bool);
        this.zzr = bool;
    }

    @WorkerThread
    public final void zzag(@Nullable String str) {
        this.zza.zzaB().zzg();
        this.zzF |= !zzg.zza(this.zze, str);
        this.zze = str;
    }

    @WorkerThread
    public final void zzah(@Nullable List list) {
        ArrayList arrayList;
        this.zza.zzaB().zzg();
        if (!zzg.zza(this.zzt, list)) {
            this.zzF = true;
            if (list != null) {
                arrayList = new ArrayList(list);
            } else {
                arrayList = null;
            }
            this.zzt = arrayList;
        }
    }

    @WorkerThread
    public final void zzai(@Nullable String str) {
        this.zza.zzaB().zzg();
        this.zzF |= !zzg.zza(this.zzu, str);
        this.zzu = str;
    }

    @WorkerThread
    public final void zzaj(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzx != j11;
        this.zzx = j11;
    }

    @WorkerThread
    public final void zzak(boolean z11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzv != z11;
        this.zzv = z11;
    }

    @WorkerThread
    public final void zzal(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzw != j11;
        this.zzw = j11;
    }

    @WorkerThread
    public final boolean zzam() {
        this.zza.zzaB().zzg();
        return this.zzp;
    }

    @WorkerThread
    public final boolean zzan() {
        this.zza.zzaB().zzg();
        return this.zzo;
    }

    @WorkerThread
    public final boolean zzao() {
        this.zza.zzaB().zzg();
        return this.zzF;
    }

    @WorkerThread
    public final boolean zzap() {
        this.zza.zzaB().zzg();
        return this.zzv;
    }

    @WorkerThread
    public final long zzb() {
        this.zza.zzaB().zzg();
        return this.zzk;
    }

    @WorkerThread
    public final long zzc() {
        this.zza.zzaB().zzg();
        return this.zzG;
    }

    @WorkerThread
    public final long zzd() {
        this.zza.zzaB().zzg();
        return this.zzB;
    }

    @WorkerThread
    public final long zze() {
        this.zza.zzaB().zzg();
        return this.zzC;
    }

    @WorkerThread
    public final long zzf() {
        this.zza.zzaB().zzg();
        return this.zzA;
    }

    @WorkerThread
    public final long zzg() {
        this.zza.zzaB().zzg();
        return this.zzz;
    }

    @WorkerThread
    public final long zzh() {
        this.zza.zzaB().zzg();
        return this.zzD;
    }

    @WorkerThread
    public final long zzi() {
        this.zza.zzaB().zzg();
        return this.zzy;
    }

    @WorkerThread
    public final long zzj() {
        this.zza.zzaB().zzg();
        return this.zzn;
    }

    @WorkerThread
    public final long zzk() {
        this.zza.zzaB().zzg();
        return this.zzs;
    }

    @WorkerThread
    public final long zzl() {
        this.zza.zzaB().zzg();
        return this.zzH;
    }

    @WorkerThread
    public final long zzm() {
        this.zza.zzaB().zzg();
        return this.zzm;
    }

    @WorkerThread
    public final long zzn() {
        this.zza.zzaB().zzg();
        return this.zzi;
    }

    @WorkerThread
    public final long zzo() {
        this.zza.zzaB().zzg();
        return this.zzg;
    }

    @WorkerThread
    public final long zzp() {
        this.zza.zzaB().zzg();
        return this.zzh;
    }

    @WorkerThread
    public final long zzq() {
        this.zza.zzaB().zzg();
        return this.zzx;
    }

    @WorkerThread
    public final long zzr() {
        this.zza.zzaB().zzg();
        return this.zzw;
    }

    @WorkerThread
    @Nullable
    public final Boolean zzs() {
        this.zza.zzaB().zzg();
        return this.zzr;
    }

    @WorkerThread
    @Nullable
    public final String zzt() {
        this.zza.zzaB().zzg();
        return this.zzq;
    }

    @WorkerThread
    @Nullable
    public final String zzu() {
        this.zza.zzaB().zzg();
        String str = this.zzE;
        zzaa((String) null);
        return str;
    }

    @WorkerThread
    public final String zzv() {
        this.zza.zzaB().zzg();
        return this.zzb;
    }

    @WorkerThread
    @Nullable
    public final String zzw() {
        this.zza.zzaB().zzg();
        return this.zzc;
    }

    @WorkerThread
    @Nullable
    public final String zzx() {
        this.zza.zzaB().zzg();
        return this.zzl;
    }

    @WorkerThread
    @Nullable
    public final String zzy() {
        this.zza.zzaB().zzg();
        return this.zzj;
    }

    @WorkerThread
    @Nullable
    public final String zzz() {
        this.zza.zzaB().zzg();
        return this.zzf;
    }
}
