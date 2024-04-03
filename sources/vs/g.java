package vs;

import androidx.lifecycle.Observer;
import com.talabat.offering.presentation.displaymodel.HeaderDisplayModel;
import com.talabat.offering.ui.OfferCollectionActivity;

public final /* synthetic */ class g implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OfferCollectionActivity f62975a;

    public /* synthetic */ g(OfferCollectionActivity offerCollectionActivity) {
        this.f62975a = offerCollectionActivity;
    }

    public final void onChanged(Object obj) {
        OfferCollectionActivity.m10691registerObservable$lambda6(this.f62975a, (HeaderDisplayModel) obj);
    }
}
