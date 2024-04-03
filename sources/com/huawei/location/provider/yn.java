package com.huawei.location.provider;

import com.huawei.location.gnss.api.Vw;
import com.huawei.location.lite.common.log.LogConsole;

public class yn {

    /* renamed from: yn  reason: collision with root package name */
    private Vw f50208yn = new Vw();

    public void Vw(com.huawei.location.cache.Vw vw2) {
        if (vw2.dC() == null) {
            LogConsole.i("NLPProvider", "locationRequest is invalid");
            return;
        }
        LogConsole.i("NLPProvider", "requestLocation, LocationRequest is " + vw2.Vw().toString());
        this.f50208yn.yn(vw2.dC(), vw2.yn());
        com.huawei.location.nlp.api.yn.yn().Vw(vw2.dC());
    }

    public void yn(com.huawei.location.cache.Vw vw2) {
        if (vw2.yn() != null) {
            this.f50208yn.yn(vw2.yn());
        }
        if (vw2.dC() != null) {
            com.huawei.location.nlp.api.yn.yn().yn(vw2.dC());
        }
    }
}
