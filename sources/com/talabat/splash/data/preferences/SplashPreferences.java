package com.talabat.splash.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import buisnessmodels.Cart;
import com.talabat.R;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.configuration.language.Language;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.domain.FWFAttributes;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.domain.address.Address;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.helpers.TalabatVolley;
import com.talabat.observability.localTracer.PointOfInterest;
import com.talabat.observability.localTracer.PointOfInterestReporter;
import com.talabat.observability.localTracer.SectionOfInterest;
import com.talabat.splash.domain.model.AppInfoGlobalCustomerWrapper;
import com.talabat.splash.domain.model.SplashDataUtils;
import com.talabat.splash.presentation.infrastructure.device.CommonUtils;
import com.talabat.splash.presentation.infrastructure.device.PresentationUtils;
import datamodels.Token;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.homemap.HomeMapTemp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Singleton
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0002J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u0014H\u0016J\b\u0010#\u001a\u00020\u0012H\u0002J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u001eJ\b\u0010(\u001a\u00020\u0012H\u0002J\b\u0010)\u001a\u00020\u0014H\u0016J\u0006\u0010*\u001a\u00020\u0012J\u000e\u0010+\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010,\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.J\u0010\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u001eH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/talabat/splash/data/preferences/SplashPreferences;", "Lcom/talabat/splash/data/preferences/SplashPreferenceHelper;", "sharedPreferences", "Landroid/content/SharedPreferences;", "presentationUtils", "Lcom/talabat/splash/presentation/infrastructure/device/PresentationUtils;", "commonUtils", "Lcom/talabat/splash/presentation/infrastructure/device/CommonUtils;", "context", "Landroid/content/Context;", "appInfoGlobalCustomerWrapper", "Lcom/talabat/splash/domain/model/AppInfoGlobalCustomerWrapper;", "mutableConfigurationLocalRepository", "Lcom/talabat/configuration/MutableConfigurationLocalRepository;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Landroid/content/SharedPreferences;Lcom/talabat/splash/presentation/infrastructure/device/PresentationUtils;Lcom/talabat/splash/presentation/infrastructure/device/CommonUtils;Landroid/content/Context;Lcom/talabat/splash/domain/model/AppInfoGlobalCustomerWrapper;Lcom/talabat/configuration/MutableConfigurationLocalRepository;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "enableSplashVideo", "", "enable", "", "getAppLanguage", "getIsEnableSplashVideo", "getIsEnableSplashWelcome", "getIsFreshInstall", "getQatarSpecialLogo", "getSavedCart", "getSavedPreferences", "getSplashVideoStatus", "getSplashViewType", "", "getTempAddress", "Lcom/talabat/domain/address/Address;", "addressString", "isUserLoggedIn", "retriveToken", "saveCountryInPrefs", "selectedCountryId", "", "selectedCountryName", "setHomeMapPreferences", "setInitalAppPreferences", "setIsFirstInstall", "setQatarSpecialSplashLogo", "setShopClickOriginForSavedCart", "cart", "Lbuisnessmodels/Cart;", "setSplashViewType", "splashViewType", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplashPreferences implements SplashPreferenceHelper {
    @NotNull
    private final AppInfoGlobalCustomerWrapper appInfoGlobalCustomerWrapper;
    @NotNull
    private final CommonUtils commonUtils;
    @NotNull
    private final Context context;
    @NotNull
    private final MutableConfigurationLocalRepository mutableConfigurationLocalRepository;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final PresentationUtils presentationUtils;
    @NotNull
    private final SharedPreferences sharedPreferences;

    @Inject
    public SplashPreferences(@NotNull SharedPreferences sharedPreferences2, @NotNull PresentationUtils presentationUtils2, @NotNull CommonUtils commonUtils2, @NotNull Context context2, @NotNull AppInfoGlobalCustomerWrapper appInfoGlobalCustomerWrapper2, @NotNull MutableConfigurationLocalRepository mutableConfigurationLocalRepository2, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        Intrinsics.checkNotNullParameter(presentationUtils2, "presentationUtils");
        Intrinsics.checkNotNullParameter(commonUtils2, "commonUtils");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(appInfoGlobalCustomerWrapper2, "appInfoGlobalCustomerWrapper");
        Intrinsics.checkNotNullParameter(mutableConfigurationLocalRepository2, "mutableConfigurationLocalRepository");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.sharedPreferences = sharedPreferences2;
        this.presentationUtils = presentationUtils2;
        this.commonUtils = commonUtils2;
        this.context = context2;
        this.appInfoGlobalCustomerWrapper = appInfoGlobalCustomerWrapper2;
        this.mutableConfigurationLocalRepository = mutableConfigurationLocalRepository2;
        this.observabilityManager = iObservabilityManager;
    }

    private final void getSavedCart() {
        Cart.getSavedCart(this.context);
        Cart.getSavedMcdCartAddress(this.context);
    }

    private final Address getTempAddress(String str) {
        return (Address) this.commonUtils.gsonFromJSON(str, Address.class);
    }

    private final void retriveToken() {
        String string = this.sharedPreferences.getString(LegacyTokenLocalDataSourceImpl.KEY, "");
        if (!Intrinsics.areEqual((Object) string, (Object) "")) {
            GlobalDataModel.token = (Token) this.commonUtils.gsonFromJSON(string, Token.class);
        }
    }

    private final void setHomeMapPreferences() {
        String str = "";
        this.sharedPreferences.getString(GlobalConstants.PrefsConstants.COUNTRY_NAME, str);
        HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
        String string = this.sharedPreferences.getString(GlobalConstants.PrefsConstants.HOME_MAP_PREF_LOCATION, str);
        if (string == null) {
            string = str;
        }
        homeMapTemp.setPrefLocation(string);
        homeMapTemp.setPrefZoom(Float.valueOf(this.sharedPreferences.getFloat(GlobalConstants.PrefsConstants.HOME_MAP_PREF_ZOOM, 14.0f)));
        homeMapTemp.setPrefAreaId(this.sharedPreferences.getInt(GlobalConstants.PrefsConstants.HOME_MAP_PREF_AREAID, 0));
        String string2 = this.sharedPreferences.getString(GlobalConstants.PrefsConstants.HOME_MAP_PREF_STREET_NAME, str);
        if (string2 == null) {
            string2 = str;
        }
        homeMapTemp.setStreetName(string2);
        homeMapTemp.setHomeMapRedirect(this.sharedPreferences.getBoolean(GlobalConstants.PrefsConstants.HOME_MAP_REDIRECT, false), this.context);
        String string3 = this.sharedPreferences.getString(GlobalConstants.PrefsConstants.HOME_MAP_PREF_ADDRESS, str);
        if (string3 != null) {
            str = string3;
        }
        homeMapTemp.setTempAddress(getTempAddress(str));
    }

    public void enableSplashVideo(boolean z11) {
        this.sharedPreferences.edit().putBoolean(GlobalConstants.PrefsConstants.CAN_HIDE_SPLASH_VIDEO, z11).apply();
    }

    public boolean getAppLanguage() {
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        SplashDataUtils splashDataUtils = SplashDataUtils.INSTANCE;
        String string = sharedPreferences2.getString(GlobalConstants.PrefsConstants.LOCALE, splashDataUtils.getLANGUAGE().getCode());
        if (string == null) {
            string = splashDataUtils.getLANGUAGE().getCode();
        }
        Intrinsics.checkNotNullExpressionValue(string, "sharedPreferences.getStr…shDataUtils.LANGUAGE.code");
        this.mutableConfigurationLocalRepository.setSelectedLanguage(string);
        if (Intrinsics.areEqual((Object) string, (Object) Language.UNKNOWN.getCode())) {
            String cleanLanguage = TalabatUtils.getCleanLanguage(Locale.getDefault().getLanguage());
            MutableConfigurationLocalRepository mutableConfigurationLocalRepository2 = this.mutableConfigurationLocalRepository;
            Intrinsics.checkNotNullExpressionValue(cleanLanguage, "cleanLanguage");
            mutableConfigurationLocalRepository2.setSelectedLanguage(cleanLanguage);
            SharedPreferences.Editor edit = this.sharedPreferences.edit();
            edit.putString(GlobalConstants.PrefsConstants.LOCALE, cleanLanguage);
            edit.apply();
            return false;
        }
        if (!Intrinsics.areEqual((Object) string, (Object) TalabatUtils.getCleanLanguage(Locale.getDefault().getLanguage()))) {
            this.appInfoGlobalCustomerWrapper.setCustomerLanguage(string);
        }
        return true;
    }

    public boolean getIsEnableSplashVideo() {
        return this.sharedPreferences.getBoolean(GlobalConstants.PrefsConstants.CAN_HIDE_SPLASH_VIDEO, false);
    }

    public boolean getIsEnableSplashWelcome() {
        return this.sharedPreferences.getBoolean(GlobalConstants.PrefsConstants.IS_FIRST_INSTALL, true);
    }

    public boolean getIsFreshInstall() {
        return this.sharedPreferences.getBoolean(GlobalConstants.PrefsConstants.IS_FIRST_INSTALL, true);
    }

    public boolean getQatarSpecialLogo() {
        return this.sharedPreferences.getBoolean(GlobalConstants.PrefsConstants.QATAR_SPECIAL_SPLASH_LOGO, false);
    }

    public boolean getSavedPreferences() {
        PointOfInterestReporter pointOfInterestReporter = PointOfInterestReporter.INSTANCE;
        SectionOfInterest sectionOfInterest = SectionOfInterest.SPLASH_ACTIVITY;
        PointOfInterest pointOfInterest = PointOfInterest.APP_BASIC_INFO_LOADED;
        pointOfInterestReporter.startTraceLog(sectionOfInterest, pointOfInterest);
        boolean z11 = false;
        this.mutableConfigurationLocalRepository.setSelectedCountry(this.sharedPreferences.getInt(GlobalConstants.PrefsConstants.COUNTRY_ID, 0));
        GlobalDataModel.SelectedCountryName = this.sharedPreferences.getString(GlobalConstants.PrefsConstants.COUNTRY_NAME, "");
        GlobalDataModel.SelectedCityId = this.sharedPreferences.getInt(GlobalConstants.PrefsConstants.CITY_ID, 0);
        GlobalDataModel.SelectedAreaId = this.sharedPreferences.getInt(GlobalConstants.PrefsConstants.AREA_ID, 0);
        GlobalDataModel.SelectedCityName = this.sharedPreferences.getString(GlobalConstants.PrefsConstants.CITY_NAME, "");
        GlobalDataModel.SelectedAreaName = this.sharedPreferences.getString(GlobalConstants.PrefsConstants.AREA_NAME, "");
        if (GlobalDataModel.SelectedCountryId <= 0) {
            z11 = true;
        }
        GlobalDataModel.isFirstTimeUser = z11;
        retriveToken();
        getSavedCart();
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        Cart instance = Cart.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        setShopClickOriginForSavedCart(sharedPreferences2, instance);
        setHomeMapPreferences();
        TalabatExperiment.INSTANCE.setAttribute(FWFAttributes.AREA_ID, String.valueOf(GlobalDataModel.SelectedAreaId));
        pointOfInterestReporter.endTraceLog(sectionOfInterest, pointOfInterest);
        return true;
    }

    public boolean getSplashVideoStatus() {
        return this.sharedPreferences.getBoolean(GlobalConstants.PrefsConstants.CAN_HIDE_SPLASH_VIDEO, false);
    }

    @NotNull
    public final String getSplashViewType() {
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        SplashDataUtils splashDataUtils = SplashDataUtils.INSTANCE;
        String string = sharedPreferences2.getString(GlobalConstants.PrefsConstants.SPLASH_VIEW_TYPE, splashDataUtils.getFWF_SPLASH_UI_VIEW_IMAGE());
        return string == null ? splashDataUtils.getFWF_SPLASH_UI_VIEW_IMAGE() : string;
    }

    public boolean isUserLoggedIn() {
        String string = this.sharedPreferences.getString(LegacyTokenLocalDataSourceImpl.KEY, "");
        if (Intrinsics.areEqual((Object) string, (Object) "")) {
            return false;
        }
        GlobalDataModel.token = (Token) this.commonUtils.gsonFromJSON(string, Token.class);
        return true;
    }

    public final void saveCountryInPrefs(int i11, @Nullable String str) {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putInt(GlobalConstants.PrefsConstants.COUNTRY_ID, i11);
        edit.putString(GlobalConstants.PrefsConstants.COUNTRY_NAME, str);
        edit.apply();
    }

    public boolean setInitalAppPreferences() {
        GlobalConstants.Version = this.context.getResources().getString(R.string.app_version);
        TalabatVolley.getRequestQueue(this.context);
        GlobalDataModel.deviceSize = this.presentationUtils.getDensity(this.context);
        return true;
    }

    public final void setIsFirstInstall() {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putBoolean(GlobalConstants.PrefsConstants.IS_FIRST_INSTALL, false);
        edit.apply();
    }

    public final void setQatarSpecialSplashLogo(boolean z11) {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putBoolean(GlobalConstants.PrefsConstants.QATAR_SPECIAL_SPLASH_LOGO, z11);
        edit.apply();
    }

    public final void setShopClickOriginForSavedCart(@NotNull SharedPreferences sharedPreferences2, @NotNull Cart cart) {
        Intrinsics.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        Intrinsics.checkNotNullParameter(cart, "cart");
        if (cart.hasItems()) {
            GlobalDataModel.ShopClickOrigin = sharedPreferences2.getString(Cart.SAVED_CART_VENDOR_CLICK_ORIGIN, "");
        }
    }

    public void setSplashViewType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "splashViewType");
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putString(GlobalConstants.PrefsConstants.SPLASH_VIEW_TYPE, str);
        edit.apply();
    }
}
