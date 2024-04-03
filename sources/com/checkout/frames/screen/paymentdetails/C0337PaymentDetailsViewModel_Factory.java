package com.checkout.frames.screen.paymentdetails;

import androidx.compose.ui.Modifier;
import com.checkout.base.mapper.Mapper;
import com.checkout.base.usecase.UseCase;
import com.checkout.frames.component.provider.ComponentProvider;
import com.checkout.frames.mapper.ImageStyleToClickableComposableImageMapper;
import com.checkout.frames.screen.manager.PaymentStateManager;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.screen.PaymentDetailsStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.view.TextLabelState;
import com.checkout.logging.Logger;
import com.checkout.logging.model.LoggingEvent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import kotlin.Unit;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
/* renamed from: com.checkout.frames.screen.paymentdetails.PaymentDetailsViewModel_Factory  reason: case insensitive filesystem */
public final class C0337PaymentDetailsViewModel_Factory implements Factory<PaymentDetailsViewModel> {
    private final Provider<ImageStyleToClickableComposableImageMapper> clickableImageStyleMapperProvider;
    private final Provider<UseCase<Unit, Unit>> closePaymentFlowUseCaseProvider;
    private final Provider<ComponentProvider> componentProvider;
    private final Provider<Mapper<ContainerStyle, Modifier>> containerMapperProvider;
    private final Provider<Logger<LoggingEvent>> loggerProvider;
    private final Provider<PaymentStateManager> paymentStateManagerProvider;
    private final Provider<PaymentDetailsStyle> styleProvider;
    private final Provider<Mapper<TextLabelStyle, TextLabelState>> textLabelStateMapperProvider;
    private final Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> textLabelStyleMapperProvider;

    public C0337PaymentDetailsViewModel_Factory(Provider<ComponentProvider> provider, Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> provider2, Provider<Mapper<TextLabelStyle, TextLabelState>> provider3, Provider<Mapper<ContainerStyle, Modifier>> provider4, Provider<ImageStyleToClickableComposableImageMapper> provider5, Provider<UseCase<Unit, Unit>> provider6, Provider<PaymentStateManager> provider7, Provider<Logger<LoggingEvent>> provider8, Provider<PaymentDetailsStyle> provider9) {
        this.componentProvider = provider;
        this.textLabelStyleMapperProvider = provider2;
        this.textLabelStateMapperProvider = provider3;
        this.containerMapperProvider = provider4;
        this.clickableImageStyleMapperProvider = provider5;
        this.closePaymentFlowUseCaseProvider = provider6;
        this.paymentStateManagerProvider = provider7;
        this.loggerProvider = provider8;
        this.styleProvider = provider9;
    }

    public static C0337PaymentDetailsViewModel_Factory create(Provider<ComponentProvider> provider, Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> provider2, Provider<Mapper<TextLabelStyle, TextLabelState>> provider3, Provider<Mapper<ContainerStyle, Modifier>> provider4, Provider<ImageStyleToClickableComposableImageMapper> provider5, Provider<UseCase<Unit, Unit>> provider6, Provider<PaymentStateManager> provider7, Provider<Logger<LoggingEvent>> provider8, Provider<PaymentDetailsStyle> provider9) {
        return new C0337PaymentDetailsViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static PaymentDetailsViewModel newInstance(ComponentProvider componentProvider2, Mapper<TextLabelStyle, TextLabelViewStyle> mapper, Mapper<TextLabelStyle, TextLabelState> mapper2, Mapper<ContainerStyle, Modifier> mapper3, ImageStyleToClickableComposableImageMapper imageStyleToClickableComposableImageMapper, UseCase<Unit, Unit> useCase, PaymentStateManager paymentStateManager, Logger<LoggingEvent> logger, PaymentDetailsStyle paymentDetailsStyle) {
        return new PaymentDetailsViewModel(componentProvider2, mapper, mapper2, mapper3, imageStyleToClickableComposableImageMapper, useCase, paymentStateManager, logger, paymentDetailsStyle);
    }

    public PaymentDetailsViewModel get() {
        return newInstance(this.componentProvider.get(), this.textLabelStyleMapperProvider.get(), this.textLabelStateMapperProvider.get(), this.containerMapperProvider.get(), this.clickableImageStyleMapperProvider.get(), this.closePaymentFlowUseCaseProvider.get(), this.paymentStateManagerProvider.get(), this.loggerProvider.get(), this.styleProvider.get());
    }
}
