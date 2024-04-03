package fc;

import com.instabug.crash.CrashReporting;
import com.instabug.crash.models.IBGNonFatalException;
import java.util.Map;
import org.json.JSONObject;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JSONObject f47101b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f47102c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ JSONObject f47103d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ IBGNonFatalException.Level f47104e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Map f47105f;

    public /* synthetic */ h(JSONObject jSONObject, boolean z11, JSONObject jSONObject2, IBGNonFatalException.Level level, Map map) {
        this.f47101b = jSONObject;
        this.f47102c = z11;
        this.f47103d = jSONObject2;
        this.f47104e = level;
        this.f47105f = map;
    }

    public final void run() {
        CrashReporting.lambda$reportException$5(this.f47101b, this.f47102c, this.f47103d, this.f47104e, this.f47105f);
    }
}
