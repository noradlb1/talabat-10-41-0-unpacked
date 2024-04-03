package com.huawei.hms.analytics;

import com.huawei.hms.analytics.bg;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.database.LogConfig;
import com.huawei.hms.analytics.database.LogConfigDao;
import com.huawei.hms.analytics.database.LogEvent;
import com.huawei.hms.analytics.framework.policy.IStoragePolicy;
import com.huawei.hms.analytics.type.HALogConfig;
import com.huawei.hms.analytics.type.HAParamType;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.greenrobot.greendao.query.WhereCondition;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final class cv implements Runnable {
    private final by ghi = new by();
    private bi hij;
    private final String ijk;
    private final String ikl = String.valueOf(System.currentTimeMillis());
    private final String klm;
    private final HALogConfig lmn;

    public cv(HALogConfig hALogConfig, String str, String str2) {
        this.lmn = hALogConfig;
        this.klm = str2;
        this.ijk = str;
    }

    private long lmn(LogConfig logConfig) {
        String str;
        long j11;
        JSONObject lmn2 = dm.lmn(this.lmn.getTags());
        String str2 = "";
        if (logConfig != null) {
            if (lmn2 != null) {
                str2 = JSONObjectInstrumentation.toString(lmn2);
            }
            logConfig.setLogTags(str2);
            this.hij.klm(logConfig);
            j11 = logConfig.getId().longValue();
            str = "update indexId: ";
        } else {
            LogConfig logConfig2 = new LogConfig();
            if (lmn2 != null) {
                str2 = JSONObjectInstrumentation.toString(lmn2);
            }
            logConfig2.setLogTags(str2);
            logConfig2.setLogGroupId(this.lmn.getLogGroupId());
            logConfig2.setLogStreamId(this.lmn.getLogStreamId());
            logConfig2.setRegion(this.lmn.getRegion());
            logConfig2.setProjectId(this.lmn.getProjectId());
            j11 = this.hij.lmn(logConfig2);
            str = "insert indexId: ";
        }
        HiLog.d("LogEvtRecord", str.concat(String.valueOf(j11)));
        return j11;
    }

    private void lmn(Long l11) {
        LogEvent logEvent = new LogEvent();
        logEvent.setConfigId(l11);
        logEvent.setEvtTime(this.ikl);
        try {
            JSONObject put = new JSONObject().put(HAParamType.CONTENT, (Object) this.klm);
            logEvent.setContent(!(put instanceof JSONObject) ? put.toString() : JSONObjectInstrumentation.toString(put));
        } catch (JSONException unused) {
            HiLog.w("LogEvtRecord", "setContent json exception");
        }
        logEvent.setEventId(this.ijk);
        this.hij.lmn(logEvent);
    }

    public final void run() {
        try {
            bi lmn2 = bi.lmn();
            this.hij = lmn2;
            LogConfig logConfig = (LogConfig) lmn2.lmn.lmn.queryBuilder().where(LogConfigDao.Properties.klm.eq(this.lmn.getRegion()), new WhereCondition[0]).where(LogConfigDao.Properties.ikl.eq(this.lmn.getProjectId()), new WhereCondition[0]).where(LogConfigDao.Properties.ijk.eq(this.lmn.getLogGroupId()), new WhereCondition[0]).where(LogConfigDao.Properties.hij.eq(this.lmn.getLogStreamId()), new WhereCondition[0]).build().forCurrentThread().unique();
            if (this.ghi.decide(IStoragePolicy.PolicyType.STORAGELENGTH, (Object) "ha_levt.db") || this.hij.klm() > 5000) {
                HiLog.w("LogEvtRecord", "log db file reach max limited size,clear it");
                this.hij.ikl();
                lmn(Long.valueOf(lmn(logConfig)));
                return;
            }
            lmn(Long.valueOf(lmn(logConfig)));
            long klm2 = this.hij.klm();
            HiLog.d("LogEvtRecord", "count: ".concat(String.valueOf(klm2)));
            if (this.ghi.decide(IStoragePolicy.PolicyType.STORAGESIZE, klm2) && this.ghi.decide(IStoragePolicy.PolicyType.NETWORK, (Object) "")) {
                ax axVar = av.lmn().lmn;
                long j11 = axVar.f47865l;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - j11 > 30000) {
                    bl lmn3 = cde.lmn().lmn("_openness_config_tag");
                    if (lmn3 != null) {
                        lmn3.klm();
                        axVar.f47865l = currentTimeMillis;
                        return;
                    }
                    return;
                }
                HiLog.w("LogEvtRecord", "log autoReport timeout. interval < 30s ");
            }
        } catch (bg.lmn unused) {
            HiLog.e("LogEvtRecord", "log db init failed");
        }
    }
}
