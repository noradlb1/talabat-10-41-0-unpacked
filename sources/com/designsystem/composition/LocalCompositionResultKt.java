package com.designsystem.composition;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotMutationPolicy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0019\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"LocalLottieCompositionState", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lcom/designsystem/composition/LottieCompositionState;", "getLocalLottieCompositionState", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class LocalCompositionResultKt {
    @NotNull
    private static final ProvidableCompositionLocal<LottieCompositionState> LocalLottieCompositionState = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, LocalCompositionResultKt$LocalLottieCompositionState$1.INSTANCE, 1, (Object) null);

    @NotNull
    public static final ProvidableCompositionLocal<LottieCompositionState> getLocalLottieCompositionState() {
        return LocalLottieCompositionState;
    }
}
