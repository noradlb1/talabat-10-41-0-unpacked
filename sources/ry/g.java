package ry;

import android.view.View;
import com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet.SubscriptionCancellationFragment;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubscriptionCancellationFragment f24095b;

    public /* synthetic */ g(SubscriptionCancellationFragment subscriptionCancellationFragment) {
        this.f24095b = subscriptionCancellationFragment;
    }

    public final void onClick(View view) {
        SubscriptionCancellationFragment.m6029addConfirmSubscriptionCancellationListener$lambda11(this.f24095b, view);
    }
}
