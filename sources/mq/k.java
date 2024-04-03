package mq;

import androidx.lifecycle.Observer;
import com.talabat.fragments.RateDeliveryFragment;
import com.talabat.rating.presentation.viewstate.RatingParadigm;

public final /* synthetic */ class k implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RateDeliveryFragment f62326a;

    public /* synthetic */ k(RateDeliveryFragment rateDeliveryFragment) {
        this.f62326a = rateDeliveryFragment;
    }

    public final void onChanged(Object obj) {
        this.f62326a.observeRatingViewChanges((RatingParadigm) obj);
    }
}
