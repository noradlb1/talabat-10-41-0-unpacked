package com.talabat.flutter.homeofoffers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.talabat.fluttercore.engine.PreWarmedEngines;
import com.talabat.helpers.GlobalConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/flutter/homeofoffers/HomeOfOffersBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "arg0", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeOfOffersBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "arg0");
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        if (Intrinsics.areEqual((Object) intent.getAction(), (Object) GlobalConstants.BROADCAST_KILL_MENU)) {
            PreWarmedEngines.INSTANCE.removeWarmedUpEngine(PreWarmedEngines.ENGINE_FOR_HOME_OF_OFFERS);
        }
    }
}
