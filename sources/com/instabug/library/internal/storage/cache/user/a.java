package com.instabug.library.internal.storage.cache.user;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.Nullable;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.instabug.library.model.j;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public abstract class a {
    public static synchronized long a(j jVar) {
        long insertWithOnConflict;
        synchronized (a.class) {
            InstabugSDKLogger.d("IBG-Core", "inserting user to DB");
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            openDatabase.beginTransaction();
            try {
                if (openDatabase.queryNumEntries("user") >= com.instabug.library.internal.dataretention.j.USER_DATA.a()) {
                    a(openDatabase);
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put(InstabugDbContract.UserEntity.COLUMN_SESSION_COUNT, Integer.valueOf(jVar.b()));
                contentValues.put(InstabugDbContract.UserEntity.COLUMN_LAST_SEEN, Long.valueOf(jVar.a()));
                contentValues.put("uuid", jVar.c());
                insertWithOnConflict = openDatabase.insertWithOnConflict("user", (String) null, contentValues);
                if (insertWithOnConflict == -1) {
                    b(jVar);
                }
                openDatabase.setTransactionSuccessful();
                openDatabase.endTransaction();
                openDatabase.close();
            } catch (Exception e11) {
                try {
                    IBGDiagnostics.reportNonFatalAndLog(e11, "Error while inserting user", "IBG-Core");
                    return -1;
                } finally {
                    openDatabase.endTransaction();
                    openDatabase.close();
                }
            }
        }
        return insertWithOnConflict;
    }

    public static synchronized long b(j jVar) {
        int i11;
        long j11;
        synchronized (a.class) {
            InstabugSDKLogger.d("IBG-Core", "updating user in DB");
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            String[] strArr = {jVar.c()};
            openDatabase.beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(InstabugDbContract.UserEntity.COLUMN_SESSION_COUNT, Integer.valueOf(jVar.b()));
                contentValues.put(InstabugDbContract.UserEntity.COLUMN_LAST_SEEN, Long.valueOf(jVar.a()));
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    i11 = openDatabase.update("user", contentValues, "uuid = ?", strArr);
                } else {
                    i11 = SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, "user", contentValues, "uuid = ?", strArr);
                }
                j11 = (long) i11;
                openDatabase.setTransactionSuccessful();
                openDatabase.endTransaction();
                openDatabase.close();
            } catch (Exception e11) {
                try {
                    IBGDiagnostics.reportNonFatalAndLog(e11, "Error while updating user", "IBG-Core");
                    return -1;
                } finally {
                    openDatabase.endTransaction();
                    openDatabase.close();
                }
            }
        }
        return j11;
    }

    @Nullable
    public static j a(String str) {
        InstabugSDKLogger.d("IBG-Core", "retrieving user by uuid");
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        String[] strArr = {str};
        Cursor query = !(openDatabase instanceof SQLiteDatabase) ? openDatabase.query("user", (String[]) null, "uuid =?", strArr, (String) null, (String) null, (String) null) : SQLiteInstrumentation.query((SQLiteDatabase) openDatabase, "user", (String[]) null, "uuid =?", strArr, (String) null, (String) null, (String) null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    return new j(str, query.getInt(query.getColumnIndex(InstabugDbContract.UserEntity.COLUMN_SESSION_COUNT)), query.getLong(query.getColumnIndex(InstabugDbContract.UserEntity.COLUMN_LAST_SEEN)));
                }
            } catch (Exception e11) {
                IBGDiagnostics.reportNonFatalAndLog(e11, "Error while retrieving user", "IBG-Core");
                return null;
            } finally {
                query.close();
                openDatabase.close();
            }
        }
        if (query != null) {
            query.close();
        }
        openDatabase.close();
        return null;
    }

    private static void a(SQLiteDatabaseWrapper sQLiteDatabaseWrapper) {
        if (!(sQLiteDatabaseWrapper instanceof SQLiteDatabase)) {
            sQLiteDatabaseWrapper.execSQL("DELETE FROM user WHERE last_seen = (SELECT MIN(last_seen) FROM user)");
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) sQLiteDatabaseWrapper, "DELETE FROM user WHERE last_seen = (SELECT MIN(last_seen) FROM user)");
        }
    }
}
