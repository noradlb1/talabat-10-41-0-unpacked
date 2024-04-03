package com.talabat.userandlocation.appinfo;

import JsonModels.Response.AppInitRM;
import buisnessmodels.Customer;
import buisnessmodels.mappers.TokenizedBankCardToOldTokenizedBankCardMapper;
import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.squareup.moshi.Moshi;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.MutableConfigurationRemoteRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
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
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import com.talabat.userandlocation.appinfo.data.remote.api.AppInfoApi;
import datamodels.Area;
import datamodels.City;
import datamodels.Country;
import datamodels.mappers.OldAreaToAreaMapper;
import datamodels.mappers.OldCityToCityMapper;
import datamodels.mappers.OldCountryToCountryMapper;
import java.util.ArrayList;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.login.domain.repository.CustomerRepository;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J!\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0019\u0010#\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/talabat/userandlocation/appinfo/AppInfoHandler;", "", "appInfoApi", "Lcom/talabat/userandlocation/appinfo/data/remote/api/AppInfoApi;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "customerAddressesRepository", "Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository;", "customerRepository", "Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;", "locationConfigRepository", "Lcom/talabat/configuration/MutableLocationConfigurationRepository;", "mutableConfigurationRemoteRepository", "Lcom/talabat/configuration/MutableConfigurationRemoteRepository;", "paymentConfigurationRepository", "Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "tokenizedBankCardToOldTokenizedBankCardMapper", "Lbuisnessmodels/mappers/TokenizedBankCardToOldTokenizedBankCardMapper;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/talabat/userandlocation/appinfo/data/remote/api/AppInfoApi;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository;Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;Lcom/talabat/configuration/MutableLocationConfigurationRepository;Lcom/talabat/configuration/MutableConfigurationRemoteRepository;Lcom/talabat/configuration/payment/PaymentConfigurationRepository;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lbuisnessmodels/mappers/TokenizedBankCardToOldTokenizedBankCardMapper;Lcom/squareup/moshi/Moshi;)V", "getAddressesFromMicroService", "", "Lcom/talabat/domain/address/Address;", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleAppinitCountrySpecifiedDataReceived", "", "fromLegacy", "", "response", "LJsonModels/Response/AppInitRM;", "refreshAppInfo", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ExperimentalStdlibApi
public final class AppInfoHandler {
    @NotNull
    private final AppInfoApi appInfoApi;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final CustomerAddressesRepository customerAddressesRepository;
    @NotNull
    private final CustomerRepository customerRepository;
    @NotNull
    private final MutableLocationConfigurationRepository locationConfigRepository;
    @NotNull
    private final Moshi moshi;
    @NotNull
    private final MutableConfigurationRemoteRepository mutableConfigurationRemoteRepository;
    @NotNull
    private final PaymentConfigurationRepository paymentConfigurationRepository;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;
    @NotNull
    private final TokenizedBankCardToOldTokenizedBankCardMapper tokenizedBankCardToOldTokenizedBankCardMapper;

    public AppInfoHandler(@NotNull AppInfoApi appInfoApi2, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull CustomerAddressesRepository customerAddressesRepository2, @NotNull CustomerRepository customerRepository2, @NotNull MutableLocationConfigurationRepository mutableLocationConfigurationRepository, @NotNull MutableConfigurationRemoteRepository mutableConfigurationRemoteRepository2, @NotNull PaymentConfigurationRepository paymentConfigurationRepository2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull TokenizedBankCardToOldTokenizedBankCardMapper tokenizedBankCardToOldTokenizedBankCardMapper2, @NotNull Moshi moshi2) {
        Intrinsics.checkNotNullParameter(appInfoApi2, "appInfoApi");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(customerAddressesRepository2, "customerAddressesRepository");
        Intrinsics.checkNotNullParameter(customerRepository2, "customerRepository");
        Intrinsics.checkNotNullParameter(mutableLocationConfigurationRepository, "locationConfigRepository");
        Intrinsics.checkNotNullParameter(mutableConfigurationRemoteRepository2, "mutableConfigurationRemoteRepository");
        Intrinsics.checkNotNullParameter(paymentConfigurationRepository2, "paymentConfigurationRepository");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(tokenizedBankCardToOldTokenizedBankCardMapper2, "tokenizedBankCardToOldTokenizedBankCardMapper");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        this.appInfoApi = appInfoApi2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.customerAddressesRepository = customerAddressesRepository2;
        this.customerRepository = customerRepository2;
        this.locationConfigRepository = mutableLocationConfigurationRepository;
        this.mutableConfigurationRemoteRepository = mutableConfigurationRemoteRepository2;
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.tokenizedBankCardToOldTokenizedBankCardMapper = tokenizedBankCardToOldTokenizedBankCardMapper2;
        this.moshi = moshi2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getAddressesFromMicroService(int r6, kotlin.coroutines.Continuation<? super java.util.List<com.talabat.domain.address.Address>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.talabat.userandlocation.appinfo.AppInfoHandler$getAddressesFromMicroService$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.userandlocation.appinfo.AppInfoHandler$getAddressesFromMicroService$1 r0 = (com.talabat.userandlocation.appinfo.AppInfoHandler$getAddressesFromMicroService$1) r0
            int r1 = r0.f12167j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12167j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.userandlocation.appinfo.AppInfoHandler$getAddressesFromMicroService$1 r0 = new com.talabat.userandlocation.appinfo.AppInfoHandler$getAddressesFromMicroService$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f12165h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12167j
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0034
            if (r2 != r4) goto L_0x002c
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
            if (r7 == 0) goto L_0x0068
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x002a }
            com.talabat.user.address.domain.repository.CustomerAddressesRepository r7 = r5.customerAddressesRepository     // Catch:{ all -> 0x002a }
            r0.f12167j = r4     // Catch:{ all -> 0x002a }
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
            if (r7 != 0) goto L_0x0063
            r3 = r6
            goto L_0x0066
        L_0x0063:
            com.talabat.talabatcore.logger.LogManager.logException(r7)
        L_0x0066:
            java.util.List r3 = (java.util.List) r3
        L_0x0068:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.appinfo.AppInfoHandler.getAddressesFromMicroService(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final boolean getAddressesFromMicroService$canInvokeAddressMicroService(AppInfoHandler appInfoHandler) {
        return appInfoHandler.locationConfigRepository.config().isAddressMicroServiceEnabled() && LoggedInHelper.isLoggedIn();
    }

    private final void handleAppinitCountrySpecifiedDataReceived(boolean z11, AppInitRM appInitRM) {
        boolean z12;
        TokenisationCreditCard[] tokenisationCreditCardArr;
        AppInitRM appInitRM2 = appInitRM;
        GlobalDataModel.countries = appInitRM2.result.countries;
        OldCountryToCountryMapper oldCountryToCountryMapper = new OldCountryToCountryMapper(new OldCityToCityMapper());
        MutableLocationConfigurationRepository mutableLocationConfigurationRepository = this.locationConfigRepository;
        LocationConfig config = mutableLocationConfigurationRepository.config();
        Country[] countryArr = appInitRM2.result.countries;
        Intrinsics.checkNotNullExpressionValue(countryArr, "response.result.countries");
        ArrayList arrayList = new ArrayList(countryArr.length);
        for (Country apply : countryArr) {
            arrayList.add(oldCountryToCountryMapper.apply(apply));
        }
        mutableLocationConfigurationRepository.setConfig(LocationConfig.copy$default(config, (List) null, (List) null, (com.talabat.configuration.country.Country) null, arrayList, false, 0, 55, (Object) null));
        Country[] countryArr2 = appInitRM2.result.countries;
        Intrinsics.checkNotNullExpressionValue(countryArr2, "response.result.countries");
        LogManager.debug("[ALOVx]: appinfo #1: response=" + ArraysKt___ArraysKt.joinToString$default((Object[]) countryArr2, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + ", config=" + this.locationConfigRepository.config() + ", countriesFromConfig=" + CollectionsKt___CollectionsKt.joinToString$default(this.locationConfigRepository.countries(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
        boolean z13 = true;
        if (this.configurationLocalRepository.selectedCountry().getCountryId() > 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (GlobalDataModel.SelectedCityId <= 0) {
            z13 = false;
        }
        if (z12) {
            Country[] countryArr3 = appInitRM2.result.countries;
            Intrinsics.checkNotNullExpressionValue(countryArr3, "response.result.countries");
            int length = countryArr3.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                Country country = countryArr3[i11];
                if (country.f13845id == this.configurationLocalRepository.selectedCountry().getCountryId()) {
                    GlobalDataModel.SelectedCountryName = country.f13846name;
                    if (z13) {
                        City[] cityArr = country.cities;
                        Intrinsics.checkNotNullExpressionValue(cityArr, "c.cities");
                        int length2 = cityArr.length;
                        int i12 = 0;
                        while (true) {
                            if (i12 >= length2) {
                                break;
                            }
                            City city = cityArr[i12];
                            if (city.f13843id == GlobalDataModel.SelectedCityId) {
                                GlobalDataModel.SelectedCityName = city.f13844name;
                                break;
                            }
                            i12++;
                        }
                    }
                }
                i11++;
            }
        }
        GlobalDataModel.imageBaseUrl = appInitRM2.baseUrl;
        if (!ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.talabatFeatureFlag, HomePageFeatureFlagsKeys.FF_HOMEPAGE_AREAS_UL_ENDPOINT, false, 2, (Object) null)) {
            if (ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.talabatFeatureFlag, LocationFeatureFlagConstants.LOCATION_REPO_REAL_AREAS, false, 2, (Object) null)) {
                OldAreaToAreaMapper oldAreaToAreaMapper = new OldAreaToAreaMapper();
                MutableLocationConfigurationRepository mutableLocationConfigurationRepository2 = this.locationConfigRepository;
                LocationConfig config2 = mutableLocationConfigurationRepository2.config();
                Area[] areaArr = appInitRM2.result.areas;
                Intrinsics.checkNotNullExpressionValue(areaArr, "response.result.areas");
                ArrayList arrayList2 = new ArrayList(areaArr.length);
                for (Area apply2 : areaArr) {
                    arrayList2.add(oldAreaToAreaMapper.apply(apply2));
                }
                mutableLocationConfigurationRepository2.setConfig(LocationConfig.copy$default(config2, (List) null, arrayList2, (com.talabat.configuration.country.Country) null, (List) null, false, 0, 61, (Object) null));
            } else {
                GlobalDataModel.areas = appInitRM2.result.areas;
            }
        }
        GlobalDataModel.CHECKOUTDOTCOM.publicKey = appInitRM2.result.publicKey;
        Customer instance = Customer.getInstance();
        if (z11) {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(this.locationConfigRepository.addresses());
            instance.setCustomerAddress((ArrayList<Address>) arrayList3);
        }
        if (ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.talabatFeatureFlag, PayFeatureFlagConstants.PayFeatureFlagsWithoutCountry.PAYMENT_REPO_REAL_CARD_TOKENS, false, 2, (Object) null)) {
            Iterable<TokenizedBankCard> tokenizedBankCards = this.paymentConfigurationRepository.walletConfig().getTokenizedBankCards();
            TokenizedBankCardToOldTokenizedBankCardMapper tokenizedBankCardToOldTokenizedBankCardMapper2 = this.tokenizedBankCardToOldTokenizedBankCardMapper;
            ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(tokenizedBankCards, 10));
            for (TokenizedBankCard apply3 : tokenizedBankCards) {
                arrayList4.add(tokenizedBankCardToOldTokenizedBankCardMapper2.apply(apply3));
            }
            Object[] array = arrayList4.toArray(new TokenisationCreditCard[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            tokenisationCreditCardArr = (TokenisationCreditCard[]) array;
        } else {
            tokenisationCreditCardArr = appInitRM2.result.tokens;
        }
        instance.setSavedCreditCards(tokenisationCreditCardArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object refreshAppInfo(int r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.talabat.userandlocation.appinfo.AppInfoHandler$refreshAppInfo$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.talabat.userandlocation.appinfo.AppInfoHandler$refreshAppInfo$1 r0 = (com.talabat.userandlocation.appinfo.AppInfoHandler$refreshAppInfo$1) r0
            int r1 = r0.f12173m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12173m = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.userandlocation.appinfo.AppInfoHandler$refreshAppInfo$1 r0 = new com.talabat.userandlocation.appinfo.AppInfoHandler$refreshAppInfo$1
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f12171k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12173m
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004b
            if (r2 == r4) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r11 = r0.f12169i
            java.lang.Object r0 = r0.f12168h
            com.talabat.userandlocation.appinfo.AppInfoHandler r0 = (com.talabat.userandlocation.appinfo.AppInfoHandler) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00b5
        L_0x0033:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003b:
            int r11 = r0.f12170j
            java.lang.Object r2 = r0.f12169i
            com.talabat.userandlocation.appinfo.AppInfoHandler r2 = (com.talabat.userandlocation.appinfo.AppInfoHandler) r2
            java.lang.Object r5 = r0.f12168h
            com.talabat.userandlocation.appinfo.AppInfoHandler r5 = (com.talabat.userandlocation.appinfo.AppInfoHandler) r5
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0049 }
            goto L_0x0063
        L_0x0049:
            r12 = move-exception
            goto L_0x009a
        L_0x004b:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlin.Result$Companion r12 = kotlin.Result.Companion     // Catch:{ all -> 0x0098 }
            com.talabat.userandlocation.appinfo.data.remote.api.AppInfoApi r12 = r10.appInfoApi     // Catch:{ all -> 0x0098 }
            r0.f12168h = r10     // Catch:{ all -> 0x0098 }
            r0.f12169i = r10     // Catch:{ all -> 0x0098 }
            r0.f12170j = r11     // Catch:{ all -> 0x0098 }
            r0.f12173m = r4     // Catch:{ all -> 0x0098 }
            java.lang.Object r12 = r12.getAppInfo(r11, r0)     // Catch:{ all -> 0x0098 }
            if (r12 != r1) goto L_0x0061
            return r1
        L_0x0061:
            r2 = r10
            r5 = r2
        L_0x0063:
            r6 = r12
            JsonModels.Response.AppInitRM r6 = (JsonModels.Response.AppInitRM) r6     // Catch:{ all -> 0x0049 }
            com.squareup.moshi.Moshi r7 = r2.moshi     // Catch:{ all -> 0x0049 }
            java.lang.Class<JsonModels.Response.AppInitRM> r8 = JsonModels.Response.AppInitRM.class
            kotlin.reflect.KType r8 = kotlin.jvm.internal.Reflection.typeOf((java.lang.Class) r8)     // Catch:{ all -> 0x0049 }
            com.squareup.moshi.JsonAdapter r7 = com.squareup.moshi._MoshiKotlinExtensionsKt.adapter(r7, r8)     // Catch:{ all -> 0x0049 }
            java.lang.String r6 = r7.toJson(r6)     // Catch:{ all -> 0x0049 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0049 }
            r7.<init>()     // Catch:{ all -> 0x0049 }
            java.lang.String r8 = "{\"appInfoResponse\":"
            r7.append(r8)     // Catch:{ all -> 0x0049 }
            r7.append(r6)     // Catch:{ all -> 0x0049 }
            java.lang.String r6 = "}"
            r7.append(r6)     // Catch:{ all -> 0x0049 }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x0049 }
            com.talabat.configuration.MutableConfigurationRemoteRepository r2 = r2.mutableConfigurationRemoteRepository     // Catch:{ all -> 0x0049 }
            r2.setCachedAppRemoteConfig(r6)     // Catch:{ all -> 0x0049 }
            JsonModels.Response.AppInitRM r12 = (JsonModels.Response.AppInitRM) r12     // Catch:{ all -> 0x0049 }
            java.lang.Object r12 = kotlin.Result.m6329constructorimpl(r12)     // Catch:{ all -> 0x0049 }
            goto L_0x00a4
        L_0x0098:
            r12 = move-exception
            r5 = r10
        L_0x009a:
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r12 = kotlin.ResultKt.createFailure(r12)
            java.lang.Object r12 = kotlin.Result.m6329constructorimpl(r12)
        L_0x00a4:
            r9 = r12
            r12 = r11
            r11 = r9
            r0.f12168h = r5
            r0.f12169i = r11
            r0.f12173m = r3
            java.lang.Object r12 = r5.getAddressesFromMicroService(r12, r0)
            if (r12 != r1) goto L_0x00b4
            return r1
        L_0x00b4:
            r0 = r5
        L_0x00b5:
            java.util.List r12 = (java.util.List) r12
            boolean r1 = kotlin.Result.m6336isSuccessimpl(r11)
            if (r1 == 0) goto L_0x00d3
            if (r12 != 0) goto L_0x00c0
            goto L_0x00c1
        L_0x00c0:
            r4 = 0
        L_0x00c1:
            kotlin.ResultKt.throwOnFailure(r11)
            JsonModels.Response.AppInitRM r11 = (JsonModels.Response.AppInitRM) r11
            r0.handleAppinitCountrySpecifiedDataReceived(r4, r11)
            if (r12 == 0) goto L_0x00d0
            library.talabat.mvp.login.domain.repository.CustomerRepository r11 = r0.customerRepository
            r11.setCustomerAddresses(r12)
        L_0x00d0:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00d3:
            java.lang.Exception r12 = new java.lang.Exception
            java.lang.Throwable r11 = kotlin.Result.m6332exceptionOrNullimpl(r11)
            r12.<init>(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.appinfo.AppInfoHandler.refreshAppInfo(int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
