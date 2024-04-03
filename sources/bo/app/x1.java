package bo.app;

import com.braze.models.IPutIntoJson;
import com.newrelic.agent.android.instrumentation.Instrumented;
import kotlin.Metadata;
import org.json.JSONObject;

@Instrumented
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fR\u0014\u0010\u0006\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\n8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00128&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u000f\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\fø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001dÀ\u0006\u0001"}, d2 = {"Lbo/app/x1;", "Lcom/braze/models/IPutIntoJson;", "Lorg/json/JSONObject;", "Lbo/app/c1;", "j", "()Lbo/app/c1;", "type", "k", "()Lorg/json/JSONObject;", "data", "", "r", "()Ljava/lang/String;", "uniqueIdentifier", "getUserId", "a", "(Ljava/lang/String;)V", "userId", "Lbo/app/j5;", "n", "()Lbo/app/j5;", "(Lbo/app/j5;)V", "sessionId", "", "d", "()Z", "isNonPersistable", "p", "serialization", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public interface x1 extends IPutIntoJson<JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f39550a = a.f39551a;

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lbo/app/x1$a;", "", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f39551a = new a();

        private a() {
        }
    }

    void a(j5 j5Var);

    void a(String str);

    boolean d();

    c1 j();

    JSONObject k();

    j5 n();

    String p();

    String r();
}
