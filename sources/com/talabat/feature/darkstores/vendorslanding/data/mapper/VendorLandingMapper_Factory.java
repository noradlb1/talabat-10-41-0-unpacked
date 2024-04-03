package com.talabat.feature.darkstores.vendorslanding.data.mapper;

import com.talabat.feature.darkstores.vendorlanding.domain.model.CategoryTree;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMission;
import com.talabat.feature.darkstores.vendorlanding.domain.model.SwimlaneProduct;
import com.talabat.feature.darkstores.vendorslanding.data.model.CategoryTreeResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.LifestyleMissionResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.SwimlaneProductResponse;
import com.talabat.mapper.ModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class VendorLandingMapper_Factory implements Factory<VendorLandingMapper> {
    private final Provider<ModelMapper<CategoryTreeResponse, CategoryTree>> categoryTreeMapperProvider;
    private final Provider<ModelMapper<LifestyleMissionResponse, LifestyleMission>> lifestyleMissionMapperProvider;
    private final Provider<ModelMapper<SwimlaneProductResponse, SwimlaneProduct>> swimlaneProductMapperProvider;

    public VendorLandingMapper_Factory(Provider<ModelMapper<CategoryTreeResponse, CategoryTree>> provider, Provider<ModelMapper<LifestyleMissionResponse, LifestyleMission>> provider2, Provider<ModelMapper<SwimlaneProductResponse, SwimlaneProduct>> provider3) {
        this.categoryTreeMapperProvider = provider;
        this.lifestyleMissionMapperProvider = provider2;
        this.swimlaneProductMapperProvider = provider3;
    }

    public static VendorLandingMapper_Factory create(Provider<ModelMapper<CategoryTreeResponse, CategoryTree>> provider, Provider<ModelMapper<LifestyleMissionResponse, LifestyleMission>> provider2, Provider<ModelMapper<SwimlaneProductResponse, SwimlaneProduct>> provider3) {
        return new VendorLandingMapper_Factory(provider, provider2, provider3);
    }

    public static VendorLandingMapper newInstance(ModelMapper<CategoryTreeResponse, CategoryTree> modelMapper, ModelMapper<LifestyleMissionResponse, LifestyleMission> modelMapper2, ModelMapper<SwimlaneProductResponse, SwimlaneProduct> modelMapper3) {
        return new VendorLandingMapper(modelMapper, modelMapper2, modelMapper3);
    }

    public VendorLandingMapper get() {
        return newInstance(this.categoryTreeMapperProvider.get(), this.lifestyleMissionMapperProvider.get(), this.swimlaneProductMapperProvider.get());
    }
}
