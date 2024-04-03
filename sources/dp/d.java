package dp;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.management.details.TProSubscriptionDetailsFragment;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TProSubscriptionDetailsFragment f61946a;

    public /* synthetic */ d(TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment) {
        this.f61946a = tProSubscriptionDetailsFragment;
    }

    public final void onChanged(Object obj) {
        this.f61946a.onCancelFreeTrial(((Boolean) obj).booleanValue());
    }
}
