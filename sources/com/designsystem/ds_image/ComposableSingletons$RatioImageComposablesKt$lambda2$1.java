package com.designsystem.ds_image;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import com.skydoves.landscapist.coil.CoilImageState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u000b"}, d2 = {"Lcom/skydoves/landscapist/coil/CoilImageState$Failure;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* renamed from: com.designsystem.ds_image.ComposableSingletons$RatioImageComposablesKt$lambda-2$1  reason: invalid class name */
public final class ComposableSingletons$RatioImageComposablesKt$lambda2$1 extends Lambda implements Function3<CoilImageState.Failure, Composer, Integer, Unit> {
    public static final ComposableSingletons$RatioImageComposablesKt$lambda2$1 INSTANCE = new ComposableSingletons$RatioImageComposablesKt$lambda2$1();

    public ComposableSingletons$RatioImageComposablesKt$lambda2$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((CoilImageState.Failure) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull CoilImageState.Failure failure, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(failure, "it");
        if (((i11 & 81) ^ 16) != 0 || !composer.getSkipping()) {
            RatioImageComposablesKt.RatioImageError(composer, 0);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
