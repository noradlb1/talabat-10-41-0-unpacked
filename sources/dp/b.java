package dp;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.management.details.TProSubscriptionDetailsFragment;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TProSubscriptionDetailsFragment f61944a;

    public /* synthetic */ b(TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment) {
        this.f61944a = tProSubscriptionDetailsFragment;
    }

    public final void onChanged(Object obj) {
        this.f61944a.onRenewalCanceled((String) obj);
    }
}
