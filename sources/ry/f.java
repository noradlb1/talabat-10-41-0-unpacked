package ry;

import android.view.View;
import com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet.SubscriptionCancellationFragment;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubscriptionCancellationFragment f24094b;

    public /* synthetic */ f(SubscriptionCancellationFragment subscriptionCancellationFragment) {
        this.f24094b = subscriptionCancellationFragment;
    }

    public final void onClick(View view) {
        SubscriptionCancellationFragment.m6031addDismissOnSuccessScreenListener$lambda4(this.f24094b, view);
    }
}
