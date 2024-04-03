package ty;

import android.view.View;
import com.talabat.wallet.ui.subscriptionManagement.view.fragment.SubscriptionDetailFragment;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubscriptionDetailFragment f24125b;

    public /* synthetic */ f(SubscriptionDetailFragment subscriptionDetailFragment) {
        this.f24125b = subscriptionDetailFragment;
    }

    public final void onClick(View view) {
        SubscriptionDetailFragment.m6035addEnableAutoRenewListener$lambda5(this.f24125b, view);
    }
}
