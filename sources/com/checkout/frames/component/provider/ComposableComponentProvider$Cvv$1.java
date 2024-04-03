package com.checkout.frames.component.provider;

import androidx.compose.runtime.Composer;
import com.checkout.frames.style.component.CvvComponentStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposableComponentProvider$Cvv$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ CvvComponentStyle $style;
    final /* synthetic */ ComposableComponentProvider $tmp0_rcvr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposableComponentProvider$Cvv$1(ComposableComponentProvider composableComponentProvider, CvvComponentStyle cvvComponentStyle, int i11) {
        super(2);
        this.$tmp0_rcvr = composableComponentProvider;
        this.$style = cvvComponentStyle;
        this.$$changed = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.$tmp0_rcvr.Cvv(this.$style, composer, this.$$changed | 1);
    }
}
