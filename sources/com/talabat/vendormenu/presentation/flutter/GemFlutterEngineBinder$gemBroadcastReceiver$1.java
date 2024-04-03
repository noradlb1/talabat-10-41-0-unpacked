package com.talabat.vendormenu.presentation.flutter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/talabat/vendormenu/presentation/flutter/GemFlutterEngineBinder$gemBroadcastReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemFlutterEngineBinder$gemBroadcastReceiver$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GemFlutterEngineBinder f12435a;

    public GemFlutterEngineBinder$gemBroadcastReceiver$1(GemFlutterEngineBinder gemFlutterEngineBinder) {
        this.f12435a = gemFlutterEngineBinder;
    }

    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        Boolean bool;
        if (intent != null) {
            bool = Boolean.valueOf(intent.getBooleanExtra("com.talabat.gem.domain.usecases.KEY_GEM_ENABLED", false));
        } else {
            bool = null;
        }
        this.f12435a.gemNativeChannel.invokeMethod("gemStatusCallback", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("isGemEnabled", bool)));
        this.f12435a.gemNativeChannel.invokeMethod("gemOffersStatusCallback", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("isGemOffersActive", bool)));
    }
}
