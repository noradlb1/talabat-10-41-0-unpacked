package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

public final /* synthetic */ class zzehd implements zzfhh {
    public final /* synthetic */ zzehh zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzehd(zzehh zzehh, String str) {
        this.zza = zzehh;
        this.zzb = str;
    }

    public final Object zza(Object obj) {
        zzehh.zzi((SQLiteDatabase) obj, this.zzb);
        return null;
    }
}
