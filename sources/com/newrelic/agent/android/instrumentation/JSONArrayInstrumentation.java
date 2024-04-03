package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;

public class JSONArrayInstrumentation {
    private static final ArrayList<String> categoryParams = new ArrayList<>(Arrays.asList(new String[]{"category", MetricCategory.class.getName(), "JSON"}));

    @TraceConstructor
    public static JSONArray init(String str) throws JSONException {
        if (str != null) {
            try {
                TraceMachine.enterMethod("JSONArray#<init>", categoryParams);
                JSONArray jSONArray = new JSONArray(str);
                TraceMachine.exitMethod();
                return jSONArray;
            } catch (JSONException e11) {
                TraceMachine.exitMethod();
                throw e11;
            }
        } else {
            throw new JSONException("Failed to initialize JSONArray: json string is null.");
        }
    }

    @ReplaceCallSite(scope = "org.json.JSONArray")
    public static String toString(JSONArray jSONArray) {
        TraceMachine.enterMethod("JSONArray#toString", categoryParams);
        String jSONArray2 = jSONArray.toString();
        TraceMachine.exitMethod();
        return jSONArray2;
    }

    @ReplaceCallSite(scope = "org.json.JSONArray")
    public static String toString(JSONArray jSONArray, int i11) throws JSONException {
        try {
            TraceMachine.enterMethod("JSONArray#toString", categoryParams);
            String jSONArray2 = jSONArray.toString(i11);
            TraceMachine.exitMethod();
            return jSONArray2;
        } catch (JSONException e11) {
            TraceMachine.exitMethod();
            throw e11;
        }
    }
}
