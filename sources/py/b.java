package py;

import android.view.View;
import com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionManagementFragment;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubscriptionManagementFragment f24064b;

    public /* synthetic */ b(SubscriptionManagementFragment subscriptionManagementFragment) {
        this.f24064b = subscriptionManagementFragment;
    }

    public final void onClick(View view) {
        SubscriptionManagementFragment.m6019addCardViewListener$lambda5(this.f24064b, view);
    }
}
