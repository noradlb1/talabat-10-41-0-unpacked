package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONObjectInstrumentation {
    private static final ArrayList<String> categoryParams = new ArrayList<>(Arrays.asList(new String[]{"category", MetricCategory.class.getName(), "JSON"}));

    @TraceConstructor
    public static JSONObject init(String str) throws JSONException {
        if (str != null) {
            try {
                TraceMachine.enterMethod((Trace) null, "JSONObject#<init>", categoryParams);
                JSONObject jSONObject = new JSONObject(str);
                TraceMachine.exitMethod();
                return jSONObject;
            } catch (JSONException e11) {
                TraceMachine.exitMethod();
                throw e11;
            }
        } else {
            throw new JSONException("Failed to initialize JSONObject: json string is null.");
        }
    }

    @ReplaceCallSite(scope = "org.json.JSONObject")
    public static String toString(JSONObject jSONObject) {
        TraceMachine.enterMethod((Trace) null, "JSONObject#toString", categoryParams);
        String jSONObject2 = jSONObject.toString();
        TraceMachine.exitMethod();
        return jSONObject2;
    }

    @ReplaceCallSite(scope = "org.json.JSONObject")
    public static String toString(JSONObject jSONObject, int i11) throws JSONException {
        try {
            TraceMachine.enterMethod((Trace) null, "JSONObject#toString", categoryParams);
            String jSONObject2 = jSONObject.toString(i11);
            TraceMachine.exitMethod();
            return jSONObject2;
        } catch (JSONException e11) {
            TraceMachine.exitMethod();
            throw e11;
        }
    }
}
