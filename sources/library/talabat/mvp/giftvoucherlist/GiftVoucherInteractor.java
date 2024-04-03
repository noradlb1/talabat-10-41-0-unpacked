package library.talabat.mvp.giftvoucherlist;

import JsonModels.GiftVoucherResponse;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatVolley;
import library.talabat.com.talabatlib.CreateApiUrl;

public class GiftVoucherInteractor implements IGiftVoucherInteractor {
    private final AppVersionProvider appVersionProvider;
    /* access modifiers changed from: private */
    public GiftVoucherListener giftVoucherListener;

    public GiftVoucherInteractor(AppVersionProvider appVersionProvider2, GiftVoucherListener giftVoucherListener2) {
        this.appVersionProvider = appVersionProvider2;
        this.giftVoucherListener = giftVoucherListener2;
    }

    private Response.Listener<GiftVoucherResponse> onGiftVoucherRecieved() {
        return new Response.Listener<GiftVoucherResponse>() {
            public void onResponse(GiftVoucherResponse giftVoucherResponse) {
                if (GiftVoucherInteractor.this.giftVoucherListener != null) {
                    GiftVoucherInteractor.this.giftVoucherListener.onGiftVoucherLoaded(giftVoucherResponse.result);
                }
            }
        };
    }

    public void loadGiftVouchers(int i11) {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.GET_GIFTVOUCHER;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{countryid}", "" + i11})).setClazz(GiftVoucherResponse.class).setListener(onGiftVoucherRecieved()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if ((volleyError instanceof ServerError) && GiftVoucherInteractor.this.giftVoucherListener != null) {
                    GiftVoucherInteractor.this.giftVoucherListener.onServerError(volleyError);
                } else if ((volleyError instanceof NetworkError) && GiftVoucherInteractor.this.giftVoucherListener != null) {
                    GiftVoucherInteractor.this.giftVoucherListener.onNetworkError();
                } else if ((volleyError instanceof AuthFailureError) && GiftVoucherInteractor.this.giftVoucherListener != null) {
                    GiftVoucherInteractor.this.giftVoucherListener.onDataError();
                }
            }
        };
    }

    public void unregister() {
        this.giftVoucherListener = null;
    }
}
