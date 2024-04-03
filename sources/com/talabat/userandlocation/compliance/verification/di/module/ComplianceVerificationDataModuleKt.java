package com.talabat.userandlocation.compliance.verification.di.module;

import android.app.Activity;
import android.content.Context;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.platform.PlatformFeatureFlagsKeys;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\b"}, d2 = {"getTalabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "context", "Landroid/content/Context;", "getTalabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "isNewTrackingLibraryEnabled", "", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ComplianceVerificationDataModuleKt {
    private static final ITalabatFeatureFlag getTalabatFeatureFlag(Context context) {
        return ((FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Activity) context).getFeature(FeatureFlagCoreLibApi.class)).getTalabatFeatureFlag();
    }

    /* access modifiers changed from: private */
    public static final TalabatTracker getTalabatTracker(Context context) {
        return ((TrackingCoreLibApi) AndroidComponentsKt.apiContainer(context).getFeature(TrackingCoreLibApi.class)).getTalabatTracker();
    }

    /* access modifiers changed from: private */
    public static final boolean isNewTrackingLibraryEnabled(Context context) {
        return getTalabatFeatureFlag(context).getFeatureFlag(PlatformFeatureFlagsKeys.TRACKING_LIBRARY_MIGRATION, true);
    }
}
