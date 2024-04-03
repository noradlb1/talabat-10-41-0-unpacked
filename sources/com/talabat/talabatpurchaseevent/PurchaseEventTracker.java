package com.talabat.talabatpurchaseevent;

import JsonModels.TransactionDetailsResponse;
import android.content.Context;
import android.content.SharedPreferences;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatcore.cache.Cache;
import com.talabat.talabatcore.cache.impl.DiskCache;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import datamodels.Coupon;
import datamodels.CustomerInfo;
import datamodels.LastOrdersDetails;
import datamodels.TOrderResponse;
import datamodels.TTransactionResponse;
import io.reactivex.Scheduler;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.login.domain.repository.CustomerRepository;
import library.talabat.mvp.orderconfirmation.OrderConfirmationInteractor;
import library.talabat.mvp.orderconfirmation.OrderConfirmationListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;
import tracking.Purchase;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\u001d\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002¢\u0006\u0002\u0010\u001cJ\u001a\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0017\u0010\"\u001a\u00020\u00162\b\u0010#\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006J \u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u000e\u0010*\u001a\u00020\u0006*\u0004\u0018\u00010\u0006H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006+"}, d2 = {"Lcom/talabat/talabatpurchaseevent/PurchaseEventTracker;", "Llibrary/talabat/mvp/orderconfirmation/OrderConfirmationListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "LAST_ORDER_ID", "", "getLAST_ORDER_ID", "()Ljava/lang/String;", "cache", "Lcom/talabat/talabatcore/cache/Cache;", "getContext", "()Landroid/content/Context;", "iOrderConfirmationInteractor", "Llibrary/talabat/mvp/orderconfirmation/OrderConfirmationInteractor;", "getIOrderConfirmationInteractor", "()Llibrary/talabat/mvp/orderconfirmation/OrderConfirmationInteractor;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "callThankYouApi", "", "transactionId", "extractCuisinesArray", "", "purchase", "Ltracking/Purchase;", "(Ltracking/Purchase;)[Ljava/lang/String;", "onThankYouPageDetailsLoaded", "transactionResponse", "Ldatamodels/TTransactionResponse;", "transactionDetailsResponse", "LJsonModels/TransactionDetailsResponse;", "trackLastOrderDetails", "orderId", "", "(Ljava/lang/Integer;)V", "trackOrderPlaced", "trackPurchaseEvents", "orderResponse", "Ldatamodels/TOrderResponse;", "getValueOrEmpty", "com_talabat_NewArchi_TalabatPurchaseEvent_TalabatPurchaseEvent"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PurchaseEventTracker implements OrderConfirmationListener {
    @NotNull
    private final String LAST_ORDER_ID = "lastOrderId";
    @NotNull
    private final Cache cache = new DiskCache((String) null, (SharedPreferences) null, 3, (DefaultConstructorMarker) null);
    @NotNull
    private final Context context;

    public PurchaseEventTracker(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    private final void callThankYouApi(String str) {
        if (!TalabatUtils.isNullOrEmpty(str)) {
            getIOrderConfirmationInteractor().getTransactionDetails(str);
        }
    }

    private final String[] extractCuisinesArray(Purchase purchase) {
        String[] strArr = new String[2];
        if (purchase.getRestaurant() != null && purchase.getRestaurant().hasCusine()) {
            purchase.setCuisine1(getValueOrEmpty(purchase.getRestaurant().getCuisine1()));
        }
        if (purchase.getRestaurant() != null && purchase.getRestaurant().hasCuisine2()) {
            strArr[0] = getValueOrEmpty(purchase.getRestaurant().getCusine2());
        }
        if (purchase.getRestaurant() != null && purchase.getRestaurant().hasCuisine3()) {
            if (TalabatUtils.isNullOrEmpty(strArr[0])) {
                strArr[0] = getValueOrEmpty(purchase.getRestaurant().getCuisine3());
            } else {
                strArr[1] = getValueOrEmpty(purchase.getRestaurant().getCuisine3());
            }
        }
        return strArr;
    }

    private final OrderConfirmationInteractor getIOrderConfirmationInteractor() {
        OrderConfirmationInteractor orderConfirmationInteractor = new OrderConfirmationInteractor(this.context, (AppVersionProvider) null, (CustomerAddressesRepository) null, (CustomerRepository) null, (LocationConfigurationRepository) null, (Scheduler) null, (Scheduler) null, 96, (DefaultConstructorMarker) null);
        orderConfirmationInteractor.setOrderConfirmationListener(this);
        return orderConfirmationInteractor;
    }

    private final IObservabilityManager getObservabilityManager() {
        Context applicationContext = this.context.getApplicationContext();
        if (applicationContext != null) {
            return ((ObservabilityCoreLibApi) ((ApiContainer) applicationContext).getFeature(ObservabilityCoreLibApi.class)).getObservabilityManager();
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
    }

    private final String getValueOrEmpty(String str) {
        return str == null || StringsKt__StringsJVMKt.isBlank(str) ? "" : str;
    }

    private final void trackLastOrderDetails(Integer num) {
        String str;
        if (num == null || (str = num.toString()) == null) {
            str = "";
        }
        this.cache.putString(this.LAST_ORDER_ID, str);
        getObservabilityManager().trackAttribute(this.LAST_ORDER_ID, str);
    }

    private final void trackPurchaseEvents(TOrderResponse tOrderResponse, TTransactionResponse tTransactionResponse, TransactionDetailsResponse transactionDetailsResponse) {
        Object obj;
        Integer num;
        int i11;
        TOrderResponse tOrderResponse2 = tOrderResponse;
        TTransactionResponse tTransactionResponse2 = tTransactionResponse;
        try {
            Result.Companion companion = Result.Companion;
            Purchase purchase = AppTracker.getPurchase();
            Unit unit = null;
            if (purchase != null) {
                Intrinsics.checkNotNullExpressionValue(purchase, "getPurchase()");
                if (!purchase.isPurchaseEventsEnabled()) {
                    if (purchase.getRestaurant() == null) {
                        if (Cart.getInstance().getRestaurant() == null) {
                            getObservabilityManager().trackUnExpectedScenario("Update purchase restaurant", MapsKt__MapsKt.mapOf(TuplesKt.to("reason", "purchase restaurant is null and cart restaurant is null"), TuplesKt.to("processedForTracking", "false")));
                            return;
                        }
                        getObservabilityManager().trackUnExpectedScenario("Update purchase restaurant", MapsKt__MapsKt.mapOf(TuplesKt.to("reason", "purchase restaurant is null and cart restaurant is not null"), TuplesKt.to("restaurantName", Cart.getInstance().getRestaurant().f13873name.toString()), TuplesKt.to("restaurantIsDarkStore", String.valueOf(Cart.getInstance().getRestaurant().isDarkStore)), TuplesKt.to("restaurantIsMigrated", String.valueOf(Cart.getInstance().getRestaurant().isMigrated)), TuplesKt.to("restaurantVerticalType", String.valueOf(Cart.getInstance().getRestaurant().shopType)), TuplesKt.to("processedForTracking", "true")));
                        purchase.setRestaurant(Cart.getInstance().getRestaurant());
                    }
                    Coupon coupon = Cart.getInstance().selectedCoupon;
                    if (coupon != null) {
                        num = Integer.valueOf(coupon.f13847id);
                    } else {
                        num = null;
                    }
                    purchase.setOfferCampaignId(String.valueOf(num));
                    Cart.resign(this.context);
                    purchase.setEncyptedTransactionId(tOrderResponse2.orderidEncypted);
                    purchase.setDisplayOrderId(String.valueOf(tOrderResponse2.orderNumber));
                    purchase.setSecondaryCuisines(extractCuisinesArray(purchase));
                    purchase.setTransactionId(String.valueOf(tTransactionResponse2.orderId));
                    Context context2 = this.context;
                    CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
                    String mobileNumber = purchase.getMobileNumber();
                    String str = tOrderResponse2.transactiionTime;
                    boolean z11 = GlobalDataModel.CONTACTLESS.contactlessEnabled;
                    CustomerInfo customerInfo2 = transactionDetailsResponse.customerInfo;
                    if (customerInfo2 != null) {
                        i11 = customerInfo2.f13850id;
                    } else {
                        i11 = 0;
                    }
                    AppTracker.onPurchase(context2, purchase, customerInfo, mobileNumber, str, z11, i11);
                    AppTracker.onIsRealAcquisition(this.context, tTransactionResponse2.isRealAcquisition);
                    AppTracker.savePurchase((Purchase) null);
                    unit = Unit.INSTANCE;
                } else {
                    return;
                }
            }
            obj = Result.m6329constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
        if (r02 != null) {
            getObservabilityManager().trackUnExpectedScenario("Update purchase restaurant", MapsKt__MapsKt.mapOf(TuplesKt.to("reason", "Exception occurred"), TuplesKt.to("exception", String.valueOf(r02.getMessage()))));
        }
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final String getLAST_ORDER_ID() {
        return this.LAST_ORDER_ID;
    }

    public void onDataError() {
        OrderConfirmationListener.DefaultImpls.onDataError(this);
    }

    public void onNetworkError() {
        OrderConfirmationListener.DefaultImpls.onNetworkError(this);
    }

    public void onServerError(@Nullable VolleyError volleyError) {
        OrderConfirmationListener.DefaultImpls.onServerError(this, volleyError);
    }

    public void onThankYouPageDetailsLoaded(@Nullable TTransactionResponse tTransactionResponse, @NotNull TransactionDetailsResponse transactionDetailsResponse) {
        CustomerInfo customerInfo;
        boolean z11;
        Intrinsics.checkNotNullParameter(transactionDetailsResponse, "transactionDetailsResponse");
        if (tTransactionResponse != null && (customerInfo = transactionDetailsResponse.customerInfo) != null) {
            TOrderResponse[] tOrderResponseArr = tTransactionResponse.tOrderResponses;
            boolean z12 = true;
            if (tOrderResponseArr != null) {
                if (tOrderResponseArr.length == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    z12 = false;
                }
            }
            if (!z12) {
                LastOrdersDetails[] lastOrdersDetailsArr = customerInfo.lastOrdersDetails;
                if (lastOrdersDetailsArr != null) {
                    Intrinsics.checkNotNullExpressionValue(lastOrdersDetailsArr, "lastOrdersDetails");
                    Customer.getInstance().setLastOrdersDetails(lastOrdersDetailsArr);
                }
                TOrderResponse tOrderResponse = tTransactionResponse.tOrderResponses[0];
                Intrinsics.checkNotNullExpressionValue(tOrderResponse, "response.tOrderResponses[0]");
                trackLastOrderDetails(Integer.valueOf(tOrderResponse.orderNumber));
                trackPurchaseEvents(tOrderResponse, tTransactionResponse, transactionDetailsResponse);
            }
        }
    }

    public final void trackOrderPlaced(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "transactionId");
        callThankYouApi(str);
    }
}
