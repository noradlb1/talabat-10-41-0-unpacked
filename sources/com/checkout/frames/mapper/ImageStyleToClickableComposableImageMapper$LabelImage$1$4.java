package com.checkout.frames.mapper;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ImageStyleToClickableComposableImageMapper$LabelImage$1$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $composableImage;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageStyleToClickableComposableImageMapper$LabelImage$1$4(Function2<? super Composer, ? super Integer, Unit> function2) {
        super(2);
        this.$composableImage = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            this.$composableImage.invoke(composer, 0);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
