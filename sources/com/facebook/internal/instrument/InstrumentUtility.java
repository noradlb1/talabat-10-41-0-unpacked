package com.facebook.internal.instrument;

import androidx.annotation.RestrictTo;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.Utility;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import w6.e;
import w6.f;
import w6.g;

@Instrumented
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0012\u0010\u001d\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\u0012\u0010\u001e\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007J\u0013\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00160 H\u0007¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160 H\u0007¢\u0006\u0002\u0010!J\u0013\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00160 H\u0007¢\u0006\u0002\u0010!J\u001c\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020\u0010H\u0007J$\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u00042\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0007J\u001c\u0010.\u001a\u00020(2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/facebook/internal/instrument/InstrumentUtility;", "", "()V", "ANALYSIS_REPORT_PREFIX", "", "ANR_REPORT_PREFIX", "CODELESS_PREFIX", "CRASH_REPORT_PREFIX", "CRASH_SHIELD_PREFIX", "ERROR_REPORT_PREFIX", "FBSDK_PREFIX", "INSTRUMENT_DIR", "METASDK_PREFIX", "SUGGESTED_EVENTS_PREFIX", "THREAD_CHECK_PREFIX", "deleteFile", "", "filename", "getCause", "e", "", "getInstrumentReportDir", "Ljava/io/File;", "getStackTrace", "thread", "Ljava/lang/Thread;", "isFromFbOrMeta", "element", "Ljava/lang/StackTraceElement;", "isSDKRelatedException", "isSDKRelatedThread", "listAnrReportFiles", "", "()[Ljava/io/File;", "listExceptionAnalysisReportFiles", "listExceptionReportFiles", "readFile", "Lorg/json/JSONObject;", "deleteOnException", "sendReports", "", "key", "reports", "Lorg/json/JSONArray;", "callback", "Lcom/facebook/GraphRequest$Callback;", "writeFile", "content", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class InstrumentUtility {
    @NotNull
    public static final String ANALYSIS_REPORT_PREFIX = "analysis_log_";
    @NotNull
    public static final String ANR_REPORT_PREFIX = "anr_log_";
    @NotNull
    private static final String CODELESS_PREFIX = "com.facebook.appevents.codeless";
    @NotNull
    public static final String CRASH_REPORT_PREFIX = "crash_log_";
    @NotNull
    public static final String CRASH_SHIELD_PREFIX = "shield_log_";
    @NotNull
    public static final String ERROR_REPORT_PREFIX = "error_log_";
    @NotNull
    private static final String FBSDK_PREFIX = "com.facebook";
    @NotNull
    public static final InstrumentUtility INSTANCE = new InstrumentUtility();
    @NotNull
    private static final String INSTRUMENT_DIR = "instrument";
    @NotNull
    private static final String METASDK_PREFIX = "com.meta";
    @NotNull
    private static final String SUGGESTED_EVENTS_PREFIX = "com.facebook.appevents.suggestedevents";
    @NotNull
    public static final String THREAD_CHECK_PREFIX = "thread_check_log_";

    private InstrumentUtility() {
    }

    @JvmStatic
    public static final boolean deleteFile(@Nullable String str) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null || str == null) {
            return false;
        }
        return new File(instrumentReportDir, str).delete();
    }

    @JvmStatic
    @Nullable
    public static final String getCause(@Nullable Throwable th2) {
        if (th2 == null) {
            return null;
        }
        if (th2.getCause() == null) {
            return th2.toString();
        }
        return String.valueOf(th2.getCause());
    }

    @JvmStatic
    @Nullable
    public static final File getInstrumentReportDir() {
        File file = new File(FacebookSdk.getApplicationContext().getCacheDir(), INSTRUMENT_DIR);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    @JvmStatic
    @Nullable
    public static final String getStackTrace(@Nullable Throwable th2) {
        Throwable th3 = null;
        if (th2 == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        while (th2 != null && th2 != th3) {
            StackTraceElement[] stackTrace = th2.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "t.stackTrace");
            int length = stackTrace.length;
            int i11 = 0;
            while (i11 < length) {
                StackTraceElement stackTraceElement = stackTrace[i11];
                i11++;
                jSONArray.put((Object) stackTraceElement.toString());
            }
            th3 = th2;
            th2 = th2.getCause();
        }
        return JSONArrayInstrumentation.toString(jSONArray);
    }

    @JvmStatic
    public static final boolean isFromFbOrMeta(@NotNull StackTraceElement stackTraceElement) {
        Intrinsics.checkNotNullParameter(stackTraceElement, "element");
        String className = stackTraceElement.getClassName();
        Intrinsics.checkNotNullExpressionValue(className, "element.className");
        if (!StringsKt__StringsJVMKt.startsWith$default(className, FBSDK_PREFIX, false, 2, (Object) null)) {
            String className2 = stackTraceElement.getClassName();
            Intrinsics.checkNotNullExpressionValue(className2, "element.className");
            if (StringsKt__StringsJVMKt.startsWith$default(className2, METASDK_PREFIX, false, 2, (Object) null)) {
                return true;
            }
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean isSDKRelatedException(@Nullable Throwable th2) {
        if (th2 == null) {
            return false;
        }
        Throwable th3 = null;
        while (th2 != null && th2 != th3) {
            StackTraceElement[] stackTrace = th2.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "t.stackTrace");
            int length = stackTrace.length;
            int i11 = 0;
            while (i11 < length) {
                StackTraceElement stackTraceElement = stackTrace[i11];
                i11++;
                Intrinsics.checkNotNullExpressionValue(stackTraceElement, "element");
                if (isFromFbOrMeta(stackTraceElement)) {
                    return true;
                }
            }
            th3 = th2;
            th2 = th2.getCause();
        }
        return false;
    }

    @JvmStatic
    public static final boolean isSDKRelatedThread(@Nullable Thread thread) {
        StackTraceElement[] stackTrace;
        if (!(thread == null || (stackTrace = thread.getStackTrace()) == null)) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                Intrinsics.checkNotNullExpressionValue(stackTraceElement, "element");
                if (isFromFbOrMeta(stackTraceElement)) {
                    String className = stackTraceElement.getClassName();
                    Intrinsics.checkNotNullExpressionValue(className, "element.className");
                    if (!StringsKt__StringsJVMKt.startsWith$default(className, CODELESS_PREFIX, false, 2, (Object) null)) {
                        String className2 = stackTraceElement.getClassName();
                        Intrinsics.checkNotNullExpressionValue(className2, "element.className");
                        if (!StringsKt__StringsJVMKt.startsWith$default(className2, SUGGESTED_EVENTS_PREFIX, false, 2, (Object) null)) {
                            return true;
                        }
                    }
                    String methodName = stackTraceElement.getMethodName();
                    Intrinsics.checkNotNullExpressionValue(methodName, "element.methodName");
                    if (!StringsKt__StringsJVMKt.startsWith$default(methodName, "onClick", false, 2, (Object) null)) {
                        String methodName2 = stackTraceElement.getMethodName();
                        Intrinsics.checkNotNullExpressionValue(methodName2, "element.methodName");
                        if (!StringsKt__StringsJVMKt.startsWith$default(methodName2, "onItemClick", false, 2, (Object) null)) {
                            String methodName3 = stackTraceElement.getMethodName();
                            Intrinsics.checkNotNullExpressionValue(methodName3, "element.methodName");
                            if (!StringsKt__StringsJVMKt.startsWith$default(methodName3, "onTouch", false, 2, (Object) null)) {
                                return true;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return false;
    }

    @JvmStatic
    @NotNull
    public static final File[] listAnrReportFiles() {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] listFiles = instrumentReportDir.listFiles(new g());
        if (listFiles == null) {
            return new File[0];
        }
        return listFiles;
    }

    /* access modifiers changed from: private */
    /* renamed from: listAnrReportFiles$lambda-1  reason: not valid java name */
    public static final boolean m8974listAnrReportFiles$lambda1(File file, String str) {
        Intrinsics.checkNotNullExpressionValue(str, "name");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{ANR_REPORT_PREFIX}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return new Regex(format).matches(str);
    }

    @JvmStatic
    @NotNull
    public static final File[] listExceptionAnalysisReportFiles() {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] listFiles = instrumentReportDir.listFiles(new f());
        if (listFiles == null) {
            return new File[0];
        }
        return listFiles;
    }

    /* access modifiers changed from: private */
    /* renamed from: listExceptionAnalysisReportFiles$lambda-2  reason: not valid java name */
    public static final boolean m8975listExceptionAnalysisReportFiles$lambda2(File file, String str) {
        Intrinsics.checkNotNullExpressionValue(str, "name");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{ANALYSIS_REPORT_PREFIX}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return new Regex(format).matches(str);
    }

    @JvmStatic
    @NotNull
    public static final File[] listExceptionReportFiles() {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] listFiles = instrumentReportDir.listFiles(new e());
        if (listFiles == null) {
            return new File[0];
        }
        return listFiles;
    }

    /* access modifiers changed from: private */
    /* renamed from: listExceptionReportFiles$lambda-3  reason: not valid java name */
    public static final boolean m8976listExceptionReportFiles$lambda3(File file, String str) {
        Intrinsics.checkNotNullExpressionValue(str, "name");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("^(%s|%s|%s)[0-9]+.json$", Arrays.copyOf(new Object[]{CRASH_REPORT_PREFIX, CRASH_SHIELD_PREFIX, THREAD_CHECK_PREFIX}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return new Regex(format).matches(str);
    }

    @JvmStatic
    @Nullable
    public static final JSONObject readFile(@Nullable String str, boolean z11) {
        File instrumentReportDir = getInstrumentReportDir();
        if (!(instrumentReportDir == null || str == null)) {
            try {
                return new JSONObject(Utility.readStreamToString(new FileInputStream(new File(instrumentReportDir, str))));
            } catch (Exception unused) {
                if (z11) {
                    deleteFile(str);
                }
            }
        }
        return null;
    }

    @JvmStatic
    public static final void sendReports(@Nullable String str, @NotNull JSONArray jSONArray, @Nullable GraphRequest.Callback callback) {
        Intrinsics.checkNotNullParameter(jSONArray, "reports");
        if (jSONArray.length() != 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(str, (Object) JSONArrayInstrumentation.toString(jSONArray));
                JSONObject dataProcessingOptions = Utility.getDataProcessingOptions();
                if (dataProcessingOptions != null) {
                    Iterator<String> keys = dataProcessingOptions.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.put(next, dataProcessingOptions.get(next));
                    }
                }
                GraphRequest.Companion companion = GraphRequest.Companion;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%s/instruments", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                companion.newPostRequest((AccessToken) null, format, jSONObject, callback).executeAsync();
            } catch (JSONException unused) {
            }
        }
    }

    @JvmStatic
    public static final void writeFile(@Nullable String str, @Nullable String str2) {
        File instrumentReportDir = getInstrumentReportDir();
        if (instrumentReportDir != null && str != null && str2 != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(instrumentReportDir, str));
                byte[] bytes = str2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                fileOutputStream.write(bytes);
                fileOutputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    @JvmStatic
    @Nullable
    public static final String getStackTrace(@NotNull Thread thread) {
        Intrinsics.checkNotNullParameter(thread, "thread");
        StackTraceElement[] stackTrace = thread.getStackTrace();
        JSONArray jSONArray = new JSONArray();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
        int length = stackTrace.length;
        int i11 = 0;
        while (i11 < length) {
            StackTraceElement stackTraceElement = stackTrace[i11];
            i11++;
            jSONArray.put((Object) stackTraceElement.toString());
        }
        return JSONArrayInstrumentation.toString(jSONArray);
    }
}
