package a20;

import JsonModels.Response.MenuItemResponse;
import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuRM;
import datamodels.GroceryInfoAndMenuResponseZipped;
import io.reactivex.functions.BiFunction;

public final /* synthetic */ class b implements BiFunction {
    public final Object apply(Object obj, Object obj2) {
        return new GroceryInfoAndMenuResponseZipped((MenuItemResponse) obj, (SplitMenuRM) obj2);
    }
}
