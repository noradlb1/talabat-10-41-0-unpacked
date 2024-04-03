package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzb  reason: invalid package */
public final class zzb extends ContextCompat {
    @Deprecated
    @Nullable
    public static Intent zza(Context context, @Nullable BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        int i11;
        if (!zza.zza()) {
            return context.registerReceiver(broadcastReceiver, intentFilter);
        }
        if (true != zza.zza()) {
            i11 = 0;
        } else {
            i11 = 2;
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, i11);
    }
}
