package com.tekartik.sqflite.operation;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class MethodCallOperation extends BaseOperation {

    /* renamed from: a  reason: collision with root package name */
    public final MethodCall f12924a;

    /* renamed from: b  reason: collision with root package name */
    public final Result f12925b;

    public class Result implements OperationResult {

        /* renamed from: a  reason: collision with root package name */
        public final MethodChannel.Result f12926a;

        public Result(MethodChannel.Result result) {
            this.f12926a = result;
        }

        public void error(String str, String str2, Object obj) {
            this.f12926a.error(str, str2, obj);
        }

        public void success(Object obj) {
            this.f12926a.success(obj);
        }
    }

    public MethodCallOperation(MethodCall methodCall, MethodChannel.Result result) {
        this.f12924a = methodCall;
        this.f12925b = new Result(result);
    }

    public <T> T getArgument(String str) {
        return this.f12924a.argument(str);
    }

    public String getMethod() {
        return this.f12924a.method;
    }

    public OperationResult getOperationResult() {
        return this.f12925b;
    }
}
