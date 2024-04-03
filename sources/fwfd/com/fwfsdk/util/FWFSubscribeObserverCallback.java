package fwfd.com.fwfsdk.util;

import fwfd.com.fwfsdk.model.api.FWFSubscribeResult;

public interface FWFSubscribeObserverCallback {
    void onFwfResponse(FWFSubscribeResult fWFSubscribeResult);
}
