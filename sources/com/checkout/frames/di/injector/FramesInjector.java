package com.checkout.frames.di.injector;

import android.content.Context;
import com.checkout.CheckoutApiServiceFactory;
import com.checkout.base.model.CardScheme;
import com.checkout.base.model.Environment;
import com.checkout.frames.BuildConfig;
import com.checkout.frames.api.PaymentFlowHandler;
import com.checkout.frames.component.addresssummary.AddressSummaryViewModel;
import com.checkout.frames.component.cardnumber.CardNumberViewModel;
import com.checkout.frames.component.cardscheme.CardSchemeViewModel;
import com.checkout.frames.component.country.CountryViewModel;
import com.checkout.frames.component.cvv.CvvViewModel;
import com.checkout.frames.component.expirydate.ExpiryDateViewModel;
import com.checkout.frames.component.paybutton.PayButtonViewModel;
import com.checkout.frames.di.base.InjectionClient;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.di.component.DaggerFramesDIComponent;
import com.checkout.frames.di.component.FramesDIComponent;
import com.checkout.frames.logging.PaymentFormEventType;
import com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsViewModel;
import com.checkout.frames.screen.countrypicker.CountryPickerViewModel;
import com.checkout.frames.screen.paymentdetails.PaymentDetailsViewModel;
import com.checkout.frames.screen.paymentform.PaymentFormViewModel;
import com.checkout.frames.usecase.CardTokenizationUseCase;
import com.checkout.frames.usecase.ClosePaymentFlowUseCase;
import com.checkout.frames.utils.extensions.LoggerExtensionsKt;
import com.checkout.logging.EventLoggerProvider;
import com.checkout.logging.Logger;
import com.checkout.logging.model.LoggingEvent;
import com.deliveryhero.customerchat.eventTracking.constants.ContactDetailsKeys;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel;
import com.visa.checkout.Profile;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/checkout/frames/di/injector/FramesInjector;", "Lcom/checkout/frames/di/base/Injector;", "component", "Lcom/checkout/frames/di/component/FramesDIComponent;", "(Lcom/checkout/frames/di/component/FramesDIComponent;)V", "inject", "", "client", "Lcom/checkout/frames/di/base/InjectionClient;", "Companion", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FramesInjector implements Injector {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final FramesDIComponent component;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0000¢\u0006\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/checkout/frames/di/injector/FramesInjector$Companion;", "", "()V", "create", "Lcom/checkout/frames/di/base/Injector;", "publicKey", "", "context", "Landroid/content/Context;", "environment", "Lcom/checkout/base/model/Environment;", "paymentFlowHandler", "Lcom/checkout/frames/api/PaymentFlowHandler;", "supportedCardSchemeList", "", "Lcom/checkout/base/model/CardScheme;", "create$frames_release", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Injector create$frames_release$default(Companion companion, String str, Context context, Environment environment, PaymentFlowHandler paymentFlowHandler, List list, int i11, Object obj) {
            if ((i11 & 16) != 0) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            return companion.create$frames_release(str, context, environment, paymentFlowHandler, list);
        }

        @NotNull
        public final Injector create$frames_release(@NotNull String str, @NotNull Context context, @NotNull Environment environment, @NotNull PaymentFlowHandler paymentFlowHandler, @NotNull List<? extends CardScheme> list) {
            Intrinsics.checkNotNullParameter(str, "publicKey");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(environment, Profile.ENVIRONMENT);
            Intrinsics.checkNotNullParameter(paymentFlowHandler, "paymentFlowHandler");
            Intrinsics.checkNotNullParameter(list, "supportedCardSchemeList");
            Logger<LoggingEvent> provide = EventLoggerProvider.INSTANCE.provide();
            provide.setup(context, environment, BuildConfig.LOGGING_IDENTIFIER, "4.0.2");
            LoggerExtensionsKt.logEvent(provide, PaymentFormEventType.INITIALISED);
            return new FramesInjector(DaggerFramesDIComponent.builder().logger(provide).cardTokenizationUseCase(new CardTokenizationUseCase(CheckoutApiServiceFactory.create(str, environment, context), new FramesInjector$Companion$create$cardTokenizationUseCase$1(paymentFlowHandler), new FramesInjector$Companion$create$cardTokenizationUseCase$2(paymentFlowHandler), new FramesInjector$Companion$create$cardTokenizationUseCase$3(paymentFlowHandler))).closePaymentFlowUseCase(new ClosePaymentFlowUseCase(new FramesInjector$Companion$create$closePaymentFlowUseCase$1(paymentFlowHandler))).supportedCardSchemes(list).build());
        }
    }

    public FramesInjector(@NotNull FramesDIComponent framesDIComponent) {
        Intrinsics.checkNotNullParameter(framesDIComponent, FluidHomeScreenViewModel.METADATA_COMPONENT_KEY);
        this.component = framesDIComponent;
    }

    public void inject(@NotNull InjectionClient injectionClient) {
        Intrinsics.checkNotNullParameter(injectionClient, ContactDetailsKeys.SENT_FROM_VALUE);
        if (injectionClient instanceof CardNumberViewModel.Factory) {
            this.component.inject((CardNumberViewModel.Factory) injectionClient);
        } else if (injectionClient instanceof ExpiryDateViewModel.Factory) {
            this.component.inject((ExpiryDateViewModel.Factory) injectionClient);
        } else if (injectionClient instanceof CvvViewModel.Factory) {
            this.component.inject((CvvViewModel.Factory) injectionClient);
        } else if (injectionClient instanceof PaymentDetailsViewModel.Factory) {
            this.component.inject((PaymentDetailsViewModel.Factory) injectionClient);
        } else if (injectionClient instanceof PaymentFormViewModel.Factory) {
            this.component.inject((PaymentFormViewModel.Factory) injectionClient);
        } else if (injectionClient instanceof CountryViewModel.Factory) {
            this.component.inject((CountryViewModel.Factory) injectionClient);
        } else if (injectionClient instanceof CountryPickerViewModel.Factory) {
            this.component.inject((CountryPickerViewModel.Factory) injectionClient);
        } else if (injectionClient instanceof CardSchemeViewModel.Factory) {
            this.component.inject((CardSchemeViewModel.Factory) injectionClient);
        } else if (injectionClient instanceof AddressSummaryViewModel.Factory) {
            this.component.inject((AddressSummaryViewModel.Factory) injectionClient);
        } else if (injectionClient instanceof PayButtonViewModel.Factory) {
            this.component.inject((PayButtonViewModel.Factory) injectionClient);
        } else if (injectionClient instanceof BillingAddressDetailsViewModel.Factory) {
            this.component.inject((BillingAddressDetailsViewModel.Factory) injectionClient);
        } else {
            String name2 = injectionClient.getClass().getName();
            throw new IllegalArgumentException("Invalid injection request for " + name2 + RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
        }
    }
}
