package com.talabat.core.flutter.channels.impl.data.address;

import JsonModels.parser.UniversalGson;
import android.app.Application;
import android.content.SharedPreferences;
import buisnessmodels.Customer;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.squareup.moshi.Moshi;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.configuration.MutableConfigurationRemoteRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.experiment.domain.FWFAttributes;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.flutter.channels.domain.address.AddressInfoChannelCallback;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.pinless.checkout.domain.GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase;
import com.talabat.domain.address.Address;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.user.address.di.AddressesDependencyProvider;
import datamodels.QuickOrderInfo;
import datamodels.QuickOrderUserInfo;
import datamodels.mappers.CityToOldCityMapper;
import datamodels.mappers.CountryToOldCountryMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.homemap.HomeMapTemp;
import library.talabat.mvp.login.di.DependencyProvider;
import library.talabat.mvp.login.domain.repository.CustomerRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001Bo\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cJ\u001c\u0010#\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020&\u0012\u0006\u0012\u0004\u0018\u00010'0%0$H\u0016J \u0010(\u001a\u0012\u0012\u0004\u0012\u00020&\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010%2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020.H\u0002J\"\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020&2\b\u00101\u001a\u0004\u0018\u00010&2\u0006\u00102\u001a\u00020*H\u0002J\u001a\u00103\u001a\u00020.2\b\u00101\u001a\u0004\u0018\u00010&2\u0006\u00102\u001a\u00020*H\u0016J\u001a\u00104\u001a\u00020.2\b\u00101\u001a\u0004\u0018\u00010&2\u0006\u00102\u001a\u00020*H\u0016J(\u00105\u001a\u0012\u0012\u0004\u0012\u00020&\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010%2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020&H\u0002J\u0010\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020;H\u0002J\u0010\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u00020>H\u0002J\u0018\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020*2\u0006\u0010A\u001a\u00020&H\u0002J\u0014\u0010B\u001a\u00020.2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030$H\u0016J0\u0010D\u001a\u00020.2\u0006\u0010)\u001a\u00020*2\u0006\u0010E\u001a\u00020&2\u0006\u0010F\u001a\u00020&2\u000e\u0010G\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030%H\u0016J\u0018\u0010H\u001a\u00020.2\u0006\u0010I\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0016J\u0019\u0010J\u001a\u00020.2\u0006\u0010@\u001a\u00020*H@ø\u0001\u0000¢\u0006\u0002\u0010KJ\u0018\u0010L\u001a\u00020.2\u000e\u0010G\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030%H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006M"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/address/AddressInfoChannelCallbackImpl;", "Lcom/talabat/core/flutter/channels/domain/address/AddressInfoChannelCallback;", "application", "Landroid/app/Application;", "getHasUserPinnedLocationInCurrentOnboardingSessionUseCase", "Lcom/talabat/core/pinless/checkout/domain/GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase;", "flutterAddressMapper", "Lcom/talabat/core/flutter/channels/impl/data/address/FlutterAddressMapper;", "nativeAddressMapper", "Lcom/talabat/core/flutter/channels/impl/data/address/NativeAddressMapper;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "moshi", "Lcom/squareup/moshi/Moshi;", "paymentConfigurationRepository", "Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "mutableConfigurationLocalRepository", "Lcom/talabat/configuration/MutableConfigurationLocalRepository;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "mutableLocationConfigRepository", "Lcom/talabat/configuration/MutableLocationConfigurationRepository;", "mutableConfigurationRemoteRepository", "Lcom/talabat/configuration/MutableConfigurationRemoteRepository;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Landroid/app/Application;Lcom/talabat/core/pinless/checkout/domain/GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase;Lcom/talabat/core/flutter/channels/impl/data/address/FlutterAddressMapper;Lcom/talabat/core/flutter/channels/impl/data/address/NativeAddressMapper;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;Lcom/talabat/core/experiment/domain/ITalabatExperiment;Lcom/squareup/moshi/Moshi;Lcom/talabat/configuration/payment/PaymentConfigurationRepository;Lcom/talabat/configuration/MutableConfigurationLocalRepository;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/configuration/MutableLocationConfigurationRepository;Lcom/talabat/configuration/MutableConfigurationRemoteRepository;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "cityToOldCityMapper", "Ldatamodels/mappers/CityToOldCityMapper;", "countryToOldCountryMapper", "Ldatamodels/mappers/CountryToOldCountryMapper;", "customerRepository", "Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;", "getAddressList", "", "", "", "", "getGuestAddressInfo", "areaId", "", "getSkipAddressMap", "", "initialiseCountryPreferences", "", "observeChannelBehaviour", "explanation", "activityName", "channelIdentity", "onAttach", "onDetach", "readGuestAddress", "preferences", "Landroid/content/SharedPreferences;", "key", "saveQuickOrderAddressData", "info", "Ldatamodels/QuickOrderInfo;", "saveQuickOrderUserData", "quickOrderUserInfo", "Ldatamodels/QuickOrderUserInfo;", "saveSelectedCountry", "countryId", "countryName", "setAddressList", "addresses", "setGuestAddressInfo", "firstName", "lastName", "addressMap", "setSelectedAddress", "addressId", "setSelectedCountry", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSelectedUnsavedAddress", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddressInfoChannelCallbackImpl implements AddressInfoChannelCallback {
    @NotNull
    private final Application application;
    @NotNull
    private final CityToOldCityMapper cityToOldCityMapper;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final CountryToOldCountryMapper countryToOldCountryMapper;
    @NotNull
    private final CustomerRepository customerRepository;
    @NotNull
    private final FlutterAddressMapper flutterAddressMapper;
    @NotNull
    private final GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase getHasUserPinnedLocationInCurrentOnboardingSessionUseCase;
    @NotNull
    private final Moshi moshi;
    @NotNull
    private final MutableConfigurationLocalRepository mutableConfigurationLocalRepository;
    @NotNull
    private final MutableConfigurationRemoteRepository mutableConfigurationRemoteRepository;
    @NotNull
    private final MutableLocationConfigurationRepository mutableLocationConfigRepository;
    @NotNull
    private final NativeAddressMapper nativeAddressMapper;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final PaymentConfigurationRepository paymentConfigurationRepository;
    @NotNull
    private final ITalabatExperiment talabatExperiment;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    @Inject
    public AddressInfoChannelCallbackImpl(@NotNull Application application2, @NotNull GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase getHasUserPinnedLocationInCurrentOnboardingSessionUseCase2, @NotNull FlutterAddressMapper flutterAddressMapper2, @NotNull NativeAddressMapper nativeAddressMapper2, @NotNull IObservabilityManager iObservabilityManager, @NotNull ITalabatExperiment iTalabatExperiment, @NotNull Moshi moshi2, @NotNull PaymentConfigurationRepository paymentConfigurationRepository2, @NotNull MutableConfigurationLocalRepository mutableConfigurationLocalRepository2, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull MutableLocationConfigurationRepository mutableLocationConfigurationRepository, @NotNull MutableConfigurationRemoteRepository mutableConfigurationRemoteRepository2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(application2, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(getHasUserPinnedLocationInCurrentOnboardingSessionUseCase2, "getHasUserPinnedLocationInCurrentOnboardingSessionUseCase");
        Intrinsics.checkNotNullParameter(flutterAddressMapper2, "flutterAddressMapper");
        Intrinsics.checkNotNullParameter(nativeAddressMapper2, "nativeAddressMapper");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        Intrinsics.checkNotNullParameter(paymentConfigurationRepository2, "paymentConfigurationRepository");
        Intrinsics.checkNotNullParameter(mutableConfigurationLocalRepository2, "mutableConfigurationLocalRepository");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(mutableLocationConfigurationRepository, "mutableLocationConfigRepository");
        Intrinsics.checkNotNullParameter(mutableConfigurationRemoteRepository2, "mutableConfigurationRemoteRepository");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.application = application2;
        this.getHasUserPinnedLocationInCurrentOnboardingSessionUseCase = getHasUserPinnedLocationInCurrentOnboardingSessionUseCase2;
        this.flutterAddressMapper = flutterAddressMapper2;
        this.nativeAddressMapper = nativeAddressMapper2;
        this.observabilityManager = iObservabilityManager;
        this.talabatExperiment = iTalabatExperiment;
        this.moshi = moshi2;
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
        this.mutableConfigurationLocalRepository = mutableConfigurationLocalRepository2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.mutableLocationConfigRepository = mutableLocationConfigurationRepository;
        this.mutableConfigurationRemoteRepository = mutableConfigurationRemoteRepository2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.customerRepository = DependencyProvider.INSTANCE.provideCustomerRepository(application2);
        CityToOldCityMapper cityToOldCityMapper2 = new CityToOldCityMapper();
        this.cityToOldCityMapper = cityToOldCityMapper2;
        this.countryToOldCountryMapper = new CountryToOldCountryMapper(cityToOldCityMapper2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initialiseCountryPreferences() {
        /*
            r5 = this;
            com.talabat.configuration.MutableLocationConfigurationRepository r0 = r5.mutableLocationConfigRepository
            java.util.List r0 = r0.countries()
            com.talabat.configuration.MutableConfigurationLocalRepository r1 = r5.mutableConfigurationLocalRepository
            com.talabat.configuration.country.Country r1 = r1.selectedCountry()
            int r2 = r1.getCountryId()
            if (r2 <= 0) goto L_0x0037
            java.util.Iterator r0 = r0.iterator()
        L_0x0016:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x008d
            java.lang.Object r2 = r0.next()
            com.talabat.configuration.location.Country r2 = (com.talabat.configuration.location.Country) r2
            com.talabat.configuration.country.Country r3 = r2.getCountry()
            int r3 = r3.getCountryId()
            int r4 = r1.getCountryId()
            if (r3 != r4) goto L_0x0016
            datamodels.mappers.CountryToOldCountryMapper r0 = r5.countryToOldCountryMapper
            datamodels.Country r0 = r0.apply((com.talabat.configuration.location.Country) r2)
            goto L_0x008e
        L_0x0037:
            com.talabat.configuration.MutableLocationConfigurationRepository r2 = r5.mutableLocationConfigRepository
            com.talabat.configuration.location.LocationConfig r2 = r2.config()
            com.talabat.configuration.country.Country r2 = r2.getCountry()
            int r2 = r2.getCountryId()
            if (r2 <= 0) goto L_0x008d
            java.util.Iterator r0 = r0.iterator()
        L_0x004b:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x008d
            java.lang.Object r3 = r0.next()
            com.talabat.configuration.location.Country r3 = (com.talabat.configuration.location.Country) r3
            com.talabat.configuration.country.Country r4 = r3.getCountry()
            int r4 = r4.getCountryId()
            if (r4 != r2) goto L_0x004b
            datamodels.mappers.CountryToOldCountryMapper r0 = r5.countryToOldCountryMapper
            datamodels.Country r0 = r0.apply((com.talabat.configuration.location.Country) r3)
            com.talabat.configuration.MutableConfigurationLocalRepository r2 = r5.mutableConfigurationLocalRepository
            com.talabat.configuration.country.Country r4 = r3.getCountry()
            int r4 = r4.getCountryId()
            r2.setSelectedCountry(r4)
            com.talabat.configuration.country.Country r2 = r3.getCountry()
            java.lang.String r2 = r2.getCountryName()
            com.talabat.helpers.GlobalDataModel.SelectedCountryName = r2
            int r1 = r1.getCountryId()
            java.lang.String r2 = com.talabat.helpers.GlobalDataModel.SelectedCountryName
            java.lang.String r3 = "SelectedCountryName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r5.saveSelectedCountry(r1, r2)
            goto L_0x008e
        L_0x008d:
            r0 = 0
        L_0x008e:
            if (r0 == 0) goto L_0x009d
            buisnessmodels.TalabatFormatter r1 = buisnessmodels.TalabatFormatter.getInstance()
            java.lang.String r2 = r0.currencySymbol
            int r3 = r0.numOfDecimalPlaces
            int r0 = r0.f13845id
            r1.setFormat(r2, r3, r0)
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.flutter.channels.impl.data.address.AddressInfoChannelCallbackImpl.initialiseCountryPreferences():void");
    }

    private final void observeChannelBehaviour(String str, String str2, int i11) {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        Pair[] pairArr = new Pair[2];
        if (str2 == null) {
            str2 = "N/A";
        }
        pairArr[0] = TuplesKt.to("activity_name", str2);
        pairArr[1] = TuplesKt.to("instance_id", String.valueOf(i11));
        iObservabilityManager.trackUnExpectedScenario(str, MapsKt__MapsKt.mapOf(pairArr));
    }

    private final Map<String, Object> readGuestAddress(SharedPreferences sharedPreferences, String str) {
        Object obj;
        try {
            Gson gson = UniversalGson.getGson();
            String string = sharedPreferences.getString(str, (String) null);
            Class cls = QuickOrderInfo.class;
            if (!(gson instanceof Gson)) {
                obj = gson.fromJson(string, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson, string, cls);
            }
            QuickOrderInfo quickOrderInfo = (QuickOrderInfo) obj;
            if (quickOrderInfo == null) {
                return null;
            }
            FlutterAddressMapper flutterAddressMapper2 = this.flutterAddressMapper;
            Address address = quickOrderInfo.address;
            Intrinsics.checkNotNullExpressionValue(address, "quickOrderInfo.address");
            Map<String, Object> map = flutterAddressMapper2.map(address);
            Map createMapBuilder = MapsKt__MapsJVMKt.createMapBuilder();
            createMapBuilder.put("firstName", quickOrderInfo.firstName);
            createMapBuilder.put("lastName", quickOrderInfo.lastName);
            createMapBuilder.put("address", map);
            return MapsKt__MapsJVMKt.build(createMapBuilder);
        } catch (JsonSyntaxException e11) {
            String message = e11.getMessage();
            if (message == null) {
                message = "Fetching address info failed when is guest user";
            }
            observeChannelBehaviour(message, "AddressInfoChannelCallbackImpl", System.identityHashCode(this));
            return null;
        }
    }

    private final void saveQuickOrderAddressData(QuickOrderInfo quickOrderInfo) {
        String str;
        SharedPreferences sharedPreferences = this.application.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "application\n            …ODE_PRIVATE\n            )");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Gson gson = UniversalGson.getGson();
        QuickOrderInfo copyForSaving = quickOrderInfo.copyForSaving();
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) copyForSaving);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) copyForSaving);
        }
        edit.putString(String.valueOf(GlobalDataModel.SelectedAreaId), str);
        edit.putString(String.valueOf(quickOrderInfo.address.areaId), str);
        edit.putString(GlobalConstants.PrefsConstants.FALLBACK_GUEST_ADDRESS, str);
        edit.apply();
    }

    private final void saveQuickOrderUserData(QuickOrderUserInfo quickOrderUserInfo) {
        String str;
        String str2;
        SharedPreferences sharedPreferences = this.application.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "application\n            …ODE_PRIVATE\n            )");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Gson gson = UniversalGson.getGson();
        String str3 = GlobalDataModel.quickOrderUserId;
        boolean z11 = gson instanceof Gson;
        if (!z11) {
            str = gson.toJson((Object) quickOrderUserInfo);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) quickOrderUserInfo);
        }
        edit.putString(str3, str);
        String str4 = "Sales_Froce" + GlobalDataModel.SelectedCountryId;
        if (!z11) {
            str2 = gson.toJson((Object) quickOrderUserInfo);
        } else {
            str2 = GsonInstrumentation.toJson(gson, (Object) quickOrderUserInfo);
        }
        edit.putString(str4, str2);
        edit.putInt("lastquickordercountryID", GlobalDataModel.SelectedCountryId);
        edit.apply();
    }

    private final void saveSelectedCountry(int i11, String str) {
        GlobalDataModel.SelectedAreaId = 0;
        GlobalDataModel.SelectedAreaName = "";
        GlobalDataModel.SelectedCityId = 0;
        GlobalDataModel.SelectedCityName = "";
        GlobalDataModel.launchRxNextEventOnCountryId(i11);
        GlobalDataModel.SelectedCountryName = str;
        SharedPreferences.Editor edit = this.application.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.putInt(GlobalConstants.PrefsConstants.COUNTRY_ID, i11);
        edit.putString(GlobalConstants.PrefsConstants.COUNTRY_NAME, str);
        edit.putString(GlobalConstants.PrefsConstants.CITY_NAME, "");
        edit.putString(GlobalConstants.PrefsConstants.AREA_NAME, GlobalDataModel.SelectedAreaName);
        edit.putInt(GlobalConstants.PrefsConstants.CITY_ID, GlobalDataModel.SelectedCityId);
        edit.putInt(GlobalConstants.PrefsConstants.AREA_ID, GlobalDataModel.SelectedAreaId);
        edit.apply();
    }

    @NotNull
    public List<Map<String, Object>> getAddressList() {
        ArrayList<Address> customerAddress = this.customerRepository.getCustomerAddress();
        FlutterAddressMapper flutterAddressMapper2 = this.flutterAddressMapper;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(customerAddress, 10));
        for (Address map : customerAddress) {
            arrayList.add(flutterAddressMapper2.map(map));
        }
        return arrayList;
    }

    @Nullable
    public Map<String, Object> getGuestAddressInfo(int i11) {
        SharedPreferences sharedPreferences = this.application.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "application\n            …ODE_PRIVATE\n            )");
        if (sharedPreferences.contains(String.valueOf(i11))) {
            return readGuestAddress(sharedPreferences, String.valueOf(i11));
        }
        if (sharedPreferences.contains(GlobalConstants.PrefsConstants.FALLBACK_GUEST_ADDRESS)) {
            return readGuestAddress(sharedPreferences, GlobalConstants.PrefsConstants.FALLBACK_GUEST_ADDRESS);
        }
        return null;
    }

    public boolean getSkipAddressMap() {
        return this.getHasUserPinnedLocationInCurrentOnboardingSessionUseCase.invoke() != null;
    }

    public void onAttach(@Nullable String str, int i11) {
        observeChannelBehaviour("address_info_method_channel_attached", str, i11);
    }

    public void onDetach(@Nullable String str, int i11) {
        observeChannelBehaviour("address_info_method_channel_detached", str, i11);
    }

    public void setAddressList(@NotNull List<?> list) {
        Intrinsics.checkNotNullParameter(list, "addresses");
        Iterable iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Object next : iterable) {
            NativeAddressMapper nativeAddressMapper2 = this.nativeAddressMapper;
            if (next != null) {
                arrayList.add(nativeAddressMapper2.map((Map) next));
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            }
        }
        this.customerRepository.setCustomerAddresses(arrayList);
        AddressesDependencyProvider.INSTANCE.provideCustomerAddressesRepository(this.talabatFeatureFlag).refreshCacheAddresses(arrayList);
    }

    public void setGuestAddressInfo(int i11, @NotNull String str, @NotNull String str2, @NotNull Map<?, ?> map) {
        Intrinsics.checkNotNullParameter(str, "firstName");
        Intrinsics.checkNotNullParameter(str2, "lastName");
        Intrinsics.checkNotNullParameter(map, "addressMap");
        Address map2 = this.flutterAddressMapper.map(map);
        QuickOrderInfo quickOrderInfo = new QuickOrderInfo();
        quickOrderInfo.firstName = str;
        quickOrderInfo.lastName = str2;
        quickOrderInfo.address = map2;
        saveQuickOrderAddressData(quickOrderInfo);
        QuickOrderUserInfo quickOrderUserInfo = new QuickOrderUserInfo();
        quickOrderUserInfo.firstName = str;
        quickOrderUserInfo.lastName = str2;
        quickOrderUserInfo.mobileNumber = map2.mobileNumber;
        quickOrderUserInfo.phoneNumber = map2.phoneNumber;
        quickOrderUserInfo.mobileNumberCountryCode = map2.mobilNumberCountryCode;
        saveQuickOrderUserData(quickOrderUserInfo);
    }

    public void setSelectedAddress(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "addressId");
        this.customerRepository.setSelectedCustomerAddress(str, i11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00d8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object setSelectedCountry(int r17, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.talabat.core.flutter.channels.impl.data.address.AddressInfoChannelCallbackImpl$setSelectedCountry$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.talabat.core.flutter.channels.impl.data.address.AddressInfoChannelCallbackImpl$setSelectedCountry$1 r2 = (com.talabat.core.flutter.channels.impl.data.address.AddressInfoChannelCallbackImpl$setSelectedCountry$1) r2
            int r3 = r2.f55910k
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f55910k = r3
            goto L_0x001c
        L_0x0017:
            com.talabat.core.flutter.channels.impl.data.address.AddressInfoChannelCallbackImpl$setSelectedCountry$1 r2 = new com.talabat.core.flutter.channels.impl.data.address.AddressInfoChannelCallbackImpl$setSelectedCountry$1
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f55908i
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.f55910k
            r5 = 1
            if (r4 == 0) goto L_0x003a
            if (r4 != r5) goto L_0x0032
            java.lang.Object r2 = r2.f55907h
            com.talabat.core.flutter.channels.impl.data.address.AddressInfoChannelCallbackImpl r2 = (com.talabat.core.flutter.channels.impl.data.address.AddressInfoChannelCallbackImpl) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00da
        L_0x0032:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r1)
            android.app.Application r1 = r0.application
            com.talabat.core.di.ApiContainer r1 = (com.talabat.core.di.ApiContainer) r1
            java.lang.Class<com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi> r4 = com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi.class
            java.lang.Object r1 = r1.getFeature(r4)
            com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi r1 = (com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi) r1
            com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository r13 = r1.getSubscriptionsCustomerRepository()
            com.talabat.feature.subscriptions.domain.usecase.GetProCentralizationStatusUseCase r14 = r1.getGetProCentralizationStatusUseCase()
            com.talabat.userandlocation.choosecountry.di.module.DomainModule r6 = com.talabat.userandlocation.choosecountry.di.module.DomainModule.INSTANCE
            android.app.Application r7 = r0.application
            com.squareup.moshi.Moshi r8 = r0.moshi
            com.talabat.configuration.ConfigurationLocalRepository r9 = r0.configurationLocalRepository
            com.talabat.configuration.MutableConfigurationRemoteRepository r11 = r0.mutableConfigurationRemoteRepository
            com.talabat.configuration.payment.PaymentConfigurationRepository r12 = r0.paymentConfigurationRepository
            com.talabat.core.featureflag.domain.ITalabatFeatureFlag r15 = r0.talabatFeatureFlag
            com.talabat.configuration.MutableLocationConfigurationRepository r10 = r0.mutableLocationConfigRepository
            kotlin.reflect.KFunction r1 = r6.getAppInfoDelegate(r7, r8, r9, r10, r11, r12, r13, r14, r15)
            com.talabat.configuration.MutableLocationConfigurationRepository r4 = r0.mutableLocationConfigRepository
            java.util.List r4 = r4.countries()
            r6 = r4
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            r6 = r6 ^ r5
            if (r6 == 0) goto L_0x00b6
            java.util.Iterator r4 = r4.iterator()
        L_0x0079:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x00b6
            java.lang.Object r6 = r4.next()
            com.talabat.configuration.location.Country r6 = (com.talabat.configuration.location.Country) r6
            com.talabat.configuration.country.Country r7 = r6.getCountry()
            int r7 = r7.getCountryId()
            r8 = r17
            if (r7 != r8) goto L_0x0079
            datamodels.mappers.CountryToOldCountryMapper r4 = r0.countryToOldCountryMapper
            datamodels.Country r4 = r4.apply((com.talabat.configuration.location.Country) r6)
            com.talabat.configuration.MutableConfigurationLocalRepository r7 = r0.mutableConfigurationLocalRepository
            int r9 = r4.f13845id
            r7.setSelectedCountry(r9)
            java.lang.String r7 = r4.f13846name
            com.talabat.helpers.GlobalDataModel.SelectedCountryName = r7
            com.talabat.configuration.country.Country r7 = r6.getCountry()
            int r7 = r7.getCountryId()
            com.talabat.configuration.country.Country r6 = r6.getCountry()
            java.lang.String r6 = r6.getCountryName()
            r0.saveSelectedCountry(r7, r6)
            goto L_0x00b9
        L_0x00b6:
            r8 = r17
            r4 = 0
        L_0x00b9:
            if (r4 == 0) goto L_0x00c8
            buisnessmodels.TalabatFormatter r6 = buisnessmodels.TalabatFormatter.getInstance()
            java.lang.String r7 = r4.currencySymbol
            int r9 = r4.numOfDecimalPlaces
            int r4 = r4.f13845id
            r6.setFormat(r7, r9, r4)
        L_0x00c8:
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r17)
            r2.f55907h = r0
            r2.f55910k = r5
            java.lang.Object r1 = r1.invoke(r4, r2)
            if (r1 != r3) goto L_0x00d9
            return r3
        L_0x00d9:
            r2 = r0
        L_0x00da:
            r2.initialiseCountryPreferences()
            buisnessmodels.Customer r1 = buisnessmodels.Customer.getInstance()
            if (r1 == 0) goto L_0x00e6
            r1.deselectCustomerAddress()
        L_0x00e6:
            com.talabat.configuration.MutableConfigurationLocalRepository r1 = r2.mutableConfigurationLocalRepository
            com.talabat.configuration.country.Country r1 = r1.selectedCountry()
            com.talabat.core.fwf.data.FunWithFlags.updateSelectedCountry(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.flutter.channels.impl.data.address.AddressInfoChannelCallbackImpl.setSelectedCountry(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void setSelectedUnsavedAddress(@NotNull Map<?, ?> map) {
        String str;
        Intrinsics.checkNotNullParameter(map, "addressMap");
        Address mapUnsavedAddress = this.flutterAddressMapper.mapUnsavedAddress(map);
        GlobalDataModel.SelectedAreaId = mapUnsavedAddress.areaId;
        GlobalDataModel.SelectedAreaName = mapUnsavedAddress.areaName;
        int i11 = mapUnsavedAddress.cityId;
        GlobalDataModel.SelectedCityId = i11;
        GlobalDataModel.SelectedCityName = TalabatUtils.getCityName(i11, this.mutableConfigurationLocalRepository, this.mutableLocationConfigRepository);
        GlobalDataModel.HOME_SCREEN_MAP.MAP_FRST_UPDATE_OPTION = 0;
        HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
        homeMapTemp.setHomeMapLatLngFromFlutter(mapUnsavedAddress.latitude, mapUnsavedAddress.longitude, this.application);
        homeMapTemp.setTempAreaId(mapUnsavedAddress.areaId);
        String str2 = mapUnsavedAddress.street;
        String str3 = "";
        if (str2 == null) {
            str2 = str3;
        }
        homeMapTemp.setStreetName(str2);
        homeMapTemp.settempAddress(mapUnsavedAddress);
        SharedPreferences sharedPreferences = this.application.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "application\n            …ODE_PRIVATE\n            )");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(GlobalConstants.PrefsConstants.AREA_ID, GlobalDataModel.SelectedAreaId);
        edit.putString(GlobalConstants.PrefsConstants.AREA_NAME, GlobalDataModel.SelectedAreaName);
        edit.putInt(GlobalConstants.PrefsConstants.CITY_ID, GlobalDataModel.SelectedCityId);
        double d11 = mapUnsavedAddress.latitude;
        double d12 = mapUnsavedAddress.longitude;
        edit.putString(GlobalConstants.PrefsConstants.HOME_MAP_PREF_LOCATION, d11 + "," + d12);
        edit.putInt(GlobalConstants.PrefsConstants.AREA_ID, mapUnsavedAddress.areaId);
        String str4 = mapUnsavedAddress.street;
        if (str4 != null) {
            str3 = str4;
        }
        edit.putString(GlobalConstants.PrefsConstants.HOME_MAP_PREF_STREET_NAME, str3);
        Gson gson = UniversalGson.getGson();
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) mapUnsavedAddress);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) mapUnsavedAddress);
        }
        edit.putString(GlobalConstants.PrefsConstants.HOME_MAP_PREF_ADDRESS, str);
        edit.apply();
        Customer.getInstance().deselectCustomerAddress(this.application);
        homeMapTemp.setHomeMapRedirect(true, this.application);
        this.talabatExperiment.setAttribute(FWFAttributes.AREA_ID, String.valueOf(mapUnsavedAddress.areaId));
    }
}
