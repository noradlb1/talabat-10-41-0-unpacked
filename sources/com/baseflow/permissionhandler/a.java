package com.baseflow.permissionhandler;

import com.baseflow.permissionhandler.ServiceManager;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class a implements ServiceManager.SuccessCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f43239a;

    public /* synthetic */ a(MethodChannel.Result result) {
        this.f43239a = result;
    }

    public final void onSuccess(int i11) {
        this.f43239a.success(Integer.valueOf(i11));
    }
}
