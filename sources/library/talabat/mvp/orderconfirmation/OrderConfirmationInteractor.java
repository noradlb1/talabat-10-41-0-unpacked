package library.talabat.mvp.orderconfirmation;

import JsonModels.Response.TransactionDetailsRM;
import JsonModels.TransactionDetailsResponse;
import android.content.Context;
import buisnessmodels.Customer;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatVolley;
import com.talabat.observability.ObservabilityManager;
import com.talabat.observability.common.ApiStatus;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import datamodels.TTransactionResponse;
import io.reactivex.Scheduler;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.CreateApiUrl;
import library.talabat.mvp.login.domain.repository.CustomerRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u10.a;
import u10.b;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0002J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0011H\u0016J\b\u0010!\u001a\u00020\u0018H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Llibrary/talabat/mvp/orderconfirmation/OrderConfirmationInteractor;", "Llibrary/talabat/mvp/orderconfirmation/IOrderConfirmationInteractor;", "context", "Landroid/content/Context;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "customerAddressesRepository", "Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository;", "customerRepository", "Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;", "locationConfigRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "ioScheduler", "Lio/reactivex/Scheduler;", "mainScheduler", "(Landroid/content/Context;Lcom/talabat/configuration/discovery/AppVersionProvider;Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository;Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;)V", "orderConfirmationListener", "Llibrary/talabat/mvp/orderconfirmation/OrderConfirmationListener;", "getErrorMessage", "", "error", "Lcom/android/volley/VolleyError;", "defaultMessage", "getTransactionDetails", "", "transactionId", "onThankYouApiRequestError", "Lcom/android/volley/Response$ErrorListener;", "onThankYouResultRecieved", "Lcom/android/volley/Response$Listener;", "LJsonModels/Response/TransactionDetailsRM;", "setOrderConfirmationListener", "listener", "unregister", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderConfirmationInteractor implements IOrderConfirmationInteractor {
    @Nullable
    private final AppVersionProvider appVersionProvider;
    @Nullable
    private final Context context;
    @Nullable
    private final CustomerAddressesRepository customerAddressesRepository;
    @Nullable
    private final CustomerRepository customerRepository;
    @NotNull
    private final Scheduler ioScheduler;
    @Nullable
    private final LocationConfigurationRepository locationConfigRepository;
    @NotNull
    private final Scheduler mainScheduler;
    @Nullable
    private OrderConfirmationListener orderConfirmationListener;

    public OrderConfirmationInteractor(@Nullable Context context2, @Nullable AppVersionProvider appVersionProvider2, @Nullable CustomerAddressesRepository customerAddressesRepository2, @Nullable CustomerRepository customerRepository2, @Nullable LocationConfigurationRepository locationConfigurationRepository, @NotNull Scheduler scheduler, @NotNull Scheduler scheduler2) {
        Intrinsics.checkNotNullParameter(scheduler, "ioScheduler");
        Intrinsics.checkNotNullParameter(scheduler2, "mainScheduler");
        this.context = context2;
        this.appVersionProvider = appVersionProvider2;
        this.customerAddressesRepository = customerAddressesRepository2;
        this.customerRepository = customerRepository2;
        this.locationConfigRepository = locationConfigurationRepository;
        this.ioScheduler = scheduler;
        this.mainScheduler = scheduler2;
    }

    private final String getErrorMessage(VolleyError volleyError, String str) {
        String message;
        String message2 = volleyError != null ? volleyError.getMessage() : null;
        return ((message2 == null || message2.length() == 0) || volleyError == null || (message = volleyError.getMessage()) == null) ? str : message;
    }

    private final Response.ErrorListener onThankYouApiRequestError() {
        return new b(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: onThankYouApiRequestError$lambda-1  reason: not valid java name */
    public static final void m7910onThankYouApiRequestError$lambda1(OrderConfirmationInteractor orderConfirmationInteractor, VolleyError volleyError) {
        Map map;
        Intrinsics.checkNotNullParameter(orderConfirmationInteractor, "this$0");
        LogManager.debug("OrderConfirmationInteractor.onThankYouApiRequestError: " + volleyError);
        if (volleyError instanceof ServerError) {
            map = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMessage", orderConfirmationInteractor.getErrorMessage(volleyError, "ServerError")));
            OrderConfirmationListener orderConfirmationListener2 = orderConfirmationInteractor.orderConfirmationListener;
            if (orderConfirmationListener2 != null) {
                orderConfirmationListener2.onServerError(volleyError);
            }
        } else if (volleyError instanceof NetworkError) {
            map = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMessage", orderConfirmationInteractor.getErrorMessage(volleyError, NativeProtocol.ERROR_NETWORK_ERROR)));
            OrderConfirmationListener orderConfirmationListener3 = orderConfirmationInteractor.orderConfirmationListener;
            if (orderConfirmationListener3 != null) {
                orderConfirmationListener3.onNetworkError();
            }
        } else if (volleyError instanceof AuthFailureError) {
            map = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMessage", orderConfirmationInteractor.getErrorMessage(volleyError, "AuthFailureError")));
            OrderConfirmationListener orderConfirmationListener4 = orderConfirmationInteractor.orderConfirmationListener;
            if (orderConfirmationListener4 != null) {
                orderConfirmationListener4.onDataError();
            }
        } else {
            map = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMessage", orderConfirmationInteractor.getErrorMessage(volleyError, "GenericError")));
            volleyError.printStackTrace();
        }
        ApiStatus apiStatus = ApiStatus.FAILURE;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
            map = null;
        }
        ObservabilityManager.trackEvent("thank_you_api", apiStatus, (Map<String, String>) map);
    }

    private final Response.Listener<TransactionDetailsRM> onThankYouResultRecieved() {
        return new a(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: onThankYouResultRecieved$lambda-0  reason: not valid java name */
    public static final void m7911onThankYouResultRecieved$lambda0(OrderConfirmationInteractor orderConfirmationInteractor, TransactionDetailsRM transactionDetailsRM) {
        Intrinsics.checkNotNullParameter(orderConfirmationInteractor, "this$0");
        LogManager.debug("onThankyouResultRecieved: " + transactionDetailsRM);
        ObservabilityManager.trackEvent$default("thank_you_api", ApiStatus.SUCCESS, (Map) null, 4, (Object) null);
        OrderConfirmationListener orderConfirmationListener2 = orderConfirmationInteractor.orderConfirmationListener;
        if (orderConfirmationListener2 != null) {
            TransactionDetailsResponse transactionDetailsResponse = transactionDetailsRM.result;
            TTransactionResponse tTransactionResponse = transactionDetailsResponse.transaction;
            Intrinsics.checkNotNullExpressionValue(transactionDetailsResponse, "response.result");
            orderConfirmationListener2.onThankYouPageDetailsLoaded(tTransactionResponse, transactionDetailsResponse);
        }
        Customer.getInstance().setSavedCreditCards(transactionDetailsRM.result.tokens);
    }

    public void getTransactionDetails(@Nullable String str) {
        String str2;
        LogManager.debug("Calling thank you api with: " + str);
        String str3 = AppUrls.TRANSACTION;
        Intrinsics.checkNotNull(str);
        String createWithParameters = CreateApiUrl.createWithParameters(str3, new String[]{"{transactionId}", str});
        GsonRequest.Builder<TransactionDetailsRM> errorListener = new GsonRequest.Builder().setUrl(createWithParameters).setClazz(TransactionDetailsRM.class).setListener(onThankYouResultRecieved()).setErrorListener(onThankYouApiRequestError());
        AppVersionProvider appVersionProvider2 = this.appVersionProvider;
        if (appVersionProvider2 != null) {
            str2 = appVersionProvider2.appVersion();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        TalabatVolley.addToRequestQueue(errorListener.setAppVersion(str2).build());
        ObservabilityManager.trackEvent("thank_you_api", ApiStatus.LOADING, (Map<String, String>) MapsKt__MapsJVMKt.mapOf(TuplesKt.to("apiUrl", createWithParameters)));
    }

    public void setOrderConfirmationListener(@NotNull OrderConfirmationListener orderConfirmationListener2) {
        Intrinsics.checkNotNullParameter(orderConfirmationListener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.orderConfirmationListener = orderConfirmationListener2;
    }

    public void unregister() {
        this.orderConfirmationListener = null;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OrderConfirmationInteractor(android.content.Context r11, com.talabat.configuration.discovery.AppVersionProvider r12, com.talabat.user.address.domain.repository.CustomerAddressesRepository r13, library.talabat.mvp.login.domain.repository.CustomerRepository r14, com.talabat.configuration.location.LocationConfigurationRepository r15, io.reactivex.Scheduler r16, io.reactivex.Scheduler r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r10 = this;
            r0 = r18 & 32
            if (r0 == 0) goto L_0x000f
            io.reactivex.Scheduler r0 = io.reactivex.schedulers.Schedulers.io()
            java.lang.String r1 = "io()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r8 = r0
            goto L_0x0011
        L_0x000f:
            r8 = r16
        L_0x0011:
            r0 = r18 & 64
            if (r0 == 0) goto L_0x0020
            io.reactivex.Scheduler r0 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            java.lang.String r1 = "mainThread()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r9 = r0
            goto L_0x0022
        L_0x0020:
            r9 = r17
        L_0x0022:
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.orderconfirmation.OrderConfirmationInteractor.<init>(android.content.Context, com.talabat.configuration.discovery.AppVersionProvider, com.talabat.user.address.domain.repository.CustomerAddressesRepository, library.talabat.mvp.login.domain.repository.CustomerRepository, com.talabat.configuration.location.LocationConfigurationRepository, io.reactivex.Scheduler, io.reactivex.Scheduler, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
