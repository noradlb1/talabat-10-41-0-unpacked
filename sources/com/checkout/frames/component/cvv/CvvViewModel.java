package com.checkout.frames.component.cvv;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.R;
import com.checkout.frames.component.base.InputComponentState;
import com.checkout.frames.di.base.InjectionClient;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.di.component.CvvViewModelSubComponent;
import com.checkout.frames.model.InputFieldColors;
import com.checkout.frames.screen.manager.PaymentStateManager;
import com.checkout.frames.style.component.CvvComponentStyle;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.view.InputComponentViewStyle;
import com.checkout.frames.style.view.InputFieldViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;
import com.checkout.frames.utils.extensions.ValidationResultExtensionsKt;
import com.checkout.validation.api.CardValidator;
import com.checkout.validation.model.ValidationResult;
import d2.h;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0000\u0018\u0000 &2\u00020\u0001:\u0002&'BG\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u001bH\u0002J\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0017J\u0006\u0010!\u001a\u00020\u0019J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\bH\u0002J\b\u0010%\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/checkout/frames/component/cvv/CvvViewModel;", "Landroidx/lifecycle/ViewModel;", "paymentStateManager", "Lcom/checkout/frames/screen/manager/PaymentStateManager;", "cardValidator", "Lcom/checkout/validation/api/CardValidator;", "inputComponentStyleMapper", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/base/InputComponentStyle;", "Lcom/checkout/frames/style/view/InputComponentViewStyle;", "inputComponentStateMapper", "Lcom/checkout/frames/component/base/InputComponentState;", "style", "Lcom/checkout/frames/style/component/CvvComponentStyle;", "(Lcom/checkout/frames/screen/manager/PaymentStateManager;Lcom/checkout/validation/api/CardValidator;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/frames/style/component/CvvComponentStyle;)V", "componentState", "Lcom/checkout/frames/component/cvv/CvvComponentState;", "getComponentState", "()Lcom/checkout/frames/component/cvv/CvvComponentState;", "componentStyle", "getComponentStyle", "()Lcom/checkout/frames/style/view/InputComponentViewStyle;", "wasFocused", "", "handleValidationResult", "", "result", "Lcom/checkout/validation/model/ValidationResult;", "onCvvChange", "text", "", "onFocusChanged", "isFocused", "prepare", "provideViewState", "provideViewStyle", "inputStyle", "validateCvv", "Companion", "Factory", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CvvViewModel extends ViewModel {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Regex onlyDigitsRegex = new Regex(ExpiryDateConstantsKt.EXPIRY_DATE_DIGITS_PATTERN);
    @NotNull
    private final CardValidator cardValidator;
    @NotNull
    private final CvvComponentState componentState;
    @NotNull
    private final InputComponentViewStyle componentStyle;
    @NotNull
    private final Mapper<InputComponentStyle, InputComponentState> inputComponentStateMapper;
    @NotNull
    private final Mapper<InputComponentStyle, InputComponentViewStyle> inputComponentStyleMapper;
    /* access modifiers changed from: private */
    @NotNull
    public final PaymentStateManager paymentStateManager;
    private boolean wasFocused;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/checkout/frames/component/cvv/CvvViewModel$Companion;", "", "()V", "onlyDigitsRegex", "Lkotlin/text/Regex;", "getOnlyDigitsRegex", "()Lkotlin/text/Regex;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Regex getOnlyDigitsRegex() {
            return CvvViewModel.onlyDigitsRegex;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J%\u0010\u000f\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/checkout/frames/component/cvv/CvvViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/checkout/frames/di/base/InjectionClient;", "injector", "Lcom/checkout/frames/di/base/Injector;", "style", "Lcom/checkout/frames/style/component/CvvComponentStyle;", "(Lcom/checkout/frames/di/base/Injector;Lcom/checkout/frames/style/component/CvvComponentStyle;)V", "subComponentProvider", "Ljavax/inject/Provider;", "Lcom/checkout/frames/di/component/CvvViewModelSubComponent$Builder;", "getSubComponentProvider", "()Ljavax/inject/Provider;", "setSubComponentProvider", "(Ljavax/inject/Provider;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Factory implements ViewModelProvider.Factory, InjectionClient {
        @NotNull
        private final Injector injector;
        @NotNull
        private final CvvComponentStyle style;
        @Inject
        public Provider<CvvViewModelSubComponent.Builder> subComponentProvider;

        public Factory(@NotNull Injector injector2, @NotNull CvvComponentStyle cvvComponentStyle) {
            Intrinsics.checkNotNullParameter(injector2, "injector");
            Intrinsics.checkNotNullParameter(cvvComponentStyle, "style");
            this.injector = injector2;
            this.style = cvvComponentStyle;
        }

        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            this.injector.inject(this);
            T cvvViewModel = getSubComponentProvider().get().style(this.style).build().getCvvViewModel();
            Intrinsics.checkNotNull(cvvViewModel, "null cannot be cast to non-null type T of com.checkout.frames.component.cvv.CvvViewModel.Factory.create");
            return cvvViewModel;
        }

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return h.b(this, cls, creationExtras);
        }

        @NotNull
        public final Provider<CvvViewModelSubComponent.Builder> getSubComponentProvider() {
            Provider<CvvViewModelSubComponent.Builder> provider = this.subComponentProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("subComponentProvider");
            return null;
        }

        public final void setSubComponentProvider(@NotNull Provider<CvvViewModelSubComponent.Builder> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.subComponentProvider = provider;
        }
    }

    @Inject
    public CvvViewModel(@NotNull PaymentStateManager paymentStateManager2, @NotNull CardValidator cardValidator2, @NotNull Mapper<InputComponentStyle, InputComponentViewStyle> mapper, @NotNull Mapper<InputComponentStyle, InputComponentState> mapper2, @NotNull CvvComponentStyle cvvComponentStyle) {
        Intrinsics.checkNotNullParameter(paymentStateManager2, "paymentStateManager");
        Intrinsics.checkNotNullParameter(cardValidator2, "cardValidator");
        Intrinsics.checkNotNullParameter(mapper, "inputComponentStyleMapper");
        Intrinsics.checkNotNullParameter(mapper2, "inputComponentStateMapper");
        Intrinsics.checkNotNullParameter(cvvComponentStyle, "style");
        this.paymentStateManager = paymentStateManager2;
        this.cardValidator = cardValidator2;
        this.inputComponentStyleMapper = mapper;
        this.inputComponentStateMapper = mapper2;
        this.componentState = provideViewState(cvvComponentStyle);
        this.componentStyle = provideViewStyle(cvvComponentStyle.getInputStyle());
    }

    private final void handleValidationResult(ValidationResult<Unit> validationResult) {
        if (validationResult instanceof ValidationResult.Success) {
            this.componentState.hideError();
        } else if (validationResult instanceof ValidationResult.Failure) {
            this.componentState.showError(R.string.cko_cvv_component_error);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final CvvComponentState provideViewState(CvvComponentStyle cvvComponentStyle) {
        return new CvvComponentState(this.inputComponentStateMapper.map(cvvComponentStyle.getInputStyle()));
    }

    private final InputComponentViewStyle provideViewStyle(InputComponentStyle inputComponentStyle) {
        InputComponentViewStyle map = this.inputComponentStyleMapper.map(inputComponentStyle);
        KeyboardOptions keyboardOptions = r3;
        KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, false, KeyboardType.Companion.m5223getNumberPjHm6EE(), ImeAction.Companion.m5188getDoneeUduSuo(), 3, (DefaultConstructorMarker) null);
        return InputComponentViewStyle.copy$default(map, (TextLabelViewStyle) null, (TextLabelViewStyle) null, (TextLabelViewStyle) null, InputFieldViewStyle.m9274copyRTRN5YQ$default(map.getInputFieldStyle(), (Modifier) null, false, false, (TextStyle) null, (Function2) null, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, false, 0, (MutableInteractionSource) null, (Shape) null, (Shape) null, (InputFieldColors) null, 0.0f, 0.0f, true, 65471, (Object) null), (TextLabelViewStyle) null, (Modifier) null, false, 119, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void validateCvv() {
        Boolean value;
        if (this.wasFocused) {
            ValidationResult<Unit> validateCvv = this.cardValidator.validateCvv(this.componentState.getCvv().getValue(), this.paymentStateManager.getCardScheme().getValue());
            MutableStateFlow<Boolean> isCvvValid = this.paymentStateManager.isCvvValid();
            do {
                value = isCvvValid.getValue();
                value.booleanValue();
            } while (!isCvvValid.compareAndSet(value, Boolean.valueOf(ValidationResultExtensionsKt.isValid(validateCvv))));
            handleValidationResult(validateCvv);
        }
    }

    @NotNull
    public final CvvComponentState getComponentState() {
        return this.componentState;
    }

    @NotNull
    public final InputComponentViewStyle getComponentStyle() {
        return this.componentStyle;
    }

    public final void onCvvChange(@NotNull String str) {
        String value;
        Intrinsics.checkNotNullParameter(str, "text");
        String replace = onlyDigitsRegex.replace((CharSequence) str, "");
        this.componentState.getCvv().setValue(replace);
        MutableStateFlow<String> cvv = this.paymentStateManager.getCvv();
        do {
            value = cvv.getValue();
            String str2 = value;
        } while (!cvv.compareAndSet(value, replace));
        this.componentState.hideError();
    }

    public final void onFocusChanged(boolean z11) {
        if (z11) {
            this.wasFocused = z11;
        }
        if (!z11 && this.wasFocused) {
            validateCvv();
        }
    }

    public final void prepare() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new CvvViewModel$prepare$1(this, (Continuation<? super CvvViewModel$prepare$1>) null), 3, (Object) null);
    }
}
