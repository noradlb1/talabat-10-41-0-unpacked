package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

final class zzehg implements zzfwm<SQLiteDatabase> {
    final /* synthetic */ zzfhh zza;

    public zzehg(zzehh zzehh, zzfhh zzfhh) {
        this.zza = zzfhh;
    }

    public final void zza(Throwable th2) {
        String valueOf = String.valueOf(th2.getMessage());
        zzciz.zzg(valueOf.length() != 0 ? "Failed to get offline buffered ping database: ".concat(valueOf) : new String("Failed to get offline buffered ping database: "));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str;
        try {
            this.zza.zza((SQLiteDatabase) obj);
        } catch (Exception e11) {
            String valueOf = String.valueOf(e11.getMessage());
            if (valueOf.length() != 0) {
                str = "Error executing function on offline buffered ping database: ".concat(valueOf);
            } else {
                str = new String("Error executing function on offline buffered ping database: ");
            }
            zzciz.zzg(str);
        }
    }
}
