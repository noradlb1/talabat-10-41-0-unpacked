package library.talabat.mvp.settings;

import android.content.Context;
import android.content.SharedPreferences;
import buisnessmodels.Cart;
import com.adjust.sdk.Constants;
import com.android.volley.VolleyError;
import com.talabat.authentication.authenticate.domain.repository.AuthenticationRepository;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.user.UserFeatureFlagsKeys;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.userandlocation.appinfo.domain.repo.AppInfoRepository;
import datamodels.CustomerInfo;
import io.reactivex.Scheduler;
import tracking.AppTracker;
import tracking.TalabatAppBoy;

public class SettingsPresenter implements ISettingsPresenter, SettingsListener {
    private Context context;
    private ISettingInteractor iSettingInteractor;
    private SharedPreferences preferences;
    private SettingsView settingsView;
    private ITalabatFeatureFlag talabatFeatureFlag;

    public SettingsPresenter(SettingsView settingsView2, LocationConfigurationRepository locationConfigurationRepository, Scheduler scheduler, Scheduler scheduler2, AppInfoRepository appInfoRepository, MutableConfigurationLocalRepository mutableConfigurationLocalRepository, AuthenticationRepository authenticationRepository, ITalabatFeatureFlag iTalabatFeatureFlag) {
        this.settingsView = settingsView2;
        this.iSettingInteractor = new SettingsInteractor(this, locationConfigurationRepository, scheduler, scheduler2, appInfoRepository, mutableConfigurationLocalRepository, authenticationRepository);
        Context context2 = settingsView2.getContext();
        this.context = context2;
        this.preferences = context2.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0);
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public void changeLanguage(Context context2, String str) {
        TalabatUtils.changeLocale(context2, str);
        AppTracker.onLanguageChanged(context2);
        this.iSettingInteractor.loadAppDataforLocaleChange();
    }

    public boolean getNotificationPreference() {
        return this.preferences.getBoolean(Constants.PUSH, true);
    }

    public void logout(boolean z11) {
        if (this.talabatFeatureFlag.getFeatureFlag(UserFeatureFlagsKeys.FF_USER_AUTHENTICATION_AAA_LOGOUT_API, false)) {
            this.settingsView.startLodingPopup();
            this.iSettingInteractor.logout(z11);
            return;
        }
        this.settingsView.onLogout(z11);
    }

    public void onCountryChanged() {
        this.settingsView.onChangeCountryCompleted();
    }

    public void onCustomerDetailsLoaded(CustomerInfo customerInfo) {
        this.settingsView.stopLodingPopup();
    }

    public void onDataError() {
        this.settingsView.stopLodingPopup();
        this.settingsView.onDataError();
    }

    public void onDataLoadingCompleted() {
        SharedPreferences.Editor edit = this.settingsView.getContext().getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.putString(GlobalConstants.PrefsConstants.LOCALE, GlobalDataModel.SelectedLanguage);
        edit.putInt(GlobalConstants.PrefsConstants.CITY_ID, GlobalDataModel.SelectedCityId);
        edit.putString(GlobalConstants.PrefsConstants.CITY_NAME, GlobalDataModel.SelectedCityName);
        edit.putString(GlobalConstants.PrefsConstants.AREA_NAME, GlobalDataModel.SelectedAreaName);
        edit.putInt(GlobalConstants.PrefsConstants.AREA_ID, GlobalDataModel.SelectedAreaId);
        edit.apply();
        Cart.getInstance().clearCart(this.settingsView.getContext());
        this.settingsView.reloadViewForLocaleChange();
    }

    public void onDestroy() {
        this.settingsView = null;
        ISettingInteractor iSettingInteractor2 = this.iSettingInteractor;
        if (iSettingInteractor2 != null) {
            iSettingInteractor2.unregister();
        }
        this.iSettingInteractor = null;
    }

    public void onLogout(boolean z11) {
        this.settingsView.stopLodingPopup();
        this.settingsView.onLogout(z11);
    }

    public void onNetworkError() {
        this.settingsView.stopLodingPopup();
        this.settingsView.onNetworkError();
    }

    public void onServerError(VolleyError volleyError) {
        this.settingsView.stopLodingPopup();
        this.settingsView.onServerError(volleyError);
    }

    public void saveNotificationPreference(boolean z11) {
        TalabatAppBoy.pushNotificationOptOut(this.context, z11);
        SharedPreferences.Editor edit = this.preferences.edit();
        edit.putBoolean(Constants.PUSH, z11);
        edit.apply();
    }
}
