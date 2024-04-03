package xe;

import android.view.View;
import com.talabat.adapters.RestaurantListQuicklyFilterAdapter;
import datamodels.QuickFilter;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantListQuicklyFilterAdapter f57984b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ QuickFilter f57985c;

    public /* synthetic */ e(RestaurantListQuicklyFilterAdapter restaurantListQuicklyFilterAdapter, QuickFilter quickFilter) {
        this.f57984b = restaurantListQuicklyFilterAdapter;
        this.f57985c = quickFilter;
    }

    public final void onClick(View view) {
        this.f57984b.lambda$onBindViewHolder$0(this.f57985c, view);
    }
}
