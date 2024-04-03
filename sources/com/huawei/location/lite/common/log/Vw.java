package com.huawei.location.lite.common.log;

import android.os.Bundle;
import com.google.gson.Gson;
import com.huawei.location.lite.common.plug.IPluginResult;
import com.huawei.location.lite.common.plug.PluginManager;
import com.huawei.location.lite.common.plug.PluginReqMessage;
import com.huawei.location.lite.common.report.HiAnalyticsConstant;
import com.huawei.location.lite.common.report.ReportBuilder;
import com.huawei.location.lite.common.report.Tracker;
import com.huawei.location.lite.common.util.CollectionsUtils;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.lite.common.util.SDKComponentType;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.CharUtils;

@Instrumented
public class Vw {
    private static int FB;
    private static byte[] Vw = new byte[2048];

    /* renamed from: yn  reason: collision with root package name */
    private static final byte[] f50147yn = new byte[0];

    public static String a(List<String> list) {
        StringBuffer stringBuffer = new StringBuffer();
        if (CollectionsUtils.isEmpty((Collection<?>) list)) {
            stringBuffer.append("|");
            stringBuffer.append(CharUtils.CR);
            stringBuffer.append(10);
        } else {
            for (int i11 = 0; i11 < list.size(); i11++) {
                if (i11 != list.size() - 1) {
                    stringBuffer.append("|");
                    stringBuffer.append(list.get(i11));
                } else {
                    stringBuffer.append(CharUtils.CR);
                    stringBuffer.append(10);
                }
            }
        }
        return stringBuffer.toString();
    }

    public static void b(String str, byte[] bArr) {
        boolean z11;
        String str2;
        if (bArr.length + FB + 1 > 2048) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            ReportBuilder reportBuilder = new ReportBuilder();
            reportBuilder.setTag(str);
            String str3 = "";
            int i11 = FB;
            if (i11 > 0) {
                try {
                    byte[] bArr2 = Vw;
                    int i12 = i11 + 1;
                    if (i12 > 2048) {
                        i12 = 2048;
                    }
                    str3 = new String(bArr2, 0, i12, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                    LogConsole.w("LogCache", "toString() UnsupportedEncodingException");
                }
            }
            reportBuilder.setErrorMessage(str3);
            if (SDKComponentType.getComponentType() == 200) {
                PluginReqMessage pluginReqMessage = new PluginReqMessage();
                Gson instance = GsonUtil.getInstance();
                if (!(instance instanceof Gson)) {
                    str2 = instance.toJson((Object) reportBuilder);
                } else {
                    str2 = GsonInstrumentation.toJson(instance, (Object) reportBuilder);
                }
                pluginReqMessage.setData(str2);
                Bundle bundle = new Bundle();
                bundle.putString("report_type", "event");
                pluginReqMessage.setExtraData(bundle);
                PluginManager.getInstance().startFunction(102, "report", pluginReqMessage, (IPluginResult) null);
            } else {
                Tracker.getInstance().onEvent(1, HiAnalyticsConstant.LOCATION_LOG_EVENT, reportBuilder.build());
            }
            synchronized (f50147yn) {
                Vw = new byte[2048];
                FB = 0;
            }
        }
        synchronized (f50147yn) {
            for (byte b11 : bArr) {
                int i13 = FB;
                if (i13 >= 0 && i13 < 2048) {
                    Vw[i13] = b11;
                    FB = i13 + 1;
                }
            }
        }
    }

    public static byte[] c(String str, String str2) {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        byte[] bArr = new byte[0];
        try {
            return (format + "|" + str + "|" + str2 + CharUtils.CR + 10).getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            LogConsole.w("LogCache", "putStr() UnsupportedEncodingException");
            return bArr;
        }
    }

    public static byte[] d(String str, List<String> list) {
        String str2;
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        byte[] bArr = new byte[0];
        try {
            if (CollectionsUtils.isEmpty((Collection<?>) list)) {
                str2 = format + "|" + str + CharUtils.CR + 10;
            } else {
                StringBuffer stringBuffer = new StringBuffer(format);
                for (int i11 = 0; i11 < list.size(); i11++) {
                    if (i11 != list.size() - 1) {
                        stringBuffer.append("|");
                        stringBuffer.append(list.get(i11));
                    } else {
                        stringBuffer.append(CharUtils.CR);
                        stringBuffer.append(10);
                    }
                }
                str2 = stringBuffer.toString();
            }
            return str2.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            LogConsole.w("LogCache", "putStr() UnsupportedEncodingException");
            return bArr;
        }
    }
}
