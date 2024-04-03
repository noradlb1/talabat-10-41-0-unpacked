package com.talabat.darkstores.di;

import com.talabat.darkstores.data.recentsearches.local.RecentSearchesDao;
import com.talabat.darkstores.data.recentsearches.local.RecentSearchesDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresDatabaseModule_ProvideRecentSearchesDaoFactory implements Factory<RecentSearchesDao> {
    private final Provider<RecentSearchesDatabase> databaseProvider;
    private final DarkstoresDatabaseModule module;

    public DarkstoresDatabaseModule_ProvideRecentSearchesDaoFactory(DarkstoresDatabaseModule darkstoresDatabaseModule, Provider<RecentSearchesDatabase> provider) {
        this.module = darkstoresDatabaseModule;
        this.databaseProvider = provider;
    }

    public static DarkstoresDatabaseModule_ProvideRecentSearchesDaoFactory create(DarkstoresDatabaseModule darkstoresDatabaseModule, Provider<RecentSearchesDatabase> provider) {
        return new DarkstoresDatabaseModule_ProvideRecentSearchesDaoFactory(darkstoresDatabaseModule, provider);
    }

    public static RecentSearchesDao provideRecentSearchesDao(DarkstoresDatabaseModule darkstoresDatabaseModule, RecentSearchesDatabase recentSearchesDatabase) {
        return (RecentSearchesDao) Preconditions.checkNotNullFromProvides(darkstoresDatabaseModule.provideRecentSearchesDao(recentSearchesDatabase));
    }

    public RecentSearchesDao get() {
        return provideRecentSearchesDao(this.module, this.databaseProvider.get());
    }
}
