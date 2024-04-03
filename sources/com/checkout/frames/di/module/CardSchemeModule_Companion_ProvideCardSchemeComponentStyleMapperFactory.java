package com.checkout.frames.di.module;

import androidx.compose.ui.Modifier;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.style.component.CardSchemeComponentStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.view.CardSchemeComponentViewStyle;
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
public final class CardSchemeModule_Companion_ProvideCardSchemeComponentStyleMapperFactory implements Factory<Mapper<CardSchemeComponentStyle, CardSchemeComponentViewStyle>> {
    private final Provider<Mapper<ContainerStyle, Modifier>> containerMapperProvider;
    private final Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> textLabelStyleMapperProvider;

    public CardSchemeModule_Companion_ProvideCardSchemeComponentStyleMapperFactory(Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> provider, Provider<Mapper<ContainerStyle, Modifier>> provider2) {
        this.textLabelStyleMapperProvider = provider;
        this.containerMapperProvider = provider2;
    }

    public static CardSchemeModule_Companion_ProvideCardSchemeComponentStyleMapperFactory create(Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> provider, Provider<Mapper<ContainerStyle, Modifier>> provider2) {
        return new CardSchemeModule_Companion_ProvideCardSchemeComponentStyleMapperFactory(provider, provider2);
    }

    public static Mapper<CardSchemeComponentStyle, CardSchemeComponentViewStyle> provideCardSchemeComponentStyleMapper(Mapper<TextLabelStyle, TextLabelViewStyle> mapper, Mapper<ContainerStyle, Modifier> mapper2) {
        return (Mapper) Preconditions.checkNotNullFromProvides(CardSchemeModule.Companion.provideCardSchemeComponentStyleMapper(mapper, mapper2));
    }

    public Mapper<CardSchemeComponentStyle, CardSchemeComponentViewStyle> get() {
        return provideCardSchemeComponentStyleMapper(this.textLabelStyleMapperProvider.get(), this.containerMapperProvider.get());
    }
}
