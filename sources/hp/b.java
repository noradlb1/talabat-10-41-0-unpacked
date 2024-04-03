package hp;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.talabat.feature.tpro.presentation.management.details.viewmodel.TproSubscriptionDetailsViewModel;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f62128a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TproSubscriptionDetailsViewModel f62129b;

    public /* synthetic */ b(MediatorLiveData mediatorLiveData, TproSubscriptionDetailsViewModel tproSubscriptionDetailsViewModel) {
        this.f62128a = mediatorLiveData;
        this.f62129b = tproSubscriptionDetailsViewModel;
    }

    public final void onChanged(Object obj) {
        TproSubscriptionDetailsViewModel.m10411setupMediator$lambda2$lambda1(this.f62128a, this.f62129b, (Boolean) obj);
    }
}
