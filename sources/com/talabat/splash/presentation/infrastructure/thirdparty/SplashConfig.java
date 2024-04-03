package com.talabat.splash.presentation.infrastructure.thirdparty;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.splash.data.preferences.SplashPreferences;
import com.talabat.splash.domain.model.SplashDataUtils;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import com.talabat.talabatremoteconfiguration.keys.SplashRemoteConfigurationKeys;
import java.util.Calendar;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/splash/presentation/infrastructure/thirdparty/SplashConfig;", "", "splashPreferences", "Lcom/talabat/splash/data/preferences/SplashPreferences;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/splash/data/preferences/SplashPreferences;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "init", "", "setFeatureSplashVideoType", "splashViewType", "", "setQatarSplashSpecialLogo", "enable", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplashConfig {
    @NotNull
    private final SplashPreferences splashPreferences;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    @Inject
    public SplashConfig(@NotNull SplashPreferences splashPreferences2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(splashPreferences2, "splashPreferences");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.splashPreferences = splashPreferences2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    /* access modifiers changed from: private */
    public final void setFeatureSplashVideoType(String str) {
        String str2;
        String str3 = str;
        SplashDataUtils splashDataUtils = SplashDataUtils.INSTANCE;
        if (Intrinsics.areEqual((Object) str3, (Object) splashDataUtils.getFWF_SPLASH_UI_VIEW_TYPE_SPECIAL_VIDEO())) {
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.set(2022, 3, 1, 0, 0, 0);
            Calendar instance3 = Calendar.getInstance();
            instance3.set(2022, 4, 5, 0, 0, 0);
            if (!instance.after(instance2) || !instance.before(instance3)) {
                str2 = splashDataUtils.getFWF_SPLASH_UI_VIEW_IMAGE();
            } else {
                str2 = splashDataUtils.getFWF_SPLASH_UI_VIEW_TYPE_SPECIAL_VIDEO();
            }
        } else if (Intrinsics.areEqual((Object) str3, (Object) splashDataUtils.getFWF_SPLASH_UI_VIEW_TYPE_NORMAL_VIDEO())) {
            str2 = splashDataUtils.getFWF_SPLASH_UI_VIEW_TYPE_NORMAL_VIDEO();
        } else {
            str2 = splashDataUtils.getFWF_SPLASH_UI_VIEW_IMAGE();
        }
        this.splashPreferences.setSplashViewType(str2);
    }

    /* access modifiers changed from: private */
    public final void setQatarSplashSpecialLogo(boolean z11) {
        this.splashPreferences.setQatarSpecialSplashLogo(z11);
    }

    public final void init() {
        ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.talabatFeatureFlag, (FWFKey) TalabatFeatureFlagConstants.SHOW_QATAR_SPECIAL_LOGO_SPLASH, false, false, (Function1) new SplashConfig$init$1(this), 6, (Object) null);
        RemoteConfiguration.INSTANCE.getRemoteConfiguration((FWFKey) SplashRemoteConfigurationKeys.SPLASH_VIEW_TYPE, "normal", false, String.class, new SplashConfig$init$2(this));
        ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.talabatFeatureFlag, (FWFKey) TalabatFeatureFlagConstants.DISABLE_OBSERVABILITY_FEATURE_KEY, false, false, (Function1) SplashConfig$init$3.INSTANCE, 2, (Object) null);
    }
}
