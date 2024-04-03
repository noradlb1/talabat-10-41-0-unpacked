package vs;

import androidx.lifecycle.Observer;
import com.talabat.offering.presentation.displaymodel.OTPDisplayModel;
import com.talabat.offering.ui.OfferCollectionActivity;

public final /* synthetic */ class i implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OfferCollectionActivity f62977a;

    public /* synthetic */ i(OfferCollectionActivity offerCollectionActivity) {
        this.f62977a = offerCollectionActivity;
    }

    public final void onChanged(Object obj) {
        OfferCollectionActivity.m10693registerObservable$lambda8(this.f62977a, (OTPDisplayModel) obj);
    }
}
