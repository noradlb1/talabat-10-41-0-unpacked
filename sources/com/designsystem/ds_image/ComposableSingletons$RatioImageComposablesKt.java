package com.designsystem.ds_image;

import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.skydoves.landscapist.coil.CoilImageState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ComposableSingletons$RatioImageComposablesKt {
    @NotNull
    public static final ComposableSingletons$RatioImageComposablesKt INSTANCE = new ComposableSingletons$RatioImageComposablesKt();
    @NotNull

    /* renamed from: lambda-1  reason: not valid java name */
    public static Function3<CoilImageState.Loading, Composer, Integer, Unit> f439lambda1 = ComposableLambdaKt.composableLambdaInstance(-985530843, false, ComposableSingletons$RatioImageComposablesKt$lambda1$1.INSTANCE);
    @NotNull

    /* renamed from: lambda-2  reason: not valid java name */
    public static Function3<CoilImageState.Failure, Composer, Integer, Unit> f440lambda2 = ComposableLambdaKt.composableLambdaInstance(-985530643, false, ComposableSingletons$RatioImageComposablesKt$lambda2$1.INSTANCE);
    @NotNull

    /* renamed from: lambda-3  reason: not valid java name */
    public static Function3<BoxWithConstraintsScope, Composer, Integer, Unit> f441lambda3 = ComposableLambdaKt.composableLambdaInstance(-985537691, false, ComposableSingletons$RatioImageComposablesKt$lambda3$1.INSTANCE);

    @NotNull
    /* renamed from: getLambda-1$marshmallow_release  reason: not valid java name */
    public final Function3<CoilImageState.Loading, Composer, Integer, Unit> m8358getLambda1$marshmallow_release() {
        return f439lambda1;
    }

    @NotNull
    /* renamed from: getLambda-2$marshmallow_release  reason: not valid java name */
    public final Function3<CoilImageState.Failure, Composer, Integer, Unit> m8359getLambda2$marshmallow_release() {
        return f440lambda2;
    }

    @NotNull
    /* renamed from: getLambda-3$marshmallow_release  reason: not valid java name */
    public final Function3<BoxWithConstraintsScope, Composer, Integer, Unit> m8360getLambda3$marshmallow_release() {
        return f441lambda3;
    }
}
