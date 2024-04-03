package com.designsystem.ds_chip;

import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ChipComposablesKt$ChipIcon$1$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f30909g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipComposablesKt$ChipIcon$1$1(String str) {
        super(1);
        this.f30909g = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.m4924setRolekuIjeqM(semanticsPropertyReceiver, Role.Companion.m4913getImageo7Vup1c());
        SemanticsPropertiesKt.setTestTag(semanticsPropertyReceiver, this.f30909g);
    }
}
