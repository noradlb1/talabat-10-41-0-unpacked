package com.talabat.hms.maps.data;

import com.huawei.hms.maps.HuaweiMap;
import com.talabat.maps.domain.FrameworkMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/talabat/hms/maps/data/HuaweiFrameworkMap$animateCamera$1", "Lcom/huawei/hms/maps/HuaweiMap$CancelableCallback;", "onCancel", "", "onFinish", "com_talabat_core_hms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HuaweiFrameworkMap$animateCamera$1 implements HuaweiMap.CancelableCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FrameworkMap.CancelableCallback f60863a;

    public HuaweiFrameworkMap$animateCamera$1(FrameworkMap.CancelableCallback cancelableCallback) {
        this.f60863a = cancelableCallback;
    }

    public void onCancel() {
        this.f60863a.onCancel();
    }

    public void onFinish() {
        this.f60863a.onFinish();
    }
}
