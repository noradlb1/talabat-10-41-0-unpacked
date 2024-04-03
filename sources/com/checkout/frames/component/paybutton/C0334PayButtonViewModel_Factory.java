package com.checkout.frames.component.paybutton;

import com.checkout.base.mapper.Mapper;
import com.checkout.base.usecase.UseCase;
import com.checkout.frames.model.request.InternalCardTokenRequest;
import com.checkout.frames.screen.manager.PaymentStateManager;
import com.checkout.frames.style.component.PayButtonComponentStyle;
import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.view.InternalButtonViewStyle;
import com.checkout.frames.view.InternalButtonState;
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
@QualifierMetadata
/* renamed from: com.checkout.frames.component.paybutton.PayButtonViewModel_Factory  reason: case insensitive filesystem */
public final class C0334PayButtonViewModel_Factory implements Factory<PayButtonViewModel> {
    private final Provider<Mapper<ButtonStyle, InternalButtonState>> buttonStateMapperProvider;
    private final Provider<Mapper<ButtonStyle, InternalButtonViewStyle>> buttonStyleMapperProvider;
    private final Provider<UseCase<InternalCardTokenRequest, Unit>> cardTokenizationUseCaseProvider;
    private final Provider<Logger<LoggingEvent>> loggerProvider;
    private final Provider<PaymentStateManager> paymentStateManagerProvider;
    private final Provider<PayButtonComponentStyle> styleProvider;

    public C0334PayButtonViewModel_Factory(Provider<PayButtonComponentStyle> provider, Provider<PaymentStateManager> provider2, Provider<UseCase<InternalCardTokenRequest, Unit>> provider3, Provider<Mapper<ButtonStyle, InternalButtonViewStyle>> provider4, Provider<Mapper<ButtonStyle, InternalButtonState>> provider5, Provider<Logger<LoggingEvent>> provider6) {
        this.styleProvider = provider;
        this.paymentStateManagerProvider = provider2;
        this.cardTokenizationUseCaseProvider = provider3;
        this.buttonStyleMapperProvider = provider4;
        this.buttonStateMapperProvider = provider5;
        this.loggerProvider = provider6;
    }

    public static C0334PayButtonViewModel_Factory create(Provider<PayButtonComponentStyle> provider, Provider<PaymentStateManager> provider2, Provider<UseCase<InternalCardTokenRequest, Unit>> provider3, Provider<Mapper<ButtonStyle, InternalButtonViewStyle>> provider4, Provider<Mapper<ButtonStyle, InternalButtonState>> provider5, Provider<Logger<LoggingEvent>> provider6) {
        return new C0334PayButtonViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static PayButtonViewModel newInstance(PayButtonComponentStyle payButtonComponentStyle, PaymentStateManager paymentStateManager, UseCase<InternalCardTokenRequest, Unit> useCase, Mapper<ButtonStyle, InternalButtonViewStyle> mapper, Mapper<ButtonStyle, InternalButtonState> mapper2, Logger<LoggingEvent> logger) {
        return new PayButtonViewModel(payButtonComponentStyle, paymentStateManager, useCase, mapper, mapper2, logger);
    }

    public PayButtonViewModel get() {
        return newInstance(this.styleProvider.get(), this.paymentStateManagerProvider.get(), this.cardTokenizationUseCaseProvider.get(), this.buttonStyleMapperProvider.get(), this.buttonStateMapperProvider.get(), this.loggerProvider.get());
    }
}
