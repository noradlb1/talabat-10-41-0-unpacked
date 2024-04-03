package com.checkout.frames.screen.billingaddress.billingaddressdetails;

import androidx.annotation.VisibleForTesting;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.Modifier;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.checkout.base.mapper.Mapper;
import com.checkout.base.model.Country;
import com.checkout.base.usecase.UseCase;
import com.checkout.frames.R;
import com.checkout.frames.component.base.InputComponentState;
import com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState;
import com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentsContainerState;
import com.checkout.frames.di.base.InjectionClient;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.di.component.BillingFormViewModelSubComponent;
import com.checkout.frames.logging.BillingFormEventType;
import com.checkout.frames.mapper.ImageStyleToDynamicComposableImageMapper;
import com.checkout.frames.model.request.ImageStyleToDynamicImageRequest;
import com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingFormFields;
import com.checkout.frames.screen.manager.PaymentStateManager;
import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.screen.BillingAddressDetailsStyle;
import com.checkout.frames.style.view.BillingAddressInputComponentViewStyle;
import com.checkout.frames.style.view.InternalButtonViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.style.view.billingformdetails.BillingAddressInputComponentsViewContainerStyle;
import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;
import com.checkout.frames.utils.extensions.BillingAddressDetailsExtensionsKt;
import com.checkout.frames.utils.extensions.LoggerExtensionsKt;
import com.checkout.frames.view.InputFieldState;
import com.checkout.frames.view.InternalButtonState;
import com.checkout.frames.view.TextLabelState;
import com.checkout.logging.Logger;
import com.checkout.logging.model.LoggingEvent;
import com.checkout.tokenization.model.Address;
import d2.h;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 W2\u00020\u0001:\u0002WXB»\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\t0\u0005\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u0010\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0005\u0012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00190\u0005\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0006\u0010\u001d\u001a\u00020\u0011¢\u0006\u0002\u0010\u001eJ\u000e\u0010>\u001a\b\u0012\u0004\u0012\u00020!0?H\u0002J\u0016\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EJ\b\u0010F\u001a\u00020AH\u0007J\u0016\u0010G\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010H\u001a\u00020!J\u0006\u0010I\u001a\u00020AJ\b\u0010J\u001a\u00020AH\u0007J\b\u0010K\u001a\u00020\u0019H\u0002J\u0016\u0010L\u001a\b\u0012\u0004\u0012\u00020-0%2\u0006\u0010M\u001a\u00020\u0011H\u0002J\u0016\u0010N\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010M\u001a\u00020\u0011H\u0002J\u0010\u0010O\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J\b\u0010P\u001a\u00020AH\u0002J\u001d\u0010Q\u001a\u00020A2\u0006\u0010R\u001a\u00020-2\u0006\u0010S\u001a\u00020TH\u0000¢\u0006\u0002\bUJ\b\u0010V\u001a\u00020AH\u0002R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u0010X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00190\u0005X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 ¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020-0%¢\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010/\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u00102\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u00105\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b6\u0010+R\u0011\u00107\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010:\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u000e\u0010\u001d\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\t0\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/checkout/frames/screen/billingaddress/billingaddressdetails/BillingAddressDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "paymentStateManager", "Lcom/checkout/frames/screen/manager/PaymentStateManager;", "textLabelStyleMapper", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "Lcom/checkout/frames/style/view/TextLabelViewStyle;", "textLabelStateMapper", "Lcom/checkout/frames/view/TextLabelState;", "containerMapper", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "Landroidx/compose/ui/Modifier;", "imageMapper", "Lcom/checkout/frames/mapper/ImageStyleToDynamicComposableImageMapper;", "billingAddressDetailsComponentStateUseCase", "Lcom/checkout/base/usecase/UseCase;", "Lcom/checkout/frames/style/screen/BillingAddressDetailsStyle;", "Lcom/checkout/frames/component/billingaddressfields/BillingAddressInputComponentsContainerState;", "billingAddressDetailsComponentStyleUseCase", "Lcom/checkout/frames/style/view/billingformdetails/BillingAddressInputComponentsViewContainerStyle;", "buttonStyleMapper", "Lcom/checkout/frames/style/component/base/ButtonStyle;", "Lcom/checkout/frames/style/view/InternalButtonViewStyle;", "buttonStateMapper", "Lcom/checkout/frames/view/InternalButtonState;", "logger", "Lcom/checkout/logging/Logger;", "Lcom/checkout/logging/model/LoggingEvent;", "style", "(Lcom/checkout/frames/screen/manager/PaymentStateManager;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/frames/mapper/ImageStyleToDynamicComposableImageMapper;Lcom/checkout/base/usecase/UseCase;Lcom/checkout/base/usecase/UseCase;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/logging/Logger;Lcom/checkout/frames/style/screen/BillingAddressDetailsStyle;)V", "goBack", "Landroidx/compose/runtime/MutableState;", "", "getGoBack", "()Landroidx/compose/runtime/MutableState;", "inputComponentViewStyleList", "", "Lcom/checkout/frames/style/view/BillingAddressInputComponentViewStyle;", "getInputComponentViewStyleList", "()Ljava/util/List;", "inputComponentsContainerModifier", "getInputComponentsContainerModifier", "()Landroidx/compose/ui/Modifier;", "inputComponentsStateList", "Lcom/checkout/frames/component/billingaddressfields/BillingAddressInputComponentState;", "getInputComponentsStateList", "screenButtonState", "getScreenButtonState", "()Lcom/checkout/frames/view/InternalButtonState;", "screenButtonStyle", "getScreenButtonStyle", "()Lcom/checkout/frames/style/view/InternalButtonViewStyle;", "screenModifier", "getScreenModifier", "screenTitleState", "getScreenTitleState", "()Lcom/checkout/frames/view/TextLabelState;", "screenTitleStyle", "getScreenTitleStyle", "()Lcom/checkout/frames/style/view/TextLabelViewStyle;", "wasFocused", "isReadyToSaveAddress", "Lkotlinx/coroutines/flow/StateFlow;", "onAddressFieldTextChange", "", "position", "", "text", "", "onClose", "onFocusChanged", "isFocused", "onTapDoneButton", "prepare", "provideButtonState", "provideInputComponentStateList", "billingAddressDetailsStyle", "provideInputComponentViewStyleList", "provideScreenTitleState", "updateBillingAddress", "updateCountryComponentState", "state", "country", "Lcom/checkout/base/model/Country;", "updateCountryComponentState$frames_release", "updateInitialState", "Companion", "Factory", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BillingAddressDetailsViewModel extends ViewModel {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Regex onlyDigitsRegex = new Regex(ExpiryDateConstantsKt.EXPIRY_DATE_DIGITS_PATTERN);
    @NotNull
    private final UseCase<BillingAddressDetailsStyle, BillingAddressInputComponentsContainerState> billingAddressDetailsComponentStateUseCase;
    @NotNull
    private final UseCase<BillingAddressDetailsStyle, BillingAddressInputComponentsViewContainerStyle> billingAddressDetailsComponentStyleUseCase;
    @NotNull
    private final Mapper<ButtonStyle, InternalButtonState> buttonStateMapper;
    @NotNull
    private final MutableState<Boolean> goBack;
    @NotNull
    private final ImageStyleToDynamicComposableImageMapper imageMapper;
    @NotNull
    private final List<BillingAddressInputComponentViewStyle> inputComponentViewStyleList;
    @NotNull
    private final Modifier inputComponentsContainerModifier;
    @NotNull
    private final List<BillingAddressInputComponentState> inputComponentsStateList;
    @NotNull
    private final Logger<LoggingEvent> logger;
    @NotNull
    private final PaymentStateManager paymentStateManager;
    @NotNull
    private final InternalButtonState screenButtonState = provideButtonState();
    @NotNull
    private final InternalButtonViewStyle screenButtonStyle;
    @NotNull
    private final Modifier screenModifier;
    @NotNull
    private final TextLabelState screenTitleState;
    @NotNull
    private final TextLabelViewStyle screenTitleStyle;
    @NotNull
    private final BillingAddressDetailsStyle style;
    @NotNull
    private final Mapper<TextLabelStyle, TextLabelState> textLabelStateMapper;
    private boolean wasFocused;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/checkout/frames/screen/billingaddress/billingaddressdetails/BillingAddressDetailsViewModel$Companion;", "", "()V", "onlyDigitsRegex", "Lkotlin/text/Regex;", "getOnlyDigitsRegex", "()Lkotlin/text/Regex;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Regex getOnlyDigitsRegex() {
            return BillingAddressDetailsViewModel.onlyDigitsRegex;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J%\u0010\u000f\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/checkout/frames/screen/billingaddress/billingaddressdetails/BillingAddressDetailsViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/checkout/frames/di/base/InjectionClient;", "injector", "Lcom/checkout/frames/di/base/Injector;", "style", "Lcom/checkout/frames/style/screen/BillingAddressDetailsStyle;", "(Lcom/checkout/frames/di/base/Injector;Lcom/checkout/frames/style/screen/BillingAddressDetailsStyle;)V", "subComponentProvider", "Ljavax/inject/Provider;", "Lcom/checkout/frames/di/component/BillingFormViewModelSubComponent$Builder;", "getSubComponentProvider", "()Ljavax/inject/Provider;", "setSubComponentProvider", "(Ljavax/inject/Provider;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Factory implements ViewModelProvider.Factory, InjectionClient {
        @NotNull
        private final Injector injector;
        @NotNull
        private final BillingAddressDetailsStyle style;
        @Inject
        public Provider<BillingFormViewModelSubComponent.Builder> subComponentProvider;

        public Factory(@NotNull Injector injector2, @NotNull BillingAddressDetailsStyle billingAddressDetailsStyle) {
            Intrinsics.checkNotNullParameter(injector2, "injector");
            Intrinsics.checkNotNullParameter(billingAddressDetailsStyle, "style");
            this.injector = injector2;
            this.style = billingAddressDetailsStyle;
        }

        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            this.injector.inject(this);
            T billingAddressDetailsViewModel = getSubComponentProvider().get().style(this.style).build().getBillingAddressDetailsViewModel();
            Intrinsics.checkNotNull(billingAddressDetailsViewModel, "null cannot be cast to non-null type T of com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsViewModel.Factory.create");
            return billingAddressDetailsViewModel;
        }

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return h.b(this, cls, creationExtras);
        }

        @NotNull
        public final Provider<BillingFormViewModelSubComponent.Builder> getSubComponentProvider() {
            Provider<BillingFormViewModelSubComponent.Builder> provider = this.subComponentProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("subComponentProvider");
            return null;
        }

        public final void setSubComponentProvider(@NotNull Provider<BillingFormViewModelSubComponent.Builder> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.subComponentProvider = provider;
        }
    }

    @Inject
    public BillingAddressDetailsViewModel(@NotNull PaymentStateManager paymentStateManager2, @NotNull Mapper<TextLabelStyle, TextLabelViewStyle> mapper, @NotNull Mapper<TextLabelStyle, TextLabelState> mapper2, @NotNull Mapper<ContainerStyle, Modifier> mapper3, @NotNull ImageStyleToDynamicComposableImageMapper imageStyleToDynamicComposableImageMapper, @NotNull UseCase<BillingAddressDetailsStyle, BillingAddressInputComponentsContainerState> useCase, @NotNull UseCase<BillingAddressDetailsStyle, BillingAddressInputComponentsViewContainerStyle> useCase2, @NotNull Mapper<ButtonStyle, InternalButtonViewStyle> mapper4, @NotNull Mapper<ButtonStyle, InternalButtonState> mapper5, @NotNull Logger<LoggingEvent> logger2, @NotNull BillingAddressDetailsStyle billingAddressDetailsStyle) {
        Intrinsics.checkNotNullParameter(paymentStateManager2, "paymentStateManager");
        Intrinsics.checkNotNullParameter(mapper, "textLabelStyleMapper");
        Intrinsics.checkNotNullParameter(mapper2, "textLabelStateMapper");
        Intrinsics.checkNotNullParameter(mapper3, "containerMapper");
        Intrinsics.checkNotNullParameter(imageStyleToDynamicComposableImageMapper, "imageMapper");
        Intrinsics.checkNotNullParameter(useCase, "billingAddressDetailsComponentStateUseCase");
        Intrinsics.checkNotNullParameter(useCase2, "billingAddressDetailsComponentStyleUseCase");
        Intrinsics.checkNotNullParameter(mapper4, "buttonStyleMapper");
        Intrinsics.checkNotNullParameter(mapper5, "buttonStateMapper");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        Intrinsics.checkNotNullParameter(billingAddressDetailsStyle, "style");
        this.paymentStateManager = paymentStateManager2;
        this.textLabelStateMapper = mapper2;
        this.imageMapper = imageStyleToDynamicComposableImageMapper;
        this.billingAddressDetailsComponentStateUseCase = useCase;
        this.billingAddressDetailsComponentStyleUseCase = useCase2;
        this.buttonStateMapper = mapper5;
        this.logger = logger2;
        this.style = billingAddressDetailsStyle;
        this.screenTitleStyle = mapper.map(billingAddressDetailsStyle.getHeaderComponentStyle().getHeaderTitleStyle());
        this.screenTitleState = provideScreenTitleState(billingAddressDetailsStyle.getHeaderComponentStyle().getHeaderTitleStyle());
        this.screenModifier = mapper3.map(billingAddressDetailsStyle.getContainerStyle());
        this.screenButtonStyle = mapper4.map(billingAddressDetailsStyle.getHeaderComponentStyle().getHeaderButtonStyle());
        this.goBack = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.inputComponentsContainerModifier = mapper3.map(billingAddressDetailsStyle.getInputComponentsContainerStyle().getContainerStyle());
        this.inputComponentsStateList = provideInputComponentStateList(billingAddressDetailsStyle);
        this.inputComponentViewStyleList = provideInputComponentViewStyleList(billingAddressDetailsStyle);
        prepare();
    }

    /* access modifiers changed from: private */
    public final StateFlow<Boolean> isReadyToSaveAddress() {
        Iterable<BillingAddressInputComponentState> iterable = this.inputComponentsStateList;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (BillingAddressInputComponentState isAddressFieldValid : iterable) {
            arrayList.add(isAddressFieldValid.isAddressFieldValid());
        }
        Object[] array = CollectionsKt___CollectionsKt.toList(arrayList).toArray(new Flow[0]);
        if (array != null) {
            return FlowKt.stateIn(new BillingAddressDetailsViewModel$isReadyToSaveAddress$$inlined$combine$1((Flow[]) array), CoroutineScopeKt.MainScope(), SharingStarted.Companion.getLazily(), Boolean.FALSE);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    private final InternalButtonState provideButtonState() {
        return this.buttonStateMapper.map(this.style.getHeaderComponentStyle().getHeaderButtonStyle());
    }

    private final List<BillingAddressInputComponentState> provideInputComponentStateList(BillingAddressDetailsStyle billingAddressDetailsStyle) {
        List<BillingAddressInputComponentState> inputComponentStateList = this.billingAddressDetailsComponentStateUseCase.execute(billingAddressDetailsStyle).getInputComponentStateList();
        int i11 = 0;
        for (Object next : inputComponentStateList) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual((Object) ((BillingAddressInputComponentState) next).getAddressFieldName(), (Object) BillingFormFields.Phone.name())) {
                inputComponentStateList.get(i11).setInputComponentState(InputComponentState.copy$default(inputComponentStateList.get(i11).getInputComponentState(), InputFieldState.copy$default(inputComponentStateList.get(i11).getInputComponentState().getInputFieldState(), (MutableState) null, SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(18, (SnapshotMutationPolicy) null, 2, (Object) null), (MutableState) null, (MutableState) null, (MutableState) null, 29, (Object) null), (TextLabelState) null, (TextLabelState) null, (TextLabelState) null, (TextLabelState) null, false, 62, (Object) null));
            }
            i11 = i12;
        }
        return inputComponentStateList;
    }

    private final List<BillingAddressInputComponentViewStyle> provideInputComponentViewStyleList(BillingAddressDetailsStyle billingAddressDetailsStyle) {
        return this.billingAddressDetailsComponentStyleUseCase.execute(billingAddressDetailsStyle).getInputComponentViewStyleList();
    }

    private final TextLabelState provideScreenTitleState(TextLabelStyle textLabelStyle) {
        TextLabelState map = this.textLabelStateMapper.map(textLabelStyle);
        map.getTextId().setValue(Integer.valueOf(R.string.cko_billing_address));
        map.getLeadingIcon().setValue(this.imageMapper.map(new ImageStyleToDynamicImageRequest(textLabelStyle.getLeadingIconStyle(), FlowKt.flowOf(Integer.valueOf(R.drawable.cko_ic_cross_close)), FlowKt.flowOf(new BillingAddressDetailsViewModel$provideScreenTitleState$1(this)))));
        return map;
    }

    private final void updateBillingAddress() {
        Country country;
        Address address = this.paymentStateManager.getBillingAddress().getValue().getAddress();
        if (address == null || (country = address.getCountry()) == null) {
            country = Country.INVALID_COUNTRY;
        }
        this.paymentStateManager.getBillingAddress().setValue(BillingAddressDetailsExtensionsKt.provideBillingAddressDetails(this.inputComponentsStateList, country));
        this.paymentStateManager.isBillingAddressValid().setValue(Boolean.TRUE);
    }

    private final void updateInitialState() {
        int i11 = 0;
        for (Object next : this.inputComponentsStateList) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            BillingAddressInputComponentState billingAddressInputComponentState = this.inputComponentsStateList.get(i11);
            billingAddressInputComponentState.getAddressFieldText().setValue(BillingAddressDetailsExtensionsKt.provideAddressFieldText(this.paymentStateManager.getBillingAddress().getValue(), ((BillingAddressInputComponentState) next).getAddressFieldName()));
            if ((!StringsKt__StringsJVMKt.isBlank(billingAddressInputComponentState.getAddressFieldText().getValue())) && !billingAddressInputComponentState.isInputFieldOptional()) {
                billingAddressInputComponentState.isAddressFieldValid().setValue(Boolean.TRUE);
            }
            i11 = i12;
        }
    }

    @NotNull
    public final MutableState<Boolean> getGoBack() {
        return this.goBack;
    }

    @NotNull
    public final List<BillingAddressInputComponentViewStyle> getInputComponentViewStyleList() {
        return this.inputComponentViewStyleList;
    }

    @NotNull
    public final Modifier getInputComponentsContainerModifier() {
        return this.inputComponentsContainerModifier;
    }

    @NotNull
    public final List<BillingAddressInputComponentState> getInputComponentsStateList() {
        return this.inputComponentsStateList;
    }

    @NotNull
    public final InternalButtonState getScreenButtonState() {
        return this.screenButtonState;
    }

    @NotNull
    public final InternalButtonViewStyle getScreenButtonStyle() {
        return this.screenButtonStyle;
    }

    @NotNull
    public final Modifier getScreenModifier() {
        return this.screenModifier;
    }

    @NotNull
    public final TextLabelState getScreenTitleState() {
        return this.screenTitleState;
    }

    @NotNull
    public final TextLabelViewStyle getScreenTitleStyle() {
        return this.screenTitleStyle;
    }

    public final void onAddressFieldTextChange(int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        BillingAddressInputComponentState billingAddressInputComponentState = this.inputComponentsStateList.get(i11);
        if (Intrinsics.areEqual((Object) billingAddressInputComponentState.getAddressFieldName(), (Object) BillingFormFields.Phone.name())) {
            str = onlyDigitsRegex.replace((CharSequence) str, "");
        }
        billingAddressInputComponentState.getAddressFieldText().setValue(str);
        MutableStateFlow<Boolean> isAddressFieldValid = billingAddressInputComponentState.isAddressFieldValid();
        boolean z11 = true;
        if (!(!StringsKt__StringsJVMKt.isBlank(str)) && !billingAddressInputComponentState.isInputFieldOptional()) {
            z11 = false;
        }
        isAddressFieldValid.setValue(Boolean.valueOf(z11));
        billingAddressInputComponentState.hideError();
    }

    @VisibleForTesting
    public final void onClose() {
        LoggerExtensionsKt.logEvent(this.logger, BillingFormEventType.CANCELED);
        this.goBack.setValue(Boolean.TRUE);
    }

    public final void onFocusChanged(int i11, boolean z11) {
        if (z11) {
            this.wasFocused = z11;
        }
        BillingAddressInputComponentState billingAddressInputComponentState = this.inputComponentsStateList.get(i11);
        if (!z11 && this.wasFocused && !billingAddressInputComponentState.isAddressFieldValid().getValue().booleanValue()) {
            billingAddressInputComponentState.showError(BillingAddressDetailsExtensionsKt.getErrorMessage(billingAddressInputComponentState));
        }
    }

    public final void onTapDoneButton() {
        updateBillingAddress();
        LoggerExtensionsKt.logEvent(this.logger, BillingFormEventType.SUBMIT);
        this.goBack.setValue(Boolean.TRUE);
    }

    @VisibleForTesting
    public final void prepare() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new BillingAddressDetailsViewModel$prepare$1(this, (Continuation<? super BillingAddressDetailsViewModel$prepare$1>) null), 3, (Object) null);
        updateInitialState();
        LoggerExtensionsKt.logEvent(this.logger, BillingFormEventType.PRESENTED);
    }

    public final void updateCountryComponentState$frames_release(@NotNull BillingAddressInputComponentState billingAddressInputComponentState, @NotNull Country country) {
        boolean z11;
        Intrinsics.checkNotNullParameter(billingAddressInputComponentState, "state");
        Intrinsics.checkNotNullParameter(country, "country");
        if (country != Country.INVALID_COUNTRY) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (billingAddressInputComponentState.isAddressFieldValid().getValue().booleanValue() != z11) {
            billingAddressInputComponentState.isAddressFieldValid().setValue(Boolean.valueOf(z11));
        }
        if (!Intrinsics.areEqual((Object) billingAddressInputComponentState.getAddressFieldText().getValue(), (Object) country.name())) {
            billingAddressInputComponentState.getAddressFieldText().setValue(country.name());
        }
    }
}
