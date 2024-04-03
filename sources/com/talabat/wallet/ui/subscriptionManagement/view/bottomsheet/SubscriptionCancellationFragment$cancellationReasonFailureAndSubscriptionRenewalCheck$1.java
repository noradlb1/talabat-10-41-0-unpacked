package com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet;

import android.view.View;
import com.talabat.talabatcommon.utils.ProgressBarLoading;
import com.talabat.wallet.R;
import com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet.SubscriptionCancellationFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "invoke", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionCancellationFragment$cancellationReasonFailureAndSubscriptionRenewalCheck$1 extends Lambda implements Function2<Boolean, Boolean, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubscriptionCancellationFragment f12725g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionCancellationFragment$cancellationReasonFailureAndSubscriptionRenewalCheck$1(SubscriptionCancellationFragment subscriptionCancellationFragment) {
        super(2);
        this.f12725g = subscriptionCancellationFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Boolean) obj, (Boolean) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Boolean bool, @NotNull Boolean bool2) {
        Intrinsics.checkNotNullParameter(bool, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(bool2, "<anonymous parameter 1>");
        ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
        View _$_findCachedViewById = this.f12725g._$_findCachedViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "progress_bar");
        progressBarLoading.hideProgress(_$_findCachedViewById);
        this.f12725g._$_findCachedViewById(R.id.cancel_subscription_success_container).setVisibility(0);
        this.f12725g._$_findCachedViewById(R.id.initialize_subscription_cancellation).setVisibility(8);
        final SubscriptionCancellationFragment subscriptionCancellationFragment = this.f12725g;
        subscriptionCancellationFragment.delay(5000, new Function0<Unit>() {
            public final void invoke() {
                SubscriptionCancellationFragment.SubscriptionCancellationFragmentInterface access$getMSubscriptionCancellationFragmentInterface$p = subscriptionCancellationFragment.mSubscriptionCancellationFragmentInterface;
                if (access$getMSubscriptionCancellationFragmentInterface$p != null) {
                    access$getMSubscriptionCancellationFragmentInterface$p.onBottomSheetClosed();
                }
            }
        });
    }
}
