package com.designsystem.ds_progressive_offer;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$OfferProgress$1$1", f = "ProgressiveOfferComposables.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ProgressiveOfferComposablesKt$OfferProgress$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f32497h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f32498i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableState<Float> f32499j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressiveOfferComposablesKt$OfferProgress$1$1(float f11, MutableState<Float> mutableState, Continuation<? super ProgressiveOfferComposablesKt$OfferProgress$1$1> continuation) {
        super(2, continuation);
        this.f32498i = f11;
        this.f32499j = mutableState;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ProgressiveOfferComposablesKt$OfferProgress$1$1(this.f32498i, this.f32499j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ProgressiveOfferComposablesKt$OfferProgress$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f32497h == 0) {
            ResultKt.throwOnFailure(obj);
            ProgressiveOfferComposablesKt.m8518OfferProgress$lambda42(this.f32499j, this.f32498i);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
