package com.talabat.userandlocation.choosecountry.di.module;

import android.content.Context;
import buisnessmodels.Customer;
import com.google.gson.Gson;
import com.squareup.moshi.Moshi;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.configuration.MutableConfigurationRemoteRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.usecase.GetProCentralizationStatusUseCase;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import com.talabat.growth.features.loyalty.sharedpreferences.IsUserRewardsSharedPreferences;
import com.talabat.helpers.BASEURLS;
import com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl;
import com.talabat.user.address.data.local.AddressesLocalDataSource;
import com.talabat.user.address.data.remote.AddressDtoMapper;
import com.talabat.user.address.data.remote.api.AddressApi;
import com.talabat.user.address.data.remote.impl.AddressRemoteDataSourceImpl;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl;
import com.talabat.userandlocation.appinfo.data.local.AppInfoLocalDataSource;
import com.talabat.userandlocation.appinfo.data.remote.api.AppInfoApi;
import com.talabat.userandlocation.appinfo.data.remote.impl.AppInfoRemoteDataSourceImpl;
import com.talabat.userandlocation.choosecountry.domain.UseCases;
import com.talabat.userandlocation.choosecountry.domain.entity.CountryVO;
import com.talabat.userandlocation.choosecountry.domain.usecase.business.GetSupportedCountriesForUserToChooseUseCase;
import com.talabat.userandlocation.choosecountry.domain.usecase.business.RequestAreasToCacheUseCase;
import com.talabat.userandlocation.choosecountry.domain.usecase.business.SetUserSelectedCountryUseCase;
import com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.GetSupportedCountriesForUserToChooseUseCaseImpl;
import com.talabat.userandlocation.choosecountry.domain.usecase.business.impl.SetUserSelectedCountryUseCaseImpl;
import com.talabat.userandlocation.choosecountry.domain.usecase.impl.UseCasesImpl;
import com.talabat.userandlocation.customerinfo.data.impl.CustomerInfoRepositoryImpl;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import com.talabat.userandlocation.customerinfo.data.remote.api.CustomerInfoApi;
import com.talabat.userandlocation.customerinfo.data.remote.impl.CustomerInfoRemoteDataSourceImpl;
import datamodels.mappers.CountryToOldCountryMapper;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineDispatcher;
import library.talabat.mvp.login.data.repository.impl.CustomerRepositoryImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jq\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J$\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0 2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010+\u001a\u00020\u001eH\u0002J \u0010,\u001a\u00020-2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002Jp\u0010.\u001a\u00020/2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&2\u0006\u0010#\u001a\u00020\u00112\u0006\u00100\u001a\u0002012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u00102\u001a\u0002032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00104\u001a\u000205H\u0002J$\u00106\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\t072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00100\u001a\u000201H\u0002Ju\u00108\u001a\u0002092\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&2\u0006\u0010#\u001a\u00020\u00112\u0006\u00100\u001a\u0002012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u00102\u001a\u0002032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00104\u001a\u000205H\u0000¢\u0006\u0002\b:\u0002\u0004\n\u0002\b\u0019¨\u0006;"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/di/module/DomainModule;", "", "()V", "getAppInfoDelegate", "Lkotlin/reflect/KSuspendFunction1;", "", "Lkotlin/ParameterName;", "name", "countryId", "", "context", "Landroid/content/Context;", "moshi", "Lcom/squareup/moshi/Moshi;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "mutableLocationConfigRepository", "Lcom/talabat/configuration/MutableLocationConfigurationRepository;", "mutableConfigurationRemoteRepository", "Lcom/talabat/configuration/MutableConfigurationRemoteRepository;", "paymentConfigurationRepository", "Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "subscriptionsCustomerRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsCustomerRepository;", "getProCentralizationStatusUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetProCentralizationStatusUseCase;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Landroid/content/Context;Lcom/squareup/moshi/Moshi;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/configuration/MutableLocationConfigurationRepository;Lcom/talabat/configuration/MutableConfigurationRemoteRepository;Lcom/talabat/configuration/payment/PaymentConfigurationRepository;Lcom/talabat/feature/subscriptions/domain/ISubscriptionsCustomerRepository;Lcom/talabat/feature/subscriptions/domain/usecase/GetProCentralizationStatusUseCase;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)Lkotlin/reflect/KFunction;", "provideAddressApi", "Lcom/talabat/user/address/data/remote/api/AddressApi;", "provideCountriesRepository", "Lkotlin/Function0;", "", "Lcom/talabat/userandlocation/choosecountry/domain/entity/CountryVO;", "locationConfigRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "countryToOldCountryMapper", "Ldatamodels/mappers/CountryToOldCountryMapper;", "provideCustomerAddressesRepository", "Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository;", "provideCustomerRepository", "Llibrary/talabat/mvp/login/data/repository/impl/CustomerRepositoryImpl;", "provideFallbackAddressApi", "provideGetSupportedCountriesForUserToChooseUseCase", "Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/GetSupportedCountriesForUserToChooseUseCase;", "provideOnUserChooseCountryUseCase", "Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/SetUserSelectedCountryUseCase;", "mutableConfigurationLocalRepository", "Lcom/talabat/configuration/MutableConfigurationLocalRepository;", "requestAreasToCacheUseCase", "Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/RequestAreasToCacheUseCase;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "provideSaveSelectedCountryDelegate", "Lkotlin/Function1;", "provideUseCases", "Lcom/talabat/userandlocation/choosecountry/domain/UseCases;", "provideUseCases$com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ExperimentalStdlibApi
public final class DomainModule {
    @NotNull
    public static final DomainModule INSTANCE = new DomainModule();

    private DomainModule() {
    }

    private final AddressApi provideAddressApi() {
        TalabatAPIBuilder talabatAPIBuilder = new TalabatAPIBuilder();
        String buildUserLocationBaseURL = BASEURLS.buildUserLocationBaseURL("release");
        Intrinsics.checkNotNullExpressionValue(buildUserLocationBaseURL, "buildUserLocationBaseURL(BuildConfig.BUILD_TYPE)");
        return (AddressApi) talabatAPIBuilder.createApi(buildUserLocationBaseURL, AddressApi.class);
    }

    private final Function0<List<CountryVO>> provideCountriesRepository(LocationConfigurationRepository locationConfigurationRepository, CountryToOldCountryMapper countryToOldCountryMapper) {
        return new DomainModule$provideCountriesRepository$1(locationConfigurationRepository, countryToOldCountryMapper);
    }

    private final CustomerAddressesRepository provideCustomerAddressesRepository(ITalabatFeatureFlag iTalabatFeatureFlag) {
        AddressApi provideAddressApi = provideAddressApi();
        AddressDtoMapper addressDtoMapper = new AddressDtoMapper();
        AddressApi provideFallbackAddressApi = provideFallbackAddressApi();
        Customer instance = Customer.getInstance();
        AddressRemoteDataSourceImpl addressRemoteDataSourceImpl = new AddressRemoteDataSourceImpl(provideAddressApi, addressDtoMapper);
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return new CustomerAddressesRepositoryImpl(provideAddressApi, provideFallbackAddressApi, addressRemoteDataSourceImpl, addressDtoMapper, instance, (AddressesLocalDataSource) null, (CoroutineDispatcher) null, iTalabatFeatureFlag, 96, (DefaultConstructorMarker) null);
    }

    private final CustomerRepositoryImpl provideCustomerRepository(Context context) {
        Customer instance = Customer.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return new CustomerRepositoryImpl(context, instance, (Function1) null, 4, (DefaultConstructorMarker) null);
    }

    private final AddressApi provideFallbackAddressApi() {
        return (AddressApi) new TalabatAPIBuilder().createApi(AddressApi.class);
    }

    private final GetSupportedCountriesForUserToChooseUseCase provideGetSupportedCountriesForUserToChooseUseCase(ConfigurationLocalRepository configurationLocalRepository, LocationConfigurationRepository locationConfigurationRepository, CountryToOldCountryMapper countryToOldCountryMapper) {
        return new GetSupportedCountriesForUserToChooseUseCaseImpl(provideCountriesRepository(locationConfigurationRepository, countryToOldCountryMapper), configurationLocalRepository);
    }

    private final SetUserSelectedCountryUseCase provideOnUserChooseCountryUseCase(Context context, Moshi moshi, ConfigurationLocalRepository configurationLocalRepository, CountryToOldCountryMapper countryToOldCountryMapper, MutableLocationConfigurationRepository mutableLocationConfigurationRepository, MutableConfigurationLocalRepository mutableConfigurationLocalRepository, MutableConfigurationRemoteRepository mutableConfigurationRemoteRepository, RequestAreasToCacheUseCase requestAreasToCacheUseCase, PaymentConfigurationRepository paymentConfigurationRepository, ISubscriptionsCustomerRepository iSubscriptionsCustomerRepository, GetProCentralizationStatusUseCase getProCentralizationStatusUseCase, ITalabatFeatureFlag iTalabatFeatureFlag, IObservabilityManager iObservabilityManager) {
        Context context2 = context;
        MutableConfigurationLocalRepository mutableConfigurationLocalRepository2 = mutableConfigurationLocalRepository;
        MutableLocationConfigurationRepository mutableLocationConfigurationRepository2 = mutableLocationConfigurationRepository;
        GetSupportedCountriesForUserToChooseUseCase provideGetSupportedCountriesForUserToChooseUseCase = provideGetSupportedCountriesForUserToChooseUseCase(mutableConfigurationLocalRepository2, mutableLocationConfigurationRepository2, countryToOldCountryMapper);
        IsUserRewardsSharedPreferences isUserRewardsSharedPreferences = r1;
        IsUserRewardsSharedPreferences isUserRewardsSharedPreferences2 = new IsUserRewardsSharedPreferences(context2);
        Function1<CountryVO, Unit> provideSaveSelectedCountryDelegate = provideSaveSelectedCountryDelegate(context2, mutableConfigurationLocalRepository2);
        KFunction<Unit> appInfoDelegate = getAppInfoDelegate(context, moshi, configurationLocalRepository, mutableLocationConfigurationRepository2, mutableConfigurationRemoteRepository, paymentConfigurationRepository, iSubscriptionsCustomerRepository, getProCentralizationStatusUseCase, iTalabatFeatureFlag);
        DomainModule$provideOnUserChooseCountryUseCase$1 domainModule$provideOnUserChooseCountryUseCase$1 = r1;
        DomainModule$provideOnUserChooseCountryUseCase$1 domainModule$provideOnUserChooseCountryUseCase$12 = new DomainModule$provideOnUserChooseCountryUseCase$1((Continuation<? super DomainModule$provideOnUserChooseCountryUseCase$1>) null);
        DomainModule$provideOnUserChooseCountryUseCase$2 domainModule$provideOnUserChooseCountryUseCase$2 = DomainModule$provideOnUserChooseCountryUseCase$2.INSTANCE;
        DomainModule$provideOnUserChooseCountryUseCase$3 domainModule$provideOnUserChooseCountryUseCase$3 = DomainModule$provideOnUserChooseCountryUseCase$3.INSTANCE;
        DomainModule$provideOnUserChooseCountryUseCase$4 domainModule$provideOnUserChooseCountryUseCase$4 = r2;
        DomainModule$provideOnUserChooseCountryUseCase$4 domainModule$provideOnUserChooseCountryUseCase$42 = new DomainModule$provideOnUserChooseCountryUseCase$4(context2);
        Function2 function2 = (Function2) appInfoDelegate;
        DomainModule$provideOnUserChooseCountryUseCase$5 domainModule$provideOnUserChooseCountryUseCase$5 = DomainModule$provideOnUserChooseCountryUseCase$5.INSTANCE;
        DomainModule$provideOnUserChooseCountryUseCase$6 domainModule$provideOnUserChooseCountryUseCase$6 = DomainModule$provideOnUserChooseCountryUseCase$6.INSTANCE;
        DomainModule$provideOnUserChooseCountryUseCase$7 domainModule$provideOnUserChooseCountryUseCase$7 = DomainModule$provideOnUserChooseCountryUseCase$7.INSTANCE;
        DomainModule$provideOnUserChooseCountryUseCase$8 domainModule$provideOnUserChooseCountryUseCase$8 = r0;
        DomainModule$provideOnUserChooseCountryUseCase$8 domainModule$provideOnUserChooseCountryUseCase$82 = new DomainModule$provideOnUserChooseCountryUseCase$8(context2);
        DomainModule$provideOnUserChooseCountryUseCase$9 domainModule$provideOnUserChooseCountryUseCase$9 = r0;
        DomainModule$provideOnUserChooseCountryUseCase$9 domainModule$provideOnUserChooseCountryUseCase$92 = new DomainModule$provideOnUserChooseCountryUseCase$9(context2);
        return new SetUserSelectedCountryUseCaseImpl(domainModule$provideOnUserChooseCountryUseCase$2, mutableConfigurationLocalRepository, provideGetSupportedCountriesForUserToChooseUseCase, isUserRewardsSharedPreferences, provideSaveSelectedCountryDelegate, domainModule$provideOnUserChooseCountryUseCase$3, domainModule$provideOnUserChooseCountryUseCase$4, function2, requestAreasToCacheUseCase, domainModule$provideOnUserChooseCountryUseCase$5, domainModule$provideOnUserChooseCountryUseCase$6, domainModule$provideOnUserChooseCountryUseCase$7, domainModule$provideOnUserChooseCountryUseCase$8, domainModule$provideOnUserChooseCountryUseCase$9, DomainModule$provideOnUserChooseCountryUseCase$10.INSTANCE, domainModule$provideOnUserChooseCountryUseCase$1, iObservabilityManager);
    }

    private final Function1<CountryVO, Unit> provideSaveSelectedCountryDelegate(Context context, MutableConfigurationLocalRepository mutableConfigurationLocalRepository) {
        return new DomainModule$provideSaveSelectedCountryDelegate$1(mutableConfigurationLocalRepository, context);
    }

    @NotNull
    public final KFunction<Unit> getAppInfoDelegate(@NotNull Context context, @NotNull Moshi moshi, @NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull MutableLocationConfigurationRepository mutableLocationConfigurationRepository, @NotNull MutableConfigurationRemoteRepository mutableConfigurationRemoteRepository, @NotNull PaymentConfigurationRepository paymentConfigurationRepository, @NotNull ISubscriptionsCustomerRepository iSubscriptionsCustomerRepository, @NotNull GetProCentralizationStatusUseCase getProCentralizationStatusUseCase, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Moshi moshi2 = moshi;
        MutableConfigurationRemoteRepository mutableConfigurationRemoteRepository2 = mutableConfigurationRemoteRepository;
        ISubscriptionsCustomerRepository iSubscriptionsCustomerRepository2 = iSubscriptionsCustomerRepository;
        GetProCentralizationStatusUseCase getProCentralizationStatusUseCase2 = getProCentralizationStatusUseCase;
        ITalabatFeatureFlag iTalabatFeatureFlag2 = iTalabatFeatureFlag;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        ConfigurationLocalRepository configurationLocalRepository2 = configurationLocalRepository;
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        MutableLocationConfigurationRepository mutableLocationConfigurationRepository2 = mutableLocationConfigurationRepository;
        Intrinsics.checkNotNullParameter(mutableLocationConfigurationRepository2, "mutableLocationConfigRepository");
        Intrinsics.checkNotNullParameter(mutableConfigurationRemoteRepository2, "mutableConfigurationRemoteRepository");
        PaymentConfigurationRepository paymentConfigurationRepository2 = paymentConfigurationRepository;
        Intrinsics.checkNotNullParameter(paymentConfigurationRepository2, "paymentConfigurationRepository");
        Intrinsics.checkNotNullParameter(iSubscriptionsCustomerRepository2, "subscriptionsCustomerRepository");
        Intrinsics.checkNotNullParameter(getProCentralizationStatusUseCase2, "getProCentralizationStatusUseCase");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag2, "talabatFeatureFlag");
        return new DomainModule$getAppInfoDelegate$1(new AppInfoRepositoryImpl((CoroutineDispatcher) null, (CoroutineDispatcher) null, new AppInfoRemoteDataSourceImpl((AppInfoApi) new TalabatAPIBuilder().createApi(AppInfoApi.class), mutableConfigurationRemoteRepository2, moshi2), provideCustomerAddressesRepository(iTalabatFeatureFlag2), provideCustomerRepository(context), new CustomerInfoRepositoryImpl((CoroutineDispatcher) null, new CustomerInfoLocalDataSourceImpl((Context) null, (Gson) null, 3, (DefaultConstructorMarker) null), new CustomerInfoRemoteDataSourceImpl((CustomerInfoApi) new TalabatAPIBuilder().createApi(CustomerInfoApi.class)), new ProCentralizationStatusWrapper(getProCentralizationStatusUseCase2, iSubscriptionsCustomerRepository2), 1, (DefaultConstructorMarker) null), configurationLocalRepository2, mutableLocationConfigurationRepository2, (AppInfoLocalDataSource) null, paymentConfigurationRepository2, iTalabatFeatureFlag2, 259, (DefaultConstructorMarker) null));
    }

    @NotNull
    public final UseCases provideUseCases$com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry(@NotNull Context context, @NotNull Moshi moshi, @NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull CountryToOldCountryMapper countryToOldCountryMapper, @NotNull MutableLocationConfigurationRepository mutableLocationConfigurationRepository, @NotNull MutableConfigurationLocalRepository mutableConfigurationLocalRepository, @NotNull MutableConfigurationRemoteRepository mutableConfigurationRemoteRepository, @NotNull RequestAreasToCacheUseCase requestAreasToCacheUseCase, @NotNull PaymentConfigurationRepository paymentConfigurationRepository, @NotNull ISubscriptionsCustomerRepository iSubscriptionsCustomerRepository, @NotNull GetProCentralizationStatusUseCase getProCentralizationStatusUseCase, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(countryToOldCountryMapper, "countryToOldCountryMapper");
        Intrinsics.checkNotNullParameter(mutableLocationConfigurationRepository, "locationConfigRepository");
        Intrinsics.checkNotNullParameter(mutableConfigurationLocalRepository, "mutableConfigurationLocalRepository");
        Intrinsics.checkNotNullParameter(mutableConfigurationRemoteRepository, "mutableConfigurationRemoteRepository");
        Intrinsics.checkNotNullParameter(requestAreasToCacheUseCase, "requestAreasToCacheUseCase");
        Intrinsics.checkNotNullParameter(paymentConfigurationRepository, "paymentConfigurationRepository");
        Intrinsics.checkNotNullParameter(iSubscriptionsCustomerRepository, "subscriptionsCustomerRepository");
        Intrinsics.checkNotNullParameter(getProCentralizationStatusUseCase, "getProCentralizationStatusUseCase");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        return new UseCasesImpl(provideGetSupportedCountriesForUserToChooseUseCase(mutableConfigurationLocalRepository, mutableLocationConfigurationRepository, countryToOldCountryMapper), provideOnUserChooseCountryUseCase(context, moshi, configurationLocalRepository, countryToOldCountryMapper, mutableLocationConfigurationRepository, mutableConfigurationLocalRepository, mutableConfigurationRemoteRepository, requestAreasToCacheUseCase, paymentConfigurationRepository, iSubscriptionsCustomerRepository, getProCentralizationStatusUseCase, iTalabatFeatureFlag, iObservabilityManager));
    }
}
