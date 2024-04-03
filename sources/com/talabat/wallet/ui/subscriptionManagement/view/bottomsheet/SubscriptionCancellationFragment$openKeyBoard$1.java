package com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet;

import androidx.core.widget.NestedScrollView;
import com.talabat.wallet.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionCancellationFragment$openKeyBoard$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubscriptionCancellationFragment f12727g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriptionCancellationFragment$openKeyBoard$1(SubscriptionCancellationFragment subscriptionCancellationFragment) {
        super(0);
        this.f12727g = subscriptionCancellationFragment;
    }

    public final void invoke() {
        ((NestedScrollView) this.f12727g._$_findCachedViewById(R.id.container_all)).fullScroll(130);
    }
}
