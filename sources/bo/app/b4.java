package bo.app;

import com.braze.models.IPutIntoJson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lbo/app/b4;", "Lcom/braze/models/IPutIntoJson;", "Lorg/json/JSONArray;", "Lbo/app/i2;", "v", "Lorg/json/JSONObject;", "userObject", "Lorg/json/JSONObject;", "w", "()Lorg/json/JSONObject;", "", "e", "()Z", "isEmpty", "<init>", "(Lorg/json/JSONObject;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class b4 implements IPutIntoJson<JSONArray>, i2 {

    /* renamed from: b  reason: collision with root package name */
    private final JSONObject f38309b;

    /* renamed from: c  reason: collision with root package name */
    private final JSONArray f38310c;

    public b4(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "userObject");
        this.f38309b = jSONObject;
        this.f38310c = new JSONArray().put((Object) jSONObject);
    }

    public boolean e() {
        if (this.f38309b.length() == 0) {
            return true;
        }
        if (this.f38309b.length() != 1 || !this.f38309b.has("user_id")) {
            return false;
        }
        return true;
    }

    /* renamed from: v */
    public JSONArray forJsonPut() {
        JSONArray jSONArray = this.f38310c;
        Intrinsics.checkNotNullExpressionValue(jSONArray, "jsonArrayForJsonPut");
        return jSONArray;
    }

    public final JSONObject w() {
        return this.f38309b;
    }
}
