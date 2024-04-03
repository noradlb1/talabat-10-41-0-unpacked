package com.huawei.hms.locationSdk;

import android.content.Context;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;

public class m extends AbstractClientBuilder<u, w> {
    public u buildClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        return new u(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }
}
