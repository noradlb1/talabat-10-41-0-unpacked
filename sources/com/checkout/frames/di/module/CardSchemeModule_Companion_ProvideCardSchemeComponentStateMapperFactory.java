package com.checkout.frames.di.module;

import com.checkout.base.mapper.Mapper;
import com.checkout.frames.component.cardscheme.CardSchemeComponentState;
import com.checkout.frames.style.component.CardSchemeComponentStyle;
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
public final class CardSchemeModule_Companion_ProvideCardSchemeComponentStateMapperFactory implements Factory<Mapper<CardSchemeComponentStyle, CardSchemeComponentState>> {
    private final Provider<Mapper<TextLabelStyle, TextLabelState>> textLabelMapperProvider;

    public CardSchemeModule_Companion_ProvideCardSchemeComponentStateMapperFactory(Provider<Mapper<TextLabelStyle, TextLabelState>> provider) {
        this.textLabelMapperProvider = provider;
    }

    public static CardSchemeModule_Companion_ProvideCardSchemeComponentStateMapperFactory create(Provider<Mapper<TextLabelStyle, TextLabelState>> provider) {
        return new CardSchemeModule_Companion_ProvideCardSchemeComponentStateMapperFactory(provider);
    }

    public static Mapper<CardSchemeComponentStyle, CardSchemeComponentState> provideCardSchemeComponentStateMapper(Mapper<TextLabelStyle, TextLabelState> mapper) {
        return (Mapper) Preconditions.checkNotNullFromProvides(CardSchemeModule.Companion.provideCardSchemeComponentStateMapper(mapper));
    }

    public Mapper<CardSchemeComponentStyle, CardSchemeComponentState> get() {
        return provideCardSchemeComponentStateMapper(this.textLabelMapperProvider.get());
    }
}
