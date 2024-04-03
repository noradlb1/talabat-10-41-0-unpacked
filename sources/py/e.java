package py;

import android.view.View;
import com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionManagementFragment;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubscriptionManagementFragment f24067b;

    public /* synthetic */ e(SubscriptionManagementFragment subscriptionManagementFragment) {
        this.f24067b = subscriptionManagementFragment;
    }

    public final void onClick(View view) {
        SubscriptionManagementFragment.m6022viewAllPlansListener$lambda8(this.f24067b, view);
    }
}
