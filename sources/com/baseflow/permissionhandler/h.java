package com.baseflow.permissionhandler;

import com.baseflow.permissionhandler.AppSettingsManager;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class h implements AppSettingsManager.OpenAppSettingsSuccessCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f43246a;

    public /* synthetic */ h(MethodChannel.Result result) {
        this.f43246a = result;
    }

    public final void onSuccess(boolean z11) {
        this.f43246a.success(Boolean.valueOf(z11));
    }
}
