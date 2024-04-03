package com.google.android.gms.internal.auth;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

public final class zzcq {
    static volatile zzdh zza = zzdh.zzc();
    private static final Object zzb = new Object();

    public static boolean zza(Context context, Uri uri) {
        int i11;
        String authority = uri.getAuthority();
        boolean z11 = false;
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            Log.e("PhenotypeClientHelper", String.valueOf(authority).concat(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported."));
            return false;
        } else if (zza.zzb()) {
            return ((Boolean) zza.zza()).booleanValue();
        } else {
            synchronized (zzb) {
                if (zza.zzb()) {
                    boolean booleanValue = ((Boolean) zza.zza()).booleanValue();
                    return booleanValue;
                }
                if (!"com.google.android.gms".equals(context.getPackageName())) {
                    PackageManager packageManager = context.getPackageManager();
                    if (Build.VERSION.SDK_INT < 29) {
                        i11 = 0;
                    } else {
                        i11 = 268435456;
                    }
                    ProviderInfo resolveContentProvider = packageManager.resolveContentProvider("com.google.android.gms.phenotype", i11);
                    if (resolveContentProvider != null) {
                        if (!"com.google.android.gms".equals(resolveContentProvider.packageName)) {
                        }
                    }
                    zza = zzdh.zzd(Boolean.valueOf(z11));
                    return ((Boolean) zza.zza()).booleanValue();
                }
                try {
                    if ((context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & 129) != 0) {
                        z11 = true;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
                zza = zzdh.zzd(Boolean.valueOf(z11));
                return ((Boolean) zza.zza()).booleanValue();
            }
        }
    }
}
