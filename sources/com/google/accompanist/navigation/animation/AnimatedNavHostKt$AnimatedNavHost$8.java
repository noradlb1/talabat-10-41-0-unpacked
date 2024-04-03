package com.google.accompanist.navigation.animation;

import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AnimatedNavHostKt$AnimatedNavHost$8 extends Lambda implements Function1<NavBackStackEntry, Object> {
    public static final AnimatedNavHostKt$AnimatedNavHost$8 INSTANCE = new AnimatedNavHostKt$AnimatedNavHost$8();

    public AnimatedNavHostKt$AnimatedNavHost$8() {
        super(1);
    }

    @Nullable
    public final Object invoke(@NotNull NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
        return navBackStackEntry.getId();
    }
}
