package fwfd.com.fwfsdk.model.db;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import fwfd.com.fwfsdk.model.api.FWFExplanation;
import fwfd.com.fwfsdk.model.api.FWFTrackInfo;
import fwfd.com.fwfsdk.util.FWFGson;
import fwfd.com.fwfsdk.util.FWFHelper;
import fwfd.com.fwfsdk.util.FWFLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Instrumented
public class FWFResult {
    public boolean abtest;
    private FWFExplanation explanation;
    private Map<String, Boolean> holdoutsEvaluations;
    private FWFResultTrackInfo trackInfo;
    public Object variation;

    public FWFResult() {
    }

    public Boolean getAbtest() {
        return Boolean.valueOf(this.abtest);
    }

    public Boolean getBooleanVariation() {
        Object obj = this.variation;
        if (obj instanceof Boolean) {
            try {
                return (Boolean) obj;
            } catch (ClassCastException unused) {
                FWFLogger.logError(FWFHelper.ERROR_VARIATION_CAST);
            }
        }
        return null;
    }

    public JsonObject getExplanation() {
        JsonObject jsonObject = new JsonObject();
        if (this.explanation == null) {
            return jsonObject;
        }
        try {
            return FWFGson.getInstance().toJsonTree(this.explanation).getAsJsonObject();
        } catch (Exception unused) {
            FWFLogger.logError("FWFFeature - Cannot create json from explanation");
            jsonObject.addProperty("error", "FWFFeature - Cannot create json from explanation");
            return jsonObject;
        }
    }

    public String getExplanationKind() {
        return this.explanation.getKind();
    }

    public Float getFloatVariation() {
        Object obj = this.variation;
        if (obj instanceof Number) {
            try {
                return Float.valueOf(((Double) obj).floatValue());
            } catch (ClassCastException unused) {
                FWFLogger.logError(FWFHelper.ERROR_VARIATION_CAST);
            }
        }
        return null;
    }

    public Map<String, Boolean> getHoldoutsEvaluations() {
        return this.holdoutsEvaluations;
    }

    public Integer getIntegerVariation() {
        Object obj = this.variation;
        if (obj instanceof Number) {
            try {
                return Integer.valueOf(((Double) obj).intValue());
            } catch (ClassCastException unused) {
                FWFLogger.logError(FWFHelper.ERROR_VARIATION_CAST);
            }
        }
        return null;
    }

    public JsonArray getJsonArrayVariation() {
        String str;
        Object obj;
        try {
            Object obj2 = this.variation;
            if (obj2 instanceof List) {
                Gson instance = FWFGson.getInstance();
                Object obj3 = this.variation;
                if (!(instance instanceof Gson)) {
                    str = instance.toJson(obj3);
                } else {
                    str = GsonInstrumentation.toJson(instance, obj3);
                }
            } else {
                str = obj2.toString();
            }
            Gson instance2 = FWFGson.getInstance();
            Class cls = JsonArray.class;
            if (!(instance2 instanceof Gson)) {
                obj = instance2.fromJson(str, cls);
            } else {
                obj = GsonInstrumentation.fromJson(instance2, str, cls);
            }
            return (JsonArray) obj;
        } catch (Exception unused) {
            FWFLogger.logError(FWFHelper.ERROR_VARIATION_CAST);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002d A[Catch:{ Exception -> 0x0039 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0032 A[Catch:{ Exception -> 0x0039 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.gson.JsonObject getJsonVariation() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.variation     // Catch:{ Exception -> 0x0039 }
            boolean r1 = r0 instanceof com.google.gson.internal.LinkedTreeMap     // Catch:{ Exception -> 0x0039 }
            if (r1 != 0) goto L_0x0010
            boolean r1 = r0 instanceof java.util.LinkedHashMap     // Catch:{ Exception -> 0x0039 }
            if (r1 == 0) goto L_0x000b
            goto L_0x0010
        L_0x000b:
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0039 }
            goto L_0x0023
        L_0x0010:
            com.google.gson.Gson r0 = fwfd.com.fwfsdk.util.FWFGson.getInstance()     // Catch:{ Exception -> 0x0039 }
            java.lang.Object r1 = r4.variation     // Catch:{ Exception -> 0x0039 }
            boolean r2 = r0 instanceof com.google.gson.Gson     // Catch:{ Exception -> 0x0039 }
            if (r2 != 0) goto L_0x001f
            java.lang.String r0 = r0.toJson((java.lang.Object) r1)     // Catch:{ Exception -> 0x0039 }
            goto L_0x0023
        L_0x001f:
            java.lang.String r0 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.toJson((com.google.gson.Gson) r0, (java.lang.Object) r1)     // Catch:{ Exception -> 0x0039 }
        L_0x0023:
            com.google.gson.Gson r1 = fwfd.com.fwfsdk.util.FWFGson.getInstance()     // Catch:{ Exception -> 0x0039 }
            java.lang.Class<com.google.gson.JsonObject> r2 = com.google.gson.JsonObject.class
            boolean r3 = r1 instanceof com.google.gson.Gson     // Catch:{ Exception -> 0x0039 }
            if (r3 != 0) goto L_0x0032
            java.lang.Object r0 = r1.fromJson((java.lang.String) r0, r2)     // Catch:{ Exception -> 0x0039 }
            goto L_0x0036
        L_0x0032:
            java.lang.Object r0 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson((com.google.gson.Gson) r1, (java.lang.String) r0, r2)     // Catch:{ Exception -> 0x0039 }
        L_0x0036:
            com.google.gson.JsonObject r0 = (com.google.gson.JsonObject) r0     // Catch:{ Exception -> 0x0039 }
            goto L_0x003f
        L_0x0039:
            java.lang.String r0 = fwfd.com.fwfsdk.util.FWFHelper.ERROR_VARIATION_CAST
            fwfd.com.fwfsdk.util.FWFLogger.logError(r0)
            r0 = 0
        L_0x003f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fwfd.com.fwfsdk.model.db.FWFResult.getJsonVariation():com.google.gson.JsonObject");
    }

    public String getStringVariation() {
        Object obj = this.variation;
        if (obj instanceof String) {
            try {
                return (String) obj;
            } catch (ClassCastException unused) {
                FWFLogger.logError(FWFHelper.ERROR_VARIATION_CAST);
            }
        }
        return null;
    }

    public FWFResultTrackInfo getTrackInfo() {
        return this.trackInfo;
    }

    public List<String> getTrackerServices() {
        FWFResultTrackInfo fWFResultTrackInfo = this.trackInfo;
        if (fWFResultTrackInfo == null || fWFResultTrackInfo.getTrackerServices() == null) {
            return new ArrayList();
        }
        return this.trackInfo.getTrackerServices();
    }

    public Object getVariation() {
        return this.variation;
    }

    public boolean isNullVariation() {
        return this.variation == null;
    }

    public void setAbtest(boolean z11) {
        this.abtest = z11;
    }

    public void setExplanation(FWFExplanation fWFExplanation) {
        this.explanation = fWFExplanation;
    }

    public void setTrackInfo(FWFResultTrackInfo fWFResultTrackInfo) {
        this.trackInfo = fWFResultTrackInfo;
    }

    public void setVariation(Object obj) {
        this.variation = obj;
    }

    public String toString() {
        return "\nvariation=" + this.variation + "\nabtest=" + this.abtest + "\nexplanation=" + this.explanation + "\ntrackInfo=" + this.trackInfo;
    }

    public FWFResult(Object obj, boolean z11, FWFExplanation fWFExplanation, FWFTrackInfo fWFTrackInfo, Map<String, Boolean> map) {
        this.variation = obj;
        this.abtest = z11;
        this.explanation = fWFExplanation;
        if (fWFTrackInfo != null) {
            this.trackInfo = new FWFResultTrackInfo(fWFTrackInfo.getVariationName(), fWFTrackInfo.getFlagType(), fWFTrackInfo.getFlagEnabled(), fWFTrackInfo.getTrackerServices());
        }
        this.holdoutsEvaluations = map;
    }

    public FWFResult(Object obj, String str, String str2) {
        FWFExplanation fWFExplanation = new FWFExplanation();
        this.explanation = fWFExplanation;
        fWFExplanation.setError(str);
        this.explanation.setKind(str2);
        this.variation = obj;
        this.abtest = false;
    }

    public FWFResult(Object obj, String str, String str2, FWFTrackInfo fWFTrackInfo) {
        FWFExplanation fWFExplanation = new FWFExplanation();
        this.explanation = fWFExplanation;
        fWFExplanation.setError(str);
        this.explanation.setKind(str2);
        this.variation = obj;
        this.abtest = false;
        if (fWFTrackInfo != null) {
            this.trackInfo = new FWFResultTrackInfo(fWFTrackInfo.getVariationName(), fWFTrackInfo.getFlagType(), fWFTrackInfo.getFlagEnabled(), fWFTrackInfo.getTrackerServices());
        }
    }
}
