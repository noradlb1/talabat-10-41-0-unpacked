package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzalt;
import com.google.android.gms.internal.ads.zzbay;
import com.google.android.gms.internal.ads.zzbes;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzblj;
import com.google.android.gms.internal.ads.zzbly;
import com.google.android.gms.internal.ads.zzbmi;
import com.google.android.gms.internal.ads.zzbqt;
import com.google.android.gms.internal.ads.zzbqv;
import com.google.android.gms.internal.ads.zzbru;
import com.google.android.gms.internal.ads.zzbrw;
import com.google.android.gms.internal.ads.zzcaq;
import com.google.android.gms.internal.ads.zzcar;
import com.google.android.gms.internal.ads.zzcbr;
import com.google.android.gms.internal.ads.zzcgf;
import com.google.android.gms.internal.ads.zzciz;
import com.google.android.gms.internal.ads.zzcjf;
import com.google.android.gms.internal.ads.zzcop;
import com.google.android.gms.internal.ads.zzcpb;
import com.google.android.gms.internal.ads.zzcqc;
import com.google.android.gms.internal.ads.zzcqe;
import com.google.android.gms.internal.ads.zzdmd;
import com.google.android.gms.internal.ads.zzdyz;
import com.google.android.gms.internal.ads.zzehh;
import com.google.android.gms.internal.ads.zzehp;
import com.google.android.gms.internal.ads.zzfdn;
import com.google.android.gms.internal.ads.zzfdq;
import com.google.android.gms.internal.ads.zzfio;
import com.google.android.gms.internal.ads.zzfjs;
import com.google.android.gms.internal.ads.zzfpj;
import com.instabug.library.model.NetworkLog;
import java.util.Collections;

public class zzl extends zzcbr implements zzaa {
    @VisibleForTesting
    static final int zza = Color.argb(0, 0, 0, 0);
    protected final Activity zzb;
    @Nullable
    @VisibleForTesting
    AdOverlayInfoParcel zzc;
    @VisibleForTesting
    zzcop zzd;
    @VisibleForTesting
    zzh zze;
    @VisibleForTesting
    zzr zzf;
    @VisibleForTesting
    boolean zzg = false;
    @VisibleForTesting
    FrameLayout zzh;
    @VisibleForTesting
    WebChromeClient.CustomViewCallback zzi;
    @VisibleForTesting
    boolean zzj = false;
    @VisibleForTesting
    boolean zzk = false;
    @VisibleForTesting
    zzg zzl;
    @VisibleForTesting
    boolean zzm = false;
    @VisibleForTesting
    int zzn = 1;
    private final Object zzo = new Object();
    private Runnable zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs = false;
    private boolean zzt = false;
    private boolean zzu = true;

    public zzl(Activity activity) {
        this.zzb = activity;
    }

    private final void zzG(Configuration configuration) {
        boolean z11;
        int i11;
        zzj zzj2;
        zzj zzj3;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        boolean z12 = true;
        boolean z13 = false;
        if (adOverlayInfoParcel == null || (zzj3 = adOverlayInfoParcel.zzo) == null || !zzj3.zzb) {
            z11 = false;
        } else {
            z11 = true;
        }
        boolean zzo2 = zzt.zzq().zzo(this.zzb, configuration);
        if ((!this.zzk || z11) && !zzo2) {
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
            if (!(adOverlayInfoParcel2 == null || (zzj2 = adOverlayInfoParcel2.zzo) == null || !zzj2.zzg)) {
                z13 = true;
            }
        } else {
            z12 = false;
        }
        Window window = this.zzb.getWindow();
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzaS)).booleanValue()) {
            View decorView = window.getDecorView();
            if (!z12) {
                i11 = 256;
            } else if (z13) {
                i11 = 5894;
            } else {
                i11 = 5380;
            }
            decorView.setSystemUiVisibility(i11);
        } else if (z12) {
            window.addFlags(1024);
            window.clearFlags(2048);
            if (z13) {
                window.getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
            }
        } else {
            window.addFlags(2048);
            window.clearFlags(1024);
        }
    }

    private static final void zzH(@Nullable IObjectWrapper iObjectWrapper, @Nullable View view) {
        if (iObjectWrapper != null && view != null) {
            zzt.zzh().zzg(iObjectWrapper, view);
        }
    }

    public final void zzA(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        FrameLayout frameLayout = new FrameLayout(this.zzb);
        this.zzh = frameLayout;
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.zzh.addView(view, -1, -1);
        this.zzb.setContentView(this.zzh);
        this.zzr = true;
        this.zzi = customViewCallback;
        this.zzg = true;
    }

    public final void zzB(boolean z11) throws zzf {
        zzcqc zzcqc;
        boolean z12;
        zzcqe zzcqe;
        String str;
        zza zza2;
        if (!this.zzr) {
            this.zzb.requestWindowFeature(1);
        }
        Window window = this.zzb.getWindow();
        if (window != null) {
            zzcop zzcop = this.zzc.zzd;
            zzb zzb2 = null;
            if (zzcop != null) {
                zzcqc = zzcop.zzP();
            } else {
                zzcqc = null;
            }
            boolean z13 = false;
            if (zzcqc == null || !zzcqc.zzJ()) {
                z12 = false;
            } else {
                z12 = true;
            }
            this.zzm = false;
            if (z12) {
                int i11 = this.zzc.zzj;
                if (i11 == 6) {
                    if (this.zzb.getResources().getConfiguration().orientation == 1) {
                        z13 = true;
                    }
                    this.zzm = z13;
                } else if (i11 == 7) {
                    if (this.zzb.getResources().getConfiguration().orientation == 2) {
                        z13 = true;
                    }
                    this.zzm = z13;
                }
            }
            StringBuilder sb2 = new StringBuilder(46);
            sb2.append("Delay onShow to next orientation change: ");
            sb2.append(z13);
            zzciz.zze(sb2.toString());
            zzy(this.zzc.zzj);
            window.setFlags(16777216, 16777216);
            zzciz.zze("Hardware acceleration on the AdActivity window enabled.");
            if (!this.zzk) {
                this.zzl.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            } else {
                this.zzl.setBackgroundColor(zza);
            }
            this.zzb.setContentView(this.zzl);
            this.zzr = true;
            if (z11) {
                try {
                    zzt.zzz();
                    Activity activity = this.zzb;
                    zzcop zzcop2 = this.zzc.zzd;
                    if (zzcop2 != null) {
                        zzcqe = zzcop2.zzQ();
                    } else {
                        zzcqe = null;
                    }
                    zzcop zzcop3 = this.zzc.zzd;
                    if (zzcop3 != null) {
                        str = zzcop3.zzU();
                    } else {
                        str = null;
                    }
                    AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
                    zzcjf zzcjf = adOverlayInfoParcel.zzm;
                    zzcop zzcop4 = adOverlayInfoParcel.zzd;
                    if (zzcop4 != null) {
                        zza2 = zzcop4.zzm();
                    } else {
                        zza2 = null;
                    }
                    zzcop zza3 = zzcpb.zza(activity, zzcqe, str, true, z12, (zzalt) null, (zzbmi) null, zzcjf, (zzbly) null, (com.google.android.gms.ads.internal.zzl) null, zza2, zzbay.zza(), (zzfdn) null, (zzfdq) null);
                    this.zzd = zza3;
                    zzcqc zzP = zza3.zzP();
                    AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
                    zzbqt zzbqt = adOverlayInfoParcel2.zzp;
                    zzbqv zzbqv = adOverlayInfoParcel2.zze;
                    zzw zzw = adOverlayInfoParcel2.zzi;
                    zzcop zzcop5 = adOverlayInfoParcel2.zzd;
                    if (zzcop5 != null) {
                        zzb2 = zzcop5.zzP().zzd();
                    }
                    zzP.zzL((zzbes) null, zzbqt, (zzo) null, zzbqv, zzw, true, (zzbrw) null, zzb2, (zzcar) null, (zzcgf) null, (zzehh) null, (zzfjs) null, (zzdyz) null, (zzfio) null, (zzbru) null, (zzdmd) null);
                    this.zzd.zzP().zzz(new zzd(this));
                    AdOverlayInfoParcel adOverlayInfoParcel3 = this.zzc;
                    String str2 = adOverlayInfoParcel3.zzl;
                    if (str2 != null) {
                        this.zzd.loadUrl(str2);
                    } else {
                        String str3 = adOverlayInfoParcel3.zzh;
                        if (str3 != null) {
                            this.zzd.loadDataWithBaseURL(adOverlayInfoParcel3.zzf, str3, NetworkLog.HTML, "UTF-8", (String) null);
                        } else {
                            throw new zzf("No URL or HTML to display in ad overlay.");
                        }
                    }
                    zzcop zzcop6 = this.zzc.zzd;
                    if (zzcop6 != null) {
                        zzcop6.zzat(this);
                    }
                } catch (Exception e11) {
                    zzciz.zzh("Error obtaining webview.", e11);
                    throw new zzf("Could not obtain webview for the overlay.");
                }
            } else {
                zzcop zzcop7 = this.zzc.zzd;
                this.zzd = zzcop7;
                zzcop7.zzam(this.zzb);
            }
            this.zzd.zzah(this);
            zzcop zzcop8 = this.zzc.zzd;
            if (zzcop8 != null) {
                zzH(zzcop8.zzS(), this.zzl);
            }
            if (this.zzc.zzk != 5) {
                ViewParent parent = this.zzd.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(this.zzd.zzH());
                }
                if (this.zzk) {
                    this.zzd.zzal();
                }
                this.zzl.addView(this.zzd.zzH(), -1, -1);
            }
            if (!z11 && !this.zzm) {
                zze();
            }
            AdOverlayInfoParcel adOverlayInfoParcel4 = this.zzc;
            if (adOverlayInfoParcel4.zzk != 5) {
                zzu(z12);
                if (this.zzd.zzay()) {
                    zzw(z12, true);
                    return;
                }
                return;
            }
            zzehp.zzh(this.zzb, this, adOverlayInfoParcel4.zzu, adOverlayInfoParcel4.zzr, adOverlayInfoParcel4.zzs, adOverlayInfoParcel4.zzt, adOverlayInfoParcel4.zzq, adOverlayInfoParcel4.zzv);
            return;
        }
        throw new zzf("Invalid activity, no window available.");
    }

    public final void zzC() {
        synchronized (this.zzo) {
            this.zzq = true;
            Runnable runnable = this.zzp;
            if (runnable != null) {
                zzfpj zzfpj = com.google.android.gms.ads.internal.util.zzt.zza;
                zzfpj.removeCallbacks(runnable);
                zzfpj.post(this.zzp);
            }
        }
    }

    public final void zzD() {
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzo zzo2;
        if (this.zzb.isFinishing() && !this.zzs) {
            this.zzs = true;
            zzcop zzcop = this.zzd;
            if (zzcop != null) {
                zzcop.zzY(this.zzn - 1);
                synchronized (this.zzo) {
                    if (!this.zzq && this.zzd.zzaz()) {
                        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdq)).booleanValue() && !this.zzt && (adOverlayInfoParcel = this.zzc) != null && (zzo2 = adOverlayInfoParcel.zzc) != null) {
                            zzo2.zzbK();
                        }
                        zze zze2 = new zze(this);
                        this.zzp = zze2;
                        com.google.android.gms.ads.internal.util.zzt.zza.postDelayed(zze2, ((Long) zzbgq.zzc().zzb(zzblj.zzaL)).longValue());
                        return;
                    }
                }
            }
            zzc();
        }
    }

    public final boolean zzE() {
        this.zzn = 1;
        if (this.zzd == null) {
            return true;
        }
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzgA)).booleanValue() || !this.zzd.canGoBack()) {
            boolean zzaE = this.zzd.zzaE();
            if (!zzaE) {
                this.zzd.zzd("onbackblocked", Collections.emptyMap());
            }
            return zzaE;
        }
        this.zzd.goBack();
        return false;
    }

    public final void zzb() {
        this.zzn = 3;
        this.zzb.finish();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && adOverlayInfoParcel.zzk == 5) {
            this.zzb.overridePendingTransition(0, 0);
        }
    }

    public final void zzbR() {
        this.zzn = 2;
        this.zzb.finish();
    }

    @VisibleForTesting
    public final void zzc() {
        zzcop zzcop;
        zzo zzo2;
        if (!this.zzt) {
            this.zzt = true;
            zzcop zzcop2 = this.zzd;
            if (zzcop2 != null) {
                this.zzl.removeView(zzcop2.zzH());
                zzh zzh2 = this.zze;
                if (zzh2 != null) {
                    this.zzd.zzam(zzh2.zzd);
                    this.zzd.zzap(false);
                    ViewGroup viewGroup = this.zze.zzc;
                    View zzH = this.zzd.zzH();
                    zzh zzh3 = this.zze;
                    viewGroup.addView(zzH, zzh3.zza, zzh3.zzb);
                    this.zze = null;
                } else if (this.zzb.getApplicationContext() != null) {
                    this.zzd.zzam(this.zzb.getApplicationContext());
                }
                this.zzd = null;
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
            if (!(adOverlayInfoParcel == null || (zzo2 = adOverlayInfoParcel.zzc) == null)) {
                zzo2.zzf(this.zzn);
            }
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
            if (adOverlayInfoParcel2 != null && (zzcop = adOverlayInfoParcel2.zzd) != null) {
                zzH(zzcop.zzS(), this.zzc.zzd.zzH());
            }
        }
    }

    public final void zzd() {
        this.zzl.zzb = true;
    }

    public final void zze() {
        this.zzd.zzZ();
    }

    public final void zzf() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && this.zzg) {
            zzy(adOverlayInfoParcel.zzj);
        }
        if (this.zzh != null) {
            this.zzb.setContentView(this.zzl);
            this.zzr = true;
            this.zzh.removeAllViews();
            this.zzh = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzi;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzi = null;
        }
        this.zzg = false;
    }

    public final void zzg(int i11, int i12, Intent intent) {
    }

    public final void zzh() {
        this.zzn = 1;
    }

    public final void zzj(IObjectWrapper iObjectWrapper) {
        zzG((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0071 A[Catch:{ zzf -> 0x00f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c4 A[Catch:{ zzf -> 0x00f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00e9 A[Catch:{ zzf -> 0x00f5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzk(android.os.Bundle r9) {
        /*
            r8 = this;
            android.app.Activity r0 = r8.zzb
            r1 = 1
            r0.requestWindowFeature(r1)
            r0 = 0
            if (r9 == 0) goto L_0x0013
            java.lang.String r2 = "com.google.android.gms.ads.internal.overlay.hasResumed"
            boolean r2 = r9.getBoolean(r2, r0)
            if (r2 == 0) goto L_0x0013
            r2 = r1
            goto L_0x0014
        L_0x0013:
            r2 = r0
        L_0x0014:
            r8.zzj = r2
            r2 = 4
            android.app.Activity r3 = r8.zzb     // Catch:{ zzf -> 0x00f5 }
            android.content.Intent r3 = r3.getIntent()     // Catch:{ zzf -> 0x00f5 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel.zza(r3)     // Catch:{ zzf -> 0x00f5 }
            r8.zzc = r3     // Catch:{ zzf -> 0x00f5 }
            if (r3 == 0) goto L_0x00ed
            com.google.android.gms.internal.ads.zzcjf r3 = r3.zzm     // Catch:{ zzf -> 0x00f5 }
            int r3 = r3.zzc     // Catch:{ zzf -> 0x00f5 }
            r4 = 7500000(0x7270e0, float:1.0509738E-38)
            if (r3 <= r4) goto L_0x0030
            r8.zzn = r2     // Catch:{ zzf -> 0x00f5 }
        L_0x0030:
            android.app.Activity r3 = r8.zzb     // Catch:{ zzf -> 0x00f5 }
            android.content.Intent r3 = r3.getIntent()     // Catch:{ zzf -> 0x00f5 }
            if (r3 == 0) goto L_0x0046
            android.app.Activity r3 = r8.zzb     // Catch:{ zzf -> 0x00f5 }
            android.content.Intent r3 = r3.getIntent()     // Catch:{ zzf -> 0x00f5 }
            java.lang.String r4 = "shouldCallOnOverlayOpened"
            boolean r3 = r3.getBooleanExtra(r4, r1)     // Catch:{ zzf -> 0x00f5 }
            r8.zzu = r3     // Catch:{ zzf -> 0x00f5 }
        L_0x0046:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r8.zzc     // Catch:{ zzf -> 0x00f5 }
            com.google.android.gms.ads.internal.zzj r4 = r3.zzo     // Catch:{ zzf -> 0x00f5 }
            r5 = 5
            if (r4 == 0) goto L_0x0054
            boolean r6 = r4.zza     // Catch:{ zzf -> 0x00f5 }
            r8.zzk = r6     // Catch:{ zzf -> 0x00f5 }
            if (r6 == 0) goto L_0x006f
            goto L_0x005a
        L_0x0054:
            int r6 = r3.zzk     // Catch:{ zzf -> 0x00f5 }
            if (r6 != r5) goto L_0x006d
            r8.zzk = r1     // Catch:{ zzf -> 0x00f5 }
        L_0x005a:
            int r3 = r3.zzk     // Catch:{ zzf -> 0x00f5 }
            if (r3 == r5) goto L_0x006f
            int r3 = r4.zzf     // Catch:{ zzf -> 0x00f5 }
            r4 = -1
            if (r3 == r4) goto L_0x006f
            com.google.android.gms.ads.internal.overlay.zzk r3 = new com.google.android.gms.ads.internal.overlay.zzk     // Catch:{ zzf -> 0x00f5 }
            r4 = 0
            r3.<init>(r8, r4)     // Catch:{ zzf -> 0x00f5 }
            r3.zzb()     // Catch:{ zzf -> 0x00f5 }
            goto L_0x006f
        L_0x006d:
            r8.zzk = r0     // Catch:{ zzf -> 0x00f5 }
        L_0x006f:
            if (r9 != 0) goto L_0x009d
            boolean r9 = r8.zzu     // Catch:{ zzf -> 0x00f5 }
            if (r9 == 0) goto L_0x0087
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzf -> 0x00f5 }
            com.google.android.gms.internal.ads.zzdfe r9 = r9.zzx     // Catch:{ zzf -> 0x00f5 }
            if (r9 == 0) goto L_0x007e
            r9.zzd()     // Catch:{ zzf -> 0x00f5 }
        L_0x007e:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzf -> 0x00f5 }
            com.google.android.gms.ads.internal.overlay.zzo r9 = r9.zzc     // Catch:{ zzf -> 0x00f5 }
            if (r9 == 0) goto L_0x0087
            r9.zzb()     // Catch:{ zzf -> 0x00f5 }
        L_0x0087:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzf -> 0x00f5 }
            int r3 = r9.zzk     // Catch:{ zzf -> 0x00f5 }
            if (r3 == r1) goto L_0x009d
            com.google.android.gms.internal.ads.zzbes r9 = r9.zzb     // Catch:{ zzf -> 0x00f5 }
            if (r9 == 0) goto L_0x0094
            r9.onAdClicked()     // Catch:{ zzf -> 0x00f5 }
        L_0x0094:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzf -> 0x00f5 }
            com.google.android.gms.internal.ads.zzdmd r9 = r9.zzy     // Catch:{ zzf -> 0x00f5 }
            if (r9 == 0) goto L_0x009d
            r9.zzq()     // Catch:{ zzf -> 0x00f5 }
        L_0x009d:
            com.google.android.gms.ads.internal.overlay.zzg r9 = new com.google.android.gms.ads.internal.overlay.zzg     // Catch:{ zzf -> 0x00f5 }
            android.app.Activity r3 = r8.zzb     // Catch:{ zzf -> 0x00f5 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r4 = r8.zzc     // Catch:{ zzf -> 0x00f5 }
            java.lang.String r6 = r4.zzn     // Catch:{ zzf -> 0x00f5 }
            com.google.android.gms.internal.ads.zzcjf r7 = r4.zzm     // Catch:{ zzf -> 0x00f5 }
            java.lang.String r7 = r7.zza     // Catch:{ zzf -> 0x00f5 }
            java.lang.String r4 = r4.zzw     // Catch:{ zzf -> 0x00f5 }
            r9.<init>(r3, r6, r7, r4)     // Catch:{ zzf -> 0x00f5 }
            r8.zzl = r9     // Catch:{ zzf -> 0x00f5 }
            r3 = 1000(0x3e8, float:1.401E-42)
            r9.setId(r3)     // Catch:{ zzf -> 0x00f5 }
            com.google.android.gms.ads.internal.util.zzae r9 = com.google.android.gms.ads.internal.zzt.zzq()     // Catch:{ zzf -> 0x00f5 }
            android.app.Activity r3 = r8.zzb     // Catch:{ zzf -> 0x00f5 }
            r9.zzr(r3)     // Catch:{ zzf -> 0x00f5 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzf -> 0x00f5 }
            int r3 = r9.zzk     // Catch:{ zzf -> 0x00f5 }
            if (r3 == r1) goto L_0x00e9
            r4 = 2
            if (r3 == r4) goto L_0x00dc
            r9 = 3
            if (r3 == r9) goto L_0x00d8
            if (r3 != r5) goto L_0x00d0
            r8.zzB(r0)     // Catch:{ zzf -> 0x00f5 }
            return
        L_0x00d0:
            com.google.android.gms.ads.internal.overlay.zzf r9 = new com.google.android.gms.ads.internal.overlay.zzf     // Catch:{ zzf -> 0x00f5 }
            java.lang.String r0 = "Could not determine ad overlay type."
            r9.<init>(r0)     // Catch:{ zzf -> 0x00f5 }
            throw r9     // Catch:{ zzf -> 0x00f5 }
        L_0x00d8:
            r8.zzB(r1)     // Catch:{ zzf -> 0x00f5 }
            return
        L_0x00dc:
            com.google.android.gms.ads.internal.overlay.zzh r1 = new com.google.android.gms.ads.internal.overlay.zzh     // Catch:{ zzf -> 0x00f5 }
            com.google.android.gms.internal.ads.zzcop r9 = r9.zzd     // Catch:{ zzf -> 0x00f5 }
            r1.<init>(r9)     // Catch:{ zzf -> 0x00f5 }
            r8.zze = r1     // Catch:{ zzf -> 0x00f5 }
            r8.zzB(r0)     // Catch:{ zzf -> 0x00f5 }
            return
        L_0x00e9:
            r8.zzB(r0)     // Catch:{ zzf -> 0x00f5 }
            return
        L_0x00ed:
            com.google.android.gms.ads.internal.overlay.zzf r9 = new com.google.android.gms.ads.internal.overlay.zzf     // Catch:{ zzf -> 0x00f5 }
            java.lang.String r0 = "Could not get info for ad overlay."
            r9.<init>(r0)     // Catch:{ zzf -> 0x00f5 }
            throw r9     // Catch:{ zzf -> 0x00f5 }
        L_0x00f5:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            com.google.android.gms.internal.ads.zzciz.zzj(r9)
            r8.zzn = r2
            android.app.Activity r9 = r8.zzb
            r9.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzl.zzk(android.os.Bundle):void");
    }

    public final void zzl() {
        zzcop zzcop = this.zzd;
        if (zzcop != null) {
            try {
                this.zzl.removeView(zzcop.zzH());
            } catch (NullPointerException unused) {
            }
        }
        zzD();
    }

    public final void zzm() {
        if (this.zzm) {
            this.zzm = false;
            zze();
        }
    }

    public final void zzn() {
        zzo zzo2;
        zzf();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (!(adOverlayInfoParcel == null || (zzo2 = adOverlayInfoParcel.zzc) == null)) {
            zzo2.zzbz();
        }
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzds)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzD();
    }

    public final void zzo() {
    }

    public final void zzp() {
        zzo zzo2;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (!(adOverlayInfoParcel == null || (zzo2 = adOverlayInfoParcel.zzc) == null)) {
            zzo2.zzbS();
        }
        zzG(this.zzb.getResources().getConfiguration());
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzds)).booleanValue()) {
            zzcop zzcop = this.zzd;
            if (zzcop == null || zzcop.zzaB()) {
                zzciz.zzj("The webview does not exist. Ignoring action.");
            } else {
                this.zzd.onResume();
            }
        }
    }

    public final void zzq(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzj);
    }

    public final void zzr() {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzds)).booleanValue()) {
            zzcop zzcop = this.zzd;
            if (zzcop == null || zzcop.zzaB()) {
                zzciz.zzj("The webview does not exist. Ignoring action.");
            } else {
                this.zzd.onResume();
            }
        }
    }

    public final void zzs() {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzds)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzD();
    }

    public final void zzt() {
        zzo zzo2;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzo2 = adOverlayInfoParcel.zzc) != null) {
            zzo2.zze();
        }
    }

    public final void zzu(boolean z11) {
        boolean z12;
        int i11;
        int i12;
        int intValue = ((Integer) zzbgq.zzc().zzb(zzblj.zzdu)).intValue();
        int i13 = 0;
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzaO)).booleanValue() || z11) {
            z12 = true;
        } else {
            z12 = false;
        }
        zzq zzq2 = new zzq();
        zzq2.zzd = 50;
        if (true != z12) {
            i11 = 0;
        } else {
            i11 = intValue;
        }
        zzq2.zza = i11;
        if (true != z12) {
            i13 = intValue;
        }
        zzq2.zzb = i13;
        zzq2.zzc = intValue;
        this.zzf = new zzr(this.zzb, zzq2, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        if (true != z12) {
            i12 = 9;
        } else {
            i12 = 11;
        }
        layoutParams.addRule(i12);
        zzw(z11, this.zzc.zzg);
        this.zzl.addView(this.zzf, layoutParams);
    }

    public final void zzv() {
        this.zzr = true;
    }

    public final void zzw(boolean z11, boolean z12) {
        boolean z13;
        boolean z14;
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzj zzj2;
        AdOverlayInfoParcel adOverlayInfoParcel2;
        zzj zzj3;
        boolean z15 = true;
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzaM)).booleanValue() || (adOverlayInfoParcel2 = this.zzc) == null || (zzj3 = adOverlayInfoParcel2.zzo) == null || !zzj3.zzh) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzaN)).booleanValue() || (adOverlayInfoParcel = this.zzc) == null || (zzj2 = adOverlayInfoParcel.zzo) == null || !zzj2.zzi) {
            z14 = false;
        } else {
            z14 = true;
        }
        if (z11 && z12 && z13 && !z14) {
            new zzcaq(this.zzd, "useCustomClose").zzg("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        zzr zzr2 = this.zzf;
        if (zzr2 != null) {
            if (!z14 && (!z12 || z13)) {
                z15 = false;
            }
            zzr2.zzb(z15);
        }
    }

    public final void zzx() {
        this.zzl.removeView(this.zzf);
        zzu(true);
    }

    public final void zzy(int i11) {
        if (this.zzb.getApplicationInfo().targetSdkVersion >= ((Integer) zzbgq.zzc().zzb(zzblj.zzet)).intValue()) {
            if (this.zzb.getApplicationInfo().targetSdkVersion <= ((Integer) zzbgq.zzc().zzb(zzblj.zzeu)).intValue()) {
                int i12 = Build.VERSION.SDK_INT;
                if (i12 >= ((Integer) zzbgq.zzc().zzb(zzblj.zzev)).intValue()) {
                    if (i12 <= ((Integer) zzbgq.zzc().zzb(zzblj.zzew)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.zzb.setRequestedOrientation(i11);
        } catch (Throwable th2) {
            zzt.zzo().zzr(th2, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zzz(boolean z11) {
        if (z11) {
            this.zzl.setBackgroundColor(0);
        } else {
            this.zzl.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }
}
