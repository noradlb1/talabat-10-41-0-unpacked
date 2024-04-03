package py;

import android.view.View;
import com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionManagementFragment;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubscriptionManagementFragment f24065b;

    public /* synthetic */ c(SubscriptionManagementFragment subscriptionManagementFragment) {
        this.f24065b = subscriptionManagementFragment;
    }

    public final void onClick(View view) {
        SubscriptionManagementFragment.m6020addChangeDefaultCardListener$lambda4(this.f24065b, view);
    }
}
