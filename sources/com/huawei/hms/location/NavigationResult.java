package com.huawei.hms.location;

import android.os.Parcel;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.common.LocationBaseResponse;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.secure.android.common.intent.SafeBundle;
import java.util.HashMap;
import java.util.Map;

public class NavigationResult extends LocationBaseResponse {
    private Map<String, Object> extras;
    private int possibility = -1;
    private int state = -1;

    public NavigationResult() {
    }

    public NavigationResult(Parcel parcel) {
        this.state = parcel.readInt();
        this.possibility = parcel.readInt();
        this.extras = new HashMap();
        SafeBundle safeBundle = new SafeBundle(parcel.readBundle(getClass().getClassLoader()));
        for (String next : safeBundle.keySet()) {
            Object obj = safeBundle.get(next);
            if (obj != null) {
                this.extras.put(next, obj);
            }
        }
    }

    private Map<String, Object> getExtras() {
        return this.extras;
    }

    private void setExtras(Map<String, Object> map) {
        this.extras = map;
    }

    public final int getPossibility() {
        return this.possibility;
    }

    public final int getState() {
        return this.state;
    }

    public void setPossibility(int i11) throws ApiException {
        if (i11 > 100 || i11 < 0) {
            throw new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
        }
        this.possibility = i11;
    }

    public void setState(int i11) {
        this.state = i11;
    }
}
