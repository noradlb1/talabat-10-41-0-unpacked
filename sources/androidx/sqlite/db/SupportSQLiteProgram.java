package androidx.sqlite.db;

import java.io.Closeable;

public interface SupportSQLiteProgram extends Closeable {
    void bindBlob(int i11, byte[] bArr);

    void bindDouble(int i11, double d11);

    void bindLong(int i11, long j11);

    void bindNull(int i11);

    void bindString(int i11, String str);

    void clearBindings();
}
