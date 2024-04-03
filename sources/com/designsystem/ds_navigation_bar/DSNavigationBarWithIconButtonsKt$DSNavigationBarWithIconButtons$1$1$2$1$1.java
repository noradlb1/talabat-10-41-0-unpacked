package com.designsystem.ds_navigation_bar;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSNavigationBarWithIconButtonsKt$DSNavigationBarWithIconButtons$1$1$2$1$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f32420g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSNavigationBarWithIconButtonsKt$DSNavigationBarWithIconButtons$1$1$2$1$1(int i11) {
        super(1);
        this.f32420g = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setTestTag(semanticsPropertyReceiver, Intrinsics.stringPlus("NAVIGATION_BAR_ACTION_BUTTON_TEST_TAG", Integer.valueOf(this.f32420g)));
    }
}
