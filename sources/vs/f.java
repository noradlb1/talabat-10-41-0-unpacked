package vs;

import androidx.lifecycle.Observer;
import com.talabat.offering.presentation.displaymodel.VendorsDisplayModel;
import com.talabat.offering.ui.OfferCollectionActivity;

public final /* synthetic */ class f implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OfferCollectionActivity f62974a;

    public /* synthetic */ f(OfferCollectionActivity offerCollectionActivity) {
        this.f62974a = offerCollectionActivity;
    }

    public final void onChanged(Object obj) {
        OfferCollectionActivity.m10690registerObservable$lambda5(this.f62974a, (VendorsDisplayModel) obj);
    }
}
