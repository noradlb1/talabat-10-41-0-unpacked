package com.checkout.frames.view;

import androidx.compose.runtime.Composer;
import com.checkout.frames.style.view.TextLabelViewStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextLabelKt$TextLabel$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ TextLabelState $state;
    final /* synthetic */ TextLabelViewStyle $style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextLabelKt$TextLabel$2(TextLabelViewStyle textLabelViewStyle, TextLabelState textLabelState, int i11) {
        super(2);
        this.$style = textLabelViewStyle;
        this.$state = textLabelState;
        this.$$changed = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        TextLabelKt.TextLabel(this.$style, this.$state, composer, this.$$changed | 1);
    }
}
