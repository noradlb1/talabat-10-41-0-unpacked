package com.baseflow.permissionhandler;

import com.baseflow.permissionhandler.PermissionManager;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class c implements PermissionManager.CheckPermissionsSuccessCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f43241a;

    public /* synthetic */ c(MethodChannel.Result result) {
        this.f43241a = result;
    }

    public final void onSuccess(int i11) {
        this.f43241a.success(Integer.valueOf(i11));
    }
}
