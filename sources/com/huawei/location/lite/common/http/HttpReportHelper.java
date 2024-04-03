package com.huawei.location.lite.common.http;

import android.os.Bundle;
import com.google.gson.Gson;
import com.huawei.location.lite.common.http.request.BaseRequest;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.plug.IPluginResult;
import com.huawei.location.lite.common.plug.PluginManager;
import com.huawei.location.lite.common.plug.PluginReqMessage;
import com.huawei.location.lite.common.report.ReportBuilder;
import com.huawei.location.lite.common.report.Tracker;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.lite.common.util.SDKComponentType;
import com.huawei.location.lite.common.util.StringUtil;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
public class HttpReportHelper {
    private static final String LOCATION_SERVER_API = "Location_serverApi";
    private static final int MAX_PATH_LENGTH = 60;
    private static final String TAG = "CommonDataHandler";
    private ReportBuilder reportBuilder;

    public HttpReportHelper(ReportBuilder reportBuilder2) {
        this.reportBuilder = reportBuilder2;
        initReport();
    }

    private void initReport() {
        if (this.reportBuilder == null) {
            this.reportBuilder = new ReportBuilder();
        }
        this.reportBuilder.setCallTime();
    }

    public void reportHttpResult(BaseRequest baseRequest, String str, String str2) {
        ReportBuilder reportBuilder2;
        if (baseRequest == null) {
            LogConsole.e(TAG, "request param exception");
            return;
        }
        if (this.reportBuilder == null) {
            this.reportBuilder = new ReportBuilder();
        }
        this.reportBuilder.setApiName(LOCATION_SERVER_API);
        this.reportBuilder.setTransactionID(baseRequest.getHeads().get("X-Request-ID"));
        String path = baseRequest.getPath();
        if (path.length() > 60) {
            reportBuilder2 = this.reportBuilder;
            path = path.substring(0, 60);
        } else {
            reportBuilder2 = this.reportBuilder;
        }
        reportBuilder2.setRequestUrl(path);
        if (!StringUtil.isEmpty(str)) {
            this.reportBuilder.setErrorCode(str);
        }
        if (!StringUtil.isEmpty(str2)) {
            this.reportBuilder.setErrorMessage(str2);
        }
        this.reportBuilder.setCostTime();
        try {
            if (SDKComponentType.getComponentType() == 100) {
                Tracker.getInstance().onMaintEvent(this.reportBuilder);
                Tracker.getInstance().onOperationEvent(this.reportBuilder);
                return;
            }
            PluginReqMessage pluginReqMessage = new PluginReqMessage();
            Gson instance = GsonUtil.getInstance();
            ReportBuilder reportBuilder3 = this.reportBuilder;
            pluginReqMessage.setData(!(instance instanceof Gson) ? instance.toJson((Object) reportBuilder3) : GsonInstrumentation.toJson(instance, (Object) reportBuilder3));
            Bundle bundle = new Bundle();
            bundle.putString("report_type", "server_report");
            pluginReqMessage.setExtraData(bundle);
            PluginManager.getInstance().startFunction(102, "report", pluginReqMessage, (IPluginResult) null);
        } catch (Exception unused) {
            LogConsole.e(TAG, "reportHttpResult exception");
        }
    }
}
