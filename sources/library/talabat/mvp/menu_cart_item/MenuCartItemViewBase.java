package library.talabat.mvp.menu_cart_item;

import JsonModels.Response.GroceryResponse.GroceryItemsForSectionPagingInfo;
import JsonModels.Response.GroceryResponse.GroceryTagsModel;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceItemModel;
import android.content.Context;
import android.widget.EditText;
import android.widget.ImageView;
import datamodels.CartMenuItem;
import datamodels.MenuItem;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.List;

public interface MenuCartItemViewBase {
    Context getContext();

    EditText getEditText();

    String getScreenName();

    void getTagsString();

    void navigateToMenuWithChoiceFlutterScreen();

    void navigateToMenuWithChoiceNativeScreen();

    void navigateToMenuWithoutChoiceFlutterScreen();

    void navigateToMenuWithoutChoiceNativeScreen();

    void noChoicesAvailable();

    void onChoiceReceived(SplitChoiceItemModel splitChoiceItemModel);

    void onItemAdded(CartMenuItem cartMenuItem);

    void onMaxCartItemsReached();

    void onNavigateToItemDetails(CartMenuItem cartMenuItem, ImageView imageView);

    void onSearchApiCalled();

    void onSearchHistoryChanged(ArrayList<String> arrayList);

    void setAllItemsLoaded();

    void setGroceryTags(GroceryTagsModel[] groceryTagsModelArr);

    void setIsUpdateRequired(boolean z11);

    void setItemCount(GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo);

    void showClearButton(boolean z11);

    void showEmptyScreen(boolean z11);

    void showLoading();

    void showRestaurantChangePopup(Restaurant restaurant, CartMenuItem cartMenuItem);

    void stopLoading();

    void updateList(List<MenuItem> list, String str, int i11);
}
