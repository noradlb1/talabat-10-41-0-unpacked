package hp;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.tpro.presentation.management.details.viewmodel.TproSubscriptionDetailsViewModel;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f62126a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TproSubscriptionDetailsViewModel f62127b;

    public /* synthetic */ a(MediatorLiveData mediatorLiveData, TproSubscriptionDetailsViewModel tproSubscriptionDetailsViewModel) {
        this.f62126a = mediatorLiveData;
        this.f62127b = tproSubscriptionDetailsViewModel;
    }

    public final void onChanged(Object obj) {
        TproSubscriptionDetailsViewModel.m10410setupMediator$lambda2$lambda0(this.f62126a, this.f62127b, (Subscription) obj);
    }
}
