package com.talabat.growth.ui.loyalty.burn.details;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BurnOptionsDetailsDialogFragment$subscriptionStatusRepository$2 extends Lambda implements Function0<ISubscriptionStatusRepository> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BurnOptionsDetailsDialogFragment f60633g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BurnOptionsDetailsDialogFragment$subscriptionStatusRepository$2(BurnOptionsDetailsDialogFragment burnOptionsDetailsDialogFragment) {
        super(0);
        this.f60633g = burnOptionsDetailsDialogFragment;
    }

    @NotNull
    public final ISubscriptionStatusRepository invoke() {
        FragmentActivity requireActivity = this.f60633g.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        return ((SubscriptionsFeatureApi) AndroidComponentsKt.apiContainer((Activity) requireActivity).getFeature(SubscriptionsFeatureApi.class)).getSubscriptionStatusRepository();
    }
}
