package com.huawei.hms.analytics.framework;

import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.core.storage.Event;
import com.huawei.hms.analytics.core.storage.IStorageHandler;
import com.huawei.hms.analytics.framework.b.a;
import com.huawei.hms.analytics.framework.b.b;
import com.huawei.hms.analytics.framework.config.ICallback;
import com.huawei.hms.analytics.framework.config.ICollectorConfig;
import com.huawei.hms.analytics.framework.config.IConfig;
import com.huawei.hms.analytics.framework.config.IMandatoryParameters;
import com.huawei.hms.analytics.framework.policy.IStoragePolicy;
import java.util.List;
import org.json.JSONObject;

public interface HAFrameworkInstance {
    public static final String TAG = "HAFrameworkCase";

    public static final class Builder {
        private ICollectorConfig collectorConfig;
        private IMandatoryParameters parameters;
        private IStorageHandler storageHandler;
        private IStoragePolicy storagePolicy;

        public final HAFrameworkInstance build(String str) {
            if (this.parameters == null && b.a().f47924a == null) {
                return null;
            }
            if (b.a().f47925b.containsKey(str)) {
                HiLog.w(HAFrameworkInstance.TAG, "serviceTag check failed : ".concat(String.valueOf(str)));
                return null;
            }
            b.a().a(str, this.parameters, new a(this.collectorConfig, this.storageHandler, this.storagePolicy));
            return new a(str);
        }

        public final Builder setCollectorConfig(ICollectorConfig iCollectorConfig) {
            this.collectorConfig = iCollectorConfig;
            return this;
        }

        public final Builder setMandatoryParameters(IMandatoryParameters iMandatoryParameters) {
            this.parameters = iMandatoryParameters;
            return this;
        }

        public final Builder setStorageHandler(IStorageHandler iStorageHandler) {
            this.storageHandler = iStorageHandler;
            return this;
        }

        public final Builder setStoragePolicy(IStoragePolicy iStoragePolicy) {
            this.storagePolicy = iStoragePolicy;
            return this;
        }
    }

    void clearCacheData(String str);

    void onBackground(long j11);

    void onEvent(String str, List<JSONObject> list, ICallback iCallback);

    void onEvent(String str, List<JSONObject> list, ICallback iCallback, long j11);

    void onEvent(List<Event> list, ICallback iCallback);

    void onEventRecord(String str, List<JSONObject> list, long j11);

    void onForeground(long j11);

    void onReport(IConfig iConfig, String str, ICallback iCallback);

    void onReport(IConfig iConfig, String str, List<?> list, ICallback iCallback);

    void onReport(String str, ICallback iCallback);

    void onStreamEvent(String str, List<JSONObject> list, ICallback iCallback);

    void onStreamEvent(String str, List<JSONObject> list, ICallback iCallback, long j11);

    void setMinSessionDuration(long j11);

    void setNeedRefreshSession(boolean z11);

    void setSessionTimeoutDuration(long j11);
}
