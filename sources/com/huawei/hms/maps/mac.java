package com.huawei.hms.maps;

import android.app.Activity;
import com.huawei.hms.feature.dynamic.LifecycleDelegate;

public interface mac extends LifecycleDelegate {
    void a(Activity activity);

    void a(OnMapReadyCallback onMapReadyCallback);
}
