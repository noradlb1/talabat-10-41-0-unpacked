package com.checkout.frames.di.module;

import com.checkout.frames.mapper.ImageStyleToDynamicComposableImageMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class StylesModule_Companion_ProvideImageStyleToDynamicComposableImageMapperFactory implements Factory<ImageStyleToDynamicComposableImageMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final StylesModule_Companion_ProvideImageStyleToDynamicComposableImageMapperFactory INSTANCE = new StylesModule_Companion_ProvideImageStyleToDynamicComposableImageMapperFactory();

        private InstanceHolder() {
        }
    }

    public static StylesModule_Companion_ProvideImageStyleToDynamicComposableImageMapperFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ImageStyleToDynamicComposableImageMapper provideImageStyleToDynamicComposableImageMapper() {
        return (ImageStyleToDynamicComposableImageMapper) Preconditions.checkNotNullFromProvides(StylesModule.Companion.provideImageStyleToDynamicComposableImageMapper());
    }

    public ImageStyleToDynamicComposableImageMapper get() {
        return provideImageStyleToDynamicComposableImageMapper();
    }
}
