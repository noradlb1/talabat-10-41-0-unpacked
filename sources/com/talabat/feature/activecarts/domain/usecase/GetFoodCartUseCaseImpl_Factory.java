package com.talabat.feature.activecarts.domain.usecase;

import com.talabat.feature.activecarts.domain.repository.ActiveCartRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetFoodCartUseCaseImpl_Factory implements Factory<GetFoodCartUseCaseImpl> {
    private final Provider<ActiveCartRepository> activeCartRepositoryProvider;

    public GetFoodCartUseCaseImpl_Factory(Provider<ActiveCartRepository> provider) {
        this.activeCartRepositoryProvider = provider;
    }

    public static GetFoodCartUseCaseImpl_Factory create(Provider<ActiveCartRepository> provider) {
        return new GetFoodCartUseCaseImpl_Factory(provider);
    }

    public static GetFoodCartUseCaseImpl newInstance(ActiveCartRepository activeCartRepository) {
        return new GetFoodCartUseCaseImpl(activeCartRepository);
    }

    public GetFoodCartUseCaseImpl get() {
        return newInstance(this.activeCartRepositoryProvider.get());
    }
}
