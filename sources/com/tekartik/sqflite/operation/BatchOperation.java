package com.tekartik.sqflite.operation;

import com.tekartik.sqflite.Constant;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BatchOperation extends BaseOperation {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f12916a;

    /* renamed from: b  reason: collision with root package name */
    public final BatchOperationResult f12917b = new BatchOperationResult();

    /* renamed from: c  reason: collision with root package name */
    public final boolean f12918c;

    public class BatchOperationResult implements OperationResult {

        /* renamed from: a  reason: collision with root package name */
        public Object f12919a;

        /* renamed from: b  reason: collision with root package name */
        public String f12920b;

        /* renamed from: c  reason: collision with root package name */
        public String f12921c;

        /* renamed from: d  reason: collision with root package name */
        public Object f12922d;

        public BatchOperationResult() {
        }

        public void error(String str, String str2, Object obj) {
            this.f12920b = str;
            this.f12921c = str2;
            this.f12922d = obj;
        }

        public void success(Object obj) {
            this.f12919a = obj;
        }
    }

    public BatchOperation(Map<String, Object> map, boolean z11) {
        this.f12916a = map;
        this.f12918c = z11;
    }

    public <T> T getArgument(String str) {
        return this.f12916a.get(str);
    }

    public String getMethod() {
        return (String) this.f12916a.get("method");
    }

    public boolean getNoResult() {
        return this.f12918c;
    }

    public Map<String, Object> getOperationError() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put(Constant.PARAM_ERROR_CODE, this.f12917b.f12920b);
        hashMap2.put("message", this.f12917b.f12921c);
        hashMap2.put("data", this.f12917b.f12922d);
        hashMap.put("error", hashMap2);
        return hashMap;
    }

    public OperationResult getOperationResult() {
        return this.f12917b;
    }

    public Map<String, Object> getOperationSuccessResult() {
        HashMap hashMap = new HashMap();
        hashMap.put("result", this.f12917b.f12919a);
        return hashMap;
    }

    public void handleError(MethodChannel.Result result) {
        BatchOperationResult batchOperationResult = this.f12917b;
        result.error(batchOperationResult.f12920b, batchOperationResult.f12921c, batchOperationResult.f12922d);
    }

    public void handleErrorContinue(List<Map<String, Object>> list) {
        if (!getNoResult()) {
            list.add(getOperationError());
        }
    }

    public void handleSuccess(List<Map<String, Object>> list) {
        if (!getNoResult()) {
            list.add(getOperationSuccessResult());
        }
    }
}
