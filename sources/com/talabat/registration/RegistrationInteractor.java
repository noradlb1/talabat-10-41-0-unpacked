package com.talabat.registration;

import JsonModels.Response.CustomerAddressInfoJsonResult;
import android.content.Context;
import bt.b;
import bt.c;
import bt.f;
import bt.g;
import bt.h;
import bt.i;
import bt.j;
import bt.k;
import bt.l;
import bt.m;
import bt.n;
import bt.o;
import buisnessmodels.Customer;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.talabat.authentication.authenticate.domain.repository.AuthenticationRepository;
import com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase;
import com.talabat.authentication.authenticate.domain.repository.JwtExchangeCallback;
import com.talabat.authentication.token.domain.repository.ClearOwinUseCase;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.authentication.usecase.MigrationExchangeObservabilityUseCase;
import com.talabat.authentication.usecase.RegistrationObservabilityUseCase;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.user.UserFeatureFlagsKeys;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.common.RegistrationStatus;
import com.talabat.domain.address.Address;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.LoggedInHelper;
import com.talabat.helpers.TalabatTokenRequest;
import com.talabat.helpers.TalabatVolley;
import com.talabat.observability.ObservabilityManager;
import com.talabat.observability.common.RegistrationFlows;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import com.talabat.user.address.domain.repository.CustomerAddressesRepositoryKt;
import com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginPasswordUseCase;
import com.talabat.userandlocation.otp.domain.repo.RequestOtpRepository;
import datamodels.RegistrationRM;
import datamodels.RegistrationType;
import datamodels.Token;
import gx.a;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import library.talabat.com.talabatlib.CreateApiUrl;
import library.talabat.mvp.login.domain.repository.CustomerRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rj.d;
import rj.e;

public class RegistrationInteractor implements IRegistrationInteractor {
    public static final String AUTH_EVENT = "AuthEvent";
    private static final int ERROR_CODE_EMAIL = 2;
    private static final int ERROR_CODE_EMAIL_OTHER = 3;
    private static final String ERROR_REASON_COMPLIANCE_ACCOUNT_BLOCKED = "-17";
    private static final String ERROR_REASON_KURDISH_CHARACTERS_IN_NAME = "-19";
    private static final String ERROR_REASON_MOBILE_NUMBER_ACCOUNT_EXIST = "-22";
    public static final String JSON_KEY_ERROR = "error";
    public static final String JSON_KEY_ERROR_DESCRIPTION = "error_description";
    public static final String JSON_KEY_ERROR_URI = "error_uri";
    public static final String SILENT_LOGIN_METHOD = "RegistractionInteractor.silentLogin()";
    private final AppVersionProvider appVersionProvider;
    private final AuthenticationRepository authenticationRepository;
    @Nullable
    private Context context;
    private final CoroutineDispatchersFactory coroutineDispatchersFactory;
    private final CustomerAddressesRepository customerAddressesRepository;
    private final CustomerRepository customerRepository;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final ITalabatFeatureFlag featureFlag;
    private final ITalabatFeatureFlag featureFlags;
    private final Scheduler ioScheduler;
    private final LocationConfigurationRepository locationConfigRepository;
    private final Scheduler mainScheduler;
    private final IObservabilityManager observabilityManager;
    @Nullable
    private RegistrationListener registrationListener;
    private final RegistrationObservabilityUseCase registrationObservabilityUseCase;
    private final RequestOtpRepository requestOtpRepository;
    private final TokenRepository tokenRepository;
    private final VerifyLoginPasswordUseCase verifyLoginPasswordUseCase;

    public RegistrationInteractor(AppVersionProvider appVersionProvider2, CustomerAddressesRepository customerAddressesRepository2, CustomerRepository customerRepository2, LocationConfigurationRepository locationConfigurationRepository, Scheduler scheduler, Scheduler scheduler2, ITalabatFeatureFlag iTalabatFeatureFlag, RequestOtpRepository requestOtpRepository2, VerifyLoginPasswordUseCase verifyLoginPasswordUseCase2, IObservabilityManager iObservabilityManager, RegistrationObservabilityUseCase registrationObservabilityUseCase2, AuthenticationRepository authenticationRepository2, TokenRepository tokenRepository2, ITalabatFeatureFlag iTalabatFeatureFlag2, CoroutineDispatchersFactory coroutineDispatchersFactory2) {
        this.appVersionProvider = appVersionProvider2;
        this.customerAddressesRepository = customerAddressesRepository2;
        this.customerRepository = customerRepository2;
        this.locationConfigRepository = locationConfigurationRepository;
        this.ioScheduler = scheduler;
        this.mainScheduler = scheduler2;
        this.featureFlag = iTalabatFeatureFlag;
        this.requestOtpRepository = requestOtpRepository2;
        this.verifyLoginPasswordUseCase = verifyLoginPasswordUseCase2;
        this.observabilityManager = iObservabilityManager;
        this.registrationObservabilityUseCase = registrationObservabilityUseCase2;
        this.authenticationRepository = authenticationRepository2;
        this.tokenRepository = tokenRepository2;
        this.featureFlags = iTalabatFeatureFlag2;
        this.coroutineDispatchersFactory = coroutineDispatchersFactory2;
    }

    private Boolean canInvokeAddressMicroService() {
        boolean z11;
        if (!this.locationConfigRepository.config().isAddressMicroServiceEnabled() || !LoggedInHelper.isLoggedIn()) {
            z11 = false;
        } else {
            z11 = true;
        }
        return Boolean.valueOf(z11);
    }

    @NotNull
    private Map<String, String> createAttributes(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("errorMessage", str);
        hashMap.put("errorDescription", str2);
        hashMap.put("errorReasonCode", str3);
        return hashMap;
    }

    private void exchangeOwinToAaaToken(RegistrationRM registrationRM) {
        String str;
        ExchangeOwinTokenToAAATokenUseCase exchangeOwinTokenToAAATokenUseCase = new ExchangeOwinTokenToAAATokenUseCase((ClearOwinUseCase) null, this.coroutineDispatchersFactory, this.featureFlags, this.authenticationRepository, new MigrationExchangeObservabilityUseCase(this.observabilityManager), UserFeatureFlagsKeys.FF_USER_AUTHENTICATION_EXCHANGE_OWIN_TO_JWT_LOGIN, this.tokenRepository, new g());
        if (registrationRM.registrationType == RegistrationType.MOBILE_NUMBER) {
            str = ExchangeOwinTokenToAAATokenUseCase.EXCHANGE_FLOW_REGISTRATION_MOBILE;
        } else {
            str = ExchangeOwinTokenToAAATokenUseCase.EXCHANGE_FLOW_REGISTRATION_EMAIL;
        }
        exchangeOwinTokenToAAATokenUseCase.call(str, new JwtExchangeCallback() {
            public void onJwtTokenExchangeFailed() {
                RegistrationInteractor.this.loadCustomerDetails();
            }

            public void onJwtTokenExchanged() {
                RegistrationInteractor.this.loadCustomerDetails();
            }
        });
    }

    private Single<CustomerAddressInfoJsonResult> getLoadCustomerDetailsSingle() {
        return Single.create(new m());
    }

    private Single<VerifyLoginPasswordUseCase.Result> getSilentLogin(String str, String str2) {
        return a.a(this.verifyLoginPasswordUseCase, str, str2).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler);
    }

    /* access modifiers changed from: private */
    public void handleMergedResult(Pair<CustomerAddressInfoJsonResult, List<Address>> pair) {
        this.customerRepository.setCustomerAddresses(pair.getSecond());
        onAddressReceived(false).onResponse(pair.getFirst());
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleServerError(com.android.volley.VolleyError r11) {
        /*
            r10 = this;
            java.lang.String r0 = "error_uri"
            java.lang.String r1 = "error_description"
            java.lang.String r2 = "error"
            java.lang.String r3 = ""
            com.talabat.registration.RegistrationListener r4 = r10.registrationListener
            if (r4 != 0) goto L_0x001c
            com.talabat.core.observabilityNew.domain.IObservabilityManager r0 = r10.observabilityManager
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r2 = "RegistrationInteractorNullListener"
            r0.trackUnExpectedScenario(r2, r1)
            com.talabat.talabatcore.logger.LogManager.logException(r11)
            return
        L_0x001c:
            java.lang.String r4 = new java.lang.String
            com.android.volley.NetworkResponse r5 = r11.networkResponse
            byte[] r5 = r5.data
            r4.<init>(r5)
            r5 = 0
            r6 = -1
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x006c }
            r7.<init>((java.lang.String) r4)     // Catch:{ Exception -> 0x006c }
            boolean r4 = r7.has(r1)     // Catch:{ Exception -> 0x006c }
            if (r4 == 0) goto L_0x0037
            java.lang.String r1 = r7.getString(r1)     // Catch:{ Exception -> 0x006c }
            goto L_0x0038
        L_0x0037:
            r1 = r3
        L_0x0038:
            boolean r4 = r7.has(r0)     // Catch:{ Exception -> 0x0069 }
            if (r4 == 0) goto L_0x0043
            java.lang.String r0 = r7.getString(r0)     // Catch:{ Exception -> 0x0069 }
            goto L_0x0044
        L_0x0043:
            r0 = r3
        L_0x0044:
            boolean r4 = r7.has(r2)     // Catch:{ Exception -> 0x0064 }
            if (r4 == 0) goto L_0x004e
            java.lang.String r3 = r7.getString(r2)     // Catch:{ Exception -> 0x0064 }
        L_0x004e:
            com.talabat.core.featureflag.domain.ITalabatFeatureFlag r4 = r10.featureFlag     // Catch:{ Exception -> 0x0064 }
            com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants r8 = com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants.REMOVE_PARSING_ERROR_AS_INT     // Catch:{ Exception -> 0x0064 }
            boolean r4 = r4.getFeatureFlag(r8, r5)     // Catch:{ Exception -> 0x0064 }
            if (r4 != 0) goto L_0x0073
            boolean r4 = r7.has(r2)     // Catch:{ Exception -> 0x0064 }
            if (r4 == 0) goto L_0x0073
            int r2 = r7.getInt(r2)     // Catch:{ Exception -> 0x0064 }
            r6 = r2
            goto L_0x0073
        L_0x0064:
            r2 = move-exception
            r9 = r2
            r2 = r0
            r0 = r9
            goto L_0x006f
        L_0x0069:
            r0 = move-exception
            r2 = r3
            goto L_0x006f
        L_0x006c:
            r0 = move-exception
            r1 = r3
            r2 = r1
        L_0x006f:
            com.talabat.talabatcore.logger.LogManager.logException(r0)
            r0 = r2
        L_0x0073:
            r2 = 2
            if (r6 == r2) goto L_0x00d4
            r4 = 3
            if (r6 == r4) goto L_0x00d4
            java.lang.String r2 = java.lang.Integer.toString(r2)
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x00d4
            java.lang.String r2 = java.lang.Integer.toString(r4)
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x008e
            goto L_0x00d4
        L_0x008e:
            java.lang.String r2 = "-17"
            boolean r2 = r0.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x009c
            com.talabat.registration.RegistrationListener r11 = r10.registrationListener
            r11.onAccountComplianceFailed()
            goto L_0x00d9
        L_0x009c:
            com.talabat.core.featureflag.domain.ITalabatFeatureFlag r2 = r10.featureFlag
            com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants r4 = com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants.BLOCK_KURDISH_NAMES
            boolean r2 = r2.getFeatureFlag(r4, r5)
            if (r2 == 0) goto L_0x00b4
            java.lang.String r2 = "-19"
            boolean r2 = r0.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x00b4
            com.talabat.registration.RegistrationListener r11 = r10.registrationListener
            r11.onKurdishNamesBlocked(r3)
            goto L_0x00d9
        L_0x00b4:
            java.lang.String r2 = "-22"
            boolean r2 = r0.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x00c2
            com.talabat.registration.RegistrationListener r11 = r10.registrationListener
            r11.onAccountAlreadyExistForMobileNumber(r3)
            goto L_0x00d9
        L_0x00c2:
            com.talabat.registration.RegistrationListener r2 = r10.registrationListener
            r2.onRegistrationFailed(r3, r1, r0)
            java.lang.String r2 = "AccountRegistrationUnknownError"
            java.util.Map r0 = r10.createAttributes(r3, r1, r0)
            com.talabat.observability.ObservabilityManager.trackUnExpectedScenario(r2, r0)
            com.talabat.talabatcore.logger.LogManager.logException(r11)
            goto L_0x00d9
        L_0x00d4:
            com.talabat.registration.RegistrationListener r11 = r10.registrationListener
            r11.showEmailPopup()
        L_0x00d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.registration.RegistrationInteractor.handleServerError(com.android.volley.VolleyError):void");
    }

    private boolean isResultIsAnError(VerifyLoginPasswordUseCase.Result result) {
        return (result instanceof VerifyLoginPasswordUseCase.Result.InvalidCredentials) || (result instanceof VerifyLoginPasswordUseCase.Result.Error);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$exchangeOwinToAaaToken$6() {
        return GlobalDataModel.token != null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$getLoadCustomerDetailsSingle$9(SingleEmitter singleEmitter) throws Exception {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.GETADDRESSES;
        GsonRequest.Builder<CustomerAddressInfoJsonResult> clazz = builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{cityid}", "" + GlobalDataModel.SelectedCountryId})).setClazz(CustomerAddressInfoJsonResult.class);
        Objects.requireNonNull(singleEmitter);
        TalabatVolley.addToRequestQueue(clazz.setListener(new d(singleEmitter)).setErrorListener(new e(singleEmitter)).build());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List lambda$loadCustomerDetails$7(Throwable th2) throws Exception {
        return new ArrayList();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$loadCustomerDetails$8(Throwable th2) throws Exception {
        LogManager.logException(th2);
        if (th2 instanceof VolleyError) {
            onRequestError(RegistrationFlows.CustomerInfo).onErrorResponse((VolleyError) th2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onAddressReceived$10(boolean z11, CustomerAddressInfoJsonResult customerAddressInfoJsonResult) {
        if (z11) {
            Customer.getInstance().setCustomerAddress(customerAddressInfoJsonResult.result.addresses);
        }
        Customer.getInstance().setCustomerInfo(customerAddressInfoJsonResult.result.customer);
        Customer.getInstance().setSavedCreditCards(customerAddressInfoJsonResult.result.tokens);
        Customer.saveToken(this.context);
        RegistrationListener registrationListener2 = this.registrationListener;
        if (registrationListener2 != null) {
            registrationListener2.onRegistrationCompleted();
        } else {
            this.observabilityManager.trackRegistration(RegistrationStatus.Failure, "registrationListener is null", Collections.singletonMap("fromLegacy", String.valueOf(z11)));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onRequestError$11(RegistrationRM registrationRM, RegistrationFlows registrationFlows, VolleyError volleyError) {
        if (registrationRM != null) {
            this.registrationObservabilityUseCase.onRequestError(volleyError.getLocalizedMessage(), registrationRM.registrationType.toString());
        }
        if (volleyError instanceof ServerError) {
            handleServerError(volleyError);
        } else if (volleyError instanceof NetworkError) {
            RegistrationListener registrationListener2 = this.registrationListener;
            if (registrationListener2 != null) {
                registrationListener2.onNetworkError();
                this.registrationListener.onRegistrationFailed("Registration failed : Network Error", "", "");
            }
            IObservabilityManager iObservabilityManager = this.observabilityManager;
            RegistrationStatus registrationStatus = RegistrationStatus.Failure;
            iObservabilityManager.trackRegistration(registrationStatus, "Network Error " + registrationFlows.name());
        } else if (volleyError instanceof AuthFailureError) {
            RegistrationListener registrationListener3 = this.registrationListener;
            if (registrationListener3 != null) {
                registrationListener3.onDataError();
                this.registrationListener.onRegisterFailedWithAccessDeniedCase();
            }
            IObservabilityManager iObservabilityManager2 = this.observabilityManager;
            RegistrationStatus registrationStatus2 = RegistrationStatus.Failure;
            iObservabilityManager2.trackRegistration(registrationStatus2, "Access Denied " + registrationFlows.name());
        } else {
            LogManager.logException(volleyError);
            IObservabilityManager iObservabilityManager3 = this.observabilityManager;
            RegistrationStatus registrationStatus3 = RegistrationStatus.Failure;
            iObservabilityManager3.trackRegistration(registrationStatus3, volleyError.getLocalizedMessage() + " " + registrationFlows.name());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onTokenReceived$1(RegistrationRM registrationRM, Token token) {
        boolean z11;
        this.registrationObservabilityUseCase.onRequestSuccess(registrationRM.registrationType.toString());
        GlobalDataModel.token = token;
        if (registrationRM.registrationType == RegistrationType.EMAIL) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || !silentLoginEnable()) {
            exchangeOwinToAaaToken(registrationRM);
        } else {
            silentLogin(registrationRM);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$requestOtp$0(RegistrationListener registrationListener2, Throwable th2) throws Exception {
        LogManager.logException(th2);
        registrationListener2.onRequestOtpUnknownError();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$silentLogin$2(VerifyLoginPasswordUseCase.Result result) throws Exception {
        LogManager.info("AuthEvent RegistractionInteractor.silentLogin() resultCall2 " + result);
        if (isResultIsAnError(result)) {
            observeSilentLoginSecondRequestFailure(result);
        } else {
            observeSilentLoginSecondRequestSuccess(result);
        }
        loadCustomerDetails();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$silentLogin$3(Throwable th2) throws Exception {
        LogManager.info("AuthEvent RegistractionInteractor.silentLogin() exception " + th2.getLocalizedMessage());
        loadCustomerDetails();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$silentLogin$4(RegistrationRM registrationRM, VerifyLoginPasswordUseCase.Result result) throws Exception {
        if (isResultIsAnError(result)) {
            this.disposables.add(getSilentLogin(registrationRM.Email, registrationRM.Password).subscribe(new j(this), new k(this)));
            observeSilentLoginFirstRequestFailure(result);
        } else {
            observeSilentLoginFirstRequestSuccess(result);
            loadCustomerDetails();
        }
        LogManager.info("AuthEvent RegistractionInteractor.silentLogin() resultCall1 " + result);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$silentLogin$5(Throwable th2) throws Exception {
        LogManager.info("AuthEvent RegistractionInteractor.silentLogin() exception " + th2.getLocalizedMessage());
        loadCustomerDetails();
    }

    private void observeSilentLoginFirstRequestFailure(VerifyLoginPasswordUseCase.Result result) {
        this.registrationObservabilityUseCase.silentLoginFirstRequestFailure(result.toString());
    }

    private void observeSilentLoginFirstRequestSuccess(VerifyLoginPasswordUseCase.Result result) {
        this.registrationObservabilityUseCase.silentLoginFirstRequestSuccess(result.toString());
    }

    private void observeSilentLoginSecondRequestFailure(VerifyLoginPasswordUseCase.Result result) {
        this.registrationObservabilityUseCase.silentLoginSecondRequestFailure(result.toString());
    }

    private void observeSilentLoginSecondRequestSuccess(VerifyLoginPasswordUseCase.Result result) {
        this.registrationObservabilityUseCase.silentLoginSecondRequestSuccess(result.toString());
    }

    private Response.Listener<CustomerAddressInfoJsonResult> onAddressReceived(boolean z11) {
        return new bt.d(this, z11);
    }

    /* access modifiers changed from: private */
    public void onRequestOtpResult(RequestOtpRepository.RequestOtpResult requestOtpResult) {
        if (requestOtpResult instanceof RequestOtpRepository.RequestOtpResult.Success) {
            RequestOtpRepository.RequestOtpResult.Success success = (RequestOtpRepository.RequestOtpResult.Success) requestOtpResult;
            this.registrationListener.onRequestOtpSuccess(success.getMessage(), success.getRemainingRequests());
        } else if (requestOtpResult instanceof RequestOtpRepository.RequestOtpResult.FailedToRequestOtp) {
            this.registrationListener.onFailedToRequestOtp(((RequestOtpRepository.RequestOtpResult.FailedToRequestOtp) requestOtpResult).getMessage());
        } else if (requestOtpResult instanceof RequestOtpRepository.RequestOtpResult.MaxRequestsReached) {
            this.registrationListener.onMaxOtpRequestsReached(((RequestOtpRepository.RequestOtpResult.MaxRequestsReached) requestOtpResult).getMessage());
        } else if (requestOtpResult instanceof RequestOtpRepository.RequestOtpResult.MobileNumberValidationError) {
            this.registrationListener.onRequestOtpMobileNumberValidationError(((RequestOtpRepository.RequestOtpResult.MobileNumberValidationError) requestOtpResult).getMessage());
        } else if (requestOtpResult instanceof RequestOtpRepository.RequestOtpResult.UnknownResult) {
            this.registrationListener.onRequestOtpUnknownError();
            ObservabilityManager.trackUnExpectedScenario("RequestOtpResult.UnknownResult");
        }
    }

    private Response.Listener<Token> onTokenReceived(RegistrationRM registrationRM) {
        return new bt.a(this, registrationRM);
    }

    private void silentLogin(RegistrationRM registrationRM) {
        if (registrationRM == null) {
            this.registrationObservabilityUseCase.silentLoginRequestParamFailure("registerModel is null.");
            return;
        }
        String str = registrationRM.Email;
        if (str == null) {
            RegistrationObservabilityUseCase registrationObservabilityUseCase2 = this.registrationObservabilityUseCase;
            registrationObservabilityUseCase2.silentLoginRequestParamFailure("Email is null. type : " + registrationRM.registrationType);
            return;
        }
        String str2 = registrationRM.Password;
        if (str2 == null) {
            RegistrationObservabilityUseCase registrationObservabilityUseCase3 = this.registrationObservabilityUseCase;
            registrationObservabilityUseCase3.silentLoginRequestParamFailure("Password is null. type : " + registrationRM.registrationType);
            return;
        }
        this.disposables.add(getSilentLogin(str, str2).subscribe(new h(this, registrationRM), new i(this)));
    }

    private boolean silentLoginEnable() {
        return this.featureFlag.getFeatureFlag(UserFeatureFlagsKeys.FF_USER_AUTHENTICATION_SILENT_LOGIN, false);
    }

    public void loadCustomerDetails() {
        if (canInvokeAddressMicroService().booleanValue()) {
            Single<List<Address>> onErrorReturn = CustomerAddressesRepositoryKt.getCustomerAddressesSingle(this.customerAddressesRepository, GlobalDataModel.SelectedCountryId).onErrorReturn(new n());
            this.disposables.add(Single.zip(getLoadCustomerDetailsSingle(), onErrorReturn, new o()).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new b(this), new c(this)));
            return;
        }
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.GETADDRESSES;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{cityid}", "" + GlobalDataModel.SelectedCountryId})).setClazz(CustomerAddressInfoJsonResult.class).setListener(onAddressReceived(true)).setErrorListener(onRequestError(RegistrationFlows.CustomerInfoLegacy)).build());
    }

    public Response.ErrorListener onRequestError(RegistrationFlows registrationFlows) {
        return onRequestError(registrationFlows, (RegistrationRM) null);
    }

    public void registerCustomer(RegistrationListener registrationListener2, Context context2, RegistrationRM registrationRM, int i11) {
        this.observabilityManager.trackRegistration(RegistrationStatus.Started, "Register Customer Started");
        this.registrationListener = registrationListener2;
        RequestQueue requestQueue = TalabatVolley.getRequestQueue();
        this.context = context2;
        TalabatTokenRequest build = new TalabatTokenRequest.Builder().setMethod(1).setUrl(AppUrls.GETLOGIN).setRegistration(registrationRM).setRegistrationType(i11).setListener(onTokenReceived(registrationRM)).setErrorListener(onRequestError(RegistrationFlows.Auth, registrationRM)).setAppVersion(this.appVersionProvider.appVersion()).build();
        build.setRetryPolicy(new DefaultRetryPolicy((int) TimeUnit.SECONDS.toMillis(20), 1, 1.0f));
        requestQueue.add(build);
    }

    public void requestOtp(String str, RegistrationListener registrationListener2) {
        this.registrationListener = registrationListener2;
        this.disposables.add(this.requestOtpRepository.requestOtp(GlobalConstants.IRAQ_COUNTRY_CODE, str).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new bt.e(this), new f(registrationListener2)));
    }

    public void unregister() {
        this.context = null;
        this.disposables.dispose();
        this.registrationListener = null;
    }

    public Response.ErrorListener onRequestError(RegistrationFlows registrationFlows, RegistrationRM registrationRM) {
        return new l(this, registrationRM, registrationFlows);
    }
}
