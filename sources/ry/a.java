package ry;

import android.view.View;
import com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet.SubscriptionCancellationFragment;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubscriptionCancellationFragment f24090b;

    public /* synthetic */ a(SubscriptionCancellationFragment subscriptionCancellationFragment) {
        this.f24090b = subscriptionCancellationFragment;
    }

    public final void onClick(View view) {
        SubscriptionCancellationFragment.m6027addCancelSubscriptionCancellationListener$lambda1(this.f24090b, view);
    }
}
