package bo.app;

import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0001¢\u0006\u0004\b\u0014\u0010\u0015JD\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004j\u0002`\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J(\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J>\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004j\u0002`\u00062\u0006\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002JP\u0010\r\u001a \u0012\u0004\u0012\u00020\n\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004j\u0002`\u00060\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004j\u0002`\u00062\u0006\u0010\u0011\u001a\u00020\nH\u0016¨\u0006\u0016"}, d2 = {"Lbo/app/m3;", "Lbo/app/k2;", "Lbo/app/v4;", "requestTarget", "", "", "Lcom/braze/communication/HttpHeaders;", "requestHeaders", "Lkotlin/Lazy;", "requestIdentifier", "Lorg/json/JSONObject;", "jsonParams", "", "a", "result", "", "timeInMillis", "payload", "Lkotlin/Pair;", "httpConnector", "<init>", "(Lbo/app/k2;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class m3 implements k2 {

    /* renamed from: a  reason: collision with root package name */
    private final k2 f38971a;

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ v4 f38972b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map<String, String> f38973c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ JSONObject f38974d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(v4 v4Var, Map<String, String> map, JSONObject jSONObject) {
            super(0);
            this.f38972b = v4Var;
            this.f38973c = map;
            this.f38974d = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return v1.a(this.f38972b, this.f38973c, this.f38974d);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ m3 f38975b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ v4 f38976c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Map<String, String> f38977d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Lazy<String> f38978e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ JSONObject f38979f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(m3 m3Var, v4 v4Var, Map<String, String> map, Lazy<String> lazy, JSONObject jSONObject) {
            super(0);
            this.f38975b = m3Var;
            this.f38976c = v4Var;
            this.f38977d = map;
            this.f38978e = lazy;
            this.f38979f = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return this.f38975b.a(this.f38976c, this.f38977d, this.f38978e.getValue(), this.f38979f);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f38980b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Exception while logging request: ";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f38981b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Lazy<String> f38982c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f38983d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(JSONObject jSONObject, Lazy<String> lazy, long j11) {
            super(0);
            this.f38981b = jSONObject;
            this.f38982c = lazy;
            this.f38983d = j11;
        }

        /* renamed from: a */
        public final String invoke() {
            String str;
            JSONObject jSONObject = this.f38981b;
            if (jSONObject == null || (str = JsonUtils.getPrettyPrintedString(jSONObject)) == null) {
                str = "none";
            }
            return "Result(id = " + this.f38982c.getValue() + " time = " + this.f38983d + "ms)\n" + str;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final e f38984b = new e();

        public e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Exception while logging result: ";
        }
    }

    public m3(k2 k2Var) {
        Intrinsics.checkNotNullParameter(k2Var, "httpConnector");
        this.f38971a = k2Var;
    }

    public Pair<JSONObject, Map<String, String>> a(v4 v4Var, Map<String, String> map, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(v4Var, "requestTarget");
        Intrinsics.checkNotNullParameter(map, "requestHeaders");
        Intrinsics.checkNotNullParameter(jSONObject, "payload");
        Lazy lazy = LazyKt__LazyJVMKt.lazy(new a(v4Var, map, jSONObject));
        a(v4Var, map, (Lazy<String>) lazy, jSONObject);
        long currentTimeMillis = System.currentTimeMillis();
        Pair<JSONObject, Map<String, String>> a11 = this.f38971a.a(v4Var, map, jSONObject);
        a(a11.getFirst(), (Lazy<String>) lazy, System.currentTimeMillis() - currentTimeMillis);
        return a11;
    }

    private final void a(v4 v4Var, Map<String, String> map, Lazy<String> lazy, JSONObject jSONObject) {
        try {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new b(this, v4Var, map, lazy, jSONObject), 7, (Object) null);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) c.f38980b, 4, (Object) null);
        }
    }

    private final void a(JSONObject jSONObject, Lazy<String> lazy, long j11) {
        try {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new d(jSONObject, lazy, j11), 7, (Object) null);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) e.f38984b, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final String a(v4 v4Var, Map<String, String> map, String str, JSONObject jSONObject) {
        String str2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\n            |Making request with id => \"");
        sb2.append(str);
        sb2.append("\"\n            |to url: ");
        sb2.append(v4Var);
        sb2.append("\n            \n            |with headers:\n            ");
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            arrayList.add("|\"" + ((String) next.getKey()) + "\" => \"" + ((String) next.getValue()) + '\"');
        }
        sb2.append(CollectionsKt___CollectionsKt.joinToString$default(arrayList, StringUtils.LF, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        sb2.append("\n            |\n            |");
        if (jSONObject == null) {
            str2 = "";
        } else {
            str2 = Intrinsics.stringPlus("and JSON :\n", JsonUtils.getPrettyPrintedString(jSONObject));
        }
        sb2.append(str2);
        sb2.append("\n        ");
        return StringsKt__IndentKt.trimMargin$default(sb2.toString(), (String) null, 1, (Object) null);
    }
}
