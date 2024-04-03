package com.talabat.userandlocation.customerinfo;

import JsonModels.Request.AccountInfoReq;
import JsonModels.Response.AccountInfoRM;
import JsonModels.Response.AccountInfoResult;
import JsonModels.Response.AccountInfoRst;
import JsonModels.parser.UniversalGson;
import android.content.Context;
import buisnessmodels.Customer;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.TalabatUtils;
import com.talabat.helpers.TalabatVolley;
import com.talabat.observability.ObservabilityManager;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.CustomerInfo;
import datamodels.RegistrationType;
import fx.a;
import fx.b;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import tracking.AppTracker;

@Instrumented
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJV\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000726\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\r0\u0012H\u0002J*\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0013H\u0002J\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"H\u0002Jf\u0010#\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000726\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\r0\u0012H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/talabat/userandlocation/customerinfo/CustomerInfoUpdateDelegateImpl;", "Lcom/talabat/userandlocation/customerinfo/CustomerInfoUpdateDelegate;", "context", "Landroid/content/Context;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "customerInfoProvider", "Lkotlin/Function0;", "Ldatamodels/CustomerInfo;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "(Landroid/content/Context;Lcom/talabat/configuration/ConfigurationLocalRepository;Lkotlin/jvm/functions/Function0;Lcom/talabat/configuration/discovery/AppVersionProvider;)V", "callApi", "", "request", "Lorg/json/JSONObject;", "onSuccess", "onError", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "status", "", "message", "createRequest", "dateOfBirth", "firstName", "lastName", "selectedCountryId", "observeUnsuccessfulResponse", "statusCode", "updateCustomerCache", "accountInfoRM", "LJsonModels/Response/AccountInfoRM;", "updateCustomerInfo", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomerInfoUpdateDelegateImpl implements CustomerInfoUpdateDelegate {
    @NotNull
    private final AppVersionProvider appVersionProvider;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final Context context;
    @NotNull
    private final Function0<CustomerInfo> customerInfoProvider;

    public CustomerInfoUpdateDelegateImpl(@NotNull Context context2, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull Function0<? extends CustomerInfo> function0, @NotNull AppVersionProvider appVersionProvider2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(function0, "customerInfoProvider");
        Intrinsics.checkNotNullParameter(appVersionProvider2, "appVersionProvider");
        this.context = context2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.customerInfoProvider = function0;
        this.appVersionProvider = appVersionProvider2;
    }

    private final void callApi(JSONObject jSONObject, Function0<Unit> function0, Function2<? super Integer, ? super String, Unit> function2) {
        GsonRequest.Builder<AccountInfoRM> errorListener = new GsonRequest.Builder().setMethod(1).setUrl(AppUrls.ACCOUNT_INFO).setClazz(AccountInfoRM.class).setRequestBody(jSONObject).setListener(new a(this, function0, function2)).setErrorListener(new b(function2));
        String appVersion = this.appVersionProvider.appVersion();
        if (appVersion == null) {
            appVersion = "";
        }
        TalabatVolley.addToRequestQueue(errorListener.setAppVersion(appVersion).build());
    }

    /* access modifiers changed from: private */
    /* renamed from: callApi$lambda-0  reason: not valid java name */
    public static final void m5918callApi$lambda0(CustomerInfoUpdateDelegateImpl customerInfoUpdateDelegateImpl, Function0 function0, Function2 function2, AccountInfoRM accountInfoRM) {
        String str;
        Intrinsics.checkNotNullParameter(customerInfoUpdateDelegateImpl, "this$0");
        Intrinsics.checkNotNullParameter(function0, "$onSuccess");
        Intrinsics.checkNotNullParameter(function2, "$onError");
        AccountInfoRst accountInfoRst = accountInfoRM.result.rst;
        int i11 = accountInfoRst.statusCode;
        if (i11 == 1) {
            Intrinsics.checkNotNullExpressionValue(accountInfoRM, "accountInfoRM");
            customerInfoUpdateDelegateImpl.updateCustomerCache(accountInfoRM);
            function0.invoke();
            return;
        }
        String str2 = accountInfoRst.msg;
        if (str2 == null) {
            str = "";
        } else {
            str = str2;
        }
        customerInfoUpdateDelegateImpl.observeUnsuccessfulResponse(i11, str);
        Integer valueOf = Integer.valueOf(i11);
        if (str2 == null) {
            str2 = "";
        }
        function2.invoke(valueOf, str2);
    }

    /* access modifiers changed from: private */
    /* renamed from: callApi$lambda-1  reason: not valid java name */
    public static final void m5919callApi$lambda1(Function2 function2, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(function2, "$onError");
        Intrinsics.checkNotNullExpressionValue(volleyError, "it");
        LogManager.logException(volleyError);
        String message = volleyError.getMessage();
        if (message == null) {
            message = "";
        }
        function2.invoke(-99999, message);
    }

    private final JSONObject createRequest(String str, String str2, String str3, int i11) {
        int i12;
        int i13;
        RegistrationType registrationType;
        String str4;
        String str5;
        int i14 = 0;
        if (!TalabatUtils.isNullOrEmpty(str)) {
            Object[] array = new Regex("/").split(str, 0).toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            i14 = Integer.parseInt(strArr[0]);
            i13 = Integer.parseInt(strArr[1]);
            i12 = Integer.parseInt(strArr[2]);
        } else {
            i12 = 0;
            i13 = 0;
        }
        Gson gson = UniversalGson.INSTANCE.gson;
        AccountInfoReq accountInfoReq = new AccountInfoReq();
        accountInfoReq.firstName = str2;
        accountInfoReq.lastName = str3;
        accountInfoReq.bday = i14;
        accountInfoReq.bmon = i13;
        accountInfoReq.byr = i12;
        accountInfoReq.countryId = i11;
        CustomerInfo invoke = this.customerInfoProvider.invoke();
        if (invoke == null || (registrationType = invoke.registrationType) == null) {
            registrationType = RegistrationType.UNDEFINED;
        }
        accountInfoReq.registrationType = registrationType;
        if (invoke == null || (str4 = invoke.mobileNumber) == null) {
            str4 = "";
        }
        accountInfoReq.mobileNumber = str4;
        if (!(gson instanceof Gson)) {
            str5 = gson.toJson((Object) accountInfoReq);
        } else {
            str5 = GsonInstrumentation.toJson(gson, (Object) accountInfoReq);
        }
        try {
            return new JSONObject(str5);
        } catch (JSONException e11) {
            LogManager.logException(e11);
            return null;
        }
    }

    private final void observeUnsuccessfulResponse(int i11, String str) {
        ObservabilityManager.trackUnExpectedScenario("CustomerInfoUpdateDelegateUnsuccessfulResponse", MapsKt__MapsKt.mapOf(TuplesKt.to("statusCode", String.valueOf(i11)), TuplesKt.to("message", str)));
    }

    private final void updateCustomerCache(AccountInfoRM accountInfoRM) {
        AccountInfoResult accountInfoResult = accountInfoRM.result;
        String str = String.valueOf(accountInfoResult.bday) + "/" + String.valueOf(accountInfoResult.bmon) + "/" + String.valueOf(accountInfoResult.byr);
        boolean z11 = accountInfoResult.subscribedToNewsletter;
        boolean z12 = accountInfoResult.subscribedToSMS;
        Customer instance = Customer.getInstance();
        CustomerInfo customerInfo = instance.getCustomerInfo();
        customerInfo.firstName = accountInfoResult.firstName;
        customerInfo.lastName = accountInfoResult.lastName;
        customerInfo.subscribedToSMS = z12;
        customerInfo.subscribedToNewsletter = z11;
        customerInfo.setGender(accountInfoResult.gender);
        customerInfo.birthday = str;
        customerInfo.registrationType = accountInfoResult.registrationType;
        instance.setCustomerInfo(customerInfo);
        AppTracker.onAccountUpdated(this.context, customerInfo);
    }

    public void updateCustomerInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Function0<Unit> function0, @NotNull Function2<? super Integer, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(str, "firstName");
        Intrinsics.checkNotNullParameter(str2, "lastName");
        Intrinsics.checkNotNullParameter(str3, "dateOfBirth");
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Intrinsics.checkNotNullParameter(function2, "onError");
        JSONObject createRequest = createRequest(str3, str, str2, this.configurationLocalRepository.selectedCountry().getCountryId());
        if (createRequest == null) {
            function2.invoke(-99999, "Couldn't create JSONObject");
            ObservabilityManager.trackUnExpectedScenario$default("CustomerInfoUpdateDelegateNullJSONRequest", (Map) null, 2, (Object) null);
            return;
        }
        callApi(createRequest, function0, function2);
    }
}
