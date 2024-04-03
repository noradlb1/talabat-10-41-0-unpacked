package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.TextureView;
import androidx.annotation.Nullable;
import java.util.Iterator;

final class zzir implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, zzvp, zzlt, zzrv, zzpb, zzfv, zzfr, zziw, zzbs, zzgh {
    final /* synthetic */ zziu zza;

    public /* synthetic */ zzir(zziu zziu, zziq zziq) {
        this.zza = zziu;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
        zziu.zzL(this.zza, surfaceTexture);
        this.zza.zzad(i11, i12);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.zza.zzag((Object) null);
        this.zza.zzad(0, 0);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
        this.zza.zzad(i11, i12);
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
        this.zza.zzad(i12, i13);
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.zza.zzad(0, 0);
    }

    public final void zzA(long j11) {
        this.zza.zzi.zzA(j11);
    }

    public final void zzB(Exception exc) {
        this.zza.zzi.zzB(exc);
    }

    public final void zzC(int i11, long j11, long j12) {
        this.zza.zzi.zzC(i11, j11, j12);
    }

    public final void zzD(int i11, long j11) {
        this.zza.zzi.zzD(i11, j11);
    }

    public final void zzE(Object obj, long j11) {
        this.zza.zzi.zzE(obj, j11);
        if (this.zza.zzr == obj) {
            Iterator it = this.zza.zzh.iterator();
            while (it.hasNext()) {
                ((zzbt) it.next()).zzbj();
            }
        }
    }

    public final void zzF(Exception exc) {
        this.zza.zzi.zzF(exc);
    }

    public final void zzG(String str, long j11, long j12) {
        this.zza.zzi.zzG(str, j11, j12);
    }

    public final void zzH(String str) {
        this.zza.zzi.zzH(str);
    }

    public final void zzI(zzfy zzfy) {
        this.zza.zzi.zzI(zzfy);
        this.zza.zzo = null;
        this.zza.zzw = null;
    }

    public final void zzJ(zzfy zzfy) {
        this.zza.zzw = zzfy;
        this.zza.zzi.zzJ(zzfy);
    }

    public final void zzK(long j11, int i11) {
        this.zza.zzi.zzK(j11, i11);
    }

    public final void zzL(zzab zzab, @Nullable zzfz zzfz) {
        this.zza.zzo = zzab;
        this.zza.zzi.zzL(zzab, zzfz);
    }

    public final /* synthetic */ void zza(zzbr zzbr) {
    }

    public final void zzb(boolean z11) {
    }

    public final /* synthetic */ void zzbh(zzaz zzaz, int i11) {
    }

    public final /* synthetic */ void zzbi(zzbe zzbe) {
    }

    public final /* synthetic */ void zzc(boolean z11) {
    }

    public final void zzf(boolean z11, int i11) {
        zziu.zzO(this.zza);
    }

    public final /* synthetic */ void zzg(zzbn zzbn) {
    }

    public final void zzh(int i11) {
        zziu.zzO(this.zza);
    }

    public final /* synthetic */ void zzi(int i11) {
    }

    public final /* synthetic */ void zzj(zzbl zzbl) {
    }

    public final /* synthetic */ void zzk(boolean z11, int i11) {
    }

    public final /* synthetic */ void zzl(zzbv zzbv, zzbv zzbv2, int i11) {
    }

    public final /* synthetic */ void zzm() {
    }

    public final /* synthetic */ void zzn(zzcd zzcd, int i11) {
    }

    public final /* synthetic */ void zzo(zzch zzch, zzci zzci) {
    }

    public final /* synthetic */ void zzp(zzcr zzcr) {
    }

    public final /* synthetic */ void zzq(boolean z11) {
    }

    public final void zzr(boolean z11) {
        zziu.zzO(this.zza);
    }

    public final void zzs(Exception exc) {
        this.zza.zzi.zzs(exc);
    }

    public final void zzt(boolean z11) {
        if (this.zza.zzB != z11) {
            this.zza.zzB = z11;
            zziu.zzJ(this.zza);
        }
    }

    public final void zzu(String str, long j11, long j12) {
        this.zza.zzi.zzu(str, j11, j12);
    }

    public final void zzv(zzct zzct) {
        this.zza.zzG = zzct;
        this.zza.zzi.zzv(zzct);
        Iterator it = this.zza.zzh.iterator();
        while (it.hasNext()) {
            ((zzbt) it.next()).zzv(zzct);
        }
    }

    public final void zzw(String str) {
        this.zza.zzi.zzw(str);
    }

    public final void zzx(zzfy zzfy) {
        this.zza.zzi.zzx(zzfy);
        this.zza.zzp = null;
        this.zza.zzx = null;
    }

    public final void zzy(zzfy zzfy) {
        this.zza.zzx = zzfy;
        this.zza.zzi.zzy(zzfy);
    }

    public final void zzz(zzab zzab, @Nullable zzfz zzfz) {
        this.zza.zzp = zzab;
        this.zza.zzi.zzz(zzab, zzfz);
    }
}
