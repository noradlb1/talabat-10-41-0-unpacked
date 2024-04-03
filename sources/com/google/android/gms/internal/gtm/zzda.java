package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import java.util.Locale;

public final class zzda extends zzan {
    private String zzaau;
    private String zzaav;
    protected int zzaax;
    private int zzacu;
    protected boolean zzacv;
    private boolean zzacw;
    private boolean zzacx;

    public zzda(zzap zzap) {
        super(zzap);
    }

    public final void zzaw() {
        ApplicationInfo applicationInfo;
        int i11;
        zzcc zzcc;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        int i12;
        Context context = getContext();
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e11) {
            zzd("PackageManager doesn't know about the app package", e11);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            zzt("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null && (i11 = bundle.getInt("com.google.android.gms.analytics.globalConfigResource")) > 0 && (zzcc = (zzcc) new zzca(zzcm()).zzq(i11)) != null) {
            zzq("Loading global XML config values");
            String str = zzcc.zzaau;
            boolean z15 = false;
            if (str != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                this.zzaau = str;
                zzb("XML config - app name", str);
            }
            String str2 = zzcc.zzaav;
            if (str2 != null) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                this.zzaav = str2;
                zzb("XML config - app version", str2);
            }
            String str3 = zzcc.zzaaw;
            if (str3 != null) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (z13) {
                String lowerCase = str3.toLowerCase(Locale.US);
                if ("verbose".equals(lowerCase)) {
                    i12 = 0;
                } else if (CustomerInfoLocalDataSourceImpl.KEY.equals(lowerCase)) {
                    i12 = 1;
                } else if ("warning".equals(lowerCase)) {
                    i12 = 2;
                } else if ("error".equals(lowerCase)) {
                    i12 = 3;
                } else {
                    i12 = -1;
                }
                if (i12 >= 0) {
                    this.zzacu = i12;
                    zza("XML config - log level", Integer.valueOf(i12));
                }
            }
            int i13 = zzcc.zzaax;
            if (i13 >= 0) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (z14) {
                this.zzaax = i13;
                this.zzacv = true;
                zzb("XML config - dispatch period (sec)", Integer.valueOf(i13));
            }
            int i14 = zzcc.zzaay;
            if (i14 != -1) {
                if (i14 == 1) {
                    z15 = true;
                }
                this.zzacx = z15;
                this.zzacw = true;
                zzb("XML config - dry run", Boolean.valueOf(z15));
            }
        }
    }

    public final String zzaz() {
        zzdb();
        return this.zzaau;
    }

    public final String zzba() {
        zzdb();
        return this.zzaav;
    }

    public final boolean zzgh() {
        zzdb();
        return false;
    }

    public final boolean zzgi() {
        zzdb();
        return this.zzacw;
    }

    public final boolean zzgj() {
        zzdb();
        return this.zzacx;
    }
}
