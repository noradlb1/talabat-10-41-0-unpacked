package com.talabat.userandlocation.appinfo.data.impl;

import JsonModels.AppInitResponse;
import JsonModels.Response.AppInitRM;
import buisnessmodels.Customer;
import buisnessmodels.mappers.TokenizedBankCardToOldTokenizedBankCardMapper;
import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.location.City;
import com.talabat.configuration.location.LocationConfig;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.configuration.payment.TokenizedBankCard;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.location.LocationFeatureFlagConstants;
import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageFeatureFlagsKeys;
import com.talabat.domain.address.Address;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.LoggedInHelper;
import com.talabat.observability.ObservabilityManager;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import com.talabat.userandlocation.appinfo.data.local.AppInfoLocalDataSource;
import com.talabat.userandlocation.appinfo.data.remote.AppInfoRemoteDataSource;
import com.talabat.userandlocation.appinfo.domain.repo.AppInfoRepository;
import com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository;
import datamodels.Area;
import datamodels.CustomerInfo;
import datamodels.mappers.OldAreaToAreaMapper;
import datamodels.mappers.OldCityToCityMapper;
import datamodels.mappers.OldCountryToCountryMapper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import library.talabat.mvp.login.domain.repository.CustomerRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001Be\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J3\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\b\u0010$\u001a\u0004\u0018\u00010%H@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0019\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)H@ø\u0001\u0000¢\u0006\u0002\u0010*J\u0019\u0010+\u001a\u00020%2\u0006\u0010(\u001a\u00020)H@ø\u0001\u0000¢\u0006\u0002\u0010*J!\u0010,\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\u0006\u0010(\u001a\u00020)H@ø\u0001\u0000¢\u0006\u0002\u0010*J\u0018\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020\u001eH\u0002J\"\u00100\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020#\u0018\u00010\"01*\u0002022\u0006\u0010(\u001a\u00020)H\u0002J\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020 01*\u0002022\u0006\u0010(\u001a\u00020)H\u0002J\u001c\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%01*\u0002022\u0006\u0010(\u001a\u00020)H\u0002R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lcom/talabat/userandlocation/appinfo/data/impl/AppInfoRepositoryImpl;", "Lcom/talabat/userandlocation/appinfo/domain/repo/AppInfoRepository;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "appInfoRemoteDataSource", "Lcom/talabat/userandlocation/appinfo/data/remote/AppInfoRemoteDataSource;", "customerAddressesRepository", "Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository;", "customerRepository", "Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;", "customerInfoRepository", "Lcom/talabat/userandlocation/customerinfo/domain/repo/CustomerInfoRepository;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "mutableLocationConfigRepository", "Lcom/talabat/configuration/MutableLocationConfigurationRepository;", "appInfoLocalDataSource", "Lcom/talabat/userandlocation/appinfo/data/local/AppInfoLocalDataSource;", "paymentConfigurationRepository", "Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/userandlocation/appinfo/data/remote/AppInfoRemoteDataSource;Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository;Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;Lcom/talabat/userandlocation/customerinfo/domain/repo/CustomerInfoRepository;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/configuration/MutableLocationConfigurationRepository;Lcom/talabat/userandlocation/appinfo/data/local/AppInfoLocalDataSource;Lcom/talabat/configuration/payment/PaymentConfigurationRepository;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "assignCountryAndCityNames", "", "cacheApplicationInformation", "response", "LJsonModels/AppInitResponse;", "imageBaseUrl", "", "appInitResponse", "LJsonModels/Response/AppInitRM;", "addressesFromMicroService", "", "Lcom/talabat/domain/address/Address;", "customerInfo", "Ldatamodels/CustomerInfo;", "(LJsonModels/Response/AppInitRM;Ljava/util/List;Ldatamodels/CustomerInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchAppInfo", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchCustomerInfo", "getAddressesFromMicroService", "trackCustomerInfoReturnedNull", "numberOfTries", "message", "fetchAddressesAsync", "Lkotlinx/coroutines/Deferred;", "Lkotlinx/coroutines/CoroutineScope;", "fetchAppInfoAsync", "getCustomerInfoWithRetryAsync", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppInfoRepositoryImpl implements AppInfoRepository {
    /* access modifiers changed from: private */
    @NotNull
    public final AppInfoLocalDataSource appInfoLocalDataSource;
    /* access modifiers changed from: private */
    @NotNull
    public final AppInfoRemoteDataSource appInfoRemoteDataSource;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final CustomerAddressesRepository customerAddressesRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final CustomerInfoRepository customerInfoRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final CustomerRepository customerRepository;
    @NotNull
    private final CoroutineDispatcher dispatcher;
    @NotNull
    private final CoroutineDispatcher mainDispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLocationConfigurationRepository mutableLocationConfigRepository;
    @NotNull
    private final PaymentConfigurationRepository paymentConfigurationRepository;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppInfoRepositoryImpl(@org.jetbrains.annotations.NotNull com.talabat.userandlocation.appinfo.data.remote.AppInfoRemoteDataSource r16, @org.jetbrains.annotations.NotNull com.talabat.user.address.domain.repository.CustomerAddressesRepository r17, @org.jetbrains.annotations.NotNull library.talabat.mvp.login.domain.repository.CustomerRepository r18, @org.jetbrains.annotations.NotNull com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository r19, @org.jetbrains.annotations.NotNull com.talabat.configuration.ConfigurationLocalRepository r20, @org.jetbrains.annotations.NotNull com.talabat.configuration.MutableLocationConfigurationRepository r21, @org.jetbrains.annotations.NotNull com.talabat.configuration.payment.PaymentConfigurationRepository r22, @org.jetbrains.annotations.NotNull com.talabat.core.featureflag.domain.ITalabatFeatureFlag r23) {
        /*
            r15 = this;
            java.lang.String r0 = "appInfoRemoteDataSource"
            r4 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "customerAddressesRepository"
            r5 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "customerRepository"
            r6 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "customerInfoRepository"
            r7 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "configurationLocalRepository"
            r8 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "mutableLocationConfigRepository"
            r9 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "paymentConfigurationRepository"
            r11 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "talabatFeatureFlag"
            r12 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r2 = 0
            r3 = 0
            r10 = 0
            r13 = 259(0x103, float:3.63E-43)
            r14 = 0
            r1 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl.<init>(com.talabat.userandlocation.appinfo.data.remote.AppInfoRemoteDataSource, com.talabat.user.address.domain.repository.CustomerAddressesRepository, library.talabat.mvp.login.domain.repository.CustomerRepository, com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository, com.talabat.configuration.ConfigurationLocalRepository, com.talabat.configuration.MutableLocationConfigurationRepository, com.talabat.configuration.payment.PaymentConfigurationRepository, com.talabat.core.featureflag.domain.ITalabatFeatureFlag):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppInfoRepositoryImpl(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineDispatcher r16, @org.jetbrains.annotations.NotNull com.talabat.userandlocation.appinfo.data.remote.AppInfoRemoteDataSource r17, @org.jetbrains.annotations.NotNull com.talabat.user.address.domain.repository.CustomerAddressesRepository r18, @org.jetbrains.annotations.NotNull library.talabat.mvp.login.domain.repository.CustomerRepository r19, @org.jetbrains.annotations.NotNull com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository r20, @org.jetbrains.annotations.NotNull com.talabat.configuration.ConfigurationLocalRepository r21, @org.jetbrains.annotations.NotNull com.talabat.configuration.MutableLocationConfigurationRepository r22, @org.jetbrains.annotations.NotNull com.talabat.configuration.payment.PaymentConfigurationRepository r23, @org.jetbrains.annotations.NotNull com.talabat.core.featureflag.domain.ITalabatFeatureFlag r24) {
        /*
            r15 = this;
            java.lang.String r0 = "mainDispatcher"
            r2 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "appInfoRemoteDataSource"
            r4 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "customerAddressesRepository"
            r5 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "customerRepository"
            r6 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "customerInfoRepository"
            r7 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "configurationLocalRepository"
            r8 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "mutableLocationConfigRepository"
            r9 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "paymentConfigurationRepository"
            r11 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "talabatFeatureFlag"
            r12 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r3 = 0
            r10 = 0
            r13 = 258(0x102, float:3.62E-43)
            r14 = 0
            r1 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl.<init>(kotlinx.coroutines.CoroutineDispatcher, com.talabat.userandlocation.appinfo.data.remote.AppInfoRemoteDataSource, com.talabat.user.address.domain.repository.CustomerAddressesRepository, library.talabat.mvp.login.domain.repository.CustomerRepository, com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository, com.talabat.configuration.ConfigurationLocalRepository, com.talabat.configuration.MutableLocationConfigurationRepository, com.talabat.configuration.payment.PaymentConfigurationRepository, com.talabat.core.featureflag.domain.ITalabatFeatureFlag):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppInfoRepositoryImpl(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineDispatcher r16, @org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineDispatcher r17, @org.jetbrains.annotations.NotNull com.talabat.userandlocation.appinfo.data.remote.AppInfoRemoteDataSource r18, @org.jetbrains.annotations.NotNull com.talabat.user.address.domain.repository.CustomerAddressesRepository r19, @org.jetbrains.annotations.NotNull library.talabat.mvp.login.domain.repository.CustomerRepository r20, @org.jetbrains.annotations.NotNull com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository r21, @org.jetbrains.annotations.NotNull com.talabat.configuration.ConfigurationLocalRepository r22, @org.jetbrains.annotations.NotNull com.talabat.configuration.MutableLocationConfigurationRepository r23, @org.jetbrains.annotations.NotNull com.talabat.configuration.payment.PaymentConfigurationRepository r24, @org.jetbrains.annotations.NotNull com.talabat.core.featureflag.domain.ITalabatFeatureFlag r25) {
        /*
            r15 = this;
            java.lang.String r0 = "mainDispatcher"
            r2 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "dispatcher"
            r3 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "appInfoRemoteDataSource"
            r4 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "customerAddressesRepository"
            r5 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "customerRepository"
            r6 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "customerInfoRepository"
            r7 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "configurationLocalRepository"
            r8 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "mutableLocationConfigRepository"
            r9 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "paymentConfigurationRepository"
            r11 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "talabatFeatureFlag"
            r12 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r10 = 0
            r13 = 256(0x100, float:3.59E-43)
            r14 = 0
            r1 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl.<init>(kotlinx.coroutines.CoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher, com.talabat.userandlocation.appinfo.data.remote.AppInfoRemoteDataSource, com.talabat.user.address.domain.repository.CustomerAddressesRepository, library.talabat.mvp.login.domain.repository.CustomerRepository, com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository, com.talabat.configuration.ConfigurationLocalRepository, com.talabat.configuration.MutableLocationConfigurationRepository, com.talabat.configuration.payment.PaymentConfigurationRepository, com.talabat.core.featureflag.domain.ITalabatFeatureFlag):void");
    }

    @JvmOverloads
    public AppInfoRepositoryImpl(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull CoroutineDispatcher coroutineDispatcher2, @NotNull AppInfoRemoteDataSource appInfoRemoteDataSource2, @NotNull CustomerAddressesRepository customerAddressesRepository2, @NotNull CustomerRepository customerRepository2, @NotNull CustomerInfoRepository customerInfoRepository2, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull MutableLocationConfigurationRepository mutableLocationConfigurationRepository, @NotNull AppInfoLocalDataSource appInfoLocalDataSource2, @NotNull PaymentConfigurationRepository paymentConfigurationRepository2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "mainDispatcher");
        Intrinsics.checkNotNullParameter(coroutineDispatcher2, "dispatcher");
        Intrinsics.checkNotNullParameter(appInfoRemoteDataSource2, "appInfoRemoteDataSource");
        Intrinsics.checkNotNullParameter(customerAddressesRepository2, "customerAddressesRepository");
        Intrinsics.checkNotNullParameter(customerRepository2, "customerRepository");
        Intrinsics.checkNotNullParameter(customerInfoRepository2, "customerInfoRepository");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(mutableLocationConfigurationRepository, "mutableLocationConfigRepository");
        Intrinsics.checkNotNullParameter(appInfoLocalDataSource2, "appInfoLocalDataSource");
        Intrinsics.checkNotNullParameter(paymentConfigurationRepository2, "paymentConfigurationRepository");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.mainDispatcher = coroutineDispatcher;
        this.dispatcher = coroutineDispatcher2;
        this.appInfoRemoteDataSource = appInfoRemoteDataSource2;
        this.customerAddressesRepository = customerAddressesRepository2;
        this.customerRepository = customerRepository2;
        this.customerInfoRepository = customerInfoRepository2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.mutableLocationConfigRepository = mutableLocationConfigurationRepository;
        this.appInfoLocalDataSource = appInfoLocalDataSource2;
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    private final void assignCountryAndCityNames() {
        boolean z11;
        Country selectedCountry = this.configurationLocalRepository.selectedCountry();
        boolean z12 = true;
        if (selectedCountry.getCountryId() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (GlobalDataModel.SelectedCityId <= 0) {
            z12 = false;
        }
        if (z11) {
            for (com.talabat.configuration.location.Country next : this.mutableLocationConfigRepository.countries()) {
                if (next.getCountry().getCountryId() == selectedCountry.getCountryId()) {
                    GlobalDataModel.SelectedCountryName = next.getCountry().getCountryName();
                    if (z12) {
                        for (City next2 : next.getCities()) {
                            if (next2.getId() == GlobalDataModel.SelectedCityId) {
                                GlobalDataModel.SelectedCityName = next2.getName();
                                return;
                            }
                        }
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final Object cacheApplicationInformation(AppInitRM appInitRM, List<Address> list, CustomerInfo customerInfo, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.mainDispatcher, new AppInfoRepositoryImpl$cacheApplicationInformation$2(this, appInitRM, list, customerInfo, (Continuation<? super AppInfoRepositoryImpl$cacheApplicationInformation$2>) null), continuation);
        return withContext == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Deferred<List<Address>> fetchAddressesAsync(CoroutineScope coroutineScope, int i11) {
        return BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AppInfoRepositoryImpl$fetchAddressesAsync$1(this, i11, (Continuation<? super AppInfoRepositoryImpl$fetchAddressesAsync$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Deferred<AppInitRM> fetchAppInfoAsync(CoroutineScope coroutineScope, int i11) {
        return BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AppInfoRepositoryImpl$fetchAppInfoAsync$1(this, i11, (Continuation<? super AppInfoRepositoryImpl$fetchAppInfoAsync$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fetchCustomerInfo(int r5, kotlin.coroutines.Continuation<? super datamodels.CustomerInfo> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl$fetchCustomerInfo$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl$fetchCustomerInfo$1 r0 = (com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl$fetchCustomerInfo$1) r0
            int r1 = r0.f12191j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12191j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl$fetchCustomerInfo$1 r0 = new com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl$fetchCustomerInfo$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f12189h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12191j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x0048 }
            goto L_0x0041
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x0048 }
            com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository r6 = r4.customerInfoRepository     // Catch:{ all -> 0x0048 }
            r0.f12191j = r3     // Catch:{ all -> 0x0048 }
            java.lang.Object r6 = r6.fetchCustomerInfo(r5, r0)     // Catch:{ all -> 0x0048 }
            if (r6 != r1) goto L_0x0041
            return r1
        L_0x0041:
            datamodels.CustomerInfo r6 = (datamodels.CustomerInfo) r6     // Catch:{ all -> 0x0048 }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r6)     // Catch:{ all -> 0x0048 }
            goto L_0x0053
        L_0x0048:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x0053:
            kotlin.ResultKt.throwOnFailure(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl.fetchCustomerInfo(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getAddressesFromMicroService(int r6, kotlin.coroutines.Continuation<? super java.util.List<com.talabat.domain.address.Address>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl$getAddressesFromMicroService$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl$getAddressesFromMicroService$1 r0 = (com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl$getAddressesFromMicroService$1) r0
            int r1 = r0.f12194j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12194j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl$getAddressesFromMicroService$1 r0 = new com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl$getAddressesFromMicroService$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f12192h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12194j
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x002a }
            goto L_0x004a
        L_0x002a:
            r6 = move-exception
            goto L_0x0051
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r7 = getAddressesFromMicroService$canInvokeAddressMicroService(r5)
            if (r7 == 0) goto L_0x0069
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x002a }
            com.talabat.user.address.domain.repository.CustomerAddressesRepository r7 = r5.customerAddressesRepository     // Catch:{ all -> 0x002a }
            r0.f12194j = r3     // Catch:{ all -> 0x002a }
            java.lang.Object r7 = r7.getCustomerAddressesFor(r6, r0)     // Catch:{ all -> 0x002a }
            if (r7 != r1) goto L_0x004a
            return r1
        L_0x004a:
            java.util.List r7 = (java.util.List) r7     // Catch:{ all -> 0x002a }
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r7)     // Catch:{ all -> 0x002a }
            goto L_0x005b
        L_0x0051:
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)
        L_0x005b:
            java.lang.Throwable r7 = kotlin.Result.m6332exceptionOrNullimpl(r6)
            if (r7 != 0) goto L_0x0065
            r4 = r6
            java.util.List r4 = (java.util.List) r4
            goto L_0x0069
        L_0x0065:
            r6 = 2
            com.talabat.talabatcore.logger.LogManager.error$default(r7, r4, r6, r4)
        L_0x0069:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl.getAddressesFromMicroService(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final boolean getAddressesFromMicroService$canInvokeAddressMicroService(AppInfoRepositoryImpl appInfoRepositoryImpl) {
        return appInfoRepositoryImpl.mutableLocationConfigRepository.config().isAddressMicroServiceEnabled() && LoggedInHelper.isLoggedIn();
    }

    /* access modifiers changed from: private */
    public final Deferred<CustomerInfo> getCustomerInfoWithRetryAsync(CoroutineScope coroutineScope, int i11) {
        return BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AppInfoRepositoryImpl$getCustomerInfoWithRetryAsync$1(this, i11, (Continuation<? super AppInfoRepositoryImpl$getCustomerInfoWithRetryAsync$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void trackCustomerInfoReturnedNull(int i11, String str) {
        ObservabilityManager.trackUnExpectedScenario("AppInfoRepositoryImplFetchCustomerInfoIsNull", MapsKt__MapsKt.mutableMapOf(TuplesKt.to("try", String.valueOf(i11)), TuplesKt.to("errorMessage", str)));
    }

    @Nullable
    public Object fetchAppInfo(int i11, @NotNull Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatcher, new AppInfoRepositoryImpl$fetchAppInfo$2(i11, this, (Continuation<? super AppInfoRepositoryImpl$fetchAppInfo$2>) null), continuation);
        return withContext == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void cacheApplicationInformation(AppInitResponse appInitResponse, String str) {
        TokenisationCreditCard[] tokenisationCreditCardArr;
        GlobalDataModel.countries = appInitResponse.countries;
        OldCountryToCountryMapper oldCountryToCountryMapper = new OldCountryToCountryMapper(new OldCityToCityMapper());
        MutableLocationConfigurationRepository mutableLocationConfigurationRepository = this.mutableLocationConfigRepository;
        LocationConfig config = mutableLocationConfigurationRepository.config();
        datamodels.Country[] countryArr = appInitResponse.countries;
        Intrinsics.checkNotNullExpressionValue(countryArr, "response.countries");
        ArrayList arrayList = new ArrayList(countryArr.length);
        for (datamodels.Country apply : countryArr) {
            arrayList.add(oldCountryToCountryMapper.apply(apply));
        }
        mutableLocationConfigurationRepository.setConfig(LocationConfig.copy$default(config, (List) null, (List) null, (Country) null, arrayList, false, 0, 55, (Object) null));
        datamodels.Country[] countryArr2 = appInitResponse.countries;
        Intrinsics.checkNotNullExpressionValue(countryArr2, "response.countries");
        LogManager.debug("[ALOVx]: appinfo #2: response=" + ArraysKt___ArraysKt.joinToString$default((Object[]) countryArr2, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + ", config=" + this.mutableLocationConfigRepository.config() + ", countriesFromConfig=" + CollectionsKt___CollectionsKt.joinToString$default(this.mutableLocationConfigRepository.countries(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
        assignCountryAndCityNames();
        GlobalDataModel.imageBaseUrl = str;
        if (!ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.talabatFeatureFlag, HomePageFeatureFlagsKeys.FF_HOMEPAGE_AREAS_UL_ENDPOINT, false, 2, (Object) null)) {
            if (ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.talabatFeatureFlag, LocationFeatureFlagConstants.LOCATION_REPO_REAL_AREAS, false, 2, (Object) null)) {
                OldAreaToAreaMapper oldAreaToAreaMapper = new OldAreaToAreaMapper();
                MutableLocationConfigurationRepository mutableLocationConfigurationRepository2 = this.mutableLocationConfigRepository;
                LocationConfig config2 = mutableLocationConfigurationRepository2.config();
                Area[] areaArr = appInitResponse.areas;
                Intrinsics.checkNotNullExpressionValue(areaArr, "response.areas");
                ArrayList arrayList2 = new ArrayList(areaArr.length);
                for (Area apply2 : areaArr) {
                    arrayList2.add(oldAreaToAreaMapper.apply(apply2));
                }
                mutableLocationConfigurationRepository2.setConfig(LocationConfig.copy$default(config2, (List) null, arrayList2, (Country) null, (List) null, false, 0, 61, (Object) null));
            } else {
                GlobalDataModel.areas = appInitResponse.areas;
            }
        }
        GlobalDataModel.CHECKOUTDOTCOM.publicKey = appInitResponse.publicKey;
        if (ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.talabatFeatureFlag, PayFeatureFlagConstants.PayFeatureFlagsWithoutCountry.PAYMENT_REPO_REAL_CARD_TOKENS, false, 2, (Object) null)) {
            TokenizedBankCardToOldTokenizedBankCardMapper tokenizedBankCardToOldTokenizedBankCardMapper = new TokenizedBankCardToOldTokenizedBankCardMapper();
            Iterable<TokenizedBankCard> tokenizedBankCards = this.paymentConfigurationRepository.walletConfig().getTokenizedBankCards();
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(tokenizedBankCards, 10));
            for (TokenizedBankCard apply3 : tokenizedBankCards) {
                arrayList3.add(tokenizedBankCardToOldTokenizedBankCardMapper.apply(apply3));
            }
            Object[] array = arrayList3.toArray(new TokenisationCreditCard[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            tokenisationCreditCardArr = (TokenisationCreditCard[]) array;
        } else {
            tokenisationCreditCardArr = appInitResponse.tokens;
        }
        Customer.getInstance().setSavedCreditCards(tokenisationCreditCardArr);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AppInfoRepositoryImpl(kotlinx.coroutines.CoroutineDispatcher r15, kotlinx.coroutines.CoroutineDispatcher r16, com.talabat.userandlocation.appinfo.data.remote.AppInfoRemoteDataSource r17, com.talabat.user.address.domain.repository.CustomerAddressesRepository r18, library.talabat.mvp.login.domain.repository.CustomerRepository r19, com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository r20, com.talabat.configuration.ConfigurationLocalRepository r21, com.talabat.configuration.MutableLocationConfigurationRepository r22, com.talabat.userandlocation.appinfo.data.local.AppInfoLocalDataSource r23, com.talabat.configuration.payment.PaymentConfigurationRepository r24, com.talabat.core.featureflag.domain.ITalabatFeatureFlag r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r14 = this;
            r0 = r26
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000c
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            r3 = r1
            goto L_0x000d
        L_0x000c:
            r3 = r15
        L_0x000d:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0017
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getIO()
            r4 = r1
            goto L_0x0019
        L_0x0017:
            r4 = r16
        L_0x0019:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0026
            com.talabat.userandlocation.appinfo.data.local.AppInfoLocalDataSourceImp r0 = new com.talabat.userandlocation.appinfo.data.local.AppInfoLocalDataSourceImp
            r1 = 0
            r2 = 1
            r0.<init>(r1, r2, r1)
            r11 = r0
            goto L_0x0028
        L_0x0026:
            r11 = r23
        L_0x0028:
            r2 = r14
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            r12 = r24
            r13 = r25
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl.<init>(kotlinx.coroutines.CoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher, com.talabat.userandlocation.appinfo.data.remote.AppInfoRemoteDataSource, com.talabat.user.address.domain.repository.CustomerAddressesRepository, library.talabat.mvp.login.domain.repository.CustomerRepository, com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository, com.talabat.configuration.ConfigurationLocalRepository, com.talabat.configuration.MutableLocationConfigurationRepository, com.talabat.userandlocation.appinfo.data.local.AppInfoLocalDataSource, com.talabat.configuration.payment.PaymentConfigurationRepository, com.talabat.core.featureflag.domain.ITalabatFeatureFlag, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
