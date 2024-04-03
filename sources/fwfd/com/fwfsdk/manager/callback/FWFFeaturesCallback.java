package fwfd.com.fwfsdk.manager.callback;

import fwfd.com.fwfsdk.model.db.FWFResult;
import java.util.HashMap;

public interface FWFFeaturesCallback {
    void onFwfResponse(HashMap<String, FWFResult> hashMap);
}
