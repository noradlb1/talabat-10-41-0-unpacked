package com.designsystem.ds_progressive_offer;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ProgressiveOfferComposablesKt$ProgressiveOfferSurface$time$2$1 extends Lambda implements Function0<MutableState<Long>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f32541g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressiveOfferComposablesKt$ProgressiveOfferSurface$time$2$1(long j11) {
        super(0);
        this.f32541g = j11;
    }

    @NotNull
    public final MutableState<Long> invoke() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Long.valueOf(this.f32541g), (SnapshotMutationPolicy) null, 2, (Object) null);
    }
}
