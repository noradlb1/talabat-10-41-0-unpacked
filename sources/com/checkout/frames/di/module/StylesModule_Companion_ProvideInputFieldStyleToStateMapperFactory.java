package com.checkout.frames.di.module;

import com.checkout.base.mapper.Mapper;
import com.checkout.frames.mapper.ImageStyleToComposableImageMapper;
import com.checkout.frames.style.component.base.InputFieldStyle;
import com.checkout.frames.view.InputFieldState;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class StylesModule_Companion_ProvideInputFieldStyleToStateMapperFactory implements Factory<Mapper<InputFieldStyle, InputFieldState>> {
    private final Provider<ImageStyleToComposableImageMapper> imageMapperProvider;

    public StylesModule_Companion_ProvideInputFieldStyleToStateMapperFactory(Provider<ImageStyleToComposableImageMapper> provider) {
        this.imageMapperProvider = provider;
    }

    public static StylesModule_Companion_ProvideInputFieldStyleToStateMapperFactory create(Provider<ImageStyleToComposableImageMapper> provider) {
        return new StylesModule_Companion_ProvideInputFieldStyleToStateMapperFactory(provider);
    }

    public static Mapper<InputFieldStyle, InputFieldState> provideInputFieldStyleToStateMapper(ImageStyleToComposableImageMapper imageStyleToComposableImageMapper) {
        return (Mapper) Preconditions.checkNotNullFromProvides(StylesModule.Companion.provideInputFieldStyleToStateMapper(imageStyleToComposableImageMapper));
    }

    public Mapper<InputFieldStyle, InputFieldState> get() {
        return provideInputFieldStyleToStateMapper(this.imageMapperProvider.get());
    }
}
