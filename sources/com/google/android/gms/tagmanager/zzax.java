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

@Instrumented
@VisibleForTesting
final class zzax extends SQLiteOpenHelper {
    private final /* synthetic */ zzat zzagd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzax(zzat zzat, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.zzagd = zzat;
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
        try {
            sQLiteDatabase = super.getWritableDatabase();
        } catch (SQLiteException unused) {
            this.zzagd.zzrm.getDatabasePath("google_tagmanager.db").delete();
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase == null) {
            return super.getWritableDatabase();
        }
        return sQLiteDatabase;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzbr.zzbb(sQLiteDatabase.getPath());
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
    }

    /* JADX INFO: finally extract failed */
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        if (!zza("datalayer", sQLiteDatabase)) {
            String zzhx = zzat.zzafx;
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL(zzhx);
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, zzhx);
            }
        } else {
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                cursor = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", (String[]) null);
            } else {
                cursor = SQLiteInstrumentation.rawQuery(sQLiteDatabase, "SELECT * FROM datalayer WHERE 0", (String[]) null);
            }
            HashSet hashSet = new HashSet();
            try {
                String[] columnNames = cursor.getColumnNames();
                for (String add : columnNames) {
                    hashSet.add(add);
                }
                cursor.close();
                if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
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
