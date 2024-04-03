package com.huawei.location.lite.common.plug;

import com.huawei.location.lite.common.plug.PluginRespResult;

public interface IPluginResult<T extends PluginRespResult> {
    void onResult(T t11);
}
