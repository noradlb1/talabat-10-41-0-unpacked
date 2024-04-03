package com.huawei.hms.flutter.map.map;

import android.graphics.Bitmap;
import com.huawei.hms.maps.HuaweiMap;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class a implements HuaweiMap.SnapshotReadyCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f48817a;

    public /* synthetic */ a(MethodChannel.Result result) {
        this.f48817a = result;
    }

    public final void onSnapshotReady(Bitmap bitmap) {
        MapController.lambda$onMethodCall$0(this.f48817a, bitmap);
    }
}
