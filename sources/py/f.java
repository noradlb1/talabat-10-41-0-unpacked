package py;

import android.view.View;
import com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionPlanFragment;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubscriptionPlanFragment f24068b;

    public /* synthetic */ f(SubscriptionPlanFragment subscriptionPlanFragment) {
        this.f24068b = subscriptionPlanFragment;
    }

    public final void onClick(View view) {
        SubscriptionPlanFragment.m6023setBackButtonListener$lambda3(this.f24068b, view);
    }
}
