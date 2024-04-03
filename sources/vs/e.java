package vs;

import androidx.lifecycle.Observer;
import com.talabat.offering.presentation.displaymodel.HeaderDisplayModel;
import com.talabat.offering.ui.OfferCollectionActivity;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OfferCollectionActivity f62973a;

    public /* synthetic */ e(OfferCollectionActivity offerCollectionActivity) {
        this.f62973a = offerCollectionActivity;
    }

    public final void onChanged(Object obj) {
        OfferCollectionActivity.m10689registerObservable$lambda3(this.f62973a, (HeaderDisplayModel) obj);
    }
}
