package ct;

import android.view.View;
import com.talabat.restaurants.PickupTooltipViewInitializer;
import com.talabat.restaurants.RestaurantsListScreenRefactor;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantsListScreenRefactor f61809b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PickupTooltipViewInitializer f61810c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f61811d;

    public /* synthetic */ a(RestaurantsListScreenRefactor restaurantsListScreenRefactor, PickupTooltipViewInitializer pickupTooltipViewInitializer, View view) {
        this.f61809b = restaurantsListScreenRefactor;
        this.f61810c = pickupTooltipViewInitializer;
        this.f61811d = view;
    }

    public final void onClick(View view) {
        PickupTooltipViewInitializer.m10717accept$lambda1$lambda0(this.f61809b, this.f61810c, this.f61811d, view);
    }
}
