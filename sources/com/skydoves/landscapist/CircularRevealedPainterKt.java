package com.skydoves.landscapist;

import androidx.compose.ui.graphics.Paint;
import androidx.core.util.Pools;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0003"}, d2 = {"paintPool", "Landroidx/core/util/Pools$SimplePool;", "Landroidx/compose/ui/graphics/Paint;", "landscapist_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class CircularRevealedPainterKt {
    /* access modifiers changed from: private */
    @NotNull
    public static final Pools.SimplePool<Paint> paintPool = new Pools.SimplePool<>(2);
}
