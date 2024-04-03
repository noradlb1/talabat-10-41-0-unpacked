package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

public final class zzbwv extends zzcje {
    private final zzbwu zza;

    public zzbwv(zzbwu zzbwu, @Nullable String str) {
        super(str);
        this.zza = zzbwu;
    }

    @WorkerThread
    public final void zza(String str) {
        String str2;
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "LeibnizHttpUrlPinger pinging URL: ".concat(valueOf);
        } else {
            str2 = new String("LeibnizHttpUrlPinger pinging URL: ");
        }
        zzciz.zze(str2);
        if (!"oda".equals(Uri.parse(str).getScheme())) {
            zzciz.zze("URL does not match oda:// scheme, falling back on HttpUrlPinger");
            super.zza(str);
        }
    }
}
