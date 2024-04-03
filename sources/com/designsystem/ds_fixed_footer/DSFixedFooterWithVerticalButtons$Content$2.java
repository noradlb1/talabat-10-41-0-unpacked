package com.designsystem.ds_fixed_footer;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSFixedFooterWithVerticalButtons$Content$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSFixedFooterWithVerticalButtons f31229g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f31230h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSFixedFooterWithVerticalButtons$Content$2(DSFixedFooterWithVerticalButtons dSFixedFooterWithVerticalButtons, int i11) {
        super(2);
        this.f31229g = dSFixedFooterWithVerticalButtons;
        this.f31230h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f31229g.Content(composer, this.f31230h | 1);
    }
}
