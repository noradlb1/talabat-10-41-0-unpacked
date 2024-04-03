package org.greenrobot.greendao.database;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public class StandardDatabase implements Database {
    private final SQLiteDatabase delegate;

    public StandardDatabase(SQLiteDatabase sQLiteDatabase) {
        this.delegate = sQLiteDatabase;
    }

    public void beginTransaction() {
        this.delegate.beginTransaction();
    }

    public void close() {
        this.delegate.close();
    }

    public DatabaseStatement compileStatement(String str) {
        return new StandardDatabaseStatement(this.delegate.compileStatement(str));
    }

    public void endTransaction() {
        this.delegate.endTransaction();
    }

    public void execSQL(String str) throws SQLException {
        SQLiteDatabase sQLiteDatabase = this.delegate;
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL(str);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, str);
        }
    }

    public Object getRawDatabase() {
        return this.delegate;
    }

    public SQLiteDatabase getSQLiteDatabase() {
        return this.delegate;
    }

    public boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase sQLiteDatabase = this.delegate;
        return !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.rawQuery(str, strArr) : SQLiteInstrumentation.rawQuery(sQLiteDatabase, str, strArr);
    }

    public void setTransactionSuccessful() {
        this.delegate.setTransactionSuccessful();
    }

    public void execSQL(String str, Object[] objArr) throws SQLException {
        SQLiteDatabase sQLiteDatabase = this.delegate;
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL(str, objArr);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, str, objArr);
        }
    }
}
