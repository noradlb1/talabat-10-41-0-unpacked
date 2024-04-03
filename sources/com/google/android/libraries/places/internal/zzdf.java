package com.google.android.libraries.places.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class zzdf {
    public static zzde zzd(Context context) {
        String packageName = context.getPackageName();
        int i11 = 0;
        try {
            i11 = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        zzdb zzdb = new zzdb();
        zzdb.zza(packageName);
        zzdb.zzb(i11);
        zzdb.zzd(1);
        return zzdb;
    }

    public abstract int zza();

    public abstract String zzb();

    public abstract int zzc();
}
