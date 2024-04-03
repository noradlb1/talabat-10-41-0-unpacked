package uo;

import android.view.View;
import com.talabat.feature.tpro.presentation.checkout.SubscriptionAtCheckoutBannerView;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f62947b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SubscriptionAtCheckoutBannerView f62948c;

    public /* synthetic */ b(Function1 function1, SubscriptionAtCheckoutBannerView subscriptionAtCheckoutBannerView) {
        this.f62947b = function1;
        this.f62948c = subscriptionAtCheckoutBannerView;
    }

    public final void onClick(View view) {
        SubscriptionAtCheckoutBannerView.m10373setTermsAndConditionsClick$lambda5(this.f62947b, this.f62948c, view);
    }
}
