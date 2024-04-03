package com.baseflow.permissionhandler;

import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class i implements ErrorCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f43247a;

    public /* synthetic */ i(MethodChannel.Result result) {
        this.f43247a = result;
    }

    public final void onError(String str, String str2) {
        this.f43247a.error(str, str2, (Object) null);
    }
}
