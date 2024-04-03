package com.instabug.apm.model;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.apm.cache.model.c;
import com.instabug.apm.configuration.c;
import com.instabug.library.apichecker.APIChecker;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import org.json.JSONObject;
import tb.b;

public class ExecutionTrace implements Parcelable {
    public static final Parcelable.Creator<ExecutionTrace> CREATOR = new a();
    private final transient com.instabug.apm.logger.internal.a apmLogger;
    @NonNull
    private final Map<String, String> attrs;
    private long endTimeMicro;
    private boolean endedInBackground;
    private final transient com.instabug.apm.handler.executiontraces.a executionTracesHandler;
    private final transient Executor executor;

    /* renamed from: id  reason: collision with root package name */
    private final long f45481id;
    private boolean isEnded;

    /* renamed from: name  reason: collision with root package name */
    private final String f45482name;
    private final long startTime;
    private final long startTimeMicro;
    private boolean startedInBackground;

    public class a implements Parcelable.Creator<ExecutionTrace> {
        /* renamed from: a */
        public ExecutionTrace createFromParcel(Parcel parcel) {
            return new ExecutionTrace(parcel);
        }

        /* renamed from: a */
        public ExecutionTrace[] newArray(int i11) {
            return new ExecutionTrace[i11];
        }
    }

    @SuppressLint({"ERADICATE_FIELD_NOT_NULLABLE"})
    public ExecutionTrace(Parcel parcel) {
        this.executor = com.instabug.apm.di.a.b("execution_traces_thread_executor");
        this.executionTracesHandler = com.instabug.apm.di.a.A();
        this.apmLogger = com.instabug.apm.di.a.f();
        this.endTimeMicro = -1;
        this.isEnded = false;
        this.f45481id = parcel.readLong();
        int readInt = parcel.readInt();
        this.attrs = new LinkedHashMap(readInt);
        for (int i11 = 0; i11 < readInt; i11++) {
            this.attrs.put(parcel.readString(), parcel.readString());
        }
        this.f45482name = parcel.readString();
        this.startTime = parcel.readLong();
        this.startTimeMicro = parcel.readLong();
        this.endTimeMicro = parcel.readLong();
    }

    public ExecutionTrace(String str) {
        this.executor = com.instabug.apm.di.a.b("execution_traces_thread_executor");
        this.executionTracesHandler = com.instabug.apm.di.a.A();
        com.instabug.apm.logger.internal.a f11 = com.instabug.apm.di.a.f();
        this.apmLogger = f11;
        this.endTimeMicro = -1;
        boolean z11 = false;
        this.isEnded = false;
        this.f45481id = new Random().nextLong();
        this.attrs = new LinkedHashMap();
        this.f45482name = str;
        this.startTimeMicro = System.nanoTime() / 1000;
        this.startTime = System.currentTimeMillis() * 1000;
        this.startedInBackground = com.instabug.apm.di.a.W().b() == null ? true : z11;
        f11.d("Execution trace " + str + " has started.");
    }

    private boolean isAtrributeKeyValid(String str) {
        if (str == null || str.trim().isEmpty()) {
            this.apmLogger.b("Trace attribute wasn't added to \"$s\". Trace attribute key can't be null or empty string.".replace("$s", this.f45482name));
            return false;
        } else if (str.trim().length() <= 30) {
            return true;
        } else {
            this.apmLogger.b("Trace attribute \"$s1\" wasn't added to \"$s2\" as it was too long. Please limit attribute key names to 30 characters.".replace("$s1", str).replace("$s2", this.f45482name));
            return false;
        }
    }

    private boolean isAttributeValueValid(String str, String str2) {
        com.instabug.apm.logger.internal.a aVar;
        String str3;
        String trim = str2.trim();
        if (trim.length() == 0) {
            aVar = this.apmLogger;
            str3 = "Trace attribute \"$s1\" wasn't added to \"$s2\". Trace attribute value can't be empty string.";
        } else if (trim.length() > 60) {
            aVar = this.apmLogger;
            str3 = "Trace attribute \"$s1\" wasn't added to \"$s2\" as its value was too long. Please limit trace attribute values to 60 characters.";
        } else if (!this.isEnded) {
            return true;
        } else {
            aVar = this.apmLogger;
            str3 = "Trace attribute \"$s1\" wasn't added to \"$s2\" because attribute was added after the trace had already ended.";
        }
        aVar.b(str3.replace("$s1", str).replace("$s2", this.f45482name));
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$end$0() {
        com.instabug.apm.logger.internal.a aVar;
        String str;
        String str2;
        c c11 = com.instabug.apm.di.a.c();
        if (!c11.H()) {
            aVar = this.apmLogger;
            str = this.f45482name;
            str2 = "Execution trace \"$s\" wasn't saved. Please make sure to enable APM first by following the instructions at this link: https://docs.instabug.com/reference#enable-or-disable-apm";
        } else if (!c11.b0()) {
            aVar = this.apmLogger;
            str = this.f45482name;
            str2 = "Execution trace \"$s\" wasn't saved as the feature seems to be disabled for your Instabug company account. Please contact support for more information.";
        } else {
            long j11 = this.endTimeMicro - this.startTimeMicro;
            this.executionTracesHandler.a(new c.a(this.f45482name, this.f45481id).b(this.startedInBackground).a((Map) this.attrs).a(j11).a(this.endedInBackground).b(this.startTime).a((Map) this.attrs).a());
            com.instabug.apm.logger.internal.a aVar2 = this.apmLogger;
            aVar2.d("Execution trace " + this.f45482name + " has ended.\nTotal duration: " + j11 + " ms\nAttributes: " + new JSONObject((Map<?, ?>) this.attrs));
            this.isEnded = true;
            return;
        }
        aVar.b(str2.replace("$s", str));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$end$1() {
        this.executor.execute(new tb.c(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setAttribute$2(String str, String str2) {
        if (isAtrributeKeyValid(str)) {
            String trim = str.trim();
            if (str2 == null) {
                this.attrs.remove(trim);
            } else if (isAttributeValueValid(trim, str2)) {
                int N = com.instabug.apm.di.a.c().N();
                if (this.attrs.size() == N) {
                    com.instabug.apm.logger.internal.a aVar = this.apmLogger;
                    String replace = "Trace attribute \"$s1\" wasn't added to \"$s2\". Max allowed trace attributes reached. Please note that you can add up to \"$s3\" attributes to the same trace.".replace("$s1", str).replace("$s2", this.f45482name);
                    aVar.b(replace.replace("$s3", N + ""));
                    return;
                }
                this.attrs.put(trim, str2.trim());
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public void end() {
        this.endTimeMicro = System.nanoTime() / 1000;
        this.endedInBackground = com.instabug.apm.di.a.W().b() == null;
        APIChecker.checkAndRunInExecutor("ExecutionTrace.end", new b(this));
    }

    @MainThread
    public synchronized void setAttribute(@NonNull String str, @Nullable String str2) {
        this.executor.execute(new tb.a(this, str, str2));
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.f45481id);
        parcel.writeInt(this.attrs.size());
        for (Map.Entry next : this.attrs.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
        parcel.writeString(this.f45482name);
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.startTimeMicro);
        parcel.writeLong(this.endTimeMicro);
    }
}
