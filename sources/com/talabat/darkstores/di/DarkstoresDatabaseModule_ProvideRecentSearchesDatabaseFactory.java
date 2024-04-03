package com.talabat.darkstores.di;

import android.content.Context;
import com.talabat.darkstores.data.recentsearches.local.RecentSearchesDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresDatabaseModule_ProvideRecentSearchesDatabaseFactory implements Factory<RecentSearchesDatabase> {
    private final Provider<Context> contextProvider;
    private final DarkstoresDatabaseModule module;

    public DarkstoresDatabaseModule_ProvideRecentSearchesDatabaseFactory(DarkstoresDatabaseModule darkstoresDatabaseModule, Provider<Context> provider) {
        this.module = darkstoresDatabaseModule;
        this.contextProvider = provider;
    }

    public static DarkstoresDatabaseModule_ProvideRecentSearchesDatabaseFactory create(DarkstoresDatabaseModule darkstoresDatabaseModule, Provider<Context> provider) {
        return new DarkstoresDatabaseModule_ProvideRecentSearchesDatabaseFactory(darkstoresDatabaseModule, provider);
    }

    public static RecentSearchesDatabase provideRecentSearchesDatabase(DarkstoresDatabaseModule darkstoresDatabaseModule, Context context) {
        return (RecentSearchesDatabase) Preconditions.checkNotNullFromProvides(darkstoresDatabaseModule.provideRecentSearchesDatabase(context));
    }

    public RecentSearchesDatabase get() {
        return provideRecentSearchesDatabase(this.module, this.contextProvider.get());
    }
}
