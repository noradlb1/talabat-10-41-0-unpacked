package com.checkout.frames.screen.billingaddress.billingaddressdetails;

import androidx.compose.ui.Modifier;
import com.checkout.base.mapper.Mapper;
import com.checkout.base.usecase.UseCase;
import com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentsContainerState;
import com.checkout.frames.mapper.ImageStyleToDynamicComposableImageMapper;
import com.checkout.frames.screen.manager.PaymentStateManager;
import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.screen.BillingAddressDetailsStyle;
import com.checkout.frames.style.view.InternalButtonViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.style.view.billingformdetails.BillingAddressInputComponentsViewContainerStyle;
import com.checkout.frames.view.InternalButtonState;
import com.checkout.frames.view.TextLabelState;
import com.checkout.logging.Logger;
import com.checkout.logging.model.LoggingEvent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* renamed from: com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsViewModel_Factory  reason: case insensitive filesystem */
public final class C0335BillingAddressDetailsViewModel_Factory implements Factory<BillingAddressDetailsViewModel> {
    private final Provider<UseCase<BillingAddressDetailsStyle, BillingAddressInputComponentsContainerState>> billingAddressDetailsComponentStateUseCaseProvider;
    private final Provider<UseCase<BillingAddressDetailsStyle, BillingAddressInputComponentsViewContainerStyle>> billingAddressDetailsComponentStyleUseCaseProvider;
    private final Provider<Mapper<ButtonStyle, InternalButtonState>> buttonStateMapperProvider;
    private final Provider<Mapper<ButtonStyle, InternalButtonViewStyle>> buttonStyleMapperProvider;
    private final Provider<Mapper<ContainerStyle, Modifier>> containerMapperProvider;
    private final Provider<ImageStyleToDynamicComposableImageMapper> imageMapperProvider;
    private final Provider<Logger<LoggingEvent>> loggerProvider;
    private final Provider<PaymentStateManager> paymentStateManagerProvider;
    private final Provider<BillingAddressDetailsStyle> styleProvider;
    private final Provider<Mapper<TextLabelStyle, TextLabelState>> textLabelStateMapperProvider;
    private final Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> textLabelStyleMapperProvider;

    public C0335BillingAddressDetailsViewModel_Factory(Provider<PaymentStateManager> provider, Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> provider2, Provider<Mapper<TextLabelStyle, TextLabelState>> provider3, Provider<Mapper<ContainerStyle, Modifier>> provider4, Provider<ImageStyleToDynamicComposableImageMapper> provider5, Provider<UseCase<BillingAddressDetailsStyle, BillingAddressInputComponentsContainerState>> provider6, Provider<UseCase<BillingAddressDetailsStyle, BillingAddressInputComponentsViewContainerStyle>> provider7, Provider<Mapper<ButtonStyle, InternalButtonViewStyle>> provider8, Provider<Mapper<ButtonStyle, InternalButtonState>> provider9, Provider<Logger<LoggingEvent>> provider10, Provider<BillingAddressDetailsStyle> provider11) {
        this.paymentStateManagerProvider = provider;
        this.textLabelStyleMapperProvider = provider2;
        this.textLabelStateMapperProvider = provider3;
        this.containerMapperProvider = provider4;
        this.imageMapperProvider = provider5;
        this.billingAddressDetailsComponentStateUseCaseProvider = provider6;
        this.billingAddressDetailsComponentStyleUseCaseProvider = provider7;
        this.buttonStyleMapperProvider = provider8;
        this.buttonStateMapperProvider = provider9;
        this.loggerProvider = provider10;
        this.styleProvider = provider11;
    }

    public static C0335BillingAddressDetailsViewModel_Factory create(Provider<PaymentStateManager> provider, Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> provider2, Provider<Mapper<TextLabelStyle, TextLabelState>> provider3, Provider<Mapper<ContainerStyle, Modifier>> provider4, Provider<ImageStyleToDynamicComposableImageMapper> provider5, Provider<UseCase<BillingAddressDetailsStyle, BillingAddressInputComponentsContainerState>> provider6, Provider<UseCase<BillingAddressDetailsStyle, BillingAddressInputComponentsViewContainerStyle>> provider7, Provider<Mapper<ButtonStyle, InternalButtonViewStyle>> provider8, Provider<Mapper<ButtonStyle, InternalButtonState>> provider9, Provider<Logger<LoggingEvent>> provider10, Provider<BillingAddressDetailsStyle> provider11) {
        return new C0335BillingAddressDetailsViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static BillingAddressDetailsViewModel newInstance(PaymentStateManager paymentStateManager, Mapper<TextLabelStyle, TextLabelViewStyle> mapper, Mapper<TextLabelStyle, TextLabelState> mapper2, Mapper<ContainerStyle, Modifier> mapper3, ImageStyleToDynamicComposableImageMapper imageStyleToDynamicComposableImageMapper, UseCase<BillingAddressDetailsStyle, BillingAddressInputComponentsContainerState> useCase, UseCase<BillingAddressDetailsStyle, BillingAddressInputComponentsViewContainerStyle> useCase2, Mapper<ButtonStyle, InternalButtonViewStyle> mapper4, Mapper<ButtonStyle, InternalButtonState> mapper5, Logger<LoggingEvent> logger, BillingAddressDetailsStyle billingAddressDetailsStyle) {
        return new BillingAddressDetailsViewModel(paymentStateManager, mapper, mapper2, mapper3, imageStyleToDynamicComposableImageMapper, useCase, useCase2, mapper4, mapper5, logger, billingAddressDetailsStyle);
    }

    public BillingAddressDetailsViewModel get() {
        return newInstance(this.paymentStateManagerProvider.get(), this.textLabelStyleMapperProvider.get(), this.textLabelStateMapperProvider.get(), this.containerMapperProvider.get(), this.imageMapperProvider.get(), this.billingAddressDetailsComponentStateUseCaseProvider.get(), this.billingAddressDetailsComponentStyleUseCaseProvider.get(), this.buttonStyleMapperProvider.get(), this.buttonStateMapperProvider.get(), this.loggerProvider.get(), this.styleProvider.get());
    }
}
