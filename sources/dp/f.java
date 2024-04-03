package dp;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.management.details.TProSubscriptionDetailsFragment;

public final /* synthetic */ class f implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TProSubscriptionDetailsFragment f61949a;

    public /* synthetic */ f(TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment) {
        this.f61949a = tProSubscriptionDetailsFragment;
    }

    public final void onChanged(Object obj) {
        this.f61949a.onAutoRenewalCanceledFromBanner(((Boolean) obj).booleanValue());
    }
}
