package com.checkout.frames.component.addresssummary;

import androidx.compose.runtime.MutableState;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.di.base.InjectionClient;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.di.component.AddressSummaryViewModelSubComponent;
import com.checkout.frames.screen.manager.PaymentStateManager;
import com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle;
import com.checkout.frames.style.view.addresssummary.AddressSummaryComponentViewStyle;
import d2.h;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0016B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/checkout/frames/component/addresssummary/AddressSummaryViewModel;", "Landroidx/lifecycle/ViewModel;", "style", "Lcom/checkout/frames/style/component/addresssummary/AddressSummaryComponentStyle;", "paymentStateManager", "Lcom/checkout/frames/screen/manager/PaymentStateManager;", "componentStateMapper", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/component/addresssummary/AddressSummaryComponentState;", "componentStyleMapper", "Lcom/checkout/frames/style/view/addresssummary/AddressSummaryComponentViewStyle;", "(Lcom/checkout/frames/style/component/addresssummary/AddressSummaryComponentStyle;Lcom/checkout/frames/screen/manager/PaymentStateManager;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;)V", "componentState", "getComponentState", "()Lcom/checkout/frames/component/addresssummary/AddressSummaryComponentState;", "componentStyle", "getComponentStyle", "()Lcom/checkout/frames/style/view/addresssummary/AddressSummaryComponentViewStyle;", "prepare", "Lkotlinx/coroutines/Job;", "provideState", "provideViewStyle", "Factory", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AddressSummaryViewModel extends ViewModel {
    @NotNull
    private final AddressSummaryComponentState componentState;
    @NotNull
    private final Mapper<AddressSummaryComponentStyle, AddressSummaryComponentState> componentStateMapper;
    @NotNull
    private final AddressSummaryComponentViewStyle componentStyle;
    @NotNull
    private final Mapper<AddressSummaryComponentStyle, AddressSummaryComponentViewStyle> componentStyleMapper;
    /* access modifiers changed from: private */
    @NotNull
    public final PaymentStateManager paymentStateManager;
    @NotNull
    private final AddressSummaryComponentStyle style;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J%\u0010\u000f\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/checkout/frames/component/addresssummary/AddressSummaryViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/checkout/frames/di/base/InjectionClient;", "injector", "Lcom/checkout/frames/di/base/Injector;", "style", "Lcom/checkout/frames/style/component/addresssummary/AddressSummaryComponentStyle;", "(Lcom/checkout/frames/di/base/Injector;Lcom/checkout/frames/style/component/addresssummary/AddressSummaryComponentStyle;)V", "subComponentProvider", "Ljavax/inject/Provider;", "Lcom/checkout/frames/di/component/AddressSummaryViewModelSubComponent$Builder;", "getSubComponentProvider", "()Ljavax/inject/Provider;", "setSubComponentProvider", "(Ljavax/inject/Provider;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Factory implements ViewModelProvider.Factory, InjectionClient {
        @NotNull
        private final Injector injector;
        @NotNull
        private final AddressSummaryComponentStyle style;
        @Inject
        public Provider<AddressSummaryViewModelSubComponent.Builder> subComponentProvider;

        public Factory(@NotNull Injector injector2, @NotNull AddressSummaryComponentStyle addressSummaryComponentStyle) {
            Intrinsics.checkNotNullParameter(injector2, "injector");
            Intrinsics.checkNotNullParameter(addressSummaryComponentStyle, "style");
            this.injector = injector2;
            this.style = addressSummaryComponentStyle;
        }

        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            this.injector.inject(this);
            T addressSummaryViewModel = getSubComponentProvider().get().style(this.style).build().getAddressSummaryViewModel();
            Intrinsics.checkNotNull(addressSummaryViewModel, "null cannot be cast to non-null type T of com.checkout.frames.component.addresssummary.AddressSummaryViewModel.Factory.create");
            return addressSummaryViewModel;
        }

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return h.b(this, cls, creationExtras);
        }

        @NotNull
        public final Provider<AddressSummaryViewModelSubComponent.Builder> getSubComponentProvider() {
            Provider<AddressSummaryViewModelSubComponent.Builder> provider = this.subComponentProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("subComponentProvider");
            return null;
        }

        public final void setSubComponentProvider(@NotNull Provider<AddressSummaryViewModelSubComponent.Builder> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.subComponentProvider = provider;
        }
    }

    @Inject
    public AddressSummaryViewModel(@NotNull AddressSummaryComponentStyle addressSummaryComponentStyle, @NotNull PaymentStateManager paymentStateManager2, @NotNull Mapper<AddressSummaryComponentStyle, AddressSummaryComponentState> mapper, @NotNull Mapper<AddressSummaryComponentStyle, AddressSummaryComponentViewStyle> mapper2) {
        Intrinsics.checkNotNullParameter(addressSummaryComponentStyle, "style");
        Intrinsics.checkNotNullParameter(paymentStateManager2, "paymentStateManager");
        Intrinsics.checkNotNullParameter(mapper, "componentStateMapper");
        Intrinsics.checkNotNullParameter(mapper2, "componentStyleMapper");
        this.style = addressSummaryComponentStyle;
        this.paymentStateManager = paymentStateManager2;
        this.componentStateMapper = mapper;
        this.componentStyleMapper = mapper2;
        this.componentState = provideState(addressSummaryComponentStyle);
        this.componentStyle = provideViewStyle(addressSummaryComponentStyle);
    }

    private final AddressSummaryComponentState provideState(AddressSummaryComponentStyle addressSummaryComponentStyle) {
        AddressSummaryComponentState map = this.componentStateMapper.map(addressSummaryComponentStyle);
        MutableState<Boolean> isEnabled = map.getAddAddressButtonState().isEnabled();
        Boolean bool = Boolean.TRUE;
        isEnabled.setValue(bool);
        map.getEditAddressButtonState().isEnabled().setValue(bool);
        return map;
    }

    private final AddressSummaryComponentViewStyle provideViewStyle(AddressSummaryComponentStyle addressSummaryComponentStyle) {
        AddressSummaryComponentViewStyle map = this.componentStyleMapper.map(addressSummaryComponentStyle);
        map.getAddAddressButtonStyle().getTextStyle().setTextMaxWidth(true);
        map.getSummarySectionStyle().getEditAddressButtonStyle().getTextStyle().setTextMaxWidth(true);
        return map;
    }

    @NotNull
    public final AddressSummaryComponentState getComponentState() {
        return this.componentState;
    }

    @NotNull
    public final AddressSummaryComponentViewStyle getComponentStyle() {
        return this.componentStyle;
    }

    @NotNull
    public final Job prepare() {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AddressSummaryViewModel$prepare$1(this, (Continuation<? super AddressSummaryViewModel$prepare$1>) null), 3, (Object) null);
    }
}
