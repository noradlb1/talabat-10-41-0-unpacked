package com.instabug.library.internal.storage.cache.db;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.Instabug;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public class DatabaseManager {
    private static SQLiteDatabaseWrapper databaseWrapper;
    private static DatabaseManager instance;

    public static synchronized void clearAll() {
        synchronized (DatabaseManager.class) {
            SQLiteDatabaseWrapper openDatabase = getInstance().openDatabase();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL(InstabugDbContract.NetworkLogEntry.DELETE_ALL);
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, InstabugDbContract.NetworkLogEntry.DELETE_ALL);
            }
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL(InstabugDbContract.InstabugLogEntry.DELETE_ALL);
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, InstabugDbContract.InstabugLogEntry.DELETE_ALL);
            }
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL(InstabugDbContract.AttachmentEntry.DELETE_ALL);
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, InstabugDbContract.AttachmentEntry.DELETE_ALL);
            }
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL(InstabugDbContract.CrashEntry.DELETE_ALL);
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, InstabugDbContract.CrashEntry.DELETE_ALL);
            }
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL(InstabugDbContract.ExperimentsEntry.DELETE_ALL);
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, InstabugDbContract.ExperimentsEntry.DELETE_ALL);
            }
        }
    }

    @SuppressLint({"RESOURCE_LEAK"})
    public static synchronized DatabaseManager getInstance() throws IllegalStateException {
        DatabaseManager databaseManager;
        synchronized (DatabaseManager.class) {
            if (instance == null) {
                if (Instabug.getApplicationContext() != null) {
                    InstabugSDKLogger.v("IBG-Core", "Initializing database manager");
                    init(a.a(Instabug.getApplicationContext()));
                } else {
                    throw new IllegalStateException(DatabaseManager.class.getSimpleName() + " is not initialized, call init(..) method first.");
                }
            }
            databaseManager = instance;
        }
        return databaseManager;
    }

    private static synchronized void init(SQLiteOpenHelper sQLiteOpenHelper) {
        synchronized (DatabaseManager.class) {
            if (instance == null) {
                instance = new DatabaseManager();
                databaseWrapper = new SQLiteDatabaseWrapper(sQLiteOpenHelper);
            }
        }
    }

    @VisibleForTesting
    @SuppressLint({"ERADICATE_FIELD_NOT_NULLABLE"})
    public static synchronized void tearDown() {
        synchronized (DatabaseManager.class) {
            SQLiteDatabaseWrapper sQLiteDatabaseWrapper = databaseWrapper;
            if (sQLiteDatabaseWrapper != null) {
                sQLiteDatabaseWrapper.closeDB();
                databaseWrapper = null;
            }
            instance = null;
        }
    }

    public synchronized SQLiteDatabaseWrapper openDatabase() {
        databaseWrapper.a();
        return databaseWrapper;
    }
}
