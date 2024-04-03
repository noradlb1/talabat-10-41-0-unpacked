package com.talabat.talabatcommon.feature.vouchers.loyalty.repository;

import com.talabat.talabatcommon.feature.vouchers.loyalty.network.VouchersService;
import com.talabat.talabatcore.platform.NetworkHandler;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class VoucherRepositoryImpl_Factory implements Factory<VoucherRepositoryImpl> {
    private final Provider<NetworkHandler> networkHandlerProvider;
    private final Provider<VouchersService> serviceProvider;

    public VoucherRepositoryImpl_Factory(Provider<NetworkHandler> provider, Provider<VouchersService> provider2) {
        this.networkHandlerProvider = provider;
        this.serviceProvider = provider2;
    }

    public static VoucherRepositoryImpl_Factory create(Provider<NetworkHandler> provider, Provider<VouchersService> provider2) {
        return new VoucherRepositoryImpl_Factory(provider, provider2);
    }

    public static VoucherRepositoryImpl newInstance(NetworkHandler networkHandler, VouchersService vouchersService) {
        return new VoucherRepositoryImpl(networkHandler, vouchersService);
    }

    public VoucherRepositoryImpl get() {
        return newInstance(this.networkHandlerProvider.get(), this.serviceProvider.get());
    }
}
