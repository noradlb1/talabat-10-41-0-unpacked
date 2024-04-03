package com.talabat.observability.localTracer;

import com.talabat.observability.localTracer.Trace;
import java.util.Map;
import kotlin.Metadata;
import net.bytebuddy.utility.JavaConstant;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0018\u0010\u0007\u001a\u00020\b*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0\tH\u0002¨\u0006\u000b"}, d2 = {"id", "", "Lcom/talabat/observability/localTracer/Trace$Companion;", "sectionOfInterest", "Lcom/talabat/observability/localTracer/SectionOfInterest;", "pointOfInterest", "Lcom/talabat/observability/localTracer/PointOfInterest;", "toJsonArray", "Lorg/json/JSONArray;", "", "Lcom/talabat/observability/localTracer/Trace;", "com_talabat_NewArchi_Observability_Observability"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PointOfInterestReporterKt {
    /* access modifiers changed from: private */
    public static final String id(Trace.Companion companion, SectionOfInterest sectionOfInterest, PointOfInterest pointOfInterest) {
        String name2 = sectionOfInterest.name();
        String name3 = pointOfInterest.name();
        return "POI - " + name2 + JavaConstant.Dynamic.DEFAULT_NAME + name3;
    }

    /* access modifiers changed from: private */
    public static final JSONArray toJsonArray(Map<String, Trace> map) {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Trace trace = (Trace) next.getValue();
            if (!(trace.getStartTime() == null || trace.getEndTime() == null)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("title", (Object) trace.getPointOfInterest());
                jSONObject.put("start", (Object) trace.getStartTime());
                jSONObject.put(TtmlNode.END, (Object) trace.getEndTime());
                jSONObject.put("content", trace.getDuration());
                jSONObject.put("group", (Object) trace.getSectionOfInterest());
                jSONArray.put((Object) jSONObject);
            }
        }
        return jSONArray;
    }
}
