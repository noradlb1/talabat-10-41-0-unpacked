package com.huawei.hms.locationSdk;

import android.content.Context;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.HmsClient;

public class t extends HmsClient {
    public t(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        super(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }

    public int getMinApkVersion() {
        return 50000000;
    }

    public String getServiceAction() {
        return "com.huawei.hms.core.locationaidlservice";
    }
}
