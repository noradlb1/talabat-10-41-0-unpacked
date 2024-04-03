package com.talabat.gms.maps.data;

import com.google.android.gms.maps.GoogleMap;
import com.talabat.maps.domain.FrameworkMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/talabat/gms/maps/data/GoogleFrameworkMap$animateCamera$1", "Lcom/google/android/gms/maps/GoogleMap$CancelableCallback;", "onCancel", "", "onFinish", "com_talabat_core_gms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GoogleFrameworkMap$animateCamera$1 implements GoogleMap.CancelableCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FrameworkMap.CancelableCallback f60558a;

    public GoogleFrameworkMap$animateCamera$1(FrameworkMap.CancelableCallback cancelableCallback) {
        this.f60558a = cancelableCallback;
    }

    public void onCancel() {
        this.f60558a.onCancel();
    }

    public void onFinish() {
        this.f60558a.onFinish();
    }
}
