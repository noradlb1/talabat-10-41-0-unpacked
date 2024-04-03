package dp;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.management.details.TProSubscriptionDetailsFragment;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TProSubscriptionDetailsFragment f61945a;

    public /* synthetic */ c(TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment) {
        this.f61945a = tProSubscriptionDetailsFragment;
    }

    public final void onChanged(Object obj) {
        this.f61945a.onRenewalEnabled((String) obj);
    }
}
