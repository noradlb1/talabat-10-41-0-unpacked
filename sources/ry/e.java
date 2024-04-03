package ry;

import android.view.View;
import com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet.SubscriptionCancellationFragment;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubscriptionCancellationFragment f24093b;

    public /* synthetic */ e(SubscriptionCancellationFragment subscriptionCancellationFragment) {
        this.f24093b = subscriptionCancellationFragment;
    }

    public final void onClick(View view) {
        SubscriptionCancellationFragment.m6030addDismissOnFailureScreenListener$lambda3(this.f24093b, view);
    }
}
