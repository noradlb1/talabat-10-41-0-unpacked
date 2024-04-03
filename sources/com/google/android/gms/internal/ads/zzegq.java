package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.zzt;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;

@Instrumented
public final /* synthetic */ class zzegq implements zzfhh {
    public final /* synthetic */ zzegr zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ ArrayList zzc;
    public final /* synthetic */ zzbda zzd;
    public final /* synthetic */ zzbdj zze;

    public /* synthetic */ zzegq(zzegr zzegr, boolean z11, ArrayList arrayList, zzbda zzbda, zzbdj zzbdj) {
        this.zza = zzegr;
        this.zzb = z11;
        this.zzc = arrayList;
        this.zzd = zzbda;
        this.zze = zzbdj;
    }

    public final Object zza(Object obj) {
        zzegr zzegr = this.zza;
        boolean z11 = this.zzb;
        ArrayList arrayList = this.zzc;
        zzbda zzbda = this.zzd;
        zzbdj zzbdj = this.zze;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        if (!zzegr.zzb.zzg.zzL()) {
            byte[] zzf = zzegs.zzf(zzegr.zzb, z11, arrayList, zzbda, zzbdj);
            ContentValues contentValues = new ContentValues();
            contentValues.put("timestamp", Long.valueOf(zzt.zzA().currentTimeMillis()));
            contentValues.put("serialized_proto_data", zzf);
            boolean z12 = sQLiteDatabase instanceof SQLiteDatabase;
            if (!z12) {
                sQLiteDatabase.insert("offline_signal_contents", (String) null, contentValues);
            } else {
                SQLiteInstrumentation.insert(sQLiteDatabase, "offline_signal_contents", (String) null, contentValues);
            }
            String format = String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", new Object[]{"total_requests"});
            if (!z12) {
                sQLiteDatabase.execSQL(format);
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, format);
            }
            if (!z11) {
                String format2 = String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", new Object[]{"failed_requests"});
                if (!z12) {
                    sQLiteDatabase.execSQL(format2);
                } else {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, format2);
                }
            }
        }
        return null;
    }
}
