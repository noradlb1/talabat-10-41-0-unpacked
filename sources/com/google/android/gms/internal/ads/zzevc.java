package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.ads.internal.util.zzae;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

public final class zzevc implements zzevn<zzevd> {
    private final zzfxb zza;
    private final Context zzb;
    private final zzcjf zzc;

    public zzevc(zzfxb zzfxb, Context context, zzcjf zzcjf) {
        this.zza = zzfxb;
        this.zzb = context;
        this.zzc = zzcjf;
    }

    public final /* synthetic */ zzevd zza() throws Exception {
        int i11;
        boolean isCallerInstantApp = Wrappers.packageManager(this.zzb).isCallerInstantApp();
        zzt.zzp();
        boolean zzI = com.google.android.gms.ads.internal.util.zzt.zzI(this.zzb);
        String str = this.zzc.zza;
        zzt.zzq();
        boolean zzu = zzae.zzu();
        zzt.zzp();
        ApplicationInfo applicationInfo = this.zzb.getApplicationInfo();
        if (applicationInfo == null) {
            i11 = 0;
        } else {
            i11 = applicationInfo.targetSdkVersion;
        }
        return new zzevd(isCallerInstantApp, zzI, str, zzu, i11, DynamiteModule.getRemoteVersion(this.zzb, ModuleDescriptor.MODULE_ID), DynamiteModule.getLocalVersion(this.zzb, ModuleDescriptor.MODULE_ID));
    }

    public final zzfxa<zzevd> zzb() {
        return this.zza.zzb(new zzevb(this));
    }
}
