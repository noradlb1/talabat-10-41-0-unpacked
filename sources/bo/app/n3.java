package bo.app;

import com.braze.support.BrazeLogger;
import java.util.List;
import org.json.JSONArray;

public abstract class n3 implements e2 {

    /* renamed from: c  reason: collision with root package name */
    private static final String f39041c = BrazeLogger.getBrazeLogTag((Class<?>) n3.class);

    /* renamed from: b  reason: collision with root package name */
    protected final List<e2> f39042b;

    public n3(List<e2> list) {
        this.f39042b = list;
    }

    /* renamed from: e */
    public JSONArray forJsonPut() {
        JSONArray jSONArray = new JSONArray();
        try {
            for (e2 forJsonPut : this.f39042b) {
                jSONArray.put(forJsonPut.forJsonPut());
            }
        } catch (Exception e11) {
            BrazeLogger.e(f39041c, "Caught exception creating Json.", e11);
        }
        return jSONArray;
    }
}
