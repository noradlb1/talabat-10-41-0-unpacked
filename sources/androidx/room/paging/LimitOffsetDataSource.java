package androidx.room.paging;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.paging.PositionalDataSource;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class LimitOffsetDataSource<T> extends PositionalDataSource<T> {
    private final String mCountQuery;
    private final RoomDatabase mDb;
    private final boolean mInTransaction;
    private final String mLimitOffsetQuery;
    private final InvalidationTracker.Observer mObserver;
    private final AtomicBoolean mRegisteredObserver;
    private final RoomSQLiteQuery mSourceQuery;

    /* renamed from: androidx.room.paging.LimitOffsetDataSource$1  reason: invalid class name */
    class AnonymousClass1 extends InvalidationTracker.Observer {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LimitOffsetDataSource f37535b;

        public void onInvalidated(@NonNull Set<String> set) {
            this.f37535b.invalidate();
        }
    }

    private RoomSQLiteQuery getSQLiteQuery(int i11, int i12) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(this.mLimitOffsetQuery, this.mSourceQuery.getArgCount() + 2);
        acquire.copyArgumentsFrom(this.mSourceQuery);
        acquire.bindLong(acquire.getArgCount() - 1, (long) i12);
        acquire.bindLong(acquire.getArgCount(), (long) i11);
        return acquire;
    }

    private void registerObserverIfNecessary() {
        if (this.mRegisteredObserver.compareAndSet(false, true)) {
            this.mDb.getInvalidationTracker().addWeakObserver(this.mObserver);
        }
    }

    @NonNull
    public abstract List<T> b(@NonNull Cursor cursor);

    public int countItems() {
        registerObserverIfNecessary();
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(this.mCountQuery, this.mSourceQuery.getArgCount());
        acquire.copyArgumentsFrom(this.mSourceQuery);
        Cursor query = this.mDb.query(acquire);
        try {
            if (query.moveToFirst()) {
                return query.getInt(0);
            }
            query.close();
            acquire.release();
            return 0;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public boolean isInvalid() {
        registerObserverIfNecessary();
        this.mDb.getInvalidationTracker().refreshVersionsSync();
        return super.isInvalid();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadInitial(@androidx.annotation.NonNull androidx.paging.PositionalDataSource.LoadInitialParams r7, @androidx.annotation.NonNull androidx.paging.PositionalDataSource.LoadInitialCallback<T> r8) {
        /*
            r6 = this;
            r6.registerObserverIfNecessary()
            java.util.List r0 = java.util.Collections.emptyList()
            androidx.room.RoomDatabase r1 = r6.mDb
            r1.beginTransaction()
            r1 = 0
            int r2 = r6.countItems()     // Catch:{ all -> 0x004a }
            if (r2 == 0) goto L_0x0035
            int r0 = androidx.paging.PositionalDataSource.computeInitialLoadPosition(r7, r2)     // Catch:{ all -> 0x004a }
            int r7 = androidx.paging.PositionalDataSource.computeInitialLoadSize(r7, r0, r2)     // Catch:{ all -> 0x004a }
            androidx.room.RoomSQLiteQuery r7 = r6.getSQLiteQuery(r0, r7)     // Catch:{ all -> 0x004a }
            androidx.room.RoomDatabase r3 = r6.mDb     // Catch:{ all -> 0x0033 }
            android.database.Cursor r1 = r3.query(r7)     // Catch:{ all -> 0x0033 }
            java.util.List r3 = r6.b(r1)     // Catch:{ all -> 0x0033 }
            androidx.room.RoomDatabase r4 = r6.mDb     // Catch:{ all -> 0x0033 }
            r4.setTransactionSuccessful()     // Catch:{ all -> 0x0033 }
            r5 = r3
            r3 = r7
            r7 = r0
            r0 = r5
            goto L_0x0037
        L_0x0033:
            r8 = move-exception
            goto L_0x004c
        L_0x0035:
            r7 = 0
            r3 = r1
        L_0x0037:
            if (r1 == 0) goto L_0x003c
            r1.close()
        L_0x003c:
            androidx.room.RoomDatabase r1 = r6.mDb
            r1.endTransaction()
            if (r3 == 0) goto L_0x0046
            r3.release()
        L_0x0046:
            r8.onResult(r0, r7, r2)
            return
        L_0x004a:
            r8 = move-exception
            r7 = r1
        L_0x004c:
            if (r1 == 0) goto L_0x0051
            r1.close()
        L_0x0051:
            androidx.room.RoomDatabase r0 = r6.mDb
            r0.endTransaction()
            if (r7 == 0) goto L_0x005b
            r7.release()
        L_0x005b:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.paging.LimitOffsetDataSource.loadInitial(androidx.paging.PositionalDataSource$LoadInitialParams, androidx.paging.PositionalDataSource$LoadInitialCallback):void");
    }

    public void loadRange(@NonNull PositionalDataSource.LoadRangeParams loadRangeParams, @NonNull PositionalDataSource.LoadRangeCallback<T> loadRangeCallback) {
        loadRangeCallback.onResult(loadRange(loadRangeParams.startPosition, loadRangeParams.loadSize));
    }

    @NonNull
    public List<T> loadRange(int i11, int i12) {
        RoomSQLiteQuery sQLiteQuery = getSQLiteQuery(i11, i12);
        if (this.mInTransaction) {
            this.mDb.beginTransaction();
            Cursor cursor = null;
            try {
                cursor = this.mDb.query(sQLiteQuery);
                List<T> b11 = b(cursor);
                this.mDb.setTransactionSuccessful();
                return b11;
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
                this.mDb.endTransaction();
                sQLiteQuery.release();
            }
        } else {
            Cursor query = this.mDb.query(sQLiteQuery);
            try {
                return b(query);
            } finally {
                query.close();
                sQLiteQuery.release();
            }
        }
    }
}
