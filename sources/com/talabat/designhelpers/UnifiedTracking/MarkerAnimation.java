package com.talabat.designhelpers.UnifiedTracking;

import android.os.Handler;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.talabat.maps.domain.LatLngFactory;
import com.talabat.maps.domain.model.LatLng;
import com.talabat.maps.domain.model.Marker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/designhelpers/UnifiedTracking/MarkerAnimation;", "", "()V", "animateMarkerToGB", "", "marker", "Lcom/talabat/maps/domain/model/Marker;", "finalPosition", "Lcom/talabat/maps/domain/model/LatLng;", "latLngInterpolator", "Lcom/talabat/designhelpers/UnifiedTracking/LatLngInterpolator;", "latLngFactory", "Lcom/talabat/maps/domain/LatLngFactory;", "handler", "Landroid/os/Handler;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MarkerAnimation {
    @NotNull
    public static final MarkerAnimation INSTANCE = new MarkerAnimation();

    private MarkerAnimation() {
    }

    public final boolean animateMarkerToGB(@NotNull Marker marker, @NotNull LatLng latLng, @NotNull LatLngInterpolator latLngInterpolator, @NotNull LatLngFactory latLngFactory, @NotNull Handler handler) {
        Handler handler2 = handler;
        Intrinsics.checkNotNullParameter(marker, "marker");
        Intrinsics.checkNotNullParameter(latLng, "finalPosition");
        LatLngInterpolator latLngInterpolator2 = latLngInterpolator;
        Intrinsics.checkNotNullParameter(latLngInterpolator2, "latLngInterpolator");
        LatLngFactory latLngFactory2 = latLngFactory;
        Intrinsics.checkNotNullParameter(latLngFactory2, "latLngFactory");
        Intrinsics.checkNotNullParameter(handler2, "handler");
        LatLng position = marker.getPosition();
        handler2.post(new MarkerAnimation$animateMarkerToGB$1(SystemClock.uptimeMillis(), 3000.0f, new AccelerateDecelerateInterpolator(), marker, latLngInterpolator2, position, latLng, latLngFactory2, handler));
        return false;
    }
}
