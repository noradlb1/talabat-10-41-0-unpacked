package ry;

import android.view.View;
import com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet.SubscriptionCancellationFragment;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubscriptionCancellationFragment f24091b;

    public /* synthetic */ b(SubscriptionCancellationFragment subscriptionCancellationFragment) {
        this.f24091b = subscriptionCancellationFragment;
    }

    public final void onClick(View view) {
        SubscriptionCancellationFragment.m6028addCancellationFeedbackListener$lambda7(this.f24091b, view);
    }
}
