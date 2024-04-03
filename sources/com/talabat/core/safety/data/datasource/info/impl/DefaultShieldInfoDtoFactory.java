package com.talabat.core.safety.data.datasource.info.impl;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.advertisement.google.domain.GoogleAdvertisementRepository;
import com.talabat.core.perseus.domain.TalabatPerseusRepository;
import com.talabat.core.safety.data.datasource.info.ShieldInfoDtoFactory;
import com.talabat.core.safety.data.di.AndroidId;
import com.talabat.core.safety.data.di.DeviceName;
import com.talabat.core.safety.data.di.InstallationPath;
import com.talabat.core.safety.data.di.PackageName;
import com.talabat.core.safety.data.model.SafetyEventTypesKt;
import com.talabat.core.safety.data.model.ShieldInfoDto;
import com.talabat.core.safety.domain.SafetyEventType;
import com.talabat.core.safety.domain.entities.SafetyAppData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BO\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\u000b\u0012\b\b\u0001\u0010\r\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u000b¢\u0006\u0002\u0010\u000fJ(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/core/safety/data/datasource/info/impl/DefaultShieldInfoDtoFactory;", "Lcom/talabat/core/safety/data/datasource/info/ShieldInfoDtoFactory;", "advertisementRepository", "Lcom/talabat/core/advertisement/google/domain/GoogleAdvertisementRepository;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "perseusRepository", "Lcom/talabat/core/perseus/domain/TalabatPerseusRepository;", "androidId", "", "packageName", "installationPath", "deviceName", "(Lcom/talabat/core/advertisement/google/domain/GoogleAdvertisementRepository;Lcom/talabat/configuration/discovery/AppVersionProvider;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/core/perseus/domain/TalabatPerseusRepository;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "create", "Lcom/talabat/core/safety/data/model/ShieldInfoDto;", "customerId", "safetyEventType", "Lcom/talabat/core/safety/domain/SafetyEventType;", "playIntegrityResponse", "safetyAppData", "Lcom/talabat/core/safety/domain/entities/SafetyAppData;", "com_talabat_core_safety_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultShieldInfoDtoFactory implements ShieldInfoDtoFactory {
    @NotNull
    private final GoogleAdvertisementRepository advertisementRepository;
    @NotNull
    private final String androidId;
    @NotNull
    private final AppVersionProvider appVersionProvider;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final String deviceName;
    @NotNull
    private final String installationPath;
    @NotNull
    private final String packageName;
    @NotNull
    private final TalabatPerseusRepository perseusRepository;

    @Inject
    public DefaultShieldInfoDtoFactory(@NotNull GoogleAdvertisementRepository googleAdvertisementRepository, @NotNull AppVersionProvider appVersionProvider2, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull TalabatPerseusRepository talabatPerseusRepository, @NotNull @AndroidId String str, @NotNull @PackageName String str2, @NotNull @InstallationPath String str3, @NotNull @DeviceName String str4) {
        Intrinsics.checkNotNullParameter(googleAdvertisementRepository, "advertisementRepository");
        Intrinsics.checkNotNullParameter(appVersionProvider2, "appVersionProvider");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(talabatPerseusRepository, "perseusRepository");
        Intrinsics.checkNotNullParameter(str, "androidId");
        Intrinsics.checkNotNullParameter(str2, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(str3, "installationPath");
        Intrinsics.checkNotNullParameter(str4, "deviceName");
        this.advertisementRepository = googleAdvertisementRepository;
        this.appVersionProvider = appVersionProvider2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.perseusRepository = talabatPerseusRepository;
        this.androidId = str;
        this.packageName = str2;
        this.installationPath = str3;
        this.deviceName = str4;
    }

    @NotNull
    public ShieldInfoDto create(@NotNull String str, @NotNull SafetyEventType safetyEventType, @NotNull String str2, @NotNull SafetyAppData safetyAppData) {
        Intrinsics.checkNotNullParameter(str, "customerId");
        Intrinsics.checkNotNullParameter(safetyEventType, "safetyEventType");
        Intrinsics.checkNotNullParameter(str2, "playIntegrityResponse");
        Intrinsics.checkNotNullParameter(safetyAppData, "safetyAppData");
        String str3 = this.installationPath;
        String str4 = this.packageName;
        String appVersion = this.appVersionProvider.appVersion();
        if (appVersion == null) {
            appVersion = "";
        }
        return new ShieldInfoDto(str3, str4, appVersion, Integer.valueOf(this.configurationLocalRepository.selectedCountry().getCountryId()), str, safetyAppData.getAdjustId(), this.advertisementRepository.fetchCachedGoogleAdvertisementId(), this.androidId, this.deviceName, Integer.valueOf(SafetyEventTypesKt.toInt(safetyEventType)), "", this.perseusRepository.getMyClientId(), this.perseusRepository.getMySessionId(), 6, str2);
    }
}
