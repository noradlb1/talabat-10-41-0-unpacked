package com.huawei.hms.analytics;

import android.os.Bundle;
import com.huawei.hms.analytics.core.storage.Event;
import com.huawei.hms.analytics.framework.config.IConfig;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public interface bl {
    void klm();

    void klm(long j11);

    void klm(IConfig iConfig);

    void klm(List<Event> list);

    void lmn();

    void lmn(long j11);

    void lmn(IConfig iConfig);

    void lmn(IConfig iConfig, List<Event> list);

    void lmn(IConfig iConfig, Map<String, dt> map);

    void lmn(String str, Bundle bundle, long j11);

    void lmn(String str, dt dtVar, long j11);

    void lmn(String str, List<JSONObject> list);

    void lmn(List<JSONObject> list);
}
