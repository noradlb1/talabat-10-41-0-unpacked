package com.checkout.frames.di.component;

import com.checkout.base.model.CardScheme;
import com.checkout.base.usecase.UseCase;
import com.checkout.frames.component.addresssummary.AddressSummaryViewModel;
import com.checkout.frames.component.cardnumber.CardNumberViewModel;
import com.checkout.frames.component.cardscheme.CardSchemeViewModel;
import com.checkout.frames.component.country.CountryViewModel;
import com.checkout.frames.component.cvv.CvvViewModel;
import com.checkout.frames.component.expirydate.ExpiryDateViewModel;
import com.checkout.frames.component.paybutton.PayButtonViewModel;
import com.checkout.frames.di.module.PaymentModule;
import com.checkout.frames.di.module.StylesModule;
import com.checkout.frames.di.module.ValidationModule;
import com.checkout.frames.model.request.InternalCardTokenRequest;
import com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsViewModel;
import com.checkout.frames.screen.countrypicker.CountryPickerViewModel;
import com.checkout.frames.screen.paymentdetails.PaymentDetailsViewModel;
import com.checkout.frames.screen.paymentform.PaymentFormViewModel;
import com.checkout.logging.Logger;
import com.checkout.logging.model.LoggingEvent;
import dagger.BindsInstance;
import dagger.Component;
import java.util.List;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

@Component(modules = {ValidationModule.class, StylesModule.class, PaymentModule.class})
@Singleton
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u00002\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H&J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH&J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\tH&J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\nH&J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000bH&J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\fH&J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\rH&J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000eH&J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000fH&J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0010H&¨\u0006\u0012"}, d2 = {"Lcom/checkout/frames/di/component/FramesDIComponent;", "", "()V", "inject", "", "factory", "Lcom/checkout/frames/component/addresssummary/AddressSummaryViewModel$Factory;", "Lcom/checkout/frames/component/cardnumber/CardNumberViewModel$Factory;", "Lcom/checkout/frames/component/cardscheme/CardSchemeViewModel$Factory;", "Lcom/checkout/frames/component/country/CountryViewModel$Factory;", "Lcom/checkout/frames/component/cvv/CvvViewModel$Factory;", "Lcom/checkout/frames/component/expirydate/ExpiryDateViewModel$Factory;", "Lcom/checkout/frames/component/paybutton/PayButtonViewModel$Factory;", "Lcom/checkout/frames/screen/billingaddress/billingaddressdetails/BillingAddressDetailsViewModel$Factory;", "Lcom/checkout/frames/screen/countrypicker/CountryPickerViewModel$Factory;", "Lcom/checkout/frames/screen/paymentdetails/PaymentDetailsViewModel$Factory;", "Lcom/checkout/frames/screen/paymentform/PaymentFormViewModel$Factory;", "Builder", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class FramesDIComponent {

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H'J\u001e\u0010\b\u001a\u00020\u00002\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0005H'J\u0016\u0010\t\u001a\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH'J\u0016\u0010\f\u001a\u00020\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH'¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/checkout/frames/di/component/FramesDIComponent$Builder;", "", "build", "Lcom/checkout/frames/di/component/FramesDIComponent;", "cardTokenizationUseCase", "Lcom/checkout/base/usecase/UseCase;", "Lcom/checkout/frames/model/request/InternalCardTokenRequest;", "", "closePaymentFlowUseCase", "logger", "Lcom/checkout/logging/Logger;", "Lcom/checkout/logging/model/LoggingEvent;", "supportedCardSchemes", "supportedCardSchemeList", "", "Lcom/checkout/base/model/CardScheme;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Component.Builder
    public interface Builder {
        @NotNull
        FramesDIComponent build();

        @NotNull
        @BindsInstance
        Builder cardTokenizationUseCase(@NotNull UseCase<InternalCardTokenRequest, Unit> useCase);

        @NotNull
        @BindsInstance
        Builder closePaymentFlowUseCase(@NotNull @Named("cko_closePaymentFlowUseCase") UseCase<Unit, Unit> useCase);

        @NotNull
        @BindsInstance
        Builder logger(@NotNull Logger<LoggingEvent> logger);

        @NotNull
        @BindsInstance
        Builder supportedCardSchemes(@NotNull List<? extends CardScheme> list);
    }

    public abstract void inject(@NotNull AddressSummaryViewModel.Factory factory);

    public abstract void inject(@NotNull CardNumberViewModel.Factory factory);

    public abstract void inject(@NotNull CardSchemeViewModel.Factory factory);

    public abstract void inject(@NotNull CountryViewModel.Factory factory);

    public abstract void inject(@NotNull CvvViewModel.Factory factory);

    public abstract void inject(@NotNull ExpiryDateViewModel.Factory factory);

    public abstract void inject(@NotNull PayButtonViewModel.Factory factory);

    public abstract void inject(@NotNull BillingAddressDetailsViewModel.Factory factory);

    public abstract void inject(@NotNull CountryPickerViewModel.Factory factory);

    public abstract void inject(@NotNull PaymentDetailsViewModel.Factory factory);

    public abstract void inject(@NotNull PaymentFormViewModel.Factory factory);
}
