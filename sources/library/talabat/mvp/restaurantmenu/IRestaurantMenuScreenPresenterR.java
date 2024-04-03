package library.talabat.mvp.restaurantmenu;

import JsonModels.MenuItemsResponseModel;
import JsonModels.Response.PreviousOrderList.PreviousOrder;
import android.content.Context;
import android.util.Pair;
import androidx.lifecycle.MutableLiveData;
import datamodels.CartMenuItem;
import datamodels.MenuItem;
import datamodels.MenuSection;
import datamodels.OffersItem;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.Map;
import library.talabat.mvp.IGlobalPresenter;

public interface IRestaurantMenuScreenPresenterR extends IGlobalPresenter {
    void addItem(Restaurant restaurant, CartMenuItem cartMenuItem, String str);

    void addPreviousOrderItemsToCart(Context context, Restaurant restaurant, PreviousOrder previousOrder);

    boolean canCallApi();

    void changeRestaurantAndAddItem(Context context, Restaurant restaurant, CartMenuItem cartMenuItem);

    void changeRestaurantAndAddPreviousOrder(Context context, Restaurant restaurant, PreviousOrder previousOrder);

    void clearErrorData();

    void clearShowBusyPopup();

    Map<String, String> getAttributes();

    void getBinTokens();

    int getBranchId();

    void getChoiceSection(int i11);

    int getCountOfItemsWithImages(MenuItemsResponseModel menuItemsResponseModel);

    int getCuisine();

    int getDeliveryTImeInteger();

    MutableLiveData<Pair<String, String>> getErrorData();

    void getGroceryItemsForSection(int i11);

    String getHeroImage();

    MenuItemsResponseModel getMenuItemsResponseModel();

    MenuSection getMenuSectionForItem(int i11);

    MenuSection getMenuSectionForPosition(int i11);

    void getParallelBinData();

    int getPositionForMenuSection(MenuSection menuSection);

    MutableLiveData<ArrayList<PreviousOrder>> getPreviousOrderList();

    void getPreviousOrderList(int i11);

    String getRestaurantCuisines();

    String getRestaurantDeliveryFee();

    String getRestaurantDeliveryTime();

    MenuItem getRestaurantMenuItem(int i11);

    ArrayList<MenuItem> getRestaurantMenuItems(ArrayList<MenuSection> arrayList);

    ArrayList<MenuSection> getRestaurantMenuSections();

    ArrayList<Pair<String, Integer>> getRestaurantMenuSectionsAndItemCount();

    String getRestaurantMinOrder();

    ArrayList<OffersItem> getRestaurantOffers();

    String getRestaurantOpeningTime();

    float getRestaurantRating();

    int getRestaurantStatus();

    String getRestaurantTotalRating();

    String getRestaurantWarning();

    String getRestaurantWarningURL();

    String getRestuarantName();

    void getShopStatus();

    MutableLiveData<Boolean> getShowBusyPopup();

    Restaurant getmRestaurant();

    void handleMenuWithoutChoiceClick();

    void handleVendorInfoClick();

    void handleVendorReviewsClick();

    void handleWithChoiceClick();

    boolean hasIconForAllItems();

    int isItemAddedToCart(MenuItem menuItem);

    boolean isRestaurantAcceptCash();

    boolean isRestaurantAcceptCreditCard();

    boolean isRestaurantAcceptDebitCard();

    boolean isRestaurantBusy();

    boolean isRestaurantClosed();

    boolean isRestaurantHasWarning();

    boolean isRestaurantOpen();

    boolean isRestaurantOpenForPreorder();

    boolean isRestaurantTGO();

    boolean isRestaurantTPro();

    boolean isSelectedCountryBahrain();

    boolean isSelectedCountryKSA();

    boolean isSelectedCountryKuwait();

    boolean resetRequired();
}
