package com.skydoves.landscapist;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.skydoves.landscapist.ImageLoad__ImageLoadKt$ImageLoad$1", f = "ImageLoad.kt", i = {}, l = {57, 78}, m = "invokeSuspend", n = {}, s = {})
public final class ImageLoad__ImageLoadKt$ImageLoad$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f52947h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super Flow<? extends ImageLoadState>>, Object> f52948i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableState<ImageLoadState> f52949j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageLoad__ImageLoadKt$ImageLoad$1(Function1<? super Continuation<? super Flow<? extends ImageLoadState>>, ? extends Object> function1, MutableState<ImageLoadState> mutableState, Continuation<? super ImageLoad__ImageLoadKt$ImageLoad$1> continuation) {
        super(2, continuation);
        this.f52948i = function1;
        this.f52949j = mutableState;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ImageLoad__ImageLoadKt$ImageLoad$1(this.f52948i, this.f52949j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ImageLoad__ImageLoadKt$ImageLoad$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f52947h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Continuation<? super Flow<? extends ImageLoadState>>, Object> function1 = this.f52948i;
            this.f52947h = 1;
            obj = ImageLoad__ImageLoadKt.executeImageLoading$ImageLoad__ImageLoadKt(function1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ImageLoad__ImageLoadKt$ImageLoad$1$invokeSuspend$$inlined$collect$1 imageLoad__ImageLoadKt$ImageLoad$1$invokeSuspend$$inlined$collect$1 = new ImageLoad__ImageLoadKt$ImageLoad$1$invokeSuspend$$inlined$collect$1(this.f52949j);
        this.f52947h = 2;
        if (((Flow) obj).collect(imageLoad__ImageLoadKt$ImageLoad$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
