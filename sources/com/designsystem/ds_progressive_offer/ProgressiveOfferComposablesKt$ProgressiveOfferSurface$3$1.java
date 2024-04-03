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
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$ProgressiveOfferSurface$3$1", f = "ProgressiveOfferComposables.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
public final class ProgressiveOfferComposablesKt$ProgressiveOfferSurface$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f32522h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f32523i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f32524j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableState<Boolean> f32525k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ MutableState<Float> f32526l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutableState<String> f32527m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ MutableState<String> f32528n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressiveOfferComposablesKt$ProgressiveOfferSurface$3$1(String str, String str2, MutableState<Boolean> mutableState, MutableState<Float> mutableState2, MutableState<String> mutableState3, MutableState<String> mutableState4, Continuation<? super ProgressiveOfferComposablesKt$ProgressiveOfferSurface$3$1> continuation) {
        super(2, continuation);
        this.f32523i = str;
        this.f32524j = str2;
        this.f32525k = mutableState;
        this.f32526l = mutableState2;
        this.f32527m = mutableState3;
        this.f32528n = mutableState4;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ProgressiveOfferComposablesKt$ProgressiveOfferSurface$3$1(this.f32523i, this.f32524j, this.f32525k, this.f32526l, this.f32527m, this.f32528n, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ProgressiveOfferComposablesKt$ProgressiveOfferSurface$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f32522h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            if (ProgressiveOfferComposablesKt.m8524ProgressiveOfferSurface$lambda13(this.f32525k)) {
                ProgressiveOfferComposablesKt.m8525ProgressiveOfferSurface$lambda14(this.f32525k, false);
                return Unit.INSTANCE;
            }
            ProgressiveOfferComposablesKt.m8527ProgressiveOfferSurface$lambda17(this.f32526l, 0.0f);
            this.f32522h = 1;
            if (DelayKt.delay(150, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ProgressiveOfferComposablesKt.m8529ProgressiveOfferSurface$lambda20(this.f32527m, this.f32523i);
        ProgressiveOfferComposablesKt.m8531ProgressiveOfferSurface$lambda23(this.f32528n, this.f32524j);
        ProgressiveOfferComposablesKt.m8527ProgressiveOfferSurface$lambda17(this.f32526l, 1.0f);
        return Unit.INSTANCE;
    }
}
