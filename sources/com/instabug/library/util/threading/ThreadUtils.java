package com.instabug.library.util.threading;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.facebook.internal.security.CertificateUtil;
import com.instabug.library.util.InstabugSDKLogger;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ThreadUtils {
    public static String buildStackTraceFromElements(StackTraceElement[] stackTraceElementArr, @Nullable String str) {
        StringBuilder sb2 = new StringBuilder();
        if (str != null) {
            sb2.append(str);
            sb2.append(StringUtils.LF);
        }
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb2.append("\t at ");
            sb2.append(stackTraceElement.toString());
            sb2.append(StringUtils.LF);
        }
        return sb2.toString();
    }

    public static StackTraceElement[] getCurrentThreadStackTrace() {
        return Thread.currentThread().getStackTrace();
    }

    public static JSONObject getMainThreadData(@Nullable String str) throws JSONException {
        JSONObject threadData = getThreadData(Looper.getMainLooper().getThread());
        threadData.put("error", (Object) getStackTraceAsError(Looper.getMainLooper().getThread(), str));
        return threadData;
    }

    private static String getMainThreadStackTrace(String str) {
        return buildStackTraceFromElements(Looper.getMainLooper().getThread().getStackTrace(), str);
    }

    private static JSONObject getStackTraceAsError(Thread thread, @Nullable String str) {
        StackTraceElement stackTraceElement;
        String str2;
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            try {
                jSONObject.put("name", (Object) "ANRError: Application Not Responding for at least 5000 ms.\n");
                jSONObject.put("exception", (Object) str);
            } catch (JSONException e11) {
                if (e11.getMessage() != null) {
                    str2 = e11.getMessage();
                } else {
                    str2 = "Json exception while creating formatted exception";
                }
                InstabugSDKLogger.e("IBG-Core", str2, e11);
            }
        }
        thread.getStackTrace();
        if (thread.getStackTrace().length > 0) {
            stackTraceElement = thread.getStackTrace()[0];
        } else {
            stackTraceElement = null;
        }
        if (!(stackTraceElement == null || stackTraceElement.getFileName() == null)) {
            jSONObject.put("location", (Object) stackTraceElement.getFileName() + CertificateUtil.DELIMITER + stackTraceElement.getLineNumber());
        }
        if (str == null) {
            str = "";
        }
        jSONObject.put("stackTrace", (Object) getMainThreadStackTrace(str));
        return jSONObject;
    }

    public static String getStackTraceFromThread(Thread thread) {
        StringBuilder sb2 = new StringBuilder();
        for (StackTraceElement stackTraceElement : thread.getStackTrace()) {
            sb2.append("\t at ");
            sb2.append(stackTraceElement.toString());
            sb2.append(StringUtils.LF);
        }
        return sb2.toString();
    }

    public static JSONObject getThreadData(Thread thread) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("threadName", (Object) thread.getName());
        jSONObject2.put("threadId", thread.getId());
        jSONObject2.put("threadPriority", thread.getPriority());
        jSONObject2.put("threadState", (Object) thread.getState().toString());
        ThreadGroup threadGroup = thread.getThreadGroup();
        if (threadGroup != null) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("name", (Object) threadGroup.getName());
            jSONObject3.put("maxPriority", threadGroup.getMaxPriority());
            jSONObject3.put("activeCount", threadGroup.activeCount());
            jSONObject2.put("threadGroup", (Object) jSONObject3);
        }
        jSONObject.put("thread", (Object) jSONObject2);
        return jSONObject;
    }

    public static JSONObject getThreadDataAndStackTrace(Thread thread, Throwable th2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("crashed", true);
        jSONObject.put("threadId", thread.getId());
        jSONObject.put("isMain", isMainThread(thread));
        jSONObject.put("stackTrace", (Object) th2.getStackTrace());
        return jSONObject;
    }

    public static JSONArray getThreadsData(@Nullable Thread thread) throws JSONException {
        boolean z11;
        JSONArray jSONArray = new JSONArray();
        for (Thread thread2 : o.a().keySet()) {
            JSONObject threadData = getThreadData(thread2);
            ((JSONObject) threadData.get("thread")).put("isMain", isMainThread(thread2));
            ((JSONObject) threadData.get("thread")).put("stackTrace", (Object) getStackTraceFromThread(thread2));
            JSONObject jSONObject = (JSONObject) threadData.get("thread");
            if (thread2 == thread) {
                z11 = true;
            } else {
                z11 = false;
            }
            jSONObject.put("isCrashing", z11);
            jSONArray.put((Object) threadData);
        }
        return jSONArray;
    }

    public static boolean isCurrentThreadMain() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static boolean isMainThread(Thread thread) {
        return Looper.getMainLooper() != null && thread == Looper.getMainLooper().getThread();
    }
}
