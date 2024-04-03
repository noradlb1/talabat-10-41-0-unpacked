package yf;

import com.talabat.collectiondetails.ui.restaurantlist.RestaurantsCollectionsAdapter;
import datamodels.Restaurant;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class d implements Function2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantsCollectionsAdapter f58010b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f58011c;

    public /* synthetic */ d(RestaurantsCollectionsAdapter restaurantsCollectionsAdapter, int i11) {
        this.f58010b = restaurantsCollectionsAdapter;
        this.f58011c = i11;
    }

    public final Object invoke(Object obj, Object obj2) {
        return this.f58010b.lambda$onBindViewHolder$0(this.f58011c, (Restaurant) obj, (Integer) obj2);
    }
}
