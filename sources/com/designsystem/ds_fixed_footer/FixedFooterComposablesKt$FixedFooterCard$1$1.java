package com.designsystem.ds_fixed_footer;

import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import com.designsystem.semantics.SemanticsPropertiesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class FixedFooterComposablesKt$FixedFooterCard$1$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f31237g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FixedFooterComposablesKt$FixedFooterCard$1$1(float f11) {
        super(1);
        this.f31237g = f11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.m8854setElevation3ABfNKs(semanticsPropertyReceiver, this.f31237g);
    }
}
