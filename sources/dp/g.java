package dp;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.management.details.TProSubscriptionDetailsFragment;

public final /* synthetic */ class g implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TProSubscriptionDetailsFragment f61950a;

    public /* synthetic */ g(TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment) {
        this.f61950a = tProSubscriptionDetailsFragment;
    }

    public final void onChanged(Object obj) {
        this.f61950a.onSubscriptionAutoRenewTurnedOff(((Boolean) obj).booleanValue());
    }
}
