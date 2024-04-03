package com.baseflow.permissionhandler;

import com.baseflow.permissionhandler.PermissionManager;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class f implements PermissionManager.ShouldShowRequestPermissionRationaleSuccessCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f43244a;

    public /* synthetic */ f(MethodChannel.Result result) {
        this.f43244a = result;
    }

    public final void onSuccess(boolean z11) {
        this.f43244a.success(Boolean.valueOf(z11));
    }
}
