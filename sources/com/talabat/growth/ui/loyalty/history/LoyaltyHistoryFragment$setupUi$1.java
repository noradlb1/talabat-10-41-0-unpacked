package com.talabat.growth.ui.loyalty.history;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyHistoryFragment$setupUi$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LoyaltyHistoryFragment f60692g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoyaltyHistoryFragment$setupUi$1(LoyaltyHistoryFragment loyaltyHistoryFragment) {
        super(0);
        this.f60692g = loyaltyHistoryFragment;
    }

    public final void invoke() {
        FragmentActivity activity = this.f60692g.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }
}
