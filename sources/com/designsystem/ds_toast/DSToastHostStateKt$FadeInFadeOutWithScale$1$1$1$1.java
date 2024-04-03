package com.designsystem.ds_toast;

import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import com.designsystem.ds_toast.DSToastHostState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSToastHostStateKt$FadeInFadeOutWithScale$1$1$1$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSToastHostState.ToastData f33189g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSToastHostStateKt$FadeInFadeOutWithScale$1$1$1$1(DSToastHostState.ToastData toastData) {
        super(1);
        this.f33189g = toastData;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.m4923setLiveRegionhR3wRGc(semanticsPropertyReceiver, LiveRegionMode.Companion.m4903getPolite0phEisY());
        final DSToastHostState.ToastData toastData = this.f33189g;
        SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() {
            @NotNull
            public final Boolean invoke() {
                toastData.dismiss();
                return Boolean.TRUE;
            }
        }, 1, (Object) null);
    }
}
