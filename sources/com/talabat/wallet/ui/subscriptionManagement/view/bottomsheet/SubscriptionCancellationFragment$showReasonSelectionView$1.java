package com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.talabat.feature.tpro.presentation.management.cancellation.reason.SubscriptionCancellationReasonBottomSheetFragment;
import com.talabat.talabatcommon.utils.ProgressBarLoading;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionCancellationReasonsDisplayModel;
import com.talabat.wallet.R;
import com.talabat.wallet.ui.subscriptionManagement.view.adapter.SubscriptionCancellationReasonAdapter;
import com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet.SubscriptionCancellationFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "subscriptionCancellationReasonsDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionCancellationReasonsDisplayModel;", "invoke", "(ZLcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionCancellationReasonsDisplayModel;)Lkotlin/Unit;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionCancellationFragment$showReasonSelectionView$1 extends Lambda implements Function2<Boolean, SubscriptionCancellationReasonsDisplayModel, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubscriptionCancellationFragment f12728g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionCancellationFragment$showReasonSelectionView$1(SubscriptionCancellationFragment subscriptionCancellationFragment) {
        super(2);
        this.f12728g = subscriptionCancellationFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), (SubscriptionCancellationReasonsDisplayModel) obj2);
    }

    @Nullable
    public final Unit invoke(boolean z11, @NotNull SubscriptionCancellationReasonsDisplayModel subscriptionCancellationReasonsDisplayModel) {
        Intrinsics.checkNotNullParameter(subscriptionCancellationReasonsDisplayModel, "subscriptionCancellationReasonsDisplayModel");
        SubscriptionCancellationReasonAdapter access$getSubscriptionCancellationReasonAdapter$p = this.f12728g.subscriptionCancellationReasonAdapter;
        if (access$getSubscriptionCancellationReasonAdapter$p != null) {
            access$getSubscriptionCancellationReasonAdapter$p.addItems(subscriptionCancellationReasonsDisplayModel.getSubscriptionCancellationReasons());
        }
        ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
        View _$_findCachedViewById = this.f12728g._$_findCachedViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "progress_bar");
        progressBarLoading.hideProgress(_$_findCachedViewById);
        SubscriptionCancellationFragment.SubscriptionCancellationFragmentInterface access$getMSubscriptionCancellationFragmentInterface$p = this.f12728g.mSubscriptionCancellationFragmentInterface;
        if (access$getMSubscriptionCancellationFragmentInterface$p != null) {
            access$getMSubscriptionCancellationFragmentInterface$p.onRefreshSubscriptionDetailScreen();
        }
        SubscriptionCancellationReasonBottomSheetFragment.Companion companion = SubscriptionCancellationReasonBottomSheetFragment.Companion;
        FragmentActivity requireActivity = this.f12728g.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        companion.show(requireActivity, this.f12728g.subscriptionMemberId);
        SubscriptionCancellationFragment.SubscriptionCancellationFragmentInterface access$getMSubscriptionCancellationFragmentInterface$p2 = this.f12728g.mSubscriptionCancellationFragmentInterface;
        if (access$getMSubscriptionCancellationFragmentInterface$p2 == null) {
            return null;
        }
        access$getMSubscriptionCancellationFragmentInterface$p2.onBottomSheetClosed();
        return Unit.INSTANCE;
    }
}
