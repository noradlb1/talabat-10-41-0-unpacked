package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.entity.opendevice.HuaweiOpendeviceNaming;
import com.huawei.hms.support.api.opendevice.OdidResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.utils.JsonUtil;

public class OpenDeviceClientImpl extends HuaweiApi<OpenDeviceOptions> implements OpenDeviceClient {

    /* renamed from: a  reason: collision with root package name */
    private static final OpenDeviceHmsClientBuilder f49637a = new OpenDeviceHmsClientBuilder();

    /* renamed from: b  reason: collision with root package name */
    private static final Api<OpenDeviceOptions> f49638b = new Api<>(HuaweiApiAvailability.HMS_API_NAME_OD);

    /* renamed from: c  reason: collision with root package name */
    private static OpenDeviceOptions f49639c = new OpenDeviceOptions();

    public OpenDeviceClientImpl(Context context) {
        super(context, f49638b, f49639c, (AbstractClientBuilder) f49637a);
        super.setKitSdkVersion(60700300);
    }

    public Task<OdidResult> getOdid() {
        return doWrite(new OpenDeviceTaskApiCall(HuaweiOpendeviceNaming.GET_ODID, JsonUtil.createJsonString((IMessageEntity) null), HiAnalyticsClient.reportEntry(getContext(), HuaweiOpendeviceNaming.GET_ODID, 60700300)));
    }
}
