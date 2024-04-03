package androidx.sqlite.db.framework;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Build;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

class FrameworkSQLiteDatabase implements SupportSQLiteDatabase {
    private static final String[] CONFLICT_VALUES = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private final SQLiteDatabase mDelegate;

    public FrameworkSQLiteDatabase(SQLiteDatabase sQLiteDatabase) {
        this.mDelegate = sQLiteDatabase;
    }

    public boolean a(SQLiteDatabase sQLiteDatabase) {
        return this.mDelegate == sQLiteDatabase;
    }

    public void beginTransaction() {
        this.mDelegate.beginTransaction();
    }

    public void beginTransactionNonExclusive() {
        this.mDelegate.beginTransactionNonExclusive();
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        this.mDelegate.beginTransactionWithListener(sQLiteTransactionListener);
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        this.mDelegate.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    public void close() throws IOException {
        this.mDelegate.close();
    }

    public SupportSQLiteStatement compileStatement(String str) {
        return new FrameworkSQLiteStatement(this.mDelegate.compileStatement(str));
    }

    public int delete(String str, String str2, Object[] objArr) {
        String str3;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DELETE FROM ");
        sb2.append(str);
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
        } else {
            str3 = " WHERE " + str2;
        }
        sb2.append(str3);
        SupportSQLiteStatement compileStatement = compileStatement(sb2.toString());
        SimpleSQLiteQuery.bind(compileStatement, objArr);
        return compileStatement.executeUpdateDelete();
    }

    @RequiresApi(api = 16)
    public void disableWriteAheadLogging() {
        SupportSQLiteCompat.Api16Impl.disableWriteAheadLogging(this.mDelegate);
    }

    public boolean enableWriteAheadLogging() {
        return this.mDelegate.enableWriteAheadLogging();
    }

    public void endTransaction() {
        this.mDelegate.endTransaction();
    }

    public void execPerConnectionSQL(@NonNull String str, @Nullable Object[] objArr) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 30) {
            this.mDelegate.execPerConnectionSQL(str, objArr);
            return;
        }
        throw new UnsupportedOperationException("execPerConnectionSQL is not supported on a SDK version lower than 30, current version is: " + i11);
    }

    public void execSQL(String str) throws SQLException {
        this.mDelegate.execSQL(str);
    }

    public List<Pair<String, String>> getAttachedDbs() {
        return this.mDelegate.getAttachedDbs();
    }

    public long getMaximumSize() {
        return this.mDelegate.getMaximumSize();
    }

    public long getPageSize() {
        return this.mDelegate.getPageSize();
    }

    public String getPath() {
        return this.mDelegate.getPath();
    }

    public int getVersion() {
        return this.mDelegate.getVersion();
    }

    public boolean inTransaction() {
        return this.mDelegate.inTransaction();
    }

    public long insert(String str, int i11, ContentValues contentValues) throws SQLException {
        return this.mDelegate.insertWithOnConflict(str, (String) null, contentValues, i11);
    }

    public boolean isDatabaseIntegrityOk() {
        return this.mDelegate.isDatabaseIntegrityOk();
    }

    public boolean isDbLockedByCurrentThread() {
        return this.mDelegate.isDbLockedByCurrentThread();
    }

    public boolean isExecPerConnectionSQLSupported() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public boolean isOpen() {
        return this.mDelegate.isOpen();
    }

    public boolean isReadOnly() {
        return this.mDelegate.isReadOnly();
    }

    @RequiresApi(api = 16)
    public boolean isWriteAheadLoggingEnabled() {
        return SupportSQLiteCompat.Api16Impl.isWriteAheadLoggingEnabled(this.mDelegate);
    }

    public boolean needUpgrade(int i11) {
        return this.mDelegate.needUpgrade(i11);
    }

    public Cursor query(String str) {
        return query((SupportSQLiteQuery) new SimpleSQLiteQuery(str));
    }

    @RequiresApi(api = 16)
    public void setForeignKeyConstraintsEnabled(boolean z11) {
        SupportSQLiteCompat.Api16Impl.setForeignKeyConstraintsEnabled(this.mDelegate, z11);
    }

    public void setLocale(Locale locale) {
        this.mDelegate.setLocale(locale);
    }

    public void setMaxSqlCacheSize(int i11) {
        this.mDelegate.setMaxSqlCacheSize(i11);
    }

    public long setMaximumSize(long j11) {
        return this.mDelegate.setMaximumSize(j11);
    }

    public void setPageSize(long j11) {
        this.mDelegate.setPageSize(j11);
    }

    public void setTransactionSuccessful() {
        this.mDelegate.setTransactionSuccessful();
    }

    public void setVersion(int i11) {
        this.mDelegate.setVersion(i11);
    }

    public int update(String str, int i11, ContentValues contentValues, String str2, Object[] objArr) {
        int i12;
        String str3;
        if (contentValues == null || contentValues.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        StringBuilder sb2 = new StringBuilder(120);
        sb2.append("UPDATE ");
        sb2.append(CONFLICT_VALUES[i11]);
        sb2.append(str);
        sb2.append(" SET ");
        int size = contentValues.size();
        if (objArr == null) {
            i12 = size;
        } else {
            i12 = objArr.length + size;
        }
        Object[] objArr2 = new Object[i12];
        int i13 = 0;
        for (String next : contentValues.keySet()) {
            if (i13 > 0) {
                str3 = ",";
            } else {
                str3 = "";
            }
            sb2.append(str3);
            sb2.append(next);
            objArr2[i13] = contentValues.get(next);
            sb2.append("=?");
            i13++;
        }
        if (objArr != null) {
            for (int i14 = size; i14 < i12; i14++) {
                objArr2[i14] = objArr[i14 - size];
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            sb2.append(" WHERE ");
            sb2.append(str2);
        }
        SupportSQLiteStatement compileStatement = compileStatement(sb2.toString());
        SimpleSQLiteQuery.bind(compileStatement, objArr2);
        return compileStatement.executeUpdateDelete();
    }

    public boolean yieldIfContendedSafely() {
        return this.mDelegate.yieldIfContendedSafely();
    }

    public void execSQL(String str, Object[] objArr) throws SQLException {
        this.mDelegate.execSQL(str, objArr);
    }

    public Cursor query(String str, Object[] objArr) {
        return query((SupportSQLiteQuery) new SimpleSQLiteQuery(str, objArr));
    }

    public boolean yieldIfContendedSafely(long j11) {
        return this.mDelegate.yieldIfContendedSafely(j11);
    }

    public Cursor query(final SupportSQLiteQuery supportSQLiteQuery) {
        return this.mDelegate.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() {
            public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                supportSQLiteQuery.bindTo(new FrameworkSQLiteProgram(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, supportSQLiteQuery.getSql(), EMPTY_STRING_ARRAY, (String) null);
    }

    @RequiresApi(api = 16)
    public Cursor query(final SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        return SupportSQLiteCompat.Api16Impl.rawQueryWithFactory(this.mDelegate, supportSQLiteQuery.getSql(), EMPTY_STRING_ARRAY, (String) null, cancellationSignal, new SQLiteDatabase.CursorFactory() {
            public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                supportSQLiteQuery.bindTo(new FrameworkSQLiteProgram(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        });
    }
}
