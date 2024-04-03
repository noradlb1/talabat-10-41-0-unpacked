package com.talabat.vendormenu.presentation.flutter;

import androidx.fragment.app.FragmentActivity;
import com.talabat.gem.integration.Gem;
import io.flutter.plugin.common.MethodChannel;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0010\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/vendormenu/presentation/flutter/GemFlutterEngineBinder;", "Lio/reactivex/functions/Consumer;", "Landroidx/fragment/app/FragmentActivity;", "gemNativeChannel", "Lio/flutter/plugin/common/MethodChannel;", "(Lio/flutter/plugin/common/MethodChannel;)V", "gemBroadcastReceiver", "com/talabat/vendormenu/presentation/flutter/GemFlutterEngineBinder$gemBroadcastReceiver$1", "Lcom/talabat/vendormenu/presentation/flutter/GemFlutterEngineBinder$gemBroadcastReceiver$1;", "accept", "", "activity", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemFlutterEngineBinder implements Consumer<FragmentActivity> {
    /* access modifiers changed from: private */
    @NotNull
    public final GemFlutterEngineBinder$gemBroadcastReceiver$1 gemBroadcastReceiver = new GemFlutterEngineBinder$gemBroadcastReceiver$1(this);
    /* access modifiers changed from: private */
    @NotNull
    public final MethodChannel gemNativeChannel;

    public GemFlutterEngineBinder(@NotNull MethodChannel methodChannel) {
        Intrinsics.checkNotNullParameter(methodChannel, "gemNativeChannel");
        this.gemNativeChannel = methodChannel;
    }

    public void accept(@NotNull FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Gem.withGemComponent(new GemFlutterEngineBinder$accept$1$1(fragmentActivity, this));
    }
}
