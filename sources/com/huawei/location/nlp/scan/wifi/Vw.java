package com.huawei.location.nlp.scan.wifi;

import android.content.Context;
import android.content.Intent;
import com.huawei.secure.android.common.intent.SafeBroadcastReceiver;

class Vw extends SafeBroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FB f50203a;

    public Vw(FB fb2) {
        this.f50203a = fb2;
    }

    public void onReceiveMsg(Context context, Intent intent) {
        if (!this.f50203a.dC) {
            FB.a(this.f50203a, intent);
        }
    }
}
