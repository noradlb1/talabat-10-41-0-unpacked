package com.checkout.frames.component.cardnumber;

import com.checkout.base.mapper.Mapper;
import com.checkout.frames.component.base.InputComponentState;
import com.checkout.frames.mapper.ImageStyleToDynamicComposableImageMapper;
import com.checkout.frames.screen.manager.PaymentStateManager;
import com.checkout.frames.style.component.CardNumberComponentStyle;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.view.InputComponentViewStyle;
import com.checkout.validation.api.CardValidator;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* renamed from: com.checkout.frames.component.cardnumber.CardNumberViewModel_Factory  reason: case insensitive filesystem */
public final class C0329CardNumberViewModel_Factory implements Factory<CardNumberViewModel> {
    private final Provider<CardValidator> cardValidatorProvider;
    private final Provider<ImageStyleToDynamicComposableImageMapper> imageMapperProvider;
    private final Provider<Mapper<InputComponentStyle, InputComponentState>> inputComponentStateMapperProvider;
    private final Provider<Mapper<InputComponentStyle, InputComponentViewStyle>> inputComponentStyleMapperProvider;
    private final Provider<PaymentStateManager> paymentStateManagerProvider;
    private final Provider<CardNumberComponentStyle> styleProvider;

    public C0329CardNumberViewModel_Factory(Provider<PaymentStateManager> provider, Provider<CardValidator> provider2, Provider<Mapper<InputComponentStyle, InputComponentViewStyle>> provider3, Provider<Mapper<InputComponentStyle, InputComponentState>> provider4, Provider<ImageStyleToDynamicComposableImageMapper> provider5, Provider<CardNumberComponentStyle> provider6) {
        this.paymentStateManagerProvider = provider;
        this.cardValidatorProvider = provider2;
        this.inputComponentStyleMapperProvider = provider3;
        this.inputComponentStateMapperProvider = provider4;
        this.imageMapperProvider = provider5;
        this.styleProvider = provider6;
    }

    public static C0329CardNumberViewModel_Factory create(Provider<PaymentStateManager> provider, Provider<CardValidator> provider2, Provider<Mapper<InputComponentStyle, InputComponentViewStyle>> provider3, Provider<Mapper<InputComponentStyle, InputComponentState>> provider4, Provider<ImageStyleToDynamicComposableImageMapper> provider5, Provider<CardNumberComponentStyle> provider6) {
        return new C0329CardNumberViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static CardNumberViewModel newInstance(PaymentStateManager paymentStateManager, CardValidator cardValidator, Mapper<InputComponentStyle, InputComponentViewStyle> mapper, Mapper<InputComponentStyle, InputComponentState> mapper2, ImageStyleToDynamicComposableImageMapper imageStyleToDynamicComposableImageMapper, CardNumberComponentStyle cardNumberComponentStyle) {
        return new CardNumberViewModel(paymentStateManager, cardValidator, mapper, mapper2, imageStyleToDynamicComposableImageMapper, cardNumberComponentStyle);
    }

    public CardNumberViewModel get() {
        return newInstance(this.paymentStateManagerProvider.get(), this.cardValidatorProvider.get(), this.inputComponentStyleMapperProvider.get(), this.inputComponentStateMapperProvider.get(), this.imageMapperProvider.get(), this.styleProvider.get());
    }
}
