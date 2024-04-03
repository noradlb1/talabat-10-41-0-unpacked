package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

final class zzk extends zzbq {
    private static final String ID = zza.APP_VERSION.toString();
    private final Context zzrm;

    public zzk(Context context) {
        super(ID, new String[0]);
        this.zzrm = context;
    }

    public final zzl zzb(Map<String, zzl> map) {
        try {
            return zzgj.zzi(Integer.valueOf(this.zzrm.getPackageManager().getPackageInfo(this.zzrm.getPackageName(), 0).versionCode));
        } catch (PackageManager.NameNotFoundException e11) {
            String packageName = this.zzrm.getPackageName();
            String message = e11.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(packageName).length() + 25 + String.valueOf(message).length());
            sb2.append("Package name ");
            sb2.append(packageName);
            sb2.append(" not found. ");
            sb2.append(message);
            zzdi.zzav(sb2.toString());
            return zzgj.zzkc();
        }
    }

    public final boolean zzgw() {
        return true;
    }
}
