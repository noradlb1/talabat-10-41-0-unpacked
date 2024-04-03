package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzbv;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public final class zzehh extends SQLiteOpenHelper {
    private final Context zza;
    private final zzfxb zzb;

    public zzehh(Context context, zzfxb zzfxb) {
        super(context, "AdMobOfflineBufferedPings.db", (SQLiteDatabase.CursorFactory) null, ((Integer) zzbgq.zzc().zzb(zzblj.zzgh)).intValue());
        this.zza = context;
        this.zzb = zzfxb;
    }

    public static /* synthetic */ void zzf(SQLiteDatabase sQLiteDatabase, String str, zzcje zzcje) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_state", 1);
        String[] strArr = {str};
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.update("offline_buffered_pings", contentValues, "gws_query_id = ?", strArr);
        } else {
            SQLiteInstrumentation.update(sQLiteDatabase, "offline_buffered_pings", contentValues, "gws_query_id = ?", strArr);
        }
        zzj(sQLiteDatabase, zzcje);
    }

    public static final void zzi(SQLiteDatabase sQLiteDatabase, String str) {
        String[] strArr = {str, Integer.toString(0)};
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.delete("offline_buffered_pings", "gws_query_id = ? AND event_state = ?", strArr);
        } else {
            SQLiteInstrumentation.delete(sQLiteDatabase, "offline_buffered_pings", "gws_query_id = ? AND event_state = ?", strArr);
        }
    }

    /* access modifiers changed from: private */
    public static void zzj(SQLiteDatabase sQLiteDatabase, zzcje zzcje) {
        sQLiteDatabase.beginTransaction();
        try {
            StringBuilder sb2 = new StringBuilder(25);
            sb2.append("event_state = ");
            sb2.append(1);
            Cursor query = SQLiteInstrumentation.query(sQLiteDatabase, "offline_buffered_pings", new String[]{"url"}, sb2.toString(), (String[]) null, (String) null, (String) null, "timestamp ASC", (String) null);
            int count = query.getCount();
            String[] strArr = new String[count];
            int i11 = 0;
            while (query.moveToNext()) {
                int columnIndex = query.getColumnIndex("url");
                if (columnIndex != -1) {
                    strArr[i11] = query.getString(columnIndex);
                }
                i11++;
            }
            query.close();
            SQLiteInstrumentation.delete(sQLiteDatabase, "offline_buffered_pings", "event_state = ?", new String[]{Integer.toString(1)});
            sQLiteDatabase.setTransactionSuccessful();
            for (int i12 = 0; i12 < count; i12++) {
                zzcje.zza(strArr[i12]);
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL("CREATE TABLE offline_buffered_pings (timestamp INTEGER PRIMARY_KEY, gws_query_id TEXT, url TEXT, event_state INTEGER)");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE offline_buffered_pings (timestamp INTEGER PRIMARY_KEY, gws_query_id TEXT, url TEXT, event_state INTEGER)");
        }
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS offline_buffered_pings");
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS offline_buffered_pings");
        }
    }

    public final /* synthetic */ Void zza(zzehj zzehj, SQLiteDatabase sQLiteDatabase) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(zzehj.zza));
        contentValues.put("gws_query_id", zzehj.zzb);
        contentValues.put("url", zzehj.zzc);
        contentValues.put("event_state", Integer.valueOf(zzehj.zzd - 1));
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.insert("offline_buffered_pings", (String) null, contentValues);
        } else {
            SQLiteInstrumentation.insert(sQLiteDatabase, "offline_buffered_pings", (String) null, contentValues);
        }
        zzt.zzp();
        zzbv zzE = com.google.android.gms.ads.internal.util.zzt.zzE(this.zza);
        if (zzE != null) {
            try {
                zzE.zze(ObjectWrapper.wrap(this.zza));
            } catch (RemoteException e11) {
                zze.zzb("Failed to schedule offline ping sender.", e11);
            }
        }
        return null;
    }

    public final void zzc(String str) {
        zze(new zzehd(this, str));
    }

    public final void zzd(zzehj zzehj) {
        zze(new zzehc(this, zzehj));
    }

    public final void zze(zzfhh<SQLiteDatabase, Void> zzfhh) {
        zzfwq.zzr(this.zzb.zzb(new zzehf(this)), new zzehg(this, zzfhh), this.zzb);
    }

    public final void zzg(SQLiteDatabase sQLiteDatabase, zzcje zzcje, String str) {
        this.zzb.execute(new zzehe(sQLiteDatabase, str, zzcje));
    }

    public final void zzh(zzcje zzcje, String str) {
        zze(new zzehb(this, zzcje, str));
    }
}
