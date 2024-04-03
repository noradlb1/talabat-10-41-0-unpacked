package com.huawei.hms.support.api.entity.location.binder;

import android.os.Binder;
import android.os.Bundle;

public class InnerBinder extends Binder {
    private static InnerBinder innerBinder;

    public static synchronized Bundle getInnerBinder() {
        Bundle bundle;
        synchronized (InnerBinder.class) {
            if (innerBinder == null) {
                innerBinder = new InnerBinder();
            }
            bundle = new Bundle();
            bundle.putBinder("InnerBinder", innerBinder);
        }
        return bundle;
    }
}
