package org.greenrobot.greendao.database;

import android.database.Cursor;
import android.database.SQLException;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import net.sqlcipher.database.SQLiteDatabase;

@Instrumented
public class EncryptedDatabase implements Database {
    private final SQLiteDatabase delegate;

    public EncryptedDatabase(SQLiteDatabase sQLiteDatabase) {
        this.delegate = sQLiteDatabase;
    }

    public void beginTransaction() {
        this.delegate.beginTransaction();
    }

    public void close() {
        this.delegate.close();
    }

    public DatabaseStatement compileStatement(String str) {
        return new EncryptedDatabaseStatement(this.delegate.compileStatement(str));
    }

    public void endTransaction() {
        this.delegate.endTransaction();
    }

    public void execSQL(String str) throws SQLException {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = this.delegate;
        if (!(sQLiteDatabase instanceof android.database.sqlite.SQLiteDatabase)) {
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
        return this.delegate.rawQuery(str, strArr);
    }

    public void setTransactionSuccessful() {
        this.delegate.setTransactionSuccessful();
    }

    public void execSQL(String str, Object[] objArr) throws SQLException {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = this.delegate;
        if (!(sQLiteDatabase instanceof android.database.sqlite.SQLiteDatabase)) {
            sQLiteDatabase.execSQL(str, objArr);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, str, objArr);
        }
    }
}
