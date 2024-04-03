package com.baseflow.permissionhandler;

import com.baseflow.permissionhandler.PermissionManager;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;

public final /* synthetic */ class d implements PermissionManager.RequestPermissionsSuccessCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f43242a;

    public /* synthetic */ d(MethodChannel.Result result) {
        this.f43242a = result;
    }

    public final void onSuccess(Map map) {
        this.f43242a.success(map);
    }
}
