package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.AdError;

public class zzemv extends zzbxm {
    private final zzdep zza;
    private final zzdmb zzb;
    private final zzdfj zzc;
    private final zzdfy zzd;
    private final zzdgd zze;
    private final zzdjo zzf;
    private final zzdgx zzg;
    private final zzdmt zzh;
    private final zzdjk zzi;
    private final zzdfe zzj;

    public zzemv(zzdep zzdep, zzdmb zzdmb, zzdfj zzdfj, zzdfy zzdfy, zzdgd zzdgd, zzdjo zzdjo, zzdgx zzdgx, zzdmt zzdmt, zzdjk zzdjk, zzdfe zzdfe) {
        this.zza = zzdep;
        this.zzb = zzdmb;
        this.zzc = zzdfj;
        this.zzd = zzdfy;
        this.zze = zzdgd;
        this.zzf = zzdjo;
        this.zzg = zzdgx;
        this.zzh = zzdmt;
        this.zzi = zzdjk;
        this.zzj = zzdfe;
    }

    public final void zze() {
        this.zza.onAdClicked();
        this.zzb.zzq();
    }

    public final void zzf() {
        this.zzg.zzf(4);
    }

    public final void zzg(int i11) {
    }

    public final void zzh(zzbew zzbew) {
    }

    public final void zzi(int i11, String str) {
    }

    @Deprecated
    public final void zzj(int i11) throws RemoteException {
        zzk(new zzbew(i11, "", AdError.UNDEFINED_DOMAIN, (zzbew) null, (IBinder) null));
    }

    public final void zzk(zzbew zzbew) {
        this.zzj.zza(zzfey.zzc(8, zzbew));
    }

    public final void zzl(String str) {
        zzk(new zzbew(0, str, AdError.UNDEFINED_DOMAIN, (zzbew) null, (IBinder) null));
    }

    public void zzm() {
        this.zzc.zza();
        this.zzi.zzb();
    }

    public final void zzn() {
        this.zzd.zzb();
    }

    public final void zzo() {
        this.zze.zzn();
    }

    public final void zzp() {
        this.zzg.zzb();
        this.zzi.zza();
    }

    public final void zzq(String str, String str2) {
        this.zzf.zzbL(str, str2);
    }

    public final void zzr(zzbpc zzbpc, String str) {
    }

    public void zzs(zzces zzces) {
    }

    public void zzt(zzcew zzcew) throws RemoteException {
    }

    public void zzu() throws RemoteException {
    }

    public void zzv() {
        this.zzh.zza();
    }

    public final void zzw() {
        this.zzh.zzb();
    }

    public final void zzx() throws RemoteException {
        this.zzh.zzc();
    }

    public void zzy() {
        this.zzh.zzd();
    }
}
