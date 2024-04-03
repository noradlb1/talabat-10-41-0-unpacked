package library.talabat.mvp.restaurantmenu;

import JsonModels.Response.PreviousOrderList.PreviousOrderResponse;
import JsonModels.Response.ShopStatus.ShopStatusResponse;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceRM;
import io.reactivex.Observable;
import library.talabat.mvp.IGlobalInteractor;

public interface IRestaurantMenuInteractor extends IGlobalInteractor {
    void getAllBinOffers();

    void getAllGroceryItems(int i11);

    void getChoiceSection(int i11);

    Observable<SplitChoiceRM> getChoicesForMenuItem(String str, String str2);

    void getCustomerTokensForBin();

    void getGroceryItemsForSection(int i11, int i12);

    Observable<PreviousOrderResponse> getPreviousOrderList(int i11);

    Observable<ShopStatusResponse> getShopStatus(String str, String str2, String str3, boolean z11);
}
