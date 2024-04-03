package com.talabat.feature.darkstores.vendorslanding.data.mapper;

import com.talabat.feature.darkstores.vendorlanding.domain.model.ImageUrl;
import com.talabat.feature.darkstores.vendorslanding.data.model.ImageUrlResponse;
import com.talabat.mapper.ModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SwimlaneProductMapper_Factory implements Factory<SwimlaneProductMapper> {
    private final Provider<ModelMapper<ImageUrlResponse, ImageUrl>> imageUrlMapperProvider;

    public SwimlaneProductMapper_Factory(Provider<ModelMapper<ImageUrlResponse, ImageUrl>> provider) {
        this.imageUrlMapperProvider = provider;
    }

    public static SwimlaneProductMapper_Factory create(Provider<ModelMapper<ImageUrlResponse, ImageUrl>> provider) {
        return new SwimlaneProductMapper_Factory(provider);
    }

    public static SwimlaneProductMapper newInstance(ModelMapper<ImageUrlResponse, ImageUrl> modelMapper) {
        return new SwimlaneProductMapper(modelMapper);
    }

    public SwimlaneProductMapper get() {
        return newInstance(this.imageUrlMapperProvider.get());
    }
}
