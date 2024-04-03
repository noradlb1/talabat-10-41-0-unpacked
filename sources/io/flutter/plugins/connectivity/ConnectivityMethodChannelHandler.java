package io.flutter.plugins.connectivity;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

class ConnectivityMethodChannelHandler implements MethodChannel.MethodCallHandler {
    private Connectivity connectivity;

    public ConnectivityMethodChannelHandler(Connectivity connectivity2) {
        this.connectivity = connectivity2;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        if (!str.equals("check")) {
            result.notImplemented();
        } else {
            result.success(this.connectivity.a());
        }
    }
}
