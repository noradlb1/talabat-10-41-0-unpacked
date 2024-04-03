package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0005B#\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\n¨\u0006\u0012"}, d2 = {"Lbo/app/p5;", "Lbo/app/t2;", "Lorg/json/JSONObject;", "jsonObject", "", "a", "Lbo/app/h5;", "session", "", "sessionId", "()Lbo/app/h5;", "storedOpenSession", "Landroid/content/Context;", "context", "userId", "apiKey", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class p5 implements t2 {

    /* renamed from: b  reason: collision with root package name */
    public static final a f39183b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f39184a;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lbo/app/p5$a;", "", "", "SESSION_STORAGE_FILENAME", "Ljava/lang/String;", "STORED_OPEN_SESSION_KEY", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f39185b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to set end time to now for session json data";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f39186b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "No stored open session in storage.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f39187b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not create new mutable session for open session.";
        }
    }

    public p5(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f39184a = context.getSharedPreferences(Intrinsics.stringPlus("com.appboy.storage.session_storage", StringUtils.getCacheFileSuffix(context, str, str2)), 0);
    }

    public h5 a() {
        String str = "";
        if (!this.f39184a.contains("current_open_session")) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) c.f39186b, 7, (Object) null);
            return null;
        }
        try {
            String string = this.f39184a.getString(this.f39184a.getString("current_open_session", str), str);
            if (string != null) {
                str = string;
            }
            return new h5(new JSONObject(str));
        } catch (JSONException e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) d.f39187b, 4, (Object) null);
            return null;
        }
    }

    public void a(h5 h5Var) {
        Intrinsics.checkNotNullParameter(h5Var, SDKCoreEvent.Session.TYPE_SESSION);
        String j5Var = h5Var.n().toString();
        JSONObject e11 = h5Var.forJsonPut();
        SharedPreferences.Editor edit = this.f39184a.edit();
        a(e11);
        edit.putString(j5Var, !(e11 instanceof JSONObject) ? e11.toString() : JSONObjectInstrumentation.toString(e11));
        if (!h5Var.y()) {
            edit.putString("current_open_session", j5Var);
        } else if (Intrinsics.areEqual((Object) this.f39184a.getString("current_open_session", ""), (Object) j5Var)) {
            edit.remove("current_open_session");
        }
        edit.apply();
    }

    public void a(String str) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        SharedPreferences.Editor edit = this.f39184a.edit();
        edit.remove(str);
        if (Intrinsics.areEqual((Object) str, (Object) this.f39184a.getString("current_open_session", (String) null))) {
            edit.remove("current_open_session");
        }
        edit.apply();
    }

    private final void a(JSONObject jSONObject) {
        if (!jSONObject.has("end_time")) {
            try {
                jSONObject.put("end_time", DateTimeUtils.nowInSecondsPrecise());
            } catch (JSONException e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) b.f39185b, 4, (Object) null);
            }
        }
    }
}
