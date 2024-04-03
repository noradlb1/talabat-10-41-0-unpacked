package com.checkout.frames.component.expirydate;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.checkout.base.mapper.Mapper;
import com.checkout.base.usecase.UseCase;
import com.checkout.frames.R;
import com.checkout.frames.component.base.InputComponentState;
import com.checkout.frames.component.expirydate.model.SmartExpiryDateValidationRequest;
import com.checkout.frames.di.base.InjectionClient;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.di.component.ExpiryDateViewModelSubComponent;
import com.checkout.frames.model.InputFieldColors;
import com.checkout.frames.screen.manager.PaymentStateManager;
import com.checkout.frames.style.component.ExpiryDateComponentStyle;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.view.InputComponentViewStyle;
import com.checkout.frames.style.view.InputFieldViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;
import com.checkout.validation.error.ValidationError;
import com.checkout.validation.model.ValidationResult;
import d2.h;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 *2\u00020\u0001:\u0002*+BY\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\n\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u001e\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u001e\u001a\u00020\u001aH\u0002J\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\bJ\u000e\u0010!\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001aJ\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u000bH\u0002J\u0010\u0010$\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u000bH\u0002J\u0016\u0010%\u001a\u00020\u001c2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0'H\u0002J\u0018\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001aH\u0002R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/checkout/frames/component/expirydate/ExpiryDateViewModel;", "Landroidx/lifecycle/ViewModel;", "paymentStateManager", "Lcom/checkout/frames/screen/manager/PaymentStateManager;", "smartExpiryDateValidationUseCase", "Lcom/checkout/base/usecase/UseCase;", "Lcom/checkout/frames/component/expirydate/model/SmartExpiryDateValidationRequest;", "Lcom/checkout/validation/model/ValidationResult;", "", "inputComponentStyleMapper", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/base/InputComponentStyle;", "Lcom/checkout/frames/style/view/InputComponentViewStyle;", "inputComponentStateMapper", "Lcom/checkout/frames/component/base/InputComponentState;", "style", "Lcom/checkout/frames/style/component/ExpiryDateComponentStyle;", "(Lcom/checkout/frames/screen/manager/PaymentStateManager;Lcom/checkout/base/usecase/UseCase;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/frames/style/component/ExpiryDateComponentStyle;)V", "componentState", "Lcom/checkout/frames/component/expirydate/ExpiryDateComponentState;", "getComponentState", "()Lcom/checkout/frames/component/expirydate/ExpiryDateComponentState;", "componentStyle", "getComponentStyle", "()Lcom/checkout/frames/style/view/InputComponentViewStyle;", "wasFocused", "", "handleValidationResult", "", "result", "isFocused", "onExpiryDateInputChange", "inputExpiryDate", "onFocusChanged", "provideViewState", "inputStyle", "provideViewStyle", "updateExpiryDateMaxLength", "smartLogicExpiryDateUseCase", "Lcom/checkout/validation/model/ValidationResult$Success;", "validateExpiryDate", "expiryDate", "Companion", "Factory", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ExpiryDateViewModel extends ViewModel {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Regex onlyDigitsRegex = new Regex(ExpiryDateConstantsKt.EXPIRY_DATE_DIGITS_PATTERN);
    @NotNull
    private final ExpiryDateComponentState componentState;
    @NotNull
    private final InputComponentViewStyle componentStyle;
    @NotNull
    private final Mapper<InputComponentStyle, InputComponentState> inputComponentStateMapper;
    @NotNull
    private final Mapper<InputComponentStyle, InputComponentViewStyle> inputComponentStyleMapper;
    @NotNull
    private final PaymentStateManager paymentStateManager;
    @NotNull
    private final UseCase<SmartExpiryDateValidationRequest, ValidationResult<String>> smartExpiryDateValidationUseCase;
    @NotNull
    private final ExpiryDateComponentStyle style;
    private boolean wasFocused;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/checkout/frames/component/expirydate/ExpiryDateViewModel$Companion;", "", "()V", "onlyDigitsRegex", "Lkotlin/text/Regex;", "getOnlyDigitsRegex", "()Lkotlin/text/Regex;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Regex getOnlyDigitsRegex() {
            return ExpiryDateViewModel.onlyDigitsRegex;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J%\u0010\u000f\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/checkout/frames/component/expirydate/ExpiryDateViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/checkout/frames/di/base/InjectionClient;", "injector", "Lcom/checkout/frames/di/base/Injector;", "style", "Lcom/checkout/frames/style/component/ExpiryDateComponentStyle;", "(Lcom/checkout/frames/di/base/Injector;Lcom/checkout/frames/style/component/ExpiryDateComponentStyle;)V", "subComponentProvider", "Ljavax/inject/Provider;", "Lcom/checkout/frames/di/component/ExpiryDateViewModelSubComponent$Builder;", "getSubComponentProvider", "()Ljavax/inject/Provider;", "setSubComponentProvider", "(Ljavax/inject/Provider;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Factory implements ViewModelProvider.Factory, InjectionClient {
        @NotNull
        private final Injector injector;
        @NotNull
        private final ExpiryDateComponentStyle style;
        @Inject
        public Provider<ExpiryDateViewModelSubComponent.Builder> subComponentProvider;

        public Factory(@NotNull Injector injector2, @NotNull ExpiryDateComponentStyle expiryDateComponentStyle) {
            Intrinsics.checkNotNullParameter(injector2, "injector");
            Intrinsics.checkNotNullParameter(expiryDateComponentStyle, "style");
            this.injector = injector2;
            this.style = expiryDateComponentStyle;
        }

        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            this.injector.inject(this);
            T expiryDateViewModel = getSubComponentProvider().get().style(this.style).build().getExpiryDateViewModel();
            Intrinsics.checkNotNull(expiryDateViewModel, "null cannot be cast to non-null type T of com.checkout.frames.component.expirydate.ExpiryDateViewModel.Factory.create");
            return expiryDateViewModel;
        }

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return h.b(this, cls, creationExtras);
        }

        @NotNull
        public final Provider<ExpiryDateViewModelSubComponent.Builder> getSubComponentProvider() {
            Provider<ExpiryDateViewModelSubComponent.Builder> provider = this.subComponentProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("subComponentProvider");
            return null;
        }

        public final void setSubComponentProvider(@NotNull Provider<ExpiryDateViewModelSubComponent.Builder> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.subComponentProvider = provider;
        }
    }

    @Inject
    public ExpiryDateViewModel(@NotNull PaymentStateManager paymentStateManager2, @NotNull UseCase<SmartExpiryDateValidationRequest, ValidationResult<String>> useCase, @NotNull Mapper<InputComponentStyle, InputComponentViewStyle> mapper, @NotNull Mapper<InputComponentStyle, InputComponentState> mapper2, @NotNull ExpiryDateComponentStyle expiryDateComponentStyle) {
        Intrinsics.checkNotNullParameter(paymentStateManager2, "paymentStateManager");
        Intrinsics.checkNotNullParameter(useCase, "smartExpiryDateValidationUseCase");
        Intrinsics.checkNotNullParameter(mapper, "inputComponentStyleMapper");
        Intrinsics.checkNotNullParameter(mapper2, "inputComponentStateMapper");
        Intrinsics.checkNotNullParameter(expiryDateComponentStyle, "style");
        this.paymentStateManager = paymentStateManager2;
        this.smartExpiryDateValidationUseCase = useCase;
        this.inputComponentStyleMapper = mapper;
        this.inputComponentStateMapper = mapper2;
        this.style = expiryDateComponentStyle;
        this.componentState = provideViewState(expiryDateComponentStyle.getInputStyle());
        this.componentStyle = provideViewStyle(expiryDateComponentStyle.getInputStyle());
    }

    private final void handleValidationResult(ValidationResult<String> validationResult, boolean z11) {
        Boolean value;
        Boolean value2;
        if (validationResult instanceof ValidationResult.Success) {
            ValidationResult.Success success = (ValidationResult.Success) validationResult;
            updateExpiryDateMaxLength(success);
            this.componentState.getExpiryDate().setValue(success.getValue());
            this.componentState.hideError();
            this.paymentStateManager.getExpiryDate().setValue(success.getValue());
            MutableStateFlow<Boolean> isExpiryDateValid = this.paymentStateManager.isExpiryDateValid();
            do {
                value2 = isExpiryDateValid.getValue();
                value2.booleanValue();
            } while (!isExpiryDateValid.compareAndSet(value2, Boolean.TRUE));
        } else if (validationResult instanceof ValidationResult.Failure) {
            MutableStateFlow<Boolean> isExpiryDateValid2 = this.paymentStateManager.isExpiryDateValid();
            do {
                value = isExpiryDateValid2.getValue();
                value.booleanValue();
            } while (!isExpiryDateValid2.compareAndSet(value, Boolean.FALSE));
            if (!z11 || !Intrinsics.areEqual((Object) ((ValidationResult.Failure) validationResult).getError().getErrorCode(), (Object) ValidationError.EXPIRY_DATE_IN_PAST)) {
                this.componentState.showError(R.string.cko_base_invalid_expiry_date_error);
            } else {
                this.componentState.showError(R.string.cko_base_invalid_past_expiry_date_error);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final ExpiryDateComponentState provideViewState(InputComponentStyle inputComponentStyle) {
        ExpiryDateComponentState expiryDateComponentState = new ExpiryDateComponentState(this.inputComponentStateMapper.map(inputComponentStyle));
        expiryDateComponentState.getExpiryDateMaxLength().setValue(4);
        return expiryDateComponentState;
    }

    private final InputComponentViewStyle provideViewStyle(InputComponentStyle inputComponentStyle) {
        InputComponentViewStyle map = this.inputComponentStyleMapper.map(inputComponentStyle);
        KeyboardOptions keyboardOptions = r3;
        KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, false, KeyboardType.Companion.m5223getNumberPjHm6EE(), ImeAction.Companion.m5190getNexteUduSuo(), 3, (DefaultConstructorMarker) null);
        InputFieldViewStyle inputFieldStyle = map.getInputFieldStyle();
        ExpiryDateVisualTransformation expiryDateVisualTransformation = r1;
        ExpiryDateVisualTransformation expiryDateVisualTransformation2 = new ExpiryDateVisualTransformation();
        return InputComponentViewStyle.copy$default(map, (TextLabelViewStyle) null, (TextLabelViewStyle) null, (TextLabelViewStyle) null, InputFieldViewStyle.m9274copyRTRN5YQ$default(inputFieldStyle, (Modifier) null, false, false, (TextStyle) null, (Function2) null, expiryDateVisualTransformation, keyboardOptions, (KeyboardActions) null, false, 0, (MutableInteractionSource) null, (Shape) null, (Shape) null, (InputFieldColors) null, 0.0f, 0.0f, true, 65439, (Object) null), (TextLabelViewStyle) null, (Modifier) null, false, 119, (Object) null);
    }

    private final void updateExpiryDateMaxLength(ValidationResult.Success<String> success) {
        boolean z11;
        int i11;
        MutableState<Integer> expiryDateMaxLength = this.componentState.getExpiryDateMaxLength();
        if (success.getValue().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || Intrinsics.compare((int) StringsKt___StringsKt.first(success.getValue()), 49) <= 0) {
            i11 = 4;
        } else {
            i11 = 3;
        }
        expiryDateMaxLength.setValue(Integer.valueOf(i11));
    }

    private final void validateExpiryDate(String str, boolean z11) {
        handleValidationResult(this.smartExpiryDateValidationUseCase.execute(new SmartExpiryDateValidationRequest(z11, str)), z11);
    }

    @NotNull
    public final ExpiryDateComponentState getComponentState() {
        return this.componentState;
    }

    @NotNull
    public final InputComponentViewStyle getComponentStyle() {
        return this.componentStyle;
    }

    public final void onExpiryDateInputChange(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "inputExpiryDate");
        validateExpiryDate(onlyDigitsRegex.replace((CharSequence) str, ""), true);
    }

    public final void onFocusChanged(boolean z11) {
        if (z11) {
            this.wasFocused = z11;
        }
        if (!z11 && this.wasFocused) {
            validateExpiryDate(this.componentState.getExpiryDate().getValue(), z11);
        }
    }
}
