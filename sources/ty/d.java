package ty;

import android.view.View;
import com.talabat.wallet.ui.subscriptionManagement.view.fragment.SubscriptionDetailFragment;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubscriptionDetailFragment f24123b;

    public /* synthetic */ d(SubscriptionDetailFragment subscriptionDetailFragment) {
        this.f24123b = subscriptionDetailFragment;
    }

    public final void onClick(View view) {
        SubscriptionDetailFragment.m6036addTermsAndConditionListeners$lambda9(this.f24123b, view);
    }
}
