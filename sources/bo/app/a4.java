package bo.app;

import com.braze.models.IPutIntoJson;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0015\u0016B1\b\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0005R\u0014\u0010\f\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lbo/app/a4;", "Lcom/braze/models/IPutIntoJson;", "Lorg/json/JSONObject;", "Lbo/app/i2;", "v", "", "w", "y", "x", "z", "e", "()Z", "isEmpty", "", "userId", "containsRespondWithFeed", "containsRespondWithTriggers", "Lbo/app/z3;", "outboundConfigParams", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lbo/app/z3;)V", "a", "b", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class a4 implements IPutIntoJson<JSONObject>, i2 {

    /* renamed from: f  reason: collision with root package name */
    public static final b f38268f = new b((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final String f38269b;

    /* renamed from: c  reason: collision with root package name */
    private final Boolean f38270c;

    /* renamed from: d  reason: collision with root package name */
    private final Boolean f38271d;

    /* renamed from: e  reason: collision with root package name */
    private final z3 f38272e;

    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0004\u001a\u00020\u0000J\u0006\u0010\u0005\u001a\u00020\u0000J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\tR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\b\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\b\u0010\u0013R$\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0004\u0010\u0013R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0004\u0010\u0019¨\u0006\u001c"}, d2 = {"Lbo/app/a4$a;", "", "", "userId", "b", "c", "Lbo/app/z3;", "outboundConfigParams", "a", "Lbo/app/a4;", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "", "containsRespondWithFeed", "Ljava/lang/Boolean;", "getContainsRespondWithFeed", "()Ljava/lang/Boolean;", "(Ljava/lang/Boolean;)V", "containsRespondWithTriggers", "getContainsRespondWithTriggers", "Lbo/app/z3;", "getOutboundConfigParams", "()Lbo/app/z3;", "(Lbo/app/z3;)V", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lbo/app/z3;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private String f38273a;

        /* renamed from: b  reason: collision with root package name */
        private Boolean f38274b;

        /* renamed from: c  reason: collision with root package name */
        private Boolean f38275c;

        /* renamed from: d  reason: collision with root package name */
        private z3 f38276d;

        public a(String str, Boolean bool, Boolean bool2, z3 z3Var) {
            this.f38273a = str;
            this.f38274b = bool;
            this.f38275c = bool2;
            this.f38276d = z3Var;
        }

        public final void a(String str) {
            this.f38273a = str;
        }

        public final void b(Boolean bool) {
            this.f38275c = bool;
        }

        public final a c() {
            b(Boolean.TRUE);
            return this;
        }

        public final void a(Boolean bool) {
            this.f38274b = bool;
        }

        public final void b(z3 z3Var) {
            this.f38276d = z3Var;
        }

        public final a a(z3 z3Var) {
            Intrinsics.checkNotNullParameter(z3Var, "outboundConfigParams");
            b(z3Var);
            return this;
        }

        public final a b(String str) {
            a(str);
            return this;
        }

        public final a4 a() {
            return new a4(this.f38273a, this.f38274b, this.f38275c, this.f38276d, (DefaultConstructorMarker) null);
        }

        public final a b() {
            a(Boolean.TRUE);
            return this;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(String str, Boolean bool, Boolean bool2, z3 z3Var, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : bool, (i11 & 4) != 0 ? null : bool2, (i11 & 8) != 0 ? null : z3Var);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lbo/app/a4$b;", "", "", "RESPOND_WITH_CONFIG_KEY", "Ljava/lang/String;", "RESPOND_WITH_FEED_KEY", "RESPOND_WITH_TRIGGERS_KEY", "USER_ID_KEY", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private a4(String str, Boolean bool, Boolean bool2, z3 z3Var) {
        this.f38269b = str;
        this.f38270c = bool;
        this.f38271d = bool2;
        this.f38272e = z3Var;
    }

    public /* synthetic */ a4(String str, Boolean bool, Boolean bool2, z3 z3Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bool, bool2, z3Var);
    }

    public boolean e() {
        z3 z3Var;
        JSONObject v11 = forJsonPut();
        if (v11.length() == 0) {
            return true;
        }
        if (this.f38270c == null && this.f38271d == null && (z3Var = this.f38272e) != null) {
            return z3Var.e();
        }
        if (v11.length() == 1) {
            return v11.has("user_id");
        }
        return false;
    }

    /* renamed from: v */
    public JSONObject forJsonPut() {
        boolean z11;
        JSONObject jSONObject = new JSONObject();
        String str = this.f38269b;
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            jSONObject.put("user_id", (Object) this.f38269b);
        }
        Boolean bool = this.f38270c;
        if (bool != null) {
            jSONObject.put("feed", bool.booleanValue());
        }
        Boolean bool2 = this.f38271d;
        if (bool2 != null) {
            jSONObject.put("triggers", bool2.booleanValue());
        }
        z3 z3Var = this.f38272e;
        if (z3Var != null) {
            jSONObject.put(DarkstoresMainActivity.CONFIG_EXTRA_KEY, (Object) z3Var.forJsonPut());
        }
        return jSONObject;
    }

    public final boolean w() {
        return this.f38272e != null;
    }

    public final boolean x() {
        return this.f38270c != null;
    }

    public final boolean y() {
        return this.f38271d != null;
    }

    public final boolean z() {
        String str = this.f38269b;
        return !(str == null || str.length() == 0);
    }
}
