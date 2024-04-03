package com.checkout.frames.di.module;

import com.checkout.base.mapper.Mapper;
import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.view.InternalButtonState;
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
public final class StylesModule_Companion_ProvideButtonStateMapperFactory implements Factory<Mapper<ButtonStyle, InternalButtonState>> {
    private final Provider<Mapper<TextLabelStyle, TextLabelState>> textLabelStateMapperProvider;

    public StylesModule_Companion_ProvideButtonStateMapperFactory(Provider<Mapper<TextLabelStyle, TextLabelState>> provider) {
        this.textLabelStateMapperProvider = provider;
    }

    public static StylesModule_Companion_ProvideButtonStateMapperFactory create(Provider<Mapper<TextLabelStyle, TextLabelState>> provider) {
        return new StylesModule_Companion_ProvideButtonStateMapperFactory(provider);
    }

    public static Mapper<ButtonStyle, InternalButtonState> provideButtonStateMapper(Mapper<TextLabelStyle, TextLabelState> mapper) {
        return (Mapper) Preconditions.checkNotNullFromProvides(StylesModule.Companion.provideButtonStateMapper(mapper));
    }

    public Mapper<ButtonStyle, InternalButtonState> get() {
        return provideButtonStateMapper(this.textLabelStateMapperProvider.get());
    }
}
