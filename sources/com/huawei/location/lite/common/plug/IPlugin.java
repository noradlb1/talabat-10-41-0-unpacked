package com.huawei.location.lite.common.plug;

public interface IPlugin {
    <T extends PluginRespResult> T startFunction(String str, PluginReqMessage pluginReqMessage);

    <T extends PluginRespResult> void startFunction(String str, PluginReqMessage pluginReqMessage, IPluginResult<T> iPluginResult);
}
