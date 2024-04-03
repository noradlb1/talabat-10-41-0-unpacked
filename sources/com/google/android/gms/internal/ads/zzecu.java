package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.Nullable;
import com.google.android.gms.common.wrappers.Wrappers;

public final class zzecu implements zzgpr<PackageInfo> {
    private final zzgqe<Context> zza;
    private final zzgqe<ApplicationInfo> zzb;

    public zzecu(zzgqe<Context> zzgqe, zzgqe<ApplicationInfo> zzgqe2) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
    }

    @Nullable
    public final /* bridge */ /* synthetic */ Object zzb() {
        try {
            return Wrappers.packageManager(this.zza.zzb()).getPackageInfo(((zzecp) this.zzb).zzb().packageName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
