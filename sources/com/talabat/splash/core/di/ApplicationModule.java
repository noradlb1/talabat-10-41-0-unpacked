package com.talabat.splash.core.di;

import JsonModels.parser.UniversalGson;
import JsonModels.parser.UniversalGsonQualifier;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.WorkManager;
import buisnessmodels.Customer;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.domain.FWFAttributes;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.network.OKHttpBuilder;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import com.talabat.helpers.BASEURLS;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.TalabatApplication;
import com.talabat.notifications.brazemigrator.BrazeUserMigrator;
import com.talabat.notifications.brazemigrator.LoggedInUserMigrator;
import com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrationUseCase;
import com.talabat.notifications.brazemigrator.guestuser.domain.GuestUserMigrator;
import com.talabat.splash.data.local.LocalCache;
import com.talabat.splash.data.preferences.AppInfoLocalDataSource;
import com.talabat.splash.data.preferences.AppInfoLocalDataSourceImp;
import com.talabat.splash.data.remote.DownloadManager;
import com.talabat.splash.data.remote.SplashConfigurationRemoteDataSource;
import com.talabat.splash.data.repositories.AppInfoRepository;
import com.talabat.splash.data.repositories.AppInfoRepositoryImpl;
import com.talabat.splash.data.repositories.DownloadsRepositoryImpl;
import com.talabat.splash.data.repositories.SplashConfigurationRepositoryImpl;
import com.talabat.splash.data.repositories.SplashCustomerInfoRepository;
import com.talabat.splash.data.repositories.SplashCustomerInfoRepositoryImp;
import com.talabat.splash.domain.repository.DownloadsRepository;
import com.talabat.splash.domain.repository.SplashConfigurationRepository;
import com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase;
import com.talabat.splash.presentation.infrastructure.device.CommonUtils;
import com.talabat.splash.presentation.infrastructure.device.PresentationUtils;
import com.talabat.splash.presentation.infrastructure.device.currentlocation.CLInfrastrcture;
import com.talabat.splash.presentation.infrastructure.device.currentlocation.CLInfrastructureImpl;
import com.talabat.splash.presentation.infrastructure.thirdparty.ThirdPartyLibraryInfrastructure;
import com.talabat.splash.presentation.infrastructure.thirdparty.ThirdPartyLibraryInfrastructureImpl;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import com.talabat.user.address.di.AddressesDependencyProvider;
import com.talabat.user.address.domain.usecases.RetrieveAndCacheCustomerAddressesUseCase;
import com.talabat.userandlocation.compliance.status.di.module.UserStatusDomainModule;
import com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository;
import com.talabat.userandlocation.customerinfo.data.impl.CustomerInfoRepositoryImpl;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import com.talabat.userandlocation.customerinfo.data.remote.api.CustomerInfoApi;
import com.talabat.userandlocation.customerinfo.data.remote.impl.CustomerInfoRemoteDataSourceImpl;
import com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository;
import dagger.Module;
import dagger.Provides;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import library.talabat.mvp.login.data.repository.impl.CustomerRepositoryImpl;
import library.talabat.mvp.login.domain.repository.CustomerRepository;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tu.a;

@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0012\u0010\u0015\u001a\u00020\u00162\b\b\u0001\u0010\u0017\u001a\u00020\u0018H\u0007J\b\u0010\u0019\u001a\u00020\u001aH\u0007J\b\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000eH\u0007J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0007J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020%H\u0007J\b\u0010-\u001a\u00020\u0018H\u0007J\b\u0010.\u001a\u00020/H\u0007J\u0014\u00100\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020301H\u0007J\u0010\u00104\u001a\u0002052\u0006\u0010#\u001a\u00020\u000eH\u0007J\b\u00106\u001a\u000207H\u0007J\u0010\u00108\u001a\u0002092\u0006\u0010#\u001a\u00020\u000eH\u0007J\u0010\u0010:\u001a\u00020+2\u0006\u0010;\u001a\u00020<H\u0007J\b\u0010=\u001a\u00020>H\u0007J\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0007J\b\u0010C\u001a\u00020DH\u0007J\u0018\u0010E\u001a\u00020F2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010G\u001a\u00020HH\u0007J\u0010\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0007J\b\u0010M\u001a\u00020NH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/talabat/splash/core/di/ApplicationModule;", "", "application", "Lcom/talabat/helpers/TalabatApplication;", "(Lcom/talabat/helpers/TalabatApplication;)V", "provideAppInfoLocalDataSource", "Lcom/talabat/splash/data/preferences/AppInfoLocalDataSource;", "appInfoLocalDataSourceImp", "Lcom/talabat/splash/data/preferences/AppInfoLocalDataSourceImp;", "provideAppInfoRepository", "Lcom/talabat/splash/data/repositories/AppInfoRepository;", "appInfoRepository", "Lcom/talabat/splash/data/repositories/AppInfoRepositoryImpl;", "provideApplicationContext", "Landroid/content/Context;", "provideBrazeUserMigrator", "Lcom/talabat/notifications/brazemigrator/BrazeUserMigrator;", "provideCLRepository", "Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/CLInfrastrcture;", "clRepository", "Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/CLInfrastructureImpl;", "provideCommonUtils", "Lcom/talabat/splash/presentation/infrastructure/device/CommonUtils;", "gson", "Lcom/google/gson/Gson;", "provideCoroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "provideCustomer", "Lbuisnessmodels/Customer;", "provideCustomerInfoRepository", "Lcom/talabat/userandlocation/customerinfo/domain/repo/CustomerInfoRepository;", "proCentralizationStatusWrapper", "Lcom/talabat/feature/subscriptions/domain/wrapper/ProCentralizationStatusWrapper;", "provideCustomerRepository", "Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;", "context", "provideDownloadsRepository", "Lcom/talabat/splash/domain/repository/DownloadsRepository;", "downloadManager", "Lcom/talabat/splash/data/remote/DownloadManager;", "provideGetDynamicSplashContentUseCase", "Lcom/talabat/splash/domain/usecase/GetDynamicSplashContentUseCase;", "splashConfigurationRepository", "Lcom/talabat/splash/domain/repository/SplashConfigurationRepository;", "downloadsRepository", "provideGson", "provideLocalCache", "Lcom/talabat/splash/data/local/LocalCache;", "providePilotSetter", "Lio/reactivex/functions/Function;", "", "", "providePresentationUtils", "Lcom/talabat/splash/presentation/infrastructure/device/PresentationUtils;", "provideRetrofit", "Lretrofit2/Retrofit;", "provideSharedPreferences", "Landroid/content/SharedPreferences;", "provideSplashConfigurationRepository", "splashConfigurationRemoteDataSource", "Lcom/talabat/splash/data/remote/SplashConfigurationRemoteDataSource;", "provideTalabatRemoteConfiguration", "Lcom/talabat/talabatremoteconfiguration/RemoteConfiguration;", "provideThirdPartyLibraryInfrastructure", "Lcom/talabat/splash/presentation/infrastructure/thirdparty/ThirdPartyLibraryInfrastructure;", "thirdPartyLibraryInfrastructure", "Lcom/talabat/splash/presentation/infrastructure/thirdparty/ThirdPartyLibraryInfrastructureImpl;", "provideWorkManager", "Landroidx/work/WorkManager;", "providesRetrieveAndCacheCustomerAddressesUseCase", "Lcom/talabat/user/address/domain/usecases/RetrieveAndCacheCustomerAddressesUseCase;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "providesSplashCustomerInfoRepository", "Lcom/talabat/splash/data/repositories/SplashCustomerInfoRepository;", "splashCustomerInfoRepositoryImp", "Lcom/talabat/splash/data/repositories/SplashCustomerInfoRepositoryImp;", "providesUserStatusRepository", "Lcom/talabat/userandlocation/compliance/status/domain/repository/UserStatusRepository;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class ApplicationModule {
    @NotNull
    private final TalabatApplication application;

    public ApplicationModule(@NotNull TalabatApplication talabatApplication) {
        Intrinsics.checkNotNullParameter(talabatApplication, MimeTypes.BASE_TYPE_APPLICATION);
        this.application = talabatApplication;
    }

    /* access modifiers changed from: private */
    /* renamed from: providePilotSetter$lambda-0  reason: not valid java name */
    public static final Unit m10906providePilotSetter$lambda0(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        TalabatExperiment.INSTANCE.setAttribute(FWFAttributes.PILOT_TARGETING_ID, "", TalabatExperimentDataSourceStrategy.APPTIMIZE);
        return Unit.INSTANCE;
    }

    @NotNull
    @ExperimentalStdlibApi
    @Provides
    public final AppInfoLocalDataSource provideAppInfoLocalDataSource(@NotNull AppInfoLocalDataSourceImp appInfoLocalDataSourceImp) {
        Intrinsics.checkNotNullParameter(appInfoLocalDataSourceImp, "appInfoLocalDataSourceImp");
        return appInfoLocalDataSourceImp;
    }

    @Singleton
    @NotNull
    @Provides
    public final AppInfoRepository provideAppInfoRepository(@NotNull AppInfoRepositoryImpl appInfoRepositoryImpl) {
        Intrinsics.checkNotNullParameter(appInfoRepositoryImpl, "appInfoRepository");
        return appInfoRepositoryImpl;
    }

    @Singleton
    @NotNull
    @Provides
    public final Context provideApplicationContext() {
        return this.application;
    }

    @NotNull
    @Provides
    @Named("brazeMigrator")
    public final BrazeUserMigrator provideBrazeUserMigrator() {
        return new BrazeUserMigrator(this.application, (LoggedInUserMigrator) null, (GuestUserMigrator) null, (GuestUserMigrationUseCase) null, 14, (DefaultConstructorMarker) null);
    }

    @Singleton
    @NotNull
    @Provides
    public final CLInfrastrcture provideCLRepository(@NotNull CLInfrastructureImpl cLInfrastructureImpl) {
        Intrinsics.checkNotNullParameter(cLInfrastructureImpl, "clRepository");
        return cLInfrastructureImpl;
    }

    @Singleton
    @NotNull
    @Provides
    public final CommonUtils provideCommonUtils(@NotNull @UniversalGsonQualifier Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        return new CommonUtils(gson);
    }

    @NotNull
    @Provides
    public final CoroutineDispatcher provideCoroutineDispatcher() {
        return Dispatchers.getIO();
    }

    @Singleton
    @NotNull
    @Provides
    public final Customer provideCustomer() {
        Customer instance = Customer.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }

    @NotNull
    @Provides
    public final CustomerInfoRepository provideCustomerInfoRepository(@NotNull ProCentralizationStatusWrapper proCentralizationStatusWrapper) {
        Intrinsics.checkNotNullParameter(proCentralizationStatusWrapper, "proCentralizationStatusWrapper");
        return new CustomerInfoRepositoryImpl((CoroutineDispatcher) null, new CustomerInfoLocalDataSourceImpl((Context) null, (Gson) null, 3, (DefaultConstructorMarker) null), new CustomerInfoRemoteDataSourceImpl((CustomerInfoApi) new TalabatAPIBuilder().createApi(CustomerInfoApi.class)), proCentralizationStatusWrapper, 1, (DefaultConstructorMarker) null);
    }

    @NotNull
    @Provides
    public final CustomerRepository provideCustomerRepository(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new CustomerRepositoryImpl(context, (Customer) null, (Function1) null, 6, (DefaultConstructorMarker) null);
    }

    @NotNull
    @Provides
    public final DownloadsRepository provideDownloadsRepository(@NotNull DownloadManager downloadManager) {
        Intrinsics.checkNotNullParameter(downloadManager, "downloadManager");
        return new DownloadsRepositoryImpl(downloadManager);
    }

    @NotNull
    @Provides
    public final GetDynamicSplashContentUseCase provideGetDynamicSplashContentUseCase(@NotNull SplashConfigurationRepository splashConfigurationRepository, @NotNull DownloadsRepository downloadsRepository) {
        Intrinsics.checkNotNullParameter(splashConfigurationRepository, "splashConfigurationRepository");
        Intrinsics.checkNotNullParameter(downloadsRepository, "downloadsRepository");
        return new GetDynamicSplashContentUseCase(splashConfigurationRepository, downloadsRepository);
    }

    @UniversalGsonQualifier
    @Singleton
    @NotNull
    @Provides
    public final Gson provideGson() {
        Gson create = UniversalGson.INSTANCE.gson.newBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        Intrinsics.checkNotNullExpressionValue(create, "INSTANCE.gson.newBuilder…ES)\n            .create()");
        return create;
    }

    @NotNull
    @Provides
    public final LocalCache provideLocalCache() {
        return new LocalCache(this.application, (Function1) null, 2, (DefaultConstructorMarker) null);
    }

    @NotNull
    @Provides
    public final Function<String, Unit> providePilotSetter() {
        return new a();
    }

    @Singleton
    @NotNull
    @Provides
    public final PresentationUtils providePresentationUtils(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new PresentationUtils(context);
    }

    @Singleton
    @NotNull
    @Provides
    public final Retrofit provideRetrofit() {
        Retrofit build = new Retrofit.Builder().baseUrl(BASEURLS.getBaseurl()).client(OKHttpBuilder.getDefaultHttpClient$default(OKHttpBuilder.INSTANCE, (List) null, 0, 3, (Object) null)).addConverterFactory(GsonConverterFactory.create()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .b…e())\n            .build()");
        return build;
    }

    @Singleton
    @NotNull
    @Provides
    public final SharedPreferences provideSharedPreferences(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…(), Context.MODE_PRIVATE)");
        return sharedPreferences;
    }

    @NotNull
    @Provides
    public final SplashConfigurationRepository provideSplashConfigurationRepository(@NotNull SplashConfigurationRemoteDataSource splashConfigurationRemoteDataSource) {
        Intrinsics.checkNotNullParameter(splashConfigurationRemoteDataSource, "splashConfigurationRemoteDataSource");
        return new SplashConfigurationRepositoryImpl(splashConfigurationRemoteDataSource);
    }

    @NotNull
    @Provides
    public final RemoteConfiguration provideTalabatRemoteConfiguration() {
        return RemoteConfiguration.INSTANCE;
    }

    @Singleton
    @NotNull
    @Provides
    public final ThirdPartyLibraryInfrastructure provideThirdPartyLibraryInfrastructure(@NotNull ThirdPartyLibraryInfrastructureImpl thirdPartyLibraryInfrastructureImpl) {
        Intrinsics.checkNotNullParameter(thirdPartyLibraryInfrastructureImpl, "thirdPartyLibraryInfrastructure");
        return thirdPartyLibraryInfrastructureImpl;
    }

    @NotNull
    @Provides
    public final WorkManager provideWorkManager() {
        WorkManager instance = WorkManager.getInstance(this.application);
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(application)");
        return instance;
    }

    @NotNull
    @Provides
    public final RetrieveAndCacheCustomerAddressesUseCase providesRetrieveAndCacheCustomerAddressesUseCase(@NotNull Context context, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        return AddressesDependencyProvider.INSTANCE.provideRetrieveAndCacheCustomerAddressesUseCase(context, iTalabatFeatureFlag);
    }

    @Singleton
    @NotNull
    @Provides
    public final SplashCustomerInfoRepository providesSplashCustomerInfoRepository(@NotNull SplashCustomerInfoRepositoryImp splashCustomerInfoRepositoryImp) {
        Intrinsics.checkNotNullParameter(splashCustomerInfoRepositoryImp, "splashCustomerInfoRepositoryImp");
        return splashCustomerInfoRepositoryImp;
    }

    @NotNull
    @Provides
    public final UserStatusRepository providesUserStatusRepository() {
        return UserStatusDomainModule.INSTANCE.provideUserStatusRepository();
    }
}
