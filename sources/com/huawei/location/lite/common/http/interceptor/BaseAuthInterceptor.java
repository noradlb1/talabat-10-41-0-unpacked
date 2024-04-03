package com.huawei.location.lite.common.http.interceptor;

import android.text.TextUtils;
import com.huawei.location.lite.common.http.adapter.InterceptorAdapter;
import com.huawei.location.lite.common.http.request.BaseRequest;
import com.huawei.location.lite.common.http.request.HeadBuilder;
import com.huawei.location.lite.common.http.sign.SignHeadInfo;
import com.huawei.location.lite.common.http.sign.SignRequest;
import com.huawei.location.lite.common.log.LogConsole;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public abstract class BaseAuthInterceptor implements InterceptorAdapter {
    public BaseRequest a(BaseRequest baseRequest) throws IOException {
        LogConsole.d("authorization", "auth request start...");
        String str = new String(baseRequest.getBody(), StandardCharsets.UTF_8);
        String str2 = baseRequest.getHeads().get("X-Request-ID");
        String str3 = baseRequest.getHeads().get(HeadBuilder.CLIENT_CP_NAME);
        SignRequest.Builder query = new SignRequest.Builder(baseRequest.getMethod(), baseRequest.getBaseUrl(), baseRequest.getPath(), str2).payLoad(str).query(baseRequest.getQueryString());
        SignHeadInfo.Builder builder = new SignHeadInfo.Builder();
        if (!TextUtils.isEmpty(str3)) {
            builder.buildWithHeadSigned(HeadBuilder.CLIENT_CP_NAME, str3);
        }
        query.headSigned(builder.build().toStringArray());
        return sign(baseRequest, query.build());
    }

    public abstract BaseRequest sign(BaseRequest baseRequest, SignRequest signRequest) throws IOException;
}
