package com.talabat.darkstores.feature.cart;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import com.talabat.feature.darkstorescartlist.domain.usecase.IsMultiBasketEnabledUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PostCartUseCase_Factory implements Factory<PostCartUseCase> {
    private final Provider<DarkstoresCartRepository> darkstoresCartRepositoryProvider;
    private final Provider<DarkstoresRepo> darkstoresRepoProvider;
    private final Provider<IsMultiBasketEnabledUseCase> isMultiBasketEnabledProvider;

    public PostCartUseCase_Factory(Provider<DarkstoresRepo> provider, Provider<IsMultiBasketEnabledUseCase> provider2, Provider<DarkstoresCartRepository> provider3) {
        this.darkstoresRepoProvider = provider;
        this.isMultiBasketEnabledProvider = provider2;
        this.darkstoresCartRepositoryProvider = provider3;
    }

    public static PostCartUseCase_Factory create(Provider<DarkstoresRepo> provider, Provider<IsMultiBasketEnabledUseCase> provider2, Provider<DarkstoresCartRepository> provider3) {
        return new PostCartUseCase_Factory(provider, provider2, provider3);
    }

    public static PostCartUseCase newInstance(DarkstoresRepo darkstoresRepo, IsMultiBasketEnabledUseCase isMultiBasketEnabledUseCase, DarkstoresCartRepository darkstoresCartRepository) {
        return new PostCartUseCase(darkstoresRepo, isMultiBasketEnabledUseCase, darkstoresCartRepository);
    }

    public PostCartUseCase get() {
        return newInstance(this.darkstoresRepoProvider.get(), this.isMultiBasketEnabledProvider.get(), this.darkstoresCartRepositoryProvider.get());
    }
}
