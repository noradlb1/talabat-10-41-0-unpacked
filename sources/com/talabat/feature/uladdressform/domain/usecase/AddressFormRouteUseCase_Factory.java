package com.talabat.feature.uladdressform.domain.usecase;

import com.talabat.feature.uladdressform.domain.repository.AddressFormFWFRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AddressFormRouteUseCase_Factory implements Factory<AddressFormRouteUseCase> {
    private final Provider<AddressFormFWFRepository> repositoryProvider;

    public AddressFormRouteUseCase_Factory(Provider<AddressFormFWFRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static AddressFormRouteUseCase_Factory create(Provider<AddressFormFWFRepository> provider) {
        return new AddressFormRouteUseCase_Factory(provider);
    }

    public static AddressFormRouteUseCase newInstance(AddressFormFWFRepository addressFormFWFRepository) {
        return new AddressFormRouteUseCase(addressFormFWFRepository);
    }

    public AddressFormRouteUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
