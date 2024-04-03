package com.designsystem.ds_fixed_footer;

import android.content.Context;
import com.designsystem.ds_button_v2.DSBaseButton;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSFixedFooterWithButtons$toComposable$1$1$1$1 extends Lambda implements Function1<Context, DSBaseButton> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSBaseButton f31206g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSFixedFooterWithButtons$toComposable$1$1$1$1(DSBaseButton dSBaseButton) {
        super(1);
        this.f31206g = dSBaseButton;
    }

    @NotNull
    public final DSBaseButton invoke(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "it");
        return this.f31206g;
    }
}
