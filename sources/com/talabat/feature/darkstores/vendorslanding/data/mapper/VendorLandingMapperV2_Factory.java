package com.talabat.feature.darkstores.vendorslanding.data.mapper;

import com.talabat.feature.darkstores.vendorlanding.domain.model.Banner;
import com.talabat.feature.darkstores.vendorlanding.domain.model.CategoryTree;
import com.talabat.feature.darkstores.vendorlanding.domain.model.Item;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMission;
import com.talabat.feature.darkstores.vendorslanding.data.model.BannerResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.CategoryTreeResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.ItemResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.LifestyleMissionResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.VendorInfoResponse;
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
public final class VendorLandingMapperV2_Factory implements Factory<VendorLandingMapperV2> {
    private final Provider<ModelMapper<BannerResponse, Banner>> bannerMapperProvider;
    private final Provider<ModelMapper<CategoryTreeResponse, CategoryTree>> categoryTreeMapperProvider;
    private final Provider<ModelMapper<ItemResponse, Item>> itemMapperProvider;
    private final Provider<ModelMapper<LifestyleMissionResponse, LifestyleMission>> lifestyleMissionMapperProvider;
    private final Provider<ModelMapper<VendorInfoResponse, Vendor>> vendorInfoMapperProvider;

    public VendorLandingMapperV2_Factory(Provider<ModelMapper<CategoryTreeResponse, CategoryTree>> provider, Provider<ModelMapper<LifestyleMissionResponse, LifestyleMission>> provider2, Provider<ModelMapper<BannerResponse, Banner>> provider3, Provider<ModelMapper<VendorInfoResponse, Vendor>> provider4, Provider<ModelMapper<ItemResponse, Item>> provider5) {
        this.categoryTreeMapperProvider = provider;
        this.lifestyleMissionMapperProvider = provider2;
        this.bannerMapperProvider = provider3;
        this.vendorInfoMapperProvider = provider4;
        this.itemMapperProvider = provider5;
    }

    public static VendorLandingMapperV2_Factory create(Provider<ModelMapper<CategoryTreeResponse, CategoryTree>> provider, Provider<ModelMapper<LifestyleMissionResponse, LifestyleMission>> provider2, Provider<ModelMapper<BannerResponse, Banner>> provider3, Provider<ModelMapper<VendorInfoResponse, Vendor>> provider4, Provider<ModelMapper<ItemResponse, Item>> provider5) {
        return new VendorLandingMapperV2_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static VendorLandingMapperV2 newInstance(ModelMapper<CategoryTreeResponse, CategoryTree> modelMapper, ModelMapper<LifestyleMissionResponse, LifestyleMission> modelMapper2, ModelMapper<BannerResponse, Banner> modelMapper3, ModelMapper<VendorInfoResponse, Vendor> modelMapper4, ModelMapper<ItemResponse, Item> modelMapper5) {
        return new VendorLandingMapperV2(modelMapper, modelMapper2, modelMapper3, modelMapper4, modelMapper5);
    }

    public VendorLandingMapperV2 get() {
        return newInstance(this.categoryTreeMapperProvider.get(), this.lifestyleMissionMapperProvider.get(), this.bannerMapperProvider.get(), this.vendorInfoMapperProvider.get(), this.itemMapperProvider.get());
    }
}
