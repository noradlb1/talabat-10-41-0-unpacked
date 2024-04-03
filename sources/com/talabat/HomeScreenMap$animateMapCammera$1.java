package com.talabat;

import com.talabat.maps.domain.FrameworkMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/talabat/HomeScreenMap$animateMapCammera$1", "Lcom/talabat/maps/domain/FrameworkMap$CancelableCallback;", "onCancel", "", "onFinish", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenMap$animateMapCammera$1 implements FrameworkMap.CancelableCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMap f54200a;

    public HomeScreenMap$animateMapCammera$1(HomeScreenMap homeScreenMap) {
        this.f54200a = homeScreenMap;
    }

    public void onCancel() {
        this.f54200a.isMapCameraFinished = true;
    }

    public void onFinish() {
        this.f54200a.isMapCameraFinished = true;
    }
}
