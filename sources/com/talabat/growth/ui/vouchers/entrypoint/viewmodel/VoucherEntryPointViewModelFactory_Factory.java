package com.talabat.growth.ui.vouchers.entrypoint.viewmodel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class VoucherEntryPointViewModelFactory_Factory implements Factory<VoucherEntryPointViewModelFactory> {
    private final Provider<VoucherEntryPointViewModel> providerProvider;

    public VoucherEntryPointViewModelFactory_Factory(Provider<VoucherEntryPointViewModel> provider) {
        this.providerProvider = provider;
    }

    public static VoucherEntryPointViewModelFactory_Factory create(Provider<VoucherEntryPointViewModel> provider) {
        return new VoucherEntryPointViewModelFactory_Factory(provider);
    }

    public static VoucherEntryPointViewModelFactory newInstance(Provider<VoucherEntryPointViewModel> provider) {
        return new VoucherEntryPointViewModelFactory(provider);
    }

    public VoucherEntryPointViewModelFactory get() {
        return newInstance(this.providerProvider);
    }
}
