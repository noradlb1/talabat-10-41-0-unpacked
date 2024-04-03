package com.talabat.splash.presentation.infrastructure.device.currentlocation;

import androidx.annotation.VisibleForTesting;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\"\u0014\u0010\u0000\u001a\u00020\u0001XD¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00058\u0002XD¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\"\u0016\u0010\b\u001a\u00020\t8\u0002XD¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0007\"\u0014\u0010\u000b\u001a\u00020\u0001XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0003\"\u000e\u0010\r\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS", "", "getFASTEST_UPDATE_INTERVAL_IN_MILLISECONDS", "()J", "LOCATION_ACCURACY", "", "getLOCATION_ACCURACY$annotations", "()V", "LOCATION_UPDATE_COUNT", "", "getLOCATION_UPDATE_COUNT$annotations", "UPDATE_INTERVAL_IN_MILLISECONDS", "getUPDATE_INTERVAL_IN_MILLISECONDS", "mGpsRequestTime", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LocationLiveDataKt {
    private static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = 5000;
    /* access modifiers changed from: private */
    public static final float LOCATION_ACCURACY = 150.0f;
    /* access modifiers changed from: private */
    public static final int LOCATION_UPDATE_COUNT = 3;
    private static final long UPDATE_INTERVAL_IN_MILLISECONDS = 10000;
    /* access modifiers changed from: private */
    public static long mGpsRequestTime;

    public static final long getFASTEST_UPDATE_INTERVAL_IN_MILLISECONDS() {
        return FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS;
    }

    @VisibleForTesting
    private static /* synthetic */ void getLOCATION_ACCURACY$annotations() {
    }

    @VisibleForTesting
    private static /* synthetic */ void getLOCATION_UPDATE_COUNT$annotations() {
    }

    public static final long getUPDATE_INTERVAL_IN_MILLISECONDS() {
        return UPDATE_INTERVAL_IN_MILLISECONDS;
    }
}
