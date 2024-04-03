package com.huawei.hms.analytics;

import android.content.Context;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;

public final class s extends AbstractClientBuilder<v, Api.ApiOptions.NoOptions> {
    public final /* synthetic */ AnyClient buildClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        return new v(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }
}
