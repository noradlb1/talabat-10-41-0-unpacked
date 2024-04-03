package com.talabat.feature.darkstoresvendor.data.repository;

import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.feature.darkstoresvendor.data.local.VendorCache;
import com.talabat.feature.darkstoresvendor.data.model.VendorResponse;
import com.talabat.feature.darkstoresvendor.data.remote.GroceryAffordabilityApi;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import com.talabat.mapper.ModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class VendorRepositoryImpl_Factory implements Factory<VendorRepositoryImpl> {
    private final Provider<GroceryAffordabilityApi> groceryAffordabilityApiProvider;
    private final Provider<RxSchedulersFactory> rxSchedulersFactoryProvider;
    private final Provider<VendorCache> vendorCacheProvider;
    private final Provider<ModelMapper<VendorResponse, Vendor>> vendorResponseMapperProvider;

    public VendorRepositoryImpl_Factory(Provider<VendorCache> provider, Provider<ModelMapper<VendorResponse, Vendor>> provider2, Provider<RxSchedulersFactory> provider3, Provider<GroceryAffordabilityApi> provider4) {
        this.vendorCacheProvider = provider;
        this.vendorResponseMapperProvider = provider2;
        this.rxSchedulersFactoryProvider = provider3;
        this.groceryAffordabilityApiProvider = provider4;
    }

    public static VendorRepositoryImpl_Factory create(Provider<VendorCache> provider, Provider<ModelMapper<VendorResponse, Vendor>> provider2, Provider<RxSchedulersFactory> provider3, Provider<GroceryAffordabilityApi> provider4) {
        return new VendorRepositoryImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static VendorRepositoryImpl newInstance(VendorCache vendorCache, ModelMapper<VendorResponse, Vendor> modelMapper, RxSchedulersFactory rxSchedulersFactory, GroceryAffordabilityApi groceryAffordabilityApi) {
        return new VendorRepositoryImpl(vendorCache, modelMapper, rxSchedulersFactory, groceryAffordabilityApi);
    }

    public VendorRepositoryImpl get() {
        return newInstance(this.vendorCacheProvider.get(), this.vendorResponseMapperProvider.get(), this.rxSchedulersFactoryProvider.get(), this.groceryAffordabilityApiProvider.get());
    }
}
