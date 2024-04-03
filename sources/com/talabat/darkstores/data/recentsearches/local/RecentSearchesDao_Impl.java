package com.talabat.darkstores.data.recentsearches.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.talabat.darkstores.data.recentsearches.local.RecentSearchesDao;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public final class RecentSearchesDao_Impl implements RecentSearchesDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<SearchQueryRecord> __deletionAdapterOfSearchQueryRecord;
    private final EntityInsertionAdapter<SearchQueryRecord> __insertionAdapterOfSearchQueryRecord;
    /* access modifiers changed from: private */
    public final SharedSQLiteStatement __preparedStmtOfClearRecentSearchesForVendor;

    public RecentSearchesDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfSearchQueryRecord = new EntityInsertionAdapter<SearchQueryRecord>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR ABORT INTO `SearchQueryRecord` (`query`,`vendor_id`,`timestamp`,`id`) VALUES (?,?,?,nullif(?, 0))";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, SearchQueryRecord searchQueryRecord) {
                if (searchQueryRecord.getQuery() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, searchQueryRecord.getQuery());
                }
                supportSQLiteStatement.bindLong(2, (long) searchQueryRecord.getVendorId());
                supportSQLiteStatement.bindLong(3, searchQueryRecord.getTimestamp());
                supportSQLiteStatement.bindLong(4, searchQueryRecord.getId());
            }
        };
        this.__deletionAdapterOfSearchQueryRecord = new EntityDeletionOrUpdateAdapter<SearchQueryRecord>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `SearchQueryRecord` WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, SearchQueryRecord searchQueryRecord) {
                supportSQLiteStatement.bindLong(1, searchQueryRecord.getId());
            }
        };
        this.__preparedStmtOfClearRecentSearchesForVendor = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM SearchQueryRecord WHERE vendor_id = ?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public Completable addQueryToRecentSearches(String str, int i11, int i12) {
        return RecentSearchesDao.DefaultImpls.addQueryToRecentSearches(this, str, i11, i12);
    }

    public void addQueryToRecentSearchesTransaction(String str, int i11, int i12) {
        this.__db.beginTransaction();
        try {
            RecentSearchesDao.DefaultImpls.addQueryToRecentSearchesTransaction(this, str, i11, i12);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public Completable clearRecentSearchesForVendor(final int i11) {
        return Completable.fromCallable(new Callable<Void>() {
            /* JADX INFO: finally extract failed */
            public Void call() throws Exception {
                SupportSQLiteStatement acquire = RecentSearchesDao_Impl.this.__preparedStmtOfClearRecentSearchesForVendor.acquire();
                acquire.bindLong(1, (long) i11);
                RecentSearchesDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    RecentSearchesDao_Impl.this.__db.setTransactionSuccessful();
                    RecentSearchesDao_Impl.this.__db.endTransaction();
                    RecentSearchesDao_Impl.this.__preparedStmtOfClearRecentSearchesForVendor.release(acquire);
                    return null;
                } catch (Throwable th2) {
                    RecentSearchesDao_Impl.this.__db.endTransaction();
                    RecentSearchesDao_Impl.this.__preparedStmtOfClearRecentSearchesForVendor.release(acquire);
                    throw th2;
                }
            }
        });
    }

    public void deleteRecord(SearchQueryRecord searchQueryRecord) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfSearchQueryRecord.handle(searchQueryRecord);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void deleteRecords(List<SearchQueryRecord> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfSearchQueryRecord.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void insertRecord(SearchQueryRecord searchQueryRecord) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfSearchQueryRecord.insert(searchQueryRecord);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public Observable<List<SearchQueryRecord>> observeRecordsByVendorIdSortedByTimestamp(int i11, int i12) {
        return RecentSearchesDao.DefaultImpls.observeRecordsByVendorIdSortedByTimestamp(this, i11, i12);
    }

    public Observable<List<SearchQueryRecord>> observeRecordsByVendorIdSortedByTimestampInternal(int i11, int i12) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM SearchQueryRecord WHERE vendor_id = ? ORDER BY timestamp DESC LIMIT ?", 2);
        acquire.bindLong(1, (long) i11);
        acquire.bindLong(2, (long) i12);
        return RxRoom.createObservable(this.__db, false, new String[]{"SearchQueryRecord"}, new Callable<List<SearchQueryRecord>>() {
            public void finalize() {
                acquire.release();
            }

            public List<SearchQueryRecord> call() throws Exception {
                String str;
                Cursor query = DBUtil.query(RecentSearchesDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "query");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "vendor_id");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "id");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        if (query.isNull(columnIndexOrThrow)) {
                            str = null;
                        } else {
                            str = query.getString(columnIndexOrThrow);
                        }
                        SearchQueryRecord searchQueryRecord = new SearchQueryRecord(str, query.getInt(columnIndexOrThrow2), query.getLong(columnIndexOrThrow3));
                        searchQueryRecord.setId(query.getLong(columnIndexOrThrow4));
                        arrayList.add(searchQueryRecord);
                    }
                    return arrayList;
                } finally {
                    query.close();
                }
            }
        });
    }

    public List<SearchQueryRecord> selectAllRecordsByVendorIdSortedByTimestamp(int i11) {
        String str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM SearchQueryRecord WHERE vendor_id = ? ORDER BY timestamp DESC", 1);
        acquire.bindLong(1, (long) i11);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "query");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "vendor_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "id");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow)) {
                    str = null;
                } else {
                    str = query.getString(columnIndexOrThrow);
                }
                SearchQueryRecord searchQueryRecord = new SearchQueryRecord(str, query.getInt(columnIndexOrThrow2), query.getLong(columnIndexOrThrow3));
                searchQueryRecord.setId(query.getLong(columnIndexOrThrow4));
                arrayList.add(searchQueryRecord);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
