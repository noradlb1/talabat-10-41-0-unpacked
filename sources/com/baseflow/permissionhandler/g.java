package com.baseflow.permissionhandler;

import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class g implements ErrorCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f43245a;

    public /* synthetic */ g(MethodChannel.Result result) {
        this.f43245a = result;
    }

    public final void onError(String str, String str2) {
        this.f43245a.error(str, str2, (Object) null);
    }
}
