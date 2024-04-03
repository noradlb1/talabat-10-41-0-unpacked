package library.talabat.mvp.menu_search;

import JsonModels.Request.GroceryRequest.GrocerySearchRequest;
import JsonModels.Response.GroceryResponse.GrocerySearchResponse;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceItemModel;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceRM;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatVolley;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import library.talabat.com.talabatlib.CreateApiUrl;
import service.ApiHandler;

public class MenuSearchInteractor implements IMenuSearchInteractor {
    private final AppVersionProvider appVersionProvider;
    public MenuSearchListener menuSearchListener;

    public MenuSearchInteractor(AppVersionProvider appVersionProvider2, MenuSearchListener menuSearchListener2) {
        this.appVersionProvider = appVersionProvider2;
        this.menuSearchListener = menuSearchListener2;
    }

    private Response.Listener<SplitChoiceRM> onChoiceReceived() {
        return new Response.Listener<SplitChoiceRM>() {
            public void onResponse(SplitChoiceRM splitChoiceRM) {
                MenuSearchListener menuSearchListener = MenuSearchInteractor.this.menuSearchListener;
                if (menuSearchListener != null) {
                    SplitChoiceItemModel[] splitChoiceItemModelArr = splitChoiceRM.result.items;
                    if (splitChoiceItemModelArr.length > 0) {
                        menuSearchListener.onChoiceReceived(splitChoiceItemModelArr[0]);
                    } else {
                        menuSearchListener.onNoChoiceAvailable();
                    }
                }
            }
        };
    }

    public void getChoiceSection(int i11) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.SPLIT_RESTAURANT_CHOICE;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{branchId}", GlobalDataModel.SELECTED.restaurant.getBranchId() + "", "{sectionId}", i11 + ""})).setClazz(SplitChoiceRM.class).setListener(onChoiceReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public Single<GrocerySearchResponse> getDataFromApi(String str, String str2, int i11, String str3, String str4, String str5, String str6) {
        MenuSearchListener menuSearchListener2 = this.menuSearchListener;
        String str7 = str;
        if (menuSearchListener2 != null) {
            menuSearchListener2.onSearchApiCalled(str);
        }
        ApiHandler.Services callApi = ApiHandler.callApi();
        String str8 = str2;
        String replace = AppUrls.GROCERY_SEARCH_ALL.replace("{branchId}", str2);
        return callApi.getGroceryItemsForSearch(replace, new GrocerySearchRequest(str, i11 + "", "", "10", str3, str4, str5, str6)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                MenuSearchListener menuSearchListener;
                MenuSearchListener menuSearchListener2;
                MenuSearchListener menuSearchListener3;
                if ((volleyError instanceof ServerError) && (menuSearchListener3 = MenuSearchInteractor.this.menuSearchListener) != null) {
                    menuSearchListener3.onServerError(volleyError);
                } else if ((volleyError instanceof NetworkError) && (menuSearchListener2 = MenuSearchInteractor.this.menuSearchListener) != null) {
                    menuSearchListener2.onNetworkError();
                } else if ((volleyError instanceof AuthFailureError) && (menuSearchListener = MenuSearchInteractor.this.menuSearchListener) != null) {
                    menuSearchListener.onDataError();
                }
            }
        };
    }

    public void unregister() {
        this.menuSearchListener = null;
    }
}
