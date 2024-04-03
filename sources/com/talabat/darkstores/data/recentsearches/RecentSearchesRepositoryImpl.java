package com.talabat.darkstores.data.recentsearches;

import com.talabat.darkstores.data.recentsearches.local.RecentSearchesDao;
import com.talabat.darkstores.data.recentsearches.local.SearchQueryRecord;
import com.talabat.darkstores.data.recentsearches.mapper.RecentSearchDatabaseToDomainModelMapper;
import com.talabat.darkstores.di.qualifier.IoScheduler;
import com.talabat.darkstores.domain.model.RecentSearch;
import com.talabat.darkstores.domain.recentsearches.RecentSearchesRepository;
import ii.a;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J$\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/data/recentsearches/RecentSearchesRepositoryImpl;", "Lcom/talabat/darkstores/domain/recentsearches/RecentSearchesRepository;", "recentSearchesDao", "Lcom/talabat/darkstores/data/recentsearches/local/RecentSearchesDao;", "mapToDomainModel", "Lcom/talabat/darkstores/data/recentsearches/mapper/RecentSearchDatabaseToDomainModelMapper;", "ioScheduler", "Lio/reactivex/Scheduler;", "(Lcom/talabat/darkstores/data/recentsearches/local/RecentSearchesDao;Lcom/talabat/darkstores/data/recentsearches/mapper/RecentSearchDatabaseToDomainModelMapper;Lio/reactivex/Scheduler;)V", "addQueryToRecentSearches", "Lio/reactivex/Completable;", "query", "", "vendorId", "", "clearRecentSearches", "observeRecentSearches", "Lio/reactivex/Observable;", "", "Lcom/talabat/darkstores/domain/model/RecentSearch;", "limit", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RecentSearchesRepositoryImpl implements RecentSearchesRepository {
    @NotNull
    private final Scheduler ioScheduler;
    @NotNull
    private final RecentSearchDatabaseToDomainModelMapper mapToDomainModel;
    @NotNull
    private final RecentSearchesDao recentSearchesDao;

    @Inject
    public RecentSearchesRepositoryImpl(@NotNull RecentSearchesDao recentSearchesDao2, @NotNull RecentSearchDatabaseToDomainModelMapper recentSearchDatabaseToDomainModelMapper, @IoScheduler @NotNull Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(recentSearchesDao2, "recentSearchesDao");
        Intrinsics.checkNotNullParameter(recentSearchDatabaseToDomainModelMapper, "mapToDomainModel");
        Intrinsics.checkNotNullParameter(scheduler, "ioScheduler");
        this.recentSearchesDao = recentSearchesDao2;
        this.mapToDomainModel = recentSearchDatabaseToDomainModelMapper;
        this.ioScheduler = scheduler;
    }

    /* access modifiers changed from: private */
    /* renamed from: observeRecentSearches$lambda-0  reason: not valid java name */
    public static final List m9726observeRecentSearches$lambda0(RecentSearchesRepositoryImpl recentSearchesRepositoryImpl, List list) {
        Intrinsics.checkNotNullParameter(recentSearchesRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(list, "models");
        Iterable<SearchQueryRecord> iterable = list;
        RecentSearchDatabaseToDomainModelMapper recentSearchDatabaseToDomainModelMapper = recentSearchesRepositoryImpl.mapToDomainModel;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (SearchQueryRecord invoke : iterable) {
            arrayList.add(recentSearchDatabaseToDomainModelMapper.invoke(invoke));
        }
        return arrayList;
    }

    @NotNull
    public Completable addQueryToRecentSearches(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "query");
        Completable subscribeOn = RecentSearchesDao.DefaultImpls.addQueryToRecentSearches$default(this.recentSearchesDao, str, i11, 0, 4, (Object) null).subscribeOn(this.ioScheduler);
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "recentSearchesDao.addQue….subscribeOn(ioScheduler)");
        return subscribeOn;
    }

    @NotNull
    public Completable clearRecentSearches(int i11) {
        Completable subscribeOn = this.recentSearchesDao.clearRecentSearchesForVendor(i11).subscribeOn(this.ioScheduler);
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "recentSearchesDao.clearR….subscribeOn(ioScheduler)");
        return subscribeOn;
    }

    @NotNull
    public Observable<List<RecentSearch>> observeRecentSearches(int i11, int i12) {
        Observable<R> subscribeOn = this.recentSearchesDao.observeRecordsByVendorIdSortedByTimestamp(i11, i12).map(new a(this)).subscribeOn(this.ioScheduler);
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "recentSearchesDao.observ….subscribeOn(ioScheduler)");
        return subscribeOn;
    }
}
