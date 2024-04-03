package com.talabat.fluttercore.domain.entities;

import android.content.Context;
import com.talabat.application.device.id.domain.DeviceIdProvider;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import com.talabat.card_tokenization.CardTokenizationPlugin;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.WalletConfig;
import com.talabat.configuration.tcs.TermsAndConditionsConfig;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.data.googleclientid.GoogleClientIdProvider;
import com.talabat.fluttercore.data.FlutterConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import datamodels.Country;
import datamodels.Token;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.gtm.datalayerLogger.DatalayerModel;
import tracking.perseus.TalabatPerseus;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001aP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007\u001a\u0018\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017*\u00020\u0003¨\u0006\u0019"}, d2 = {"getEnvironment", "", "getFlutterConfig", "Lcom/talabat/fluttercore/domain/entities/FlutterConfig;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "deviceIdProvider", "Lcom/talabat/application/device/id/domain/DeviceIdProvider;", "googleClientIdProvider", "Lcom/talabat/data/googleclientid/GoogleClientIdProvider;", "walletConfig", "Lcom/talabat/configuration/payment/WalletConfig;", "termsAndConditionsConfig", "Lcom/talabat/configuration/tcs/TermsAndConditionsConfig;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "datalayerModel", "Ltracking/gtm/datalayerLogger/DatalayerModel;", "toMap", "", "", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FlutterConfigKt {
    @NotNull
    public static final String getEnvironment() {
        return FlutterConstants.Companion.buildType("release");
    }

    @NotNull
    @Deprecated(message = "Don't extend. Use *Config classes from :core:configuration:remote:domain instead")
    public static final FlutterConfig getFlutterConfig(@NotNull AppVersionProvider appVersionProvider, @NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull LocationConfigurationRepository locationConfigurationRepository, @NotNull DeviceIdProvider deviceIdProvider, @NotNull GoogleClientIdProvider googleClientIdProvider, @NotNull WalletConfig walletConfig, @NotNull TermsAndConditionsConfig termsAndConditionsConfig, @NotNull IObservabilityManager iObservabilityManager, @NotNull DatalayerModel datalayerModel) {
        FlutterCountryInfo flutterCountryInfo;
        String str;
        ConfigurationLocalRepository configurationLocalRepository2 = configurationLocalRepository;
        LocationConfigurationRepository locationConfigurationRepository2 = locationConfigurationRepository;
        IObservabilityManager iObservabilityManager2 = iObservabilityManager;
        Intrinsics.checkNotNullParameter(appVersionProvider, "appVersionProvider");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        Intrinsics.checkNotNullParameter(deviceIdProvider, "deviceIdProvider");
        Intrinsics.checkNotNullParameter(googleClientIdProvider, "googleClientIdProvider");
        Intrinsics.checkNotNullParameter(walletConfig, "walletConfig");
        Intrinsics.checkNotNullParameter(termsAndConditionsConfig, "termsAndConditionsConfig");
        Intrinsics.checkNotNullParameter(iObservabilityManager2, "observabilityManager");
        Intrinsics.checkNotNullParameter(datalayerModel, "datalayerModel");
        Country selectedCountry = TalabatUtils.getSelectedCountry(configurationLocalRepository2, locationConfigurationRepository2, iObservabilityManager2);
        if (selectedCountry != null) {
            int i11 = selectedCountry.f13845id;
            String str2 = selectedCountry.currencySymbol;
            Intrinsics.checkNotNullExpressionValue(str2, "country.currencySymbol");
            flutterCountryInfo = new FlutterCountryInfo(i11, str2, selectedCountry.numOfDecimalPlaces, selectedCountry.code);
        } else {
            flutterCountryInfo = null;
        }
        FlutterCustomerInfo flutterCustomerInfoFromGlobalDataModel = FlutterCustomerInfoKt.flutterCustomerInfoFromGlobalDataModel();
        FlutterConstants.Companion companion = FlutterConstants.Companion;
        String buildType = companion.buildType("release");
        Token token = GlobalDataModel.token;
        if (token != null) {
            str = token.access_token;
        } else {
            str = null;
        }
        String str3 = GlobalDataModel.SelectedLanguage;
        Intrinsics.checkNotNullExpressionValue(str3, "SelectedLanguage");
        String selectedLanguage = companion.selectedLanguage(str3);
        double latitude = GlobalDataModel.RECENT_LATLONG.getLatitude();
        double longitude = GlobalDataModel.RECENT_LATLONG.getLongitude();
        TalabatPerseus.Companion companion2 = TalabatPerseus.Companion;
        String myClientId$default = TalabatPerseus.Companion.getMyClientId$default(companion2, (Context) null, 1, (Object) null);
        String mySessionId = companion2.getMySessionId();
        String hitMatchId = companion2.getHitMatchId();
        String str4 = GlobalDataModel.SelectedLanguage;
        Intrinsics.checkNotNullExpressionValue(str4, "SelectedLanguage");
        String selectedLanguageName = companion.selectedLanguageName(str4);
        String str5 = GlobalDataModel.SelectedLanguage;
        Intrinsics.checkNotNullExpressionValue(str5, "SelectedLanguage");
        boolean isLanguageRTL = companion.isLanguageRTL(str5);
        String str6 = GlobalDataModel.SelectedLanguage;
        Intrinsics.checkNotNullExpressionValue(str6, "SelectedLanguage");
        String selectedLanguageCode = companion.selectedLanguageCode(str6);
        FlutterArea flutterArea = new FlutterArea(longitude, latitude, GlobalDataModel.SelectedAreaId, GlobalDataModel.SelectedAreaName, GlobalDataModel.SelectedCityId, GlobalDataModel.SelectedCityName);
        String id2 = deviceIdProvider.getId();
        FlutterLanguage flutterLanguage = new FlutterLanguage(selectedLanguageName, selectedLanguageCode, isLanguageRTL, selectedLanguage);
        FlutterAppInfo flutterAppInfo = new FlutterAppInfo(walletConfig.isAmexAvailable(), termsAndConditionsConfig.getTermsAndConditionsUrl());
        String appVersion = appVersionProvider.appVersion();
        String googleClientId = googleClientIdProvider.getGoogleClientId();
        String nullCountryTraceId = iObservabilityManager.getNullCountryTraceId();
        if (nullCountryTraceId == null) {
            nullCountryTraceId = "";
        }
        return new FlutterConfig(buildType, str, selectedLanguage, flutterCustomerInfoFromGlobalDataModel, flutterCountryInfo, flutterArea, myClientId$default, mySessionId, hitMatchId, flutterLanguage, flutterAppInfo, id2, appVersion, googleClientId, nullCountryTraceId, datalayerModel.isLoggingEnabled(), datalayerModel.getLoggingKey());
    }

    @NotNull
    public static final Map<String, Object> toMap(@NotNull FlutterConfig flutterConfig) {
        Map<String, Object> map;
        Map<String, Object> map2;
        Map<String, Object> map3;
        Intrinsics.checkNotNullParameter(flutterConfig, "<this>");
        Pair[] pairArr = new Pair[16];
        FlutterCustomerInfo customer = flutterConfig.getCustomer();
        Map<String, Object> map4 = null;
        if (customer != null) {
            map = FlutterCustomerInfoKt.toMap(customer);
        } else {
            map = null;
        }
        pairArr[0] = TuplesKt.to("customer", map);
        FlutterCountryInfo country = flutterConfig.getCountry();
        if (country != null) {
            map2 = FlutterCountryInfoKt.toMap(country);
        } else {
            map2 = null;
        }
        pairArr[1] = TuplesKt.to("country", map2);
        pairArr[2] = TuplesKt.to(CardTokenizationPlugin.ARG_ENV_KEY, flutterConfig.getEnv());
        pairArr[3] = TuplesKt.to(LegacyTokenLocalDataSourceImpl.KEY, flutterConfig.getToken());
        pairArr[4] = TuplesKt.to("lang", flutterConfig.getLang());
        FlutterArea selectedArea = flutterConfig.getSelectedArea();
        if (selectedArea != null) {
            map3 = FlutterAreaKt.toMap(selectedArea);
        } else {
            map3 = null;
        }
        pairArr[5] = TuplesKt.to("selectedArea", map3);
        pairArr[6] = TuplesKt.to("perseusClientId", flutterConfig.getPerseusClientId());
        pairArr[7] = TuplesKt.to("persuesSessionId", flutterConfig.getPersuesSessionId());
        pairArr[8] = TuplesKt.to("persuesHitMatchId", flutterConfig.getPersuesHitMatchId());
        FlutterLanguage languageModel = flutterConfig.getLanguageModel();
        if (languageModel != null) {
            map4 = FlutterLanguageKt.toMap(languageModel);
        }
        pairArr[9] = TuplesKt.to("languageModel", map4);
        pairArr[10] = TuplesKt.to("appInfo", FlutterAppInfoKt.toMap(flutterConfig.getAppInfo()));
        String deviceID = flutterConfig.getDeviceID();
        if (deviceID == null) {
            deviceID = "";
        }
        pairArr[11] = TuplesKt.to("deviceID", deviceID);
        pairArr[12] = TuplesKt.to("deviceVersion", flutterConfig.getDeviceVersion());
        pairArr[13] = TuplesKt.to("googleClientId", flutterConfig.getGoogleClientId());
        pairArr[14] = TuplesKt.to("isDatalayerEnabled", Boolean.valueOf(flutterConfig.isDatalayerEnabled()));
        pairArr[15] = TuplesKt.to("datalayerKey", flutterConfig.getDatalayerKey());
        return MapsKt__MapsKt.mapOf(pairArr);
    }
}
