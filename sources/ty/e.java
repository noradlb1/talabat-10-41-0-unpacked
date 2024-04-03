package ty;

import android.view.View;
import com.talabat.wallet.ui.subscriptionManagement.view.fragment.SubscriptionDetailFragment;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubscriptionDetailFragment f24124b;

    public /* synthetic */ e(SubscriptionDetailFragment subscriptionDetailFragment) {
        this.f24124b = subscriptionDetailFragment;
    }

    public final void onClick(View view) {
        SubscriptionDetailFragment.m6034addCancelSubscriptionListener$lambda2(this.f24124b, view);
    }
}
