package bo.app;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0011\b\u0014\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lbo/app/q6;", "Lbo/app/o6;", "", "", "remoteAssetToLocalAssetPaths", "", "a", "y", "()Ljava/util/Map;", "remoteAssetToLocalAssetMap", "Lorg/json/JSONObject;", "json", "<init>", "(Lorg/json/JSONObject;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public abstract class q6 extends o6 {

    /* renamed from: h  reason: collision with root package name */
    private Map<String, String> f39230h = new LinkedHashMap();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q6(JSONObject jSONObject) {
        super(jSONObject);
        Intrinsics.checkNotNullParameter(jSONObject, "json");
    }

    public void a(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "remoteAssetToLocalAssetPaths");
        this.f39230h = new HashMap(map);
    }

    public Map<String, String> y() {
        return MapsKt__MapsKt.toMap(this.f39230h);
    }
}
