package ty;

import android.view.View;
import com.talabat.wallet.ui.subscriptionManagement.view.fragment.SubscriptionDetailFragment;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubscriptionDetailFragment f24121b;

    public /* synthetic */ a(SubscriptionDetailFragment subscriptionDetailFragment) {
        this.f24121b = subscriptionDetailFragment;
    }

    public final void onClick(View view) {
        SubscriptionDetailFragment.m6033addBackButtonListener$lambda17(this.f24121b, view);
    }
}
