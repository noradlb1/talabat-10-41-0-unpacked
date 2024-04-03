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
public final class CategoryTreeMapper_Factory implements Factory<CategoryTreeMapper> {
    private final Provider<ModelMapper<ImageUrlResponse, ImageUrl>> imageUrlMapperProvider;

    public CategoryTreeMapper_Factory(Provider<ModelMapper<ImageUrlResponse, ImageUrl>> provider) {
        this.imageUrlMapperProvider = provider;
    }

    public static CategoryTreeMapper_Factory create(Provider<ModelMapper<ImageUrlResponse, ImageUrl>> provider) {
        return new CategoryTreeMapper_Factory(provider);
    }

    public static CategoryTreeMapper newInstance(ModelMapper<ImageUrlResponse, ImageUrl> modelMapper) {
        return new CategoryTreeMapper(modelMapper);
    }

    public CategoryTreeMapper get() {
        return newInstance(this.imageUrlMapperProvider.get());
    }
}
