package com.facebook.internal.instrument.errorreport;

import androidx.annotation.RestrictTo;
import com.facebook.internal.instrument.InstrumentUtility;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Instrumented
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0014\u001a\u00020\u0015J\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0000H\u0002J\u0006\u0010\u0019\u001a\u00020\u0015J\b\u0010\u001a\u001a\u00020\u0003H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/facebook/internal/instrument/errorreport/ErrorReportData;", "", "message", "", "(Ljava/lang/String;)V", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "errorMessage", "filename", "isValid", "", "()Z", "parameters", "Lorg/json/JSONObject;", "getParameters", "()Lorg/json/JSONObject;", "timestamp", "", "Ljava/lang/Long;", "clear", "", "compareTo", "", "data", "save", "toString", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ErrorReportData {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String PARAM_TIMESTAMP = "timestamp";
    @NotNull
    private static final String PRARAM_ERROR_MESSAGE = "error_message";
    @Nullable
    private String errorMessage;
    @NotNull
    private String filename;
    @Nullable
    private Long timestamp;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/instrument/errorreport/ErrorReportData$Companion;", "", "()V", "PARAM_TIMESTAMP", "", "PRARAM_ERROR_MESSAGE", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ErrorReportData(@Nullable String str) {
        this.timestamp = Long.valueOf(System.currentTimeMillis() / ((long) 1000));
        this.errorMessage = str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(InstrumentUtility.ERROR_REPORT_PREFIX);
        Long l11 = this.timestamp;
        if (l11 != null) {
            stringBuffer.append(l11.longValue());
            stringBuffer.append(".json");
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(stringBuffer2, "StringBuffer()\n            .append(InstrumentUtility.ERROR_REPORT_PREFIX)\n            .append(timestamp as Long)\n            .append(\".json\")\n            .toString()");
            this.filename = stringBuffer2;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    }

    public final void clear() {
        InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
        InstrumentUtility.deleteFile(this.filename);
    }

    public final int compareTo(@NotNull ErrorReportData errorReportData) {
        Intrinsics.checkNotNullParameter(errorReportData, "data");
        Long l11 = this.timestamp;
        if (l11 == null) {
            return -1;
        }
        long longValue = l11.longValue();
        Long l12 = errorReportData.timestamp;
        if (l12 == null) {
            return 1;
        }
        return Intrinsics.compare(l12.longValue(), longValue);
    }

    @Nullable
    public final JSONObject getParameters() {
        JSONObject jSONObject = new JSONObject();
        try {
            Long l11 = this.timestamp;
            if (l11 != null) {
                jSONObject.put("timestamp", (Object) l11);
            }
            jSONObject.put("error_message", (Object) this.errorMessage);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final boolean isValid() {
        return (this.errorMessage == null || this.timestamp == null) ? false : true;
    }

    public final void save() {
        if (isValid()) {
            InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
            InstrumentUtility.writeFile(this.filename, toString());
        }
    }

    @NotNull
    public String toString() {
        JSONObject parameters = getParameters();
        if (parameters == null) {
            return super.toString();
        }
        String jSONObjectInstrumentation = JSONObjectInstrumentation.toString(parameters);
        Intrinsics.checkNotNullExpressionValue(jSONObjectInstrumentation, "params.toString()");
        return jSONObjectInstrumentation;
    }

    public ErrorReportData(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        String name2 = file.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "file.name");
        this.filename = name2;
        JSONObject readFile = InstrumentUtility.readFile(name2, true);
        if (readFile != null) {
            this.timestamp = Long.valueOf(readFile.optLong("timestamp", 0));
            this.errorMessage = readFile.optString("error_message", (String) null);
        }
    }
}
