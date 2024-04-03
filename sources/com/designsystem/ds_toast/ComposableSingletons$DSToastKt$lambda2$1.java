package com.designsystem.ds_toast;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u000b"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* renamed from: com.designsystem.ds_toast.ComposableSingletons$DSToastKt$lambda-2$1  reason: invalid class name */
public final class ComposableSingletons$DSToastKt$lambda2$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$DSToastKt$lambda2$1 INSTANCE = new ComposableSingletons$DSToastKt$lambda2$1();

    public ComposableSingletons$DSToastKt$lambda2$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) == 0 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        }
    }
}
