package com.checkout.frames.di.component;

import com.checkout.base.mapper.Mapper;
import com.checkout.base.model.CardScheme;
import com.checkout.base.usecase.UseCase;
import com.checkout.frames.component.addresssummary.AddressSummaryComponentState;
import com.checkout.frames.component.addresssummary.AddressSummaryViewModel;
import com.checkout.frames.component.addresssummary.AddressSummaryViewModel_Factory_MembersInjector;
import com.checkout.frames.component.base.InputComponentState;
import com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState;
import com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentsContainerState;
import com.checkout.frames.component.cardnumber.CardNumberViewModel;
import com.checkout.frames.component.cardnumber.CardNumberViewModel_Factory_MembersInjector;
import com.checkout.frames.component.cardscheme.CardSchemeComponentState;
import com.checkout.frames.component.cardscheme.CardSchemeViewModel;
import com.checkout.frames.component.cardscheme.CardSchemeViewModel_Factory_MembersInjector;
import com.checkout.frames.component.country.CountryViewModel;
import com.checkout.frames.component.country.CountryViewModel_Factory_MembersInjector;
import com.checkout.frames.component.cvv.CvvViewModel;
import com.checkout.frames.component.cvv.CvvViewModel_Factory_MembersInjector;
import com.checkout.frames.component.expirydate.ExpiryDateViewModel;
import com.checkout.frames.component.expirydate.ExpiryDateViewModel_Factory_MembersInjector;
import com.checkout.frames.component.expirydate.model.SmartExpiryDateValidationRequest;
import com.checkout.frames.component.paybutton.PayButtonViewModel;
import com.checkout.frames.component.paybutton.PayButtonViewModel_Factory_MembersInjector;
import com.checkout.frames.component.provider.ComponentProvider;
import com.checkout.frames.di.component.AddressSummaryViewModelSubComponent;
import com.checkout.frames.di.component.BillingFormViewModelSubComponent;
import com.checkout.frames.di.component.CardNumberViewModelSubComponent;
import com.checkout.frames.di.component.CardSchemeViewModelSubComponent;
import com.checkout.frames.di.component.CountryPickerViewModelSubComponent;
import com.checkout.frames.di.component.CountryViewModelSubComponent;
import com.checkout.frames.di.component.CvvViewModelSubComponent;
import com.checkout.frames.di.component.ExpiryDateViewModelSubComponent;
import com.checkout.frames.di.component.FramesDIComponent;
import com.checkout.frames.di.component.PayButtonViewModelSubComponent;
import com.checkout.frames.di.module.AddressSummaryModule_Companion_ProvideAddressSummaryComponentStateMapperFactory;
import com.checkout.frames.di.module.AddressSummaryModule_Companion_ProvideAddressSummaryComponentStyleMapperFactory;
import com.checkout.frames.di.module.AddressSummaryModule_Companion_ProvideAddressSummarySectionStyleMapperFactory;
import com.checkout.frames.di.module.AddressSummaryModule_Companion_ProvideDividerMapperFactory;
import com.checkout.frames.di.module.BillingAddressDetailsModule_Companion_ProvideBillingAddressInputComponentsStateMapperFactory;
import com.checkout.frames.di.module.BillingAddressDetailsModule_Companion_ProvideBillingAddressInputComponentsStateUseCaseFactory;
import com.checkout.frames.di.module.BillingAddressDetailsModule_Companion_ProvideBillingAddressInputComponentsStyleMapperFactory;
import com.checkout.frames.di.module.BillingAddressDetailsModule_Companion_ProvideBillingAddressInputComponentsStyleUseCaseFactory;
import com.checkout.frames.di.module.CardSchemeModule_Companion_ProvideCardSchemeComponentStateMapperFactory;
import com.checkout.frames.di.module.CardSchemeModule_Companion_ProvideCardSchemeComponentStyleMapperFactory;
import com.checkout.frames.di.module.PaymentModule_Companion_PaymentStateManagerFactory;
import com.checkout.frames.di.module.StylesModule_Companion_ProvideButtonStateMapperFactory;
import com.checkout.frames.di.module.StylesModule_Companion_ProvideButtonStyleMapperFactory;
import com.checkout.frames.di.module.StylesModule_Companion_ProvideContainerStyleToModifierMapperFactory;
import com.checkout.frames.di.module.StylesModule_Companion_ProvideImageStyleToClickableComposableImageMapperFactory;
import com.checkout.frames.di.module.StylesModule_Companion_ProvideImageStyleToComposableImageMapperFactory;
import com.checkout.frames.di.module.StylesModule_Companion_ProvideImageStyleToDynamicComposableImageMapperFactory;
import com.checkout.frames.di.module.StylesModule_Companion_ProvideInputComponentStyleMapperFactory;
import com.checkout.frames.di.module.StylesModule_Companion_ProvideInputComponentStyleToStateMapperFactory;
import com.checkout.frames.di.module.StylesModule_Companion_ProvideInputFieldStyleToStateMapperFactory;
import com.checkout.frames.di.module.StylesModule_Companion_ProvideInputFieldStyleToViewStyleMapperFactory;
import com.checkout.frames.di.module.StylesModule_Companion_ProvideTextLabelStyleToStateMapperFactory;
import com.checkout.frames.di.module.StylesModule_Companion_ProvideTextLabelStyleToViewStyleMapperFactory;
import com.checkout.frames.di.module.ValidationModule_Companion_ProvideCardValidatorFactory;
import com.checkout.frames.di.module.ValidationModule_Companion_ProvideValidateExpiryDateUseCaseFactory;
import com.checkout.frames.di.screen.PaymentDetailsViewModelSubComponent;
import com.checkout.frames.model.request.InternalCardTokenRequest;
import com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsViewModel;
import com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsViewModel_Factory_MembersInjector;
import com.checkout.frames.screen.countrypicker.CountryPickerViewModel;
import com.checkout.frames.screen.countrypicker.CountryPickerViewModel_Factory_MembersInjector;
import com.checkout.frames.screen.manager.PaymentStateManager;
import com.checkout.frames.screen.paymentdetails.PaymentDetailsViewModel;
import com.checkout.frames.screen.paymentdetails.PaymentDetailsViewModel_Factory_MembersInjector;
import com.checkout.frames.screen.paymentform.PaymentFormViewModel;
import com.checkout.frames.screen.paymentform.PaymentFormViewModel_Factory_MembersInjector;
import com.checkout.frames.style.component.CardNumberComponentStyle;
import com.checkout.frames.style.component.CardSchemeComponentStyle;
import com.checkout.frames.style.component.CountryComponentStyle;
import com.checkout.frames.style.component.CvvComponentStyle;
import com.checkout.frames.style.component.ExpiryDateComponentStyle;
import com.checkout.frames.style.component.PayButtonComponentStyle;
import com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle;
import com.checkout.frames.style.component.addresssummary.AddressSummarySectionStyle;
import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.component.base.InputFieldStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.component.billingformdetails.BillingAddressInputComponentStyle;
import com.checkout.frames.style.screen.BillingAddressDetailsStyle;
import com.checkout.frames.style.screen.CountryPickerStyle;
import com.checkout.frames.style.screen.PaymentDetailsStyle;
import com.checkout.frames.style.view.BillingAddressInputComponentViewStyle;
import com.checkout.frames.style.view.CardSchemeComponentViewStyle;
import com.checkout.frames.style.view.InputComponentViewStyle;
import com.checkout.frames.style.view.InputFieldViewStyle;
import com.checkout.frames.style.view.InternalButtonViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.style.view.addresssummary.AddressSummaryComponentViewStyle;
import com.checkout.frames.style.view.addresssummary.AddressSummarySectionViewStyle;
import com.checkout.frames.style.view.billingformdetails.BillingAddressInputComponentsViewContainerStyle;
import com.checkout.frames.view.InputFieldState;
import com.checkout.frames.view.InternalButtonState;
import com.checkout.frames.view.TextLabelState;
import com.checkout.logging.Logger;
import com.checkout.logging.model.LoggingEvent;
import com.checkout.validation.model.ValidationResult;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.inject.Provider;
import kotlin.Unit;

@DaggerGenerated
public final class DaggerFramesDIComponent {

    public static final class AddressSummaryViewModelSubComponentBuilder implements AddressSummaryViewModelSubComponent.Builder {
        private final FramesDIComponentImpl framesDIComponentImpl;
        private AddressSummaryComponentStyle style;

        private AddressSummaryViewModelSubComponentBuilder(FramesDIComponentImpl framesDIComponentImpl2) {
            this.framesDIComponentImpl = framesDIComponentImpl2;
        }

        public AddressSummaryViewModelSubComponent build() {
            Preconditions.checkBuilderRequirement(this.style, AddressSummaryComponentStyle.class);
            return new AddressSummaryViewModelSubComponentImpl(this.framesDIComponentImpl, this.style);
        }

        public AddressSummaryViewModelSubComponentBuilder style(AddressSummaryComponentStyle addressSummaryComponentStyle) {
            this.style = (AddressSummaryComponentStyle) Preconditions.checkNotNull(addressSummaryComponentStyle);
            return this;
        }
    }

    public static final class AddressSummaryViewModelSubComponentImpl implements AddressSummaryViewModelSubComponent {
        private final AddressSummaryViewModelSubComponentImpl addressSummaryViewModelSubComponentImpl;
        private final FramesDIComponentImpl framesDIComponentImpl;
        private final AddressSummaryComponentStyle style;

        private AddressSummaryViewModelSubComponentImpl(FramesDIComponentImpl framesDIComponentImpl2, AddressSummaryComponentStyle addressSummaryComponentStyle) {
            this.addressSummaryViewModelSubComponentImpl = this;
            this.framesDIComponentImpl = framesDIComponentImpl2;
            this.style = addressSummaryComponentStyle;
        }

        private Mapper<AddressSummaryComponentStyle, AddressSummaryComponentState> mapperOfAddressSummaryComponentStyleAndAddressSummaryComponentState() {
            return AddressSummaryModule_Companion_ProvideAddressSummaryComponentStateMapperFactory.provideAddressSummaryComponentStateMapper(this.framesDIComponentImpl.mapperOfTextLabelStyleAndTextLabelState(), this.framesDIComponentImpl.mapperOfButtonStyleAndInternalButtonState());
        }

        private Mapper<AddressSummaryComponentStyle, AddressSummaryComponentViewStyle> mapperOfAddressSummaryComponentStyleAndAddressSummaryComponentViewStyle() {
            return AddressSummaryModule_Companion_ProvideAddressSummaryComponentStyleMapperFactory.provideAddressSummaryComponentStyleMapper(this.framesDIComponentImpl.mapperOfTextLabelStyleAndTextLabelViewStyle(), this.framesDIComponentImpl.mapperOfButtonStyleAndInternalButtonViewStyle(), mapperOfAddressSummarySectionStyleAndAddressSummarySectionViewStyle(), StylesModule_Companion_ProvideContainerStyleToModifierMapperFactory.provideContainerStyleToModifierMapper());
        }

        private Mapper<AddressSummarySectionStyle, AddressSummarySectionViewStyle> mapperOfAddressSummarySectionStyleAndAddressSummarySectionViewStyle() {
            return AddressSummaryModule_Companion_ProvideAddressSummarySectionStyleMapperFactory.provideAddressSummarySectionStyleMapper(this.framesDIComponentImpl.mapperOfTextLabelStyleAndTextLabelViewStyle(), AddressSummaryModule_Companion_ProvideDividerMapperFactory.provideDividerMapper(), this.framesDIComponentImpl.mapperOfButtonStyleAndInternalButtonViewStyle(), StylesModule_Companion_ProvideContainerStyleToModifierMapperFactory.provideContainerStyleToModifierMapper());
        }

        public AddressSummaryViewModel getAddressSummaryViewModel() {
            return new AddressSummaryViewModel(this.style, (PaymentStateManager) this.framesDIComponentImpl.paymentStateManagerProvider.get(), mapperOfAddressSummaryComponentStyleAndAddressSummaryComponentState(), mapperOfAddressSummaryComponentStyleAndAddressSummaryComponentViewStyle());
        }
    }

    public static final class BillingFormViewModelSubComponentBuilder implements BillingFormViewModelSubComponent.Builder {
        private final FramesDIComponentImpl framesDIComponentImpl;
        private BillingAddressDetailsStyle style;

        private BillingFormViewModelSubComponentBuilder(FramesDIComponentImpl framesDIComponentImpl2) {
            this.framesDIComponentImpl = framesDIComponentImpl2;
        }

        public BillingFormViewModelSubComponent build() {
            Preconditions.checkBuilderRequirement(this.style, BillingAddressDetailsStyle.class);
            return new BillingFormViewModelSubComponentImpl(this.framesDIComponentImpl, this.style);
        }

        public BillingFormViewModelSubComponentBuilder style(BillingAddressDetailsStyle billingAddressDetailsStyle) {
            this.style = (BillingAddressDetailsStyle) Preconditions.checkNotNull(billingAddressDetailsStyle);
            return this;
        }
    }

    public static final class BillingFormViewModelSubComponentImpl implements BillingFormViewModelSubComponent {
        private final BillingFormViewModelSubComponentImpl billingFormViewModelSubComponentImpl;
        private final FramesDIComponentImpl framesDIComponentImpl;
        private final BillingAddressDetailsStyle style;

        private BillingFormViewModelSubComponentImpl(FramesDIComponentImpl framesDIComponentImpl2, BillingAddressDetailsStyle billingAddressDetailsStyle) {
            this.billingFormViewModelSubComponentImpl = this;
            this.framesDIComponentImpl = framesDIComponentImpl2;
            this.style = billingAddressDetailsStyle;
        }

        private Mapper<BillingAddressInputComponentStyle, BillingAddressInputComponentState> mapperOfBillingAddressInputComponentStyleAndBillingAddressInputComponentState() {
            return BillingAddressDetailsModule_Companion_ProvideBillingAddressInputComponentsStateMapperFactory.provideBillingAddressInputComponentsStateMapper(this.framesDIComponentImpl.mapperOfInputComponentStyleAndInputComponentState());
        }

        private Mapper<BillingAddressInputComponentStyle, BillingAddressInputComponentViewStyle> mapperOfBillingAddressInputComponentStyleAndBillingAddressInputComponentViewStyle() {
            return BillingAddressDetailsModule_Companion_ProvideBillingAddressInputComponentsStyleMapperFactory.provideBillingAddressInputComponentsStyleMapper(this.framesDIComponentImpl.mapperOfInputComponentStyleAndInputComponentViewStyle());
        }

        private UseCase<BillingAddressDetailsStyle, BillingAddressInputComponentsContainerState> useCaseOfBillingAddressDetailsStyleAndBillingAddressInputComponentsContainerState() {
            return BillingAddressDetailsModule_Companion_ProvideBillingAddressInputComponentsStateUseCaseFactory.provideBillingAddressInputComponentsStateUseCase(mapperOfBillingAddressInputComponentStyleAndBillingAddressInputComponentState());
        }

        private UseCase<BillingAddressDetailsStyle, BillingAddressInputComponentsViewContainerStyle> useCaseOfBillingAddressDetailsStyleAndBillingAddressInputComponentsViewContainerStyle() {
            return BillingAddressDetailsModule_Companion_ProvideBillingAddressInputComponentsStyleUseCaseFactory.provideBillingAddressInputComponentsStyleUseCase(mapperOfBillingAddressInputComponentStyleAndBillingAddressInputComponentViewStyle());
        }

        public BillingAddressDetailsViewModel getBillingAddressDetailsViewModel() {
            return new BillingAddressDetailsViewModel((PaymentStateManager) this.framesDIComponentImpl.paymentStateManagerProvider.get(), this.framesDIComponentImpl.mapperOfTextLabelStyleAndTextLabelViewStyle(), this.framesDIComponentImpl.mapperOfTextLabelStyleAndTextLabelState(), StylesModule_Companion_ProvideContainerStyleToModifierMapperFactory.provideContainerStyleToModifierMapper(), StylesModule_Companion_ProvideImageStyleToDynamicComposableImageMapperFactory.provideImageStyleToDynamicComposableImageMapper(), useCaseOfBillingAddressDetailsStyleAndBillingAddressInputComponentsContainerState(), useCaseOfBillingAddressDetailsStyleAndBillingAddressInputComponentsViewContainerStyle(), this.framesDIComponentImpl.mapperOfButtonStyleAndInternalButtonViewStyle(), this.framesDIComponentImpl.mapperOfButtonStyleAndInternalButtonState(), this.framesDIComponentImpl.logger, this.style);
        }
    }

    public static final class Builder implements FramesDIComponent.Builder {
        private UseCase<InternalCardTokenRequest, Unit> cardTokenizationUseCase;
        private UseCase<Unit, Unit> closePaymentFlowUseCase;
        private Logger<LoggingEvent> logger;
        private List<? extends CardScheme> supportedCardSchemes;

        private Builder() {
        }

        public FramesDIComponent build() {
            Class<UseCase> cls = UseCase.class;
            Preconditions.checkBuilderRequirement(this.cardTokenizationUseCase, cls);
            Preconditions.checkBuilderRequirement(this.closePaymentFlowUseCase, cls);
            Preconditions.checkBuilderRequirement(this.logger, Logger.class);
            Preconditions.checkBuilderRequirement(this.supportedCardSchemes, List.class);
            return new FramesDIComponentImpl(this.cardTokenizationUseCase, this.closePaymentFlowUseCase, this.logger, this.supportedCardSchemes);
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [com.checkout.base.usecase.UseCase<com.checkout.frames.model.request.InternalCardTokenRequest, kotlin.Unit>, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.checkout.frames.di.component.DaggerFramesDIComponent.Builder cardTokenizationUseCase(com.checkout.base.usecase.UseCase<com.checkout.frames.model.request.InternalCardTokenRequest, kotlin.Unit> r1) {
            /*
                r0 = this;
                java.lang.Object r1 = dagger.internal.Preconditions.checkNotNull(r1)
                com.checkout.base.usecase.UseCase r1 = (com.checkout.base.usecase.UseCase) r1
                r0.cardTokenizationUseCase = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.di.component.DaggerFramesDIComponent.Builder.cardTokenizationUseCase(com.checkout.base.usecase.UseCase):com.checkout.frames.di.component.DaggerFramesDIComponent$Builder");
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [com.checkout.base.usecase.UseCase<kotlin.Unit, kotlin.Unit>, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.checkout.frames.di.component.DaggerFramesDIComponent.Builder closePaymentFlowUseCase(com.checkout.base.usecase.UseCase<kotlin.Unit, kotlin.Unit> r1) {
            /*
                r0 = this;
                java.lang.Object r1 = dagger.internal.Preconditions.checkNotNull(r1)
                com.checkout.base.usecase.UseCase r1 = (com.checkout.base.usecase.UseCase) r1
                r0.closePaymentFlowUseCase = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.di.component.DaggerFramesDIComponent.Builder.closePaymentFlowUseCase(com.checkout.base.usecase.UseCase):com.checkout.frames.di.component.DaggerFramesDIComponent$Builder");
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [com.checkout.logging.Logger<com.checkout.logging.model.LoggingEvent>, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.checkout.frames.di.component.DaggerFramesDIComponent.Builder logger(com.checkout.logging.Logger<com.checkout.logging.model.LoggingEvent> r1) {
            /*
                r0 = this;
                java.lang.Object r1 = dagger.internal.Preconditions.checkNotNull(r1)
                com.checkout.logging.Logger r1 = (com.checkout.logging.Logger) r1
                r0.logger = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.di.component.DaggerFramesDIComponent.Builder.logger(com.checkout.logging.Logger):com.checkout.frames.di.component.DaggerFramesDIComponent$Builder");
        }

        public Builder supportedCardSchemes(List<? extends CardScheme> list) {
            this.supportedCardSchemes = (List) Preconditions.checkNotNull(list);
            return this;
        }
    }

    public static final class CardNumberViewModelSubComponentBuilder implements CardNumberViewModelSubComponent.Builder {
        private final FramesDIComponentImpl framesDIComponentImpl;
        private CardNumberComponentStyle style;

        private CardNumberViewModelSubComponentBuilder(FramesDIComponentImpl framesDIComponentImpl2) {
            this.framesDIComponentImpl = framesDIComponentImpl2;
        }

        public CardNumberViewModelSubComponent build() {
            Preconditions.checkBuilderRequirement(this.style, CardNumberComponentStyle.class);
            return new CardNumberViewModelSubComponentImpl(this.framesDIComponentImpl, this.style);
        }

        public CardNumberViewModelSubComponentBuilder style(CardNumberComponentStyle cardNumberComponentStyle) {
            this.style = (CardNumberComponentStyle) Preconditions.checkNotNull(cardNumberComponentStyle);
            return this;
        }
    }

    public static final class CardNumberViewModelSubComponentImpl implements CardNumberViewModelSubComponent {
        private final CardNumberViewModelSubComponentImpl cardNumberViewModelSubComponentImpl;
        private final FramesDIComponentImpl framesDIComponentImpl;
        private final CardNumberComponentStyle style;

        private CardNumberViewModelSubComponentImpl(FramesDIComponentImpl framesDIComponentImpl2, CardNumberComponentStyle cardNumberComponentStyle) {
            this.cardNumberViewModelSubComponentImpl = this;
            this.framesDIComponentImpl = framesDIComponentImpl2;
            this.style = cardNumberComponentStyle;
        }

        public CardNumberViewModel getCardNumberViewModel() {
            return new CardNumberViewModel((PaymentStateManager) this.framesDIComponentImpl.paymentStateManagerProvider.get(), ValidationModule_Companion_ProvideCardValidatorFactory.provideCardValidator(), this.framesDIComponentImpl.mapperOfInputComponentStyleAndInputComponentViewStyle(), this.framesDIComponentImpl.mapperOfInputComponentStyleAndInputComponentState(), StylesModule_Companion_ProvideImageStyleToDynamicComposableImageMapperFactory.provideImageStyleToDynamicComposableImageMapper(), this.style);
        }
    }

    public static final class CardSchemeViewModelSubComponentBuilder implements CardSchemeViewModelSubComponent.Builder {
        private final FramesDIComponentImpl framesDIComponentImpl;
        private CardSchemeComponentStyle style;

        private CardSchemeViewModelSubComponentBuilder(FramesDIComponentImpl framesDIComponentImpl2) {
            this.framesDIComponentImpl = framesDIComponentImpl2;
        }

        public CardSchemeViewModelSubComponent build() {
            Preconditions.checkBuilderRequirement(this.style, CardSchemeComponentStyle.class);
            return new CardSchemeViewModelSubComponentImpl(this.framesDIComponentImpl, this.style);
        }

        public CardSchemeViewModelSubComponentBuilder style(CardSchemeComponentStyle cardSchemeComponentStyle) {
            this.style = (CardSchemeComponentStyle) Preconditions.checkNotNull(cardSchemeComponentStyle);
            return this;
        }
    }

    public static final class CardSchemeViewModelSubComponentImpl implements CardSchemeViewModelSubComponent {
        private final CardSchemeViewModelSubComponentImpl cardSchemeViewModelSubComponentImpl;
        private final FramesDIComponentImpl framesDIComponentImpl;
        private final CardSchemeComponentStyle style;

        private CardSchemeViewModelSubComponentImpl(FramesDIComponentImpl framesDIComponentImpl2, CardSchemeComponentStyle cardSchemeComponentStyle) {
            this.cardSchemeViewModelSubComponentImpl = this;
            this.framesDIComponentImpl = framesDIComponentImpl2;
            this.style = cardSchemeComponentStyle;
        }

        private Mapper<CardSchemeComponentStyle, CardSchemeComponentState> mapperOfCardSchemeComponentStyleAndCardSchemeComponentState() {
            return CardSchemeModule_Companion_ProvideCardSchemeComponentStateMapperFactory.provideCardSchemeComponentStateMapper(this.framesDIComponentImpl.mapperOfTextLabelStyleAndTextLabelState());
        }

        private Mapper<CardSchemeComponentStyle, CardSchemeComponentViewStyle> mapperOfCardSchemeComponentStyleAndCardSchemeComponentViewStyle() {
            return CardSchemeModule_Companion_ProvideCardSchemeComponentStyleMapperFactory.provideCardSchemeComponentStyleMapper(this.framesDIComponentImpl.mapperOfTextLabelStyleAndTextLabelViewStyle(), StylesModule_Companion_ProvideContainerStyleToModifierMapperFactory.provideContainerStyleToModifierMapper());
        }

        public CardSchemeViewModel getCardSchemeViewModel() {
            return new CardSchemeViewModel((PaymentStateManager) this.framesDIComponentImpl.paymentStateManagerProvider.get(), mapperOfCardSchemeComponentStyleAndCardSchemeComponentViewStyle(), mapperOfCardSchemeComponentStyleAndCardSchemeComponentState(), StylesModule_Companion_ProvideImageStyleToComposableImageMapperFactory.provideImageStyleToComposableImageMapper(), this.style);
        }
    }

    public static final class CountryPickerViewModelSubComponentBuilder implements CountryPickerViewModelSubComponent.Builder {
        private final FramesDIComponentImpl framesDIComponentImpl;
        private CountryPickerStyle style;

        private CountryPickerViewModelSubComponentBuilder(FramesDIComponentImpl framesDIComponentImpl2) {
            this.framesDIComponentImpl = framesDIComponentImpl2;
        }

        public CountryPickerViewModelSubComponent build() {
            Preconditions.checkBuilderRequirement(this.style, CountryPickerStyle.class);
            return new CountryPickerViewModelSubComponentImpl(this.framesDIComponentImpl, this.style);
        }

        public CountryPickerViewModelSubComponentBuilder style(CountryPickerStyle countryPickerStyle) {
            this.style = (CountryPickerStyle) Preconditions.checkNotNull(countryPickerStyle);
            return this;
        }
    }

    public static final class CountryPickerViewModelSubComponentImpl implements CountryPickerViewModelSubComponent {
        private final CountryPickerViewModelSubComponentImpl countryPickerViewModelSubComponentImpl;
        private final FramesDIComponentImpl framesDIComponentImpl;
        private final CountryPickerStyle style;

        private CountryPickerViewModelSubComponentImpl(FramesDIComponentImpl framesDIComponentImpl2, CountryPickerStyle countryPickerStyle) {
            this.countryPickerViewModelSubComponentImpl = this;
            this.framesDIComponentImpl = framesDIComponentImpl2;
            this.style = countryPickerStyle;
        }

        public CountryPickerViewModel getCountryPickerViewModel() {
            return new CountryPickerViewModel((PaymentStateManager) this.framesDIComponentImpl.paymentStateManagerProvider.get(), this.framesDIComponentImpl.mapperOfInputFieldStyleAndInputFieldViewStyle(), this.framesDIComponentImpl.mapperOfInputFieldStyleAndInputFieldState(), this.framesDIComponentImpl.mapperOfTextLabelStyleAndTextLabelViewStyle(), this.framesDIComponentImpl.mapperOfTextLabelStyleAndTextLabelState(), StylesModule_Companion_ProvideContainerStyleToModifierMapperFactory.provideContainerStyleToModifierMapper(), StylesModule_Companion_ProvideImageStyleToDynamicComposableImageMapperFactory.provideImageStyleToDynamicComposableImageMapper(), this.style);
        }
    }

    public static final class CountryViewModelSubComponentBuilder implements CountryViewModelSubComponent.Builder {
        private final FramesDIComponentImpl framesDIComponentImpl;
        private CountryComponentStyle style;

        private CountryViewModelSubComponentBuilder(FramesDIComponentImpl framesDIComponentImpl2) {
            this.framesDIComponentImpl = framesDIComponentImpl2;
        }

        public CountryViewModelSubComponent build() {
            Preconditions.checkBuilderRequirement(this.style, CountryComponentStyle.class);
            return new CountryViewModelSubComponentImpl(this.framesDIComponentImpl, this.style);
        }

        public CountryViewModelSubComponentBuilder style(CountryComponentStyle countryComponentStyle) {
            this.style = (CountryComponentStyle) Preconditions.checkNotNull(countryComponentStyle);
            return this;
        }
    }

    public static final class CountryViewModelSubComponentImpl implements CountryViewModelSubComponent {
        private final CountryViewModelSubComponentImpl countryViewModelSubComponentImpl;
        private final FramesDIComponentImpl framesDIComponentImpl;
        private final CountryComponentStyle style;

        private CountryViewModelSubComponentImpl(FramesDIComponentImpl framesDIComponentImpl2, CountryComponentStyle countryComponentStyle) {
            this.countryViewModelSubComponentImpl = this;
            this.framesDIComponentImpl = framesDIComponentImpl2;
            this.style = countryComponentStyle;
        }

        public CountryViewModel getCountryViewModel() {
            return new CountryViewModel((PaymentStateManager) this.framesDIComponentImpl.paymentStateManagerProvider.get(), this.framesDIComponentImpl.mapperOfInputComponentStyleAndInputComponentViewStyle(), this.framesDIComponentImpl.mapperOfInputComponentStyleAndInputComponentState(), this.style);
        }
    }

    public static final class CvvViewModelSubComponentBuilder implements CvvViewModelSubComponent.Builder {
        private final FramesDIComponentImpl framesDIComponentImpl;
        private CvvComponentStyle style;

        private CvvViewModelSubComponentBuilder(FramesDIComponentImpl framesDIComponentImpl2) {
            this.framesDIComponentImpl = framesDIComponentImpl2;
        }

        public CvvViewModelSubComponent build() {
            Preconditions.checkBuilderRequirement(this.style, CvvComponentStyle.class);
            return new CvvViewModelSubComponentImpl(this.framesDIComponentImpl, this.style);
        }

        public CvvViewModelSubComponentBuilder style(CvvComponentStyle cvvComponentStyle) {
            this.style = (CvvComponentStyle) Preconditions.checkNotNull(cvvComponentStyle);
            return this;
        }
    }

    public static final class CvvViewModelSubComponentImpl implements CvvViewModelSubComponent {
        private final CvvViewModelSubComponentImpl cvvViewModelSubComponentImpl;
        private final FramesDIComponentImpl framesDIComponentImpl;
        private final CvvComponentStyle style;

        private CvvViewModelSubComponentImpl(FramesDIComponentImpl framesDIComponentImpl2, CvvComponentStyle cvvComponentStyle) {
            this.cvvViewModelSubComponentImpl = this;
            this.framesDIComponentImpl = framesDIComponentImpl2;
            this.style = cvvComponentStyle;
        }

        public CvvViewModel getCvvViewModel() {
            return new CvvViewModel((PaymentStateManager) this.framesDIComponentImpl.paymentStateManagerProvider.get(), ValidationModule_Companion_ProvideCardValidatorFactory.provideCardValidator(), this.framesDIComponentImpl.mapperOfInputComponentStyleAndInputComponentViewStyle(), this.framesDIComponentImpl.mapperOfInputComponentStyleAndInputComponentState(), this.style);
        }
    }

    public static final class ExpiryDateViewModelSubComponentBuilder implements ExpiryDateViewModelSubComponent.Builder {
        private final FramesDIComponentImpl framesDIComponentImpl;
        private ExpiryDateComponentStyle style;

        private ExpiryDateViewModelSubComponentBuilder(FramesDIComponentImpl framesDIComponentImpl2) {
            this.framesDIComponentImpl = framesDIComponentImpl2;
        }

        public ExpiryDateViewModelSubComponent build() {
            Preconditions.checkBuilderRequirement(this.style, ExpiryDateComponentStyle.class);
            return new ExpiryDateViewModelSubComponentImpl(this.framesDIComponentImpl, this.style);
        }

        public ExpiryDateViewModelSubComponentBuilder style(ExpiryDateComponentStyle expiryDateComponentStyle) {
            this.style = (ExpiryDateComponentStyle) Preconditions.checkNotNull(expiryDateComponentStyle);
            return this;
        }
    }

    public static final class ExpiryDateViewModelSubComponentImpl implements ExpiryDateViewModelSubComponent {
        private final ExpiryDateViewModelSubComponentImpl expiryDateViewModelSubComponentImpl;
        private final FramesDIComponentImpl framesDIComponentImpl;
        private final ExpiryDateComponentStyle style;

        private ExpiryDateViewModelSubComponentImpl(FramesDIComponentImpl framesDIComponentImpl2, ExpiryDateComponentStyle expiryDateComponentStyle) {
            this.expiryDateViewModelSubComponentImpl = this;
            this.framesDIComponentImpl = framesDIComponentImpl2;
            this.style = expiryDateComponentStyle;
        }

        public ExpiryDateViewModel getExpiryDateViewModel() {
            return new ExpiryDateViewModel((PaymentStateManager) this.framesDIComponentImpl.paymentStateManagerProvider.get(), this.framesDIComponentImpl.useCaseOfSmartExpiryDateValidationRequestAndValidationResultOfString(), this.framesDIComponentImpl.mapperOfInputComponentStyleAndInputComponentViewStyle(), this.framesDIComponentImpl.mapperOfInputComponentStyleAndInputComponentState(), this.style);
        }
    }

    public static final class FramesDIComponentImpl extends FramesDIComponent {
        private Provider<AddressSummaryViewModelSubComponent.Builder> addressSummaryViewModelSubComponentBuilderProvider;
        private Provider<BillingFormViewModelSubComponent.Builder> billingFormViewModelSubComponentBuilderProvider;
        private Provider<CardNumberViewModelSubComponent.Builder> cardNumberViewModelSubComponentBuilderProvider;
        private Provider<CardSchemeViewModelSubComponent.Builder> cardSchemeViewModelSubComponentBuilderProvider;
        /* access modifiers changed from: private */
        public final UseCase<InternalCardTokenRequest, Unit> cardTokenizationUseCase;
        /* access modifiers changed from: private */
        public final UseCase<Unit, Unit> closePaymentFlowUseCase;
        private Provider<CountryPickerViewModelSubComponent.Builder> countryPickerViewModelSubComponentBuilderProvider;
        private Provider<CountryViewModelSubComponent.Builder> countryViewModelSubComponentBuilderProvider;
        private Provider<CvvViewModelSubComponent.Builder> cvvViewModelSubComponentBuilderProvider;
        private Provider<ExpiryDateViewModelSubComponent.Builder> expiryDateViewModelSubComponentBuilderProvider;
        /* access modifiers changed from: private */
        public final FramesDIComponentImpl framesDIComponentImpl;
        /* access modifiers changed from: private */
        public final Logger<LoggingEvent> logger;
        private Provider<PayButtonViewModelSubComponent.Builder> payButtonViewModelSubComponentBuilderProvider;
        private Provider<PaymentDetailsViewModelSubComponent.Builder> paymentDetailsViewModelSubComponentBuilderProvider;
        /* access modifiers changed from: private */
        public Provider<PaymentStateManager> paymentStateManagerProvider;
        private Provider<List<? extends CardScheme>> supportedCardSchemesProvider;

        private FramesDIComponentImpl(UseCase<InternalCardTokenRequest, Unit> useCase, UseCase<Unit, Unit> useCase2, Logger<LoggingEvent> logger2, List<? extends CardScheme> list) {
            this.framesDIComponentImpl = this;
            this.closePaymentFlowUseCase = useCase2;
            this.logger = logger2;
            this.cardTokenizationUseCase = useCase;
            initialize(useCase, useCase2, logger2, list);
        }

        private void initialize(UseCase<InternalCardTokenRequest, Unit> useCase, UseCase<Unit, Unit> useCase2, Logger<LoggingEvent> logger2, List<? extends CardScheme> list) {
            this.paymentDetailsViewModelSubComponentBuilderProvider = new Provider<PaymentDetailsViewModelSubComponent.Builder>() {
                public PaymentDetailsViewModelSubComponent.Builder get() {
                    return new PaymentDetailsViewModelSubComponentBuilder(FramesDIComponentImpl.this.framesDIComponentImpl);
                }
            };
            this.countryPickerViewModelSubComponentBuilderProvider = new Provider<CountryPickerViewModelSubComponent.Builder>() {
                public CountryPickerViewModelSubComponent.Builder get() {
                    return new CountryPickerViewModelSubComponentBuilder(FramesDIComponentImpl.this.framesDIComponentImpl);
                }
            };
            this.billingFormViewModelSubComponentBuilderProvider = new Provider<BillingFormViewModelSubComponent.Builder>() {
                public BillingFormViewModelSubComponent.Builder get() {
                    return new BillingFormViewModelSubComponentBuilder(FramesDIComponentImpl.this.framesDIComponentImpl);
                }
            };
            this.cardNumberViewModelSubComponentBuilderProvider = new Provider<CardNumberViewModelSubComponent.Builder>() {
                public CardNumberViewModelSubComponent.Builder get() {
                    return new CardNumberViewModelSubComponentBuilder(FramesDIComponentImpl.this.framesDIComponentImpl);
                }
            };
            this.cvvViewModelSubComponentBuilderProvider = new Provider<CvvViewModelSubComponent.Builder>() {
                public CvvViewModelSubComponent.Builder get() {
                    return new CvvViewModelSubComponentBuilder(FramesDIComponentImpl.this.framesDIComponentImpl);
                }
            };
            this.expiryDateViewModelSubComponentBuilderProvider = new Provider<ExpiryDateViewModelSubComponent.Builder>() {
                public ExpiryDateViewModelSubComponent.Builder get() {
                    return new ExpiryDateViewModelSubComponentBuilder(FramesDIComponentImpl.this.framesDIComponentImpl);
                }
            };
            this.cardSchemeViewModelSubComponentBuilderProvider = new Provider<CardSchemeViewModelSubComponent.Builder>() {
                public CardSchemeViewModelSubComponent.Builder get() {
                    return new CardSchemeViewModelSubComponentBuilder(FramesDIComponentImpl.this.framesDIComponentImpl);
                }
            };
            this.countryViewModelSubComponentBuilderProvider = new Provider<CountryViewModelSubComponent.Builder>() {
                public CountryViewModelSubComponent.Builder get() {
                    return new CountryViewModelSubComponentBuilder(FramesDIComponentImpl.this.framesDIComponentImpl);
                }
            };
            this.addressSummaryViewModelSubComponentBuilderProvider = new Provider<AddressSummaryViewModelSubComponent.Builder>() {
                public AddressSummaryViewModelSubComponent.Builder get() {
                    return new AddressSummaryViewModelSubComponentBuilder(FramesDIComponentImpl.this.framesDIComponentImpl);
                }
            };
            this.payButtonViewModelSubComponentBuilderProvider = new Provider<PayButtonViewModelSubComponent.Builder>() {
                public PayButtonViewModelSubComponent.Builder get() {
                    return new PayButtonViewModelSubComponentBuilder(FramesDIComponentImpl.this.framesDIComponentImpl);
                }
            };
            Factory<T> create = InstanceFactory.create(list);
            this.supportedCardSchemesProvider = create;
            this.paymentStateManagerProvider = DoubleCheck.provider(PaymentModule_Companion_PaymentStateManagerFactory.create(create));
        }

        private PaymentFormViewModel.Factory injectFactory(PaymentFormViewModel.Factory factory) {
            PaymentFormViewModel_Factory_MembersInjector.injectViewModel(factory, new PaymentFormViewModel());
            return factory;
        }

        private AddressSummaryViewModel.Factory injectFactory10(AddressSummaryViewModel.Factory factory) {
            AddressSummaryViewModel_Factory_MembersInjector.injectSubComponentProvider(factory, this.addressSummaryViewModelSubComponentBuilderProvider);
            return factory;
        }

        private PayButtonViewModel.Factory injectFactory11(PayButtonViewModel.Factory factory) {
            PayButtonViewModel_Factory_MembersInjector.injectSubComponentProvider(factory, this.payButtonViewModelSubComponentBuilderProvider);
            return factory;
        }

        private PaymentDetailsViewModel.Factory injectFactory2(PaymentDetailsViewModel.Factory factory) {
            PaymentDetailsViewModel_Factory_MembersInjector.injectSubComponentProvider(factory, this.paymentDetailsViewModelSubComponentBuilderProvider);
            return factory;
        }

        private CountryPickerViewModel.Factory injectFactory3(CountryPickerViewModel.Factory factory) {
            CountryPickerViewModel_Factory_MembersInjector.injectSubComponentProvider(factory, this.countryPickerViewModelSubComponentBuilderProvider);
            return factory;
        }

        private BillingAddressDetailsViewModel.Factory injectFactory4(BillingAddressDetailsViewModel.Factory factory) {
            BillingAddressDetailsViewModel_Factory_MembersInjector.injectSubComponentProvider(factory, this.billingFormViewModelSubComponentBuilderProvider);
            return factory;
        }

        private CardNumberViewModel.Factory injectFactory5(CardNumberViewModel.Factory factory) {
            CardNumberViewModel_Factory_MembersInjector.injectSubComponentProvider(factory, this.cardNumberViewModelSubComponentBuilderProvider);
            return factory;
        }

        private CvvViewModel.Factory injectFactory6(CvvViewModel.Factory factory) {
            CvvViewModel_Factory_MembersInjector.injectSubComponentProvider(factory, this.cvvViewModelSubComponentBuilderProvider);
            return factory;
        }

        private ExpiryDateViewModel.Factory injectFactory7(ExpiryDateViewModel.Factory factory) {
            ExpiryDateViewModel_Factory_MembersInjector.injectSubComponentProvider(factory, this.expiryDateViewModelSubComponentBuilderProvider);
            return factory;
        }

        private CardSchemeViewModel.Factory injectFactory8(CardSchemeViewModel.Factory factory) {
            CardSchemeViewModel_Factory_MembersInjector.injectSubComponentProvider(factory, this.cardSchemeViewModelSubComponentBuilderProvider);
            return factory;
        }

        private CountryViewModel.Factory injectFactory9(CountryViewModel.Factory factory) {
            CountryViewModel_Factory_MembersInjector.injectSubComponentProvider(factory, this.countryViewModelSubComponentBuilderProvider);
            return factory;
        }

        /* access modifiers changed from: private */
        public Mapper<ButtonStyle, InternalButtonState> mapperOfButtonStyleAndInternalButtonState() {
            return StylesModule_Companion_ProvideButtonStateMapperFactory.provideButtonStateMapper(mapperOfTextLabelStyleAndTextLabelState());
        }

        /* access modifiers changed from: private */
        public Mapper<ButtonStyle, InternalButtonViewStyle> mapperOfButtonStyleAndInternalButtonViewStyle() {
            return StylesModule_Companion_ProvideButtonStyleMapperFactory.provideButtonStyleMapper(mapperOfTextLabelStyleAndTextLabelViewStyle(), StylesModule_Companion_ProvideContainerStyleToModifierMapperFactory.provideContainerStyleToModifierMapper());
        }

        /* access modifiers changed from: private */
        public Mapper<InputComponentStyle, InputComponentState> mapperOfInputComponentStyleAndInputComponentState() {
            return StylesModule_Companion_ProvideInputComponentStyleToStateMapperFactory.provideInputComponentStyleToStateMapper(mapperOfTextLabelStyleAndTextLabelState(), mapperOfInputFieldStyleAndInputFieldState());
        }

        /* access modifiers changed from: private */
        public Mapper<InputComponentStyle, InputComponentViewStyle> mapperOfInputComponentStyleAndInputComponentViewStyle() {
            return StylesModule_Companion_ProvideInputComponentStyleMapperFactory.provideInputComponentStyleMapper(mapperOfTextLabelStyleAndTextLabelViewStyle(), mapperOfInputFieldStyleAndInputFieldViewStyle(), StylesModule_Companion_ProvideContainerStyleToModifierMapperFactory.provideContainerStyleToModifierMapper());
        }

        /* access modifiers changed from: private */
        public Mapper<InputFieldStyle, InputFieldState> mapperOfInputFieldStyleAndInputFieldState() {
            return StylesModule_Companion_ProvideInputFieldStyleToStateMapperFactory.provideInputFieldStyleToStateMapper(StylesModule_Companion_ProvideImageStyleToComposableImageMapperFactory.provideImageStyleToComposableImageMapper());
        }

        /* access modifiers changed from: private */
        public Mapper<InputFieldStyle, InputFieldViewStyle> mapperOfInputFieldStyleAndInputFieldViewStyle() {
            return StylesModule_Companion_ProvideInputFieldStyleToViewStyleMapperFactory.provideInputFieldStyleToViewStyleMapper(mapperOfTextLabelStyleAndTextLabelViewStyle());
        }

        /* access modifiers changed from: private */
        public Mapper<TextLabelStyle, TextLabelState> mapperOfTextLabelStyleAndTextLabelState() {
            return StylesModule_Companion_ProvideTextLabelStyleToStateMapperFactory.provideTextLabelStyleToStateMapper(StylesModule_Companion_ProvideImageStyleToComposableImageMapperFactory.provideImageStyleToComposableImageMapper());
        }

        /* access modifiers changed from: private */
        public Mapper<TextLabelStyle, TextLabelViewStyle> mapperOfTextLabelStyleAndTextLabelViewStyle() {
            return StylesModule_Companion_ProvideTextLabelStyleToViewStyleMapperFactory.provideTextLabelStyleToViewStyleMapper(StylesModule_Companion_ProvideContainerStyleToModifierMapperFactory.provideContainerStyleToModifierMapper());
        }

        /* access modifiers changed from: private */
        public UseCase<SmartExpiryDateValidationRequest, ValidationResult<String>> useCaseOfSmartExpiryDateValidationRequestAndValidationResultOfString() {
            return ValidationModule_Companion_ProvideValidateExpiryDateUseCaseFactory.provideValidateExpiryDateUseCase(ValidationModule_Companion_ProvideCardValidatorFactory.provideCardValidator());
        }

        public void inject(PaymentFormViewModel.Factory factory) {
            injectFactory(factory);
        }

        public void inject(PaymentDetailsViewModel.Factory factory) {
            injectFactory2(factory);
        }

        public void inject(CountryPickerViewModel.Factory factory) {
            injectFactory3(factory);
        }

        public void inject(BillingAddressDetailsViewModel.Factory factory) {
            injectFactory4(factory);
        }

        public void inject(CardNumberViewModel.Factory factory) {
            injectFactory5(factory);
        }

        public void inject(CvvViewModel.Factory factory) {
            injectFactory6(factory);
        }

        public void inject(ExpiryDateViewModel.Factory factory) {
            injectFactory7(factory);
        }

        public void inject(CardSchemeViewModel.Factory factory) {
            injectFactory8(factory);
        }

        public void inject(CountryViewModel.Factory factory) {
            injectFactory9(factory);
        }

        public void inject(AddressSummaryViewModel.Factory factory) {
            injectFactory10(factory);
        }

        public void inject(PayButtonViewModel.Factory factory) {
            injectFactory11(factory);
        }
    }

    public static final class PayButtonViewModelSubComponentBuilder implements PayButtonViewModelSubComponent.Builder {
        private final FramesDIComponentImpl framesDIComponentImpl;
        private PayButtonComponentStyle style;

        private PayButtonViewModelSubComponentBuilder(FramesDIComponentImpl framesDIComponentImpl2) {
            this.framesDIComponentImpl = framesDIComponentImpl2;
        }

        public PayButtonViewModelSubComponent build() {
            Preconditions.checkBuilderRequirement(this.style, PayButtonComponentStyle.class);
            return new PayButtonViewModelSubComponentImpl(this.framesDIComponentImpl, this.style);
        }

        public PayButtonViewModelSubComponentBuilder style(PayButtonComponentStyle payButtonComponentStyle) {
            this.style = (PayButtonComponentStyle) Preconditions.checkNotNull(payButtonComponentStyle);
            return this;
        }
    }

    public static final class PayButtonViewModelSubComponentImpl implements PayButtonViewModelSubComponent {
        private final FramesDIComponentImpl framesDIComponentImpl;
        private final PayButtonViewModelSubComponentImpl payButtonViewModelSubComponentImpl;
        private final PayButtonComponentStyle style;

        private PayButtonViewModelSubComponentImpl(FramesDIComponentImpl framesDIComponentImpl2, PayButtonComponentStyle payButtonComponentStyle) {
            this.payButtonViewModelSubComponentImpl = this;
            this.framesDIComponentImpl = framesDIComponentImpl2;
            this.style = payButtonComponentStyle;
        }

        public PayButtonViewModel getPayButtonViewModel() {
            return new PayButtonViewModel(this.style, (PaymentStateManager) this.framesDIComponentImpl.paymentStateManagerProvider.get(), this.framesDIComponentImpl.cardTokenizationUseCase, this.framesDIComponentImpl.mapperOfButtonStyleAndInternalButtonViewStyle(), this.framesDIComponentImpl.mapperOfButtonStyleAndInternalButtonState(), this.framesDIComponentImpl.logger);
        }
    }

    public static final class PaymentDetailsViewModelSubComponentBuilder implements PaymentDetailsViewModelSubComponent.Builder {
        private ComponentProvider componentProvider;
        private final FramesDIComponentImpl framesDIComponentImpl;
        private PaymentDetailsStyle style;

        private PaymentDetailsViewModelSubComponentBuilder(FramesDIComponentImpl framesDIComponentImpl2) {
            this.framesDIComponentImpl = framesDIComponentImpl2;
        }

        public PaymentDetailsViewModelSubComponent build() {
            Preconditions.checkBuilderRequirement(this.style, PaymentDetailsStyle.class);
            Preconditions.checkBuilderRequirement(this.componentProvider, ComponentProvider.class);
            return new PaymentDetailsViewModelSubComponentImpl(this.framesDIComponentImpl, this.style, this.componentProvider);
        }

        public PaymentDetailsViewModelSubComponentBuilder componentProvider(ComponentProvider componentProvider2) {
            this.componentProvider = (ComponentProvider) Preconditions.checkNotNull(componentProvider2);
            return this;
        }

        public PaymentDetailsViewModelSubComponentBuilder style(PaymentDetailsStyle paymentDetailsStyle) {
            this.style = (PaymentDetailsStyle) Preconditions.checkNotNull(paymentDetailsStyle);
            return this;
        }
    }

    public static final class PaymentDetailsViewModelSubComponentImpl implements PaymentDetailsViewModelSubComponent {
        private final ComponentProvider componentProvider;
        private final FramesDIComponentImpl framesDIComponentImpl;
        private final PaymentDetailsViewModelSubComponentImpl paymentDetailsViewModelSubComponentImpl;
        private final PaymentDetailsStyle style;

        private PaymentDetailsViewModelSubComponentImpl(FramesDIComponentImpl framesDIComponentImpl2, PaymentDetailsStyle paymentDetailsStyle, ComponentProvider componentProvider2) {
            this.paymentDetailsViewModelSubComponentImpl = this;
            this.framesDIComponentImpl = framesDIComponentImpl2;
            this.componentProvider = componentProvider2;
            this.style = paymentDetailsStyle;
        }

        public PaymentDetailsViewModel getPaymentDetailsViewModel() {
            return new PaymentDetailsViewModel(this.componentProvider, this.framesDIComponentImpl.mapperOfTextLabelStyleAndTextLabelViewStyle(), this.framesDIComponentImpl.mapperOfTextLabelStyleAndTextLabelState(), StylesModule_Companion_ProvideContainerStyleToModifierMapperFactory.provideContainerStyleToModifierMapper(), StylesModule_Companion_ProvideImageStyleToClickableComposableImageMapperFactory.provideImageStyleToClickableComposableImageMapper(), this.framesDIComponentImpl.closePaymentFlowUseCase, (PaymentStateManager) this.framesDIComponentImpl.paymentStateManagerProvider.get(), this.framesDIComponentImpl.logger, this.style);
        }
    }

    private DaggerFramesDIComponent() {
    }

    public static FramesDIComponent.Builder builder() {
        return new Builder();
    }
}
