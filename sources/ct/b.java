package ct;

import android.view.View;
import com.talabat.restaurants.PickupTooltipViewInitializer;
import com.talabat.restaurants.RestaurantsListScreenRefactor;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantsListScreenRefactor f61812b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PickupTooltipViewInitializer f61813c;

    public /* synthetic */ b(RestaurantsListScreenRefactor restaurantsListScreenRefactor, PickupTooltipViewInitializer pickupTooltipViewInitializer) {
        this.f61812b = restaurantsListScreenRefactor;
        this.f61813c = pickupTooltipViewInitializer;
    }

    public final void onClick(View view) {
        PickupTooltipViewInitializer.m10718accept$lambda2(this.f61812b, this.f61813c, view);
    }
}
