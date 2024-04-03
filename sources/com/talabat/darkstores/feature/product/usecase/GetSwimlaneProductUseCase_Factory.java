package com.talabat.darkstores.feature.product.usecase;

import com.talabat.darkstores.data.swimlanes.SwimlanesProductRepository;
import com.talabat.darkstores.domain.common.ApplyDiscountsAndCampaignsUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetSwimlaneProductUseCase_Factory implements Factory<GetSwimlaneProductUseCase> {
    private final Provider<ApplyDiscountsAndCampaignsUseCase> applyDiscountsAndCampaignsProvider;
    private final Provider<SwimlanesProductRepository> swimlanesProductRepositoryProvider;

    public GetSwimlaneProductUseCase_Factory(Provider<SwimlanesProductRepository> provider, Provider<ApplyDiscountsAndCampaignsUseCase> provider2) {
        this.swimlanesProductRepositoryProvider = provider;
        this.applyDiscountsAndCampaignsProvider = provider2;
    }

    public static GetSwimlaneProductUseCase_Factory create(Provider<SwimlanesProductRepository> provider, Provider<ApplyDiscountsAndCampaignsUseCase> provider2) {
        return new GetSwimlaneProductUseCase_Factory(provider, provider2);
    }

    public static GetSwimlaneProductUseCase newInstance(SwimlanesProductRepository swimlanesProductRepository, ApplyDiscountsAndCampaignsUseCase applyDiscountsAndCampaignsUseCase) {
        return new GetSwimlaneProductUseCase(swimlanesProductRepository, applyDiscountsAndCampaignsUseCase);
    }

    public GetSwimlaneProductUseCase get() {
        return newInstance(this.swimlanesProductRepositoryProvider.get(), this.applyDiscountsAndCampaignsProvider.get());
    }
}
