package com.google.android.gms.tagmanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.common.util.VisibleForTesting;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.HashSet;
import org.apache.commons.lang3.time.DateUtils;

@Instrumented
@VisibleForTesting
final class zzed extends SQLiteOpenHelper {
    private final /* synthetic */ zzeb zzaik;
    private boolean zzail;
    private long zzaim = 0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzed(zzeb zzeb, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.zzaik = zzeb;
    }

    private static boolean zza(String str, SQLiteDatabase sQLiteDatabase) {
        String str2;
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            String[] strArr = {"name"};
            String[] strArr2 = {str};
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                cursor = sQLiteDatabase.query("SQLITE_MASTER", strArr, "name=?", strArr2, (String) null, (String) null, (String) null);
            } else {
                cursor = SQLiteInstrumentation.query(sQLiteDatabase, "SQLITE_MASTER", strArr, "name=?", strArr2, (String) null, (String) null, (String) null);
            }
            Cursor cursor3 = cursor;
            boolean moveToFirst = cursor3.moveToFirst();
            cursor3.close();
            return moveToFirst;
        } catch (SQLiteException unused) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "Error querying for table ".concat(valueOf);
            } else {
                str2 = new String("Error querying for table ");
            }
            zzdi.zzac(str2);
            if (cursor2 != null) {
                cursor2.close();
            }
            return false;
        } catch (Throwable th2) {
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th2;
        }
    }

    public final SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        if (!this.zzail || this.zzaim + DateUtils.MILLIS_PER_HOUR <= this.zzaik.zzsd.currentTimeMillis()) {
            this.zzail = true;
            this.zzaim = this.zzaik.zzsd.currentTimeMillis();
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException unused) {
                this.zzaik.zzrm.getDatabasePath(this.zzaik.zzaih).delete();
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
        zzbr.zzbb(sQLiteDatabase.getPath());
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
    }

    /* JADX INFO: finally extract failed */
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        if (!zza("gtm_hits", sQLiteDatabase)) {
            String zzix = zzeb.zzxj;
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL(zzix);
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, zzix);
            }
        } else {
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                cursor = sQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", (String[]) null);
            } else {
                cursor = SQLiteInstrumentation.rawQuery(sQLiteDatabase, "SELECT * FROM gtm_hits WHERE 0", (String[]) null);
            }
            HashSet hashSet = new HashSet();
            try {
                String[] columnNames = cursor.getColumnNames();
                for (String add : columnNames) {
                    hashSet.add(add);
                }
                cursor.close();
                if (!hashSet.remove("hit_id") || !hashSet.remove("hit_url") || !hashSet.remove("hit_time") || !hashSet.remove("hit_first_send_time")) {
                    throw new SQLiteException("Database column missing");
                } else if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } catch (Throwable th2) {
                cursor.close();
                throw th2;
            }
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
    }
}
