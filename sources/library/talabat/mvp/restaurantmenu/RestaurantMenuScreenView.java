package library.talabat.mvp.restaurantmenu;

import JsonModels.Response.BinTokenRM;
import JsonModels.Response.PreviousOrderList.PreviousOrder;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceItemModel;
import android.content.Context;
import com.talabat.helpers.Talabat;
import datamodels.CartMenuItem;
import datamodels.Restaurant;

public interface RestaurantMenuScreenView extends Talabat {
    Context getContext();

    String getScreenName();

    void hidePreviousOrderList();

    void navigateToMenuWithChoiceNativeScreen();

    void navigateToMenuWithoutChoiceNativeScreen();

    void navigateToVendorInfoNativeScreen();

    void navigateToVendorReviewsNativeScreen();

    void onBinResponseReceived(BinTokenRM binTokenRM, String str);

    void onChoiceReceived(SplitChoiceItemModel splitChoiceItemModel);

    void onItemAdded(CartMenuItem cartMenuItem);

    void onMaxCartItemsReached();

    void onNavigateToItemDetails(CartMenuItem cartMenuItem);

    void onNoChoiceAvailable();

    void onParallelBinAvailable();

    void showNonCancelableProgress();

    void showRestaurantChangePopup(Restaurant restaurant, PreviousOrder previousOrder);

    void showRestaurantChangePopup(Restaurant restaurant, CartMenuItem cartMenuItem);

    void stopNonCancelableLoading();
}
