package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzckv extends FrameLayout implements zzckn {
    private final zzclh zza;
    private final FrameLayout zzb;
    private final View zzc;
    private final zzbly zzd;
    private final zzclj zze;
    private final long zzf;
    @Nullable
    private final zzcko zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private String zzn;
    private String[] zzo;
    private Bitmap zzp;
    private final ImageView zzq;
    private boolean zzr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzckv(Context context, zzclh zzclh, int i11, boolean z11, zzbly zzbly, zzclg zzclg) {
        super(context);
        zzcko zzcko;
        String str;
        Context context2 = context;
        zzbly zzbly2 = zzbly;
        this.zza = zzclh;
        this.zzd = zzbly2;
        FrameLayout frameLayout = new FrameLayout(context2);
        this.zzb = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.checkNotNull(zzclh.zzm());
        zzckp zzckp = zzclh.zzm().zza;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null || applicationInfo.targetSdkVersion >= 11) {
            zzcli zzcli = new zzcli(context, zzclh.zzp(), zzclh.zzu(), zzbly, zzclh.zzn());
            if (i11 == 2) {
                zzcko = new zzcly(context, zzcli, zzclh, z11, zzckp.zza(zzclh), zzclg);
            } else {
                Context context3 = context;
                zzcko = new zzckm(context3, zzclh, z11, zzckp.zza(zzclh), zzclg, new zzcli(context3, zzclh.zzp(), zzclh.zzu(), zzbly, zzclh.zzn()));
            }
        } else {
            zzcko = null;
        }
        this.zzg = zzcko;
        View view = new View(context2);
        this.zzc = view;
        view.setBackgroundColor(0);
        if (zzcko != null) {
            frameLayout.addView(zzcko, new FrameLayout.LayoutParams(-1, -1, 17));
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzA)).booleanValue()) {
                frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
                frameLayout.bringChildToFront(view);
            }
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzx)).booleanValue()) {
                zzm();
            }
        }
        this.zzq = new ImageView(context2);
        this.zzf = ((Long) zzbgq.zzc().zzb(zzblj.zzC)).longValue();
        boolean booleanValue = ((Boolean) zzbgq.zzc().zzb(zzblj.zzz)).booleanValue();
        this.zzk = booleanValue;
        if (zzbly2 != null) {
            if (true != booleanValue) {
                str = "0";
            } else {
                str = "1";
            }
            zzbly2.zzd("spinner_used", str);
        }
        this.zze = new zzclj(this);
        if (zzcko != null) {
            zzcko.zzr(this);
        }
        if (zzcko == null) {
            zzb("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    private final void zzH() {
        if (this.zza.zzk() != null && this.zzi && !this.zzj) {
            this.zza.zzk().getWindow().clearFlags(128);
            this.zzi = false;
        }
    }

    /* access modifiers changed from: private */
    public final void zzI(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                hashMap.put(str2, str3);
                str2 = null;
            }
        }
        this.zza.zzd("onVideoEvent", hashMap);
    }

    private final boolean zzJ() {
        return this.zzq.getParent() != null;
    }

    public final void finalize() throws Throwable {
        try {
            this.zze.zza();
            zzcko zzcko = this.zzg;
            if (zzcko != null) {
                zzcjm.zze.execute(new zzckq(zzcko));
            }
        } finally {
            super.finalize();
        }
    }

    public final void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
        if (z11) {
            this.zze.zzb();
        } else {
            this.zze.zza();
            this.zzm = this.zzl;
        }
        zzt.zza.post(new zzckr(this, z11));
    }

    public final void onWindowVisibilityChanged(int i11) {
        boolean z11;
        super.onWindowVisibilityChanged(i11);
        if (i11 == 0) {
            this.zze.zzb();
            z11 = true;
        } else {
            this.zze.zza();
            this.zzm = this.zzl;
            z11 = false;
        }
        zzt.zza.post(new zzcku(this, z11));
    }

    public final void zzA(int i11) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzA)).booleanValue()) {
            this.zzb.setBackgroundColor(i11);
            this.zzc.setBackgroundColor(i11);
        }
    }

    public final void zzB(int i11) {
        this.zzg.zzA(i11);
    }

    public final void zzC(String str, String[] strArr) {
        this.zzn = str;
        this.zzo = strArr;
    }

    public final void zzD(int i11, int i12, int i13, int i14) {
        if (zze.zzc()) {
            StringBuilder sb2 = new StringBuilder(75);
            sb2.append("Set video bounds to x:");
            sb2.append(i11);
            sb2.append(";y:");
            sb2.append(i12);
            sb2.append(";w:");
            sb2.append(i13);
            sb2.append(";h:");
            sb2.append(i14);
            zze.zza(sb2.toString());
        }
        if (i13 != 0 && i14 != 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i13, i14);
            layoutParams.setMargins(i11, i12, 0, 0);
            this.zzb.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public final void zzE(float f11) {
        zzcko zzcko = this.zzg;
        if (zzcko != null) {
            zzcko.zzb.zze(f11);
            zzcko.zzn();
        }
    }

    public final void zzF(float f11, float f12) {
        zzcko zzcko = this.zzg;
        if (zzcko != null) {
            zzcko.zzu(f11, f12);
        }
    }

    public final void zzG() {
        zzcko zzcko = this.zzg;
        if (zzcko != null) {
            zzcko.zzb.zzd(false);
            zzcko.zzn();
        }
    }

    public final void zza() {
        zzI("ended", new String[0]);
        zzH();
    }

    public final void zzb(String str, @Nullable String str2) {
        zzI("error", "what", str, "extra", str2);
    }

    public final void zzc(String str, @Nullable String str2) {
        zzI("exception", "what", "ExoPlayerAdapter exception", "extra", str2);
    }

    public final void zzd() {
        zzI("pause", new String[0]);
        zzH();
        this.zzh = false;
    }

    public final void zze() {
        boolean z11;
        if (this.zza.zzk() != null && !this.zzi) {
            if ((this.zza.zzk().getWindow().getAttributes().flags & 128) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.zzj = z11;
            if (!z11) {
                this.zza.zzk().getWindow().addFlags(128);
                this.zzi = true;
            }
        }
        this.zzh = true;
    }

    public final void zzf() {
        zzcko zzcko = this.zzg;
        if (zzcko != null && this.zzm == 0) {
            zzI("canplaythrough", "duration", String.valueOf(((float) zzcko.zzc()) / 1000.0f), "videoWidth", String.valueOf(this.zzg.zze()), "videoHeight", String.valueOf(this.zzg.zzd()));
        }
    }

    public final void zzg() {
        this.zzc.setVisibility(4);
    }

    public final void zzh() {
        this.zze.zzb();
        zzt.zza.post(new zzcks(this));
    }

    public final void zzi() {
        if (this.zzr && this.zzp != null && !zzJ()) {
            this.zzq.setImageBitmap(this.zzp);
            this.zzq.invalidate();
            this.zzb.addView(this.zzq, new FrameLayout.LayoutParams(-1, -1));
            this.zzb.bringChildToFront(this.zzq);
        }
        this.zze.zza();
        this.zzm = this.zzl;
        zzt.zza.post(new zzckt(this));
    }

    public final void zzj(int i11, int i12) {
        if (this.zzk) {
            zzblb zzblb = zzblj.zzB;
            int max = Math.max(i11 / ((Integer) zzbgq.zzc().zzb(zzblb)).intValue(), 1);
            int max2 = Math.max(i12 / ((Integer) zzbgq.zzc().zzb(zzblb)).intValue(), 1);
            Bitmap bitmap = this.zzp;
            if (bitmap == null || bitmap.getWidth() != max || this.zzp.getHeight() != max2) {
                this.zzp = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
                this.zzr = false;
            }
        }
    }

    public final void zzk() {
        if (this.zzh && zzJ()) {
            this.zzb.removeView(this.zzq);
        }
        if (this.zzp != null) {
            long elapsedRealtime = com.google.android.gms.ads.internal.zzt.zzA().elapsedRealtime();
            if (this.zzg.getBitmap(this.zzp) != null) {
                this.zzr = true;
            }
            long elapsedRealtime2 = com.google.android.gms.ads.internal.zzt.zzA().elapsedRealtime() - elapsedRealtime;
            if (zze.zzc()) {
                StringBuilder sb2 = new StringBuilder(46);
                sb2.append("Spinner frame grab took ");
                sb2.append(elapsedRealtime2);
                sb2.append("ms");
                zze.zza(sb2.toString());
            }
            if (elapsedRealtime2 > this.zzf) {
                zzciz.zzj("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.zzk = false;
                this.zzp = null;
                zzbly zzbly = this.zzd;
                if (zzbly != null) {
                    zzbly.zzd("spinner_jank", Long.toString(elapsedRealtime2));
                }
            }
        }
    }

    @TargetApi(14)
    public final void zzm() {
        String str;
        zzcko zzcko = this.zzg;
        if (zzcko != null) {
            TextView textView = new TextView(zzcko.getContext());
            String valueOf = String.valueOf(this.zzg.zzj());
            if (valueOf.length() != 0) {
                str = "AdMob - ".concat(valueOf);
            } else {
                str = new String("AdMob - ");
            }
            textView.setText(str);
            textView.setTextColor(-65536);
            textView.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
            this.zzb.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
            this.zzb.bringChildToFront(textView);
        }
    }

    public final void zzn() {
        this.zze.zza();
        zzcko zzcko = this.zzg;
        if (zzcko != null) {
            zzcko.zzt();
        }
        zzH();
    }

    public final /* synthetic */ void zzo(boolean z11) {
        zzI("windowFocusChanged", "hasWindowFocus", String.valueOf(z11));
    }

    public final void zzp() {
        if (this.zzg != null) {
            if (!TextUtils.isEmpty(this.zzn)) {
                this.zzg.zzB(this.zzn, this.zzo);
            } else {
                zzI("no_src", new String[0]);
            }
        }
    }

    public final void zzq() {
        zzcko zzcko = this.zzg;
        if (zzcko != null) {
            zzcko.zzb.zzd(true);
            zzcko.zzn();
        }
    }

    public final void zzr() {
        zzcko zzcko = this.zzg;
        if (zzcko != null) {
            long zza2 = (long) zzcko.zza();
            if (this.zzl != zza2 && zza2 > 0) {
                float f11 = ((float) zza2) / 1000.0f;
                if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbr)).booleanValue()) {
                    zzI("timeupdate", "time", String.valueOf(f11), "totalBytes", String.valueOf(this.zzg.zzh()), "qoeCachedBytes", String.valueOf(this.zzg.zzf()), "qoeLoadedBytes", String.valueOf(this.zzg.zzg()), "droppedFrames", String.valueOf(this.zzg.zzb()), "reportTime", String.valueOf(com.google.android.gms.ads.internal.zzt.zzA().currentTimeMillis()));
                } else {
                    zzI("timeupdate", "time", String.valueOf(f11));
                }
                this.zzl = zza2;
            }
        }
    }

    public final void zzs() {
        zzcko zzcko = this.zzg;
        if (zzcko != null) {
            zzcko.zzo();
        }
    }

    public final void zzt() {
        zzcko zzcko = this.zzg;
        if (zzcko != null) {
            zzcko.zzp();
        }
    }

    public final void zzu(int i11) {
        zzcko zzcko = this.zzg;
        if (zzcko != null) {
            zzcko.zzq(i11);
        }
    }

    @TargetApi(14)
    public final void zzv(MotionEvent motionEvent) {
        zzcko zzcko = this.zzg;
        if (zzcko != null) {
            zzcko.dispatchTouchEvent(motionEvent);
        }
    }

    public final void zzw(int i11) {
        this.zzg.zzw(i11);
    }

    public final void zzx(int i11) {
        this.zzg.zzx(i11);
    }

    public final void zzy(int i11) {
        this.zzg.zzy(i11);
    }

    public final void zzz(int i11) {
        this.zzg.zzz(i11);
    }
}
