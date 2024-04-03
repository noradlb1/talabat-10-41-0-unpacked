package bo.app;

import com.braze.models.IPutIntoJson;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u000eB\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lbo/app/z3;", "Lcom/braze/models/IPutIntoJson;", "Lorg/json/JSONObject;", "Lbo/app/i2;", "v", "", "e", "()Z", "isEmpty", "", "lastConfigUnixTimestampSeconds", "isFirstTimeConfigRequest", "<init>", "(JZ)V", "a", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class z3 implements IPutIntoJson<JSONObject>, i2 {

    /* renamed from: d  reason: collision with root package name */
    public static final a f39630d = new a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final long f39631b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f39632c;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lbo/app/z3$a;", "", "", "CONFIG_TIME_KEY", "Ljava/lang/String;", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public z3(long j11, boolean z11) {
        this.f39631b = j11;
        this.f39632c = z11;
    }

    public boolean e() {
        return !this.f39632c;
    }

    /* renamed from: v */
    public JSONObject forJsonPut() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("config_time", this.f39631b);
        return jSONObject;
    }
}
