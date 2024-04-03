package com.talabat.helpers;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.provider.Settings;
import android.text.Html;
import android.text.Spanned;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Patterns;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import buisnessmodels.Customer;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.helpers.GlobalConstants;
import com.talabat.observability.ObservabilityManager;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import com.talabat.talabatcore.logger.LogManager;
import com.visa.checkout.Profile;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import datamodels.City;
import datamodels.Country;
import datamodels.mappers.CityToOldCityMapper;
import datamodels.mappers.CountryToOldCountryMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;

public class TalabatUtils {
    private static void BuildConfigurationsWithLanguage(Context context, MutableConfigurationLocalRepository mutableConfigurationLocalRepository, Configuration configuration, String str) {
        configuration.locale = getLocale(mutableConfigurationLocalRepository, str);
        int i11 = Build.VERSION.SDK_INT;
        configuration.setLayoutDirection(getLocale(mutableConfigurationLocalRepository, str));
        if (i11 > 23) {
            configuration.setLocales(new LocaleList(new Locale[]{getLocale(mutableConfigurationLocalRepository, str)}));
            context.createConfigurationContext(configuration);
        }
    }

    public static void changeLocale(Context context, String str) {
        MutableConfigurationLocalRepository mutableRepository = ((MutableConfigurationLocalCoreLibApi) ((ApiContainer) ((Activity) context).getApplication()).getFeature(MutableConfigurationLocalCoreLibApi.class)).getMutableRepository();
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        BuildConfigurationsWithLanguage(context, mutableRepository, configuration, str);
        resources.updateConfiguration(configuration, displayMetrics);
        Customer.setSavedLanguage(context, str);
    }

    private static String countriesToString(Country[] countryArr) {
        if (countryArr == null) {
            return "null";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        for (Country country : countryArr) {
            sb2.append("Country{");
            sb2.append("id=");
            sb2.append(country.f13845id);
            sb2.append(",");
            sb2.append("name=");
            sb2.append(country.f13846name);
            sb2.append("}");
            sb2.append(",");
        }
        sb2.append(AbstractJsonLexerKt.END_LIST);
        return sb2.toString();
    }

    public static Locale createSelectedLanguageLocale(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 93023368:
                if (str.equals(GlobalConstants.ARABIC)) {
                    c11 = 0;
                    break;
                }
                break;
            case 102347650:
                if (str.equals(GlobalConstants.KURDISH_BADINI)) {
                    c11 = 1;
                    break;
                }
                break;
            case 102348191:
                if (str.equals(GlobalConstants.KURDISH_SORANI)) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return new Locale(GlobalConstants.ARABIC.split(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE)[0], GlobalConstants.ARABIC.split(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE)[1]);
            case 1:
                return new Locale(GlobalConstants.KURDISH_BADINI_LOCAL.split(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE)[0], GlobalConstants.KURDISH_BADINI_LOCAL.split(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE)[1]);
            case 2:
                return new Locale(GlobalConstants.KURDISH_SORANI_LOCAL);
            default:
                return new Locale("en-US".split(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE)[0], "en-US".split(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE)[1]);
        }
    }

    public static String decodeFromBase64(String str) {
        try {
            return new String(Base64.decode(str, 0), "UTF-8");
        } catch (Exception unused) {
            return null;
        }
    }

    public static String encodeToBase64(String str) {
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Spanned fromHtml(String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Html.fromHtml(str, 0);
        }
        return Html.fromHtml(str);
    }

    public static String getChoicesString(List<ChoiceSection> list) {
        StringBuilder sb2 = new StringBuilder();
        if (list.isEmpty()) {
            return "";
        }
        for (ChoiceSection choiceSection : list) {
            Iterator<ChoiceItem> it = choiceSection.itemChoices.iterator();
            while (it.hasNext()) {
                ChoiceItem next = it.next();
                if (sb2.length() > 0) {
                    sb2.append(",");
                }
                sb2.append(next.f13840name);
            }
        }
        return sb2.toString();
    }

    public static String getCityName(int i11, ConfigurationLocalRepository configurationLocalRepository, LocationConfigurationRepository locationConfigurationRepository) {
        Country selectedCountry = getSelectedCountry(configurationLocalRepository, locationConfigurationRepository);
        if (selectedCountry == null) {
            return "";
        }
        for (City city : selectedCountry.cities) {
            if (i11 == city.f13843id) {
                return city.f13844name;
            }
        }
        return "";
    }

    public static String getCleanLanguage(String str) {
        if (str.startsWith(GlobalConstants.ARABIC.split(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE)[0])) {
            return GlobalConstants.ARABIC;
        }
        if (str.startsWith(GlobalConstants.KURDISH_SORANI.split(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE)[0])) {
            return GlobalConstants.KURDISH_SORANI;
        }
        if (str.startsWith(GlobalConstants.KURDISH_BADINI.split(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE)[0])) {
            return GlobalConstants.KURDISH_BADINI;
        }
        return "en-US";
    }

    @Nullable
    public static Country getDatamodelsSelectedCountry(@NonNull com.talabat.configuration.country.Country country, LocationConfigurationRepository locationConfigurationRepository) {
        if (country == com.talabat.configuration.country.Country.UNDEFINED) {
            return null;
        }
        List<com.talabat.configuration.location.Country> countries = locationConfigurationRepository.countries();
        CountryToOldCountryMapper countryToOldCountryMapper = new CountryToOldCountryMapper(new CityToOldCityMapper());
        for (com.talabat.configuration.location.Country next : countries) {
            if (next.getCountry().getCountryId() == country.getCountryId()) {
                return countryToOldCountryMapper.apply(next);
            }
        }
        return null;
    }

    public static String getDeviceIDFromSharedPref(Context context) {
        return context.getSharedPreferences(GlobalConstants.PrefsWithBackupConstants.NAME, 0).getString(GlobalConstants.PrefsWithBackupConstants.DEVICE_ID, (String) null);
    }

    public static String getDeviceId(Context context) {
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (string != null) {
                return string;
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static int getGlobalCountryFromGeoCode(String str) {
        if (isNullOrEmpty(str)) {
            return 0;
        }
        if (str.equals(Profile.Country.KW)) {
            return com.talabat.configuration.country.Country.KUWAIT.getCountryId();
        }
        if (str.equals(Profile.Country.SA)) {
            return com.talabat.configuration.country.Country.KSA.getCountryId();
        }
        if (str.equals("BH")) {
            return com.talabat.configuration.country.Country.BAHRAIN.getCountryId();
        }
        if (str.equals(Profile.Country.AE)) {
            return com.talabat.configuration.country.Country.UAE.getCountryId();
        }
        if (str.equals("OM")) {
            return com.talabat.configuration.country.Country.OMAN.getCountryId();
        }
        if (str.equals(Profile.Country.QA)) {
            return com.talabat.configuration.country.Country.QATAR.getCountryId();
        }
        if (str.equals(ExpandedProductParsedResult.POUND)) {
            return com.talabat.configuration.country.Country.LEBANON.getCountryId();
        }
        if (str.equals("JO")) {
            return com.talabat.configuration.country.Country.JORDAN.getCountryId();
        }
        if (str.equals("EG")) {
            return com.talabat.configuration.country.Country.EGYPT.getCountryId();
        }
        if (str.equals("IQ")) {
            return com.talabat.configuration.country.Country.IRAQ.getCountryId();
        }
        return 0;
    }

    public static String getLastDigitNumberValidate(String str) {
        if (str.length() > 4) {
            return str.substring(str.length() - 4);
        }
        return str;
    }

    @NotNull
    private static Locale getLocale(MutableConfigurationLocalRepository mutableConfigurationLocalRepository, String str) {
        mutableConfigurationLocalRepository.setSelectedLanguage(str);
        return createSelectedLanguageLocale(str);
    }

    public static int getNumberFromString(String str) {
        try {
            return Integer.parseInt(str.trim());
        } catch (NullPointerException | NumberFormatException unused) {
            return 0;
        }
    }

    public static float getPriceForPercentageDiscount(float f11, float f12) {
        return (f11 * f12) / 100.0f;
    }

    @Deprecated
    public static Country getSelectedCountry(ConfigurationLocalRepository configurationLocalRepository, LocationConfigurationRepository locationConfigurationRepository) {
        return getSelectedCountry(configurationLocalRepository, locationConfigurationRepository, (IObservabilityManager) null);
    }

    public static String getSelectedCountryIso3166() {
        switch (GlobalDataModel.SelectedCountryId) {
            case 2:
                return Profile.Country.SA;
            case 3:
                return "BH";
            case 4:
                return Profile.Country.AE;
            case 5:
                return "OM";
            case 6:
                return Profile.Country.QA;
            case 7:
                return ExpandedProductParsedResult.POUND;
            case 8:
                return "JO";
            case 9:
                return "EG";
            case 10:
                return "IQ";
            default:
                return Profile.Country.KW;
        }
    }

    public static String getSixBinNumber(String str) {
        if (isNullOrEmpty(str) || str.length() <= 6) {
            return "";
        }
        return str.substring(0, 6);
    }

    public static String getTheFirstDeviceID(Context context) {
        String deviceIDFromSharedPref = getDeviceIDFromSharedPref(context);
        if (isNullOrEmpty(deviceIDFromSharedPref)) {
            deviceIDFromSharedPref = getDeviceId(context);
            if (isNullOrEmpty(deviceIDFromSharedPref)) {
                deviceIDFromSharedPref = UUID.randomUUID().toString();
            }
            saveDeviceIDToSharedPref(context, deviceIDFromSharedPref);
        }
        return deviceIDFromSharedPref;
    }

    public static boolean isAddressBlockEnabledCountry() {
        if (GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.KUWAIT.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.BAHRAIN.getCountryId()) {
            return true;
        }
        return false;
    }

    public static boolean isArabic() {
        return GlobalDataModel.SelectedLanguage.equals(GlobalConstants.ARABIC);
    }

    public static boolean isCountryCodeVerificationEnabledCountry() {
        if (GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.KSA.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.JORDAN.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.KUWAIT.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.OMAN.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.BAHRAIN.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.UAE.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.EGYPT.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.QATAR.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.IRAQ.getCountryId()) {
            return true;
        }
        return false;
    }

    public static boolean isDrawPolygonCountry() {
        if (GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.KUWAIT.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.BAHRAIN.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.QATAR.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.UAE.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.OMAN.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.JORDAN.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.EGYPT.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.KSA.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.IRAQ.getCountryId()) {
            return true;
        }
        return false;
    }

    public static boolean isEnglish() {
        return GlobalDataModel.SelectedLanguage.equals("en-US");
    }

    public static boolean isInterantionalCountryCodeVerificationEnabledCountry(ConfigurationLocalRepository configurationLocalRepository, LocationConfigurationRepository locationConfigurationRepository) {
        Country selectedCountry = getSelectedCountry(configurationLocalRepository, locationConfigurationRepository);
        if (GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.UAE.getCountryId()) {
            return true;
        }
        if ((GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.KSA.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.JORDAN.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.KUWAIT.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.OMAN.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.BAHRAIN.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.EGYPT.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.IRAQ.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.QATAR.getCountryId()) && selectedCountry != null && selectedCountry.supportsInternalization) {
            return true;
        }
        return false;
    }

    public static boolean isKurdish() {
        if (GlobalDataModel.SelectedLanguage.equals(GlobalConstants.KURDISH_BADINI) || GlobalDataModel.SelectedLanguage.equals(GlobalConstants.KURDISH_SORANI)) {
            return true;
        }
        return false;
    }

    public static boolean isMapPackageEnabledCountry(ConfigurationLocalRepository configurationLocalRepository, LocationConfigurationRepository locationConfigurationRepository) {
        Country selectedCountry = getSelectedCountry(configurationLocalRepository, locationConfigurationRepository);
        if (GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.KUWAIT.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.BAHRAIN.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.QATAR.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.UAE.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.OMAN.getCountryId()) {
            return true;
        }
        if (GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.KSA.getCountryId() && selectedCountry != null && selectedCountry.isMapEnabledCountry) {
            return true;
        }
        if ((GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.JORDAN.getCountryId() && selectedCountry != null && selectedCountry.isMapEnabledCountry) || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.EGYPT.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.IRAQ.getCountryId()) {
            return true;
        }
        return false;
    }

    public static boolean isMcdBlockMenuEnabledCountry() {
        if (GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.BAHRAIN.getCountryId()) {
            return true;
        }
        return false;
    }

    public static boolean isMcdInforMapEnabledCountry() {
        if (GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.UAE.getCountryId()) {
            return true;
        }
        return false;
    }

    public static boolean isMcdLatLngEnabledCountry() {
        if (GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.KSA.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.JORDAN.getCountryId()) {
            return true;
        }
        return false;
    }

    public static boolean isNotLowerThanLollipop() {
        return true;
    }

    public static boolean isNullOrEmpty(String str) {
        if (str == null) {
            return true;
        }
        return str.trim().equals("");
    }

    public static boolean isNullOrEmptyLatLng(double d11, double d12) {
        return d11 <= 0.0d || d12 <= 0.0d;
    }

    public static boolean isPartiallyMapPackageEnabledCountry() {
        if (GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.JORDAN.getCountryId()) {
            return true;
        }
        return false;
    }

    public static boolean isRTL() {
        return isArabic() || isKurdish();
    }

    public static boolean isValidEmail(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(charSequence).matches();
    }

    public static String loadJSONFromAsset(Context context) {
        InputStream open;
        try {
            open = context.getAssets().open("countrycode.json");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            String str = new String(bArr, "UTF-8");
            open.close();
            return str;
        } catch (IOException unused) {
            return null;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    private static void reportGetSelectedCountryReturnedNull(int i11, Country[] countryArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("selected_country_id", String.valueOf(i11));
        hashMap.put("countries", countriesToString(countryArr));
        ObservabilityManager.trackEvent("get_selected_country_returned_null", "ULEvents", (Map<String, String>) hashMap);
    }

    public static void resetAreaSelection(Context context) {
        GlobalDataModel.SelectedAreaId = 0;
        GlobalDataModel.SelectedAreaName = "";
        SharedPreferences.Editor edit = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.remove(GlobalConstants.PrefsConstants.AREA_NAME);
        edit.remove(GlobalConstants.PrefsConstants.AREA_ID);
        edit.apply();
    }

    public static void saveDeviceIDToSharedPref(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences(GlobalConstants.PrefsWithBackupConstants.NAME, 0).edit();
        edit.putString(GlobalConstants.PrefsWithBackupConstants.DEVICE_ID, str);
        edit.apply();
    }

    @Deprecated
    public static Country getSelectedCountry(ConfigurationLocalRepository configurationLocalRepository, LocationConfigurationRepository locationConfigurationRepository, @Nullable IObservabilityManager iObservabilityManager) {
        com.talabat.configuration.country.Country selectedCountry = configurationLocalRepository.selectedCountry();
        if (iObservabilityManager != null) {
            new HashMap().put("selectedCountryFromConfigurationLocalRepository", selectedCountry.toString());
        }
        LogManager.debug("[ALOV]: getSelectedCountry :: init selectedCountry=" + selectedCountry);
        if (selectedCountry != null && selectedCountry.getCountryId() > 0) {
            List<com.talabat.configuration.location.Country> countries = locationConfigurationRepository.countries();
            CountryToOldCountryMapper countryToOldCountryMapper = new CountryToOldCountryMapper(new CityToOldCityMapper());
            LogManager.debug("[ALOV]: getSelectedCountry :: local config countries=" + countries);
            for (com.talabat.configuration.location.Country next : countries) {
                if (next.getCountry().getCountryId() == selectedCountry.getCountryId()) {
                    Country apply = countryToOldCountryMapper.apply(next);
                    LogManager.debug("[ALOV]: getSelectedCountry :: NEW HIT nCountry=" + apply);
                    if (iObservabilityManager != null) {
                        new HashMap().put("country", apply.toString());
                    }
                    return apply;
                }
            }
        }
        Country selectedCountry2 = getSelectedCountry();
        LogManager.debug("[ALOV]: getSelectedCountry :: OLD WAY oCountry=" + selectedCountry2);
        if (iObservabilityManager != null) {
            new HashMap().put("country", selectedCountry2 != null ? selectedCountry2.toString() : "null");
        }
        return selectedCountry2;
    }

    public static boolean isNullOrEmpty(ArrayList arrayList) {
        return arrayList == null || arrayList.size() == 0;
    }

    @Deprecated
    public static Country getSelectedCountry() {
        Country country;
        int i11 = GlobalDataModel.SelectedCountryId;
        Country[] countryArr = GlobalDataModel.countries;
        if (i11 > 0 && countryArr != null) {
            int length = countryArr.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    break;
                }
                country = countryArr[i12];
                if (country.f13845id == GlobalDataModel.SelectedCountryId) {
                    break;
                }
                i12++;
            }
        }
        country = null;
        if (country == null) {
            reportGetSelectedCountryReturnedNull(i11, countryArr);
        }
        return country;
    }
}
