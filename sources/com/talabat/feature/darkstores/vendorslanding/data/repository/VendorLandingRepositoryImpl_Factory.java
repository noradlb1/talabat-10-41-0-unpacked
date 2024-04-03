package com.talabat.feature.darkstores.vendorslanding.data.repository;

import com.talabat.feature.darkstores.vendorlanding.domain.model.VendorLanding;
import com.talabat.feature.darkstores.vendorslanding.data.model.VendorLandingResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.VendorLandingResponseV2;
import com.talabat.feature.darkstores.vendorslanding.data.remote.VendorLandingApi;
import com.talabat.mapper.ModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class VendorLandingRepositoryImpl_Factory implements Factory<VendorLandingRepositoryImpl> {
    private final Provider<VendorLandingApi> vendorLandingApiProvider;
    private final Provider<ModelMapper<VendorLandingResponse, VendorLanding>> vendorLandingMapperProvider;
    private final Provider<ModelMapper<VendorLandingResponseV2, VendorLanding>> vendorLandingMapperV2Provider;

    public VendorLandingRepositoryImpl_Factory(Provider<VendorLandingApi> provider, Provider<ModelMapper<VendorLandingResponse, VendorLanding>> provider2, Provider<ModelMapper<VendorLandingResponseV2, VendorLanding>> provider3) {
        this.vendorLandingApiProvider = provider;
        this.vendorLandingMapperProvider = provider2;
        this.vendorLandingMapperV2Provider = provider3;
    }

    public static VendorLandingRepositoryImpl_Factory create(Provider<VendorLandingApi> provider, Provider<ModelMapper<VendorLandingResponse, VendorLanding>> provider2, Provider<ModelMapper<VendorLandingResponseV2, VendorLanding>> provider3) {
        return new VendorLandingRepositoryImpl_Factory(provider, provider2, provider3);
    }

    public static VendorLandingRepositoryImpl newInstance(VendorLandingApi vendorLandingApi, ModelMapper<VendorLandingResponse, VendorLanding> modelMapper, ModelMapper<VendorLandingResponseV2, VendorLanding> modelMapper2) {
        return new VendorLandingRepositoryImpl(vendorLandingApi, modelMapper, modelMapper2);
    }

    public VendorLandingRepositoryImpl get() {
        return newInstance(this.vendorLandingApiProvider.get(), this.vendorLandingMapperProvider.get(), this.vendorLandingMapperV2Provider.get());
    }
}
