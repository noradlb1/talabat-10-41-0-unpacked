package com.talabat.darkstores.data.recentsearches.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.Iterator;
import java.util.List;
import ji.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Dao
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0016J \u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0017J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH'J\u0016\u0010\u000f\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011H'J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH'J$\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00110\u00142\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J$\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00110\u00142\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H'J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00112\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\u0018"}, d2 = {"Lcom/talabat/darkstores/data/recentsearches/local/RecentSearchesDao;", "", "addQueryToRecentSearches", "Lio/reactivex/Completable;", "query", "", "vendorId", "", "maxRecordsPerVendor", "addQueryToRecentSearchesTransaction", "", "clearRecentSearchesForVendor", "deleteRecord", "record", "Lcom/talabat/darkstores/data/recentsearches/local/SearchQueryRecord;", "deleteRecords", "records", "", "insertRecord", "observeRecordsByVendorIdSortedByTimestamp", "Lio/reactivex/Observable;", "limit", "observeRecordsByVendorIdSortedByTimestampInternal", "selectAllRecordsByVendorIdSortedByTimestamp", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RecentSearchesDao {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static Completable addQueryToRecentSearches(@NotNull RecentSearchesDao recentSearchesDao, @NotNull String str, int i11, int i12) {
            Intrinsics.checkNotNullParameter(str, "query");
            Completable fromRunnable = Completable.fromRunnable(new a(recentSearchesDao, str, i11, i12));
            Intrinsics.checkNotNullExpressionValue(fromRunnable, "fromRunnable {\n        a…axRecordsPerVendor)\n    }");
            return fromRunnable;
        }

        public static /* synthetic */ Completable addQueryToRecentSearches$default(RecentSearchesDao recentSearchesDao, String str, int i11, int i12, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 4) != 0) {
                    i12 = 100;
                }
                return recentSearchesDao.addQueryToRecentSearches(str, i11, i12);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addQueryToRecentSearches");
        }

        /* access modifiers changed from: private */
        /* renamed from: addQueryToRecentSearches$lambda-1  reason: not valid java name */
        public static void m9727addQueryToRecentSearches$lambda1(RecentSearchesDao recentSearchesDao, String str, int i11, int i12) {
            Intrinsics.checkNotNullParameter(recentSearchesDao, "this$0");
            Intrinsics.checkNotNullParameter(str, "$query");
            recentSearchesDao.addQueryToRecentSearchesTransaction(str, i11, i12);
        }

        @Transaction
        public static void addQueryToRecentSearchesTransaction(@NotNull RecentSearchesDao recentSearchesDao, @NotNull String str, int i11, int i12) {
            Object obj;
            Intrinsics.checkNotNullParameter(str, "query");
            if (i12 > 0) {
                List<SearchQueryRecord> selectAllRecordsByVendorIdSortedByTimestamp = recentSearchesDao.selectAllRecordsByVendorIdSortedByTimestamp(i11);
                int size = selectAllRecordsByVendorIdSortedByTimestamp.size() - i12;
                if (size > 0) {
                    int size2 = selectAllRecordsByVendorIdSortedByTimestamp.size() - size;
                    recentSearchesDao.deleteRecords(selectAllRecordsByVendorIdSortedByTimestamp.subList(size2, selectAllRecordsByVendorIdSortedByTimestamp.size()));
                    selectAllRecordsByVendorIdSortedByTimestamp = selectAllRecordsByVendorIdSortedByTimestamp.subList(0, size2);
                }
                Iterator it = selectAllRecordsByVendorIdSortedByTimestamp.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (StringsKt__StringsJVMKt.equals(((SearchQueryRecord) obj).getQuery(), str, true)) {
                        break;
                    }
                }
                SearchQueryRecord searchQueryRecord = (SearchQueryRecord) obj;
                if (searchQueryRecord != null) {
                    recentSearchesDao.deleteRecord(searchQueryRecord);
                } else if (selectAllRecordsByVendorIdSortedByTimestamp.size() == i12) {
                    recentSearchesDao.deleteRecord((SearchQueryRecord) CollectionsKt___CollectionsKt.last(selectAllRecordsByVendorIdSortedByTimestamp));
                }
                recentSearchesDao.insertRecord(new SearchQueryRecord(str, i11, System.currentTimeMillis()));
                return;
            }
            throw new IllegalArgumentException("Maximum records per vendor should be a positive value");
        }

        @NotNull
        public static Observable<List<SearchQueryRecord>> observeRecordsByVendorIdSortedByTimestamp(@NotNull RecentSearchesDao recentSearchesDao, int i11, int i12) {
            return recentSearchesDao.observeRecordsByVendorIdSortedByTimestampInternal(i11, Math.max(0, i12));
        }
    }

    @NotNull
    Completable addQueryToRecentSearches(@NotNull String str, int i11, int i12);

    @Transaction
    void addQueryToRecentSearchesTransaction(@NotNull String str, int i11, int i12);

    @NotNull
    @Query("DELETE FROM SearchQueryRecord WHERE vendor_id = :vendorId")
    Completable clearRecentSearchesForVendor(int i11);

    @Delete
    void deleteRecord(@NotNull SearchQueryRecord searchQueryRecord);

    @Delete
    void deleteRecords(@NotNull List<SearchQueryRecord> list);

    @Insert
    void insertRecord(@NotNull SearchQueryRecord searchQueryRecord);

    @NotNull
    Observable<List<SearchQueryRecord>> observeRecordsByVendorIdSortedByTimestamp(int i11, int i12);

    @NotNull
    @Query("SELECT * FROM SearchQueryRecord WHERE vendor_id = :vendorId ORDER BY timestamp DESC LIMIT :limit")
    Observable<List<SearchQueryRecord>> observeRecordsByVendorIdSortedByTimestampInternal(int i11, int i12);

    @NotNull
    @Query("SELECT * FROM SearchQueryRecord WHERE vendor_id = :vendorId ORDER BY timestamp DESC")
    List<SearchQueryRecord> selectAllRecordsByVendorIdSortedByTimestamp(int i11);
}
