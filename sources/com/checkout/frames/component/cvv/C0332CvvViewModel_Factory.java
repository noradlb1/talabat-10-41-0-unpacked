package com.checkout.frames.component.cvv;

import com.checkout.base.mapper.Mapper;
import com.checkout.frames.component.base.InputComponentState;
import com.checkout.frames.screen.manager.PaymentStateManager;
import com.checkout.frames.style.component.CvvComponentStyle;
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
/* renamed from: com.checkout.frames.component.cvv.CvvViewModel_Factory  reason: case insensitive filesystem */
public final class C0332CvvViewModel_Factory implements Factory<CvvViewModel> {
    private final Provider<CardValidator> cardValidatorProvider;
    private final Provider<Mapper<InputComponentStyle, InputComponentState>> inputComponentStateMapperProvider;
    private final Provider<Mapper<InputComponentStyle, InputComponentViewStyle>> inputComponentStyleMapperProvider;
    private final Provider<PaymentStateManager> paymentStateManagerProvider;
    private final Provider<CvvComponentStyle> styleProvider;

    public C0332CvvViewModel_Factory(Provider<PaymentStateManager> provider, Provider<CardValidator> provider2, Provider<Mapper<InputComponentStyle, InputComponentViewStyle>> provider3, Provider<Mapper<InputComponentStyle, InputComponentState>> provider4, Provider<CvvComponentStyle> provider5) {
        this.paymentStateManagerProvider = provider;
        this.cardValidatorProvider = provider2;
        this.inputComponentStyleMapperProvider = provider3;
        this.inputComponentStateMapperProvider = provider4;
        this.styleProvider = provider5;
    }

    public static C0332CvvViewModel_Factory create(Provider<PaymentStateManager> provider, Provider<CardValidator> provider2, Provider<Mapper<InputComponentStyle, InputComponentViewStyle>> provider3, Provider<Mapper<InputComponentStyle, InputComponentState>> provider4, Provider<CvvComponentStyle> provider5) {
        return new C0332CvvViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static CvvViewModel newInstance(PaymentStateManager paymentStateManager, CardValidator cardValidator, Mapper<InputComponentStyle, InputComponentViewStyle> mapper, Mapper<InputComponentStyle, InputComponentState> mapper2, CvvComponentStyle cvvComponentStyle) {
        return new CvvViewModel(paymentStateManager, cardValidator, mapper, mapper2, cvvComponentStyle);
    }

    public CvvViewModel get() {
        return newInstance(this.paymentStateManagerProvider.get(), this.cardValidatorProvider.get(), this.inputComponentStyleMapperProvider.get(), this.inputComponentStateMapperProvider.get(), this.styleProvider.get());
    }
}
