package com.checkout.frames.component.country;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.checkout.base.mapper.Mapper;
import com.checkout.base.model.Country;
import com.checkout.frames.R;
import com.checkout.frames.component.base.InputComponentState;
import com.checkout.frames.di.base.InjectionClient;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.di.component.CountryViewModelSubComponent;
import com.checkout.frames.model.InputFieldColors;
import com.checkout.frames.screen.manager.PaymentStateManager;
import com.checkout.frames.style.component.CountryComponentStyle;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.view.InputComponentViewStyle;
import com.checkout.frames.style.view.InputFieldViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.view.TextLabelState;
import d2.h;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001fB?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J)\u0010\u0017\u001a\u00020\u00142!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00140\u0019J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0006H\u0002R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/checkout/frames/component/country/CountryViewModel;", "Landroidx/lifecycle/ViewModel;", "paymentStateManager", "Lcom/checkout/frames/screen/manager/PaymentStateManager;", "inputComponentStyleMapper", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/base/InputComponentStyle;", "Lcom/checkout/frames/style/view/InputComponentViewStyle;", "inputComponentStateMapper", "Lcom/checkout/frames/component/base/InputComponentState;", "style", "Lcom/checkout/frames/style/component/CountryComponentStyle;", "(Lcom/checkout/frames/screen/manager/PaymentStateManager;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/frames/style/component/CountryComponentStyle;)V", "componentState", "getComponentState", "()Lcom/checkout/frames/component/base/InputComponentState;", "componentStyle", "getComponentStyle", "()Lcom/checkout/frames/style/view/InputComponentViewStyle;", "maybeShowErrorMessage", "", "country", "Lcom/checkout/base/model/Country;", "prepare", "onCountryUpdated", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "provideViewState", "provideViewStyle", "inputStyle", "Factory", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CountryViewModel extends ViewModel {
    @NotNull
    private final InputComponentState componentState;
    @NotNull
    private final InputComponentViewStyle componentStyle;
    @NotNull
    private final Mapper<InputComponentStyle, InputComponentState> inputComponentStateMapper;
    @NotNull
    private final Mapper<InputComponentStyle, InputComponentViewStyle> inputComponentStyleMapper;
    /* access modifiers changed from: private */
    @NotNull
    public final PaymentStateManager paymentStateManager;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J%\u0010\u000f\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/checkout/frames/component/country/CountryViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/checkout/frames/di/base/InjectionClient;", "injector", "Lcom/checkout/frames/di/base/Injector;", "style", "Lcom/checkout/frames/style/component/CountryComponentStyle;", "(Lcom/checkout/frames/di/base/Injector;Lcom/checkout/frames/style/component/CountryComponentStyle;)V", "subComponentProvider", "Ljavax/inject/Provider;", "Lcom/checkout/frames/di/component/CountryViewModelSubComponent$Builder;", "getSubComponentProvider", "()Ljavax/inject/Provider;", "setSubComponentProvider", "(Ljavax/inject/Provider;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Factory implements ViewModelProvider.Factory, InjectionClient {
        @NotNull
        private final Injector injector;
        @NotNull
        private final CountryComponentStyle style;
        @Inject
        public Provider<CountryViewModelSubComponent.Builder> subComponentProvider;

        public Factory(@NotNull Injector injector2, @NotNull CountryComponentStyle countryComponentStyle) {
            Intrinsics.checkNotNullParameter(injector2, "injector");
            Intrinsics.checkNotNullParameter(countryComponentStyle, "style");
            this.injector = injector2;
            this.style = countryComponentStyle;
        }

        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            this.injector.inject(this);
            T countryViewModel = getSubComponentProvider().get().style(this.style).build().getCountryViewModel();
            Intrinsics.checkNotNull(countryViewModel, "null cannot be cast to non-null type T of com.checkout.frames.component.country.CountryViewModel.Factory.create");
            return countryViewModel;
        }

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return h.b(this, cls, creationExtras);
        }

        @NotNull
        public final Provider<CountryViewModelSubComponent.Builder> getSubComponentProvider() {
            Provider<CountryViewModelSubComponent.Builder> provider = this.subComponentProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("subComponentProvider");
            return null;
        }

        public final void setSubComponentProvider(@NotNull Provider<CountryViewModelSubComponent.Builder> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.subComponentProvider = provider;
        }
    }

    @Inject
    public CountryViewModel(@NotNull PaymentStateManager paymentStateManager2, @NotNull Mapper<InputComponentStyle, InputComponentViewStyle> mapper, @NotNull Mapper<InputComponentStyle, InputComponentState> mapper2, @NotNull CountryComponentStyle countryComponentStyle) {
        Intrinsics.checkNotNullParameter(paymentStateManager2, "paymentStateManager");
        Intrinsics.checkNotNullParameter(mapper, "inputComponentStyleMapper");
        Intrinsics.checkNotNullParameter(mapper2, "inputComponentStateMapper");
        Intrinsics.checkNotNullParameter(countryComponentStyle, "style");
        this.paymentStateManager = paymentStateManager2;
        this.inputComponentStyleMapper = mapper;
        this.inputComponentStateMapper = mapper2;
        this.componentState = provideViewState(countryComponentStyle.getInputStyle());
        this.componentStyle = provideViewStyle(countryComponentStyle.getInputStyle());
    }

    /* access modifiers changed from: private */
    public final void maybeShowErrorMessage(Country country) {
        if (this.paymentStateManager.getVisitedCountryPicker().getValue().booleanValue()) {
            TextLabelState errorState = this.componentState.getErrorState();
            if (country == Country.INVALID_COUNTRY) {
                errorState.isVisible().setValue(Boolean.TRUE);
                errorState.getTextId().setValue(Integer.valueOf(R.string.cko_billing_form_input_field_phone_country_error));
                return;
            }
            errorState.isVisible().setValue(Boolean.FALSE);
        }
    }

    private final InputComponentState provideViewState(InputComponentStyle inputComponentStyle) {
        return this.inputComponentStateMapper.map(inputComponentStyle);
    }

    private final InputComponentViewStyle provideViewStyle(InputComponentStyle inputComponentStyle) {
        InputComponentViewStyle map = this.inputComponentStyleMapper.map(inputComponentStyle);
        return InputComponentViewStyle.copy$default(map, (TextLabelViewStyle) null, (TextLabelViewStyle) null, (TextLabelViewStyle) null, InputFieldViewStyle.m9274copyRTRN5YQ$default(map.getInputFieldStyle(), (Modifier) null, false, true, (TextStyle) null, (Function2) null, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, (MutableInteractionSource) null, (Shape) null, (Shape) null, (InputFieldColors) null, 0.0f, 0.0f, false, 131065, (Object) null), (TextLabelViewStyle) null, (Modifier) null, false, 119, (Object) null);
    }

    @NotNull
    public final InputComponentState getComponentState() {
        return this.componentState;
    }

    @NotNull
    public final InputComponentViewStyle getComponentStyle() {
        return this.componentStyle;
    }

    public final void prepare(@NotNull Function1<? super Country, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onCountryUpdated");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new CountryViewModel$prepare$1(this, function1, (Continuation<? super CountryViewModel$prepare$1>) null), 3, (Object) null);
    }
}
