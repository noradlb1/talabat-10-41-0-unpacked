package ue;

import android.util.Pair;
import androidx.lifecycle.Observer;
import com.talabat.RestaurantMenuScreenR;

public final /* synthetic */ class ed implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RestaurantMenuScreenR f57514a;

    public /* synthetic */ ed(RestaurantMenuScreenR restaurantMenuScreenR) {
        this.f57514a = restaurantMenuScreenR;
    }

    public final void onChanged(Object obj) {
        this.f57514a.lambda$observeApiResponses$16((Pair) obj);
    }
}
