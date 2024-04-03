package com.skydoves.landscapist;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/skydoves/landscapist/LocalShimmerProvider;", "", "()V", "defaultShimmerParams", "Lcom/skydoves/landscapist/ShimmerParams;", "landscapist_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LocalShimmerProvider {
    @NotNull
    public static final LocalShimmerProvider INSTANCE = new LocalShimmerProvider();

    private LocalShimmerProvider() {
    }

    @NotNull
    public final ShimmerParams defaultShimmerParams() {
        Color.Companion companion = Color.Companion;
        return new ShimmerParams(companion.m2948getDarkGray0d7_KjU(), companion.m2951getLightGray0d7_KjU(), 0.0f, 0.0f, 0.0f, 0, 60, (DefaultConstructorMarker) null);
    }
}
