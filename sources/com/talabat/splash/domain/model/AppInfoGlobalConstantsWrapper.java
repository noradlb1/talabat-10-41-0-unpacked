package com.talabat.splash.domain.model;

import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.location.LocationConfig;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.location.LocationFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageFeatureFlagsKeys;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.splash.data.preferences.SplashPreferences;
import com.talabat.splash.domain.entity.AppInitResponseEntity;
import com.talabat.splash.domain.entity.AppInitRootEntity;
import datamodels.Area;
import datamodels.mappers.OldAreaToAreaMapper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Singleton
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ+\u0010\u000b\u001a\u00020\u00062\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u0017\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/splash/domain/model/AppInfoGlobalConstantsWrapper;", "", "splashPreferences", "Lcom/talabat/splash/data/preferences/SplashPreferences;", "(Lcom/talabat/splash/data/preferences/SplashPreferences;)V", "saveNormalAppUpdate", "", "updateAvail", "", "updateMsg", "", "setAppInfoGlobalArea", "areas", "", "Ldatamodels/Area;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "mutableLocationConfigurationRepository", "Lcom/talabat/configuration/MutableLocationConfigurationRepository;", "([Ldatamodels/Area;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/configuration/MutableLocationConfigurationRepository;)V", "setAppInfoGlobalInfo", "response", "Lcom/talabat/splash/domain/entity/AppInitRootEntity;", "updateFirstInstall", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppInfoGlobalConstantsWrapper {
    @NotNull
    private final SplashPreferences splashPreferences;

    @Inject
    public AppInfoGlobalConstantsWrapper(@NotNull SplashPreferences splashPreferences2) {
        Intrinsics.checkNotNullParameter(splashPreferences2, "splashPreferences");
        this.splashPreferences = splashPreferences2;
    }

    public final void saveNormalAppUpdate(boolean z11, @Nullable String str) {
        GlobalConstants.NormalUpdate.IS_NORMAL_UPDATE = z11;
        GlobalConstants.NormalUpdate.NORMAL_UPDATE_MSG = str;
    }

    public final void setAppInfoGlobalArea(@Nullable Area[] areaArr, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull MutableLocationConfigurationRepository mutableLocationConfigurationRepository) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(mutableLocationConfigurationRepository, "mutableLocationConfigurationRepository");
        if (!ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(iTalabatFeatureFlag, HomePageFeatureFlagsKeys.FF_HOMEPAGE_AREAS_UL_ENDPOINT, false, 2, (Object) null)) {
            if (!ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(iTalabatFeatureFlag, LocationFeatureFlagConstants.LOCATION_REPO_REAL_AREAS, false, 2, (Object) null) || areaArr == null) {
                GlobalDataModel.areas = areaArr;
                return;
            }
            OldAreaToAreaMapper oldAreaToAreaMapper = new OldAreaToAreaMapper();
            LocationConfig config = mutableLocationConfigurationRepository.config();
            ArrayList arrayList = new ArrayList(areaArr.length);
            for (Area apply : areaArr) {
                arrayList.add(oldAreaToAreaMapper.apply(apply));
            }
            mutableLocationConfigurationRepository.setConfig(LocationConfig.copy$default(config, (List) null, arrayList, (Country) null, (List) null, false, 0, 61, (Object) null));
        }
    }

    public final void setAppInfoGlobalInfo(@Nullable AppInitRootEntity appInitRootEntity) {
        String str;
        AppInitResponseEntity result;
        String str2 = null;
        if (appInitRootEntity != null) {
            str = appInitRootEntity.getBaseUrl();
        } else {
            str = null;
        }
        GlobalDataModel.imageBaseUrl = str;
        if (!(appInitRootEntity == null || (result = appInitRootEntity.getResult()) == null)) {
            str2 = result.getPublicKey();
        }
        GlobalDataModel.CHECKOUTDOTCOM.publicKey = str2;
    }

    public final void updateFirstInstall() {
        this.splashPreferences.setIsFirstInstall();
    }
}
