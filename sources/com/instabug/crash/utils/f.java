package com.instabug.crash.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.internal.security.CertificateUtil;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.agentdata.HexAttribute;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class f {
    public static JSONObject a(@NonNull Throwable th2, @Nullable String str) {
        JSONObject jSONObject = new JSONObject();
        if (th2 == null) {
            return jSONObject;
        }
        try {
            String name2 = th2.getClass().getName();
            if (str != null) {
                name2 = name2 + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + str;
            }
            jSONObject.put("name", (Object) name2);
            StackTraceElement stackTraceElement = (th2.getStackTrace() == null || th2.getStackTrace().length <= 0) ? null : th2.getStackTrace()[0];
            if (stackTraceElement == null || stackTraceElement.getFileName() == null) {
                InstabugSDKLogger.w("IBG-CR", "Incomplete crash stacktrace, if you're using Proguard, add the following line to your configuration file to have file name and line number in your crash report:");
                InstabugSDKLogger.w("IBG-CR", "-keepattributes SourceFile,LineNumberTable");
            } else {
                jSONObject.put("location", (Object) stackTraceElement.getFileName() + CertificateUtil.DELIMITER + stackTraceElement.getLineNumber());
            }
            jSONObject.put("exception", (Object) th2.toString());
            if (th2.getMessage() != null) {
                jSONObject.put("message", (Object) th2.getMessage());
            }
            jSONObject.put("stackTrace", (Object) a(th2));
            if (th2.getCause() != null) {
                jSONObject.put(HexAttribute.HEX_ATTR_CAUSE, (Object) a(th2.getCause(), str));
            }
        } catch (JSONException e11) {
            InstabugSDKLogger.e("IBG-CR", e11.getMessage() != null ? e11.getMessage() : "Json exception while creating formatted exception", e11);
        }
        return jSONObject;
    }

    public static String a(Throwable th2) {
        StringBuilder sb2 = new StringBuilder(th2.toString());
        sb2.append(StringUtils.LF);
        for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
            sb2.append("\t at ");
            sb2.append(stackTraceElement.toString());
            sb2.append(StringUtils.LF);
        }
        return sb2.toString();
    }
}
