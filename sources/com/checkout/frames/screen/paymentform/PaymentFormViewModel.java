package com.checkout.frames.screen.paymentform;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.checkout.base.model.CardScheme;
import com.checkout.base.model.Environment;
import com.checkout.frames.api.PaymentFlowHandler;
import com.checkout.frames.di.base.InjectionClient;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.di.injector.FramesInjector;
import com.visa.checkout.Profile;
import d2.h;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\tB\u0007\b\u0001¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/checkout/frames/screen/paymentform/PaymentFormViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "injector", "Lcom/checkout/frames/di/base/Injector;", "getInjector", "()Lcom/checkout/frames/di/base/Injector;", "setInjector", "(Lcom/checkout/frames/di/base/Injector;)V", "Factory", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PaymentFormViewModel extends ViewModel {
    public Injector injector;

    @NotNull
    public final Injector getInjector() {
        Injector injector2 = this.injector;
        if (injector2 != null) {
            return injector2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("injector");
        return null;
    }

    public final void setInjector(@NotNull Injector injector2) {
        Intrinsics.checkNotNullParameter(injector2, "<set-?>");
        this.injector = injector2;
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ%\u0010\u0017\u001a\u0002H\u0018\"\b\b\u0000\u0010\u0018*\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001bH\u0016¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/checkout/frames/screen/paymentform/PaymentFormViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/checkout/frames/di/base/InjectionClient;", "publicKey", "", "context", "Landroid/content/Context;", "environment", "Lcom/checkout/base/model/Environment;", "paymentFlowHandler", "Lcom/checkout/frames/api/PaymentFlowHandler;", "supportedCardSchemes", "", "Lcom/checkout/base/model/CardScheme;", "(Ljava/lang/String;Landroid/content/Context;Lcom/checkout/base/model/Environment;Lcom/checkout/frames/api/PaymentFlowHandler;Ljava/util/List;)V", "injector", "Lcom/checkout/frames/di/base/Injector;", "viewModel", "Lcom/checkout/frames/screen/paymentform/PaymentFormViewModel;", "getViewModel", "()Lcom/checkout/frames/screen/paymentform/PaymentFormViewModel;", "setViewModel", "(Lcom/checkout/frames/screen/paymentform/PaymentFormViewModel;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Factory implements ViewModelProvider.Factory, InjectionClient {
        @NotNull
        private final Context context;
        @NotNull
        private final Environment environment;
        private Injector injector;
        @NotNull
        private final PaymentFlowHandler paymentFlowHandler;
        @NotNull
        private final String publicKey;
        @NotNull
        private final List<CardScheme> supportedCardSchemes;
        @Inject
        public PaymentFormViewModel viewModel;

        public Factory(@NotNull String str, @NotNull Context context2, @NotNull Environment environment2, @NotNull PaymentFlowHandler paymentFlowHandler2, @NotNull List<? extends CardScheme> list) {
            Intrinsics.checkNotNullParameter(str, "publicKey");
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(environment2, Profile.ENVIRONMENT);
            Intrinsics.checkNotNullParameter(paymentFlowHandler2, "paymentFlowHandler");
            Intrinsics.checkNotNullParameter(list, "supportedCardSchemes");
            this.publicKey = str;
            this.context = context2;
            this.environment = environment2;
            this.paymentFlowHandler = paymentFlowHandler2;
            this.supportedCardSchemes = list;
        }

        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            Injector create$frames_release = FramesInjector.Companion.create$frames_release(this.publicKey, this.context, this.environment, this.paymentFlowHandler, this.supportedCardSchemes);
            this.injector = create$frames_release;
            Injector injector2 = null;
            if (create$frames_release == null) {
                Intrinsics.throwUninitializedPropertyAccessException("injector");
                create$frames_release = null;
            }
            create$frames_release.inject(this);
            PaymentFormViewModel viewModel2 = getViewModel();
            Injector injector3 = this.injector;
            if (injector3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("injector");
            } else {
                injector2 = injector3;
            }
            viewModel2.setInjector(injector2);
            T viewModel3 = getViewModel();
            Intrinsics.checkNotNull(viewModel3, "null cannot be cast to non-null type T of com.checkout.frames.screen.paymentform.PaymentFormViewModel.Factory.create");
            return viewModel3;
        }

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return h.b(this, cls, creationExtras);
        }

        @NotNull
        public final PaymentFormViewModel getViewModel() {
            PaymentFormViewModel paymentFormViewModel = this.viewModel;
            if (paymentFormViewModel != null) {
                return paymentFormViewModel;
            }
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            return null;
        }

        public final void setViewModel(@NotNull PaymentFormViewModel paymentFormViewModel) {
            Intrinsics.checkNotNullParameter(paymentFormViewModel, "<set-?>");
            this.viewModel = paymentFormViewModel;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Factory(String str, Context context2, Environment environment2, PaymentFlowHandler paymentFlowHandler2, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, context2, environment2, paymentFlowHandler2, (i11 & 16) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
        }
    }
}
