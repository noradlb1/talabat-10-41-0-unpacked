package com.baseflow.permissionhandler;

import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class e implements ErrorCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f43243a;

    public /* synthetic */ e(MethodChannel.Result result) {
        this.f43243a = result;
    }

    public final void onError(String str, String str2) {
        this.f43243a.error(str, str2, (Object) null);
    }
}
