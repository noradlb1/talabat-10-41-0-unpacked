package library.talabat.mvp.restaurantssearch;

import JsonModels.Request.RestaurantsSearchRequestModel;
import JsonModels.Response.RestaurantSearchResponse;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GlobalDataModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import service.ApiHandler;

public class RestaurantsSearchInteractor implements IRestaurantsSearchInteractor {

    /* renamed from: b  reason: collision with root package name */
    public Disposable f26850b;

    /* renamed from: c  reason: collision with root package name */
    public RestaurantsSearchListener f26851c;

    public RestaurantsSearchInteractor(RestaurantsSearchListener restaurantsSearchListener) {
        this.f26851c = restaurantsSearchListener;
    }

    public void searchForRestaurants(String str, final String str2, String str3, final boolean z11) {
        RestaurantsSearchRequestModel restaurantsSearchRequestModel = new RestaurantsSearchRequestModel();
        restaurantsSearchRequestModel.BranchIds = str;
        restaurantsSearchRequestModel.SearchTerm = str2;
        restaurantsSearchRequestModel.keyboardType = str3;
        unregister();
        ApiHandler.Services services = ApiHandler.getInstance().getServices();
        this.f26850b = services.restaurantsSearch(AppUrls.GLOBAL_SEARCH_BASE_URL + "/api/v2/country/" + GlobalDataModel.SelectedCountryId + "/global-search", restaurantsSearchRequestModel).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ArrayList<RestaurantSearchResponse>>() {
            public void accept(ArrayList<RestaurantSearchResponse> arrayList) {
                RestaurantsSearchListener restaurantsSearchListener = RestaurantsSearchInteractor.this.f26851c;
                if (restaurantsSearchListener != null) {
                    restaurantsSearchListener.resultReceived(arrayList, str2, z11);
                }
            }
        }, new Consumer<Throwable>() {
            public void accept(Throwable th2) {
                RestaurantsSearchListener restaurantsSearchListener = RestaurantsSearchInteractor.this.f26851c;
                if (restaurantsSearchListener != null) {
                    restaurantsSearchListener.onNetworkError();
                }
            }
        });
    }

    public void unregister() {
        Disposable disposable = this.f26850b;
        if (disposable != null && !disposable.isDisposed()) {
            this.f26850b.dispose();
        }
    }
}
