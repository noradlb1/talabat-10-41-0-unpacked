package com.talabat.feature.fees.domain.usecase;

import com.talabat.feature.fees.domain.repository.IPricingRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetFeesUseCase_Factory implements Factory<GetFeesUseCase> {
    private final Provider<IPricingRepository> pricingRepositoryProvider;

    public GetFeesUseCase_Factory(Provider<IPricingRepository> provider) {
        this.pricingRepositoryProvider = provider;
    }

    public static GetFeesUseCase_Factory create(Provider<IPricingRepository> provider) {
        return new GetFeesUseCase_Factory(provider);
    }

    public static GetFeesUseCase newInstance(IPricingRepository iPricingRepository) {
        return new GetFeesUseCase(iPricingRepository);
    }

    public GetFeesUseCase get() {
        return newInstance(this.pricingRepositoryProvider.get());
    }
}
