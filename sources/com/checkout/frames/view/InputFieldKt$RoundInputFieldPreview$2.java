package com.checkout.frames.view;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class InputFieldKt$RoundInputFieldPreview$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputFieldKt$RoundInputFieldPreview$2(int i11) {
        super(2);
        this.$$changed = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        InputFieldKt.RoundInputFieldPreview(composer, this.$$changed | 1);
    }
}
