package ue;

import androidx.lifecycle.Observer;
import com.talabat.RestaurantMenuScreenR;
import java.util.ArrayList;

public final /* synthetic */ class dd implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RestaurantMenuScreenR f57493a;

    public /* synthetic */ dd(RestaurantMenuScreenR restaurantMenuScreenR) {
        this.f57493a = restaurantMenuScreenR;
    }

    public final void onChanged(Object obj) {
        this.f57493a.lambda$observeApiResponses$15((ArrayList) obj);
    }
}
