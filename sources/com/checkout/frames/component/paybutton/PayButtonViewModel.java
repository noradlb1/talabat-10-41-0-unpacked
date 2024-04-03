package com.checkout.frames.component.paybutton;

import androidx.compose.foundation.layout.SizeKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.checkout.base.mapper.Mapper;
import com.checkout.base.usecase.UseCase;
import com.checkout.frames.di.base.InjectionClient;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.di.component.PayButtonViewModelSubComponent;
import com.checkout.frames.logging.PaymentFormEventType;
import com.checkout.frames.model.request.InternalCardTokenRequest;
import com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingAddress;
import com.checkout.frames.screen.manager.PaymentStateManager;
import com.checkout.frames.style.component.PayButtonComponentStyle;
import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.view.InternalButtonViewStyle;
import com.checkout.frames.utils.extensions.LoggerExtensionsKt;
import com.checkout.frames.utils.extensions.StringExtensionsKt;
import com.checkout.frames.view.InternalButtonState;
import com.checkout.logging.Logger;
import com.checkout.logging.model.LoggingEvent;
import com.checkout.tokenization.model.Address;
import com.checkout.tokenization.model.Card;
import com.checkout.tokenization.model.ExpiryDate;
import com.checkout.tokenization.model.Phone;
import d2.h;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001fBa\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000b\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\u0010\u0013J\u0006\u0010\u001a\u001a\u00020\tJ\u0006\u0010\u001b\u001a\u00020\tJ\b\u0010\u001c\u001a\u00020\rH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002R\u0011\u0010\u0014\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/checkout/frames/component/paybutton/PayButtonViewModel;", "Landroidx/lifecycle/ViewModel;", "style", "Lcom/checkout/frames/style/component/PayButtonComponentStyle;", "paymentStateManager", "Lcom/checkout/frames/screen/manager/PaymentStateManager;", "cardTokenizationUseCase", "Lcom/checkout/base/usecase/UseCase;", "Lcom/checkout/frames/model/request/InternalCardTokenRequest;", "", "buttonStyleMapper", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/base/ButtonStyle;", "Lcom/checkout/frames/style/view/InternalButtonViewStyle;", "buttonStateMapper", "Lcom/checkout/frames/view/InternalButtonState;", "logger", "Lcom/checkout/logging/Logger;", "Lcom/checkout/logging/model/LoggingEvent;", "(Lcom/checkout/frames/style/component/PayButtonComponentStyle;Lcom/checkout/frames/screen/manager/PaymentStateManager;Lcom/checkout/base/usecase/UseCase;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/logging/Logger;)V", "buttonState", "getButtonState", "()Lcom/checkout/frames/view/InternalButtonState;", "buttonStyle", "getButtonStyle", "()Lcom/checkout/frames/style/view/InternalButtonViewStyle;", "pay", "prepare", "provideButtonViewStyle", "provideCardData", "Lcom/checkout/tokenization/model/Card;", "Factory", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PayButtonViewModel extends ViewModel {
    @NotNull
    private final InternalButtonState buttonState;
    @NotNull
    private final InternalButtonViewStyle buttonStyle = provideButtonViewStyle();
    @NotNull
    private final Mapper<ButtonStyle, InternalButtonViewStyle> buttonStyleMapper;
    @NotNull
    private final UseCase<InternalCardTokenRequest, Unit> cardTokenizationUseCase;
    @NotNull
    private final Logger<LoggingEvent> logger;
    /* access modifiers changed from: private */
    @NotNull
    public final PaymentStateManager paymentStateManager;
    @NotNull
    private final PayButtonComponentStyle style;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J%\u0010\u000f\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/checkout/frames/component/paybutton/PayButtonViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/checkout/frames/di/base/InjectionClient;", "injector", "Lcom/checkout/frames/di/base/Injector;", "style", "Lcom/checkout/frames/style/component/PayButtonComponentStyle;", "(Lcom/checkout/frames/di/base/Injector;Lcom/checkout/frames/style/component/PayButtonComponentStyle;)V", "subComponentProvider", "Ljavax/inject/Provider;", "Lcom/checkout/frames/di/component/PayButtonViewModelSubComponent$Builder;", "getSubComponentProvider", "()Ljavax/inject/Provider;", "setSubComponentProvider", "(Ljavax/inject/Provider;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Factory implements ViewModelProvider.Factory, InjectionClient {
        @NotNull
        private final Injector injector;
        @NotNull
        private final PayButtonComponentStyle style;
        @Inject
        public Provider<PayButtonViewModelSubComponent.Builder> subComponentProvider;

        public Factory(@NotNull Injector injector2, @NotNull PayButtonComponentStyle payButtonComponentStyle) {
            Intrinsics.checkNotNullParameter(injector2, "injector");
            Intrinsics.checkNotNullParameter(payButtonComponentStyle, "style");
            this.injector = injector2;
            this.style = payButtonComponentStyle;
        }

        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            this.injector.inject(this);
            T payButtonViewModel = getSubComponentProvider().get().style(this.style).build().getPayButtonViewModel();
            Intrinsics.checkNotNull(payButtonViewModel, "null cannot be cast to non-null type T of com.checkout.frames.component.paybutton.PayButtonViewModel.Factory.create");
            return payButtonViewModel;
        }

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return h.b(this, cls, creationExtras);
        }

        @NotNull
        public final Provider<PayButtonViewModelSubComponent.Builder> getSubComponentProvider() {
            Provider<PayButtonViewModelSubComponent.Builder> provider = this.subComponentProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("subComponentProvider");
            return null;
        }

        public final void setSubComponentProvider(@NotNull Provider<PayButtonViewModelSubComponent.Builder> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.subComponentProvider = provider;
        }
    }

    @Inject
    public PayButtonViewModel(@NotNull PayButtonComponentStyle payButtonComponentStyle, @NotNull PaymentStateManager paymentStateManager2, @NotNull UseCase<InternalCardTokenRequest, Unit> useCase, @NotNull Mapper<ButtonStyle, InternalButtonViewStyle> mapper, @NotNull Mapper<ButtonStyle, InternalButtonState> mapper2, @NotNull Logger<LoggingEvent> logger2) {
        Intrinsics.checkNotNullParameter(payButtonComponentStyle, "style");
        Intrinsics.checkNotNullParameter(paymentStateManager2, "paymentStateManager");
        Intrinsics.checkNotNullParameter(useCase, "cardTokenizationUseCase");
        Intrinsics.checkNotNullParameter(mapper, "buttonStyleMapper");
        Intrinsics.checkNotNullParameter(mapper2, "buttonStateMapper");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        this.style = payButtonComponentStyle;
        this.paymentStateManager = paymentStateManager2;
        this.cardTokenizationUseCase = useCase;
        this.buttonStyleMapper = mapper;
        this.logger = logger2;
        this.buttonState = mapper2.map(payButtonComponentStyle.getButtonStyle());
    }

    private final InternalButtonViewStyle provideButtonViewStyle() {
        InternalButtonViewStyle map = this.buttonStyleMapper.map(this.style.getButtonStyle());
        map.setModifier(SizeKt.fillMaxWidth$default(map.getModifier(), 0.0f, 1, (Object) null));
        return map;
    }

    private final Card provideCardData() {
        boolean z11;
        String str;
        Address address;
        PaymentStateManager paymentStateManager2 = this.paymentStateManager;
        BillingAddress value = paymentStateManager2.getBillingAddress().getValue();
        BillingAddress billingAddress = value;
        if (!paymentStateManager2.isBillingAddressEnabled().getValue().booleanValue() || !BillingAddress.Companion.isEdited$frames_release(billingAddress)) {
            z11 = false;
        } else {
            z11 = true;
        }
        Phone phone = null;
        if (!z11) {
            value = null;
        }
        BillingAddress billingAddress2 = value;
        ExpiryDate expiryDate = StringExtensionsKt.toExpiryDate(paymentStateManager2.getExpiryDate().getValue());
        if (billingAddress2 != null) {
            str = billingAddress2.getName();
        } else {
            str = null;
        }
        String value2 = paymentStateManager2.getCardNumber().getValue();
        String value3 = paymentStateManager2.getCvv().getValue();
        if (billingAddress2 != null) {
            address = billingAddress2.getAddress();
        } else {
            address = null;
        }
        if (billingAddress2 != null) {
            phone = billingAddress2.getPhone();
        }
        return new Card(expiryDate, str, value2, value3, address, phone);
    }

    @NotNull
    public final InternalButtonState getButtonState() {
        return this.buttonState;
    }

    @NotNull
    public final InternalButtonViewStyle getButtonStyle() {
        return this.buttonStyle;
    }

    public final void pay() {
        PayButtonViewModel$pay$onPaymentFinished$1 payButtonViewModel$pay$onPaymentFinished$1 = new PayButtonViewModel$pay$onPaymentFinished$1(this);
        InternalCardTokenRequest internalCardTokenRequest = new InternalCardTokenRequest(provideCardData(), payButtonViewModel$pay$onPaymentFinished$1, payButtonViewModel$pay$onPaymentFinished$1);
        this.buttonState.isEnabled().setValue(Boolean.FALSE);
        LoggerExtensionsKt.logEvent(this.logger, PaymentFormEventType.SUBMITTED);
        this.cardTokenizationUseCase.execute(internalCardTokenRequest);
    }

    public final void prepare() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PayButtonViewModel$prepare$1(this, (Continuation<? super PayButtonViewModel$prepare$1>) null), 3, (Object) null);
    }
}
