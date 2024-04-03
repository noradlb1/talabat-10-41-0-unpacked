package com.huawei.wisesecurity.kfs.interceptors;

import android.os.Build;
import android.util.Log;
import com.huawei.hms.framework.network.restclient.hwhttp.Interceptor;
import com.huawei.hms.framework.network.restclient.hwhttp.RealInterceptorChain;
import com.huawei.hms.framework.network.restclient.hwhttp.Request;
import com.huawei.hms.framework.network.restclient.hwhttp.Response;
import com.huawei.wisesecurity.kfs.exception.ParamException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ReqHeaderInterceptor implements Interceptor {
    public static final String ANDROID_API_LEVEL_TITLE = "X-Android-Api-Level";
    public static final String APP_ID_TITLE = "X-App-ID";
    public static final String APP_PACKAGE_NAME_TITLE = "appPkgName";
    public static final String CALL_TIME_TITLE = "callTime";
    public static final String CLIENT_VERSION_TITLE = "X-Client-Version";
    public static final String EMUI_API_LEVEL_TITLE = "X-Emui-Api-Level";
    public static final String KEYPAIR_SEPARATOR = ",";
    public static final String KEY_VALUE_SEPARATOR = "=";
    public static final String REQUEST_CONTEXT_TITLE = "X-Request-Context";
    public static final String TAG = ReqHeaderInterceptor.class.getSimpleName();
    public static final String TERMINAL_TITLE = "X-Terminal";
    public static final String TERMINAL_TYPE_TITLE = "terminalType";
    public String appId;
    public final Map<String, String> headers;
    public String packageName;
    public String serviceVersion;
    public TerminalType terminalType;

    public ReqHeaderInterceptor(Map<String, String> map, String str, String str2, String str3, TerminalType terminalType2) throws ParamException {
        HashMap hashMap = new HashMap();
        this.headers = hashMap;
        ArgumentChecker.checkNonNull(map);
        ArgumentChecker.checkHeaderValue(map);
        ArgumentChecker.checkHeaderValue(str);
        ArgumentChecker.checkHeaderValue(str2);
        ArgumentChecker.checkHeaderValue(str3);
        ArgumentChecker.checkNonNull(terminalType2);
        this.appId = str;
        this.packageName = str2;
        this.serviceVersion = str3;
        this.terminalType = terminalType2;
        hashMap.putAll(map);
    }

    private void addAndroidHeader(Request.Builder builder) {
        builder.addHeader(EMUI_API_LEVEL_TITLE, getSystemProperties("ro.build.version.emui", ""));
        builder.addHeader(ANDROID_API_LEVEL_TITLE, "" + Build.VERSION.SDK_INT);
        builder.addHeader(APP_ID_TITLE, this.appId);
        builder.addHeader(TERMINAL_TYPE_TITLE, Build.MODEL);
        builder.addHeader("appPkgName", this.packageName);
    }

    private void addCommomHeader(Request.Builder builder) {
        for (Map.Entry next : this.headers.entrySet()) {
            builder.addHeader((String) next.getKey(), (String) next.getValue());
        }
        builder.addHeader(CLIENT_VERSION_TITLE, this.serviceVersion);
        builder.addHeader(TERMINAL_TITLE, this.terminalType.getValue());
        String valueOf = String.valueOf(System.currentTimeMillis());
        builder.addHeader("callTime", valueOf);
        builder.addHeader(REQUEST_CONTEXT_TITLE, TERMINAL_TYPE_TITLE + "=" + Build.MODEL + "," + "callTime" + "=" + valueOf);
    }

    public static String getSystemProperties(String str, String str2) {
        Class<String> cls = String.class;
        try {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            Object invoke = cls2.getDeclaredMethod("get", new Class[]{cls, cls}).invoke(cls2, new Object[]{str, str2});
            if (invoke instanceof String) {
                return (String) invoke;
            }
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            String str3 = TAG;
            Log.e(str3, "An exception occurred while reading SystemProperties: " + str);
        }
        return str2;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request.Builder newBuilder = realInterceptorChain.request().newBuilder();
        addCommomHeader(newBuilder);
        if (TerminalType.ANDROID == this.terminalType) {
            addAndroidHeader(newBuilder);
        }
        return realInterceptorChain.proceed(newBuilder.build());
    }
}
