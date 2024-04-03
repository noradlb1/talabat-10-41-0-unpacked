package com.checkout.frames.screen.paymentdetails;

import androidx.annotation.VisibleForTesting;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.ui.Modifier;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.checkout.base.mapper.Mapper;
import com.checkout.base.usecase.UseCase;
import com.checkout.frames.component.provider.ComponentProvider;
import com.checkout.frames.component.provider.ComposableComponentProvider;
import com.checkout.frames.di.base.InjectionClient;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.di.screen.PaymentDetailsViewModelSubComponent;
import com.checkout.frames.logging.PaymentFormEventType;
import com.checkout.frames.mapper.ImageStyleToClickableComposableImageMapper;
import com.checkout.frames.model.request.ImageStyleToClickableImageRequest;
import com.checkout.frames.screen.manager.PaymentStateManager;
import com.checkout.frames.style.component.ScreenHeaderStyle;
import com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.ImageStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.screen.PaymentDetailsStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.utils.extensions.LoggerExtensionsKt;
import com.checkout.frames.view.TextLabelState;
import com.checkout.logging.Logger;
import com.checkout.logging.model.LoggingEvent;
import d2.h;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001:\u0001(B\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\t0\u0005\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0014\b\u0001\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019J\b\u0010%\u001a\u00020\u0011H\u0007J\b\u0010&\u001a\u00020\tH\u0002J\b\u0010'\u001a\u00020\u0007H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\t0\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/checkout/frames/screen/paymentdetails/PaymentDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "componentProvider", "Lcom/checkout/frames/component/provider/ComponentProvider;", "textLabelStyleMapper", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "Lcom/checkout/frames/style/view/TextLabelViewStyle;", "textLabelStateMapper", "Lcom/checkout/frames/view/TextLabelState;", "containerMapper", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "Landroidx/compose/ui/Modifier;", "clickableImageStyleMapper", "Lcom/checkout/frames/mapper/ImageStyleToClickableComposableImageMapper;", "closePaymentFlowUseCase", "Lcom/checkout/base/usecase/UseCase;", "", "paymentStateManager", "Lcom/checkout/frames/screen/manager/PaymentStateManager;", "logger", "Lcom/checkout/logging/Logger;", "Lcom/checkout/logging/model/LoggingEvent;", "style", "Lcom/checkout/frames/style/screen/PaymentDetailsStyle;", "(Lcom/checkout/frames/component/provider/ComponentProvider;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/frames/mapper/ImageStyleToClickableComposableImageMapper;Lcom/checkout/base/usecase/UseCase;Lcom/checkout/frames/screen/manager/PaymentStateManager;Lcom/checkout/logging/Logger;Lcom/checkout/frames/style/screen/PaymentDetailsStyle;)V", "getComponentProvider", "()Lcom/checkout/frames/component/provider/ComponentProvider;", "fieldsContainerModifier", "getFieldsContainerModifier", "()Landroidx/compose/ui/Modifier;", "headerState", "getHeaderState", "()Lcom/checkout/frames/view/TextLabelState;", "headerStyle", "getHeaderStyle", "()Lcom/checkout/frames/style/view/TextLabelViewStyle;", "onClose", "provideHeaderState", "provideHeaderViewStyle", "Factory", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PaymentDetailsViewModel extends ViewModel {
    @NotNull
    private final ImageStyleToClickableComposableImageMapper clickableImageStyleMapper;
    @NotNull
    private final UseCase<Unit, Unit> closePaymentFlowUseCase;
    @NotNull
    private final ComponentProvider componentProvider;
    @NotNull
    private final Modifier fieldsContainerModifier;
    @NotNull
    private final TextLabelState headerState = provideHeaderState();
    @NotNull
    private final TextLabelViewStyle headerStyle = provideHeaderViewStyle();
    @NotNull
    private final Logger<LoggingEvent> logger;
    @NotNull
    private final PaymentDetailsStyle style;
    @NotNull
    private final Mapper<TextLabelStyle, TextLabelState> textLabelStateMapper;
    @NotNull
    private final Mapper<TextLabelStyle, TextLabelViewStyle> textLabelStyleMapper;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J%\u0010\u000f\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/checkout/frames/screen/paymentdetails/PaymentDetailsViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/checkout/frames/di/base/InjectionClient;", "injector", "Lcom/checkout/frames/di/base/Injector;", "style", "Lcom/checkout/frames/style/screen/PaymentDetailsStyle;", "(Lcom/checkout/frames/di/base/Injector;Lcom/checkout/frames/style/screen/PaymentDetailsStyle;)V", "subComponentProvider", "Ljavax/inject/Provider;", "Lcom/checkout/frames/di/screen/PaymentDetailsViewModelSubComponent$Builder;", "getSubComponentProvider", "()Ljavax/inject/Provider;", "setSubComponentProvider", "(Ljavax/inject/Provider;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Factory implements ViewModelProvider.Factory, InjectionClient {
        @NotNull
        private final Injector injector;
        @NotNull
        private final PaymentDetailsStyle style;
        @Inject
        public Provider<PaymentDetailsViewModelSubComponent.Builder> subComponentProvider;

        public Factory(@NotNull Injector injector2, @NotNull PaymentDetailsStyle paymentDetailsStyle) {
            Intrinsics.checkNotNullParameter(injector2, "injector");
            Intrinsics.checkNotNullParameter(paymentDetailsStyle, "style");
            this.injector = injector2;
            this.style = paymentDetailsStyle;
        }

        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            this.injector.inject(this);
            T paymentDetailsViewModel = getSubComponentProvider().get().style(this.style).componentProvider(new ComposableComponentProvider(this.injector)).build().getPaymentDetailsViewModel();
            Intrinsics.checkNotNull(paymentDetailsViewModel, "null cannot be cast to non-null type T of com.checkout.frames.screen.paymentdetails.PaymentDetailsViewModel.Factory.create");
            return paymentDetailsViewModel;
        }

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return h.b(this, cls, creationExtras);
        }

        @NotNull
        public final Provider<PaymentDetailsViewModelSubComponent.Builder> getSubComponentProvider() {
            Provider<PaymentDetailsViewModelSubComponent.Builder> provider = this.subComponentProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("subComponentProvider");
            return null;
        }

        public final void setSubComponentProvider(@NotNull Provider<PaymentDetailsViewModelSubComponent.Builder> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.subComponentProvider = provider;
        }
    }

    @Inject
    public PaymentDetailsViewModel(@NotNull ComponentProvider componentProvider2, @NotNull Mapper<TextLabelStyle, TextLabelViewStyle> mapper, @NotNull Mapper<TextLabelStyle, TextLabelState> mapper2, @NotNull Mapper<ContainerStyle, Modifier> mapper3, @NotNull ImageStyleToClickableComposableImageMapper imageStyleToClickableComposableImageMapper, @NotNull @Named("cko_closePaymentFlowUseCase") UseCase<Unit, Unit> useCase, @NotNull PaymentStateManager paymentStateManager, @NotNull Logger<LoggingEvent> logger2, @NotNull PaymentDetailsStyle paymentDetailsStyle) {
        boolean z11;
        boolean z12;
        Intrinsics.checkNotNullParameter(componentProvider2, "componentProvider");
        Intrinsics.checkNotNullParameter(mapper, "textLabelStyleMapper");
        Intrinsics.checkNotNullParameter(mapper2, "textLabelStateMapper");
        Intrinsics.checkNotNullParameter(mapper3, "containerMapper");
        Intrinsics.checkNotNullParameter(imageStyleToClickableComposableImageMapper, "clickableImageStyleMapper");
        Intrinsics.checkNotNullParameter(useCase, "closePaymentFlowUseCase");
        Intrinsics.checkNotNullParameter(paymentStateManager, "paymentStateManager");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        Intrinsics.checkNotNullParameter(paymentDetailsStyle, "style");
        this.componentProvider = componentProvider2;
        this.textLabelStyleMapper = mapper;
        this.textLabelStateMapper = mapper2;
        this.clickableImageStyleMapper = imageStyleToClickableComposableImageMapper;
        this.closePaymentFlowUseCase = useCase;
        this.logger = logger2;
        this.style = paymentDetailsStyle;
        this.fieldsContainerModifier = mapper3.map(paymentDetailsStyle.getFieldsContainerStyle());
        boolean z13 = false;
        if (paymentDetailsStyle.getCvvStyle() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        AddressSummaryComponentStyle addressSummaryStyle = paymentDetailsStyle.getAddressSummaryStyle();
        if (addressSummaryStyle != null) {
            z12 = addressSummaryStyle.isOptional();
        } else {
            z12 = true;
        }
        paymentStateManager.resetPaymentState(z11, z12, paymentDetailsStyle.getAddressSummaryStyle() != null ? true : z13);
        LoggerExtensionsKt.logEventWithLocale(logger2, PaymentFormEventType.PRESENTED);
    }

    private final TextLabelState provideHeaderState() {
        ScreenHeaderStyle paymentDetailsHeaderStyle = this.style.getPaymentDetailsHeaderStyle();
        ImageStyleToClickableImageRequest imageStyleToClickableImageRequest = new ImageStyleToClickableImageRequest(paymentDetailsHeaderStyle.getBackIconStyle(), new PaymentDetailsViewModel$provideHeaderState$1$imageRequest$1(this));
        TextLabelState map = this.textLabelStateMapper.map(new TextLabelStyle(paymentDetailsHeaderStyle.getText(), paymentDetailsHeaderStyle.getTextId(), paymentDetailsHeaderStyle.getTextStyle(), (ImageStyle) null, (ImageStyle) null, paymentDetailsHeaderStyle.getContainerStyle(), 24, (DefaultConstructorMarker) null));
        map.getLeadingIcon().setValue(this.clickableImageStyleMapper.map(imageStyleToClickableImageRequest));
        return map;
    }

    private final TextLabelViewStyle provideHeaderViewStyle() {
        ScreenHeaderStyle paymentDetailsHeaderStyle = this.style.getPaymentDetailsHeaderStyle();
        TextLabelViewStyle map = this.textLabelStyleMapper.map(new TextLabelStyle(paymentDetailsHeaderStyle.getText(), paymentDetailsHeaderStyle.getTextId(), paymentDetailsHeaderStyle.getTextStyle(), (ImageStyle) null, (ImageStyle) null, paymentDetailsHeaderStyle.getContainerStyle(), 24, (DefaultConstructorMarker) null));
        map.setModifier(SizeKt.fillMaxWidth$default(map.getModifier(), 0.0f, 1, (Object) null));
        return map;
    }

    @NotNull
    public final ComponentProvider getComponentProvider() {
        return this.componentProvider;
    }

    @NotNull
    public final Modifier getFieldsContainerModifier() {
        return this.fieldsContainerModifier;
    }

    @NotNull
    public final TextLabelState getHeaderState() {
        return this.headerState;
    }

    @NotNull
    public final TextLabelViewStyle getHeaderStyle() {
        return this.headerStyle;
    }

    @VisibleForTesting
    public final void onClose() {
        LoggerExtensionsKt.logEvent(this.logger, PaymentFormEventType.CANCELED);
        this.closePaymentFlowUseCase.execute(Unit.INSTANCE);
    }
}
