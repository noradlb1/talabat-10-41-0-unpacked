package com.talabat.feature.darkstoresvendor.domain.usecase;

import com.talabat.feature.darkstoresvendor.domain.repository.VendorRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetVendorUseCase_Factory implements Factory<GetVendorUseCase> {
    private final Provider<VendorRepository> vendorRepositoryProvider;

    public GetVendorUseCase_Factory(Provider<VendorRepository> provider) {
        this.vendorRepositoryProvider = provider;
    }

    public static GetVendorUseCase_Factory create(Provider<VendorRepository> provider) {
        return new GetVendorUseCase_Factory(provider);
    }

    public static GetVendorUseCase newInstance(VendorRepository vendorRepository) {
        return new GetVendorUseCase(vendorRepository);
    }

    public GetVendorUseCase get() {
        return newInstance(this.vendorRepositoryProvider.get());
    }
}
