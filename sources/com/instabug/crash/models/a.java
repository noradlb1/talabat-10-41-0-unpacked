package com.instabug.crash.models;

import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.commons.models.Incident;
import com.instabug.commons.models.IncidentMetadata;
import com.instabug.crash.models.IBGNonFatalException;
import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.model.Attachment;
import com.instabug.library.model.State;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class a implements Incident, Cacheable {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f46405a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f46406b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f46407c;

    /* renamed from: d  reason: collision with root package name */
    private List f46408d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private State f46409e;

    /* renamed from: f  reason: collision with root package name */
    private C0057a f46410f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f46411g;

    /* renamed from: h  reason: collision with root package name */
    private int f46412h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private String f46413i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private String f46414j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private IBGNonFatalException.Level f46415k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private IncidentMetadata f46416l;

    /* renamed from: com.instabug.crash.models.a$a  reason: collision with other inner class name */
    public enum C0057a {
        READY_TO_BE_SENT,
        LOGS_READY_TO_BE_UPLOADED,
        ATTACHMENTS_READY_TO_BE_UPLOADED,
        NOT_AVAILABLE,
        WAITING_FOR_SCREEN_RECORDING_TO_BE_TRIMMED
    }

    public static class b {
        @SuppressLint({"CheckResult"})
        public a a(State state) {
            return a(System.currentTimeMillis() + "", state, IncidentMetadata.Factory.create());
        }

        public a a(@NonNull String str, @NonNull IncidentMetadata incidentMetadata) {
            return new a(str, incidentMetadata);
        }

        public a a(@NonNull String str, @NonNull State state, @NonNull IncidentMetadata incidentMetadata) {
            State h11;
            a aVar = new a(str, state, incidentMetadata);
            if (InstabugCore.getFeatureState(Feature.REPRO_STEPS) == Feature.State.ENABLED && (h11 = aVar.h()) != null) {
                h11.updateVisualUserSteps();
            }
            return aVar;
        }
    }

    public a(@NonNull IncidentMetadata incidentMetadata) {
        this.f46410f = C0057a.NOT_AVAILABLE;
        this.f46408d = new CopyOnWriteArrayList();
        this.f46416l = incidentMetadata;
    }

    public a a(String str) {
        this.f46407c = str;
        return this;
    }

    @Nullable
    public String b() {
        return this.f46407c;
    }

    public a c(String str) {
        this.f46405a = str;
        return this;
    }

    public a d(String str) {
        this.f46406b = str;
        return this;
    }

    @Nullable
    public String e() {
        return this.f46405a;
    }

    @SuppressLint({"NP_METHOD_PARAMETER_TIGHTENS_ANNOTATION"})
    public boolean equals(@Nullable Object obj) {
        if (obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (String.valueOf(aVar.e()).equals(String.valueOf(e())) && String.valueOf(aVar.b()).equals(String.valueOf(b())) && String.valueOf(aVar.i()).equals(String.valueOf(i())) && aVar.c() == c() && aVar.h() != null && aVar.h().equals(h()) && aVar.k() == k() && aVar.g() == g() && aVar.a() != null && aVar.a().size() == a().size() && (((aVar.j() == null && j() == null) || (aVar.j() != null && aVar.j().equals(j()))) && (((aVar.d() == null && d() == null) || (aVar.d() != null && aVar.d().equals(d()))) && ((aVar.f() == null && f() == null) || (aVar.f() != null && aVar.f().equals(f())))))) {
                for (int i11 = 0; i11 < aVar.a().size(); i11++) {
                    if (!((Attachment) aVar.a().get(i11)).equals(a().get(i11))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Nullable
    public IBGNonFatalException.Level f() {
        return this.f46415k;
    }

    public void fromJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("id")) {
            c(jSONObject.getString("id"));
        }
        if (jSONObject.has("temporary_server_token")) {
            d(jSONObject.getString("temporary_server_token"));
        }
        if (jSONObject.has(InstabugDbContract.CrashEntry.COLUMN_CRASH_MESSAGE)) {
            a(jSONObject.getString(InstabugDbContract.CrashEntry.COLUMN_CRASH_MESSAGE));
        }
        if (jSONObject.has("crash_state")) {
            a(C0057a.valueOf(jSONObject.getString("crash_state")));
        }
        if (jSONObject.has("state")) {
            State state = new State();
            state.fromJson(jSONObject.getString("state"));
            a(state);
        }
        if (jSONObject.has(InstabugDbContract.AttachmentEntry.TABLE_NAME)) {
            a((List) Attachment.fromJson(jSONObject.getJSONArray(InstabugDbContract.AttachmentEntry.TABLE_NAME)));
        }
        if (jSONObject.has(InstabugDbContract.CrashEntry.COLUMN_HANDLED)) {
            a(jSONObject.getBoolean(InstabugDbContract.CrashEntry.COLUMN_HANDLED));
        }
        if (jSONObject.has(InstabugDbContract.CrashEntry.COLUMN_RETRY_COUNT)) {
            b(jSONObject.getInt(InstabugDbContract.CrashEntry.COLUMN_RETRY_COUNT));
        }
        if (jSONObject.has(InstabugDbContract.CrashEntry.COLUMN_THREADS_DETAILS)) {
            e(jSONObject.getString(InstabugDbContract.CrashEntry.COLUMN_THREADS_DETAILS));
        }
        if (jSONObject.has("fingerprint")) {
            b(jSONObject.getString("fingerprint"));
        }
        if (jSONObject.has("level")) {
            a(jSONObject.getInt("level"));
        }
    }

    public int g() {
        return this.f46412h;
    }

    @NonNull
    public IncidentMetadata getMetadata() {
        return this.f46416l;
    }

    @NonNull
    public Incident.Type getType() {
        if (this.f46411g) {
            return Incident.Type.NonFatalCrash;
        }
        return Incident.Type.FatalCrash;
    }

    @Nullable
    public State h() {
        return this.f46409e;
    }

    public int hashCode() {
        if (e() != null) {
            return e().hashCode();
        }
        return -1;
    }

    @Nullable
    public String i() {
        return this.f46406b;
    }

    @Nullable
    public String j() {
        return this.f46413i;
    }

    public boolean k() {
        return this.f46411g;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", (Object) e()).put("temporary_server_token", (Object) i()).put(InstabugDbContract.CrashEntry.COLUMN_CRASH_MESSAGE, (Object) b()).put("crash_state", (Object) c().toString()).put(InstabugDbContract.AttachmentEntry.TABLE_NAME, (Object) Attachment.toJson(a())).put(InstabugDbContract.CrashEntry.COLUMN_HANDLED, k()).put(InstabugDbContract.CrashEntry.COLUMN_RETRY_COUNT, g()).put(InstabugDbContract.CrashEntry.COLUMN_THREADS_DETAILS, (Object) j()).put("fingerprint", (Object) d());
        IBGNonFatalException.Level f11 = f();
        if (f11 != null) {
            jSONObject.put("level", f11.getSeverity());
        }
        if (h() != null) {
            jSONObject.put("state", (Object) h().toJson());
        } else {
            InstabugSDKLogger.e("IBG-CR", "Error parsing crash: state is null");
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    public String toString() {
        return "Internal Id: " + this.f46405a + ", TemporaryServerToken:" + this.f46406b + ", crashMessage:" + this.f46407c + ", handled:" + this.f46411g + ", retryCount:" + this.f46412h + ", threadsDetails:" + this.f46413i + ", fingerprint:" + this.f46414j + ", level:" + this.f46415k;
    }

    public a a(Uri uri) {
        return a(uri, Attachment.Type.ATTACHMENT_FILE);
    }

    public void b(int i11) {
        this.f46412h = i11;
    }

    public C0057a c() {
        return this.f46410f;
    }

    @Nullable
    public String d() {
        return this.f46414j;
    }

    public a e(@Nullable String str) {
        this.f46413i = str;
        return this;
    }

    public a a(Uri uri, Attachment.Type type) {
        if (uri == null) {
            InstabugSDKLogger.w("IBG-CR", "Adding attachment with a null Uri, ignored.");
            return this;
        }
        Attachment attachment = new Attachment();
        if (uri.getLastPathSegment() != null) {
            attachment.setName(uri.getLastPathSegment());
        }
        if (uri.getPath() != null) {
            attachment.setLocalPath(uri.getPath());
        }
        attachment.setType(type);
        if (type == Attachment.Type.VISUAL_USER_STEPS) {
            attachment.setEncrypted(true);
        }
        this.f46408d.add(attachment);
        return this;
    }

    public void b(@Nullable String str) {
        this.f46414j = str;
    }

    public a(@NonNull String str, @NonNull IncidentMetadata incidentMetadata) {
        this(incidentMetadata);
        this.f46405a = str;
    }

    public a(@NonNull String str, @NonNull State state, @NonNull IncidentMetadata incidentMetadata) {
        this(incidentMetadata);
        this.f46405a = str;
        this.f46409e = state;
        this.f46412h = 0;
    }

    public List a() {
        return this.f46408d;
    }

    public a a(@NonNull List list) {
        this.f46408d = new CopyOnWriteArrayList(list);
        return this;
    }

    public a a(State state) {
        this.f46409e = state;
        return this;
    }

    public a a(C0057a aVar) {
        this.f46410f = aVar;
        return this;
    }

    public a a(boolean z11) {
        this.f46411g = z11;
        return this;
    }

    public void a(@Nullable IBGNonFatalException.Level level) {
        this.f46415k = level;
    }

    public void a(int i11) {
        this.f46415k = IBGNonFatalException.Level.parse(i11);
    }
}
