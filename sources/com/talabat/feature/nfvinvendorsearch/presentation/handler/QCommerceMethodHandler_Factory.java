package com.talabat.feature.nfvinvendorsearch.presentation.handler;

import com.talabat.feature.darkstoresvendor.domain.usecase.GetVendorUseCase;
import com.talabat.feature.nfvinvendorsearch.presentation.mapper.FlutterVendorToMapMapper;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class QCommerceMethodHandler_Factory implements Factory<QCommerceMethodHandler> {
    private final Provider<FlutterConfigurationParams> configurationParamsProvider;
    private final Provider<GetVendorUseCase> getVendorUseCaseProvider;
    private final Provider<FlutterVendorToMapMapper> vendorMapperProvider;

    public QCommerceMethodHandler_Factory(Provider<FlutterConfigurationParams> provider, Provider<GetVendorUseCase> provider2, Provider<FlutterVendorToMapMapper> provider3) {
        this.configurationParamsProvider = provider;
        this.getVendorUseCaseProvider = provider2;
        this.vendorMapperProvider = provider3;
    }

    public static QCommerceMethodHandler_Factory create(Provider<FlutterConfigurationParams> provider, Provider<GetVendorUseCase> provider2, Provider<FlutterVendorToMapMapper> provider3) {
        return new QCommerceMethodHandler_Factory(provider, provider2, provider3);
    }

    public static QCommerceMethodHandler newInstance(FlutterConfigurationParams flutterConfigurationParams, GetVendorUseCase getVendorUseCase, FlutterVendorToMapMapper flutterVendorToMapMapper) {
        return new QCommerceMethodHandler(flutterConfigurationParams, getVendorUseCase, flutterVendorToMapMapper);
    }

    public QCommerceMethodHandler get() {
        return newInstance(this.configurationParamsProvider.get(), this.getVendorUseCaseProvider.get(), this.vendorMapperProvider.get());
    }
}
