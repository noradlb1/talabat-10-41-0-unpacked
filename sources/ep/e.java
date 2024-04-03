package ep;

import android.view.View;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.tpro.presentation.management.details.adapter.viewholder.TproDetailsManageSubscriptionViewHolder;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TproDetailsManageSubscriptionViewHolder f61989b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Subscription f61990c;

    public /* synthetic */ e(TproDetailsManageSubscriptionViewHolder tproDetailsManageSubscriptionViewHolder, Subscription subscription) {
        this.f61989b = tproDetailsManageSubscriptionViewHolder;
        this.f61990c = subscription;
    }

    public final void onClick(View view) {
        TproDetailsManageSubscriptionViewHolder.m10402bind$lambda3$lambda2(this.f61989b, this.f61990c, view);
    }
}
