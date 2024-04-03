package ry;

import android.view.View;
import com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet.SubscriptionCancellationFragment;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubscriptionCancellationFragment f24092b;

    public /* synthetic */ d(SubscriptionCancellationFragment subscriptionCancellationFragment) {
        this.f24092b = subscriptionCancellationFragment;
    }

    public final void onClick(View view) {
        SubscriptionCancellationFragment.m6026addCancelIconClickListener$lambda0(this.f24092b, view);
    }
}
