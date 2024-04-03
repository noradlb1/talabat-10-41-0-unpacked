package com.huawei.location.lite.common.http.interceptor;

import android.text.TextUtils;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.http.adapter.InterceptorAdapter;
import com.huawei.location.lite.common.http.adapter.ResponseAdapter;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.request.BaseRequest;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.DeviceInfoUtil;
import java.io.IOException;

public abstract class BaseCommonInterceptor implements InterceptorAdapter {
    private void addCommonHeads(BaseRequest.Builder builder) {
        a(builder, "X-Device-Type", Integer.toString(DeviceInfoUtil.getDeviceFeature(ContextUtil.getContext())));
        a(builder, "X-PhoneModel", DeviceInfoUtil.getDeviceModel());
    }

    public static String b() {
        String property = System.getProperty("http.agent");
        if (TextUtils.isEmpty(property)) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int length = property.length();
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = property.charAt(i11);
            if (charAt <= 31 || charAt >= 127) {
                sb2.append(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
            } else {
                sb2.append(charAt);
            }
        }
        return sb2.toString();
    }

    public void a(BaseRequest.Builder builder, String str, String str2) {
        try {
            builder.addHeader(str, str2);
        } catch (IllegalArgumentException | NullPointerException unused) {
            LogConsole.d("CommonHeadsInterceptor", "add head failed : key or value is null or illegal");
        }
    }

    public abstract void addCustomHeads(BaseRequest.Builder builder);

    public abstract void addCustomQuery(BaseRequest.Builder builder);

    public ResponseAdapter intercept(InterceptorAdapter.Chain chain) throws IOException, OnFailureException, OnErrorException {
        BaseRequest.Builder newBuilder = chain.request().newBuilder();
        addCommonHeads(newBuilder);
        addCustomHeads(newBuilder);
        addCustomQuery(newBuilder);
        return chain.proceed(newBuilder.build());
    }
}
