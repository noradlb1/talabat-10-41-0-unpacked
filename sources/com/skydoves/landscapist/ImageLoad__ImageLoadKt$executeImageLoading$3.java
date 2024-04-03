package com.skydoves.landscapist;

import com.skydoves.landscapist.ImageLoadState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/skydoves/landscapist/ImageLoadState;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.skydoves.landscapist.ImageLoad__ImageLoadKt$executeImageLoading$3", f = "ImageLoad.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
public final class ImageLoad__ImageLoadKt$executeImageLoading$3 extends SuspendLambda implements Function3<FlowCollector<? super ImageLoadState>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f52961h;

    public ImageLoad__ImageLoadKt$executeImageLoading$3(Continuation<? super ImageLoad__ImageLoadKt$executeImageLoading$3> continuation) {
        super(3, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super ImageLoadState> flowCollector, @NotNull Throwable th2, @Nullable Continuation<? super Unit> continuation) {
        ImageLoad__ImageLoadKt$executeImageLoading$3 imageLoad__ImageLoadKt$executeImageLoading$3 = new ImageLoad__ImageLoadKt$executeImageLoading$3(continuation);
        imageLoad__ImageLoadKt$executeImageLoading$3.L$0 = flowCollector;
        return imageLoad__ImageLoadKt$executeImageLoading$3.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f52961h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            ImageLoadState.Failure failure = new ImageLoadState.Failure((Object) null);
            this.f52961h = 1;
            if (((FlowCollector) this.L$0).emit(failure, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
