package com.google.android.gms.internal.ads;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;

@Instrumented
public final class zzegu {
    public static int zza(SQLiteDatabase sQLiteDatabase, int i11) {
        int i12;
        Cursor zzd = zzd(sQLiteDatabase, i11);
        if (zzd.getCount() > 0) {
            zzd.moveToNext();
            i12 = zzd.getInt(zzd.getColumnIndexOrThrow("value"));
        } else {
            i12 = 0;
        }
        zzd.close();
        return i12;
    }

    public static long zzb(SQLiteDatabase sQLiteDatabase, int i11) {
        long j11;
        Cursor zzd = zzd(sQLiteDatabase, 2);
        if (zzd.getCount() > 0) {
            zzd.moveToNext();
            j11 = zzd.getLong(zzd.getColumnIndexOrThrow("value"));
        } else {
            j11 = 0;
        }
        zzd.close();
        return j11;
    }

    public static ArrayList<zzbdf> zzc(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        ArrayList<zzbdf> arrayList = new ArrayList<>();
        String[] strArr = {"serialized_proto_data"};
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            cursor = sQLiteDatabase.query("offline_signal_contents", strArr, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        } else {
            cursor = SQLiteInstrumentation.query(sQLiteDatabase, "offline_signal_contents", strArr, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        }
        while (cursor.moveToNext()) {
            try {
                arrayList.add(zzbdf.zzi(cursor.getBlob(cursor.getColumnIndexOrThrow("serialized_proto_data"))));
            } catch (zzgkx e11) {
                zzciz.zzg("Unable to deserialize proto from offline signals database:");
                zzciz.zzg(e11.getMessage());
            }
        }
        cursor.close();
        return arrayList;
    }

    private static Cursor zzd(SQLiteDatabase sQLiteDatabase, int i11) {
        String[] strArr = {"value"};
        String[] strArr2 = new String[1];
        if (i11 == 0) {
            strArr2[0] = "failed_requests";
        } else if (i11 != 1) {
            strArr2[0] = "last_successful_request_time";
        } else {
            strArr2[0] = "total_requests";
        }
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            return sQLiteDatabase.query("offline_signal_statistics", strArr, "statistic_name = ?", strArr2, (String) null, (String) null, (String) null);
        }
        return SQLiteInstrumentation.query(sQLiteDatabase, "offline_signal_statistics", strArr, "statistic_name = ?", strArr2, (String) null, (String) null, (String) null);
    }
}
