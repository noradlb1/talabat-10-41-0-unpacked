package service;

import JsonModels.DeliverableAddressRM;
import JsonModels.GeoAddressRequest;
import JsonModels.OrderDetailsRM;
import JsonModels.Request.DeliverAddressRequest;
import JsonModels.Request.FranchiseRestRequest;
import JsonModels.Request.GroceryRequest.GrocerySearchRequest;
import JsonModels.Request.GroceryRequest.GrocerySortAndFilterRequest;
import JsonModels.Request.RestGeoReverseCodingRequest;
import JsonModels.Request.RestaurantInfoRequest.RestaurantInfoRequestModel;
import JsonModels.Request.RestaurantReq;
import JsonModels.Request.RestaurantsSearchRequestModel;
import JsonModels.Request.UserFeedback.FeedbackRequestModel;
import JsonModels.Request.rateOrders.RateOrderRequest;
import JsonModels.Response.CustomerLastOrderDetailsRM;
import JsonModels.Response.Darkstores.DarkStoresEntryPointResponse;
import JsonModels.Response.GeoPolygonRM;
import JsonModels.Response.GroceryResponse.GroceryItemsForSectionResponse;
import JsonModels.Response.GroceryResponse.GrocerySearchResponse;
import JsonModels.Response.MenuItemResponse;
import JsonModels.Response.OrderRatingDetailsResponse;
import JsonModels.Response.PreviousOrderList.PreviousOrderResponse;
import JsonModels.Response.RateOrderResponse;
import JsonModels.Response.RestaurantSearchResponse;
import JsonModels.Response.ShopStatus.ShopStatusResponse;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceRM;
import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuRM;
import JsonModels.Response.UserFeedback.UserFeedBackResponse;
import JsonModels.Response.VoucherUnAppliedResponse;
import JsonModels.Response.WalletCreditCardABTestResponse;
import JsonModels.Response.rateOrders.RateReasonResponse;
import JsonModels.RestGeoAddressRM;
import JsonModels.RestaurantFranchiseRespone;
import JsonModels.parser.UniversalGson;
import com.talabat.core.network.network.OKHttpBuilder;
import com.talabat.core.network.testutils.IsMockServerTestingKt;
import com.talabat.core.network.testutils.OkHttpIdlingResource;
import com.talabat.helpers.BASEURLS;
import com.talabat.helpers.GlobalDataModel;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.ArrayList;
import library.talabat.com.talabatlib.RestuarntListResponse;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public class ApiHandler {
    private static final String TAG = "ApiHandler";
    private static ApiHandler mInstance;
    private Retrofit mRetrofit;
    private Services mServices;

    public interface Services {
        @GET
        Observable<SplitChoiceRM> getChoiceSectionForMenuItem(@Url String str);

        @GET
        Observable<DarkStoresEntryPointResponse> getDarkStoresInfo(@Url String str);

        @POST
        Observable<MenuItemResponse> getGroceryInfoWithLocation(@Url String str, @Body RestaurantInfoRequestModel restaurantInfoRequestModel);

        @POST
        Single<GrocerySearchResponse> getGroceryItemsForSearch(@Url String str, @Body GrocerySearchRequest grocerySearchRequest);

        @GET
        Observable<GroceryItemsForSectionResponse> getGroceryItemsForSection(@Url String str);

        @POST
        Observable<GroceryItemsForSectionResponse> getGroceryItemsForSectionAfterSortingAndFilter(@Url String str, @Body GrocerySortAndFilterRequest grocerySortAndFilterRequest);

        @GET
        Observable<SplitMenuRM> getGroceryMenu(@Url String str);

        @GET
        Observable<SplitMenuRM> getGroceryMenuForSearch(@Url String str);

        @GET
        Observable<CustomerLastOrderDetailsRM> getLastOrderIds(@Url String str);

        @POST
        Observable<RestuarntListResponse> getNewRestaurantsApi(@Url String str, @Body RestaurantReq restaurantReq);

        @GET
        Observable<OrderDetailsRM> getOrderDetails(@Url String str);

        @GET
        Observable<OrderRatingDetailsResponse> getOrderRatingDetails(@Url String str);

        @GET
        Observable<PreviousOrderResponse> getPreviousOrders(@Url String str, @Query("branchId") String str2);

        @GET
        Observable<RateReasonResponse> getRatingReason(@Url String str);

        @GET
        Observable<RateOrderResponse> getRatingStatus(@Url String str);

        @POST
        Observable<RestGeoAddressRM> getResBasedGeoReverseCoding(@Url String str, @Body RestGeoReverseCodingRequest restGeoReverseCodingRequest);

        @POST
        Observable<DeliverableAddressRM> getResDeliverableAddress(@Url String str, @Body DeliverAddressRequest deliverAddressRequest);

        @POST
        Observable<RestaurantFranchiseRespone> getResFranchiseBasedLoc(@Url String str, @Body FranchiseRestRequest franchiseRestRequest);

        @GET
        Observable<GeoAddressRequest> getReserveGeoAddress(@Url String str);

        @POST
        Observable<MenuItemResponse> getRestaurantInfoWithLocation(@Url String str, @Body RestaurantInfoRequestModel restaurantInfoRequestModel);

        @GET
        Observable<GeoPolygonRM> getRestaurantPolygon(@Url String str);

        @POST
        Observable<RestuarntListResponse> getRestaurantsInfo(@Url String str, @Body RestaurantReq restaurantReq);

        @GET
        Observable<UserFeedBackResponse> getSavedUserFeedback(@Url String str);

        @GET
        Observable<ShopStatusResponse> getShopStatus(@Url String str, @Query("vendorid") String str2, @Query("lat") String str3, @Query("lon") String str4, @Query("ispickup") boolean z11);

        @GET
        Observable<WalletCreditCardABTestResponse> getWalletABTestResponse(@Url String str);

        @POST
        Observable<ArrayList<RestaurantSearchResponse>> restaurantsSearch(@Url String str, @Body RestaurantsSearchRequestModel restaurantsSearchRequestModel);

        @POST
        Call<Void> saveUserfeedback(@Url String str, @Body FeedbackRequestModel feedbackRequestModel);

        @POST
        Observable<JsonModels.Response.rateOrders.RateOrderResponse> submitRating(@Url String str, @Body RateOrderRequest rateOrderRequest);

        @POST
        Observable<VoucherUnAppliedResponse> unApplyAllVouchers(@Url String str);
    }

    private ApiHandler() {
        String str;
        OkHttpClient okHttpClient = OKHttpBuilder.INSTANCE.getOkHttpClient();
        if (IsMockServerTestingKt.isIdlingResourceRequired()) {
            OkHttpIdlingResource.register(okHttpClient);
        }
        if (GlobalDataModel.FunWithFlag.FunWithFlagChangeRetrofitBaseUrl) {
            str = BASEURLS.getBaseurl();
        } else {
            str = BASEURLS.getCheckoutBaseUrl();
        }
        Retrofit build = new Retrofit.Builder().baseUrl(str).client(okHttpClient).addConverterFactory(GsonConverterFactory.create(UniversalGson.INSTANCE.gson)).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        this.mRetrofit = build;
        this.mServices = (Services) build.create(Services.class);
    }

    public static Services callApi() {
        return getInstance().mServices;
    }

    public static ApiHandler getInstance() {
        if (mInstance == null) {
            mInstance = new ApiHandler();
        }
        return mInstance;
    }

    public Retrofit getRetrofit() {
        return this.mRetrofit;
    }

    public Services getServices() {
        return this.mServices;
    }
}
