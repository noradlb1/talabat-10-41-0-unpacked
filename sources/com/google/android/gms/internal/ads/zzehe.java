package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

public final /* synthetic */ class zzehe implements Runnable {
    public final /* synthetic */ SQLiteDatabase zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzcje zzc;

    public /* synthetic */ zzehe(SQLiteDatabase sQLiteDatabase, String str, zzcje zzcje) {
        this.zza = sQLiteDatabase;
        this.zzb = str;
        this.zzc = zzcje;
    }

    public final void run() {
        zzehh.zzf(this.zza, this.zzb, this.zzc);
    }
}
