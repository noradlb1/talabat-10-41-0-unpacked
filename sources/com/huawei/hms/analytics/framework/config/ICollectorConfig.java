package com.huawei.hms.analytics.framework.config;

import com.huawei.hms.analytics.core.storage.Event;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public interface ICollectorConfig {
    String getAppId();

    List<JSONObject> getCustomEventJson(long j11);

    DeviceAttributeCollector getDeviceAttribute(String str);

    EvtHeaderAttributeCollector getEvtCustomHeader(String str, JSONObject jSONObject);

    Map<String, String> getHttpHeader(String str);

    RomAttributeCollector getRomAttribute(String str);

    IConfig getServiceConfig();

    List<String> getServiceTagsByElbHeader(String str);

    Event getSpecialEvent(String str);

    void handlerThrowable(Throwable th2);

    boolean isDebugModel();

    boolean isEnableSession(String str);

    void serviceListener(boolean z11, IConfig iConfig);

    void setIConfig(IConfig iConfig);

    void syncOaid();
}
