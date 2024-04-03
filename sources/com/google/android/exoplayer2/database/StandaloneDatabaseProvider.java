package com.google.android.exoplayer2.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.exoplayer2.util.Log;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public class StandaloneDatabaseProvider extends SQLiteOpenHelper implements DatabaseProvider {
    public static final String DATABASE_NAME = "exoplayer_internal.db";
    private static final String TAG = "SADatabaseProvider";
    private static final int VERSION = 1;

    public StandaloneDatabaseProvider(Context context) {
        super(context.getApplicationContext(), DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    private static void wipeDatabase(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        String str;
        String[] strArr = {"type", "name"};
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            cursor = sQLiteDatabase.query("sqlite_master", strArr, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        } else {
            cursor = SQLiteInstrumentation.query(sQLiteDatabase, "sqlite_master", strArr, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        }
        while (cursor.moveToNext()) {
            try {
                String string = cursor.getString(0);
                String string2 = cursor.getString(1);
                if (!"sqlite_sequence".equals(string2)) {
                    str = "DROP " + string + " IF EXISTS " + string2;
                    if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                        sQLiteDatabase.execSQL(str);
                    } else {
                        SQLiteInstrumentation.execSQL(sQLiteDatabase, str);
                    }
                }
            } catch (SQLException e11) {
                Log.e(TAG, "Error executing " + str, e11);
            } catch (Throwable th2) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
        cursor.close();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        wipeDatabase(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
    }
}
