package com.huawei.wisesecurity.ucs_credential;

import com.huawei.hms.network.NetworkKit;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;

public class o extends NetworkKit.Callback {
    public o(p pVar) {
    }

    public void onResult(boolean z11) {
        if (z11) {
            LogUcs.e("RemoteRestClient", "Networkkit init success", new Object[0]);
        } else {
            LogUcs.e("RemoteRestClient", " Networkkit init failed", new Object[0]);
        }
    }
}
