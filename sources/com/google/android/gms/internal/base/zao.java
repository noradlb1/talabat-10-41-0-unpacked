package com.google.android.gms.internal.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

public final class zao extends ContextCompat {
    @ResultIgnorabilityUnspecified
    @Deprecated
    @Nullable
    public static Intent zaa(Context context, @Nullable BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        int i11;
        if (!zan.zaa()) {
            return context.registerReceiver(broadcastReceiver, intentFilter);
        }
        if (true != zan.zaa()) {
            i11 = 0;
        } else {
            i11 = 2;
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, i11);
    }
}
