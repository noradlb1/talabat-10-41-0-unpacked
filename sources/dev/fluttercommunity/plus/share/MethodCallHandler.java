package dev.fluttercommunity.plus.share;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.IOException;
import java.util.List;
import java.util.Map;

class MethodCallHandler implements MethodChannel.MethodCallHandler {
    private Share share;

    public MethodCallHandler(Share share2) {
        this.share = share2;
    }

    private void expectMapArguments(MethodCall methodCall) throws IllegalArgumentException {
        if (!(methodCall.arguments instanceof Map)) {
            throw new IllegalArgumentException("Map argument expected");
        }
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        if (str.equals("shareFiles")) {
            expectMapArguments(methodCall);
            try {
                this.share.c((List) methodCall.argument("paths"), (List) methodCall.argument("mimeTypes"), (String) methodCall.argument("text"), (String) methodCall.argument("subject"));
                result.success((Object) null);
            } catch (IOException e11) {
                result.error(e11.getMessage(), (String) null, (Object) null);
            }
        } else if (!str.equals("share")) {
            result.notImplemented();
        } else {
            expectMapArguments(methodCall);
            this.share.b((String) methodCall.argument("text"), (String) methodCall.argument("subject"));
            result.success((Object) null);
        }
    }
}
