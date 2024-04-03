package bo.app;

import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001:\u0001!B\u0011\b\u0014\u0012\u0006\u0010#\u001a\u00020\u0006¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\n\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\tR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lbo/app/o6;", "Lbo/app/b3;", "Lbo/app/w2;", "event", "", "b", "Lorg/json/JSONObject;", "e", "x", "()Z", "isWithinTimeWindow", "w", "isPastStartDate", "v", "isNotExpired", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lbo/app/r2;", "scheduleConfig", "Lbo/app/r2;", "f", "()Lbo/app/r2;", "shouldPrefetchAssets", "Z", "m", "Lbo/app/l6;", "triggerMetadata", "Lbo/app/l6;", "i", "()Lbo/app/l6;", "a", "(Lbo/app/l6;)V", "json", "<init>", "(Lorg/json/JSONObject;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public abstract class o6 implements b3 {

    /* renamed from: g  reason: collision with root package name */
    public static final a f39114g = new a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final String f39115b;

    /* renamed from: c  reason: collision with root package name */
    private final r2 f39116c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f39117d;

    /* renamed from: e  reason: collision with root package name */
    private l6 f39118e;

    /* renamed from: f  reason: collision with root package name */
    private final List<v2> f39119f;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lbo/app/o6$a;", "", "", "ID", "Ljava/lang/String;", "PREFETCH", "TRIGGER_CONDITIONS", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
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
        final /* synthetic */ o6 f39120b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ w2 f39121c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(o6 o6Var, w2 w2Var) {
            super(0);
            this.f39120b = o6Var;
            this.f39121c = w2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Triggered action " + this.f39120b.getId() + " not eligible to be triggered by " + this.f39121c.d() + " event. Current device time outside triggered action time window.";
        }
    }

    public o6(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        ArrayList arrayList = new ArrayList();
        this.f39119f = arrayList;
        String string = jSONObject.getString("id");
        Intrinsics.checkNotNullExpressionValue(string, "json.getString(ID)");
        this.f39115b = string;
        this.f39116c = new w4(jSONObject);
        JSONArray jSONArray = jSONObject.getJSONArray("trigger_condition");
        if (jSONArray.length() > 0) {
            m6 m6Var = m6.f38991a;
            Intrinsics.checkNotNullExpressionValue(jSONArray, "triggers");
            arrayList.addAll(m6Var.a(jSONArray));
        }
        this.f39117d = jSONObject.optBoolean("prefetch", true);
    }

    private final boolean v() {
        return this.f39116c.h() == -1 || DateTimeUtils.nowInSeconds() < this.f39116c.h();
    }

    private final boolean w() {
        return this.f39116c.c() == -1 || DateTimeUtils.nowInSeconds() > this.f39116c.c();
    }

    private final boolean x() {
        return w() && v();
    }

    public void a(l6 l6Var) {
        this.f39118e = l6Var;
    }

    public boolean b(w2 w2Var) {
        Intrinsics.checkNotNullParameter(w2Var, "event");
        if (!x()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new b(this, w2Var), 7, (Object) null);
            return false;
        }
        Iterator<v2> it = this.f39119f.iterator();
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                i11 = -1;
                break;
            } else if (it.next().a(w2Var)) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 != -1) {
            return true;
        }
        return false;
    }

    public JSONObject e() {
        try {
            JSONObject jSONObject = (JSONObject) this.f39116c.forJsonPut();
            if (jSONObject == null) {
                return null;
            }
            jSONObject.put("id", (Object) this.f39115b);
            JSONArray jSONArray = new JSONArray();
            for (v2 forJsonPut : this.f39119f) {
                jSONArray.put(forJsonPut.forJsonPut());
            }
            jSONObject.put("trigger_condition", (Object) jSONArray);
            jSONObject.put("prefetch", this.f39117d);
            return jSONObject;
        } catch (JSONException unused) {
        }
    }

    public final r2 f() {
        return this.f39116c;
    }

    public final String getId() {
        return this.f39115b;
    }

    public l6 i() {
        return this.f39118e;
    }

    public final boolean m() {
        return this.f39117d;
    }
}
