package com.talabat.feature.tpro.presentation.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/feature/tpro/presentation/util/CancellationReasonScrollHeightHelper;", "", "()V", "ADJUSTED_HEIGHT_PERCENTAGE_NORMAL", "", "FULL_SCREEN_THRESHOLD", "", "PERCENTAGE_MULTIPLIER", "getAdjustedScrollHeight", "screenHeight", "isFullScreenContent", "", "contentHeight", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CancellationReasonScrollHeightHelper {
    private static final float ADJUSTED_HEIGHT_PERCENTAGE_NORMAL = 0.5f;
    private static final int FULL_SCREEN_THRESHOLD = 90;
    @NotNull
    public static final CancellationReasonScrollHeightHelper INSTANCE = new CancellationReasonScrollHeightHelper();
    private static final int PERCENTAGE_MULTIPLIER = 100;

    private CancellationReasonScrollHeightHelper() {
    }

    public final int getAdjustedScrollHeight(int i11) {
        return (int) (((float) i11) * 0.5f);
    }

    public final boolean isFullScreenContent(int i11, int i12) {
        return (((float) i12) / ((float) i11)) * ((float) 100) > 90.0f;
    }
}
