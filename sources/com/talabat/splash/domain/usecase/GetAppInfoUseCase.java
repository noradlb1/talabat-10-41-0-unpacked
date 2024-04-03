package com.talabat.splash.domain.usecase;

import android.content.Context;
import buisnessmodels.Customer;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.LoggedInHelper;
import com.talabat.notifications.brazemigrator.BrazeUserMigrator;
import com.talabat.observability.ObservabilityManager;
import com.talabat.observability.common.BackgroundAction;
import com.talabat.splash.core.exception.Failure;
import com.talabat.splash.core.functional.Either;
import com.talabat.splash.core.interactor.UseCase;
import com.talabat.splash.data.repositories.AppInfoRepository;
import com.talabat.splash.data.repositories.SplashCustomerInfoRepository;
import com.talabat.splash.domain.model.AppInfoGlobalConstantsWrapper;
import com.talabat.splash.domain.model.AppInfoRequestModel;
import com.talabat.splash.domain.model.AppInfoResponseWrapper;
import com.talabat.splash.domain.model.ScreenInfoWrapper;
import com.talabat.splash.domain.model.SplashDataUtils;
import com.talabat.splash.domain.model.SplashRedirectionWrapper;
import com.talabat.user.address.domain.usecases.RetrieveAndCacheCustomerAddressesUseCase;
import com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository;
import com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository;
import datamodels.CustomerInfo;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import library.talabat.mvp.login.domain.repository.CustomerRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BY\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J%\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a2\u0006\u0010\u001d\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u0004\u0018\u00010 H@ø\u0001\u0000¢\u0006\u0002\u0010!J\u001c\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a2\u0006\u0010#\u001a\u00020\u0002H\u0002J%\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a2\u0006\u0010#\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010%J\u0019\u0010&\u001a\u00020'2\u0006\u0010#\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010%J\u0019\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*H@ø\u0001\u0000¢\u0006\u0002\u0010+J%\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020-0\u001a2\u0006\u0010.\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0010\u0010/\u001a\u00020'2\u0006\u00100\u001a\u000201H\u0002J\u0018\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020*2\u0006\u00104\u001a\u000205H\u0002J&\u00106\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00020\u001a07*\u0002082\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\u001c\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 07*\u0002082\u0006\u0010)\u001a\u00020*H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, d2 = {"Lcom/talabat/splash/domain/usecase/GetAppInfoUseCase;", "Lcom/talabat/splash/core/interactor/UseCase;", "Lcom/talabat/splash/domain/model/AppInfoResponseWrapper;", "Lcom/talabat/splash/domain/model/AppInfoRequestModel;", "appInfoRepository", "Lcom/talabat/splash/data/repositories/AppInfoRepository;", "context", "Landroid/content/Context;", "appInfoGlobalConstantsWrapper", "Lcom/talabat/splash/domain/model/AppInfoGlobalConstantsWrapper;", "retrieveAndCacheCustomerAddressesUseCase", "Lcom/talabat/user/address/domain/usecases/RetrieveAndCacheCustomerAddressesUseCase;", "userStatusRepository", "Lcom/talabat/userandlocation/compliance/status/domain/repository/UserStatusRepository;", "customerInfoRepository", "Lcom/talabat/userandlocation/customerinfo/domain/repo/CustomerInfoRepository;", "customerRepository", "Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;", "locationConfigRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "splashCustomerInfoRepository", "Lcom/talabat/splash/data/repositories/SplashCustomerInfoRepository;", "brazeMigrator", "Lcom/talabat/notifications/brazemigrator/BrazeUserMigrator;", "(Lcom/talabat/splash/data/repositories/AppInfoRepository;Landroid/content/Context;Lcom/talabat/splash/domain/model/AppInfoGlobalConstantsWrapper;Lcom/talabat/user/address/domain/usecases/RetrieveAndCacheCustomerAddressesUseCase;Lcom/talabat/userandlocation/compliance/status/domain/repository/UserStatusRepository;Lcom/talabat/userandlocation/customerinfo/domain/repo/CustomerInfoRepository;Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lcom/talabat/splash/data/repositories/SplashCustomerInfoRepository;Lcom/talabat/notifications/brazemigrator/BrazeUserMigrator;)V", "getAppInfoAndCustomerInfo", "Lcom/talabat/splash/core/functional/Either;", "Lcom/talabat/splash/core/exception/Failure;", "Lcom/talabat/splash/domain/model/ScreenInfoWrapper;", "appInfoRequestModel", "(Lcom/talabat/splash/domain/model/AppInfoRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCachedCustomerInfo", "Ldatamodels/CustomerInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getScreenRedirectionInfo", "appInfoResponseWrapper", "handleAppInfoResponseAndGetScreenRedirection", "(Lcom/talabat/splash/domain/model/AppInfoResponseWrapper;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retrieveAddressesFromMicroServiceIfPossible", "", "retrieveCustomerAddresses", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "run", "", "params", "trackAuthTokenGotNull", "afterRetrievingFromSharedPref", "", "trackCustomerInfoReturnedNull", "numberOfTries", "throwable", "", "getAppInfoAsync", "Lkotlinx/coroutines/Deferred;", "Lkotlinx/coroutines/CoroutineScope;", "getCustomerInfoAsync", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetAppInfoUseCase extends UseCase<AppInfoResponseWrapper, AppInfoRequestModel> {
    @NotNull
    private final AppInfoGlobalConstantsWrapper appInfoGlobalConstantsWrapper;
    /* access modifiers changed from: private */
    @NotNull
    public final AppInfoRepository appInfoRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final BrazeUserMigrator brazeMigrator;
    @NotNull
    private final Context context;
    @NotNull
    private final CustomerInfoRepository customerInfoRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final CustomerRepository customerRepository;
    @NotNull
    private final LocationConfigurationRepository locationConfigRepository;
    @NotNull
    private final RetrieveAndCacheCustomerAddressesUseCase retrieveAndCacheCustomerAddressesUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final SplashCustomerInfoRepository splashCustomerInfoRepository;
    @NotNull
    private final UserStatusRepository userStatusRepository;

    @Inject
    public GetAppInfoUseCase(@NotNull AppInfoRepository appInfoRepository2, @NotNull Context context2, @NotNull AppInfoGlobalConstantsWrapper appInfoGlobalConstantsWrapper2, @NotNull RetrieveAndCacheCustomerAddressesUseCase retrieveAndCacheCustomerAddressesUseCase2, @NotNull UserStatusRepository userStatusRepository2, @NotNull CustomerInfoRepository customerInfoRepository2, @NotNull CustomerRepository customerRepository2, @NotNull LocationConfigurationRepository locationConfigurationRepository, @NotNull SplashCustomerInfoRepository splashCustomerInfoRepository2, @NotNull @Named("brazeMigrator") BrazeUserMigrator brazeUserMigrator) {
        Intrinsics.checkNotNullParameter(appInfoRepository2, "appInfoRepository");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(appInfoGlobalConstantsWrapper2, "appInfoGlobalConstantsWrapper");
        Intrinsics.checkNotNullParameter(retrieveAndCacheCustomerAddressesUseCase2, "retrieveAndCacheCustomerAddressesUseCase");
        Intrinsics.checkNotNullParameter(userStatusRepository2, "userStatusRepository");
        Intrinsics.checkNotNullParameter(customerInfoRepository2, "customerInfoRepository");
        Intrinsics.checkNotNullParameter(customerRepository2, "customerRepository");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigRepository");
        Intrinsics.checkNotNullParameter(splashCustomerInfoRepository2, "splashCustomerInfoRepository");
        Intrinsics.checkNotNullParameter(brazeUserMigrator, "brazeMigrator");
        this.appInfoRepository = appInfoRepository2;
        this.context = context2;
        this.appInfoGlobalConstantsWrapper = appInfoGlobalConstantsWrapper2;
        this.retrieveAndCacheCustomerAddressesUseCase = retrieveAndCacheCustomerAddressesUseCase2;
        this.userStatusRepository = userStatusRepository2;
        this.customerInfoRepository = customerInfoRepository2;
        this.customerRepository = customerRepository2;
        this.locationConfigRepository = locationConfigurationRepository;
        this.splashCustomerInfoRepository = splashCustomerInfoRepository2;
        this.brazeMigrator = brazeUserMigrator;
    }

    /* access modifiers changed from: private */
    public final Object getAppInfoAndCustomerInfo(AppInfoRequestModel appInfoRequestModel, Continuation<? super Either<? extends Failure, ScreenInfoWrapper>> continuation) {
        return CoroutineScopeKt.coroutineScope(new GetAppInfoUseCase$getAppInfoAndCustomerInfo$2(this, appInfoRequestModel, (Continuation<? super GetAppInfoUseCase$getAppInfoAndCustomerInfo$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    public final Deferred<Either<Failure, AppInfoResponseWrapper>> getAppInfoAsync(CoroutineScope coroutineScope, AppInfoRequestModel appInfoRequestModel) {
        return BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new GetAppInfoUseCase$getAppInfoAsync$1(this, appInfoRequestModel, (Continuation<? super GetAppInfoUseCase$getAppInfoAsync$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getCachedCustomerInfo(kotlin.coroutines.Continuation<? super datamodels.CustomerInfo> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.talabat.splash.domain.usecase.GetAppInfoUseCase$getCachedCustomerInfo$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.splash.domain.usecase.GetAppInfoUseCase$getCachedCustomerInfo$1 r0 = (com.talabat.splash.domain.usecase.GetAppInfoUseCase$getCachedCustomerInfo$1) r0
            int r1 = r0.f61477j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61477j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.splash.domain.usecase.GetAppInfoUseCase$getCachedCustomerInfo$1 r0 = new com.talabat.splash.domain.usecase.GetAppInfoUseCase$getCachedCustomerInfo$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f61475h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f61477j
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x0053 }
            goto L_0x004a
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x0053 }
            library.talabat.mvp.login.domain.repository.CustomerRepository r6 = r5.customerRepository     // Catch:{ all -> 0x0053 }
            boolean r6 = r6.isLoggedIn()     // Catch:{ all -> 0x0053 }
            if (r6 == 0) goto L_0x004d
            com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository r6 = r5.customerInfoRepository     // Catch:{ all -> 0x0053 }
            r0.f61477j = r3     // Catch:{ all -> 0x0053 }
            java.lang.Object r6 = r6.getCachedCustomerInfo(r0)     // Catch:{ all -> 0x0053 }
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            datamodels.CustomerInfo r6 = (datamodels.CustomerInfo) r6     // Catch:{ all -> 0x0053 }
            goto L_0x004e
        L_0x004d:
            r6 = r4
        L_0x004e:
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)     // Catch:{ all -> 0x0053 }
            goto L_0x005e
        L_0x0053:
            r6 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)
        L_0x005e:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r6)
            if (r0 != 0) goto L_0x0066
            r4 = r6
            goto L_0x0086
        L_0x0066:
            kotlin.Pair[] r6 = new kotlin.Pair[r3]
            java.lang.String r1 = r0.getMessage()
            if (r1 != 0) goto L_0x0070
            java.lang.String r1 = ""
        L_0x0070:
            java.lang.String r2 = "errorMessage"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r2, r1)
            r2 = 0
            r6[r2] = r1
            java.util.Map r6 = kotlin.collections.MapsKt__MapsKt.mutableMapOf(r6)
            java.lang.String r1 = "GetAppInfoUseCaseCachedCustomerInfoIsNull"
            com.talabat.observability.ObservabilityManager.trackUnExpectedScenario(r1, r6)
            r6 = 2
            com.talabat.talabatcore.logger.LogManager.error$default(r0, r4, r6, r4)
        L_0x0086:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.splash.domain.usecase.GetAppInfoUseCase.getCachedCustomerInfo(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Deferred<CustomerInfo> getCustomerInfoAsync(CoroutineScope coroutineScope, int i11) {
        return BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new GetAppInfoUseCase$getCustomerInfoAsync$1(this, i11, (Continuation<? super GetAppInfoUseCase$getCustomerInfoAsync$1>) null), 3, (Object) null);
    }

    private final Either<Failure, ScreenInfoWrapper> getScreenRedirectionInfo(AppInfoResponseWrapper appInfoResponseWrapper) {
        ScreenInfoWrapper screenInfoWrapper;
        String str;
        Boolean isForceUpdate = appInfoResponseWrapper.isForceUpdate();
        Intrinsics.checkNotNull(isForceUpdate);
        if (isForceUpdate.booleanValue()) {
            String forceUpdateMsg = appInfoResponseWrapper.getForceUpdateMsg();
            Intrinsics.checkNotNull(forceUpdateMsg);
            SplashRedirectionWrapper screenType = appInfoResponseWrapper.getScreenType();
            Intrinsics.checkNotNull(screenType);
            Boolean bool = Boolean.TRUE;
            screenInfoWrapper = new ScreenInfoWrapper(SplashDataUtils.FORCE_UPDATE_SCREEN, forceUpdateMsg, screenType, bool, bool);
        } else {
            Boolean isFirstInstall = appInfoResponseWrapper.isFirstInstall();
            Intrinsics.checkNotNull(isFirstInstall);
            if (!isFirstInstall.booleanValue()) {
                if (this.locationConfigRepository.config().getCountry() == Country.UNDEFINED) {
                    str = "Country Selection Screen";
                } else {
                    Boolean isShowAd = appInfoResponseWrapper.isShowAd();
                    Intrinsics.checkNotNull(isShowAd);
                    if (isShowAd.booleanValue()) {
                        str = "Ad Screen";
                    } else {
                        str = "Home Screen";
                    }
                }
                String str2 = str;
                SplashRedirectionWrapper screenType2 = appInfoResponseWrapper.getScreenType();
                Intrinsics.checkNotNull(screenType2);
                Boolean bool2 = Boolean.FALSE;
                screenInfoWrapper = new ScreenInfoWrapper(str2, "NA", screenType2, bool2, bool2);
            } else if (this.locationConfigRepository.config().getCountry() != Country.UNDEFINED) {
                SplashRedirectionWrapper screenType3 = appInfoResponseWrapper.getScreenType();
                Intrinsics.checkNotNull(screenType3);
                Boolean bool3 = Boolean.FALSE;
                screenInfoWrapper = new ScreenInfoWrapper("Home Screen", "NA", screenType3, bool3, bool3);
            } else {
                SplashRedirectionWrapper screenType4 = appInfoResponseWrapper.getScreenType();
                Intrinsics.checkNotNull(screenType4);
                Boolean bool4 = Boolean.FALSE;
                screenInfoWrapper = new ScreenInfoWrapper("Country Selection Screen", "NA", screenType4, bool4, bool4);
            }
            AppInfoGlobalConstantsWrapper appInfoGlobalConstantsWrapper2 = this.appInfoGlobalConstantsWrapper;
            if (appInfoGlobalConstantsWrapper2 != null) {
                appInfoGlobalConstantsWrapper2.updateFirstInstall();
            }
        }
        return new Either.Right(screenInfoWrapper);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object handleAppInfoResponseAndGetScreenRedirection(com.talabat.splash.domain.model.AppInfoResponseWrapper r5, kotlin.coroutines.Continuation<? super com.talabat.splash.core.functional.Either<? extends com.talabat.splash.core.exception.Failure, com.talabat.splash.domain.model.ScreenInfoWrapper>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.splash.domain.usecase.GetAppInfoUseCase$handleAppInfoResponseAndGetScreenRedirection$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.splash.domain.usecase.GetAppInfoUseCase$handleAppInfoResponseAndGetScreenRedirection$1 r0 = (com.talabat.splash.domain.usecase.GetAppInfoUseCase$handleAppInfoResponseAndGetScreenRedirection$1) r0
            int r1 = r0.f61487l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61487l = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.splash.domain.usecase.GetAppInfoUseCase$handleAppInfoResponseAndGetScreenRedirection$1 r0 = new com.talabat.splash.domain.usecase.GetAppInfoUseCase$handleAppInfoResponseAndGetScreenRedirection$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f61485j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f61487l
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r5 = r0.f61484i
            com.talabat.splash.domain.model.AppInfoResponseWrapper r5 = (com.talabat.splash.domain.model.AppInfoResponseWrapper) r5
            java.lang.Object r0 = r0.f61483h
            com.talabat.splash.domain.usecase.GetAppInfoUseCase r0 = (com.talabat.splash.domain.usecase.GetAppInfoUseCase) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004a
        L_0x0031:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.f61483h = r4
            r0.f61484i = r5
            r0.f61487l = r3
            java.lang.Object r6 = r4.retrieveAddressesFromMicroServiceIfPossible(r5, r0)
            if (r6 != r1) goto L_0x0049
            return r1
        L_0x0049:
            r0 = r4
        L_0x004a:
            com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository r6 = r0.userStatusRepository
            r6.resetUserStatusAllowedCheck()
            com.talabat.splash.core.functional.Either r5 = r0.getScreenRedirectionInfo(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.splash.domain.usecase.GetAppInfoUseCase.handleAppInfoResponseAndGetScreenRedirection(com.talabat.splash.domain.model.AppInfoResponseWrapper, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object retrieveAddressesFromMicroServiceIfPossible(AppInfoResponseWrapper appInfoResponseWrapper, Continuation<? super Unit> continuation) {
        if (this.locationConfigRepository.config().isAddressMicroServiceEnabled() && Intrinsics.areEqual((Object) appInfoResponseWrapper.isLoggedIn(), (Object) Boxing.boxBoolean(true))) {
            if (!LoggedInHelper.isLoggedIn()) {
                trackAuthTokenGotNull(false);
                Customer.retriveToken(this.context);
            }
            if (LoggedInHelper.isLoggedIn()) {
                Object retrieveCustomerAddresses = retrieveCustomerAddresses(GlobalDataModel.SelectedCountryId, continuation);
                if (retrieveCustomerAddresses == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return retrieveCustomerAddresses;
                }
                return Unit.INSTANCE;
            }
            trackAuthTokenGotNull(true);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object retrieveCustomerAddresses(int i11, Continuation<? super Unit> continuation) {
        Object retrieveAndCacheCustomerAddresses = this.retrieveAndCacheCustomerAddressesUseCase.retrieveAndCacheCustomerAddresses(i11, continuation);
        return retrieveAndCacheCustomerAddresses == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? retrieveAndCacheCustomerAddresses : Unit.INSTANCE;
    }

    private final void trackAuthTokenGotNull(boolean z11) {
        ObservabilityManager.trackEvent(BackgroundAction.TRACK_AUTH_TOKEN_GOT_NULL, (Map<String, String>) MapsKt__MapsJVMKt.mapOf(TuplesKt.to("afterRetrievingFromSharedPref", String.valueOf(z11))));
    }

    /* access modifiers changed from: private */
    public final void trackCustomerInfoReturnedNull(int i11, Throwable th2) {
        Pair[] pairArr = new Pair[2];
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        pairArr[0] = TuplesKt.to("errorMessage", message);
        pairArr[1] = TuplesKt.to("try", String.valueOf(i11));
        ObservabilityManager.trackUnExpectedScenario("GetAppInfoUseCaseFetchCustomerInfoIsNull", MapsKt__MapsKt.mutableMapOf(pairArr));
    }

    @Nullable
    public Object run(@NotNull AppInfoRequestModel appInfoRequestModel, @NotNull Continuation<? super Either<? extends Failure, ? extends Object>> continuation) {
        return getAppInfoAndCustomerInfo(appInfoRequestModel, continuation);
    }
}
