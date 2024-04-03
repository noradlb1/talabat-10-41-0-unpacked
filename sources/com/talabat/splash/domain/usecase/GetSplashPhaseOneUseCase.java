package com.talabat.splash.domain.usecase;

import com.talabat.configuration.country.Country;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.splash.core.interactor.InternalUseCaseStateDecider;
import com.talabat.splash.data.preferences.SplashPreferences;
import com.talabat.splash.domain.model.SplashCampaignType;
import com.talabat.splash.domain.model.SplashDataUtils;
import com.talabat.splash.domain.model.SplashPhaseOneWrapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/splash/domain/usecase/GetSplashPhaseOneUseCase;", "Lcom/talabat/splash/core/interactor/InternalUseCaseStateDecider;", "Lcom/talabat/splash/domain/model/SplashPhaseOneWrapper;", "splashPreferences", "Lcom/talabat/splash/data/preferences/SplashPreferences;", "(Lcom/talabat/splash/data/preferences/SplashPreferences;)V", "getCampaignLogoVisibility", "", "getCampaignType", "Lcom/talabat/splash/domain/model/SplashCampaignType;", "getScreenRedirectionInfo", "", "handleVisibilityLogicForQatar", "isQatarCurrentlySelected", "run", "splashUIType", "", "splashViewType", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetSplashPhaseOneUseCase extends InternalUseCaseStateDecider<SplashPhaseOneWrapper> {
    @NotNull
    private final SplashPreferences splashPreferences;

    @Inject
    public GetSplashPhaseOneUseCase(@NotNull SplashPreferences splashPreferences2) {
        Intrinsics.checkNotNullParameter(splashPreferences2, "splashPreferences");
        this.splashPreferences = splashPreferences2;
    }

    private final boolean getCampaignLogoVisibility() {
        if (this.splashPreferences.getQatarSpecialLogo()) {
            return handleVisibilityLogicForQatar();
        }
        return false;
    }

    private final SplashCampaignType getCampaignType() {
        if (isQatarCurrentlySelected()) {
            return SplashCampaignType.QATAR_NATIONAL_TEAM;
        }
        return null;
    }

    private final Object getScreenRedirectionInfo() {
        return new SplashPhaseOneWrapper(splashViewType(), Integer.valueOf(splashUIType()), Boolean.FALSE, Boolean.valueOf(getCampaignLogoVisibility()), getCampaignType());
    }

    private final boolean handleVisibilityLogicForQatar() {
        return isQatarCurrentlySelected();
    }

    private final boolean isQatarCurrentlySelected() {
        int i11 = GlobalDataModel.SelectedCountryId;
        if (i11 > 0 && i11 == Country.QATAR.getCountryId()) {
            return true;
        }
        return false;
    }

    private final int splashUIType() {
        String splashViewType = this.splashPreferences.getSplashViewType();
        SplashDataUtils splashDataUtils = SplashDataUtils.INSTANCE;
        if (Intrinsics.areEqual((Object) splashViewType, (Object) splashDataUtils.getFWF_SPLASH_UI_VIEW_TYPE_NORMAL_VIDEO())) {
            return splashDataUtils.getSPLASH_UI_NORMAL_VIDEO();
        }
        if (Intrinsics.areEqual((Object) splashViewType, (Object) splashDataUtils.getFWF_SPLASH_UI_VIEW_TYPE_SPECIAL_VIDEO())) {
            return splashDataUtils.getSPLASH_UI_SPECIAL_OCCASION_VIDEO();
        }
        return splashDataUtils.getSPLASH_UI_IMAGE();
    }

    private final int splashViewType() {
        return this.splashPreferences.getIsEnableSplashWelcome() ? 1 : 0;
    }

    @NotNull
    public Object run() {
        return getScreenRedirectionInfo();
    }
}
