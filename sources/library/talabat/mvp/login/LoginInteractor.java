package library.talabat.mvp.login;

import JsonModels.Response.CustomerAddressInfoJsonResult;
import android.content.Context;
import androidx.annotation.NonNull;
import bt.o;
import buisnessmodels.Customer;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.talabat.authentication.authenticate.domain.repository.AuthenticationRepository;
import com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase;
import com.talabat.authentication.authenticate.domain.repository.JwtExchangeCallback;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.authentication.usecase.MigrationExchangeObservabilityUseCase;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.projects.killswitch.KillSwitchFeatureFlagsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.user.UserFeatureFlagsKeys;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.domain.address.Address;
import com.talabat.feature.subscriptions.domain.model.CountryParams;
import com.talabat.feature.subscriptions.domain.model.ProCentralization;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.GsonRequest;
import com.talabat.helpers.LoggedInHelper;
import com.talabat.helpers.TalabatTokenRequest;
import com.talabat.helpers.TalabatUtils;
import com.talabat.helpers.TalabatVolley;
import com.talabat.observability.ObservabilityManager;
import com.talabat.registration.RegistrationInteractor;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import com.talabat.user.address.domain.repository.CustomerAddressesRepositoryKt;
import com.talabat.userandlocation.otp.domain.repo.RequestOtpRepository;
import com.talabat.userandlocation.token.ClearOwinUseCaseImpl;
import datamodels.LoginRM;
import datamodels.RegistrationRM;
import datamodels.RegistrationType;
import datamodels.Token;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Dispatchers;
import library.talabat.com.talabatlib.CreateApiUrl;
import library.talabat.mvp.login.domain.repository.CustomerRepository;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import p10.a;
import p10.b;
import p10.c;
import p10.d;
import p10.f;
import p10.g;
import p10.h;
import p10.i;
import p10.j;
import p10.k;
import p10.l;
import rj.e;

public class LoginInteractor implements ILoginInteractor {
    public static final int ERROR_CODE_EMAIL_DIFFERENT = 3;
    private static final String ERROR_REASON_COMPLIANCE_ACCOUNT_BLOCKED = "-17";
    private static final String ERROR_REASON_KURDISH_CHARACTERS_IN_NAME = "-19";
    private static final String ERROR_REASON_MOBILE_NUMBER_LOGIN_INVALID_CREDENTIALS = "-23";
    private final AppVersionProvider appVersionProvider;
    private final AuthenticationRepository authenticationRepository;
    @Nullable
    private Context context;
    private final CoroutineDispatchersFactory coroutineDispatchersFactory;
    private final CustomerAddressesRepository customerAddressesRepository;
    private final CustomerRepository customerRepository;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final ITalabatFeatureFlag featureFlags;
    private final Scheduler ioScheduler;
    private final LocationConfigurationRepository locationConfigRepository;
    /* access modifiers changed from: private */
    @Nullable
    public LoginListener loginListener;
    private final Scheduler maincheduler;
    private final IObservabilityManager observabilityManager;
    private final ProCentralizationStatusWrapper proCentralizationStatusUseCase;
    private final RequestOtpRepository requestOtpRepository;
    private final TokenRepository tokenRepository;

    public LoginInteractor(Context context2, AppVersionProvider appVersionProvider2, AuthenticationRepository authenticationRepository2, CustomerAddressesRepository customerAddressesRepository2, CustomerRepository customerRepository2, LocationConfigurationRepository locationConfigurationRepository, Scheduler scheduler, Scheduler scheduler2, IObservabilityManager iObservabilityManager, ITalabatFeatureFlag iTalabatFeatureFlag, RequestOtpRepository requestOtpRepository2, TokenRepository tokenRepository2, ProCentralizationStatusWrapper proCentralizationStatusWrapper, CoroutineDispatchersFactory coroutineDispatchersFactory2) {
        this.context = context2;
        this.appVersionProvider = appVersionProvider2;
        this.authenticationRepository = authenticationRepository2;
        this.customerAddressesRepository = customerAddressesRepository2;
        this.customerRepository = customerRepository2;
        this.locationConfigRepository = locationConfigurationRepository;
        this.ioScheduler = scheduler;
        this.maincheduler = scheduler2;
        this.observabilityManager = iObservabilityManager;
        this.featureFlags = iTalabatFeatureFlag;
        this.requestOtpRepository = requestOtpRepository2;
        this.tokenRepository = tokenRepository2;
        this.proCentralizationStatusUseCase = proCentralizationStatusWrapper;
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

    /* access modifiers changed from: private */
    public void finalizeLogin() {
        LoginListener loginListener2 = this.loginListener;
        if (loginListener2 != null) {
            loginListener2.onRequestCompleted();
        }
    }

    private void getActiveSubscriptionInfo() {
        if (this.featureFlags.getFeatureFlag(KillSwitchFeatureFlagsKeys.TPRO, false)) {
            Country from = Country.Companion.from(GlobalDataModel.SelectedCountryId);
            try {
                from = this.locationConfigRepository.selectedCountry().getCountry();
            } catch (Exception unused) {
                ObservabilityManager.trackUnExpectedScenario("LoginInteractor - tpro selectedCountry.getCountry was null");
            }
            try {
                this.proCentralizationStatusUseCase.single(new CountryParams(from), new Continuation<ProCentralization>() {
                    @NonNull
                    public CoroutineContext getContext() {
                        return Dispatchers.getMain();
                    }

                    public void resumeWith(@NonNull Object obj) {
                        if (obj instanceof Result.Failure) {
                            LogManager.logException(((Result.Failure) obj).exception);
                        }
                        LoginInteractor.this.finalizeLogin();
                    }
                });
            } catch (Exception e11) {
                ObservabilityManager.trackUnExpectedScenario("LoginInteractor - proCentralizationStatusUseCase.single exception - " + e11.getMessage());
                finalizeLogin();
            }
        } else {
            finalizeLogin();
        }
    }

    private Single<CustomerAddressInfoJsonResult> getLoadCustomerDetailsSingle() {
        return Single.create(new c());
    }

    /* access modifiers changed from: private */
    public void handleMergedResult(Pair<CustomerAddressInfoJsonResult, List<Address>> pair) {
        this.customerRepository.setCustomerAddresses(pair.getSecond());
        onAddressReceived(false).onResponse(pair.getFirst());
    }

    private boolean isCloudflareTooManyRequestsErrorThenFailAndReturn(VolleyError volleyError) {
        LoginListener loginListener2;
        if (!this.featureFlags.getFeatureFlag(TalabatFeatureFlagConstants.HANDLE_TOO_MANY_REQUESTS_IN_LOGIN, true) || (loginListener2 = this.loginListener) == null || volleyError.networkResponse.statusCode != GlobalConstants.serverErrorCode.NOT_RESPONDING_ERROR_CODE) {
            return false;
        }
        loginListener2.onLoginFailedBecauseOfTooManyRequests();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$faceBookLoginWithResult$0(SingleEmitter singleEmitter, Token token) {
        onResultRecieved(ExchangeOwinTokenToAAATokenUseCase.EXCHANGE_FLOW_LOGIN_SOCIAL).onResponse(token);
        singleEmitter.onSuccess(token);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$faceBookLoginWithResult$1(SingleEmitter singleEmitter, VolleyError volleyError) {
        onRequestError().onErrorResponse(volleyError);
        singleEmitter.onError(volleyError);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$faceBookLoginWithResult$2(RegistrationRM registrationRM, SingleEmitter singleEmitter) throws Exception {
        TalabatVolley.getRequestQueue().add(new TalabatTokenRequest.Builder().setMethod(1).setUrl(AppUrls.GETLOGIN).setRegistration(registrationRM).setRegistrationType(1).setListener(new a(this, singleEmitter)).setErrorListener(new d(this, singleEmitter)).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$getLoadCustomerDetailsSingle$8(SingleEmitter singleEmitter) throws Exception {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.GETADDRESSES;
        GsonRequest.Builder<CustomerAddressInfoJsonResult> clazz = builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{cityid}", "" + GlobalDataModel.SelectedCountryId})).setClazz(CustomerAddressInfoJsonResult.class);
        Objects.requireNonNull(singleEmitter);
        TalabatVolley.addToRequestQueue(clazz.setListener(new rj.d(singleEmitter)).setErrorListener(new e(singleEmitter)).build());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List lambda$loadCustomerDetailsFromMicroservice$6(Throwable th2) throws Exception {
        return new ArrayList();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$loadCustomerDetailsFromMicroservice$7(Throwable th2) throws Exception {
        LogManager.logException(th2);
        if (th2 instanceof VolleyError) {
            onRequestError().onErrorResponse((VolleyError) th2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onAddressReceived$9(boolean z11, CustomerAddressInfoJsonResult customerAddressInfoJsonResult) {
        if (z11) {
            Customer.getInstance().setCustomerAddress(customerAddressInfoJsonResult.result.addresses);
        }
        Customer.getInstance().setCustomerInfo(customerAddressInfoJsonResult.result.customer);
        Customer.getInstance().setSavedCreditCards(customerAddressInfoJsonResult.result.tokens);
        Customer.saveToken(this.context);
        getActiveSubscriptionInfo();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onRequestError$5(VolleyError volleyError) {
        String str;
        String str2;
        String str3;
        String str4 = "";
        if (volleyError instanceof ParseError) {
            LogManager.debug("Parse Error");
        } else if (volleyError instanceof ServerError) {
            LoginListener loginListener2 = this.loginListener;
            if (loginListener2 != null) {
                loginListener2.onServerError(volleyError);
            }
            String str5 = new String(volleyError.networkResponse.data);
            if (!isCloudflareTooManyRequestsErrorThenFailAndReturn(volleyError)) {
                int i11 = -1;
                try {
                    JSONObject jSONObject = new JSONObject(str5);
                    if (!this.featureFlags.getFeatureFlag(TalabatFeatureFlagConstants.REMOVE_PARSING_ERROR_AS_INT, false)) {
                        if (jSONObject.has("error")) {
                            i11 = jSONObject.getInt("error");
                        }
                    }
                    if (jSONObject.has(RegistrationInteractor.JSON_KEY_ERROR_URI)) {
                        str = jSONObject.getString(RegistrationInteractor.JSON_KEY_ERROR_URI);
                    } else {
                        str = str4;
                    }
                    try {
                        if (jSONObject.has("error_description")) {
                            str3 = jSONObject.getString("error_description");
                        } else {
                            str3 = str4;
                        }
                        try {
                            if (!TalabatUtils.isNullOrEmpty(str3)) {
                                str4 = str3;
                            } else if (jSONObject.has("error")) {
                                str4 = jSONObject.getString("error");
                            }
                        } catch (Exception e11) {
                            String str6 = str;
                            str2 = str3;
                            e = e11;
                            str4 = str6;
                            LogManager.logException(e);
                            String str7 = str4;
                            str4 = str2;
                            str = str7;
                            handleLoginError(i11, str, str4);
                        }
                    } catch (Exception e12) {
                        e = e12;
                        String str8 = str4;
                        str4 = str;
                        str2 = str8;
                        LogManager.logException(e);
                        String str72 = str4;
                        str4 = str2;
                        str = str72;
                        handleLoginError(i11, str, str4);
                    }
                } catch (Exception e13) {
                    e = e13;
                    str2 = str4;
                    LogManager.logException(e);
                    String str722 = str4;
                    str4 = str2;
                    str = str722;
                    handleLoginError(i11, str, str4);
                }
                handleLoginError(i11, str, str4);
            }
        } else if (volleyError instanceof NetworkError) {
            LogManager.debug("Network Error");
            LoginListener loginListener3 = this.loginListener;
            if (loginListener3 != null) {
                loginListener3.onNetworkError();
                LogManager.logException(new Exception("login Network Exception"));
            }
        } else if (volleyError instanceof AuthFailureError) {
            handleAuthError();
        } else {
            this.loginListener.onServerError(volleyError);
            LogManager.logException(volleyError);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onResultRecieved$4(String str, Token token) {
        GlobalDataModel.token = token;
        if (this.context == null) {
            loadCustomerDetails();
        } else {
            new ExchangeOwinTokenToAAATokenUseCase(new ClearOwinUseCaseImpl(this.featureFlags, this.observabilityManager, this.context), this.coroutineDispatchersFactory, this.featureFlags, this.authenticationRepository, new MigrationExchangeObservabilityUseCase(this.observabilityManager), UserFeatureFlagsKeys.FF_USER_AUTHENTICATION_EXCHANGE_OWIN_TO_JWT_LOGIN, this.tokenRepository, new ExchangeOwinTokenToAAATokenUseCase.IsGdmOwinAvailable() {
                public boolean isGdmOwinAvailable() {
                    return GlobalDataModel.token != null;
                }
            }).call(str, new JwtExchangeCallback() {
                public void onJwtTokenExchangeFailed() {
                    if (LoginInteractor.this.loginListener != null) {
                        LoginInteractor.this.loginListener.onLoginFailedWithTokenExchangeFailure();
                    }
                }

                public void onJwtTokenExchanged() {
                    LoginInteractor.this.loadCustomerDetails();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$requestOtp$3(Throwable th2) throws Exception {
        LogManager.logException(th2);
        this.loginListener.onRequestOtpUnknownError();
    }

    private void loadCustomerDetailsFromMicroservice() {
        Single<List<Address>> onErrorReturn = CustomerAddressesRepositoryKt.getCustomerAddressesSingle(this.customerAddressesRepository, GlobalDataModel.SelectedCountryId).onErrorReturn(new k());
        this.disposables.add(Single.zip(getLoadCustomerDetailsSingle(), onErrorReturn, new o()).subscribeOn(this.ioScheduler).observeOn(this.maincheduler).subscribe(new l(this), new b(this)));
    }

    private void loadCustomerDetailsLegacy() {
        GsonRequest.Builder builder = new GsonRequest.Builder();
        String str = AppUrls.GETADDRESSES;
        TalabatVolley.addToRequestQueue(builder.setUrl(CreateApiUrl.createWithParameters(str, new String[]{"{cityid}", "" + GlobalDataModel.SelectedCountryId})).setClazz(CustomerAddressInfoJsonResult.class).setListener(onAddressReceived(true)).setErrorListener(onRequestError()).build());
    }

    private Response.Listener<CustomerAddressInfoJsonResult> onAddressReceived(boolean z11) {
        return new j(this, z11);
    }

    /* access modifiers changed from: private */
    public void onRequestOtpResult(RequestOtpRepository.RequestOtpResult requestOtpResult) {
        if (requestOtpResult instanceof RequestOtpRepository.RequestOtpResult.Success) {
            RequestOtpRepository.RequestOtpResult.Success success = (RequestOtpRepository.RequestOtpResult.Success) requestOtpResult;
            this.loginListener.onRequestOtpSuccess(success.getMessage(), success.getRemainingRequests());
        } else if (requestOtpResult instanceof RequestOtpRepository.RequestOtpResult.FailedToRequestOtp) {
            this.loginListener.onFailedToRequestOtp(((RequestOtpRepository.RequestOtpResult.FailedToRequestOtp) requestOtpResult).getMessage());
        } else if (requestOtpResult instanceof RequestOtpRepository.RequestOtpResult.MaxRequestsReached) {
            this.loginListener.onMaxOtpRequestsReached(((RequestOtpRepository.RequestOtpResult.MaxRequestsReached) requestOtpResult).getMessage());
        } else if (requestOtpResult instanceof RequestOtpRepository.RequestOtpResult.MobileNumberValidationError) {
            this.loginListener.onRequestOtpMobileNumberValidationError(((RequestOtpRepository.RequestOtpResult.MobileNumberValidationError) requestOtpResult).getMessage());
        } else if (requestOtpResult instanceof RequestOtpRepository.RequestOtpResult.UnknownResult) {
            this.loginListener.onRequestOtpUnknownError();
            ObservabilityManager.trackUnExpectedScenario("Login: RequestOtpResult.UnknownResult");
        }
    }

    public void faceBookLogin(RegistrationRM registrationRM) {
        TalabatVolley.getRequestQueue().add(new TalabatTokenRequest.Builder().setMethod(1).setUrl(AppUrls.GETLOGIN).setRegistration(registrationRM).setRegistrationType(1).setListener(onResultRecieved(ExchangeOwinTokenToAAATokenUseCase.EXCHANGE_FLOW_LOGIN_SOCIAL)).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public Single<Token> faceBookLoginWithResult(RegistrationRM registrationRM) {
        return Single.create(new i(this, registrationRM));
    }

    public void getLogin(LoginRM loginRM) {
        String str;
        RequestQueue requestQueue = TalabatVolley.getRequestQueue();
        if (loginRM.registrationType == RegistrationType.MOBILE_NUMBER) {
            str = ExchangeOwinTokenToAAATokenUseCase.EXCHANGE_FLOW_LOGIN_MOBILE;
        } else {
            str = ExchangeOwinTokenToAAATokenUseCase.EXCHANGE_FLOW_LOGIN_EMAIL;
        }
        requestQueue.add(new TalabatTokenRequest.Builder().setMethod(1).setUrl(AppUrls.GETLOGIN).setLoginModel(loginRM).setListener(onResultRecieved(str)).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void googleLogin(RegistrationRM registrationRM) {
        TalabatVolley.getRequestQueue().add(new TalabatTokenRequest.Builder().setMethod(1).setUrl(AppUrls.GETLOGIN).setRegistration(registrationRM).setRegistrationType(2).setListener(onResultRecieved(ExchangeOwinTokenToAAATokenUseCase.EXCHANGE_FLOW_LOGIN_SOCIAL)).setErrorListener(onRequestError()).setAppVersion(this.appVersionProvider.appVersion()).build());
    }

    public void handleAuthError() {
        LogManager.debug("Auth Failure Error");
        LoginListener loginListener2 = this.loginListener;
        if (loginListener2 != null) {
            loginListener2.onDataError();
            this.loginListener.onLoginFailedWithAccessDeniedCase();
            LogManager.logException(new Exception("login Authentication Exception 403"));
        }
    }

    public void handleLoginError(int i11, String str, String str2) {
        if (i11 == 2 || i11 == 3) {
            LoginListener loginListener2 = this.loginListener;
            if (loginListener2 != null) {
                loginListener2.showEmailPopup();
            }
        } else if (str.equals(ILoginInteractor.ERROR_REASON_EMAIL_NOT_REGISTERED)) {
            LoginListener loginListener3 = this.loginListener;
            if (loginListener3 != null) {
                loginListener3.showEmailNotRegisteredError(str2, str);
            }
        } else if (i11 == Integer.parseInt(ERROR_REASON_COMPLIANCE_ACCOUNT_BLOCKED) || str.equalsIgnoreCase(ERROR_REASON_COMPLIANCE_ACCOUNT_BLOCKED)) {
            LoginListener loginListener4 = this.loginListener;
            if (loginListener4 != null) {
                loginListener4.onAccountComplianceFailed();
            }
        } else if (this.featureFlags.getFeatureFlag(TalabatFeatureFlagConstants.BLOCK_KURDISH_NAMES, false) && str.equalsIgnoreCase(ERROR_REASON_KURDISH_CHARACTERS_IN_NAME)) {
            LoginListener loginListener5 = this.loginListener;
            if (loginListener5 != null) {
                loginListener5.onKurdishNamesBlocked(str2);
            }
        } else if (str.equalsIgnoreCase(ERROR_REASON_MOBILE_NUMBER_LOGIN_INVALID_CREDENTIALS)) {
            LoginListener loginListener6 = this.loginListener;
            if (loginListener6 != null) {
                loginListener6.onInvalidCredentialsForMobileLogin(str2);
            }
        } else if (!TalabatUtils.isNullOrEmpty(str2)) {
            LoginListener loginListener7 = this.loginListener;
            if (loginListener7 != null) {
                loginListener7.onLoginFailed(str2, str);
            }
        } else {
            LoginListener loginListener8 = this.loginListener;
            if (loginListener8 != null) {
                loginListener8.onLoginFailed("unknown Exception", str);
                LogManager.logException(new Exception("login unknownException" + str + str2));
            }
        }
    }

    public void loadCustomerDetails() {
        if (canInvokeAddressMicroService().booleanValue()) {
            loadCustomerDetailsFromMicroservice();
        } else {
            loadCustomerDetailsLegacy();
        }
    }

    public Response.ErrorListener onRequestError() {
        return new f(this);
    }

    public Response.Listener<Token> onResultRecieved(@NonNull String str) {
        return new p10.e(this, str);
    }

    public void requestOtp(String str) {
        this.disposables.add(this.requestOtpRepository.requestOtp(GlobalConstants.IRAQ_COUNTRY_CODE, str).subscribeOn(this.ioScheduler).observeOn(this.maincheduler).subscribe(new g(this), new h(this)));
    }

    public void setLoginListener(@Nullable LoginListener loginListener2) {
        this.loginListener = loginListener2;
    }

    public void unregister() {
        this.context = null;
        this.loginListener = null;
        this.disposables.dispose();
    }
}
