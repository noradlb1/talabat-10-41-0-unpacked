package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzcik {
    /* access modifiers changed from: private */
    public final Object zza = new Object();
    private final zzj zzb;
    private final zzcio zzc;
    private boolean zzd;
    /* access modifiers changed from: private */
    public Context zze;
    /* access modifiers changed from: private */
    public zzcjf zzf;
    /* access modifiers changed from: private */
    @Nullable
    public zzblo zzg;
    @Nullable
    private Boolean zzh;
    private final AtomicInteger zzi;
    private final zzcij zzj;
    private final Object zzk;
    @GuardedBy("grantedPermissionLock")
    private zzfxa<ArrayList<String>> zzl;

    public zzcik() {
        zzj zzj2 = new zzj();
        this.zzb = zzj2;
        this.zzc = new zzcio(zzbgo.zzd(), zzj2);
        this.zzd = false;
        this.zzg = null;
        this.zzh = null;
        this.zzi = new AtomicInteger(0);
        this.zzj = new zzcij((zzcii) null);
        this.zzk = new Object();
    }

    public final int zza() {
        return this.zzi.get();
    }

    @Nullable
    public final Context zzc() {
        return this.zze;
    }

    @Nullable
    public final Resources zzd() {
        if (this.zzf.zzd) {
            return this.zze.getResources();
        }
        try {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzho)).booleanValue()) {
                return zzcjd.zza(this.zze).getResources();
            }
            zzcjd.zza(this.zze).getResources();
            return null;
        } catch (zzcjc e11) {
            zzciz.zzk("Cannot load resource from dynamite apk or local jar", e11);
            return null;
        }
    }

    @Nullable
    public final zzblo zzf() {
        zzblo zzblo;
        synchronized (this.zza) {
            zzblo = this.zzg;
        }
        return zzblo;
    }

    public final zzcio zzg() {
        return this.zzc;
    }

    public final zzg zzh() {
        zzj zzj2;
        synchronized (this.zza) {
            zzj2 = this.zzb;
        }
        return zzj2;
    }

    public final zzfxa<ArrayList<String>> zzj() {
        if (PlatformVersion.isAtLeastJellyBean() && this.zze != null) {
            if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzbT)).booleanValue()) {
                synchronized (this.zzk) {
                    zzfxa<ArrayList<String>> zzfxa = this.zzl;
                    if (zzfxa != null) {
                        return zzfxa;
                    }
                    zzfxa<ArrayList<String>> zzb2 = zzcjm.zza.zzb(new zzcig(this));
                    this.zzl = zzb2;
                    return zzb2;
                }
            }
        }
        return zzfwq.zzi(new ArrayList());
    }

    public final Boolean zzk() {
        Boolean bool;
        synchronized (this.zza) {
            bool = this.zzh;
        }
        return bool;
    }

    public final /* synthetic */ ArrayList zzm() throws Exception {
        Context zza2 = zzcee.zza(this.zze);
        ArrayList arrayList = new ArrayList();
        try {
            PackageInfo packageInfo = Wrappers.packageManager(zza2).getPackageInfo(zza2.getApplicationInfo().packageName, 4096);
            if (packageInfo.requestedPermissions != null && packageInfo.requestedPermissionsFlags != null) {
                int i11 = 0;
                while (true) {
                    String[] strArr = packageInfo.requestedPermissions;
                    if (i11 >= strArr.length) {
                        break;
                    }
                    if ((packageInfo.requestedPermissionsFlags[i11] & 2) != 0) {
                        arrayList.add(strArr[i11]);
                    }
                    i11++;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return arrayList;
    }

    public final void zzn() {
        this.zzj.zza();
    }

    public final void zzo() {
        this.zzi.decrementAndGet();
    }

    public final void zzp() {
        this.zzi.incrementAndGet();
    }

    @TargetApi(23)
    public final void zzq(Context context, zzcjf zzcjf) {
        zzblo zzblo;
        synchronized (this.zza) {
            if (!this.zzd) {
                this.zze = context.getApplicationContext();
                this.zzf = zzcjf;
                zzt.zzb().zzc(this.zzc);
                this.zzb.zzp(this.zze);
                zzcct.zzb(this.zze, this.zzf);
                zzt.zze();
                if (!zzbms.zzc.zze().booleanValue()) {
                    zze.zza("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                    zzblo = null;
                } else {
                    zzblo = new zzblo();
                }
                this.zzg = zzblo;
                if (zzblo != null) {
                    zzcjp.zza(new zzcih(this).zzb(), "AppState.registerCsiReporter");
                }
                this.zzd = true;
                zzj();
            }
        }
        zzt.zzp().zzd(context, zzcjf.zza);
    }

    public final void zzr(Throwable th2, String str) {
        zzcct.zzb(this.zze, this.zzf).zze(th2, str, zzbne.zzg.zze().floatValue());
    }

    public final void zzs(Throwable th2, String str) {
        zzcct.zzb(this.zze, this.zzf).zzd(th2, str);
    }

    public final void zzt(Boolean bool) {
        synchronized (this.zza) {
            this.zzh = bool;
        }
    }
}
