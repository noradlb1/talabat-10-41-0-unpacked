package dp;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.management.details.TProSubscriptionDetailsFragment;

public final /* synthetic */ class h implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TProSubscriptionDetailsFragment f61951a;

    public /* synthetic */ h(TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment) {
        this.f61951a = tProSubscriptionDetailsFragment;
    }

    public final void onChanged(Object obj) {
        this.f61951a.onSubscriptionAutoRenewTurnedOn(((Boolean) obj).booleanValue());
    }
}
