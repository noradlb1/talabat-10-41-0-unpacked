package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

@TargetApi(16)
public final class zzcly extends zzcko implements TextureView.SurfaceTextureListener, zzckx {
    private final zzclh zzc;
    private final zzcli zzd;
    private final boolean zze;
    private final zzclg zzf;
    private zzckn zzg;
    private Surface zzh;
    private zzcky zzi;
    private String zzj;
    private String[] zzk;
    private boolean zzl;
    private int zzm = 1;
    private zzclf zzn;
    private final boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private float zzv;

    public zzcly(Context context, zzcli zzcli, zzclh zzclh, boolean z11, boolean z12, zzclg zzclg) {
        super(context);
        this.zze = z12;
        this.zzc = zzclh;
        this.zzd = zzcli;
        this.zzo = z11;
        this.zzf = zzclg;
        setSurfaceTextureListener(this);
        zzcli.zza(this);
    }

    private static String zzR(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        int length = String.valueOf(canonicalName).length();
        StringBuilder sb2 = new StringBuilder(str.length() + 2 + length + String.valueOf(message).length());
        sb2.append(str);
        sb2.append("/");
        sb2.append(canonicalName);
        sb2.append(CertificateUtil.DELIMITER);
        sb2.append(message);
        return sb2.toString();
    }

    private final void zzS() {
        zzcky zzcky = this.zzi;
        if (zzcky != null) {
            zzcky.zzK(true);
        }
    }

    private final void zzT() {
        if (!this.zzp) {
            this.zzp = true;
            zzt.zza.post(new zzclp(this));
            zzn();
            this.zzd.zzb();
            if (this.zzq) {
                zzp();
            }
        }
    }

    private final void zzU(boolean z11) {
        String str;
        if ((this.zzi == null || z11) && this.zzj != null && this.zzh != null) {
            if (z11) {
                if (zzac()) {
                    this.zzi.zzO();
                    zzW();
                } else {
                    zzciz.zzj("No valid ExoPlayerAdapter exists when switch source.");
                    return;
                }
            }
            if (this.zzj.startsWith("cache:")) {
                zzcnf zzr2 = this.zzc.zzr(this.zzj);
                if (zzr2 instanceof zzcno) {
                    zzcky zzj2 = ((zzcno) zzr2).zzj();
                    this.zzi = zzj2;
                    if (!zzj2.zzP()) {
                        zzciz.zzj("Precached video player has been released.");
                        return;
                    }
                } else if (zzr2 instanceof zzcnl) {
                    zzcnl zzcnl = (zzcnl) zzr2;
                    String zzE = zzE();
                    ByteBuffer zzl2 = zzcnl.zzl();
                    boolean zzm2 = zzcnl.zzm();
                    String zzi2 = zzcnl.zzi();
                    if (zzi2 == null) {
                        zzciz.zzj("Stream cache URL is null.");
                        return;
                    }
                    zzcky zzD = zzD();
                    this.zzi = zzD;
                    zzD.zzB(new Uri[]{Uri.parse(zzi2)}, zzE, zzl2, zzm2);
                } else {
                    String valueOf = String.valueOf(this.zzj);
                    if (valueOf.length() != 0) {
                        str = "Stream cache miss: ".concat(valueOf);
                    } else {
                        str = new String("Stream cache miss: ");
                    }
                    zzciz.zzj(str);
                    return;
                }
            } else {
                this.zzi = zzD();
                String zzE2 = zzE();
                Uri[] uriArr = new Uri[this.zzk.length];
                int i11 = 0;
                while (true) {
                    String[] strArr = this.zzk;
                    if (i11 >= strArr.length) {
                        break;
                    }
                    uriArr[i11] = Uri.parse(strArr[i11]);
                    i11++;
                }
                this.zzi.zzA(uriArr, zzE2);
            }
            this.zzi.zzG(this);
            zzY(this.zzh, false);
            if (this.zzi.zzP()) {
                int zzr3 = this.zzi.zzr();
                this.zzm = zzr3;
                if (zzr3 == 3) {
                    zzT();
                }
            }
        }
    }

    private final void zzV() {
        zzcky zzcky = this.zzi;
        if (zzcky != null) {
            zzcky.zzK(false);
        }
    }

    private final void zzW() {
        if (this.zzi != null) {
            zzY((Surface) null, true);
            zzcky zzcky = this.zzi;
            if (zzcky != null) {
                zzcky.zzG((zzckx) null);
                this.zzi.zzC();
                this.zzi = null;
            }
            this.zzm = 1;
            this.zzl = false;
            this.zzp = false;
            this.zzq = false;
        }
    }

    private final void zzX(float f11, boolean z11) {
        zzcky zzcky = this.zzi;
        if (zzcky != null) {
            try {
                zzcky.zzN(f11, z11);
            } catch (IOException e11) {
                zzciz.zzk("", e11);
            }
        } else {
            zzciz.zzj("Trying to set volume before player is initialized.");
        }
    }

    private final void zzY(Surface surface, boolean z11) {
        zzcky zzcky = this.zzi;
        if (zzcky != null) {
            try {
                zzcky.zzM(surface, z11);
            } catch (IOException e11) {
                zzciz.zzk("", e11);
            }
        } else {
            zzciz.zzj("Trying to set surface before player is initialized.");
        }
    }

    private final void zzZ() {
        zzaa(this.zzr, this.zzs);
    }

    private final void zzaa(int i11, int i12) {
        float f11 = i12 > 0 ? ((float) i11) / ((float) i12) : 1.0f;
        if (this.zzv != f11) {
            this.zzv = f11;
            requestLayout();
        }
    }

    private final boolean zzab() {
        return zzac() && this.zzm != 1;
    }

    private final boolean zzac() {
        zzcky zzcky = this.zzi;
        return zzcky != null && zzcky.zzP() && !this.zzl;
    }

    public final void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f11 = this.zzv;
        if (f11 != 0.0f && this.zzn == null) {
            float f12 = (float) measuredWidth;
            float f13 = f12 / ((float) measuredHeight);
            if (f11 > f13) {
                measuredHeight = (int) (f12 / f11);
            }
            if (f11 < f13) {
                measuredWidth = (int) (((float) measuredHeight) * f11);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzclf zzclf = this.zzn;
        if (zzclf != null) {
            zzclf.zzc(measuredWidth, measuredHeight);
        }
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
        if (this.zzo) {
            zzclf zzclf = new zzclf(getContext());
            this.zzn = zzclf;
            zzclf.zzd(surfaceTexture, i11, i12);
            this.zzn.start();
            SurfaceTexture zzb = this.zzn.zzb();
            if (zzb != null) {
                surfaceTexture = zzb;
            } else {
                this.zzn.zze();
                this.zzn = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.zzh = surface;
        if (this.zzi == null) {
            zzU(false);
        } else {
            zzY(surface, true);
            if (!this.zzf.zza) {
                zzS();
            }
        }
        if (this.zzr == 0 || this.zzs == 0) {
            zzaa(i11, i12);
        } else {
            zzZ();
        }
        zzt.zza.post(new zzclr(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzo();
        zzclf zzclf = this.zzn;
        if (zzclf != null) {
            zzclf.zze();
            this.zzn = null;
        }
        if (this.zzi != null) {
            zzV();
            Surface surface = this.zzh;
            if (surface != null) {
                surface.release();
            }
            this.zzh = null;
            zzY((Surface) null, true);
        }
        zzt.zza.post(new zzcls(this));
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
        zzclf zzclf = this.zzn;
        if (zzclf != null) {
            zzclf.zzc(i11, i12);
        }
        zzt.zza.post(new zzclw(this, i11, i12));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzd.zzf(this);
        this.zza.zza(surfaceTexture, this.zzg);
    }

    public final void onWindowVisibilityChanged(int i11) {
        StringBuilder sb2 = new StringBuilder(57);
        sb2.append("AdExoPlayerView3 window visibility changed to ");
        sb2.append(i11);
        zze.zza(sb2.toString());
        zzt.zza.post(new zzclv(this, i11));
        super.onWindowVisibilityChanged(i11);
    }

    public final void zzA(int i11) {
        zzcky zzcky = this.zzi;
        if (zzcky != null) {
            zzcky.zzL(i11);
        }
    }

    public final void zzB(String str, String[] strArr) {
        if (str != null) {
            boolean z11 = true;
            if (strArr == null) {
                this.zzk = new String[]{str};
            } else {
                this.zzk = (String[]) Arrays.copyOf(strArr, strArr.length);
            }
            String str2 = this.zzj;
            if (!this.zzf.zzn || str2 == null || str.equals(str2) || this.zzm != 4) {
                z11 = false;
            }
            this.zzj = str;
            zzU(z11);
        }
    }

    public final void zzC(int i11, int i12) {
        this.zzr = i11;
        this.zzs = i12;
        zzZ();
    }

    public final zzcky zzD() {
        if (this.zzf.zzm) {
            return new zzcof(this.zzc.getContext(), this.zzf, this.zzc);
        }
        return new zzcmn(this.zzc.getContext(), this.zzf, this.zzc);
    }

    public final String zzE() {
        return com.google.android.gms.ads.internal.zzt.zzp().zzd(this.zzc.getContext(), this.zzc.zzp().zza);
    }

    public final /* synthetic */ void zzF(String str) {
        zzckn zzckn = this.zzg;
        if (zzckn != null) {
            zzckn.zzb("ExoPlayerAdapter error", str);
        }
    }

    public final /* synthetic */ void zzG() {
        zzckn zzckn = this.zzg;
        if (zzckn != null) {
            zzckn.zza();
        }
    }

    public final /* synthetic */ void zzH() {
        zzckn zzckn = this.zzg;
        if (zzckn != null) {
            zzckn.zzf();
        }
    }

    public final /* synthetic */ void zzI(boolean z11, long j11) {
        this.zzc.zzx(z11, j11);
    }

    public final /* synthetic */ void zzJ(String str) {
        zzckn zzckn = this.zzg;
        if (zzckn != null) {
            zzckn.zzc("ExoPlayerAdapter exception", str);
        }
    }

    public final /* synthetic */ void zzK() {
        zzckn zzckn = this.zzg;
        if (zzckn != null) {
            zzckn.zzg();
        }
    }

    public final /* synthetic */ void zzL() {
        zzckn zzckn = this.zzg;
        if (zzckn != null) {
            zzckn.zzh();
        }
    }

    public final /* synthetic */ void zzM() {
        zzckn zzckn = this.zzg;
        if (zzckn != null) {
            zzckn.zzi();
        }
    }

    public final /* synthetic */ void zzN(int i11, int i12) {
        zzckn zzckn = this.zzg;
        if (zzckn != null) {
            zzckn.zzj(i11, i12);
        }
    }

    public final /* synthetic */ void zzO(int i11) {
        zzckn zzckn = this.zzg;
        if (zzckn != null) {
            zzckn.onWindowVisibilityChanged(i11);
        }
    }

    public final /* synthetic */ void zzP() {
        zzckn zzckn = this.zzg;
        if (zzckn != null) {
            zzckn.zzd();
        }
    }

    public final /* synthetic */ void zzQ() {
        zzckn zzckn = this.zzg;
        if (zzckn != null) {
            zzckn.zze();
        }
    }

    public final int zza() {
        if (zzab()) {
            return (int) this.zzi.zzw();
        }
        return 0;
    }

    public final int zzb() {
        zzcky zzcky = this.zzi;
        if (zzcky != null) {
            return zzcky.zzp();
        }
        return -1;
    }

    public final int zzc() {
        if (zzab()) {
            return (int) this.zzi.zzx();
        }
        return 0;
    }

    public final int zzd() {
        return this.zzs;
    }

    public final int zze() {
        return this.zzr;
    }

    public final long zzf() {
        zzcky zzcky = this.zzi;
        if (zzcky != null) {
            return zzcky.zzv();
        }
        return -1;
    }

    public final long zzg() {
        zzcky zzcky = this.zzi;
        if (zzcky != null) {
            return zzcky.zzy();
        }
        return -1;
    }

    public final long zzh() {
        zzcky zzcky = this.zzi;
        if (zzcky != null) {
            return zzcky.zzz();
        }
        return -1;
    }

    public final void zzi(boolean z11, long j11) {
        if (this.zzc != null) {
            zzcjm.zze.execute(new zzclo(this, z11, j11));
        }
    }

    public final String zzj() {
        String str = true != this.zzo ? "" : " spherical";
        return str.length() != 0 ? "ExoPlayer/3".concat(str) : new String("ExoPlayer/3");
    }

    public final void zzk(String str, Exception exc) {
        String str2;
        String zzR = zzR(str, exc);
        if (zzR.length() != 0) {
            str2 = "ExoPlayerAdapter error: ".concat(zzR);
        } else {
            str2 = new String("ExoPlayerAdapter error: ");
        }
        zzciz.zzj(str2);
        this.zzl = true;
        if (this.zzf.zza) {
            zzV();
        }
        zzt.zza.post(new zzclx(this, zzR));
        com.google.android.gms.ads.internal.zzt.zzo().zzr(exc, "AdExoPlayerView.onError");
    }

    public final void zzl(String str, Exception exc) {
        String str2;
        String zzR = zzR("onLoadException", exc);
        if (zzR.length() != 0) {
            str2 = "ExoPlayerAdapter exception: ".concat(zzR);
        } else {
            str2 = new String("ExoPlayerAdapter exception: ");
        }
        zzciz.zzj(str2);
        com.google.android.gms.ads.internal.zzt.zzo().zzr(exc, "AdExoPlayerView.onException");
        zzt.zza.post(new zzcln(this, zzR));
    }

    public final void zzm(int i11) {
        if (this.zzm != i11) {
            this.zzm = i11;
            if (i11 == 3) {
                zzT();
            } else if (i11 == 4) {
                if (this.zzf.zza) {
                    zzV();
                }
                this.zzd.zze();
                this.zzb.zzc();
                zzt.zza.post(new zzclm(this));
            }
        }
    }

    public final void zzn() {
        zzX(this.zzb.zza(), false);
    }

    public final void zzo() {
        if (zzab()) {
            if (this.zzf.zza) {
                zzV();
            }
            this.zzi.zzJ(false);
            this.zzd.zze();
            this.zzb.zzc();
            zzt.zza.post(new zzclt(this));
        }
    }

    public final void zzp() {
        if (zzab()) {
            if (this.zzf.zza) {
                zzS();
            }
            this.zzi.zzJ(true);
            this.zzd.zzc();
            this.zzb.zzb();
            this.zza.zzb();
            zzt.zza.post(new zzclu(this));
            return;
        }
        this.zzq = true;
    }

    public final void zzq(int i11) {
        if (zzab()) {
            this.zzi.zzD((long) i11);
        }
    }

    public final void zzr(zzckn zzckn) {
        this.zzg = zzckn;
    }

    public final void zzs(String str) {
        if (str != null) {
            zzB(str, (String[]) null);
        }
    }

    public final void zzt() {
        if (zzac()) {
            this.zzi.zzO();
            zzW();
        }
        this.zzd.zze();
        this.zzb.zzc();
        this.zzd.zzd();
    }

    public final void zzu(float f11, float f12) {
        zzclf zzclf = this.zzn;
        if (zzclf != null) {
            zzclf.zzf(f11, f12);
        }
    }

    public final void zzv() {
        zzt.zza.post(new zzclq(this));
    }

    public final void zzw(int i11) {
        zzcky zzcky = this.zzi;
        if (zzcky != null) {
            zzcky.zzE(i11);
        }
    }

    public final void zzx(int i11) {
        zzcky zzcky = this.zzi;
        if (zzcky != null) {
            zzcky.zzF(i11);
        }
    }

    public final void zzy(int i11) {
        zzcky zzcky = this.zzi;
        if (zzcky != null) {
            zzcky.zzH(i11);
        }
    }

    public final void zzz(int i11) {
        zzcky zzcky = this.zzi;
        if (zzcky != null) {
            zzcky.zzI(i11);
        }
    }
}
