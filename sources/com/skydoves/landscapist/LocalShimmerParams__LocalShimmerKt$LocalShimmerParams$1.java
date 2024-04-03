package com.skydoves.landscapist;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/skydoves/landscapist/ShimmerParams;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class LocalShimmerParams__LocalShimmerKt$LocalShimmerParams$1 extends Lambda implements Function0<ShimmerParams> {
    public static final LocalShimmerParams__LocalShimmerKt$LocalShimmerParams$1 INSTANCE = new LocalShimmerParams__LocalShimmerKt$LocalShimmerParams$1();

    public LocalShimmerParams__LocalShimmerKt$LocalShimmerParams$1() {
        super(0);
    }

    @NotNull
    public final ShimmerParams invoke() {
        return LocalShimmerProvider.INSTANCE.defaultShimmerParams();
    }
}
