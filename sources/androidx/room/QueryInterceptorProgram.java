package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import java.util.ArrayList;
import java.util.List;

final class QueryInterceptorProgram implements SupportSQLiteProgram {
    private List<Object> mBindArgsCache = new ArrayList();

    private void saveArgsToCache(int i11, Object obj) {
        int i12 = i11 - 1;
        if (i12 >= this.mBindArgsCache.size()) {
            for (int size = this.mBindArgsCache.size(); size <= i12; size++) {
                this.mBindArgsCache.add((Object) null);
            }
        }
        this.mBindArgsCache.set(i12, obj);
    }

    public List<Object> a() {
        return this.mBindArgsCache;
    }

    public void bindBlob(int i11, byte[] bArr) {
        saveArgsToCache(i11, bArr);
    }

    public void bindDouble(int i11, double d11) {
        saveArgsToCache(i11, Double.valueOf(d11));
    }

    public void bindLong(int i11, long j11) {
        saveArgsToCache(i11, Long.valueOf(j11));
    }

    public void bindNull(int i11) {
        saveArgsToCache(i11, (Object) null);
    }

    public void bindString(int i11, String str) {
        saveArgsToCache(i11, str);
    }

    public void clearBindings() {
        this.mBindArgsCache.clear();
    }

    public void close() {
    }
}
