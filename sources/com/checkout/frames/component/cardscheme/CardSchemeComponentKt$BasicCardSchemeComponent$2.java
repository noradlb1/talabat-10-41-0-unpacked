package com.checkout.frames.component.cardscheme;

import androidx.compose.runtime.Composer;
import com.checkout.frames.style.view.CardSchemeComponentViewStyle;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CardSchemeComponentKt$BasicCardSchemeComponent$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ CardSchemeComponentState $state;
    final /* synthetic */ CardSchemeComponentViewStyle $style;
    final /* synthetic */ List<Function2<Composer, Integer, Unit>> $supportedCardSchemeIconList;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardSchemeComponentKt$BasicCardSchemeComponent$2(CardSchemeComponentViewStyle cardSchemeComponentViewStyle, CardSchemeComponentState cardSchemeComponentState, List<? extends Function2<? super Composer, ? super Integer, Unit>> list, int i11) {
        super(2);
        this.$style = cardSchemeComponentViewStyle;
        this.$state = cardSchemeComponentState;
        this.$supportedCardSchemeIconList = list;
        this.$$changed = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CardSchemeComponentKt.BasicCardSchemeComponent(this.$style, this.$state, this.$supportedCardSchemeIconList, composer, this.$$changed | 1);
    }
}
