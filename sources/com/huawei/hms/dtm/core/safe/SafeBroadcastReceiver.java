package com.huawei.hms.dtm.core.safe;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

public abstract class SafeBroadcastReceiver extends BroadcastReceiver {
    private boolean a(Context context, Intent intent) {
        if (!(context == null || intent == null)) {
            try {
                intent.getStringExtra("TestIntent");
                return !TextUtils.isEmpty(intent.getAction());
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public final void onReceive(Context context, Intent intent) {
        if (a(context, intent)) {
            onReceiveMsg(context, intent);
        }
    }

    public abstract void onReceiveMsg(Context context, Intent intent);
}
