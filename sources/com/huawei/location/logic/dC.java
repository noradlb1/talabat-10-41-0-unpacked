package com.huawei.location.logic;

import android.location.Location;
import com.huawei.location.cache.Vw;
import com.huawei.location.cache.yn;
import com.huawei.location.callback.E5;
import com.huawei.location.callback.d2;
import com.huawei.location.callback.ut;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.android.receiver.GnssAndNetReceiver;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.LocationUtil;
import com.huawei.location.lite.common.util.NetworkUtil;
import java.util.Map;

public class dC extends GnssAndNetReceiver {
    public void notifyListeners() {
        boolean isLocationEnabled = LocationUtil.isLocationEnabled(ContextUtil.getContext());
        boolean isNetworkAvailable = NetworkUtil.isNetworkAvailable(ContextUtil.getContext());
        if (!isLocationEnabled) {
            yn.Vw().yn((Location) null);
        }
        if (isLocationEnabled && isNetworkAvailable) {
            LogConsole.i("LocationAvailabilityObserver", "available,resume scan and get location");
            com.huawei.location.nlp.api.yn.yn().FB();
        } else {
            LogConsole.i("LocationAvailabilityObserver", "unAvailable,stop scan and get location");
            com.huawei.location.nlp.api.yn.yn().LW();
        }
        for (Map.Entry<String, Vw> value : yn.Vw().yn().entrySet()) {
            d2 yn2 = ((Vw) value.getValue()).yn();
            if (yn2 != null) {
                if ((yn2 instanceof E5) || (yn2 instanceof ut) || (yn2 instanceof com.huawei.location.callback.dC)) {
                    yn2.yn(isLocationEnabled);
                } else {
                    yn2.yn(isLocationEnabled && isNetworkAvailable);
                }
            }
        }
    }
}
