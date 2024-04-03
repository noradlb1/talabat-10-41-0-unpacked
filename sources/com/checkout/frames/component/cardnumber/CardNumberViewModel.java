package com.checkout.frames.component.cardnumber;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.checkout.base.mapper.Mapper;
import com.checkout.base.model.CardScheme;
import com.checkout.frames.R;
import com.checkout.frames.component.base.InputComponentState;
import com.checkout.frames.di.base.InjectionClient;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.di.component.CardNumberViewModelSubComponent;
import com.checkout.frames.mapper.ImageStyleToDynamicComposableImageMapper;
import com.checkout.frames.model.InputFieldColors;
import com.checkout.frames.model.request.ImageStyleToDynamicImageRequest;
import com.checkout.frames.screen.manager.PaymentStateManager;
import com.checkout.frames.style.component.CardNumberComponentStyle;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.view.InputComponentViewStyle;
import com.checkout.frames.style.view.InputFieldViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;
import com.checkout.validation.api.CardValidator;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0000\u0018\u0000 *2\u00020\u0001:\u0002*+BO\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u001e\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020\u0019H\u0002J\b\u0010 \u001a\u00020\u001bH\u0002J\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u0019J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\bH\u0002J\b\u0010)\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/checkout/frames/component/cardnumber/CardNumberViewModel;", "Landroidx/lifecycle/ViewModel;", "paymentStateManager", "Lcom/checkout/frames/screen/manager/PaymentStateManager;", "cardValidator", "Lcom/checkout/validation/api/CardValidator;", "inputComponentStyleMapper", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/base/InputComponentStyle;", "Lcom/checkout/frames/style/view/InputComponentViewStyle;", "inputComponentStateMapper", "Lcom/checkout/frames/component/base/InputComponentState;", "imageMapper", "Lcom/checkout/frames/mapper/ImageStyleToDynamicComposableImageMapper;", "style", "Lcom/checkout/frames/style/component/CardNumberComponentStyle;", "(Lcom/checkout/frames/screen/manager/PaymentStateManager;Lcom/checkout/validation/api/CardValidator;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/frames/mapper/ImageStyleToDynamicComposableImageMapper;Lcom/checkout/frames/style/component/CardNumberComponentStyle;)V", "componentState", "Lcom/checkout/frames/component/cardnumber/CardNumberComponentState;", "getComponentState", "()Lcom/checkout/frames/component/cardnumber/CardNumberComponentState;", "componentStyle", "getComponentStyle", "()Lcom/checkout/frames/style/view/InputComponentViewStyle;", "wasFocused", "", "handleValidationResult", "", "result", "Lcom/checkout/validation/model/ValidationResult;", "Lcom/checkout/base/model/CardScheme;", "isEagerCheck", "hideValidationError", "onCardNumberChange", "text", "", "onFocusChanged", "isFocused", "provideViewState", "provideViewStyle", "inputStyle", "showValidationError", "Companion", "Factory", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CardNumberViewModel extends ViewModel {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Regex onlyDigitsRegex = new Regex(ExpiryDateConstantsKt.EXPIRY_DATE_DIGITS_PATTERN);
    @NotNull
    private final CardValidator cardValidator;
    @NotNull
    private final CardNumberComponentState componentState;
    @NotNull
    private final InputComponentViewStyle componentStyle;
    @NotNull
    private final ImageStyleToDynamicComposableImageMapper imageMapper;
    @NotNull
    private final Mapper<InputComponentStyle, InputComponentState> inputComponentStateMapper;
    @NotNull
    private final Mapper<InputComponentStyle, InputComponentViewStyle> inputComponentStyleMapper;
    @NotNull
    private final PaymentStateManager paymentStateManager;
    @NotNull
    private final CardNumberComponentStyle style;
    private boolean wasFocused;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/checkout/frames/component/cardnumber/CardNumberViewModel$Companion;", "", "()V", "onlyDigitsRegex", "Lkotlin/text/Regex;", "getOnlyDigitsRegex", "()Lkotlin/text/Regex;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Regex getOnlyDigitsRegex() {
            return CardNumberViewModel.onlyDigitsRegex;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J%\u0010\u000f\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/checkout/frames/component/cardnumber/CardNumberViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/checkout/frames/di/base/InjectionClient;", "injector", "Lcom/checkout/frames/di/base/Injector;", "style", "Lcom/checkout/frames/style/component/CardNumberComponentStyle;", "(Lcom/checkout/frames/di/base/Injector;Lcom/checkout/frames/style/component/CardNumberComponentStyle;)V", "subComponentProvider", "Ljavax/inject/Provider;", "Lcom/checkout/frames/di/component/CardNumberViewModelSubComponent$Builder;", "getSubComponentProvider", "()Ljavax/inject/Provider;", "setSubComponentProvider", "(Ljavax/inject/Provider;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Factory implements ViewModelProvider.Factory, InjectionClient {
        @NotNull
        private final Injector injector;
        @NotNull
        private final CardNumberComponentStyle style;
        @Inject
        public Provider<CardNumberViewModelSubComponent.Builder> subComponentProvider;

        public Factory(@NotNull Injector injector2, @NotNull CardNumberComponentStyle cardNumberComponentStyle) {
            Intrinsics.checkNotNullParameter(injector2, "injector");
            Intrinsics.checkNotNullParameter(cardNumberComponentStyle, "style");
            this.injector = injector2;
            this.style = cardNumberComponentStyle;
        }

        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            this.injector.inject(this);
            T cardNumberViewModel = getSubComponentProvider().get().style(this.style).build().getCardNumberViewModel();
            Intrinsics.checkNotNull(cardNumberViewModel, "null cannot be cast to non-null type T of com.checkout.frames.component.cardnumber.CardNumberViewModel.Factory.create");
            return cardNumberViewModel;
        }

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return h.b(this, cls, creationExtras);
        }

        @NotNull
        public final Provider<CardNumberViewModelSubComponent.Builder> getSubComponentProvider() {
            Provider<CardNumberViewModelSubComponent.Builder> provider = this.subComponentProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("subComponentProvider");
            return null;
        }

        public final void setSubComponentProvider(@NotNull Provider<CardNumberViewModelSubComponent.Builder> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.subComponentProvider = provider;
        }
    }

    @Inject
    public CardNumberViewModel(@NotNull PaymentStateManager paymentStateManager2, @NotNull CardValidator cardValidator2, @NotNull Mapper<InputComponentStyle, InputComponentViewStyle> mapper, @NotNull Mapper<InputComponentStyle, InputComponentState> mapper2, @NotNull ImageStyleToDynamicComposableImageMapper imageStyleToDynamicComposableImageMapper, @NotNull CardNumberComponentStyle cardNumberComponentStyle) {
        Intrinsics.checkNotNullParameter(paymentStateManager2, "paymentStateManager");
        Intrinsics.checkNotNullParameter(cardValidator2, "cardValidator");
        Intrinsics.checkNotNullParameter(mapper, "inputComponentStyleMapper");
        Intrinsics.checkNotNullParameter(mapper2, "inputComponentStateMapper");
        Intrinsics.checkNotNullParameter(imageStyleToDynamicComposableImageMapper, "imageMapper");
        Intrinsics.checkNotNullParameter(cardNumberComponentStyle, "style");
        this.paymentStateManager = paymentStateManager2;
        this.cardValidator = cardValidator2;
        this.inputComponentStyleMapper = mapper;
        this.inputComponentStateMapper = mapper2;
        this.imageMapper = imageStyleToDynamicComposableImageMapper;
        this.style = cardNumberComponentStyle;
        this.componentState = provideViewState(cardNumberComponentStyle);
        this.componentStyle = provideViewStyle(cardNumberComponentStyle.getInputStyle());
    }

    private final void handleValidationResult(ValidationResult<? extends CardScheme> validationResult, boolean z11) {
        CardScheme value;
        if (validationResult instanceof ValidationResult.Success) {
            CardScheme cardScheme = (CardScheme) ((ValidationResult.Success) validationResult).getValue();
            if (z11) {
                this.componentState.getCardScheme().setValue(cardScheme);
                this.componentState.getCardNumberLength().setValue(Integer.valueOf(cardScheme.getMaxNumberLength()));
                MutableStateFlow<CardScheme> cardScheme2 = this.paymentStateManager.getCardScheme();
                do {
                    value = cardScheme2.getValue();
                    CardScheme cardScheme3 = value;
                } while (!cardScheme2.compareAndSet(value, cardScheme));
            }
            if (this.paymentStateManager.getSupportedCardSchemeList().contains(cardScheme)) {
                hideValidationError();
            } else {
                showValidationError();
            }
        } else if (validationResult instanceof ValidationResult.Failure) {
            showValidationError();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void hideValidationError() {
        Boolean value;
        this.componentState.hideError();
        MutableStateFlow<Boolean> isCardNumberValid = this.paymentStateManager.isCardNumberValid();
        do {
            value = isCardNumberValid.getValue();
            value.booleanValue();
        } while (!isCardNumberValid.compareAndSet(value, Boolean.TRUE));
    }

    private final CardNumberComponentState provideViewState(CardNumberComponentStyle cardNumberComponentStyle) {
        CardNumberComponentState cardNumberComponentState = new CardNumberComponentState(this.inputComponentStateMapper.map(cardNumberComponentStyle.getInputStyle()), (MutableState) null, 2, (DefaultConstructorMarker) null);
        cardNumberComponentState.getInputState().getInputFieldState().getLeadingIcon().setValue(this.imageMapper.map(new ImageStyleToDynamicImageRequest(cardNumberComponentStyle.getInputStyle().getInputFieldStyle().getLeadingIconStyle(), new CardNumberViewModel$provideViewState$$inlined$map$1(SnapshotStateKt.snapshotFlow(new CardNumberViewModel$provideViewState$1(cardNumberComponentState))), (Flow) null, 4, (DefaultConstructorMarker) null)));
        return cardNumberComponentState;
    }

    private final InputComponentViewStyle provideViewStyle(InputComponentStyle inputComponentStyle) {
        InputComponentViewStyle map = this.inputComponentStyleMapper.map(inputComponentStyle);
        KeyboardOptions keyboardOptions = r3;
        KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, false, KeyboardType.Companion.m5223getNumberPjHm6EE(), ImeAction.Companion.m5190getNexteUduSuo(), 3, (DefaultConstructorMarker) null);
        InputFieldViewStyle inputFieldStyle = map.getInputFieldStyle();
        CardNumberTransformation cardNumberTransformation = r1;
        CardNumberTransformation cardNumberTransformation2 = new CardNumberTransformation(this.style.getCardNumberSeparator(), this.componentState.getCardScheme());
        return InputComponentViewStyle.copy$default(map, (TextLabelViewStyle) null, (TextLabelViewStyle) null, (TextLabelViewStyle) null, InputFieldViewStyle.m9274copyRTRN5YQ$default(inputFieldStyle, (Modifier) null, false, false, (TextStyle) null, (Function2) null, cardNumberTransformation, keyboardOptions, (KeyboardActions) null, false, 0, (MutableInteractionSource) null, (Shape) null, (Shape) null, (InputFieldColors) null, 0.0f, 0.0f, true, 65439, (Object) null), (TextLabelViewStyle) null, (Modifier) null, false, 119, (Object) null);
    }

    private final void showValidationError() {
        Boolean value;
        this.componentState.showError(R.string.cko_base_invalid_card_number_error);
        MutableStateFlow<Boolean> isCardNumberValid = this.paymentStateManager.isCardNumberValid();
        do {
            value = isCardNumberValid.getValue();
            value.booleanValue();
        } while (!isCardNumberValid.compareAndSet(value, Boolean.FALSE));
    }

    @NotNull
    public final CardNumberComponentState getComponentState() {
        return this.componentState;
    }

    @NotNull
    public final InputComponentViewStyle getComponentStyle() {
        return this.componentStyle;
    }

    public final void onCardNumberChange(@NotNull String str) {
        String value;
        Intrinsics.checkNotNullParameter(str, "text");
        String replace = onlyDigitsRegex.replace((CharSequence) str, "");
        ValidationResult<CardScheme> eagerValidateCardNumber = this.cardValidator.eagerValidateCardNumber(replace);
        this.componentState.getCardNumber().setValue(replace);
        MutableStateFlow<String> cardNumber = this.paymentStateManager.getCardNumber();
        do {
            value = cardNumber.getValue();
            String str2 = value;
        } while (!cardNumber.compareAndSet(value, replace));
        handleValidationResult(eagerValidateCardNumber, true);
    }

    public final void onFocusChanged(boolean z11) {
        if (z11) {
            this.wasFocused = z11;
        }
        if (!z11 && this.wasFocused) {
            handleValidationResult(this.cardValidator.validateCardNumber(this.componentState.getCardNumber().getValue()), false);
        }
    }
}
