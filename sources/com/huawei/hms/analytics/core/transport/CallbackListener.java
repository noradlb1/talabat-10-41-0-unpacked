package com.huawei.hms.analytics.core.transport;

import com.huawei.hms.analytics.core.transport.net.Response;

public interface CallbackListener {
    void onFailure(int i11);

    void onSuccess(Response response);
}
