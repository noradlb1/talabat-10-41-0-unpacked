package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzblj;
import com.google.android.gms.internal.ads.zzciz;
import com.google.android.gms.internal.ads.zzcjm;
import com.google.android.gms.internal.ads.zzebp;
import com.google.android.gms.internal.ads.zzebt;
import com.google.android.gms.internal.ads.zzfxb;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzaw {
    private final Context zza;
    private final zzebt zzb;
    private String zzc;
    private String zzd;
    private String zze;
    @Nullable
    private String zzf;
    private int zzg;
    private int zzh;
    private PointF zzi;
    private PointF zzj;
    private Handler zzk;
    private Runnable zzl;

    public zzaw(Context context) {
        this.zzg = 0;
        this.zzl = new zzai(this);
        this.zza = context;
        this.zzh = ViewConfiguration.get(context).getScaledTouchSlop();
        zzt.zzt().zzb();
        this.zzk = zzt.zzt().zza();
        this.zzb = zzt.zzs().zza();
    }

    private final void zzs(Context context) {
        int i11;
        ArrayList arrayList = new ArrayList();
        int zzu = zzu(arrayList, "None", true);
        int zzu2 = zzu(arrayList, "Shake", true);
        int zzu3 = zzu(arrayList, "Flick", true);
        zzebp zzebp = zzebp.zza;
        int ordinal = this.zzb.zza().ordinal();
        if (ordinal == 1) {
            i11 = zzu2;
        } else if (ordinal != 2) {
            i11 = zzu;
        } else {
            i11 = zzu3;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context, zzt.zzq().zzk());
        AtomicInteger atomicInteger = new AtomicInteger(i11);
        builder.setTitle("Setup gesture");
        builder.setSingleChoiceItems((CharSequence[]) arrayList.toArray(new String[0]), i11, new zzar(atomicInteger));
        builder.setNegativeButton("Dismiss", new zzan(this));
        builder.setPositiveButton("Save", new zzaq(this, atomicInteger, i11, zzu2, zzu3));
        builder.setOnCancelListener(new zzag(this));
        builder.create().show();
    }

    private final boolean zzt(float f11, float f12, float f13, float f14) {
        if (Math.abs(this.zzi.x - f11) >= ((float) this.zzh) || Math.abs(this.zzi.y - f12) >= ((float) this.zzh) || Math.abs(this.zzj.x - f13) >= ((float) this.zzh) || Math.abs(this.zzj.y - f14) >= ((float) this.zzh)) {
            return false;
        }
        return true;
    }

    private static final int zzu(List<String> list, String str, boolean z11) {
        if (!z11) {
            return -1;
        }
        list.add(str);
        return list.size() - 1;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(100);
        sb2.append("{Dialog: ");
        sb2.append(this.zzc);
        sb2.append(",DebugSignal: ");
        sb2.append(this.zzf);
        sb2.append(",AFMA Version: ");
        sb2.append(this.zze);
        sb2.append(",Ad Unit ID: ");
        sb2.append(this.zzd);
        sb2.append("}");
        return sb2.toString();
    }

    public final /* synthetic */ void zza() {
        zzs(this.zza);
    }

    public final /* synthetic */ void zzb() {
        zzs(this.zza);
    }

    public final /* synthetic */ void zzc(zzfxb zzfxb) {
        if (!zzt.zzs().zzj(this.zza, this.zzd, this.zze)) {
            zzt.zzs().zzd(this.zza, this.zzd, this.zze);
        } else {
            zzfxb.execute(new zzau(this));
        }
    }

    public final /* synthetic */ void zzd(zzfxb zzfxb) {
        if (!zzt.zzs().zzj(this.zza, this.zzd, this.zze)) {
            zzt.zzs().zzd(this.zza, this.zzd, this.zze);
        } else {
            zzfxb.execute(new zzah(this));
        }
    }

    public final /* synthetic */ void zze() {
        zzt.zzs().zzc(this.zza);
    }

    public final /* synthetic */ void zzf() {
        zzt.zzs().zzc(this.zza);
    }

    public final /* synthetic */ void zzg() {
        this.zzg = 4;
        zzr();
    }

    public final /* synthetic */ void zzh(AtomicInteger atomicInteger, int i11, int i12, int i13, DialogInterface dialogInterface, int i14) {
        if (atomicInteger.get() != i11) {
            if (atomicInteger.get() == i12) {
                this.zzb.zzj(zzebp.SHAKE);
            } else if (atomicInteger.get() == i13) {
                this.zzb.zzj(zzebp.FLICK);
            } else {
                this.zzb.zzj(zzebp.zza);
            }
        }
        zzr();
    }

    public final /* synthetic */ void zzi(String str, DialogInterface dialogInterface, int i11) {
        zzt.zzp();
        zzt.zzQ(this.zza, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    public final /* synthetic */ void zzj(int i11, int i12, int i13, int i14, int i15, DialogInterface dialogInterface, int i16) {
        if (i16 == i11) {
            if (!(this.zza instanceof Activity)) {
                zzciz.zzi("Can not create dialog without Activity Context");
                return;
            }
            String str = this.zzc;
            String str2 = "No debug information";
            if (!TextUtils.isEmpty(str)) {
                Uri build = new Uri.Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
                StringBuilder sb2 = new StringBuilder();
                zzt.zzp();
                Map<String, String> zzS = zzt.zzS(build);
                for (String next : zzS.keySet()) {
                    sb2.append(next);
                    sb2.append(" = ");
                    sb2.append(zzS.get(next));
                    sb2.append("\n\n");
                }
                String trim = sb2.toString().trim();
                if (!TextUtils.isEmpty(trim)) {
                    str2 = trim;
                }
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this.zza);
            builder.setMessage(str2);
            builder.setTitle("Ad Information");
            builder.setPositiveButton("Share", new zzap(this, str2));
            builder.setNegativeButton("Close", zzas.zza);
            builder.create().show();
        } else if (i16 == i12) {
            zzciz.zze("Debug mode [Creative Preview] selected.");
            zzcjm.zza.execute(new zzak(this));
        } else if (i16 == i13) {
            zzciz.zze("Debug mode [Troubleshooting] selected.");
            zzcjm.zza.execute(new zzaj(this));
        } else if (i16 == i14) {
            zzfxb zzfxb = zzcjm.zze;
            zzfxb zzfxb2 = zzcjm.zza;
            if (this.zzb.zzm()) {
                zzfxb.execute(new zzav(this));
            } else {
                zzfxb2.execute(new zzam(this, zzfxb));
            }
        } else if (i16 == i15) {
            zzfxb zzfxb3 = zzcjm.zze;
            zzfxb zzfxb4 = zzcjm.zza;
            if (this.zzb.zzm()) {
                zzfxb3.execute(new zzat(this));
            } else {
                zzfxb4.execute(new zzal(this, zzfxb3));
            }
        }
    }

    public final /* synthetic */ void zzk() {
        zzba zzs = zzt.zzs();
        Context context = this.zza;
        String str = this.zzd;
        String str2 = this.zze;
        String str3 = this.zzf;
        boolean zzm = zzs.zzm();
        zzs.zzh(zzs.zzj(context, str, str2));
        if (zzs.zzm()) {
            if (!zzm && !TextUtils.isEmpty(str3)) {
                zzs.zze(context, str2, str3, str);
            }
            zzciz.zze("Device is linked for debug signals.");
            zzs.zzi(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        zzs.zzd(context, str, str2);
    }

    public final /* synthetic */ void zzl() {
        zzba zzs = zzt.zzs();
        Context context = this.zza;
        String str = this.zzd;
        String str2 = this.zze;
        if (!zzs.zzk(context, str, str2)) {
            zzs.zzi(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
        } else if (ExifInterface.GPS_MEASUREMENT_2D.equals(zzs.zza)) {
            zzciz.zze("Creative is not pushed for this device.");
            zzs.zzi(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(zzs.zza)) {
            zzciz.zze("The app is not linked for creative preview.");
            zzs.zzd(context, str, str2);
        } else if ("0".equals(zzs.zza)) {
            zzciz.zze("Device is linked for in app preview.");
            zzs.zzi(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final void zzm(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int historySize = motionEvent.getHistorySize();
        int pointerCount = motionEvent.getPointerCount();
        if (actionMasked == 0) {
            this.zzg = 0;
            this.zzi = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return;
        }
        int i11 = this.zzg;
        if (i11 != -1) {
            if (i11 == 0) {
                if (actionMasked == 5) {
                    this.zzg = 5;
                    this.zzj = new PointF(motionEvent.getX(1), motionEvent.getY(1));
                    this.zzk.postDelayed(this.zzl, ((Long) zzbgq.zzc().zzb(zzblj.zzdj)).longValue());
                }
            } else if (i11 == 5) {
                if (pointerCount == 2) {
                    if (actionMasked == 2) {
                        boolean z11 = false;
                        for (int i12 = 0; i12 < historySize; i12++) {
                            z11 |= !zzt(motionEvent.getHistoricalX(0, i12), motionEvent.getHistoricalY(0, i12), motionEvent.getHistoricalX(1, i12), motionEvent.getHistoricalY(1, i12));
                        }
                        if (zzt(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1)) && !z11) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                this.zzg = -1;
                this.zzk.removeCallbacks(this.zzl);
            }
        }
    }

    public final void zzn(String str) {
        this.zzd = str;
    }

    public final void zzo(String str) {
        this.zze = str;
    }

    public final void zzp(String str) {
        this.zzc = str;
    }

    public final void zzq(String str) {
        this.zzf = str;
    }

    public final void zzr() {
        try {
            if (!(this.zza instanceof Activity)) {
                zzciz.zzi("Can not create dialog without Activity Context");
                return;
            }
            String str = "Creative preview (enabled)";
            if (true == TextUtils.isEmpty(zzt.zzs().zzb())) {
                str = "Creative preview";
            }
            String str2 = "Troubleshooting (enabled)";
            if (true != zzt.zzs().zzm()) {
                str2 = "Troubleshooting";
            }
            ArrayList arrayList = new ArrayList();
            int zzu = zzu(arrayList, "Ad information", true);
            int zzu2 = zzu(arrayList, str, true);
            int zzu3 = zzu(arrayList, str2, true);
            boolean booleanValue = ((Boolean) zzbgq.zzc().zzb(zzblj.zzgP)).booleanValue();
            int zzu4 = zzu(arrayList, "Open ad inspector", booleanValue);
            int zzu5 = zzu(arrayList, "Ad inspector settings", booleanValue);
            AlertDialog.Builder builder = new AlertDialog.Builder(this.zza, zzt.zzq().zzk());
            builder.setTitle("Select a debug mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new zzao(this, zzu, zzu2, zzu3, zzu4, zzu5));
            builder.create().show();
        } catch (WindowManager.BadTokenException e11) {
            zze.zzb("", e11);
        }
    }

    public zzaw(Context context, String str) {
        this(context);
        this.zzc = str;
    }
}
