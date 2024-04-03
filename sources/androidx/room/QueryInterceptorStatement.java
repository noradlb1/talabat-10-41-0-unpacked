package androidx.room;

import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

final class QueryInterceptorStatement implements SupportSQLiteStatement {
    private final List<Object> mBindArgsCache = new ArrayList();
    private final SupportSQLiteStatement mDelegate;
    private final RoomDatabase.QueryCallback mQueryCallback;
    private final Executor mQueryCallbackExecutor;
    private final String mSqlStatement;

    public QueryInterceptorStatement(@NonNull SupportSQLiteStatement supportSQLiteStatement, @NonNull RoomDatabase.QueryCallback queryCallback, String str, @NonNull Executor executor) {
        this.mDelegate = supportSQLiteStatement;
        this.mQueryCallback = queryCallback;
        this.mSqlStatement = str;
        this.mQueryCallbackExecutor = executor;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$execute$0() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$executeInsert$2() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$executeUpdateDelete$1() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$simpleQueryForLong$3() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$simpleQueryForString$4() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    private void saveArgsToCache(int i11, Object obj) {
        int i12 = i11 - 1;
        if (i12 >= this.mBindArgsCache.size()) {
            for (int size = this.mBindArgsCache.size(); size <= i12; size++) {
                this.mBindArgsCache.add((Object) null);
            }
        }
        this.mBindArgsCache.set(i12, obj);
    }

    public void bindBlob(int i11, byte[] bArr) {
        saveArgsToCache(i11, bArr);
        this.mDelegate.bindBlob(i11, bArr);
    }

    public void bindDouble(int i11, double d11) {
        saveArgsToCache(i11, Double.valueOf(d11));
        this.mDelegate.bindDouble(i11, d11);
    }

    public void bindLong(int i11, long j11) {
        saveArgsToCache(i11, Long.valueOf(j11));
        this.mDelegate.bindLong(i11, j11);
    }

    public void bindNull(int i11) {
        saveArgsToCache(i11, this.mBindArgsCache.toArray());
        this.mDelegate.bindNull(i11);
    }

    public void bindString(int i11, String str) {
        saveArgsToCache(i11, str);
        this.mDelegate.bindString(i11, str);
    }

    public void clearBindings() {
        this.mBindArgsCache.clear();
        this.mDelegate.clearBindings();
    }

    public void close() throws IOException {
        this.mDelegate.close();
    }

    public void execute() {
        this.mQueryCallbackExecutor.execute(new e0(this));
        this.mDelegate.execute();
    }

    public long executeInsert() {
        this.mQueryCallbackExecutor.execute(new f0(this));
        return this.mDelegate.executeInsert();
    }

    public int executeUpdateDelete() {
        this.mQueryCallbackExecutor.execute(new d0(this));
        return this.mDelegate.executeUpdateDelete();
    }

    public long simpleQueryForLong() {
        this.mQueryCallbackExecutor.execute(new h0(this));
        return this.mDelegate.simpleQueryForLong();
    }

    public String simpleQueryForString() {
        this.mQueryCallbackExecutor.execute(new g0(this));
        return this.mDelegate.simpleQueryForString();
    }
}
