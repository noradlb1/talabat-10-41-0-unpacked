package vs;

import androidx.lifecycle.Observer;
import com.talabat.offering.presentation.displaymodel.UserSubscriptionDisplayModel;
import com.talabat.offering.ui.OfferCollectionActivity;

public final /* synthetic */ class h implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OfferCollectionActivity f62976a;

    public /* synthetic */ h(OfferCollectionActivity offerCollectionActivity) {
        this.f62976a = offerCollectionActivity;
    }

    public final void onChanged(Object obj) {
        OfferCollectionActivity.m10692registerObservable$lambda7(this.f62976a, (UserSubscriptionDisplayModel) obj);
    }
}
