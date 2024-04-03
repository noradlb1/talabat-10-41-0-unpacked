package com.checkout.frames.component.cardscheme;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CardSchemeComponentKt$BasicCardSchemeComponent$1$1$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ List<Function2<Composer, Integer, Unit>> $supportedCardSchemeIconList;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardSchemeComponentKt$BasicCardSchemeComponent$1$1$2(List<? extends Function2<? super Composer, ? super Integer, Unit>> list) {
        super(2);
        this.$supportedCardSchemeIconList = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            for (Function2 function2 : this.$supportedCardSchemeIconList) {
                if (function2 != null) {
                    function2.invoke(composer, 0);
                }
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
