package com.huawei.secure.android.common.intent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public abstract class SafeBroadcastReceiver extends BroadcastReceiver {
    public final void onReceive(Context context, Intent intent) {
        if (!IntentUtils.hasIntentBomb(intent)) {
            onReceiveMsg(context, new SafeIntent(intent));
        }
    }

    public abstract void onReceiveMsg(Context context, Intent intent);
}
