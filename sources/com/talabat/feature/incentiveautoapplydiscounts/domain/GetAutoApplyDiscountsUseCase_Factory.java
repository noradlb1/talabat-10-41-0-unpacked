package com.talabat.feature.incentiveautoapplydiscounts.domain;

import com.talabat.feature.incentiveautoapplydiscounts.domain.repository.IncentiveAutoApplyDiscountsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetAutoApplyDiscountsUseCase_Factory implements Factory<GetAutoApplyDiscountsUseCase> {
    private final Provider<IncentiveAutoApplyDiscountsRepository> incentiveBookingRepositoryProvider;

    public GetAutoApplyDiscountsUseCase_Factory(Provider<IncentiveAutoApplyDiscountsRepository> provider) {
        this.incentiveBookingRepositoryProvider = provider;
    }

    public static GetAutoApplyDiscountsUseCase_Factory create(Provider<IncentiveAutoApplyDiscountsRepository> provider) {
        return new GetAutoApplyDiscountsUseCase_Factory(provider);
    }

    public static GetAutoApplyDiscountsUseCase newInstance(IncentiveAutoApplyDiscountsRepository incentiveAutoApplyDiscountsRepository) {
        return new GetAutoApplyDiscountsUseCase(incentiveAutoApplyDiscountsRepository);
    }

    public GetAutoApplyDiscountsUseCase get() {
        return newInstance(this.incentiveBookingRepositoryProvider.get());
    }
}
