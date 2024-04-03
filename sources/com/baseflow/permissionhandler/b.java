package com.baseflow.permissionhandler;

import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class b implements ErrorCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f43240a;

    public /* synthetic */ b(MethodChannel.Result result) {
        this.f43240a = result;
    }

    public final void onError(String str, String str2) {
        this.f43240a.error(str, str2, (Object) null);
    }
}
