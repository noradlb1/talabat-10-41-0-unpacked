package com.skydoves.landscapist;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ImageLoad__ImageLoadKt$ImageLoad$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<ImageLoadState> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MutableState f52946b;

    public ImageLoad__ImageLoadKt$ImageLoad$1$invokeSuspend$$inlined$collect$1(MutableState mutableState) {
        this.f52946b = mutableState;
    }

    @Nullable
    public Object emit(ImageLoadState imageLoadState, @NotNull Continuation<? super Unit> continuation) {
        ImageLoad__ImageLoadKt.m9396ImageLoad$lambda2$ImageLoad__ImageLoadKt(this.f52946b, imageLoadState);
        return Unit.INSTANCE;
    }
}
