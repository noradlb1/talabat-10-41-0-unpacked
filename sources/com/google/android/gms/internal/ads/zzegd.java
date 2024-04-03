package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public final class zzegd extends SQLiteOpenHelper {
    public zzegd(Context context) {
        super(context, "OfflineUpload.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL("CREATE TABLE offline_signal_contents (timestamp INTEGER PRIMARY_KEY, serialized_proto_data BLOB)");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE offline_signal_contents (timestamp INTEGER PRIMARY_KEY, serialized_proto_data BLOB)");
        }
        if (!z11) {
            sQLiteDatabase.execSQL("CREATE TABLE offline_signal_statistics (statistic_name TEXT PRIMARY_KEY, value INTEGER)");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE offline_signal_statistics (statistic_name TEXT PRIMARY_KEY, value INTEGER)");
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("statistic_name", "failed_requests");
        contentValues.put("value", 0);
        if (!z11) {
            sQLiteDatabase.insert("offline_signal_statistics", (String) null, contentValues);
        } else {
            SQLiteInstrumentation.insert(sQLiteDatabase, "offline_signal_statistics", (String) null, contentValues);
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("statistic_name", "total_requests");
        contentValues2.put("value", 0);
        if (!z11) {
            sQLiteDatabase.insert("offline_signal_statistics", (String) null, contentValues2);
        } else {
            SQLiteInstrumentation.insert(sQLiteDatabase, "offline_signal_statistics", (String) null, contentValues2);
        }
        ContentValues contentValues3 = new ContentValues();
        contentValues3.put("statistic_name", "last_successful_request_time");
        contentValues3.put("value", 0L);
        if (!z11) {
            sQLiteDatabase.insert("offline_signal_statistics", (String) null, contentValues3);
        } else {
            SQLiteInstrumentation.insert(sQLiteDatabase, "offline_signal_statistics", (String) null, contentValues3);
        }
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        onUpgrade(sQLiteDatabase, i11, i12);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_signal_contents");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS offline_signal_contents");
        }
        if (!z11) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_signal_statistics");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS offline_signal_statistics");
        }
    }
}
