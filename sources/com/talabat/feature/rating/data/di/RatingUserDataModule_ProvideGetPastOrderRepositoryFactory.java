package com.talabat.feature.rating.data.di;

import com.talabat.feature.rating.data.remote.GetPastOrdersService;
import com.talabat.feature.rating.domain.repo.GetPastOrdersRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RatingUserDataModule_ProvideGetPastOrderRepositoryFactory implements Factory<GetPastOrdersRepository> {
    private final Provider<GetPastOrdersService> getPastOrdersServiceProvider;

    public RatingUserDataModule_ProvideGetPastOrderRepositoryFactory(Provider<GetPastOrdersService> provider) {
        this.getPastOrdersServiceProvider = provider;
    }

    public static RatingUserDataModule_ProvideGetPastOrderRepositoryFactory create(Provider<GetPastOrdersService> provider) {
        return new RatingUserDataModule_ProvideGetPastOrderRepositoryFactory(provider);
    }

    public static GetPastOrdersRepository provideGetPastOrderRepository(GetPastOrdersService getPastOrdersService) {
        return (GetPastOrdersRepository) Preconditions.checkNotNullFromProvides(RatingUserDataModule.INSTANCE.provideGetPastOrderRepository(getPastOrdersService));
    }

    public GetPastOrdersRepository get() {
        return provideGetPastOrderRepository(this.getPastOrdersServiceProvider.get());
    }
}
