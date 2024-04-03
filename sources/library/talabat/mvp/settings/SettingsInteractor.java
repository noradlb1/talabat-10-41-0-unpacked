package library.talabat.mvp.settings;

import buisnessmodels.TalabatFormatter;
import c20.a;
import c20.b;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.talabat.authentication.authenticate.data.remote.model.LogoutResponse;
import com.talabat.authentication.authenticate.domain.repository.AuthenticationRepository;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.configuration.location.Area;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.observability.ObservabilityManager;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.userandlocation.appinfo.domain.repo.AppInfoRepository;
import com.talabat.userandlocation.appinfo.domain.repo.AppInfoRepositoryKt;
import datamodels.Country;
import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.HashMap;
import java.util.Iterator;

public class SettingsInteractor implements ISettingInteractor {
    private Disposable appInfoDisposable = Disposables.empty();
    private final AppInfoRepository appInfoRepository;
    /* access modifiers changed from: private */
    public Disposable authDisposable = Disposables.empty();
    private final AuthenticationRepository authenticationRepository;
    private final Scheduler ioScheduler;
    private Disposable loadCountrySepecificDataDisposable = Disposables.empty();
    private final LocationConfigurationRepository locationConfigRepository;
    private final Scheduler mainScheduler;
    private final MutableConfigurationLocalRepository mutableConfigurationLocalRepository;
    /* access modifiers changed from: private */
    public SettingsListener settingsListener;

    public SettingsInteractor(SettingsListener settingsListener2, LocationConfigurationRepository locationConfigurationRepository, Scheduler scheduler, Scheduler scheduler2, AppInfoRepository appInfoRepository2, MutableConfigurationLocalRepository mutableConfigurationLocalRepository2, AuthenticationRepository authenticationRepository2) {
        this.settingsListener = settingsListener2;
        this.locationConfigRepository = locationConfigurationRepository;
        this.ioScheduler = scheduler;
        this.mainScheduler = scheduler2;
        this.appInfoRepository = appInfoRepository2;
        this.mutableConfigurationLocalRepository = mutableConfigurationLocalRepository2;
        this.authenticationRepository = authenticationRepository2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$loadAppDataforLocaleChange$0() throws Exception {
        LogManager.info("SettingScreen - FetchAppInfoSuccess");
        GlobalDataModel.filterEngine = null;
        GlobalDataModel.cuisines = null;
        requestCompleted();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$loadAppDataforLocaleChange$1(Throwable th2) throws Exception {
        trackUnexpectedScenario(th2);
        this.settingsListener.onNetworkError();
    }

    private void requestCompleted() {
        boolean z11;
        initialiseCountryPreferences();
        int i11 = GlobalDataModel.SelectedCityId;
        boolean z12 = true;
        if (i11 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            GlobalDataModel.SelectedCityName = TalabatUtils.getCityName(i11, this.mutableConfigurationLocalRepository, this.locationConfigRepository);
        }
        if (GlobalDataModel.SelectedAreaId <= 0) {
            z12 = false;
        }
        if (z12) {
            Iterator<Area> it = this.locationConfigRepository.areas().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Area next = it.next();
                if (next.getId() == GlobalDataModel.SelectedAreaId) {
                    GlobalDataModel.SelectedAreaName = next.getAreaName();
                    break;
                }
            }
        }
        SettingsListener settingsListener2 = this.settingsListener;
        if (settingsListener2 != null) {
            settingsListener2.onDataLoadingCompleted();
        }
    }

    private void trackUnexpectedScenario(Throwable th2) {
        HashMap hashMap = new HashMap();
        hashMap.put("errorMessage", th2.getMessage());
        ObservabilityManager.trackUnExpectedScenario("SettingsInteractorAppInfoError", hashMap);
    }

    public void initialiseCountryPreferences() {
        Country selectedCountry = TalabatUtils.getSelectedCountry(this.mutableConfigurationLocalRepository, this.locationConfigRepository);
        this.mutableConfigurationLocalRepository.setSelectedCountry(selectedCountry.f13845id);
        GlobalDataModel.launchRxNextEventOnCountryId(selectedCountry.f13845id);
        GlobalDataModel.SelectedCountryName = selectedCountry.f13846name;
        TalabatFormatter.getInstance().setFormat(selectedCountry.currencySymbol, selectedCountry.numOfDecimalPlaces, selectedCountry.f13845id);
    }

    public void loadAppDataforLocaleChange() {
        this.appInfoDisposable = AppInfoRepositoryKt.fetchAppInfoCompletable(this.appInfoRepository, GlobalDataModel.SelectedCountryId).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new a(this), new b(this));
    }

    public void logout(final boolean z11) {
        this.authenticationRepository.logout().subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new SingleObserver<LogoutResponse>() {
            public void onError(Throwable th2) {
                SettingsInteractor.this.settingsListener.onLogout(z11);
            }

            public void onSubscribe(Disposable disposable) {
                SettingsInteractor.this.authDisposable = disposable;
            }

            public void onSuccess(LogoutResponse logoutResponse) {
                SettingsInteractor.this.settingsListener.onLogout(z11);
            }
        });
    }

    public Response.ErrorListener onRequestError() {
        return new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                if ((volleyError instanceof ServerError) && SettingsInteractor.this.settingsListener != null) {
                    SettingsInteractor.this.settingsListener.onServerError(volleyError);
                } else if ((volleyError instanceof NetworkError) && SettingsInteractor.this.settingsListener != null) {
                    SettingsInteractor.this.settingsListener.onNetworkError();
                } else if ((volleyError instanceof AuthFailureError) && SettingsInteractor.this.settingsListener != null) {
                    SettingsInteractor.this.settingsListener.onDataError();
                }
            }
        };
    }

    public void unregister() {
        this.loadCountrySepecificDataDisposable.dispose();
        this.appInfoDisposable.dispose();
        this.authDisposable.dispose();
        this.settingsListener = null;
    }
}
