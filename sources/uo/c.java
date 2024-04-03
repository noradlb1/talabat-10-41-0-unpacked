package uo;

import androidx.lifecycle.Observer;
import com.talabat.feature.subscriptions.domain.model.SubscriptionMultiPlan;
import com.talabat.feature.tpro.presentation.checkout.SubscriptionAtCheckoutBannerView;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubscriptionAtCheckoutBannerView f62949a;

    public /* synthetic */ c(SubscriptionAtCheckoutBannerView subscriptionAtCheckoutBannerView) {
        this.f62949a = subscriptionAtCheckoutBannerView;
    }

    public final void onChanged(Object obj) {
        SubscriptionAtCheckoutBannerView.m10374setupObservers$lambda0(this.f62949a, (SubscriptionMultiPlan) obj);
    }
}
