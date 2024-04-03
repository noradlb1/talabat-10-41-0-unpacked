package com.skydoves.landscapist;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotMutationPolicy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"LocalShimmerParams", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lcom/skydoves/landscapist/ShimmerParams;", "getLocalShimmerParams", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "landscapist_release"}, k = 5, mv = {1, 5, 1}, xi = 48, xs = "com/skydoves/landscapist/LocalShimmerParams")
final /* synthetic */ class LocalShimmerParams__LocalShimmerKt {
    @NotNull
    private static final ProvidableCompositionLocal<ShimmerParams> LocalShimmerParams = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, LocalShimmerParams__LocalShimmerKt$LocalShimmerParams$1.INSTANCE, 1, (Object) null);

    @NotNull
    public static final ProvidableCompositionLocal<ShimmerParams> getLocalShimmerParams() {
        return LocalShimmerParams;
    }
}
