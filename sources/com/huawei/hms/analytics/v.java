package com.huawei.hms.analytics;

import android.content.Context;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.HmsClient;

public final class v extends HmsClient {
    public v(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        super(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }

    public final int getMinApkVersion() {
        return HuaweiApiAvailability.HMS_VERSION_CODE_KIT_UPDATE;
    }
}
