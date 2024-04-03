package com.talabat.feature.subscriptions.data;

import buisnessmodels.Customer;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsExperimentsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsFeatureFlagsKeys;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0002J\"\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0002J\u001a\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0017J\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/talabat/feature/subscriptions/data/SubscriptionsFeatureFlagsRepositoryImpl;", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "featureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "experiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/core/experiment/domain/ITalabatExperiment;)V", "getApptimizeBoolean", "", "key", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "default", "getBoolean", "source", "Lcom/talabat/feature/subscriptions/data/SubscriptionsFeatureFlagsRepositoryImpl$FlagSource;", "getFwFBoolean", "isNewBrandEnabled", "isNewHeroBannerEnabled", "isOnboardingDeeplingEnabled", "isROIbannerExpiredModeEnabled", "isReactivateFromROIBannerEnabled", "isSavingsBannerEnabled", "isSavingsFlowEnabled", "isTProDisclaimerTextEnabled", "isTProEnabledForNFV", "isTProEnabledForTMart", "isTProFeatureEnabled", "isTProSideBannerEnabled", "isTproSubscriptionEnabled", "isTproSubscriptionUpgradeEnabled", "Companion", "FlagSource", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionsFeatureFlagsRepositoryImpl implements ISubscriptionsFeatureFlagsRepository {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String control = "Control";
    @NotNull
    private final ITalabatExperiment experiment;
    @NotNull
    private final ITalabatFeatureFlag featureFlag;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/subscriptions/data/SubscriptionsFeatureFlagsRepositoryImpl$Companion;", "", "()V", "control", "", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/subscriptions/data/SubscriptionsFeatureFlagsRepositoryImpl$FlagSource;", "", "(Ljava/lang/String;I)V", "FWF", "APPTIMIZE", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum FlagSource {
        FWF,
        APPTIMIZE
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FlagSource.values().length];
            iArr[FlagSource.FWF.ordinal()] = 1;
            iArr[FlagSource.APPTIMIZE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public SubscriptionsFeatureFlagsRepositoryImpl(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull ITalabatExperiment iTalabatExperiment) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlag");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, InstabugDbContract.ExperimentsEntry.COLUMN_EXPERIMENT);
        this.featureFlag = iTalabatFeatureFlag;
        this.experiment = iTalabatExperiment;
    }

    public static /* synthetic */ boolean a(SubscriptionsFeatureFlagsRepositoryImpl subscriptionsFeatureFlagsRepositoryImpl, FWFKey fWFKey, FlagSource flagSource, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        return subscriptionsFeatureFlagsRepositoryImpl.getBoolean(fWFKey, flagSource, z11);
    }

    private final boolean getApptimizeBoolean(FWFKey fWFKey, boolean z11) {
        return ITalabatExperiment.DefaultImpls.getBooleanVariant$default(this.experiment, fWFKey, z11, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null);
    }

    private final boolean getBoolean(FWFKey fWFKey, FlagSource flagSource, boolean z11) {
        boolean z12;
        int i11 = WhenMappings.$EnumSwitchMapping$0[flagSource.ordinal()];
        if (i11 == 1) {
            z12 = getFwFBoolean(fWFKey, z11);
        } else if (i11 == 2) {
            z12 = getApptimizeBoolean(fWFKey, z11);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        String value = fWFKey.getValue();
        String name2 = flagSource.name();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Requesting flag: ");
        sb2.append(value);
        sb2.append(" = ");
        sb2.append(z12);
        sb2.append(" - source: ");
        sb2.append(name2);
        if (!z12 || !isTProFeatureEnabled()) {
            return false;
        }
        return true;
    }

    private final boolean getFwFBoolean(FWFKey fWFKey, boolean z11) {
        return this.featureFlag.getFeatureFlag(fWFKey, z11);
    }

    @Deprecated(message = "To be removed")
    public boolean isNewBrandEnabled() {
        return a(this, TalabatFeatureFlagConstants.BRAND_UPDATES, FlagSource.APPTIMIZE, false, 4, (Object) null);
    }

    public boolean isNewHeroBannerEnabled() {
        if (Intrinsics.areEqual((Object) this.experiment.getStringVariant(EcosystemsExperimentsKeys.IS_PRO_NEW_BENEFITS_PAGE_ENABLED, "Control", TalabatExperimentDataSourceStrategy.FWF), (Object) "Control") || !isTProFeatureEnabled()) {
            return false;
        }
        return true;
    }

    public boolean isOnboardingDeeplingEnabled() {
        if (isTproSubscriptionEnabled()) {
            if (a(this, TalabatFeatureFlagConstants.ENABLE_TPRO_ONBOARDING_DEEPLINKS, FlagSource.FWF, false, 4, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public boolean isROIbannerExpiredModeEnabled() {
        if (isTproSubscriptionEnabled()) {
            if (a(this, EcosystemsFeatureFlagsKeys.IS_EXPIRED_MODE_ROI_BANNER_ENABLED, FlagSource.FWF, false, 4, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public boolean isReactivateFromROIBannerEnabled() {
        if (isTproSubscriptionEnabled()) {
            if (a(this, EcosystemsFeatureFlagsKeys.IS_REACTIVATE_FROM_ROI_BANNER_ENABLED, FlagSource.FWF, false, 4, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSavingsBannerEnabled() {
        if (isTproSubscriptionEnabled()) {
            if (a(this, TalabatFeatureFlagConstants.ENABLE_SAVINGS_ACCOUNT_BANNER, FlagSource.FWF, false, 4, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSavingsFlowEnabled() {
        if (isTproSubscriptionEnabled()) {
            if (a(this, TalabatFeatureFlagConstants.ENABLE_SAVINGS_CANCEL_FLOW, FlagSource.FWF, false, 4, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public boolean isTProDisclaimerTextEnabled() {
        if (isTproSubscriptionEnabled()) {
            if (a(this, EcosystemsFeatureFlagsKeys.IS_TALABAT_PRO_DISCLAIMER_TEXT_ENABLED, FlagSource.FWF, false, 4, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public boolean isTProEnabledForNFV() {
        if (isTproSubscriptionEnabled()) {
            if (a(this, TalabatFeatureFlagConstants.ENABLE_TPRO_FOR_NFV, FlagSource.FWF, false, 4, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public boolean isTProEnabledForTMart() {
        if (isTproSubscriptionEnabled()) {
            if (a(this, TalabatFeatureFlagConstants.ENABLE_TPRO_FOR_TMART, FlagSource.FWF, false, 4, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public boolean isTProFeatureEnabled() {
        return isTproSubscriptionEnabled();
    }

    public boolean isTProSideBannerEnabled() {
        if (isTproSubscriptionEnabled()) {
            if (a(this, TalabatFeatureFlagConstants.ENABLE_TPRO_SIDE_MENU_BANNER, FlagSource.FWF, false, 4, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public boolean isTproSubscriptionEnabled() {
        Customer instance = Customer.getInstance();
        return instance != null && instance.isShowPro();
    }

    public boolean isTproSubscriptionUpgradeEnabled() {
        if (Intrinsics.areEqual((Object) this.experiment.getStringVariant(EcosystemsExperimentsKeys.TPRO_UPGRADE_SUBSCRIPTION, "Control", TalabatExperimentDataSourceStrategy.FWF), (Object) "Control") || !isTProFeatureEnabled()) {
            return false;
        }
        return true;
    }
}
