package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.common.util.VisibleForTesting;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.apache.commons.lang3.time.DateUtils;

@Instrumented
@VisibleForTesting
final class zzfa extends SQLiteOpenHelper {
    private boolean zzail;
    private long zzaim = 0;
    private final /* synthetic */ zzey zzaom;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfa(zzey zzey, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.zzaom = zzey;
    }

    private static boolean zza(String str, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            String[] strArr = {"name"};
            String[] strArr2 = {str};
            Cursor query = !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.query("SQLITE_MASTER", strArr, "name=?", strArr2, (String) null, (String) null, (String) null) : SQLiteInstrumentation.query(sQLiteDatabase, "SQLITE_MASTER", strArr, "name=?", strArr2, (String) null, (String) null, (String) null);
            boolean moveToFirst = query.moveToFirst();
            query.close();
            return moveToFirst;
        } catch (SQLiteException unused) {
            if (cursor != null) {
                cursor.close();
            }
            return false;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        if (!this.zzail || this.zzaim + DateUtils.MILLIS_PER_HOUR <= this.zzaom.zzsd.currentTimeMillis()) {
            this.zzail = true;
            this.zzaim = this.zzaom.zzsd.currentTimeMillis();
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException unused) {
                this.zzaom.zzrm.getDatabasePath(this.zzaom.zzaih).delete();
                sQLiteDatabase = null;
            }
            if (sQLiteDatabase == null) {
                sQLiteDatabase = super.getWritableDatabase();
            }
            this.zzail = false;
            return sQLiteDatabase;
        }
        throw new SQLiteException("Database creation failed");
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        String path = sQLiteDatabase.getPath();
        if (zzeg.version() >= 9) {
            File file = new File(path);
            file.setReadable(false, false);
            file.setWritable(false, false);
            file.setReadable(true, true);
            file.setWritable(true, true);
        }
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (!zza("gtm_hit_unique_ids", sQLiteDatabase)) {
            String zzix = zzey.zzaog;
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL(zzix);
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, zzix);
            }
        } else {
            zza(sQLiteDatabase, "gtm_hit_unique_ids", Arrays.asList(new String[]{"hit_unique_id"}));
        }
        if (!zza("gtm_hits", sQLiteDatabase)) {
            String zzkn = zzey.zzxj;
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL(zzkn);
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, zzkn);
            }
        } else {
            zza(sQLiteDatabase, "gtm_hits", Arrays.asList(new String[]{"hit_id", "hit_url", "hit_time", "hit_first_send_time", "hit_method", "hit_unique_id", "hit_headers", "hit_body"}));
        }
        String zzko = zzey.zzaoh;
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL(zzko);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, zzko);
        }
        String zzkp = zzey.zzaoi;
        if (!z11) {
            sQLiteDatabase.execSQL(zzkp);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, zzkp);
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
    }

    /* JADX INFO: finally extract failed */
    private static void zza(SQLiteDatabase sQLiteDatabase, String str, List<String> list) {
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 22);
        sb2.append("SELECT * FROM ");
        sb2.append(str);
        sb2.append(" WHERE 0");
        String sb3 = sb2.toString();
        Cursor rawQuery = !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.rawQuery(sb3, (String[]) null) : SQLiteInstrumentation.rawQuery(sQLiteDatabase, sb3, (String[]) null);
        HashSet hashSet = new HashSet();
        try {
            String[] columnNames = rawQuery.getColumnNames();
            for (String add : columnNames) {
                hashSet.add(add);
            }
            rawQuery.close();
            for (String next : list) {
                if (!hashSet.remove(next)) {
                    throw new SQLiteException(String.format("Database column %s missing in table %s.", new Object[]{next, str}));
                }
            }
            if (!hashSet.isEmpty()) {
                throw new SQLiteException(String.format("Database has extra columns in table %s.", new Object[]{str}));
            }
        } catch (Throwable th2) {
            rawQuery.close();
            throw th2;
        }
    }
}
