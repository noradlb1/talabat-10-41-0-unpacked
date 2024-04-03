package dp;

import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.management.details.TProSubscriptionDetailsFragment;
import com.talabat.feature.tpro.presentation.management.details.viewmodel.TproSubscriptionDetailsViewModel;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TproSubscriptionDetailsViewModel f61947a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TProSubscriptionDetailsFragment f61948b;

    public /* synthetic */ e(TproSubscriptionDetailsViewModel tproSubscriptionDetailsViewModel, TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment) {
        this.f61947a = tproSubscriptionDetailsViewModel;
        this.f61948b = tProSubscriptionDetailsFragment;
    }

    public final void onChanged(Object obj) {
        TProSubscriptionDetailsFragment.m10397observe$lambda5$lambda3(this.f61947a, this.f61948b, (Boolean) obj);
    }
}
