package com.talabat.core.flutter.channels.data.gem;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/talabat/core/flutter/channels/data/gem/GemMethodChannel$gemBroadcastReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "com_talabat_core_flutter-channels_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemMethodChannel$gemBroadcastReceiver$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GemMethodChannel f55889a;

    public GemMethodChannel$gemBroadcastReceiver$1(GemMethodChannel gemMethodChannel) {
        this.f55889a = gemMethodChannel;
    }

    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        Boolean bool;
        if (intent != null) {
            bool = Boolean.valueOf(intent.getBooleanExtra("com.talabat.gem.domain.usecases.KEY_GEM_ENABLED", false));
        } else {
            bool = null;
        }
        MethodChannel channel = this.f55889a.getChannel();
        if (channel != null) {
            channel.invokeMethod("gemStatusCallback", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("isGemEnabled", bool)));
        }
        MethodChannel channel2 = this.f55889a.getChannel();
        if (channel2 != null) {
            channel2.invokeMethod("gemOffersStatusCallback", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("isGemOffersActive", bool)));
        }
    }
}
