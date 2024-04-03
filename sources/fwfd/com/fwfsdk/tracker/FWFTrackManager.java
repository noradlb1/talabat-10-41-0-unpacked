package fwfd.com.fwfsdk.tracker;

import com.google.gson.JsonObject;
import fwfd.com.fwfsdk.FunWithFlags;
import fwfd.com.fwfsdk.model.db.FWFResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FWFTrackManager {
    private FWFFlagData buildFlagData(String str, FWFResult fWFResult, Map<String, String> map) {
        return new FWFFlagData(str, fWFResult.getVariation(), fWFResult.getAbtest(), fWFResult.getTrackerServices(), fWFResult.getExplanationKind(), map);
    }

    public void trackEvent(JsonObject jsonObject, String str, FWFResult fWFResult, Map<String, String> map) {
        for (FWFTracker trackEvent : FunWithFlags.getInstance().getTrackers()) {
            trackEvent.trackEvent(jsonObject, buildFlagData(str, fWFResult, map));
        }
    }

    public void trackEvents(JsonObject jsonObject, HashMap<String, FWFResult> hashMap, Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : hashMap.entrySet()) {
            arrayList.add(buildFlagData((String) next.getKey(), (FWFResult) next.getValue(), map));
        }
        for (FWFTracker trackEvents : FunWithFlags.getInstance().getTrackers()) {
            trackEvents.trackEvents(jsonObject, arrayList);
        }
    }
}
