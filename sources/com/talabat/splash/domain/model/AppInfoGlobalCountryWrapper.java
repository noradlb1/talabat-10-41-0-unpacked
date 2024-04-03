package com.talabat.splash.domain.model;

import buisnessmodels.TalabatFormatter;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import com.talabat.configuration.location.City;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.fwf.data.FunWithFlags;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.splash.data.preferences.SplashPreferences;
import com.talabat.splash.presentation.infrastructure.thirdparty.Tracking;
import datamodels.Country;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Singleton
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0019\u0010\u0013\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012J\u0006\u0010\u001c\u001a\u00020\u0010J\u0006\u0010\u001d\u001a\u00020\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/talabat/splash/domain/model/AppInfoGlobalCountryWrapper;", "", "splashPreferences", "Lcom/talabat/splash/data/preferences/SplashPreferences;", "tracking", "Lcom/talabat/splash/presentation/infrastructure/thirdparty/Tracking;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "mutableConfigurationLocalCoreLibApi", "Lcom/talabat/configuration/di/MutableConfigurationLocalCoreLibApi;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/splash/data/preferences/SplashPreferences;Lcom/talabat/splash/presentation/infrastructure/thirdparty/Tracking;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lcom/talabat/configuration/di/MutableConfigurationLocalCoreLibApi;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "saveReverseGeoConuntry", "", "countryId", "", "setAppInfoGlobalCountry", "countries", "", "Ldatamodels/Country;", "([Ldatamodels/Country;)V", "setCountryFormatter", "currencySymbol", "", "numOfDecimalPlaces", "setGlobalCountryDetails", "setGlobalCountryPrefs", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppInfoGlobalCountryWrapper {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;
    @NotNull
    private final MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final SplashPreferences splashPreferences;
    @NotNull

    /* renamed from: tracking  reason: collision with root package name */
    private final Tracking f61467tracking;

    @Inject
    public AppInfoGlobalCountryWrapper(@NotNull SplashPreferences splashPreferences2, @NotNull Tracking tracking2, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull LocationConfigurationRepository locationConfigurationRepository2, @NotNull MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi2, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(splashPreferences2, "splashPreferences");
        Intrinsics.checkNotNullParameter(tracking2, "tracking");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        Intrinsics.checkNotNullParameter(mutableConfigurationLocalCoreLibApi2, "mutableConfigurationLocalCoreLibApi");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.splashPreferences = splashPreferences2;
        this.f61467tracking = tracking2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.mutableConfigurationLocalCoreLibApi = mutableConfigurationLocalCoreLibApi2;
        this.observabilityManager = iObservabilityManager;
    }

    public final void saveReverseGeoConuntry(int i11) {
        this.mutableConfigurationLocalCoreLibApi.getMutableRepository().setSelectedCountry(i11);
    }

    public final void setAppInfoGlobalCountry(@NotNull Country[] countryArr) {
        Intrinsics.checkNotNullParameter(countryArr, "countries");
        GlobalDataModel.countries = countryArr;
    }

    public final void setCountryFormatter(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "currencySymbol");
        TalabatFormatter.getInstance().setFormat(str, i11, GlobalDataModel.SelectedCountryId);
    }

    public final void setGlobalCountryDetails() {
        boolean z11;
        com.talabat.configuration.country.Country selectedCountry = this.configurationLocalRepository.selectedCountry();
        boolean z12 = true;
        int i11 = 0;
        if (selectedCountry.getCountryId() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (GlobalDataModel.SelectedCityId <= 0) {
            z12 = false;
        }
        String str = "";
        if (z11) {
            Iterator<com.talabat.configuration.location.Country> it = this.locationConfigurationRepository.countries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.talabat.configuration.location.Country next = it.next();
                if (next.getCountry().getCountryId() == selectedCountry.getCountryId()) {
                    GlobalDataModel.SelectedCountryName = next.getCountry().getCountryName();
                    str = next.getCurrencyCode();
                    i11 = next.getNumberOfDecimalPlaces();
                    if (z12) {
                        Iterator<City> it2 = next.getCities().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            City next2 = it2.next();
                            if (next2.getId() == GlobalDataModel.SelectedCityId) {
                                GlobalDataModel.SelectedCityName = next2.getName();
                                break;
                            }
                        }
                    }
                }
            }
        }
        setCountryFormatter(str, i11);
    }

    public final void setGlobalCountryPrefs() {
        String str;
        int i11;
        int countryId = this.locationConfigurationRepository.config().getCountry().getCountryId();
        if (countryId > 0) {
            Iterator<com.talabat.configuration.location.Country> it = this.locationConfigurationRepository.countries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = "";
                    i11 = 0;
                    break;
                }
                com.talabat.configuration.location.Country next = it.next();
                if (next.getCountry().getCountryId() == countryId) {
                    this.mutableConfigurationLocalCoreLibApi.getMutableRepository().setSelectedCountry(next.getCountry().getCountryId());
                    GlobalDataModel.launchRxNextEventOnCountryId(next.getCountry().getCountryId());
                    GlobalDataModel.SelectedCountryName = next.getCountry().getCountryName();
                    str = next.getCurrencyCode();
                    i11 = next.getNumberOfDecimalPlaces();
                    break;
                }
            }
            this.splashPreferences.saveCountryInPrefs(GlobalDataModel.SelectedCountryId, GlobalDataModel.SelectedCountryName);
            setCountryFormatter(str, i11);
            this.f61467tracking.onCountrySelected();
            FunWithFlags.updateSelectedCountry(this.mutableConfigurationLocalCoreLibApi.getMutableRepository().selectedCountry());
        }
    }
}
