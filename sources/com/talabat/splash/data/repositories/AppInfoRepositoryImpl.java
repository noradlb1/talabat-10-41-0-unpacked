package com.talabat.splash.data.repositories;

import androidx.annotation.VisibleForTesting;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.discovery.NewAppVersion;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.killswitch.KillSwitchFeatureFlagsKeys;
import com.talabat.domain.address.Address;
import com.talabat.observability.ObservabilityManager;
import com.talabat.splash.core.exception.Failure;
import com.talabat.splash.core.functional.Either;
import com.talabat.splash.core.platform.NetworkHandler;
import com.talabat.splash.data.preferences.AppInfoLocalDataSource;
import com.talabat.splash.data.preferences.SplashPreferences;
import com.talabat.splash.domain.entity.AppInitResponseEntity;
import com.talabat.splash.domain.entity.AppInitRootEntity;
import com.talabat.splash.domain.model.AppInfoGlobalConstantsWrapper;
import com.talabat.splash.domain.model.AppInfoGlobalCountryWrapper;
import com.talabat.splash.domain.model.AppInfoGlobalCustomerWrapper;
import com.talabat.splash.domain.model.AppInfoRequestModel;
import com.talabat.splash.domain.model.AppInfoResponseMapper;
import com.talabat.splash.domain.model.AppInfoResponseWrapper;
import com.talabat.splash.domain.model.SplashRedirectionWrapper;
import com.talabat.splash.network.SplashServices;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.Area;
import datamodels.Country;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001Bo\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cJ\b\u0010\u001f\u001a\u00020 H\u0002J\u001c\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"2\u0006\u0010%\u001a\u00020&H\u0016J\u001c\u0010'\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"2\u0006\u0010%\u001a\u00020&H\u0002J$\u0010(\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"2\u0006\u0010%\u001a\u00020&2\u0006\u0010)\u001a\u00020$H\u0002J\b\u0010*\u001a\u00020\u001eH\u0016J\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020-H\u0002J\u001c\u0010.\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"2\u0006\u0010%\u001a\u00020&H\u0002J\u0018\u0010/\u001a\u00020$2\u0006\u00100\u001a\u0002012\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020$H\u0002JO\u00104\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u0002H50\"\"\u0004\b\u0000\u00106\"\u0004\b\u0001\u001052\f\u00107\u001a\b\u0012\u0004\u0012\u0002H6082\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u0002H50:2\u0006\u0010;\u001a\u0002H6H\u0002¢\u0006\u0002\u0010<J\b\u0010=\u001a\u00020\u001eH\u0016J\u0010\u0010>\u001a\u00020 2\u0006\u00100\u001a\u000201H\u0007J \u0010?\u001a\u00020 2\u0006\u00100\u001a\u0002012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010@\u001a\u00020 H\u0002J\u001b\u0010A\u001a\u00020 2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020D0CH\u0002¢\u0006\u0002\u0010EJ\b\u0010F\u001a\u00020\u001eH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/talabat/splash/data/repositories/AppInfoRepositoryImpl;", "Lcom/talabat/splash/data/repositories/AppInfoRepository;", "networkHandler", "Lcom/talabat/splash/core/platform/NetworkHandler;", "service", "Lcom/talabat/splash/network/SplashServices;", "splashPreferences", "Lcom/talabat/splash/data/preferences/SplashPreferences;", "appInfoLocalDataSource", "Lcom/talabat/splash/data/preferences/AppInfoLocalDataSource;", "appInfoGlobalConstantsWrapper", "Lcom/talabat/splash/domain/model/AppInfoGlobalConstantsWrapper;", "appInfoGlobalCountryWrapper", "Lcom/talabat/splash/domain/model/AppInfoGlobalCountryWrapper;", "appInfoGlobalCustomerWrapper", "Lcom/talabat/splash/domain/model/AppInfoGlobalCustomerWrapper;", "discoveryConfigurationRepository", "Lcom/talabat/configuration/discovery/DiscoveryConfigurationRepository;", "locationConfigRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "dispatcherIO", "Lkotlinx/coroutines/CoroutineDispatcher;", "mapper", "Lcom/talabat/splash/domain/model/AppInfoResponseMapper;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "mutableLocationConfigurationRepository", "Lcom/talabat/configuration/MutableLocationConfigurationRepository;", "(Lcom/talabat/splash/core/platform/NetworkHandler;Lcom/talabat/splash/network/SplashServices;Lcom/talabat/splash/data/preferences/SplashPreferences;Lcom/talabat/splash/data/preferences/AppInfoLocalDataSource;Lcom/talabat/splash/domain/model/AppInfoGlobalConstantsWrapper;Lcom/talabat/splash/domain/model/AppInfoGlobalCountryWrapper;Lcom/talabat/splash/domain/model/AppInfoGlobalCustomerWrapper;Lcom/talabat/configuration/discovery/DiscoveryConfigurationRepository;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/splash/domain/model/AppInfoResponseMapper;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/configuration/MutableLocationConfigurationRepository;)V", "ignoreCustomerInfo", "", "clearGlobalToken", "", "getAppInfo", "Lcom/talabat/splash/core/functional/Either;", "Lcom/talabat/splash/core/exception/Failure;", "Lcom/talabat/splash/domain/model/AppInfoResponseWrapper;", "appRequestModel", "Lcom/talabat/splash/domain/model/AppInfoRequestModel;", "getAppInfoEither", "getAppInfoEitherFromCached", "appInfoCached", "getAppLanguage", "handleThrowable", "throwable", "", "makeAppInfoRequest", "mapToAppInfoResponseWrapper", "appInitRootEntity", "Lcom/talabat/splash/domain/entity/AppInitRootEntity;", "onAppInfoSuccess", "appInitRes", "request", "R", "T", "call", "Lretrofit2/Call;", "transform", "Lkotlin/Function1;", "default", "(Lretrofit2/Call;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)Lcom/talabat/splash/core/functional/Either;", "retriveSavedPreferences", "saveAppInfoCustomerDetails", "saveAppInfoResponse", "saveAppNormalAppUpdate", "saveAppinfoCountry", "countries", "", "Ldatamodels/Country;", "([Ldatamodels/Country;)V", "setInitalAppPreferences", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppInfoRepositoryImpl implements AppInfoRepository {
    @NotNull
    private final AppInfoGlobalConstantsWrapper appInfoGlobalConstantsWrapper;
    @NotNull
    private final AppInfoGlobalCountryWrapper appInfoGlobalCountryWrapper;
    @NotNull
    private final AppInfoGlobalCustomerWrapper appInfoGlobalCustomerWrapper;
    @NotNull
    private final AppInfoLocalDataSource appInfoLocalDataSource;
    @NotNull
    private final DiscoveryConfigurationRepository discoveryConfigurationRepository;
    @NotNull
    private final CoroutineDispatcher dispatcherIO;
    private boolean ignoreCustomerInfo;
    @NotNull
    private final LocationConfigurationRepository locationConfigRepository;
    @NotNull
    private final AppInfoResponseMapper mapper;
    @NotNull
    private final MutableLocationConfigurationRepository mutableLocationConfigurationRepository;
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull

    /* renamed from: service  reason: collision with root package name */
    private final SplashServices f61450service;
    @NotNull
    private final SplashPreferences splashPreferences;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    @Inject
    public AppInfoRepositoryImpl(@NotNull NetworkHandler networkHandler2, @NotNull SplashServices splashServices, @NotNull SplashPreferences splashPreferences2, @NotNull AppInfoLocalDataSource appInfoLocalDataSource2, @NotNull AppInfoGlobalConstantsWrapper appInfoGlobalConstantsWrapper2, @NotNull AppInfoGlobalCountryWrapper appInfoGlobalCountryWrapper2, @NotNull AppInfoGlobalCustomerWrapper appInfoGlobalCustomerWrapper2, @NotNull DiscoveryConfigurationRepository discoveryConfigurationRepository2, @NotNull LocationConfigurationRepository locationConfigurationRepository, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull AppInfoResponseMapper appInfoResponseMapper, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull MutableLocationConfigurationRepository mutableLocationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(splashServices, "service");
        Intrinsics.checkNotNullParameter(splashPreferences2, "splashPreferences");
        Intrinsics.checkNotNullParameter(appInfoLocalDataSource2, "appInfoLocalDataSource");
        Intrinsics.checkNotNullParameter(appInfoGlobalConstantsWrapper2, "appInfoGlobalConstantsWrapper");
        Intrinsics.checkNotNullParameter(appInfoGlobalCountryWrapper2, "appInfoGlobalCountryWrapper");
        Intrinsics.checkNotNullParameter(appInfoGlobalCustomerWrapper2, "appInfoGlobalCustomerWrapper");
        Intrinsics.checkNotNullParameter(discoveryConfigurationRepository2, "discoveryConfigurationRepository");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigRepository");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcherIO");
        Intrinsics.checkNotNullParameter(appInfoResponseMapper, "mapper");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(mutableLocationConfigurationRepository2, "mutableLocationConfigurationRepository");
        this.networkHandler = networkHandler2;
        this.f61450service = splashServices;
        this.splashPreferences = splashPreferences2;
        this.appInfoLocalDataSource = appInfoLocalDataSource2;
        this.appInfoGlobalConstantsWrapper = appInfoGlobalConstantsWrapper2;
        this.appInfoGlobalCountryWrapper = appInfoGlobalCountryWrapper2;
        this.appInfoGlobalCustomerWrapper = appInfoGlobalCustomerWrapper2;
        this.discoveryConfigurationRepository = discoveryConfigurationRepository2;
        this.locationConfigRepository = locationConfigurationRepository;
        this.dispatcherIO = coroutineDispatcher;
        this.mapper = appInfoResponseMapper;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.mutableLocationConfigurationRepository = mutableLocationConfigurationRepository2;
    }

    private final void clearGlobalToken() {
        this.appInfoGlobalCustomerWrapper.clearGlobalToken();
    }

    private final Either<Failure, AppInfoResponseWrapper> getAppInfoEither(AppInfoRequestModel appInfoRequestModel) {
        boolean z11;
        AppInfoResponseWrapper appInfo = this.appInfoLocalDataSource.getAppInfo();
        boolean featureFlag = this.talabatFeatureFlag.getFeatureFlag(KillSwitchFeatureFlagsKeys.APP_LAUNCH_DATA_CACHE, true);
        if (appInfo == null || !featureFlag) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            return getAppInfoEitherFromCached(appInfoRequestModel, appInfo);
        }
        if (!z11) {
            return makeAppInfoRequest(appInfoRequestModel);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Either<Failure, AppInfoResponseWrapper> getAppInfoEitherFromCached(AppInfoRequestModel appInfoRequestModel, AppInfoResponseWrapper appInfoResponseWrapper) {
        onAppInfoSuccess(appInfoResponseWrapper);
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.dispatcherIO.plus(new AppInfoRepositoryImpl$getAppInfoEitherFromCached$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this))), (CoroutineContext) null, (CoroutineStart) null, new AppInfoRepositoryImpl$getAppInfoEitherFromCached$2(this, appInfoRequestModel, (Continuation<? super AppInfoRepositoryImpl$getAppInfoEitherFromCached$2>) null), 3, (Object) null);
        return new Either.Right(AppInfoResponseWrapper.copy$default(appInfoResponseWrapper, (AppInitRootEntity) null, (Boolean) null, (Boolean) null, appInfoRequestModel.getFlowType(), (Boolean) null, (String) null, (Boolean) null, 119, (Object) null));
    }

    /* access modifiers changed from: private */
    public final void handleThrowable(Throwable th2) {
        Pair[] pairArr = new Pair[1];
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        pairArr[0] = TuplesKt.to("errorMessage", message);
        ObservabilityManager.trackUnExpectedScenario("getAppInfoFormSplashErrorsInCashingFlow", MapsKt__MapsKt.mutableMapOf(pairArr));
        LogManager.error$default(th2, (String) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Either<Failure, AppInfoResponseWrapper> makeAppInfoRequest(AppInfoRequestModel appInfoRequestModel) {
        return request(this.f61450service.getAppInfo(String.valueOf(appInfoRequestModel.getCountryId())), new AppInfoRepositoryImpl$makeAppInfoRequest$1(this, appInfoRequestModel), new AppInitRootEntity((AppInitResponseEntity) null, (String) null, 3, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    public final AppInfoResponseWrapper mapToAppInfoResponseWrapper(AppInitRootEntity appInitRootEntity, AppInfoRequestModel appInfoRequestModel) {
        String str;
        boolean shouldForceUpdate = this.discoveryConfigurationRepository.shouldForceUpdate();
        NewAppVersion newAppVersion = this.discoveryConfigurationRepository.config().getNewAppVersion();
        if (newAppVersion != null) {
            str = newAppVersion.getMessage();
        } else {
            str = null;
        }
        String str2 = str;
        try {
            AppInfoResponseMapper appInfoResponseMapper = this.mapper;
            boolean isFreshInstall = this.splashPreferences.getIsFreshInstall();
            boolean isUserLoggedIn = this.splashPreferences.isUserLoggedIn();
            SplashRedirectionWrapper flowType = appInfoRequestModel.getFlowType();
            Intrinsics.checkNotNull(flowType);
            return appInfoResponseMapper.mapToDisplayModel(appInitRootEntity, isFreshInstall, isUserLoggedIn, flowType, Boolean.valueOf(shouldForceUpdate), str2, Boolean.FALSE);
        } catch (Throwable unused) {
            return new AppInfoResponseWrapper();
        }
    }

    private final void onAppInfoSuccess(AppInfoResponseWrapper appInfoResponseWrapper) {
        AppInitResponseEntity result;
        Country[] countries;
        this.appInfoLocalDataSource.cacheAppInfo(appInfoResponseWrapper);
        AppInitRootEntity appInfoResponse = appInfoResponseWrapper.getAppInfoResponse();
        if (appInfoResponse != null) {
            saveAppInfoResponse(appInfoResponse, this.talabatFeatureFlag, this.mutableLocationConfigurationRepository);
        }
        AppInitRootEntity appInfoResponse2 = appInfoResponseWrapper.getAppInfoResponse();
        if (!(appInfoResponse2 == null || (result = appInfoResponse2.getResult()) == null || (countries = result.getCountries()) == null)) {
            saveAppinfoCountry(countries);
        }
        AppInitRootEntity appInfoResponse3 = appInfoResponseWrapper.getAppInfoResponse();
        if (appInfoResponse3 != null) {
            saveAppInfoCustomerDetails(appInfoResponse3);
        }
        if (appInfoResponseWrapper.getAppInfoResponse() != null) {
            saveAppNormalAppUpdate();
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0026 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002e A[Catch:{ all -> 0x009d }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002f A[Catch:{ all -> 0x009d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <T, R> com.talabat.splash.core.functional.Either<com.talabat.splash.core.exception.Failure, R> request(retrofit2.Call<T> r3, kotlin.jvm.functions.Function1<? super T, ? extends R> r4, T r5) {
        /*
            r2 = this;
            retrofit2.Response r3 = r3.execute()     // Catch:{ all -> 0x009d }
            boolean r0 = r3.isSuccessful()     // Catch:{ all -> 0x009d }
            r1 = 1
            if (r0 != r1) goto L_0x0039
            java.lang.Object r0 = r3.body()     // Catch:{ all -> 0x0026 }
            if (r0 != 0) goto L_0x0012
            r0 = r5
        L_0x0012:
            java.lang.Object r0 = r4.invoke(r0)     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x001e
            com.talabat.splash.domain.model.AppInfoResponseWrapper r0 = (com.talabat.splash.domain.model.AppInfoResponseWrapper) r0     // Catch:{ all -> 0x0026 }
            r2.onAppInfoSuccess(r0)     // Catch:{ all -> 0x0026 }
            goto L_0x0026
        L_0x001e:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ all -> 0x0026 }
            java.lang.String r1 = "null cannot be cast to non-null type com.talabat.splash.domain.model.AppInfoResponseWrapper"
            r0.<init>(r1)     // Catch:{ all -> 0x0026 }
            throw r0     // Catch:{ all -> 0x0026 }
        L_0x0026:
            com.talabat.splash.core.functional.Either$Right r0 = new com.talabat.splash.core.functional.Either$Right     // Catch:{ all -> 0x009d }
            java.lang.Object r3 = r3.body()     // Catch:{ all -> 0x009d }
            if (r3 != 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r5 = r3
        L_0x0030:
            java.lang.Object r3 = r4.invoke(r5)     // Catch:{ all -> 0x009d }
            r0.<init>(r3)     // Catch:{ all -> 0x009d }
            goto L_0x00b2
        L_0x0039:
            if (r0 != 0) goto L_0x0097
            int r4 = r3.code()     // Catch:{ all -> 0x009d }
            r5 = 400(0x190, float:5.6E-43)
            if (r4 != r5) goto L_0x004c
            com.talabat.splash.core.functional.Either$Left r3 = new com.talabat.splash.core.functional.Either$Left     // Catch:{ all -> 0x009d }
            com.talabat.splash.core.exception.Failure$BadRequest r4 = com.talabat.splash.core.exception.Failure.BadRequest.INSTANCE     // Catch:{ all -> 0x009d }
            r3.<init>(r4)     // Catch:{ all -> 0x009d }
        L_0x004a:
            r0 = r3
            goto L_0x00b2
        L_0x004c:
            int r4 = r3.code()     // Catch:{ all -> 0x009d }
            r5 = 401(0x191, float:5.62E-43)
            if (r4 != r5) goto L_0x005f
            r2.clearGlobalToken()     // Catch:{ all -> 0x009d }
            com.talabat.splash.core.functional.Either$Left r3 = new com.talabat.splash.core.functional.Either$Left     // Catch:{ all -> 0x009d }
            com.talabat.splash.core.exception.Failure$Unauthorized r4 = com.talabat.splash.core.exception.Failure.Unauthorized.INSTANCE     // Catch:{ all -> 0x009d }
            r3.<init>(r4)     // Catch:{ all -> 0x009d }
            goto L_0x004a
        L_0x005f:
            int r4 = r3.code()     // Catch:{ all -> 0x009d }
            r5 = 403(0x193, float:5.65E-43)
            if (r4 != r5) goto L_0x006f
            com.talabat.splash.core.functional.Either$Left r3 = new com.talabat.splash.core.functional.Either$Left     // Catch:{ all -> 0x009d }
            com.talabat.splash.core.exception.Failure$Forbidden r4 = com.talabat.splash.core.exception.Failure.Forbidden.INSTANCE     // Catch:{ all -> 0x009d }
            r3.<init>(r4)     // Catch:{ all -> 0x009d }
            goto L_0x004a
        L_0x006f:
            int r4 = r3.code()     // Catch:{ all -> 0x009d }
            r5 = 404(0x194, float:5.66E-43)
            if (r4 != r5) goto L_0x007f
            com.talabat.splash.core.functional.Either$Left r3 = new com.talabat.splash.core.functional.Either$Left     // Catch:{ all -> 0x009d }
            com.talabat.splash.core.exception.Failure$NotFound r4 = com.talabat.splash.core.exception.Failure.NotFound.INSTANCE     // Catch:{ all -> 0x009d }
            r3.<init>(r4)     // Catch:{ all -> 0x009d }
            goto L_0x004a
        L_0x007f:
            int r3 = r3.code()     // Catch:{ all -> 0x009d }
            r4 = 500(0x1f4, float:7.0E-43)
            if (r3 != r4) goto L_0x008f
            com.talabat.splash.core.functional.Either$Left r3 = new com.talabat.splash.core.functional.Either$Left     // Catch:{ all -> 0x009d }
            com.talabat.splash.core.exception.Failure$InternalServerError r4 = com.talabat.splash.core.exception.Failure.InternalServerError.INSTANCE     // Catch:{ all -> 0x009d }
            r3.<init>(r4)     // Catch:{ all -> 0x009d }
            goto L_0x004a
        L_0x008f:
            com.talabat.splash.core.functional.Either$Left r3 = new com.talabat.splash.core.functional.Either$Left     // Catch:{ all -> 0x009d }
            com.talabat.splash.core.exception.Failure$UnKnownError r4 = com.talabat.splash.core.exception.Failure.UnKnownError.INSTANCE     // Catch:{ all -> 0x009d }
            r3.<init>(r4)     // Catch:{ all -> 0x009d }
            goto L_0x004a
        L_0x0097:
            kotlin.NoWhenBranchMatchedException r3 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x009d }
            r3.<init>()     // Catch:{ all -> 0x009d }
            throw r3     // Catch:{ all -> 0x009d }
        L_0x009d:
            r3 = move-exception
            boolean r3 = r3 instanceof java.net.SocketTimeoutException
            if (r3 == 0) goto L_0x00aa
            com.talabat.splash.core.functional.Either$Left r3 = new com.talabat.splash.core.functional.Either$Left
            com.talabat.splash.core.exception.Failure$TimeOutError r4 = com.talabat.splash.core.exception.Failure.TimeOutError.INSTANCE
            r3.<init>(r4)
            goto L_0x004a
        L_0x00aa:
            com.talabat.splash.core.functional.Either$Left r3 = new com.talabat.splash.core.functional.Either$Left
            com.talabat.splash.core.exception.Failure$UnKnownError r4 = com.talabat.splash.core.exception.Failure.UnKnownError.INSTANCE
            r3.<init>(r4)
            goto L_0x004a
        L_0x00b2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.splash.data.repositories.AppInfoRepositoryImpl.request(retrofit2.Call, kotlin.jvm.functions.Function1, java.lang.Object):com.talabat.splash.core.functional.Either");
    }

    private final void saveAppInfoResponse(AppInitRootEntity appInitRootEntity, ITalabatFeatureFlag iTalabatFeatureFlag, MutableLocationConfigurationRepository mutableLocationConfigurationRepository2) {
        Area[] areaArr;
        this.appInfoGlobalConstantsWrapper.setAppInfoGlobalInfo(appInitRootEntity);
        AppInfoGlobalConstantsWrapper appInfoGlobalConstantsWrapper2 = this.appInfoGlobalConstantsWrapper;
        AppInitResponseEntity result = appInitRootEntity.getResult();
        if (result != null) {
            areaArr = result.getAreas();
        } else {
            areaArr = null;
        }
        appInfoGlobalConstantsWrapper2.setAppInfoGlobalArea(areaArr, iTalabatFeatureFlag, mutableLocationConfigurationRepository2);
    }

    private final void saveAppNormalAppUpdate() {
        String str;
        boolean shouldForceUpdate = this.discoveryConfigurationRepository.shouldForceUpdate();
        boolean isNewAppVersionAvailable = this.discoveryConfigurationRepository.isNewAppVersionAvailable();
        NewAppVersion newAppVersion = this.discoveryConfigurationRepository.config().getNewAppVersion();
        if (newAppVersion != null) {
            str = newAppVersion.getMessage();
        } else {
            str = null;
        }
        if (isNewAppVersionAvailable || shouldForceUpdate) {
            this.appInfoGlobalConstantsWrapper.saveNormalAppUpdate(isNewAppVersionAvailable, str);
        }
    }

    private final void saveAppinfoCountry(Country[] countryArr) {
        this.appInfoGlobalCountryWrapper.setAppInfoGlobalCountry(countryArr);
        this.appInfoGlobalCountryWrapper.setGlobalCountryDetails();
        this.appInfoGlobalCountryWrapper.setGlobalCountryPrefs();
    }

    @NotNull
    public Either<Failure, AppInfoResponseWrapper> getAppInfo(@NotNull AppInfoRequestModel appInfoRequestModel) {
        Intrinsics.checkNotNullParameter(appInfoRequestModel, "appRequestModel");
        this.ignoreCustomerInfo = appInfoRequestModel.getIgnoreCustomerInfoReturnedFromAppInfo();
        Boolean isConnected = this.networkHandler.isConnected();
        if (Intrinsics.areEqual((Object) isConnected, (Object) Boolean.TRUE)) {
            return getAppInfoEither(appInfoRequestModel);
        }
        boolean z11 = true;
        if (!Intrinsics.areEqual((Object) isConnected, (Object) Boolean.FALSE) && isConnected != null) {
            z11 = false;
        }
        if (z11) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    public boolean getAppLanguage() {
        return this.splashPreferences.getAppLanguage();
    }

    public boolean retriveSavedPreferences() {
        return this.splashPreferences.getSavedPreferences();
    }

    @VisibleForTesting
    public final void saveAppInfoCustomerDetails(@NotNull AppInitRootEntity appInitRootEntity) {
        Intrinsics.checkNotNullParameter(appInitRootEntity, "appInitRootEntity");
        if (!this.locationConfigRepository.config().isAddressMicroServiceEnabled()) {
            Object[] array = this.locationConfigRepository.addresses().toArray(new Address[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            this.appInfoGlobalCustomerWrapper.setAppInfoGlobalCustomerAddressDetails((Address[]) array);
        }
        this.appInfoGlobalCustomerWrapper.setAppInfoGlobalCustomerCardTokens(appInitRootEntity);
    }

    public boolean setInitalAppPreferences() {
        return this.splashPreferences.setInitalAppPreferences();
    }
}
