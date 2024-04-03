package com.talabat.restaurants;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.talabat.R;
import com.talabat.adapters.RestaurantListQuicklyFilterAdapter;
import com.talabat.helpers.HorizontalSpaceItemDecoration;
import io.reactivex.functions.Consumer;

public class CollectionsRecyclerViewInitializer implements Consumer<RestaurantsListScreenRefactor> {
    public void accept(RestaurantsListScreenRefactor restaurantsListScreenRefactor) {
        restaurantsListScreenRefactor.f61214t.setLayoutManager(new LinearLayoutManager(restaurantsListScreenRefactor, 0, false));
        restaurantsListScreenRefactor.f61214t.addItemDecoration(new HorizontalSpaceItemDecoration(restaurantsListScreenRefactor.getResources().getDimensionPixelOffset(R.dimen.collection_recycler_margin)));
        RestaurantListQuicklyFilterAdapter restaurantListQuicklyFilterAdapter = new RestaurantListQuicklyFilterAdapter(restaurantsListScreenRefactor);
        restaurantsListScreenRefactor.B = restaurantListQuicklyFilterAdapter;
        restaurantListQuicklyFilterAdapter.setOnClickListener(restaurantsListScreenRefactor);
        restaurantsListScreenRefactor.f61214t.setAdapter(restaurantsListScreenRefactor.B);
        restaurantsListScreenRefactor.f61211q.setVisibility(0);
    }
}
