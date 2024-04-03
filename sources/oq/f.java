package oq;

import com.talabat.gem.adapters.data.ObservedData;
import com.talabat.gem.adapters.data.RestaurantsDataSources;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class f implements Predicate {
    public final boolean test(Object obj) {
        return RestaurantsDataSources.m10506observeOnSelectedRestaurantId$lambda1((ObservedData) obj);
    }
}
