package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;

class FrameworkSQLiteProgram implements SupportSQLiteProgram {
    private final SQLiteProgram mDelegate;

    public FrameworkSQLiteProgram(SQLiteProgram sQLiteProgram) {
        this.mDelegate = sQLiteProgram;
    }

    public void bindBlob(int i11, byte[] bArr) {
        this.mDelegate.bindBlob(i11, bArr);
    }

    public void bindDouble(int i11, double d11) {
        this.mDelegate.bindDouble(i11, d11);
    }

    public void bindLong(int i11, long j11) {
        this.mDelegate.bindLong(i11, j11);
    }

    public void bindNull(int i11) {
        this.mDelegate.bindNull(i11);
    }

    public void bindString(int i11, String str) {
        this.mDelegate.bindString(i11, str);
    }

    public void clearBindings() {
        this.mDelegate.clearBindings();
    }

    public void close() {
        this.mDelegate.close();
    }
}
