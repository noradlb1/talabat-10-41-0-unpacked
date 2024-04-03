package com.checkout.frames.api;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.fragment.app.Fragment;
import com.checkout.frames.screen.paymentform.PaymentFormConfig;
import com.checkout.frames.screen.paymentform.PaymentFormScreenKt;
import com.checkout.threedsecure.Executor;
import com.checkout.threedsecure.model.ThreeDSRequest;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.platform.engine.support.hierarchical.DefaultParallelExecutionConfigurationStrategy;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0007J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007J\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/checkout/frames/api/PaymentFormMediator;", "", "config", "Lcom/checkout/frames/screen/paymentform/PaymentFormConfig;", "(Lcom/checkout/frames/screen/paymentform/PaymentFormConfig;)V", "threeDSExecutor", "Lcom/checkout/threedsecure/Executor;", "Lcom/checkout/threedsecure/model/ThreeDSRequest;", "getThreeDSExecutor", "()Lcom/checkout/threedsecure/Executor;", "threeDSExecutor$delegate", "Lkotlin/Lazy;", "PaymentForm", "", "(Landroidx/compose/runtime/Composer;I)V", "handleThreeDS", "request", "provideFragmentContent", "Landroid/view/View;", "fragment", "Landroidx/fragment/app/Fragment;", "strategy", "Landroidx/compose/ui/platform/ViewCompositionStrategy;", "setActivityContent", "activity", "Landroidx/activity/ComponentActivity;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PaymentFormMediator {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    @NotNull
    public final PaymentFormConfig config;
    @NotNull
    private final Lazy threeDSExecutor$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new PaymentFormMediator$threeDSExecutor$2(this));

    public PaymentFormMediator(@NotNull PaymentFormConfig paymentFormConfig) {
        Intrinsics.checkNotNullParameter(paymentFormConfig, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        this.config = paymentFormConfig;
    }

    private final Executor<ThreeDSRequest> getThreeDSExecutor() {
        return (Executor) this.threeDSExecutor$delegate.getValue();
    }

    public static /* synthetic */ View provideFragmentContent$default(PaymentFormMediator paymentFormMediator, Fragment fragment, ViewCompositionStrategy viewCompositionStrategy, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            viewCompositionStrategy = ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE;
        }
        return paymentFormMediator.provideFragmentContent(fragment, viewCompositionStrategy);
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void PaymentForm(@Nullable Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(2079947923);
        PaymentFormScreenKt.PaymentFormScreen(this.config, startRestartGroup, 8);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new PaymentFormMediator$PaymentForm$1(this, i11));
        }
    }

    public final void handleThreeDS(@NotNull ThreeDSRequest threeDSRequest) {
        Intrinsics.checkNotNullParameter(threeDSRequest, "request");
        getThreeDSExecutor().execute(threeDSRequest);
    }

    @NotNull
    @JvmOverloads
    public final View provideFragmentContent(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        return provideFragmentContent$default(this, fragment, (ViewCompositionStrategy) null, 2, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final View provideFragmentContent(@NotNull Fragment fragment, @NotNull ViewCompositionStrategy viewCompositionStrategy) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(viewCompositionStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        Context requireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
        ComposeView composeView = new ComposeView(requireContext, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        composeView.setViewCompositionStrategy(viewCompositionStrategy);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(175838748, true, new PaymentFormMediator$provideFragmentContent$1$1(this)));
        return composeView;
    }

    public final void setActivityContent(@NotNull ComponentActivity componentActivity) {
        Intrinsics.checkNotNullParameter(componentActivity, "activity");
        ComponentActivityKt.setContent$default(componentActivity, (CompositionContext) null, ComposableLambdaKt.composableLambdaInstance(-705165046, true, new PaymentFormMediator$setActivityContent$1(this)), 1, (Object) null);
    }
}
