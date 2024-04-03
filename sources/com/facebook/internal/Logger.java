package com.facebook.internal;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00052\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0016\"\u00020\u0001¢\u0006\u0002\u0010\u0017J\u0012\u0010\u0011\u001a\u00020\u00122\n\u0010\u0018\u001a\u00060\bj\u0002`\tJ\u0016\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0001J\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001c\u001a\u00020\u0012J\u000e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\b\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bj\u0002`\tX\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/facebook/internal/Logger;", "", "behavior", "Lcom/facebook/LoggingBehavior;", "tag", "", "(Lcom/facebook/LoggingBehavior;Ljava/lang/String;)V", "contents", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "value", "", "priority", "getPriority", "()I", "setPriority", "(I)V", "append", "", "string", "format", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "stringBuilder", "appendKeyValue", "key", "getContents", "log", "logString", "shouldLog", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Logger {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String LOG_TAG_BASE = "FacebookSDK.";
    /* access modifiers changed from: private */
    @NotNull
    public static final HashMap<String, String> stringsToReplace = new HashMap<>();
    @NotNull
    private final LoggingBehavior behavior;
    @NotNull
    private StringBuilder contents;
    private int priority = 3;
    @NotNull
    private final String tag;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0007JA\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0012\"\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0013J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J9\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0012\"\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0004H\u0007J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0007J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/facebook/internal/Logger$Companion;", "", "()V", "LOG_TAG_BASE", "", "stringsToReplace", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "log", "", "behavior", "Lcom/facebook/LoggingBehavior;", "priority", "", "tag", "string", "format", "args", "", "(Lcom/facebook/LoggingBehavior;ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "registerAccessToken", "accessToken", "registerStringToReplace", "original", "replace", "replaceStrings", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final synchronized String replaceStrings(String str) {
            String str2;
            str2 = str;
            for (Map.Entry entry : Logger.stringsToReplace.entrySet()) {
                str2 = StringsKt__StringsJVMKt.replace$default(str2, (String) entry.getKey(), (String) entry.getValue(), false, 4, (Object) null);
            }
            return str2;
        }

        @JvmStatic
        public final void log(@NotNull LoggingBehavior loggingBehavior, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(loggingBehavior, "behavior");
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(str2, TypedValues.Custom.S_STRING);
            log(loggingBehavior, 3, str, str2);
        }

        @JvmStatic
        public final synchronized void registerAccessToken(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "accessToken");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
                registerStringToReplace(str, "ACCESS_TOKEN_REMOVED");
            }
        }

        @JvmStatic
        public final synchronized void registerStringToReplace(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "original");
            Intrinsics.checkNotNullParameter(str2, "replace");
            Logger.stringsToReplace.put(str, str2);
        }

        @JvmStatic
        public final void log(@NotNull LoggingBehavior loggingBehavior, @NotNull String str, @NotNull String str2, @NotNull Object... objArr) {
            Intrinsics.checkNotNullParameter(loggingBehavior, "behavior");
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(str2, "format");
            Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
            if (FacebookSdk.isLoggingBehaviorEnabled(loggingBehavior)) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                String format = String.format(str2, Arrays.copyOf(copyOf, copyOf.length));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                log(loggingBehavior, 3, str, format);
            }
        }

        @JvmStatic
        public final void log(@NotNull LoggingBehavior loggingBehavior, int i11, @NotNull String str, @NotNull String str2, @NotNull Object... objArr) {
            Intrinsics.checkNotNullParameter(loggingBehavior, "behavior");
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(str2, "format");
            Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
            if (FacebookSdk.isLoggingBehaviorEnabled(loggingBehavior)) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                String format = String.format(str2, Arrays.copyOf(copyOf, copyOf.length));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                log(loggingBehavior, i11, str, format);
            }
        }

        @JvmStatic
        public final void log(@NotNull LoggingBehavior loggingBehavior, int i11, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(loggingBehavior, "behavior");
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(str2, TypedValues.Custom.S_STRING);
            if (FacebookSdk.isLoggingBehaviorEnabled(loggingBehavior)) {
                String replaceStrings = replaceStrings(str2);
                if (!StringsKt__StringsJVMKt.startsWith$default(str, Logger.LOG_TAG_BASE, false, 2, (Object) null)) {
                    str = Intrinsics.stringPlus(Logger.LOG_TAG_BASE, str);
                }
                Log.println(i11, str, replaceStrings);
                if (loggingBehavior == LoggingBehavior.DEVELOPER_ERRORS) {
                    new Exception().printStackTrace();
                }
            }
        }
    }

    public Logger(@NotNull LoggingBehavior loggingBehavior, @NotNull String str) {
        Intrinsics.checkNotNullParameter(loggingBehavior, "behavior");
        Intrinsics.checkNotNullParameter(str, "tag");
        this.behavior = loggingBehavior;
        this.tag = Intrinsics.stringPlus(LOG_TAG_BASE, Validate.notNullOrEmpty(str, "tag"));
        this.contents = new StringBuilder();
    }

    @JvmStatic
    public static final void log(@NotNull LoggingBehavior loggingBehavior, int i11, @NotNull String str, @NotNull String str2) {
        Companion.log(loggingBehavior, i11, str, str2);
    }

    @JvmStatic
    public static final void log(@NotNull LoggingBehavior loggingBehavior, int i11, @NotNull String str, @NotNull String str2, @NotNull Object... objArr) {
        Companion.log(loggingBehavior, i11, str, str2, objArr);
    }

    @JvmStatic
    public static final void log(@NotNull LoggingBehavior loggingBehavior, @NotNull String str, @NotNull String str2) {
        Companion.log(loggingBehavior, str, str2);
    }

    @JvmStatic
    public static final void log(@NotNull LoggingBehavior loggingBehavior, @NotNull String str, @NotNull String str2, @NotNull Object... objArr) {
        Companion.log(loggingBehavior, str, str2, objArr);
    }

    @JvmStatic
    public static final synchronized void registerAccessToken(@NotNull String str) {
        synchronized (Logger.class) {
            Companion.registerAccessToken(str);
        }
    }

    @JvmStatic
    public static final synchronized void registerStringToReplace(@NotNull String str, @NotNull String str2) {
        synchronized (Logger.class) {
            Companion.registerStringToReplace(str, str2);
        }
    }

    private final boolean shouldLog() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return FacebookSdk.isLoggingBehaviorEnabled(this.behavior);
    }

    public final void append(@NotNull StringBuilder sb2) {
        Intrinsics.checkNotNullParameter(sb2, "stringBuilder");
        if (shouldLog()) {
            this.contents.append(sb2);
        }
    }

    public final void appendKeyValue(@NotNull String str, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(obj, "value");
        append("  %s:\t%s\n", str, obj);
    }

    @NotNull
    public final String getContents() {
        Companion companion = Companion;
        String sb2 = this.contents.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "contents.toString()");
        return companion.replaceStrings(sb2);
    }

    public final int getPriority() {
        return this.priority;
    }

    public final void log() {
        String sb2 = this.contents.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "contents.toString()");
        logString(sb2);
        this.contents = new StringBuilder();
    }

    public final void logString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        Companion.log(this.behavior, this.priority, this.tag, str);
    }

    public final void setPriority(int i11) {
        Validate validate = Validate.INSTANCE;
        Validate.oneOf(Integer.valueOf(i11), "value", 7, 3, 6, 4, 2, 5);
        setPriority(i11);
    }

    public final void append(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        if (shouldLog()) {
            this.contents.append(str);
        }
    }

    public final void append(@NotNull String str, @NotNull Object... objArr) {
        Intrinsics.checkNotNullParameter(str, "format");
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        if (shouldLog()) {
            StringBuilder sb2 = this.contents;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
            String format = String.format(str, Arrays.copyOf(copyOf, copyOf.length));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            sb2.append(format);
        }
    }
}
