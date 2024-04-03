package com.talabat.feature.tpro.presentation.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/tpro/presentation/util/PlanSelectionScrollHeightHelper;", "", "()V", "ADJUSTED_HEIGHT_PERCENTAGE_FREE_TRIAL", "", "ADJUSTED_HEIGHT_PERCENTAGE_NORMAL", "FULL_SCREEN_THRESHOLD", "", "PERCENTAGE_MULTIPLIER", "getAdjustedScrollHeight", "screenHeight", "isFreeTrial", "", "isFullScreenContent", "contentHeight", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PlanSelectionScrollHeightHelper {
    private static final float ADJUSTED_HEIGHT_PERCENTAGE_FREE_TRIAL = 0.5f;
    private static final float ADJUSTED_HEIGHT_PERCENTAGE_NORMAL = 0.6f;
    private static final int FULL_SCREEN_THRESHOLD = 90;
    @NotNull
    public static final PlanSelectionScrollHeightHelper INSTANCE = new PlanSelectionScrollHeightHelper();
    private static final int PERCENTAGE_MULTIPLIER = 100;

    private PlanSelectionScrollHeightHelper() {
    }

    public final int getAdjustedScrollHeight(int i11, boolean z11) {
        return (int) (((float) i11) * (z11 ? 0.5f : 0.6f));
    }

    public final boolean isFullScreenContent(int i11, int i12) {
        return (((float) i12) / ((float) i11)) * ((float) 100) > 90.0f;
    }
}
