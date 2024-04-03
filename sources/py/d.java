package py;

import android.view.View;
import com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionManagementFragment;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubscriptionManagementFragment f24066b;

    public /* synthetic */ d(SubscriptionManagementFragment subscriptionManagementFragment) {
        this.f24066b = subscriptionManagementFragment;
    }

    public final void onClick(View view) {
        SubscriptionManagementFragment.m6021setBackButtonListener$lambda13(this.f24066b, view);
    }
}
