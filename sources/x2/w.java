package x2;

import bo.app.x1;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final /* synthetic */ class w {
    public static String a(x1 x1Var) {
        JSONObject jSONObject = (JSONObject) x1Var.forJsonPut();
        String jSONObject2 = !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "forJsonPut().toString()");
        return jSONObject2;
    }
}
