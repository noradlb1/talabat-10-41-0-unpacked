package com.instabug.library.internal.storage.cache.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.Arrays;

@Instrumented
public class SQLiteDatabaseWrapper {
    @Nullable
    private SQLiteDatabase database;
    private SQLiteOpenHelper databaseHelper;
    @Nullable
    private Boolean databaseTransactionsEnabled;

    public SQLiteDatabaseWrapper(SQLiteOpenHelper sQLiteOpenHelper) {
        this.databaseHelper = sQLiteOpenHelper;
    }

    private synchronized boolean isDatabaseTransactionsEnabled() {
        boolean z11;
        if (this.databaseTransactionsEnabled == null && Instabug.getApplicationContext() != null) {
            this.databaseTransactionsEnabled = Boolean.valueOf(!InstabugCore.isDatabaseTransactionDisabled(Instabug.getApplicationContext()));
        }
        Boolean bool = this.databaseTransactionsEnabled;
        if (bool != null) {
            z11 = bool.booleanValue();
        } else {
            z11 = false;
        }
        return z11;
    }

    private synchronized void logOperationFailedWarning(String str) {
        SQLiteDatabase sQLiteDatabase = this.database;
        if (sQLiteDatabase == null) {
            InstabugSDKLogger.e("IBG-Core", "Attempted to do operation on an uninitialized database. Falling back silently");
        } else if (!sQLiteDatabase.isOpen()) {
            InstabugSDKLogger.e("IBG-Core", "Attempted to do operation on a closed database. Falling back silently");
        } else {
            InstabugSDKLogger.e("IBG-Core", str + " ,Falling back silently");
        }
    }

    public void a() {
        try {
            SQLiteDatabase sQLiteDatabase = this.database;
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                this.database = this.databaseHelper.getWritableDatabase();
            }
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Error while opening the DB: " + e11.getMessage(), e11);
            IBGDiagnostics.reportNonFatal(e11, "Error while opening the DB: " + e11.getMessage());
        } catch (OutOfMemoryError e12) {
            InstabugSDKLogger.e("IBG-Core", "Error while opening the DB: " + e12.getMessage(), e12);
            IBGDiagnostics.reportNonFatal(e12, "Error while opening the DB: " + e12.getMessage());
        }
    }

    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    public void beginTransaction() {
        try {
            SQLiteDatabase sQLiteDatabase = this.database;
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                logOperationFailedWarning("DB transaction failed");
            } else if (isDatabaseTransactionsEnabled()) {
                this.database.beginTransaction();
            }
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatal(e11, "DB transaction failed due to: " + e11.getMessage());
            logOperationFailedWarning("DB transaction failed due to:" + e11.getMessage());
        } catch (OutOfMemoryError e12) {
            IBGDiagnostics.reportNonFatal(e12, "DB transaction failed due to: " + e12.getMessage());
            logOperationFailedWarning("\"DB transaction failed due to an Exception due to: " + e12.getMessage());
        }
    }

    public synchronized void close() {
    }

    @VisibleForTesting
    public void closeDB() {
        SQLiteDatabase sQLiteDatabase = this.database;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
            this.database = null;
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public int delete(@NonNull String str, @Nullable String str2, @Nullable String[] strArr) {
        try {
            SQLiteDatabase sQLiteDatabase = this.database;
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                logOperationFailedWarning("DB deletion failed");
                return 0;
            }
            SQLiteDatabase sQLiteDatabase2 = this.database;
            if (!(sQLiteDatabase2 instanceof SQLiteDatabase)) {
                return sQLiteDatabase2.delete(str, str2, strArr);
            }
            return SQLiteInstrumentation.delete(sQLiteDatabase2, str, str2, strArr);
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatal(e11, "DB raw query failed: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
            logOperationFailedWarning("DB deletion failed: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
            return 0;
        } catch (OutOfMemoryError e12) {
            IBGDiagnostics.reportNonFatal(e12, "DB raw query failed: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
            logOperationFailedWarning("DB deletion failed: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
            return 0;
        }
    }

    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    public synchronized void endTransaction() {
        try {
            SQLiteDatabase sQLiteDatabase = this.database;
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                logOperationFailedWarning("DB end transaction not successful");
            } else if (isDatabaseTransactionsEnabled()) {
                this.database.endTransaction();
            }
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatal(e11, "DB end transaction not successful due to: " + e11.getMessage());
            logOperationFailedWarning("DB end transaction not successful due to: " + e11.getMessage());
        } catch (OutOfMemoryError e12) {
            IBGDiagnostics.reportNonFatal(e12, "DB end transaction not successful due to: " + e12.getMessage());
            logOperationFailedWarning("B end transaction not successful due to: " + e12.getMessage());
        }
    }

    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    public void execSQL(@NonNull String str) {
        try {
            SQLiteDatabase sQLiteDatabase = this.database;
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                logOperationFailedWarning("DB execution a sql failed");
                return;
            }
            SQLiteDatabase sQLiteDatabase2 = this.database;
            if (!(sQLiteDatabase2 instanceof SQLiteDatabase)) {
                sQLiteDatabase2.execSQL(str);
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase2, str);
            }
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatal(e11, "DB execution a sql failed: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
            logOperationFailedWarning("DB execution a sql failed due to: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
        } catch (OutOfMemoryError e12) {
            IBGDiagnostics.reportNonFatal(e12, "DB execution a sql failed: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
            logOperationFailedWarning("DB execution a sql failed due to: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public long insert(@NonNull String str, @Nullable String str2, @NonNull ContentValues contentValues) {
        try {
            SQLiteDatabase sQLiteDatabase = this.database;
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                logOperationFailedWarning("DB insertion failed");
                return -1;
            }
            SQLiteDatabase sQLiteDatabase2 = this.database;
            if (!(sQLiteDatabase2 instanceof SQLiteDatabase)) {
                return sQLiteDatabase2.insert(str, str2, contentValues);
            }
            return SQLiteInstrumentation.insert(sQLiteDatabase2, str, str2, contentValues);
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatal(e11, "DB insertion failed due to: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
            logOperationFailedWarning("DB insertion failed due to: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
            return -1;
        } catch (OutOfMemoryError e12) {
            IBGDiagnostics.reportNonFatal(e12, "DB insertion failed due to: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
            logOperationFailedWarning("DB insertion failed due to: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
            return -1;
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public long insertWithOnConflict(@NonNull String str, @Nullable String str2, @NonNull ContentValues contentValues) {
        try {
            SQLiteDatabase sQLiteDatabase = this.database;
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                logOperationFailedWarning("DB insertion with on conflict failed");
                return -1;
            }
            SQLiteDatabase sQLiteDatabase2 = this.database;
            if (!(sQLiteDatabase2 instanceof SQLiteDatabase)) {
                return sQLiteDatabase2.insertWithOnConflict(str, str2, contentValues, 4);
            }
            return SQLiteInstrumentation.insertWithOnConflict(sQLiteDatabase2, str, str2, contentValues, 4);
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatal(e11, "DB insertion with on conflict failed: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
            logOperationFailedWarning("DB insertion with on conflict failed due to: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
            return -1;
        } catch (OutOfMemoryError e12) {
            IBGDiagnostics.reportNonFatal(e12, "DB insertion with on conflict failed: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
            logOperationFailedWarning("DB insertion with on conflict failed due to: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
            return -1;
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public long insertWithOnConflictReplace(@NonNull String str, @Nullable String str2, @NonNull ContentValues contentValues) {
        try {
            SQLiteDatabase sQLiteDatabase = this.database;
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                logOperationFailedWarning("DB insertion with on conflict replace failed");
                return -1;
            }
            SQLiteDatabase sQLiteDatabase2 = this.database;
            if (!(sQLiteDatabase2 instanceof SQLiteDatabase)) {
                return sQLiteDatabase2.insertWithOnConflict(str, str2, contentValues, 5);
            }
            return SQLiteInstrumentation.insertWithOnConflict(sQLiteDatabase2, str, str2, contentValues, 5);
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatal(e11, "DB insertion with on conflict replace failed: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
            logOperationFailedWarning("DB insertion with on conflict replace failed due to: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
            return -1;
        } catch (OutOfMemoryError e12) {
            IBGDiagnostics.reportNonFatal(e12, "DB insertion with on conflict replace failed: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
            logOperationFailedWarning("DB insertion with on conflict replace failed due to: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
            return -1;
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    @Nullable
    public Cursor query(String str, @Nullable String[] strArr, @Nullable String str2, @Nullable String[] strArr2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        try {
            SQLiteDatabase sQLiteDatabase = this.database;
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                logOperationFailedWarning("DB query failed");
                return null;
            }
            SQLiteDatabase sQLiteDatabase2 = this.database;
            String str6 = str;
            String[] strArr3 = strArr;
            String str7 = str2;
            String[] strArr4 = strArr2;
            String str8 = str3;
            String str9 = str4;
            String str10 = str5;
            return !(sQLiteDatabase2 instanceof SQLiteDatabase) ? sQLiteDatabase2.query(str6, strArr3, str7, strArr4, str8, str9, str10) : SQLiteInstrumentation.query(sQLiteDatabase2, str6, strArr3, str7, strArr4, str8, str9, str10);
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatal(e11, "DB query failed: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
            logOperationFailedWarning("DB query failed due to: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
            return null;
        } catch (OutOfMemoryError e12) {
            IBGDiagnostics.reportNonFatal(e12, "DB query failed: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
            logOperationFailedWarning("DB query failed due to: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
            return null;
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public long queryNumEntries(@NonNull String str) {
        try {
            SQLiteDatabase sQLiteDatabase = this.database;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                return DatabaseUtils.queryNumEntries(this.database, str);
            }
            logOperationFailedWarning("DB query num entries failed");
            return -1;
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatal(e11, "DB query num entries failed: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
            logOperationFailedWarning("DB query num entries failed due to: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
            return -1;
        } catch (OutOfMemoryError e12) {
            IBGDiagnostics.reportNonFatal(e12, "DB query num entries failed: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
            logOperationFailedWarning("DB query num entries failed due to: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
            return -1;
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    @Nullable
    public Cursor rawQuery(@NonNull String str, @Nullable String[] strArr) {
        try {
            SQLiteDatabase sQLiteDatabase = this.database;
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                logOperationFailedWarning("DB raw query failed");
                return null;
            }
            SQLiteDatabase sQLiteDatabase2 = this.database;
            if (!(sQLiteDatabase2 instanceof SQLiteDatabase)) {
                return sQLiteDatabase2.rawQuery(str, strArr);
            }
            return SQLiteInstrumentation.rawQuery(sQLiteDatabase2, str, strArr);
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatal(e11, "DB raw query failed: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
            logOperationFailedWarning("DB raw query failed due to: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
            return null;
        } catch (OutOfMemoryError e12) {
            IBGDiagnostics.reportNonFatal(e12, "DB raw query failed: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
            logOperationFailedWarning("DB raw query failed due to: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
            return null;
        }
    }

    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    public void setTransactionSuccessful() {
        try {
            SQLiteDatabase sQLiteDatabase = this.database;
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                logOperationFailedWarning("DB transaction not successful");
            } else if (isDatabaseTransactionsEnabled()) {
                this.database.setTransactionSuccessful();
            }
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatal(e11, "DB transaction not successful due to: " + e11.getMessage());
            logOperationFailedWarning("DB transaction not successful due to: " + e11.getMessage());
        } catch (OutOfMemoryError e12) {
            IBGDiagnostics.reportNonFatal(e12, "DB transaction not successful due to: " + e12.getMessage());
            logOperationFailedWarning("DB transaction not successful due to: " + e12.getMessage());
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public int update(@NonNull String str, @NonNull ContentValues contentValues, @Nullable String str2, @Nullable String[] strArr) {
        try {
            SQLiteDatabase sQLiteDatabase = this.database;
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                logOperationFailedWarning("DB update failed");
                return -1;
            }
            SQLiteDatabase sQLiteDatabase2 = this.database;
            if (!(sQLiteDatabase2 instanceof SQLiteDatabase)) {
                return sQLiteDatabase2.update(str, contentValues, str2, strArr);
            }
            return SQLiteInstrumentation.update(sQLiteDatabase2, str, contentValues, str2, strArr);
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatal(e11, "DB update failed: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
            logOperationFailedWarning("DB update failed: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
            return -1;
        } catch (OutOfMemoryError e12) {
            IBGDiagnostics.reportNonFatal(e12, "DB update failed: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
            logOperationFailedWarning("DB update failed: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
            return -1;
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    @Nullable
    public Cursor query(String str, @Nullable String[] strArr, @Nullable String str2, @Nullable String[] strArr2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        try {
            SQLiteDatabase sQLiteDatabase = this.database;
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                logOperationFailedWarning("DB query failed");
                return null;
            }
            SQLiteDatabase sQLiteDatabase2 = this.database;
            String str7 = str;
            String[] strArr3 = strArr;
            String str8 = str2;
            String[] strArr4 = strArr2;
            String str9 = str3;
            String str10 = str4;
            String str11 = str5;
            String str12 = str6;
            return !(sQLiteDatabase2 instanceof SQLiteDatabase) ? sQLiteDatabase2.query(str7, strArr3, str8, strArr4, str9, str10, str11, str12) : SQLiteInstrumentation.query(sQLiteDatabase2, str7, strArr3, str8, strArr4, str9, str10, str11, str12);
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatal(e11, "DB query failed: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
            logOperationFailedWarning("DB query failed due to: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
            return null;
        } catch (OutOfMemoryError e12) {
            IBGDiagnostics.reportNonFatal(e12, "DB query failed: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
            logOperationFailedWarning("DB query failed due to: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
            return null;
        }
    }
}
