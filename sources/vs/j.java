package vs;

import androidx.lifecycle.Observer;
import com.talabat.offering.presentation.displaymodel.OTPDisplayModel;
import com.talabat.offering.ui.OfferCollectionActivity;

public final /* synthetic */ class j implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OfferCollectionActivity f62978a;

    public /* synthetic */ j(OfferCollectionActivity offerCollectionActivity) {
        this.f62978a = offerCollectionActivity;
    }

    public final void onChanged(Object obj) {
        OfferCollectionActivity.m10694registerObservable$lambda9(this.f62978a, (OTPDisplayModel) obj);
    }
}
