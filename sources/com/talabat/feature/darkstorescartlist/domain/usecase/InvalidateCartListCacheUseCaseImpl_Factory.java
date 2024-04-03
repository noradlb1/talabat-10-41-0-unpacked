package com.talabat.feature.darkstorescartlist.domain.usecase;

import com.talabat.feature.darkstorescartlist.domain.repository.DarkstoresCartListRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class InvalidateCartListCacheUseCaseImpl_Factory implements Factory<InvalidateCartListCacheUseCaseImpl> {
    private final Provider<DarkstoresCartListRepository> darkstoresCartListRepositoryProvider;

    public InvalidateCartListCacheUseCaseImpl_Factory(Provider<DarkstoresCartListRepository> provider) {
        this.darkstoresCartListRepositoryProvider = provider;
    }

    public static InvalidateCartListCacheUseCaseImpl_Factory create(Provider<DarkstoresCartListRepository> provider) {
        return new InvalidateCartListCacheUseCaseImpl_Factory(provider);
    }

    public static InvalidateCartListCacheUseCaseImpl newInstance(DarkstoresCartListRepository darkstoresCartListRepository) {
        return new InvalidateCartListCacheUseCaseImpl(darkstoresCartListRepository);
    }

    public InvalidateCartListCacheUseCaseImpl get() {
        return newInstance(this.darkstoresCartListRepositoryProvider.get());
    }
}
