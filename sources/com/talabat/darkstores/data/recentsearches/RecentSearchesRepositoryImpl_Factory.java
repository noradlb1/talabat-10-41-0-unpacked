package com.talabat.darkstores.data.recentsearches;

import com.talabat.darkstores.data.recentsearches.local.RecentSearchesDao;
import com.talabat.darkstores.data.recentsearches.mapper.RecentSearchDatabaseToDomainModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.reactivex.Scheduler;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.IoScheduler"})
public final class RecentSearchesRepositoryImpl_Factory implements Factory<RecentSearchesRepositoryImpl> {
    private final Provider<Scheduler> ioSchedulerProvider;
    private final Provider<RecentSearchDatabaseToDomainModelMapper> mapToDomainModelProvider;
    private final Provider<RecentSearchesDao> recentSearchesDaoProvider;

    public RecentSearchesRepositoryImpl_Factory(Provider<RecentSearchesDao> provider, Provider<RecentSearchDatabaseToDomainModelMapper> provider2, Provider<Scheduler> provider3) {
        this.recentSearchesDaoProvider = provider;
        this.mapToDomainModelProvider = provider2;
        this.ioSchedulerProvider = provider3;
    }

    public static RecentSearchesRepositoryImpl_Factory create(Provider<RecentSearchesDao> provider, Provider<RecentSearchDatabaseToDomainModelMapper> provider2, Provider<Scheduler> provider3) {
        return new RecentSearchesRepositoryImpl_Factory(provider, provider2, provider3);
    }

    public static RecentSearchesRepositoryImpl newInstance(RecentSearchesDao recentSearchesDao, RecentSearchDatabaseToDomainModelMapper recentSearchDatabaseToDomainModelMapper, Scheduler scheduler) {
        return new RecentSearchesRepositoryImpl(recentSearchesDao, recentSearchDatabaseToDomainModelMapper, scheduler);
    }

    public RecentSearchesRepositoryImpl get() {
        return newInstance(this.recentSearchesDaoProvider.get(), this.mapToDomainModelProvider.get(), this.ioSchedulerProvider.get());
    }
}
