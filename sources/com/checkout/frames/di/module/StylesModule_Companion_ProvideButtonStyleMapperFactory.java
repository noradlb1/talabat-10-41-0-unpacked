package com.checkout.frames.di.module;

import androidx.compose.ui.Modifier;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.view.InternalButtonViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class StylesModule_Companion_ProvideButtonStyleMapperFactory implements Factory<Mapper<ButtonStyle, InternalButtonViewStyle>> {
    private final Provider<Mapper<ContainerStyle, Modifier>> containerMapperProvider;
    private final Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> textLabelStyleMapperProvider;

    public StylesModule_Companion_ProvideButtonStyleMapperFactory(Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> provider, Provider<Mapper<ContainerStyle, Modifier>> provider2) {
        this.textLabelStyleMapperProvider = provider;
        this.containerMapperProvider = provider2;
    }

    public static StylesModule_Companion_ProvideButtonStyleMapperFactory create(Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> provider, Provider<Mapper<ContainerStyle, Modifier>> provider2) {
        return new StylesModule_Companion_ProvideButtonStyleMapperFactory(provider, provider2);
    }

    public static Mapper<ButtonStyle, InternalButtonViewStyle> provideButtonStyleMapper(Mapper<TextLabelStyle, TextLabelViewStyle> mapper, Mapper<ContainerStyle, Modifier> mapper2) {
        return (Mapper) Preconditions.checkNotNullFromProvides(StylesModule.Companion.provideButtonStyleMapper(mapper, mapper2));
    }

    public Mapper<ButtonStyle, InternalButtonViewStyle> get() {
        return provideButtonStyleMapper(this.textLabelStyleMapperProvider.get(), this.containerMapperProvider.get());
    }
}
