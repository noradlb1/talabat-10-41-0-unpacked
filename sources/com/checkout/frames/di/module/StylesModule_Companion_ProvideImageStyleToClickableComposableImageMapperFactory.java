package com.checkout.frames.di.module;

import com.checkout.frames.mapper.ImageStyleToClickableComposableImageMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class StylesModule_Companion_ProvideImageStyleToClickableComposableImageMapperFactory implements Factory<ImageStyleToClickableComposableImageMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final StylesModule_Companion_ProvideImageStyleToClickableComposableImageMapperFactory INSTANCE = new StylesModule_Companion_ProvideImageStyleToClickableComposableImageMapperFactory();

        private InstanceHolder() {
        }
    }

    public static StylesModule_Companion_ProvideImageStyleToClickableComposableImageMapperFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ImageStyleToClickableComposableImageMapper provideImageStyleToClickableComposableImageMapper() {
        return (ImageStyleToClickableComposableImageMapper) Preconditions.checkNotNullFromProvides(StylesModule.Companion.provideImageStyleToClickableComposableImageMapper());
    }

    public ImageStyleToClickableComposableImageMapper get() {
        return provideImageStyleToClickableComposableImageMapper();
    }
}
