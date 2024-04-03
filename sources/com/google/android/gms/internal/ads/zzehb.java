package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

public final /* synthetic */ class zzehb implements zzfhh {
    public final /* synthetic */ zzehh zza;
    public final /* synthetic */ zzcje zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzehb(zzehh zzehh, zzcje zzcje, String str) {
        this.zza = zzehh;
        this.zzb = zzcje;
        this.zzc = str;
    }

    public final Object zza(Object obj) {
        this.zza.zzg((SQLiteDatabase) obj, this.zzb, this.zzc);
        return null;
    }
}
