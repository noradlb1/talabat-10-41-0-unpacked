package com.designsystem.ds_toast;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.designsystem.ds_toast.DSToastHostState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ComposableSingletons$DSToastKt {
    @NotNull
    public static final ComposableSingletons$DSToastKt INSTANCE = new ComposableSingletons$DSToastKt();
    @NotNull

    /* renamed from: lambda-1  reason: not valid java name */
    public static Function3<DSToastHostState.ToastData, Composer, Integer, Unit> f445lambda1 = ComposableLambdaKt.composableLambdaInstance(-985532298, false, ComposableSingletons$DSToastKt$lambda1$1.INSTANCE);
    @NotNull

    /* renamed from: lambda-2  reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f446lambda2 = ComposableLambdaKt.composableLambdaInstance(-985536652, false, ComposableSingletons$DSToastKt$lambda2$1.INSTANCE);

    @NotNull
    /* renamed from: getLambda-1$marshmallow_release  reason: not valid java name */
    public final Function3<DSToastHostState.ToastData, Composer, Integer, Unit> m8851getLambda1$marshmallow_release() {
        return f445lambda1;
    }

    @NotNull
    /* renamed from: getLambda-2$marshmallow_release  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m8852getLambda2$marshmallow_release() {
        return f446lambda2;
    }
}
