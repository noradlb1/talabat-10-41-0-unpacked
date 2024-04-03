package com.checkout.frames.di.module;

import com.checkout.frames.mapper.ImageStyleToComposableImageMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class StylesModule_Companion_ProvideImageStyleToComposableImageMapperFactory implements Factory<ImageStyleToComposableImageMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final StylesModule_Companion_ProvideImageStyleToComposableImageMapperFactory INSTANCE = new StylesModule_Companion_ProvideImageStyleToComposableImageMapperFactory();

        private InstanceHolder() {
        }
    }

    public static StylesModule_Companion_ProvideImageStyleToComposableImageMapperFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ImageStyleToComposableImageMapper provideImageStyleToComposableImageMapper() {
        return (ImageStyleToComposableImageMapper) Preconditions.checkNotNullFromProvides(StylesModule.Companion.provideImageStyleToComposableImageMapper());
    }

    public ImageStyleToComposableImageMapper get() {
        return provideImageStyleToComposableImageMapper();
    }
}
