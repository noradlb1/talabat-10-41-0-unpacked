package library.talabat.mvp.payfortcardlist;

import JsonModels.Response.SavedCreditCardDeleteRM;
import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatUtils;
import com.talabat.helpers.TalabatVolley;
import library.talabat.com.talabatlib.CreateApiUrl;

public class PayfortCardListIntractor implements IPayfortCardListIntractor {
    private final AppVersionProvider appVersionProvider;

    /* renamed from: b  reason: collision with root package name */
    public TokenisationCreditCard f26795b;
    private String cardNumber;
    /* access modifiers changed from: private */
    public String cardToken;
    private final ConfigurationLocalRepository configurationLocalRepository;
    private final LocationConfigurationRepository locationConfigurationRepository;
    /* access modifiers changed from: private */
    public PayfortCardListListener payfortCardListListener;

    public PayfortCardListIntractor(AppVersionProvider appVersionProvider2, ConfigurationLocalRepository configurationLocalRepository2, LocationConfigurationRepository locationConfigurationRepository2, PayfortCardListListener payfortCardListListener2) {
        this.appVersionProvider = appVersionProvider2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.payfortCardListListener = payfortCardListListener2;
    }

    private Response.Listener<SavedCreditCardDeleteRM> onDeleteAllSavedCards() {
        return new Response.Listener<SavedCreditCardDeleteRM>() {
            public void onResponse(SavedCreditCardDeleteRM savedCreditCardDeleteRM) {
                if (savedCreditCardDeleteRM.result.isSuccess) {
                    if (PayfortCardListIntractor.this.payfortCardListListener != null) {
                        PayfortCardListIntractor.this.payfortCardListListener.onDeleteAllSavedCardSuccess();
                    }
                } else if (PayfortCardListIntractor.this.payfortCardListListener != null) {
                    PayfortCardListIntractor.this.payfortCardListListener.onDeleteSavedCardFail(savedCreditCardDeleteRM.result.displayMessage);
                }
            }
        };
    }

    private Response.Listener<SavedCreditCardDeleteRM> onSavedCardDelete() {
        return new Response.Listener<SavedCreditCardDeleteRM>() {
            public void onResponse(SavedCreditCardDeleteRM savedCreditCardDeleteRM) {
                if (savedCreditCardDeleteRM.result.isSuccess) {
                    if (PayfortCardListIntractor.this.payfortCardListListener != null) {
                        PayfortCardListIntractor.this.payfortCardListListener.onDeleteSavedCardSucess(PayfortCardListIntractor.this.cardToken, savedCreditCardDeleteRM.result.displayMessage);
                    }
                } else if (PayfortCardListIntractor.this.payfortCardListListener != null) {
                    PayfortCardListIntractor.this.payfortCardListListener.onDeleteSavedCardFail(savedCreditCardDeleteRM.result.displayMessage);
                }
            }
        };
    }

    public void deleteAllSavedCard(String str) {
        GsonRequest.Builder method = new GsonRequest.Builder().setMethod(0);
        String str2 = AppUrls.DELETESAVEDCARD;
        TalabatVolley.addToRequestQueue(method.setUrl(CreateApiUrl.createWithParameters(str2, new String[]{"{tokenName}", "" + str})).setClazz(SavedCreditCardDeleteRM.class).setListener(onDeleteAllSavedCards()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void deleteSavedCard(TokenisationCreditCard tokenisationCreditCard) {
        this.f26795b = tokenisationCreditCard;
        this.cardNumber = tokenisationCreditCard.cardnumber;
        this.cardToken = tokenisationCreditCard.token;
        GsonRequest.Builder method = new GsonRequest.Builder().setMethod(0);
        String str = AppUrls.DELETESAVEDCARD;
        TalabatVolley.addToRequestQueue(method.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{tokenName}", "" + tokenisationCreditCard.token, "{payProvider}", "" + TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigurationRepository).tokenisationProvider})).setClazz(SavedCreditCardDeleteRM.class).setListener(onSavedCardDelete()).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if ((volleyError instanceof ServerError) && PayfortCardListIntractor.this.payfortCardListListener != null) {
                    PayfortCardListIntractor.this.payfortCardListListener.onServerError(volleyError);
                    PayfortCardListIntractor.this.payfortCardListListener.onDeleteSavedCardFail("");
                } else if ((volleyError instanceof NetworkError) && PayfortCardListIntractor.this.payfortCardListListener != null) {
                    PayfortCardListIntractor.this.payfortCardListListener.onNetworkError();
                    PayfortCardListIntractor.this.payfortCardListListener.onDeleteSavedCardFail("");
                } else if ((volleyError instanceof AuthFailureError) && PayfortCardListIntractor.this.payfortCardListListener != null) {
                    PayfortCardListIntractor.this.payfortCardListListener.onDataError();
                    PayfortCardListIntractor.this.payfortCardListListener.onDeleteSavedCardFail("");
                }
            }
        };
    }

    public void unregister() {
        this.payfortCardListListener = null;
    }
}
