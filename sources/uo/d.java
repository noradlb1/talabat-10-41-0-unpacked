package uo;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.checkout.SubscriptionAtCheckoutBannerView;
import com.talabat.feature.tpro.presentation.model.SubscriptionsErrorDisplayModel;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubscriptionAtCheckoutBannerView f62950a;

    public /* synthetic */ d(SubscriptionAtCheckoutBannerView subscriptionAtCheckoutBannerView) {
        this.f62950a = subscriptionAtCheckoutBannerView;
    }

    public final void onChanged(Object obj) {
        SubscriptionAtCheckoutBannerView.m10375setupObservers$lambda2(this.f62950a, (SubscriptionsErrorDisplayModel) obj);
    }
}
