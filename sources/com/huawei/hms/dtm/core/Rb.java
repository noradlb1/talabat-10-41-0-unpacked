package com.huawei.hms.dtm.core;

import android.os.Build;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;

public class Rb extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        return new Cc(String.valueOf(Build.VERSION.SDK_INT));
    }

    public String a() {
        return RemoteConfigConstants.RequestFieldKey.SDK_VERSION;
    }
}
