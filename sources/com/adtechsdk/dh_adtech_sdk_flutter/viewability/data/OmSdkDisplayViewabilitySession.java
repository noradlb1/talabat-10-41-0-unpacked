package com.adtechsdk.dh_adtech_sdk_flutter.viewability.data;

import android.view.View;
import com.adtechsdk.dh_adtech_sdk_flutter.viewability.entities.DisplayViewabilitySession;
import com.iab.omid.library.deliveryhero3.adsession.AdEvents;
import com.iab.omid.library.deliveryhero3.adsession.AdSession;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/data/OmSdkDisplayViewabilitySession;", "Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/entities/DisplayViewabilitySession;", "adSession", "Lcom/iab/omid/library/deliveryhero3/adsession/AdSession;", "adEvents", "Lcom/iab/omid/library/deliveryhero3/adsession/AdEvents;", "(Lcom/iab/omid/library/deliveryhero3/adsession/AdSession;Lcom/iab/omid/library/deliveryhero3/adsession/AdEvents;)V", "_isTracking", "", "isTracking", "()Z", "finish", "", "start", "adView", "Landroid/view/View;", "trackImpression", "trackLoaded", "dh_adtech_sdk_flutter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OmSdkDisplayViewabilitySession implements DisplayViewabilitySession {
    private boolean _isTracking;
    @NotNull
    private final AdEvents adEvents;
    @NotNull
    private final AdSession adSession;

    public OmSdkDisplayViewabilitySession(@NotNull AdSession adSession2, @NotNull AdEvents adEvents2) {
        Intrinsics.checkNotNullParameter(adSession2, "adSession");
        Intrinsics.checkNotNullParameter(adEvents2, "adEvents");
        this.adSession = adSession2;
        this.adEvents = adEvents2;
    }

    public void finish() {
        if (isTracking()) {
            this.adSession.finish();
            this._isTracking = false;
        }
    }

    public boolean isTracking() {
        return this._isTracking;
    }

    public void start(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "adView");
        if (!isTracking()) {
            this.adSession.registerAdView(view);
            this.adSession.start();
            this._isTracking = true;
        }
    }

    public void trackImpression() {
        this.adEvents.impressionOccurred();
    }

    public void trackLoaded() {
        this.adEvents.loaded();
    }
}
