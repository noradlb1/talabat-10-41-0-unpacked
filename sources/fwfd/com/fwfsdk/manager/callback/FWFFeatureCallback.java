package fwfd.com.fwfsdk.manager.callback;

import fwfd.com.fwfsdk.model.db.FWFResult;

public interface FWFFeatureCallback {
    void onFwfResponse(FWFResult fWFResult);
}
