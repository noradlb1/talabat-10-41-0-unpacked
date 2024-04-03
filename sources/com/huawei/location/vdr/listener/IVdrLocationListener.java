package com.huawei.location.vdr.listener;

import android.location.Location;

public interface IVdrLocationListener {
    String getUuid();

    void onVdrLocationChanged(Location location);
}
