package dp;

import androidx.lifecycle.Observer;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.tpro.presentation.management.details.TProSubscriptionDetailsFragment;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TProSubscriptionDetailsFragment f61943a;

    public /* synthetic */ a(TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment) {
        this.f61943a = tProSubscriptionDetailsFragment;
    }

    public final void onChanged(Object obj) {
        this.f61943a.onDataLoaded((Subscription) obj);
    }
}
