package com.talabat.feature.darkstores.vendorslanding.data.mapper;

import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMetadata;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMissionItem;
import com.talabat.feature.darkstores.vendorlanding.domain.model.PageInfo;
import com.talabat.feature.darkstores.vendorslanding.data.model.LifestyleMissionItemResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.MetadataResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.PageInfoResponse;
import com.talabat.mapper.ModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class LifestyleMissionMapper_Factory implements Factory<LifestyleMissionMapper> {
    private final Provider<ModelMapper<LifestyleMissionItemResponse, LifestyleMissionItem>> lifestyleMissionItemMapperProvider;
    private final Provider<ModelMapper<MetadataResponse, LifestyleMetadata>> metadataMapperProvider;
    private final Provider<ModelMapper<PageInfoResponse, PageInfo>> pageInfoMapperProvider;

    public LifestyleMissionMapper_Factory(Provider<ModelMapper<LifestyleMissionItemResponse, LifestyleMissionItem>> provider, Provider<ModelMapper<MetadataResponse, LifestyleMetadata>> provider2, Provider<ModelMapper<PageInfoResponse, PageInfo>> provider3) {
        this.lifestyleMissionItemMapperProvider = provider;
        this.metadataMapperProvider = provider2;
        this.pageInfoMapperProvider = provider3;
    }

    public static LifestyleMissionMapper_Factory create(Provider<ModelMapper<LifestyleMissionItemResponse, LifestyleMissionItem>> provider, Provider<ModelMapper<MetadataResponse, LifestyleMetadata>> provider2, Provider<ModelMapper<PageInfoResponse, PageInfo>> provider3) {
        return new LifestyleMissionMapper_Factory(provider, provider2, provider3);
    }

    public static LifestyleMissionMapper newInstance(ModelMapper<LifestyleMissionItemResponse, LifestyleMissionItem> modelMapper, ModelMapper<MetadataResponse, LifestyleMetadata> modelMapper2, ModelMapper<PageInfoResponse, PageInfo> modelMapper3) {
        return new LifestyleMissionMapper(modelMapper, modelMapper2, modelMapper3);
    }

    public LifestyleMissionMapper get() {
        return newInstance(this.lifestyleMissionItemMapperProvider.get(), this.metadataMapperProvider.get(), this.pageInfoMapperProvider.get());
    }
}
