package mq;

import androidx.lifecycle.Observer;
import com.talabat.fragments.RateRestaurantFragment;
import com.talabat.rating.presentation.viewstate.RatingParadigm;

public final /* synthetic */ class q implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RateRestaurantFragment f62332a;

    public /* synthetic */ q(RateRestaurantFragment rateRestaurantFragment) {
        this.f62332a = rateRestaurantFragment;
    }

    public final void onChanged(Object obj) {
        this.f62332a.observeRatingViewChanges((RatingParadigm) obj);
    }
}
