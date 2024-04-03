package com.checkout.frames.component.cardscheme;

import com.checkout.base.mapper.Mapper;
import com.checkout.frames.mapper.ImageStyleToComposableImageMapper;
import com.checkout.frames.screen.manager.PaymentStateManager;
import com.checkout.frames.style.component.CardSchemeComponentStyle;
import com.checkout.frames.style.view.CardSchemeComponentViewStyle;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* renamed from: com.checkout.frames.component.cardscheme.CardSchemeViewModel_Factory  reason: case insensitive filesystem */
public final class C0330CardSchemeViewModel_Factory implements Factory<CardSchemeViewModel> {
    private final Provider<Mapper<CardSchemeComponentStyle, CardSchemeComponentState>> cardSchemeComponentStateMapperProvider;
    private final Provider<Mapper<CardSchemeComponentStyle, CardSchemeComponentViewStyle>> cardSchemeComponentStyleMapperProvider;
    private final Provider<ImageStyleToComposableImageMapper> imageMapperProvider;
    private final Provider<PaymentStateManager> paymentStateManagerProvider;
    private final Provider<CardSchemeComponentStyle> styleProvider;

    public C0330CardSchemeViewModel_Factory(Provider<PaymentStateManager> provider, Provider<Mapper<CardSchemeComponentStyle, CardSchemeComponentViewStyle>> provider2, Provider<Mapper<CardSchemeComponentStyle, CardSchemeComponentState>> provider3, Provider<ImageStyleToComposableImageMapper> provider4, Provider<CardSchemeComponentStyle> provider5) {
        this.paymentStateManagerProvider = provider;
        this.cardSchemeComponentStyleMapperProvider = provider2;
        this.cardSchemeComponentStateMapperProvider = provider3;
        this.imageMapperProvider = provider4;
        this.styleProvider = provider5;
    }

    public static C0330CardSchemeViewModel_Factory create(Provider<PaymentStateManager> provider, Provider<Mapper<CardSchemeComponentStyle, CardSchemeComponentViewStyle>> provider2, Provider<Mapper<CardSchemeComponentStyle, CardSchemeComponentState>> provider3, Provider<ImageStyleToComposableImageMapper> provider4, Provider<CardSchemeComponentStyle> provider5) {
        return new C0330CardSchemeViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static CardSchemeViewModel newInstance(PaymentStateManager paymentStateManager, Mapper<CardSchemeComponentStyle, CardSchemeComponentViewStyle> mapper, Mapper<CardSchemeComponentStyle, CardSchemeComponentState> mapper2, ImageStyleToComposableImageMapper imageStyleToComposableImageMapper, CardSchemeComponentStyle cardSchemeComponentStyle) {
        return new CardSchemeViewModel(paymentStateManager, mapper, mapper2, imageStyleToComposableImageMapper, cardSchemeComponentStyle);
    }

    public CardSchemeViewModel get() {
        return newInstance(this.paymentStateManagerProvider.get(), this.cardSchemeComponentStyleMapperProvider.get(), this.cardSchemeComponentStateMapperProvider.get(), this.imageMapperProvider.get(), this.styleProvider.get());
    }
}
