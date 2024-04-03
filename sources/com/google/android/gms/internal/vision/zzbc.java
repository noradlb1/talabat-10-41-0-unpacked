package com.google.android.gms.internal.vision;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.util.Log;

public final class zzbc {
    private static volatile zzcn<Boolean> zzfv = zzcn.zzbx();
    private static final Object zzfw = new Object();

    public static boolean zza(Context context, Uri uri) {
        boolean z11;
        String authority = uri.getAuthority();
        boolean z12 = false;
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(authority).length() + 91);
            sb2.append(authority);
            sb2.append(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
            Log.e("PhenotypeClientHelper", sb2.toString());
            return false;
        } else if (zzfv.isPresent()) {
            return zzfv.get().booleanValue();
        } else {
            synchronized (zzfw) {
                if (zzfv.isPresent()) {
                    boolean booleanValue = zzfv.get().booleanValue();
                    return booleanValue;
                }
                if (!"com.google.android.gms".equals(context.getPackageName())) {
                    ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", 0);
                    if (resolveContentProvider == null || !"com.google.android.gms".equals(resolveContentProvider.packageName)) {
                        z11 = false;
                        if (z11 && zzh(context)) {
                            z12 = true;
                        }
                        zzfv = zzcn.zzb(Boolean.valueOf(z12));
                        return zzfv.get().booleanValue();
                    }
                }
                z11 = true;
                z12 = true;
                zzfv = zzcn.zzb(Boolean.valueOf(z12));
                return zzfv.get().booleanValue();
            }
        }
    }

    private static boolean zzh(Context context) {
        try {
            if ((context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & 129) != 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }
}
