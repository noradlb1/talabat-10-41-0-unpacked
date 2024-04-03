package yf;

import com.talabat.collectiondetails.ui.restaurantlist.RestaurantsListAdapter;
import datamodels.Restaurant;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class e implements Function2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantsListAdapter f58012b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f58013c;

    public /* synthetic */ e(RestaurantsListAdapter restaurantsListAdapter, int i11) {
        this.f58012b = restaurantsListAdapter;
        this.f58013c = i11;
    }

    public final Object invoke(Object obj, Object obj2) {
        return this.f58012b.lambda$onBindViewHolder$0(this.f58013c, (Restaurant) obj, (Integer) obj2);
    }
}
