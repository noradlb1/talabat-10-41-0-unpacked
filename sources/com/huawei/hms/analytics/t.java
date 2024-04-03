package com.huawei.hms.analytics;

import android.content.Context;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;

public final class t extends HuaweiApi<Api.ApiOptions.NoOptions> {
    private static final s lmn = new s();

    public t(Context context) {
        super(context, new Api(""), new Api.ApiOptions.NoOptions(), (AbstractClientBuilder) lmn);
    }
}
