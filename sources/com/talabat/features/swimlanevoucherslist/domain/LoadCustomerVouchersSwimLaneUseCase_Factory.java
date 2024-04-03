package com.talabat.features.swimlanevoucherslist.domain;

import com.talabat.features.swimlanevoucherslist.domain.repository.CustomerVouchersSwimLaneRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class LoadCustomerVouchersSwimLaneUseCase_Factory implements Factory<LoadCustomerVouchersSwimLaneUseCase> {
    private final Provider<CustomerVouchersSwimLaneRepository> vouchersSwimLaneRepositoryProvider;

    public LoadCustomerVouchersSwimLaneUseCase_Factory(Provider<CustomerVouchersSwimLaneRepository> provider) {
        this.vouchersSwimLaneRepositoryProvider = provider;
    }

    public static LoadCustomerVouchersSwimLaneUseCase_Factory create(Provider<CustomerVouchersSwimLaneRepository> provider) {
        return new LoadCustomerVouchersSwimLaneUseCase_Factory(provider);
    }

    public static LoadCustomerVouchersSwimLaneUseCase newInstance(CustomerVouchersSwimLaneRepository customerVouchersSwimLaneRepository) {
        return new LoadCustomerVouchersSwimLaneUseCase(customerVouchersSwimLaneRepository);
    }

    public LoadCustomerVouchersSwimLaneUseCase get() {
        return newInstance(this.vouchersSwimLaneRepositoryProvider.get());
    }
}
