package com.huawei.hms.locationSdk;

import android.content.Context;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;

public class j extends AbstractClientBuilder<t, w> {
    public t buildClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        return new t(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }
}
