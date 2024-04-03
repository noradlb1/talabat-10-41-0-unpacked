package com.google.accompanist.navigation.animation;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u000b¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Landroidx/compose/animation/AnimatedVisibilityScope;", "it", "Landroidx/navigation/NavBackStackEntry;", "invoke", "(Landroidx/compose/animation/AnimatedVisibilityScope;Landroidx/navigation/NavBackStackEntry;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.google.accompanist.navigation.animation.ComposableSingletons$AnimatedComposeNavigatorKt$lambda-1$1  reason: invalid class name */
public final class ComposableSingletons$AnimatedComposeNavigatorKt$lambda1$1 extends Lambda implements Function4<AnimatedVisibilityScope, NavBackStackEntry, Composer, Integer, Unit> {
    public static final ComposableSingletons$AnimatedComposeNavigatorKt$lambda1$1 INSTANCE = new ComposableSingletons$AnimatedComposeNavigatorKt$lambda1$1();

    public ComposableSingletons$AnimatedComposeNavigatorKt$lambda1$1() {
        super(4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((AnimatedVisibilityScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull AnimatedVisibilityScope animatedVisibilityScope, @NotNull NavBackStackEntry navBackStackEntry, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$$receiver");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2143581737, i11, -1, "com.google.accompanist.navigation.animation.ComposableSingletons$AnimatedComposeNavigatorKt.lambda-1.<anonymous> (AnimatedComposeNavigator.kt:53)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
