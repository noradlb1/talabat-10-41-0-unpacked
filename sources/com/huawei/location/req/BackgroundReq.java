package com.huawei.location.req;

import android.content.Context;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;

public class BackgroundReq extends LocationBaseRequest {
    @Packed
    private int notificationId;
    @Packed
    private String uuid;

    public BackgroundReq() {
    }

    public BackgroundReq(Context context) {
        super(context);
    }

    public int getNotificationId() {
        return this.notificationId;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setNotificationId(int i11) {
        this.notificationId = i11;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }
}
