package com.checkout.frames.di.module;

import com.checkout.base.mapper.Mapper;
import com.checkout.frames.mapper.ImageStyleToComposableImageMapper;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.view.TextLabelState;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class StylesModule_Companion_ProvideTextLabelStyleToStateMapperFactory implements Factory<Mapper<TextLabelStyle, TextLabelState>> {
    private final Provider<ImageStyleToComposableImageMapper> imageMapperProvider;

    public StylesModule_Companion_ProvideTextLabelStyleToStateMapperFactory(Provider<ImageStyleToComposableImageMapper> provider) {
        this.imageMapperProvider = provider;
    }

    public static StylesModule_Companion_ProvideTextLabelStyleToStateMapperFactory create(Provider<ImageStyleToComposableImageMapper> provider) {
        return new StylesModule_Companion_ProvideTextLabelStyleToStateMapperFactory(provider);
    }

    public static Mapper<TextLabelStyle, TextLabelState> provideTextLabelStyleToStateMapper(ImageStyleToComposableImageMapper imageStyleToComposableImageMapper) {
        return (Mapper) Preconditions.checkNotNullFromProvides(StylesModule.Companion.provideTextLabelStyleToStateMapper(imageStyleToComposableImageMapper));
    }

    public Mapper<TextLabelStyle, TextLabelState> get() {
        return provideTextLabelStyleToStateMapper(this.imageMapperProvider.get());
    }
}
