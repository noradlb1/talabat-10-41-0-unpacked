package library.talabat.mvp.restaurant_review;

import JsonModels.RestaurantReviewResponse;
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
import library.talabat.com.talabatlib.CreateApiUrl;

public class RestaurantReviewInteractor implements IRestaurantReviewInteractor {
    private final AppVersionProvider appVersionProvider;
    /* access modifiers changed from: private */
    public RestaurantReivewListener reivewListener;

    public RestaurantReviewInteractor(AppVersionProvider appVersionProvider2, RestaurantReivewListener restaurantReivewListener) {
        this.appVersionProvider = appVersionProvider2;
        this.reivewListener = restaurantReivewListener;
    }

    private Response.Listener<RestaurantReviewResponse> onReviewReceived() {
        return new Response.Listener<RestaurantReviewResponse>() {
            public void onResponse(RestaurantReviewResponse restaurantReviewResponse) {
                if (RestaurantReviewInteractor.this.reivewListener == null) {
                    return;
                }
                if (restaurantReviewResponse != null) {
                    RestaurantReviewInteractor.this.reivewListener.onReviewLoadingCompleted(restaurantReviewResponse);
                } else {
                    RestaurantReviewInteractor.this.onRequestError();
                }
            }
        };
    }

    public void loadRestaurantReview(int i11, int i12) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.RESTAURANT_REVIEWS_PAGE;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{branchid}", "" + i11, "{pageNumber}", "" + i12})).setClazz(RestaurantReviewResponse.class).setListener(onReviewReceived()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError instanceof ServerError) {
                    if (RestaurantReviewInteractor.this.reivewListener != null) {
                        RestaurantReviewInteractor.this.reivewListener.onServerError(volleyError);
                    }
                } else if (volleyError instanceof NetworkError) {
                    if (RestaurantReviewInteractor.this.reivewListener != null) {
                        RestaurantReviewInteractor.this.reivewListener.onNetworkError();
                    }
                } else if (volleyError instanceof AuthFailureError) {
                    GlobalDataModel.token = null;
                    if (RestaurantReviewInteractor.this.reivewListener != null) {
                        RestaurantReviewInteractor.this.reivewListener.onDataError();
                    }
                }
            }
        };
    }

    public void unregister() {
        this.reivewListener = null;
    }
}
