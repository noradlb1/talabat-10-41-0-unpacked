package com.adtechsdk.dh_adtech_sdk_flutter.viewability.entities;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\u0006H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/entities/DisplayViewabilitySession;", "", "isTracking", "", "()Z", "finish", "", "start", "adView", "Landroid/view/View;", "trackImpression", "trackLoaded", "dh_adtech_sdk_flutter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface DisplayViewabilitySession {
    void finish();

    boolean isTracking();

    void start(@NotNull View view);

    void trackImpression();

    void trackLoaded();
}
