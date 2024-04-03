package dp;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.management.details.TProSubscriptionDetailsFragment;

public final /* synthetic */ class i implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TProSubscriptionDetailsFragment f61952a;

    public /* synthetic */ i(TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment) {
        this.f61952a = tProSubscriptionDetailsFragment;
    }

    public final void onChanged(Object obj) {
        TProSubscriptionDetailsFragment.m10398observe$lambda5$lambda4(this.f61952a, (Boolean) obj);
    }
}
