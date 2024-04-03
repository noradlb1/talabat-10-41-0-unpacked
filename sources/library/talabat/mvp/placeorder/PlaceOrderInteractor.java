package library.talabat.mvp.placeorder;

import JsonModels.PlaceOrderRequestModel;
import JsonModels.PlaceOrderResponse;
import JsonModels.Request.CheckoutDotComRequest.RecurringPurchaseRequest;
import JsonModels.Response.CheckoutDotComResponse.RecurringPurchaseResponse;
import JsonModels.Response.PlaceOrderRM;
import JsonModels.parser.UniversalGson;
import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import buisnessmodels.Customer;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.domain.address.Address;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.BASEURLS;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatUtils;
import com.talabat.helpers.TalabatVolley;
import com.talabat.observability.ObservabilityManager;
import com.talabat.observability.common.ApiStatus;
import com.talabat.observability.common.BackgroundAction;
import com.talabat.observability.squads.nfv.NFVEventType;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.TransactionCoupon;
import datamodels.TransactionPromotion;
import datamodels.TransactionVoucher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import library.talabat.mvp.homemap.HomeMapTemp;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import tracking.AppTracker;

@Instrumented
public class PlaceOrderInteractor implements IPlaceOrderInteractor {
    private final AppVersionProvider appVersionProvider;
    private final ConfigurationLocalRepository configurationLocalRepository;
    private final DiscoveryConfigurationRepository discoveryConfigurationRepository;
    private final LocationConfigurationRepository locationConfigurationRepository;
    private final PaymentConfigurationRepository paymentConfigurationRepository;
    /* access modifiers changed from: private */
    public PlaceOrderListener placeOrderListener;
    /* access modifiers changed from: private */
    public String uaeInternationalDialCode;
    /* access modifiers changed from: private */
    public String userMobileNumber;

    public PlaceOrderInteractor(AppVersionProvider appVersionProvider2, ConfigurationLocalRepository configurationLocalRepository2, DiscoveryConfigurationRepository discoveryConfigurationRepository2, LocationConfigurationRepository locationConfigurationRepository2, PaymentConfigurationRepository paymentConfigurationRepository2) {
        this.appVersionProvider = appVersionProvider2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.discoveryConfigurationRepository = discoveryConfigurationRepository2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
    }

    private void observePlaceOrder(int i11, PlaceOrderRequestModel placeOrderRequestModel) {
        ArrayList<TransactionCoupon> arrayList;
        String str;
        String str2;
        ArrayList<TransactionPromotion> arrayList2 = null;
        if (placeOrderRequestModel.getCart().getRestaurant() != null) {
            arrayList = placeOrderRequestModel.getCart().getRestaurant().getCoupons();
        } else {
            arrayList = null;
        }
        if (placeOrderRequestModel.getCart().getRestaurant() != null) {
            arrayList2 = placeOrderRequestModel.getCart().getRestaurant().getPromotions();
        }
        ArrayList<TransactionVoucher> vouchers = placeOrderRequestModel.getCart().getVouchers();
        int i12 = 0;
        String str3 = "none";
        if (arrayList == null || arrayList.isEmpty()) {
            str = str3;
        } else {
            str = arrayList.get(0).logValues();
        }
        if (arrayList2 == null || arrayList2.isEmpty()) {
            str2 = str3;
        } else {
            str2 = arrayList2.get(0).logValues();
        }
        StringBuilder sb2 = new StringBuilder();
        if (vouchers != null) {
            Iterator<TransactionVoucher> it = vouchers.iterator();
            while (it.hasNext()) {
                sb2.append(it.next().logValues());
                i12++;
                if (i12 < vouchers.size()) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
            }
        }
        if (!sb2.toString().isEmpty()) {
            str3 = sb2.toString();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("state", "PlaceOrder");
        linkedHashMap.put("customerId", String.valueOf(i11));
        linkedHashMap.put("appliedCoupon", str);
        linkedHashMap.put("appliedPromotion", str2);
        linkedHashMap.put("appliedVouchers", str3);
        ObservabilityManager.trackEvent(BackgroundAction.MENU_DISCOUNTS_EVENTS, (Map<String, String>) linkedHashMap);
    }

    private Response.Listener<RecurringPurchaseResponse> onCheckoutDotComResponse() {
        return new Response.Listener<RecurringPurchaseResponse>() {
            public void onResponse(RecurringPurchaseResponse recurringPurchaseResponse) {
                if (PlaceOrderInteractor.this.placeOrderListener == null) {
                    return;
                }
                if (!recurringPurchaseResponse.isValid) {
                    PlaceOrderInteractor.this.placeOrderListener.onCheckoutDotComRecurringFailed(recurringPurchaseResponse.message);
                } else if (!TalabatUtils.isNullOrEmpty(recurringPurchaseResponse.redirectUrl) && recurringPurchaseResponse.verificationCode == 1) {
                    PlaceOrderInteractor.this.placeOrderListener.onRedirectToPaymentWebViewWithCheckoutDotCom(recurringPurchaseResponse.redirectUrl);
                } else if (recurringPurchaseResponse.verificationCode == 0) {
                    PlaceOrderInteractor.this.placeOrderListener.onSuccessfulRecurringCheckoutDotCom();
                }
            }
        };
    }

    private Response.Listener<PlaceOrderRM> onPlaceOrder() {
        return new Response.Listener<PlaceOrderRM>() {
            public void onResponse(PlaceOrderRM placeOrderRM) {
                String str;
                LogManager.debug("[ALOV]: Interactor placeOrder response");
                if (PlaceOrderInteractor.this.placeOrderListener != null) {
                    LogManager.debug("[ALOV]: Interactor placeOrder response #1");
                    if (placeOrderRM != null) {
                        LogManager.debug("[ALOV]: Interactor placeOrder response #2");
                        if (placeOrderRM.result != null) {
                            LogManager.debug("[ALOV]: Interactor placeOrder response #3");
                            PlaceOrderInteractor.this.placeOrderListener.onResponseRecieved();
                            if (placeOrderRM.result.isOrderSuccess) {
                                LogManager.debug("[ALOV]: Interactor placeOrder response #4");
                                PlaceOrderInteractor.this.placeOrderListener.onOrderSucess(placeOrderRM.result);
                            } else {
                                LogManager.debug("[ALOV]: Interactor placeOrder response #5");
                                int i11 = placeOrderRM.result.errorCode;
                                if (i11 == 55) {
                                    LogManager.debug("[ALOV]: Interactor placeOrder response #6");
                                    PlaceOrderListener a11 = PlaceOrderInteractor.this.placeOrderListener;
                                    PlaceOrderResponse placeOrderResponse = placeOrderRM.result;
                                    a11.onDuplicateOrder(placeOrderResponse.errorMessage, placeOrderResponse.errorCode, placeOrderResponse.errorDetail, placeOrderResponse.refId, placeOrderResponse.timeDifference, placeOrderResponse.previousOrderId, placeOrderResponse.previousEncryptedOrderId);
                                } else if (i11 == 52) {
                                    LogManager.debug("[ALOV]: Interactor placeOrder response #7");
                                    PlaceOrderListener a12 = PlaceOrderInteractor.this.placeOrderListener;
                                    PlaceOrderResponse placeOrderResponse2 = placeOrderRM.result;
                                    a12.showBusyPopup(placeOrderResponse2.errorMessage, placeOrderResponse2.errorCode, placeOrderResponse2.errorDetail, placeOrderResponse2.refId, true);
                                } else if (i11 == 70) {
                                    LogManager.debug("[ALOV]: Interactor placeOrder response #8");
                                    PlaceOrderListener a13 = PlaceOrderInteractor.this.placeOrderListener;
                                    PlaceOrderResponse placeOrderResponse3 = placeOrderRM.result;
                                    a13.showBusyPopup(placeOrderResponse3.errorMessage, placeOrderResponse3.errorCode, placeOrderResponse3.errorDetail, placeOrderResponse3.refId, true);
                                } else if (i11 == 54) {
                                    LogManager.debug("[ALOV]: Interactor placeOrder response #9");
                                    PlaceOrderListener a14 = PlaceOrderInteractor.this.placeOrderListener;
                                    PlaceOrderResponse placeOrderResponse4 = placeOrderRM.result;
                                    a14.showBusyPopup(placeOrderResponse4.errorMessage, placeOrderResponse4.errorCode, placeOrderResponse4.errorDetail, placeOrderResponse4.refId, false);
                                } else if (i11 == 301) {
                                    LogManager.debug("[ALOV]: Interactor placeOrder response #10");
                                    String str2 = "";
                                    if (!TalabatUtils.isNullOrEmpty(placeOrderRM.result.smsToken)) {
                                        LogManager.debug("[ALOV]: Interactor placeOrder response #11");
                                        str = placeOrderRM.result.smsToken;
                                    } else {
                                        str = str2;
                                    }
                                    if (!TalabatUtils.isNullOrEmpty(placeOrderRM.result.eMobileNum)) {
                                        LogManager.debug("[ALOV]: Interactor placeOrder response #12");
                                        str2 = placeOrderRM.result.eMobileNum;
                                    }
                                    LogManager.debug("[ALOV]: Interactor placeOrder response #13");
                                    PlaceOrderInteractor.this.placeOrderListener.verifyMobileNumber(PlaceOrderInteractor.this.userMobileNumber, PlaceOrderInteractor.this.uaeInternationalDialCode, str, str2);
                                } else {
                                    LogManager.debug("[ALOV]: Interactor placeOrder response #14");
                                    PlaceOrderListener a15 = PlaceOrderInteractor.this.placeOrderListener;
                                    PlaceOrderResponse placeOrderResponse5 = placeOrderRM.result;
                                    a15.onOrderError(placeOrderResponse5.errorCode, placeOrderResponse5.errorMessage, placeOrderResponse5.errorDetail, placeOrderResponse5.refId, placeOrderResponse5.invalidItems);
                                }
                            }
                            LogManager.debug("[ALOV]: Interactor placeOrder response #15");
                        }
                    }
                }
                LogManager.debug("[ALOV]: Interactor placeOrder response :: exit");
            }
        };
    }

    private void trackPlaceOrderEvent(PlaceOrderRequestModel placeOrderRequestModel) {
        ObservabilityManager.trackEvent("PlaceOrder", NFVEventType.DarkstoreEvents.name(), placeOrderRequestModel.getPlaceOrderEventData());
    }

    public void continueWithAdyenSavedToken(RecurringPurchaseRequest recurringPurchaseRequest) {
        String str;
        JSONObject jSONObject;
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) recurringPurchaseRequest);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) recurringPurchaseRequest);
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        String str2 = BASEURLS.getCheckoutBaseUrl() + AppUrls.ADYEN_RECUR_PAYMENT_API;
        GsonRequest<RecurringPurchaseResponse> build = new GsonRequest.Builder().setMethod(1).setUrl(str2).setClazz(RecurringPurchaseResponse.class).setRequestBody(jSONObject).setListener(onCheckoutDotComResponse()).setErrorListener(onRequestError(str2, str)).setAppVersion(this.appVersionProvider.appVersion()).build();
        LogManager.debug("[ALOV]: continueWithAdyenSavedToken :: POST " + str2 + " :: body: " + jSONObject);
        TalabatVolley.addPaymentRequestToQueue(build);
    }

    public void continueWithCheckoutDotComSavedToken(RecurringPurchaseRequest recurringPurchaseRequest) {
        String str;
        JSONObject jSONObject;
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) recurringPurchaseRequest);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) recurringPurchaseRequest);
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        String recurringUrl = getRecurringUrl();
        GsonRequest<RecurringPurchaseResponse> build = new GsonRequest.Builder().setMethod(1).setUrl(recurringUrl).setClazz(RecurringPurchaseResponse.class).setRequestBody(jSONObject).setListener(onCheckoutDotComResponse()).setErrorListener(onRequestError(recurringUrl, str)).setAppVersion(this.appVersionProvider.appVersion()).build();
        LogManager.debug("[ALOV]: continueWithCheckoutDotComSavedToken :: POST " + recurringUrl + " :: body: " + jSONObject);
        TalabatVolley.addPaymentRequestToQueue(build);
    }

    public PlaceOrderListener getListener() {
        return this.placeOrderListener;
    }

    @VisibleForTesting
    public String getRecurringUrl() {
        String str = this.paymentConfigurationRepository.config().getCheckoutBaseUrl() + this.paymentConfigurationRepository.config().getCheckoutRecurringUrl();
        LogManager.debug("[ALOV]: getRecurringUrl :: " + str);
        return str;
    }

    public Response.ErrorListener onRequestError(@Nullable final String str, @Nullable String str2) {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                LogManager.debug("[ALOV]: Interactor placeOrder response ERROR :: " + volleyError);
                if (volleyError instanceof ServerError) {
                    if (PlaceOrderInteractor.this.placeOrderListener != null) {
                        LogManager.debug("[ALOV]: Interactor placeOrder response ERROR :: onServerError");
                        PlaceOrderInteractor.this.placeOrderListener.onServerError(volleyError);
                    }
                } else if (volleyError instanceof NetworkError) {
                    if (PlaceOrderInteractor.this.placeOrderListener != null) {
                        LogManager.debug("[ALOV]: Interactor placeOrder response ERROR :: onNetworkError");
                        PlaceOrderInteractor.this.placeOrderListener.onNetworkError();
                    }
                } else if (volleyError instanceof AuthFailureError) {
                    if (PlaceOrderInteractor.this.placeOrderListener != null) {
                        LogManager.debug("[ALOV]: Interactor placeOrder response ERROR :: onDataError");
                        PlaceOrderInteractor.this.placeOrderListener.onDataError();
                    }
                } else if (volleyError instanceof TimeoutError) {
                    if (PlaceOrderInteractor.this.placeOrderListener != null) {
                        LogManager.debug("[ALOV]: Interactor placeOrder response ERROR :: Timeout");
                        PlaceOrderInteractor.this.placeOrderListener.onRequestException(true);
                    }
                    String str = str;
                    if (str != null) {
                        ObservabilityManager.trackEvent(str, ApiStatus.API_TIME_OUT);
                    }
                } else if (PlaceOrderInteractor.this.placeOrderListener != null) {
                    LogManager.debug("[ALOV]: Interactor placeOrder response ERROR :: other error");
                    PlaceOrderInteractor.this.placeOrderListener.onRequestException(false);
                }
                if (PlaceOrderInteractor.this.placeOrderListener != null) {
                    LogManager.debug("[ALOV]: Interactor placeOrder response ERROR :: onBNPLOrderError");
                    PlaceOrderInteractor.this.placeOrderListener.onBNPLOrderError();
                }
            }
        };
    }

    public void placeOrder(PlaceOrderRequestModel placeOrderRequestModel, Context context) throws JSONException {
        String str;
        int i11;
        Address address;
        LogManager.debug("[ALOV]: Interactor placeOrder enter");
        Gson gson = UniversalGson.INSTANCE.gson;
        this.userMobileNumber = placeOrderRequestModel.address.mobileNumber;
        HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
        if (homeMapTemp != null) {
            if (!(homeMapTemp.getPlaceOrderLatitude() == null || homeMapTemp.getPlaceOrderLongitude() == null)) {
                placeOrderRequestModel.latitude = homeMapTemp.getPlaceOrderLatitude().doubleValue();
                placeOrderRequestModel.longitude = homeMapTemp.getPlaceOrderLongitude().doubleValue();
            }
            Address address2 = placeOrderRequestModel.address;
            if (address2 != null) {
                AppTracker.onSaveMapFirstLastOrderLatLng(context, address2.latitude, address2.longitude);
            }
        }
        if (TalabatUtils.isInterantionalCountryCodeVerificationEnabledCountry(this.configurationLocalRepository, this.locationConfigurationRepository) && (address = placeOrderRequestModel.address) != null) {
            this.uaeInternationalDialCode = address.mobilNumberCountryCode;
        }
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) placeOrderRequestModel);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) placeOrderRequestModel);
        }
        JSONObject jSONObject = new JSONObject(str);
        GsonRequest.Builder method = new GsonRequest.Builder().setMethod(1);
        String str2 = AppUrls.PLACEORDER;
        GsonRequest<PlaceOrderRM> build = method.setUrl(str2).setClazz(PlaceOrderRM.class).setRequestBody(jSONObject).setListener(onPlaceOrder()).setErrorListener(onRequestError(str2, str)).setAppVersion(this.appVersionProvider.appVersion()).build();
        trackPlaceOrderEvent(placeOrderRequestModel);
        if (Customer.getInstance().getCustomerInfo() != null) {
            i11 = Customer.getInstance().getCustomerInfo().f13850id;
        } else {
            i11 = -1;
        }
        observePlaceOrder(i11, placeOrderRequestModel);
        LogManager.debug("[ALOV]: Interactor placeOrder request :: POST " + str2 + " :: body: " + jSONObject);
        TalabatVolley.addToRequestQueueForPlaceOrder(build);
        LogManager.debug("[ALOV]: Interactor placeOrder exit");
    }

    public void register(PlaceOrderListener placeOrderListener2) {
        this.placeOrderListener = placeOrderListener2;
    }

    public void unregister() {
        this.placeOrderListener = null;
    }
}
